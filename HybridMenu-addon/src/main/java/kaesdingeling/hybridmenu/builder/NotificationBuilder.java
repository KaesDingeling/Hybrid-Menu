package kaesdingeling.hybridmenu.builder;

import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.server.Resource;
import com.vaadin.ui.Component;

import kaesdingeling.hybridmenu.components.NotificationCenter;
import kaesdingeling.hybridmenu.data.Notification;
import kaesdingeling.hybridmenu.data.enums.ENotificationPriority;
import kaesdingeling.hybridmenu.data.listeners.INotificationClickListener;

public class NotificationBuilder {
	private Notification notification = null;
	
	public static NotificationBuilder get(NotificationCenter notificationCenter) {
		return new NotificationBuilder(new Notification(notificationCenter));
	}
	public NotificationBuilder(Notification notification) {
		this.notification = notification;
	}
	public NotificationBuilder withCaption(String caption) {
		notification.setCaption(caption);
		return this;
	}
	public NotificationBuilder withDescription(String description) {
		notification.setDescription(description);
		return this;
	}
	public NotificationBuilder withIcon(Resource icon) {
		notification.setIcon(icon);
		return this;
	}
	public NotificationBuilder withLayoutClickListener(INotificationClickListener listener) {
		notification.addLayoutClickListener(new LayoutClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void layoutClick(LayoutClickEvent event) {
				listener.click(event, notification);
			}
		});
		return this;
	}
	public NotificationBuilder withComponents(Component... components) {
		notification.addComponents(components);
		return this;
	}
	public NotificationBuilder withCloseByHide() {
		notification.withCloseByHide();
		return this;
	}
	public NotificationBuilder withPriority(ENotificationPriority priority) {
		notification.setPriority(priority);
		return this;
	}
	public NotificationBuilder withCloseButton() {
		notification.setCloseButton();
		return this;
	}
	public Notification build() {
		notification.update();
		return notification;
	}
}