package kaesdingeling.hybridmenu.data;

import java.util.Date;

import org.ocpsoft.prettytime.PrettyTime;

import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Resource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;

import kaesdingeling.hybridmenu.components.NotificationCenter;
import kaesdingeling.hybridmenu.data.enums.ENotificationPriority;
import kaesdingeling.hybridmenu.utils.STYLES;

public class Notification {
	private CssLayout content = new CssLayout();
	private Label contentLabel = new Label();
	private Button closeButton = null;
	
	private NotificationCenter notificationCenter = null;
	private ENotificationPriority priority = null;
	private boolean isReaded = false;
	private String caption = "";
	private long created = 0;
	private long lastOpen = 0;
	
	public Notification(NotificationCenter notificationCenter) {
		this.notificationCenter = notificationCenter;
		contentLabel.setCaptionAsHtml(true);
		content.addComponent(contentLabel);
		content.setStyleName(STYLES.notificationItem);
	}
	public void setIcon(Resource icon) {
		content.setIcon(icon);
		if (icon != null && !content.getStyleName().contains(STYLES.notificationItemWithIcon)) {
			content.addStyleName(STYLES.notificationItemWithIcon);
		} else if (content.getStyleName().contains(STYLES.notificationItemWithIcon)) {
			content.removeStyleName(STYLES.notificationItemWithIcon);
		}
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public void setDescription(String caption) {
		contentLabel.setValue(caption);
	}
	public void addLayoutClickListener(LayoutClickListener listener) {
		content.addLayoutClickListener(listener);
	}
	public void addComponents(Component... components) {
		content.addComponents(components);
	}
	public CssLayout getContent() {
		return content;
	}
	public Label getContentLabel() {
		return contentLabel;
	}
	public boolean isReaded() {
		return isReaded;
	}
	public void setCloseButton() {
		closeButton = new Button();
		closeButton.setIcon(VaadinIcons.CLOSE);
		closeButton.setPrimaryStyleName(STYLES.notificationItemCloseButton);
		closeButton.addClickListener(e -> notificationCenter.remove(this));
		content.addComponent(closeButton);
	}
	public void makeAsReaded() {
		isReaded = true;
	}
	public void makeAsUnReaded() {
		isReaded = false;
	}
	public long getCreated() {
		return created;
	}
	public void setPriority(ENotificationPriority priority) {
		this.priority = priority;
		update();
	}
	public ENotificationPriority getPriority() {
		if (priority == null) {
			priority = ENotificationPriority.MEDIUM;
		}
		return priority;
	}
	public NotificationCenter getNotificationCenter() {
		return notificationCenter;
	}
	public void update() {
		if (!toRemove()) {
			if (created == 0) {
				created = System.currentTimeMillis();
			}
			if (!getNotificationCenter().isShowAll() && isShow() && lastOpen <= System.currentTimeMillis()) {
				hide();
			}
			updateCaption();
			updatePriority();
			notificationCenter.add(this);
		}
	}
	public void show() {
		if (!isShow() && !toRemove()) {
			content.addStyleName(STYLES.notificationItemShow);
			lastOpen = System.currentTimeMillis() + 4500;
		}
	}
	public boolean isShow() {
		return content.getStyleName().contains(STYLES.notificationItemShow);
	}
	public void hide() {
		if (isShow()) {
			content.removeStyleName(STYLES.notificationItemShow);
		}
	}
	public void remove() {
		getNotificationCenter().remove(this);
	}
	public boolean toRemove() {
		return content.getStyleName().contains(STYLES.notificationItemRemove);
	}
	private void updateCaption() {
		contentLabel.setCaption(caption + "<p class=\"timeAgo\">" + new PrettyTime().format(new Date(created)) + "</p>");
	}
	private void updatePriority() {
		switch (getPriority()) {
			case LOW:
				content.addStyleName(STYLES.notificationPriorityLow);
				content.removeStyleName(STYLES.notificationPriorityMedium);
				content.removeStyleName(STYLES.notificationPriorityHigh);
				break;
			case MEDIUM:
				content.addStyleName(STYLES.notificationPriorityMedium);
				content.removeStyleName(STYLES.notificationPriorityLow);
				content.removeStyleName(STYLES.notificationPriorityHigh);
				break;
			case HIGH:
				content.addStyleName(STYLES.notificationPriorityHigh);
				content.removeStyleName(STYLES.notificationPriorityLow);
				content.removeStyleName(STYLES.notificationPriorityMedium);
				break;
			default:
				break;
		}
	}
}