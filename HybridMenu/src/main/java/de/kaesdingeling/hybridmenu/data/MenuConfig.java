package de.kaesdingeling.hybridmenu.data;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcons;

import de.kaesdingeling.hybridmenu.data.enums.NotificationPosition;
import de.kaesdingeling.hybridmenu.design.DesignItem;

public class MenuConfig {
	public static MenuConfig get() {
		return new MenuConfig();
	}
	
	private DesignItem designItem = DesignItem.getDarkDesign();
	
	private VaadinIcons subMenuIcon = VaadinIcons.ANGLE_UP;
	
	private VaadinIcons notificationButtonIcon = VaadinIcons.BELL;
	private VaadinIcons notificationButtonEmptyIcon = VaadinIcons.BELL_O;
	private VaadinIcons notificationCenterCloseIcon = VaadinIcons.ANGLE_RIGHT;
	private VaadinIcons notificationRemoveIcon = VaadinIcons.CLOSE;
	
	private NotificationPosition notificationPosition = NotificationPosition.BOTTOM;
	
	private long notificationDisplayTime = 5000;
	
	private VaadinIcons breadcrumbSeperatorIcon = VaadinIcons.ANGLE_RIGHT;
	private boolean breadcrumbs = true;
	
	public static int notificationQueueMax = 200;
	
	public DesignItem getDesignItem() {
		return designItem;
	}
	public MenuConfig withDesignItem(DesignItem designItem) {
		this.designItem = designItem;
		return this;
	}
	public Icon getSubMenuIcon() {
		return subMenuIcon.create();
	}
	public MenuConfig withSubMenuIcon(VaadinIcons subMenuIcon) {
		this.subMenuIcon = subMenuIcon;
		return this;
	}
	public Icon getNotificationButtonIcon() {
		return notificationButtonIcon.create();
	}
	public MenuConfig withNotificationButtonIcon(VaadinIcons notificationButtonIcon) {
		this.notificationButtonIcon = notificationButtonIcon;
		return this;
	}
	public Icon getNotificationButtonEmptyIcon() {
		return notificationButtonEmptyIcon.create();
	}
	public MenuConfig withNotificationButtonEmptyIcon(VaadinIcons notificationButtonEmptyIcon) {
		this.notificationButtonEmptyIcon = notificationButtonEmptyIcon;
		return this;
	}
	public Icon getNotificationCenterCloseIcon() {
		return notificationCenterCloseIcon.create();
	}
	public MenuConfig withNotificationCenterCloseIcon(VaadinIcons notificationCenterCloseIcon) {
		this.notificationCenterCloseIcon = notificationCenterCloseIcon;
		return this;
	}
	public Icon getNotificationRemoveIcon() {
		return notificationRemoveIcon.create();
	}
	public MenuConfig withNotificationRemoveIcon(VaadinIcons notificationRemoveIcon) {
		this.notificationRemoveIcon = notificationRemoveIcon;
		return this;
	}
	public NotificationPosition getNotificationPosition() {
		return notificationPosition;
	}
	public MenuConfig setNotificationPosition(NotificationPosition notificationPosition) {
		this.notificationPosition = notificationPosition;
		return this;
	}
	public VaadinIcons getBreadcrumbSeperatorIcon() {
		return breadcrumbSeperatorIcon;
	}
	public MenuConfig withBreadcrumbSeperatorIcon(VaadinIcons breadcrumbSeperatorIcon) {
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
	public long getNotificationDisplayTime() {
		return notificationDisplayTime;
	}
	public MenuConfig setNotificationDisplayTime(long notificationDisplayTime) {
		this.notificationDisplayTime = notificationDisplayTime;
		return this;
	}
}