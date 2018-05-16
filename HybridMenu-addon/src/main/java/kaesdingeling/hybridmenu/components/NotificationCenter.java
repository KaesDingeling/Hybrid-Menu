package kaesdingeling.hybridmenu.components;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.Position;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import kaesdingeling.hybridmenu.data.MenuConfig;
import kaesdingeling.hybridmenu.data.enums.NotificationPosition;
import kaesdingeling.hybridmenu.data.interfaces.MenuComponent;

@SuppressWarnings("deprecation")
public class NotificationCenter extends VerticalLayout {
	private static final long serialVersionUID = 4526129172208540022L;
	
	public static final String CLASS_NAME = "notificationCenter";
	
	public UI ui = UI.getCurrent();
	
	private VerticalLayout content = new VerticalLayout();
	private HorizontalLayout footer = new HorizontalLayout();
	private CssLayout lastNotification = new CssLayout();
	
	private ArrayBlockingQueue<Notification> notificationQueue = new ArrayBlockingQueue<Notification>(MenuConfig.notificationQueueMax);
	
	private HMButton notiButton = null;
	
	public ExecutorService exe = Executors.newSingleThreadExecutor();
	
	public NotificationCenter() {
		super();
		setHeight(100, Unit.PERCENTAGE);
		setWidth(0, Unit.PIXELS);
		setStyleName(CLASS_NAME);
		setMargin(false);
		setSpacing(false);
		
		exe.execute(() -> {
			try {
				boolean initBoot = false;
				while (this.getUI() != null && this.getUI().isAttached() || !initBoot) {
					initBoot = true;
					
					TimeUnit.SECONDS.sleep(1);
					
					Notification noti = notificationQueue.take();
					
					noti.build(this);
					
					ui.access(() -> {
						lastNotification.removeAllComponents();
						lastNotification.addComponent(noti);
						lastNotification.addStyleName("show");
						
						runOneAttached(noti, () -> {
							lastNotification.removeStyleName("show");
						}, noti.getDisplayTime());
					});
					
					TimeUnit.MILLISECONDS.sleep(noti.getDisplayTime());
				}
			} catch (Exception e) {
				com.vaadin.ui.Notification vaadinNotification = new com.vaadin.ui.Notification("Notification of the NotificationCenter is no longer possible!", Type.WARNING_MESSAGE);
				vaadinNotification.setPosition(Position.BOTTOM_RIGHT);
				vaadinNotification.setDescription("Error: " + e.getMessage());
				vaadinNotification.show(ui.getPage());
				e.printStackTrace();
			}
		});
		
		footer.setSpacing(true);
		footer.setMargin(false);
		footer.setStyleName("footer");
		
		content.setSpacing(false);
		content.setMargin(false);
		content.setStyleName("content");
		
		lastNotification.setHeight(0, Unit.PIXELS);
		lastNotification.setStyleName("lastNotification");
		
		addComponents(content, footer, lastNotification);
		setExpandRatio(content, 1);
		
		VaadinSession.getCurrent().setAttribute(NotificationCenter.class, this);
		
		addFooter(HMButton.get().withIcon(FontAwesome.ANGLE_RIGHT).withClickListener(e -> close()));
	}
	
	public NotificationCenter setNotificationPosition(NotificationPosition notificationPosition) {
		if (notificationPosition.equals(NotificationPosition.TOP) && !lastNotification.getStyleName().contains("top")) {
			lastNotification.addStyleName("top");
		} else {
			lastNotification.removeStyleName("top");
		}
		return this;
	}
	
	public <C extends MenuComponent<?>> C addFooter(C c) {
		c.setPrimaryStyleName(c.getClass().getSimpleName());
		footer.addComponentAsFirst(c);
		return c;
	}
	
	public <C extends MenuComponent<?>> NotificationCenter removeFooter(C c) {
		footer.removeComponent(c);
		return this;
	}
	
	public boolean add(Notification notification) {
		return add(notification, true);
	}
	
	public boolean add(Notification notification, boolean showDescriptionOnPopup) {
		if (isOpen()) {
			notification.makeAsReaded();
		}
		content.addComponentAsFirst(notification.build(this));
		updateToolTip();
		
		Notification notificationClone = notification.clone();
		
		if (!showDescriptionOnPopup) {
			notificationClone.setDescription("");
		}
		
		return notificationQueue.add(notificationClone);
	}
	
	public NotificationCenter remove(Notification notification) {
		content.removeComponent(notification);
		return this;
	}
	
	public List<Notification> getAll() {
		List<Notification> notificationsList = new ArrayList<Notification>();
		for (int i = 0; i < content.getComponentCount(); i++) {
			Component component = content.getComponent(i);
			if (component instanceof Notification) {
				notificationsList.add((Notification) component);
			}
		}
		return notificationsList;
	}
	
	public NotificationCenter open() {
		addStyleName("open");
		getAll().forEach(e -> {
			e.update(this);
			e.makeAsReaded();
		});
		updateToolTip();
		return this;
	}
	
	public NotificationCenter close() {
		removeStyleName("open");
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
		return getStyleName().contains("open");
	}
	
	public NotificationCenter updateToolTip() {
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
		return this;
	}
	
	public NotificationCenter setNotiButton(HMButton notiButton) {
		this.notiButton = notiButton;
		this.notiButton.addClickListener(e -> toggle());
		updateToolTip();
		return this;
	}
	
	public static Thread runWhileAttached(final Component component, final Runnable task, final long initSleep, final long sleep) {
		return initThread(() -> {
            try {
                Thread.sleep(initSleep);
                while (component.getUI() != null && component.getUI().isAttached()) {
                    Future<Void> future = component.getUI().access(task);
                    future.get();
                    Thread.sleep(sleep);
                }
            } catch (Exception e) {
			}
        });
	}
	
	public static Thread runOneAttached(final Component component, final Runnable task, final long initSleep) {
        return initThread(() -> {
        	 try {
                 Thread.sleep(initSleep);
                 if (component.getUI() != null && component.getUI().isAttached()) {
                     Future<Void> future = component.getUI().access(task);
                     future.get();
                 }
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