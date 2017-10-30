package kaesdingeling.hybridmenu.data;

import com.vaadin.shared.ui.colorpicker.Color;

import kaesdingeling.hybridmenu.builder.DesignBuilder;

public class DesignItem {
	/* Colors */
    private DesignColor darkColor;
    private DesignColor whiteColor;
    
    /* Content Background */
    private DesignColor contentBackground;
    
    /* Notifications */
    private DesignColor notificationPrioLowBackground;
    private DesignColor notificationPrioMediumBackground;
    private DesignColor notificationPrioHighBackground;
    private double notificationBorderColorOpacity;
    private double notificationShadow;
    private DesignColor notificationCloseButtonHover;
    private double notificationCloseButtonOpacity;
    
    /* Left-Menu */
    private DesignColor menuLeftBackground;
    private DesignColor menuLeftShadow;
    private double menuLeftShadowOpacity;
    private double menuLeftButtonOpacity;
    private DesignColor menuLeftButtonHover;
    private DesignColor menuLeftButtonBorderHover;
    private DesignColor menuLeftButtonActive;
    private DesignColor menuLeftButtonBorderActive;
    private DesignColor menuLeftSubMenuBorder;
    private DesignColor menuLeftButtonTooltip;
    
    /* Top-Menu */
    private DesignColor menuTopBackground;
    private DesignColor menuTopShadow;
    private double menuTopShadowOpacity;
    private DesignColor menuTopButtonHover;
    private DesignColor menuTopButtonActive;
    private DesignColor menuTopButtonBorder;
    private DesignColor menuTopButtonTooltip;
    
    public String convertToStyle() {
    	DesignBuilder designBuilder = DesignBuilder.get().withWhiteColor(whiteColor).withDarkColor(darkColor);
    	
    	String content = designBuilder.newBuilder().withBackground(contentBackground).withDetectColor(contentBackground).build();
		
		/* Notification */
    	content += designBuilder.newBuilder().withClass(".notificationItem.notificationPriorityLow.notificationItemWithIcon:before").withDetectColor(notificationPrioLowBackground, notificationBorderColorOpacity).build();
    	content += designBuilder.newBuilder().withClass(".notificationItem.notificationPriorityMedium.notificationItemWithIcon:before").withDetectColor(notificationPrioMediumBackground, notificationBorderColorOpacity).build();
    	content += designBuilder.newBuilder().withClass(".notificationItem.notificationPriorityHigh.notificationItemWithIcon:before").withDetectColor(notificationPrioHighBackground, notificationBorderColorOpacity).build();
		
    	content += designBuilder.newBuilder().withClass(".v-caption-notificationItem.v-caption-notificationPriorityLow.v-caption-notificationItemShow.v-caption-notificationItemWithIcon").withDetectColor(notificationPrioLowBackground).build();
    	content += designBuilder.newBuilder().withClass(".v-caption-notificationItem.v-caption-notificationPriorityMedium.v-caption-notificationItemShow.v-caption-notificationItemWithIcon").withDetectColor(notificationPrioMediumBackground).build();
    	content += designBuilder.newBuilder().withClass(".v-caption-notificationItem.v-caption-notificationPriorityHigh.v-caption-notificationItemShow.v-caption-notificationItemWithIcon").withDetectColor(notificationPrioHighBackground).build();
    	
    	content += designBuilder.newBuilder().withClass(".notificationItem .notificationItemCloseButton span.v-icon:hover").withColorImp(notificationCloseButtonHover).build();
		
    	content += buildNotificationItem("notificationPriorityLow", designBuilder, notificationPrioLowBackground);
    	content += buildNotificationItem("notificationPriorityMedium", designBuilder, notificationPrioMediumBackground);
    	content += buildNotificationItem("notificationPriorityHigh", designBuilder, notificationPrioHighBackground);
    	
    	/* Left-Menu */
    	content += designBuilder.newBuilder().withClass(".leftMenu").withBackground(menuLeftBackground).withDetectColor(menuLeftBackground).withBoxShadow(1, -1, 7, 0, DesignBuilder.colorToRGBA(menuLeftShadow, menuLeftShadowOpacity)).build();
    	content += designBuilder.newBuilder().withClass(".leftMenu .menuButton.active").withBorderLeftColor(menuLeftButtonBorderActive).withDetectColor(menuLeftButtonActive).withBackground(menuLeftButtonActive, menuLeftButtonOpacity).build();
    	content += designBuilder.newBuilder().withClass(".leftMenu .menuButton:hover").withBorderLeftColor(menuLeftButtonBorderHover).withDetectColor(menuLeftButtonHover).withBackground(menuLeftButtonHover, menuLeftButtonOpacity).build();
    	content += designBuilder.newBuilder().withClass(".leftMenu .menuButton.active:hover").withBorderLeftColor(menuLeftButtonBorderActive).build();
    	content += designBuilder.newBuilder().withClass(".leftMenu .menuSubMenuContent").withBorderLeftColor(menuLeftSubMenuBorder).build();
    	content += designBuilder.newBuilder().withClass(".leftMenu.minimal .menuButton-caption").withBackground(menuLeftBackground).build();
    	content += designBuilder.newBuilder().withClass(".leftMenu.minimal .v-slot-menuSubMenuContent").withBackground(menuLeftBackground).build();
    	
    	/* Top-Menu */
    	content += designBuilder.newBuilder().withClass(".topMenu").withBackground(menuTopBackground).withDetectColor(menuTopBackground).withBoxShadow(0, 6, 7, -3, DesignBuilder.colorToRGBA(menuTopShadow, menuTopShadowOpacity)).build();
    	content += designBuilder.newBuilder().withClass(".topMenu .menuButton.captionOutside .menuButton-caption .caption").withBorderLeftColor(menuTopButtonBorder).withDetectColor(menuTopBackground).withBackground(menuTopBackground).build();
    	content += designBuilder.newBuilder().withClass(".topMenu .menuSubMenu .menuSubMenuContent").withBorderLeftColor(menuTopButtonBorder).withDetectColor(menuTopBackground).withBackground(menuTopBackground).build();
    	
    	content += designBuilder.newBuilder().withClass(".topMenu .menuButton.active").withDetectColor(menuTopButtonActive).withBackground(menuTopButtonActive).build();
    	content += designBuilder.newBuilder().withClass(".topMenu .menuButton:hover").withDetectColor(menuTopButtonHover).withBackground(menuTopButtonHover).build();
    	content += designBuilder.newBuilder().withClass(".topMenu .menuButton.captionOutside .menuButton-caption .toolTop").withDetectColor(menuTopButtonTooltip).withBackground(menuTopButtonTooltip).build();
    	
    	content += designBuilder.newBuilder().withClass(".topMenu .menuSubMenu .menuSubMenuContent .menuSubMenuHr").withBackground(menuTopButtonHover).build();
    	content += designBuilder.newBuilder().withClass(".topMenu .menuSubMenu .menuSubMenuContent .menuSubMenuButton:hover").withBackground(menuTopButtonHover).build();
    	
    	return content;
    }
    
    private String buildNotificationItem(String className, DesignBuilder designBuilder, DesignColor notificationPrioBackground) {
    	String content = "";
    	content += designBuilder.newBuilder().withClass(".notificationItem." + className).withBackground(notificationPrioBackground).withBoxShadow(0, 6, 7, -3, DesignBuilder.colorToRGBA(notificationPrioBackground, notificationShadow)).build();
    	content += designBuilder.newBuilder().withClass(".notificationItem." + className + " .v-label").withDetectColor(notificationPrioBackground).build();
    	content += designBuilder.newBuilder().withClass(".notificationItem." + className + " .v-caption .v-captiontext").withDetectColor(notificationPrioBackground).build();
    	content += designBuilder.newBuilder().withClass(".notificationItem." + className + " .v-caption .v-captiontext p.timeAgo").withDetectColor(notificationPrioBackground).build();
    	content += designBuilder.newBuilder().withClass(".notificationItem." + className + " .v-caption .v-captiontext p.timeAgo:before").withDetectBackground(notificationPrioBackground).build();
    	content += designBuilder.newBuilder().withClass(".notificationItem." + className + " .notificationItemCloseButton span.v-icon").withDetectColor(notificationPrioBackground, notificationCloseButtonOpacity).build();
		return content;
    }

	public Color getDarkColor() {
		return getItem(darkColor);
	}
	public void setDarkColor(Color color) {
		darkColor = getItem(darkColor, color);
	}
	public Color getWhiteColor() {
		return getItem(whiteColor);
	}
	public void setWhiteColor(Color color) {
		whiteColor = getItem(whiteColor, color);
	}
	public Color getContentBackground() {
		return getItem(contentBackground);
	}
	public void setContentBackground(Color color) {
		contentBackground = getItem(contentBackground, color);
	}
	public Color getNotificationPrioLowBackground() {
		return getItem(notificationPrioLowBackground);
	}
	public void setNotificationPrioLowBackground(Color color) {
		notificationPrioLowBackground = getItem(notificationPrioLowBackground, color);
	}
	public Color getNotificationPrioMediumBackground() {
		return getItem(notificationPrioMediumBackground);
	}
	public void setNotificationPrioMediumBackground(Color color) {
		notificationPrioMediumBackground = getItem(notificationPrioMediumBackground, color);
	}
	public Color getNotificationPrioHighBackground() {
		return getItem(notificationPrioHighBackground);
	}
	public void setNotificationPrioHighBackground(Color color) {
		notificationPrioHighBackground = getItem(notificationPrioHighBackground, color);
	}
	public double getNotificationBorderColorOpacity() {
		return notificationBorderColorOpacity;
	}
	public void setNotificationBorderColorOpacity(double notificationBorderColorOpacity) {
		this.notificationBorderColorOpacity = notificationBorderColorOpacity;
	}
	public double getNotificationShadow() {
		return notificationShadow;
	}
	public void setNotificationShadow(double notificationShadow) {
		this.notificationShadow = notificationShadow;
	}
	public Color getNotificationCloseButtonHover() {
		return getItem(notificationCloseButtonHover);
	}
	public void setNotificationCloseButtonHover(Color color) {
		notificationCloseButtonHover = getItem(notificationCloseButtonHover, color);
	}
	public double getNotificationCloseButtonOpacity() {
		return notificationCloseButtonOpacity;
	}
	public void setNotificationCloseButtonOpacity(double notificationCloseButtonOpacity) {
		this.notificationCloseButtonOpacity = notificationCloseButtonOpacity;
	}
	public Color getMenuLeftBackground() {
		return getItem(menuLeftBackground);
	}
	public void setMenuLeftBackground(Color color) {
		menuLeftBackground = getItem(menuLeftBackground, color);
	}
	public Color getMenuLeftShadow() {
		return getItem(menuLeftShadow);
	}
	public void setMenuLeftShadow(Color color) {
		menuLeftShadow = getItem(menuLeftShadow, color);
	}
	public double getMenuLeftShadowOpacity() {
		return menuLeftShadowOpacity;
	}
	public void setMenuLeftShadowOpacity(double menuLeftShadowOpacity) {
		this.menuLeftShadowOpacity = menuLeftShadowOpacity;
	}
	public double getMenuLeftButtonOpacity() {
		return menuLeftButtonOpacity;
	}
	public void setMenuLeftButtonOpacity(double menuLeftButtonOpacity) {
		this.menuLeftButtonOpacity = menuLeftButtonOpacity;
	}
	public Color getMenuLeftButtonHover() {
		return getItem(menuLeftButtonHover);
	}
	public void setMenuLeftButtonHover(Color color) {
		menuLeftButtonHover = getItem(menuLeftButtonHover, color);
	}
	public Color getMenuLeftButtonBorderHover() {
		return getItem(menuLeftButtonBorderHover);
	}
	public void setMenuLeftButtonBorderHover(Color color) {
		menuLeftButtonBorderHover = getItem(menuLeftButtonBorderHover, color);
	}
	public Color getMenuLeftButtonActive() {
		return getItem(menuLeftButtonActive);
	}
	public void setMenuLeftButtonActive(Color color) {
		menuLeftButtonActive = getItem(menuLeftButtonActive, color);
	}
	public Color getMenuLeftButtonBorderActive() {
		return getItem(menuLeftButtonBorderActive);
	}
	public void setMenuLeftButtonBorderActive(Color color) {
		menuLeftButtonBorderActive = getItem(menuLeftButtonBorderActive, color);
	}
	public Color getMenuLeftSubMenuBorder() {
		return getItem(menuLeftSubMenuBorder);
	}
	public void setMenuLeftSubMenuBorder(Color color) {
		menuLeftSubMenuBorder = getItem(menuLeftSubMenuBorder, color);
	}
	public Color getMenuLeftButtonTooltip() {
		return getItem(menuLeftButtonTooltip);
	}
	public void setMenuLeftButtonTooltip(Color color) {
		menuLeftButtonTooltip = getItem(menuLeftButtonTooltip, color);
	}
	public Color getMenuTopBackground() {
		return getItem(menuTopBackground);
	}
	public void setMenuTopBackground(Color color) {
		menuTopBackground = getItem(menuTopBackground, color);
	}
	public Color getMenuTopShadow() {
		return getItem(menuTopShadow);
	}
	public void setMenuTopShadow(Color color) {
		menuTopShadow = getItem(menuTopShadow, color);
	}
	public double getMenuTopShadowOpacity() {
		return menuTopShadowOpacity;
	}
	public void setMenuTopShadowOpacity(double menuTopShadowOpacity) {
		this.menuTopShadowOpacity = menuTopShadowOpacity;
	}
	public Color getMenuTopButtonHover() {
		return getItem(menuTopButtonHover);
	}
	public void setMenuTopButtonHover(Color color) {
		menuTopButtonHover = getItem(menuTopButtonHover, color);
	}
	public Color getMenuTopButtonActive() {
		return getItem(menuTopButtonActive);
	}
	public void setMenuTopButtonActive(Color color) {
		menuTopButtonActive = getItem(menuTopButtonActive, color);
	}
	public Color getMenuTopButtonBorder() {
		return getItem(menuTopButtonBorder);
	}
	public void setMenuTopButtonBorder(Color color) {
		menuTopButtonBorder = getItem(menuTopButtonBorder, color);
	}
	public Color getMenuTopButtonTooltip() {
		return getItem(menuTopButtonTooltip);
	}
	public void setMenuTopButtonTooltip(Color color) {
		menuTopButtonTooltip = getItem(menuTopButtonTooltip, color);
	}
	private DesignColor getItem(DesignColor designColor, Color color) {
		if (color != null) {
			if (designColor != null) {
				designColor.convert(color);
				return designColor;
			} else {
				return new DesignColor(color);
			}
		} else {
			return null;
		}
	}
	private Color getItem(DesignColor designColor) {
		if (designColor != null) {
			return designColor.getColor();
		} else {
			return null;
		}
	}
	public static DesignItem getWhiteDesign() {
		DesignItem design = new DesignItem();
		
		/* Colors */
		design.setDarkColor(new Color(66, 66, 66));
		design.setWhiteColor(new Color(245, 245, 245));
		
		/* Content-Background */
		design.setContentBackground(new Color(245, 245, 245));
		
		/* Notifications */
		design.setNotificationPrioLowBackground(new Color(224, 224, 224));
		design.setNotificationPrioMediumBackground(new Color(0, 96, 100));
		design.setNotificationPrioHighBackground(new Color(191, 54, 12));
		design.setNotificationBorderColorOpacity(15.0);
		design.setNotificationShadow(70.0);
		design.setNotificationCloseButtonHover(new Color(222, 30, 30));
		design.setNotificationCloseButtonOpacity(50.0);
		
		/* Left-Menu */
		design.setMenuLeftBackground(new Color(238, 238, 238));
		design.setMenuLeftShadow(new Color(189, 189, 189));
		design.setMenuLeftShadowOpacity(40.0);
		design.setMenuLeftButtonOpacity(50.0);
		design.setMenuLeftButtonHover(new Color(224, 224, 224));
		design.setMenuLeftButtonBorderHover(new Color(25, 118, 210));
		design.setMenuLeftButtonActive(new Color(245, 245, 245));
		design.setMenuLeftButtonBorderActive(new Color(51, 105, 30));
		design.setMenuLeftSubMenuBorder(new Color(224, 224, 224));
		design.setMenuTopButtonTooltip(new Color(25, 118, 210));
		
		/* Top-Menu */
		design.setMenuTopBackground(new Color(224, 224, 224));
		design.setMenuTopShadow(new Color(189, 189, 189));
		design.setMenuTopShadowOpacity(40.0);
		design.setMenuTopButtonHover(new Color(51, 105, 30));
		design.setMenuTopButtonActive(new Color(46, 125, 50));
		design.setMenuTopButtonBorder(new Color(100, 221, 23));
		design.setMenuTopButtonTooltip(new Color(25, 118, 210));
		
		return design;
	}
	public static DesignItem getWhiteBlueDesign() {
		DesignItem design = DesignItem.getWhiteDesign();
		
		/* Top-Menu */
		design.setMenuTopBackground(new Color(25, 118, 210));
		design.setMenuTopButtonTooltip(new Color(245, 245, 245));
		
		return design;
	}
	public static DesignItem getDarkDesign() {
		DesignItem design = DesignItem.getWhiteDesign();
		
		/* Content-Background */
		design.setContentBackground(new Color(83, 83, 83));
		
		/* Notifications */
		design.setNotificationPrioLowBackground(new Color(53, 53, 53));
		
		/* Left-Menu */
		design.setMenuLeftBackground(new Color(53, 53, 53));
		design.setMenuLeftShadow(new Color(0, 0, 0));
		design.setMenuLeftButtonHover(new Color(33, 33, 33));
		design.setMenuLeftButtonActive(new Color(83, 83, 83));
		design.setMenuLeftSubMenuBorder(new Color(83, 83, 83));
		
		/* Top-Menu */
		design.setMenuTopBackground(new Color(33, 33, 33));
		design.setMenuTopShadow(new Color(0, 0, 0));
		
		return design;
	}
}