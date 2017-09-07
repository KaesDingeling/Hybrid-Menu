package kaesdingeling.hybridmenu.data;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;

import kaesdingeling.hybridmenu.data.enums.EMenuAnimationSpeed;
import kaesdingeling.hybridmenu.data.enums.EMenuComponents;
import kaesdingeling.hybridmenu.data.enums.EMenuDesign;
import kaesdingeling.hybridmenu.data.enums.EMenuNotificationCenterSort;

@SuppressWarnings("deprecation")
public class MenuConfig {
	private EMenuComponents menuComponents = EMenuComponents.LEFT_WITH_TOP;
	private EMenuDesign menuDesign = EMenuDesign.DARK;
	private EMenuAnimationSpeed menuAnimationSpeed = EMenuAnimationSpeed.HIGH;
	private EMenuNotificationCenterSort menuNotificationCenterSort = EMenuNotificationCenterSort.DOWNWARDS;
	private Resource notificationRemoveIcon = FontAwesome.TIMES;
	private Resource subMenuIcon = FontAwesome.ANGLE_UP;
	private Resource topMenuLeftMenuMaxSizeIcon = FontAwesome.ANGLE_RIGHT;
	private Resource topMenuLeftMenuMinSizeIcon = FontAwesome.ANGLE_LEFT;
	private Resource notificationCenterIcon = FontAwesome.BELL;
	private Resource notificationCenterEmptyIcon = FontAwesome.BELL_O;
	private int leftMenuButtonHeight = 50;
	private int leftMenuLabelHeight = 45;
	
	public EMenuNotificationCenterSort getMenuNotificationCenterSort() {
		return menuNotificationCenterSort;
	}
	public void setMenuNotificationCenterSort(EMenuNotificationCenterSort menuNotificationCenterSort) {
		this.menuNotificationCenterSort = menuNotificationCenterSort;
	}
	public Resource getNotificationRemoveIcon() {
		return notificationRemoveIcon;
	}
	public void setNotificationRemoveIcon(Resource notificationRemoveIcon) {
		this.notificationRemoveIcon = notificationRemoveIcon;
	}
	public int getLeftMenuButtonHeight() {
		return leftMenuButtonHeight;
	}
	public void setLeftMenuButtonHeight(int leftMenuButtonHeight) {
		this.leftMenuButtonHeight = leftMenuButtonHeight;
	}
	public int getLeftMenuLabelHeight() {
		return leftMenuLabelHeight;
	}
	public void setLeftMenuLabelHeight(int leftMenuLabelHeight) {
		this.leftMenuLabelHeight = leftMenuLabelHeight;
	}
	public EMenuComponents getMenuComponents() {
		return menuComponents;
	}
	public void setMenuComponents(EMenuComponents menuComponents) {
		this.menuComponents = menuComponents;
	}
	public EMenuDesign getMenuDesign() {
		return menuDesign;
	}
	public void setMenuDesign(EMenuDesign menuDesign) {
		this.menuDesign = menuDesign;
	}
	public EMenuAnimationSpeed getMenuAnimationSpeed() {
		return menuAnimationSpeed;
	}
	public void setMenuAnimationSpeed(EMenuAnimationSpeed menuAnimationSpeed) {
		this.menuAnimationSpeed = menuAnimationSpeed;
	}
	public Resource getSubMenuIcon() {
		return subMenuIcon;
	}
	public void setSubMenuIcon(Resource subMenuIcon) {
		this.subMenuIcon = subMenuIcon;
	}
	public Resource getTopMenuLeftMenuMaxSizeIcon() {
		return topMenuLeftMenuMaxSizeIcon;
	}
	public void setTopMenuLeftMenuMaxSizeIcon(Resource topMenuLeftMenuMaxSizeIcon) {
		this.topMenuLeftMenuMaxSizeIcon = topMenuLeftMenuMaxSizeIcon;
	}
	public Resource getTopMenuLeftMenuMinSizeIcon() {
		return topMenuLeftMenuMinSizeIcon;
	}
	public void setTopMenuLeftMenuMinSizeIcon(Resource topMenuLeftMenuMinSizeIcon) {
		this.topMenuLeftMenuMinSizeIcon = topMenuLeftMenuMinSizeIcon;
	}
	public Resource getNotificationCenterIcon() {
		return notificationCenterIcon;
	}
	public void setNotificationCenterIcon(Resource notificationCenterIcon) {
		this.notificationCenterIcon = notificationCenterIcon;
	}
	public Resource getNotificationCenterEmptyIcon() {
		return notificationCenterEmptyIcon;
	}
	public void setNotificationCenterEmptyIcon(Resource notificationCenterEmptyIcon) {
		this.notificationCenterEmptyIcon = notificationCenterEmptyIcon;
	}
}