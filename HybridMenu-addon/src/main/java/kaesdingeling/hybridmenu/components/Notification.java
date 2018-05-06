package kaesdingeling.hybridmenu.components;

import java.util.Date;

import org.ocpsoft.prettytime.PrettyTime;

import com.vaadin.server.Resource;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;

import kaesdingeling.hybridmenu.data.MenuConfig;

public class Notification extends CssLayout {
	private static final long serialVersionUID = 3572068667525046443L;
	
	private MenuConfig menuConfig = VaadinSession.getCurrent().getAttribute(MenuConfig.class);
	
	private String caption = "";
	
	private Label title = new Label("", ContentMode.HTML);
	private Label content = new Label("", ContentMode.HTML);
	private Button removeButton = null;
	
	private long created = 0L;
	private long removeDisplayOffset = 0L;
	private long displayTime = menuConfig.getNotificationDisplayTime();
	
	private boolean readed = false;
	
	public static Notification get() {
		return new Notification();
	}
	
	public Notification() {
		created = System.currentTimeMillis();
	}
	
	public Notification withCloseable() {
		removeButton = new Button(menuConfig.getNotificationRemoveIcon());
		removeButton.setPrimaryStyleName("button");
		return this;
	}
	
	public Notification withDisplayTime(long displayTime) {
		if (removeDisplayOffset == this.displayTime) {
			removeDisplayOffset = displayTime;
		}
		this.displayTime = displayTime;
		return this;
	}
	
	public long getDisplayTime() {
		return displayTime;
	}
	
	public Notification withAutoRemove() {
		this.removeDisplayOffset = displayTime;
		return this;
	}
	
	public Notification withAutoRemove(long removeDisplayOffset) {
		this.removeDisplayOffset = removeDisplayOffset;
		return this;
	}
	
	public Notification withTitle(String title) {
		this.caption = title;
		return this;
	}
	
	public Notification withContent(String content) {
		this.content.setValue(content);
		return this;
	}
	
	public Notification withIcon(Resource icon) {
		title.setIcon(icon);
		return this;
	}
	
	public boolean isReaded() {
		return readed;
	}
	
	public Notification makeAsReaded() {
		readed = true;
		addStyleName("readed");
		return this;
	}
	
	public Notification build(NotificationCenter notificationCenter) {
		setStyleName("notification");
		addComponents(title, content);
		
		content.setPrimaryStyleName("content");
		
		if (removeButton != null) {
			removeButton.addClickListener(e -> notificationCenter.remove(this));
			addComponent(removeButton);
		}
		
		if (title.getIcon() != null) {
			addStyleName("withIcon");
		}
		
		title.setPrimaryStyleName("title");
		title.setValue(caption + "<p class=\"timeAgo\">" + new PrettyTime(notificationCenter.getUI().getLocale()).format(new Date(created)) + "</p>");
		
		if (removeDisplayOffset > 0L) {
			NotificationCenter.runOneAttached(this, () -> notificationCenter.remove(this), removeDisplayOffset);
		}
		return this;
	}
	
	public void update(NotificationCenter notificationCenter) {
		title.setValue(caption + "<p class=\"timeAgo\">" + new PrettyTime(notificationCenter.getUI().getLocale()).format(new Date(created)) + "</p>");
	}
	
	@Override
	public Notification clone() {
		Notification notification = new Notification();
		notification.withAutoRemove(removeDisplayOffset);
		notification.withContent(content.getValue());
		notification.withTitle(title.getValue());
		notification.withDisplayTime(displayTime);
		notification.withIcon(title.getIcon());
		notification.created = created;
		notification.caption = caption;
		return notification;
	}
}