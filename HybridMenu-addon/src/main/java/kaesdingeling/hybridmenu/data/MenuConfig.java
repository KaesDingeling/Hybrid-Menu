package kaesdingeling.hybridmenu.data;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.FontIcon;
import com.vaadin.server.Resource;

import kaesdingeling.hybridmenu.data.enums.NotificationPosition;
import kaesdingeling.hybridmenu.design.DesignItem;

@SuppressWarnings("deprecation")
public class MenuConfig {
	public static MenuConfig get() {
		return new MenuConfig();
	}
	
	private DesignItem designItem = DesignItem.getDarkDesign();
	
	private FontIcon subMenuIcon = FontAwesome.ANGLE_UP;
	
	private Resource notificationButtonIcon = FontAwesome.BELL;
	private Resource notificationButtonEmptyIcon = FontAwesome.BELL_O;
	private Resource notificationCenterCloseIcon = FontAwesome.ANGLE_RIGHT;
	private Resource notificationRemoveIcon = FontAwesome.TIMES;
	
	private NotificationPosition notificationPopupPosition = NotificationPosition.BOTTOM;
	private NotificationPosition notificationButtonLinePosition = NotificationPosition.BOTTOM;
	
	private long notificationDisplayTime = 5000;
	
	private int notificationPopupMaxContentLength = 100;
	
	private Resource breadcrumbSeperatorIcon = FontAwesome.ANGLE_RIGHT;
	private boolean breadcrumbs = true;
	
	public static int notificationQueueMax = 200;
	
	public DesignItem getDesignItem() {
		return designItem;
	}
	public MenuConfig withDesignItem(DesignItem designItem) {
		this.designItem = designItem;
		return this;
	}
	public FontIcon getSubMenuIcon() {
		return subMenuIcon;
	}
	public MenuConfig withSubMenuIcon(FontIcon subMenuIcon) {
		this.subMenuIcon = subMenuIcon;
		return this;
	}
	public Resource getNotificationButtonIcon() {
		return notificationButtonIcon;
	}
	public MenuConfig withNotificationButtonIcon(Resource notificationButtonIcon) {
		this.notificationButtonIcon = notificationButtonIcon;
		return this;
	}
	public Resource getNotificationButtonEmptyIcon() {
		return notificationButtonEmptyIcon;
	}
	public MenuConfig withNotificationButtonEmptyIcon(Resource notificationButtonEmptyIcon) {
		this.notificationButtonEmptyIcon = notificationButtonEmptyIcon;
		return this;
	}
	public Resource getNotificationCenterCloseIcon() {
		return notificationCenterCloseIcon;
	}
	public MenuConfig withNotificationCenterCloseIcon(Resource notificationCenterCloseIcon) {
		this.notificationCenterCloseIcon = notificationCenterCloseIcon;
		return this;
	}
	public Resource getNotificationRemoveIcon() {
		return notificationRemoveIcon;
	}
	public MenuConfig withNotificationRemoveIcon(Resource notificationRemoveIcon) {
		this.notificationRemoveIcon = notificationRemoveIcon;
		return this;
	}
	public NotificationPosition getNotificationPopupPosition() {
		return notificationPopupPosition;
	}
	public MenuConfig setNotificationPopupPosition(NotificationPosition notificationPopupPosition) {
		this.notificationPopupPosition = notificationPopupPosition;
		return this;
	}
	public NotificationPosition getNotificationButtonLinePosition() {
		return notificationButtonLinePosition;
	}
	public MenuConfig setNotificationButtonLinePosition(NotificationPosition notificationButtonLinePosition) {
		this.notificationButtonLinePosition = notificationButtonLinePosition;
		return this;
	}
	public long getNotificationDisplayTime() {
		return notificationDisplayTime;
	}
	public MenuConfig setNotificationDisplayTime(long notificationDisplayTime) {
		this.notificationDisplayTime = notificationDisplayTime;
		return this;
	}
	public int getNotificationPopupMaxContentLength() {
		return notificationPopupMaxContentLength;
	}
	public MenuConfig setNotificationPopupMaxContentLength(int notificationPopupMaxContentLength) {
		this.notificationPopupMaxContentLength = notificationPopupMaxContentLength;
		return this;
	}
	public Resource getBreadcrumbSeperatorIcon() {
		return breadcrumbSeperatorIcon;
	}
	public MenuConfig withBreadcrumbSeperatorIcon(Resource breadcrumbSeperatorIcon) {
		this.breadcrumbSeperatorIcon = breadcrumbSeperatorIcon;
		return this;
	}
	public boolean isBreadcrumbs() {
		return breadcrumbs;
	}
	public MenuConfig withBreadcrumbs(boolean breadcrumbs) {
		this.breadcrumbs = breadcrumbs;
		return this;
	}
}