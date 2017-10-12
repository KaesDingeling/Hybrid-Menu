package kaesdingeling.hybridmenu.data.top;

import com.vaadin.server.Resource;
import com.vaadin.ui.HorizontalLayout;

public class MenuNotification {
	private Resource icon;
	private String title;
	private String description;
	private NotificationCenter notificationCenter;
	private HorizontalLayout messageLayout;
	private boolean isReaded;
	private long created;
	
	public MenuNotification(String title) {
		this.title = title;
	}
	public Resource getIcon() {
		return icon;
	}
	public void setIcon(Resource icon) {
		this.icon = icon;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public NotificationCenter getNotificationCenter() {
		return notificationCenter;
	}
	public void setNotificationCenter(NotificationCenter notificationCenter) {
		this.notificationCenter = notificationCenter;
	}
	public void setMessageLayout(HorizontalLayout messageLayout) {
		this.messageLayout = messageLayout;
	}
	public long getCreated() {
		return created;
	}
	public boolean isReaded() {
		return isReaded;
	}
	public void setReaded(boolean isReaded) {
		this.isReaded = isReaded;
	}
	public void add() {
		if (notificationCenter != null) {
			created = System.currentTimeMillis();
			notificationCenter.add(this);
		}
	}
	public void remove() {
		if (notificationCenter != null) {
			notificationCenter.remove(this);
		}
	}
	public HorizontalLayout get() {
		return messageLayout;
	}
}