package de.kaesdingeling.hybridmenu.components;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcons;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.Command;
import com.vaadin.flow.server.VaadinSession;

import de.kaesdingeling.hybridmenu.data.MenuConfig;
import de.kaesdingeling.hybridmenu.data.enums.NotificationPosition;
import de.kaesdingeling.hybridmenu.utils.Styles;

public class NotificationCenter extends VerticalLayout {
	private static final long serialVersionUID = 4526129172208540022L;
	
	public UI ui = UI.getCurrent();
	
	private VerticalLayout content = new VerticalLayout();
	private HorizontalLayout footer = new HorizontalLayout();
	private Div lastNotification = new Div();
	
	private ArrayBlockingQueue<Notification> notificationQueue = new ArrayBlockingQueue<Notification>(MenuConfig.notificationQueueMax);
	
	private HMButton notiButton = null;
	
	public ExecutorService exe = null;
	
	public NotificationCenter() {
		super();
		setHeight("100%");
		setWidth("0px");
		getClassNames().add(Styles.notificationCenter);
		setMargin(false);
		setPadding(false);
		setSpacing(false);
		
		footer.setSpacing(true);
		footer.setMargin(false);
		footer.getClassNames().add(Styles.footer);
		
		content.setSpacing(false);
		content.setMargin(false);
		content.setPadding(false);
		content.getClassNames().add(Styles.content);
		
		lastNotification.setHeight("0px");
		lastNotification.getClassNames().add(Styles.lastNotification);
		
		add(content, footer, lastNotification);
		expand(content);
		
		VaadinSession.getCurrent().setAttribute(NotificationCenter.class, this);
		
		addFooter(HMButton.get().withIcon(VaadinIcons.ANGLE_RIGHT.create()).withClickListener(e -> close()));
	}
	
	public NotificationCenter setNotificationPosition(NotificationPosition notificationPosition) {
		if (notificationPosition.equals(NotificationPosition.TOP) && !lastNotification.getClassNames().contains(Styles.top)) {
			lastNotification.getClassNames().add(Styles.top);
		} else {
			lastNotification.getClassNames().remove(Styles.top);
		}
		return this;
	}
	
	public <MenuComponent extends Component> MenuComponent addFooter(MenuComponent c) {
		footer.add(c);
		return c;
	}
	
	public <MenuComponent extends Component> NotificationCenter removeFooter(MenuComponent c) {
		footer.remove(c);
		return this;
	}
	
	public boolean add(Notification notification) {
		return add(notification, true);
	}
	
	public boolean add(Notification notification, boolean showDescriptionOnPopup) {
		if (isOpen()) {
			notification.makeAsReaded();
		}
		content.add(notification.build(this, ui));
		updateToolTip();
		
		Notification notificationClone = notification.clone();
		
		if (!showDescriptionOnPopup) {
			notificationClone.withContent("");
		}
		
		return addQueue(notificationClone);
	}
	
	private boolean addQueue(Notification notification) {
		if (exe == null) {
			exe = Executors.newSingleThreadExecutor();
			exe.execute(() -> {
				try {
					while (notificationQueue.size() > 0) {
						TimeUnit.SECONDS.sleep(1);
						
						Notification noti = notificationQueue.take().build(this, ui);
						
						ui.access(() -> {
							lastNotification.removeAll();
							lastNotification.add(noti);
							lastNotification.getClassNames().add(Styles.show);
							
							runOneAttached(noti, () -> {
								lastNotification.getClassNames().remove(Styles.show);
							}, noti.getDisplayTime());
						});
						
						TimeUnit.MILLISECONDS.sleep(noti.getDisplayTime());
					}
				} catch (Exception e) {
					
				}
				exe.shutdown();
				exe = null;
			});
		}
		
		return notificationQueue.add(notification);
	}
	
	public NotificationCenter remove(Notification notification) {
		content.remove(notification);
		updateToolTip();
		return this;
	}
	
	public int queueSize() {
		return notificationQueue.size();
	}
	
	public List<Notification> getAll() {
		List<Notification> notificationsList = new ArrayList<Notification>();
		for (int i = 0; i < content.getComponentCount(); i++) {
			Component component = content.getComponentAt(i);
			if (component instanceof Notification) {
				notificationsList.add((Notification) component);
			}
		}
		return notificationsList;
	}
	
	public NotificationCenter open() {
		getClassNames().add(Styles.open);
		getAll().forEach(e -> {
			e.update(ui);
			e.makeAsReaded();
		});
		updateToolTip();
		return this;
	}
	
	public NotificationCenter close() {
		getClassNames().remove(Styles.open);
		return this;
	}
	
	public NotificationCenter toggle() {
		if (isOpen()) {
			close();
		} else {
			open();
		}
		return this;
	}
	
	public boolean isOpen() {
		return getClassNames().contains(Styles.open);
	}
	
	public NotificationCenter updateToolTip() {
		if (notiButton != null) {
			int unreaded = 0;
			for (Notification notification : getAll()) {
				if (!notification.isReaded()) {
					unreaded++;
				}
			}
			notiButton.withToolTip(unreaded);
			if (unreaded > 0) {
				notiButton.setIcon(VaadinSession.getCurrent().getAttribute(MenuConfig.class).getNotificationButtonIcon());
			} else {
				notiButton.setIcon(VaadinSession.getCurrent().getAttribute(MenuConfig.class).getNotificationButtonEmptyIcon());
			}
		}
		return this;
	}
	
	public NotificationCenter setNotiButton(HMButton notiButton) {
		this.notiButton = notiButton;
		this.notiButton.addClickListener(e -> toggle());
		updateToolTip();
		return this;
	}
	
	public Thread runOneAttached(final Component component, final Command task, final long initSleep) {
        return initThread(() -> {
        	 try {
                 Thread.sleep(initSleep);
                 Future<Void> future = ui.access(task);
                 future.get();
             } catch (Exception e) {
             }
        });
	}
	
	public static Thread initThread(final Runnable task) {
		final Thread thread = new Thread(task);
		thread.start();
		return thread;
	}
}