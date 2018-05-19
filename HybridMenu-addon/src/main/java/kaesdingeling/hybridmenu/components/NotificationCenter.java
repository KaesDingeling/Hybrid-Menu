package kaesdingeling.hybridmenu.components;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcons;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.VaadinSession;

import kaesdingeling.hybridmenu.data.MenuConfig;
import kaesdingeling.hybridmenu.data.enums.NotificationPosition;
import kaesdingeling.hybridmenu.utils.Styles;

public class NotificationCenter extends VerticalLayout {
	private static final long serialVersionUID = 4526129172208540022L;
	
	public UI ui = UI.getCurrent();
	
	private VerticalLayout content = new VerticalLayout();
	private HorizontalLayout footer = new HorizontalLayout();
	private Div lastNotification = new Div();
	
	private ArrayBlockingQueue<Notification> notificationQueue = new ArrayBlockingQueue<Notification>(MenuConfig.notificationQueueMax);
	
	private HMButton notiButton = null;
	
	public ExecutorService exe = Executors.newSingleThreadExecutor();
	
	public NotificationCenter() {
		super();
		setHeight("100%");
		setWidth("0px");
		getClassNames().add(Styles.notificationCenter);
		setMargin(false);
		setPadding(false);
		setSpacing(false);
		
		exe.execute(() -> {
			try {
				boolean initBoot = false;
				while (this.getUI() != null && this.getUI().isPresent() || !initBoot) {
					initBoot = true;
					
					TimeUnit.SECONDS.sleep(1);
					
					Notification noti = notificationQueue.take();
					
					noti.build(this);
					
					/*
					ui.access(() -> {
						lastNotification.removeAllComponents();
						lastNotification.addComponent(noti);
						lastNotification.addStyleName("show");
						
						runOneAttached(noti, () -> {
							lastNotification.removeStyleName("show");
						}, noti.getDisplayTime());
					});
					*/
					
					TimeUnit.MILLISECONDS.sleep(noti.getDisplayTime());
				}
			} catch (Exception e) {
				/*
				com.vaadin.ui.Notification vaadinNotification = new com.vaadin.ui.Notification("Notification of the NotificationCenter is no longer possible!", Type.WARNING_MESSAGE);
				vaadinNotification.setPosition(Position.BOTTOM_RIGHT);
				vaadinNotification.setDescription("Error: " + e.getMessage());
				vaadinNotification.show(ui.getPage());
				*/
				e.printStackTrace();
			}
		});
		
		footer.setSpacing(true);
		footer.setMargin(false);
		footer.getClassNames().add(Styles.footer);
		
		content.setSpacing(false);
		content.setMargin(false);
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
		content.add(notification.build(this));
		updateToolTip();
		
		Notification notificationClone = notification.clone();
		
		if (!showDescriptionOnPopup) {
			//notificationClone.setDescription("");
		}
		
		return notificationQueue.add(notificationClone);
	}
	
	public NotificationCenter remove(Notification notification) {
		content.remove(notification);
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
			e.update(this);
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
	
	public static Thread initThread(final Runnable task) {
		final Thread thread = new Thread(task);
		thread.start();
		return thread;
	}
}