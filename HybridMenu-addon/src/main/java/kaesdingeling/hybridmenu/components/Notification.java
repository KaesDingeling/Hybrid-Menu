package kaesdingeling.hybridmenu.components;

import java.util.Date;

import org.ocpsoft.prettytime.PrettyTime;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcons;
import com.vaadin.flow.server.VaadinSession;

import kaesdingeling.hybridmenu.data.MenuConfig;

public class Notification extends Div {
	private static final long serialVersionUID = 3572068667525046443L;
	
	private MenuConfig menuConfig = VaadinSession.getCurrent().getAttribute(MenuConfig.class);
	
	private String caption = "";
	
	private Label title = new Label();
	private Label timeAgo = new Label();
	private Label content = new Label();
	private Button removeButton = null;
	
	private Icon icon = null;
	
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
		removeButton.getClassNames().add("button");
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
		this.title.setText(title);
		return this;
	}
	
	public Notification withContent(String content) {
		this.content.setText(content);
		return this;
	}
	
	public Notification withIcon(VaadinIcons icon) {
		return withIcon(icon.create());
	}
	
	public Notification withIcon(Icon icon) {
		this.icon = icon;
		return this;
	}
	
	public boolean isReaded() {
		return readed;
	}
	
	public Notification makeAsReaded() {
		readed = true;
		return this;
	}
	
	public Notification build(NotificationCenter notificationCenter) {
		if (icon != null) {
			add(icon);
		}
		
		getClassNames().add("notification");
		add(title, timeAgo, content);
		
		title.getClassNames().add("title");
		timeAgo.getClassNames().add("timeAgo");
		content.getClassNames().add("content");
		
		if (removeButton != null) {
			removeButton.addClickListener(e -> notificationCenter.remove(this));
			add(removeButton);
		}
		
		timeAgo.setText(new PrettyTime(notificationCenter.getUI().get().getLocale()).format(new Date(created)));
		
		if (removeDisplayOffset > 0L) {
			//NotificationCenter.runOneAttached(this, () -> notificationCenter.remove(this), removeDisplayOffset);
		}
		return this;
	}
	
	public void update(NotificationCenter notificationCenter) {
		//title.setValue(caption + "<p class=\"timeAgo\">" + new PrettyTime(notificationCenter.getUI().getLocale()).format(new Date(created)) + "</p>");
	}
	
	@Override
	public Notification clone() {
		Notification notification = new Notification();
		notification.withAutoRemove(removeDisplayOffset);
		//notification.withContent(content.getValue());
		//notification.withTitle(title.getValue());
		notification.withDisplayTime(displayTime);
		//notification.withIcon(title.getIcon());
		notification.created = created;
		notification.caption = caption;
		return notification;
	}
}