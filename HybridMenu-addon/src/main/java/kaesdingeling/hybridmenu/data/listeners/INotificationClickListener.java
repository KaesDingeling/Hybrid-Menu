package kaesdingeling.hybridmenu.data.listeners;

import java.io.Serializable;

import com.vaadin.event.LayoutEvents.LayoutClickEvent;

import kaesdingeling.hybridmenu.data.Notification;

@FunctionalInterface
public interface INotificationClickListener extends Serializable {
	public void click(LayoutClickEvent event, Notification notification);
}