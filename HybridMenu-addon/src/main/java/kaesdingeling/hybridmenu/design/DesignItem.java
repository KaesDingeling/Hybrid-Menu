package kaesdingeling.hybridmenu.design;

import kaesdingeling.hybridmenu.data.enums.MenuDesign;

public class DesignItem {
	private MenuDesign menuDesign = MenuDesign.DARK;
	
	/* Colors */
    private DesignColor darkColor;
    private DesignColor whiteColor;
    
    /* Content Background */
    private DesignColor contentBackground;
    
    /* Notifications */
    private DesignColor notificationBackground;
    private double notificationShadow;
    private DesignColor notificationRemoveButtonHover;
    
    /* Left-Menu */
    private DesignColor menuLeftBackground;
    private DesignColor menuLeftButtonHover;
    private DesignColor menuLeftButtonActive;
    
    /* tooltip */
    private DesignColor tooltipBackground;
    private DesignColor tooltipActiveBackground;
    
    public String convertToStyle() {
    	DesignUtils.setWhiteColor(whiteColor);
    	DesignUtils.setDarkColor(darkColor);
    	
    	DesignBuilder designBuilder = DesignBuilder.get();
		
		/* Notification */
    	
    	/* top menu */
    	designBuilder
    		.with(".topMenu .v-slot > div")
		    	.add(DesignUtils.hmBackgroundWithColor(menuLeftBackground))
		    	.add(DesignUtils.border(tooltipBackground, "top"))
		    	.with("input.HMTextField")
		    		.add(DesignUtils.hmBackgroundWithColor(notificationBackground))
		    		.and()
		    	.with("&:hover")
		    		.add(DesignUtils.hmBackgroundWithColor(menuLeftButtonHover))
		    		.and()
		    	.with(".HMButton-caption .toolTip")
		    		.add(DesignUtils.hmBackgroundWithColor(tooltipBackground))
		    		.and()
		    	.and()
		    .with(".rootContent.minimal .leftMenu .HMButton .HMButton-caption")
		    	.add(DesignUtils.background(menuLeftBackground, 0.75))
		    	.and()
		    .with(".rootContent")
		    	.add(DesignUtils.hmBackgroundWithColor(contentBackground))
		    	.with(".leftMenu")
		    		.add(DesignUtils.background(menuLeftBackground))
		    		.with(".v-slot-HMLabel > div .v-caption:after")
		    			.add(DesignUtils.border(DesignUtils.hmColorDedect(menuLeftBackground), "bottom", 25))
		    			.and()
		    		.with(".HMButton")
			    		.add(DesignUtils.border(tooltipBackground, "left"))
			    		.with("&.active")
			    			.add(DesignUtils.border(tooltipActiveBackground, "left"))
			    			.add(DesignUtils.hmBackgroundWithColor(menuLeftButtonActive))
			    			.and()
			    		.with("&:hover")
			    			.add(DesignUtils.hmBackgroundWithColor(menuLeftButtonHover))
			    			.and()
			    		.and()
			    	.with(".HMSubMenu > .v-slot:last-child > .v-verticallayout")
			    		.add(DesignUtils.border(DesignUtils.hmColorDedect(menuLeftBackground), "left", 25))
			    		.and()
			    	.and()
			    .with(".notificationCenter")
				    .add(DesignUtils.background(menuLeftBackground, notificationShadow))
				    .add(DesignUtils.color(DesignUtils.hmColorDedect(menuLeftBackground)))
				    .with(".notification")
				    	.add(DesignUtils.hmBackgroundWithColor(notificationBackground))
				    	.with(".title .timeAgo:before")
				    		.add(DesignUtils.background(DesignUtils.hmColorDedect(notificationBackground)))
				    		.and()
				    	.with(".button")
					    	.add(DesignUtils.background(new DesignColor(0, 0, 0, 0)))
					    	.add(DesignUtils.color(DesignUtils.hmColorDedect(notificationBackground)))
					    	.with("&:hover")
						    	.add(DesignUtils.color(notificationRemoveButtonHover))
						    	.add(DesignUtils.background(menuLeftButtonHover, 50))
						    	.and()
						    .and()
						.and()
					.with(".v-slot-footer .v-slot > div")
						.add(DesignUtils.hmBackgroundWithColor(menuLeftButtonActive))
						.with("&:hover")
							.add(DesignUtils.hmBackgroundWithColor(menuLeftButtonHover));
    	
    	return designBuilder.build();
    }

	public MenuDesign getMenuDesign() {
		return menuDesign;
	}
	public DesignItem setMenuDesign(MenuDesign menuDesign) {
		this.menuDesign = menuDesign;
		return this;
	}
	public DesignColor getDarkColor() {
		return darkColor;
	}
	public DesignItem setDarkColor(DesignColor darkColor) {
		this.darkColor = darkColor;
		return this;
	}
	public DesignColor getWhiteColor() {
		return whiteColor;
	}
	public DesignItem setWhiteColor(DesignColor whiteColor) {
		this.whiteColor = whiteColor;
		return this;
	}
	public DesignColor getContentBackground() {
		return contentBackground;
	}
	public DesignItem setContentBackground(DesignColor contentBackground) {
		this.contentBackground = contentBackground;
		return this;
	}
	public DesignColor getNotificationBackground() {
		return notificationBackground;
	}
	public DesignItem setNotificationBackground(DesignColor notificationBackground) {
		this.notificationBackground = notificationBackground;
		return this;
	}
	public double getNotificationShadow() {
		return notificationShadow;
	}
	public DesignItem setNotificationShadow(double notificationShadow) {
		this.notificationShadow = notificationShadow;
		return this;
	}
	public DesignColor getNotificationRemoveButtonHover() {
		return notificationRemoveButtonHover;
	}
	public DesignItem setNotificationRemoveButtonHover(DesignColor notificationRemoveButtonHover) {
		this.notificationRemoveButtonHover = notificationRemoveButtonHover;
		return this;
	}
	public DesignColor getMenuLeftBackground() {
		return menuLeftBackground;
	}
	public DesignItem setMenuLeftBackground(DesignColor menuLeftBackground) {
		this.menuLeftBackground = menuLeftBackground;
		return this;
	}
	public DesignColor getMenuLeftButtonHover() {
		return menuLeftButtonHover;
	}
	public DesignItem setMenuLeftButtonHover(DesignColor menuLeftButtonHover) {
		this.menuLeftButtonHover = menuLeftButtonHover;
		return this;
	}
	public DesignColor getMenuLeftButtonActive() {
		return menuLeftButtonActive;
	}
	public DesignItem setMenuLeftButtonActive(DesignColor menuLeftButtonActive) {
		this.menuLeftButtonActive = menuLeftButtonActive;
		return this;
	}
	public DesignColor getTooltipBackground() {
		return tooltipBackground;
	}
	public DesignItem setTooltipBackground(DesignColor tooltipBackground) {
		this.tooltipBackground = tooltipBackground;
		return this;
	}
	public DesignColor getTooltipActiveBackground() {
		return tooltipActiveBackground;
	}
	public DesignItem setTooltipActiveBackground(DesignColor tooltipActiveBackground) {
		this.tooltipActiveBackground = tooltipActiveBackground;
		return this;
	}
	
	public static DesignItem getWhiteDesign() {
		DesignItem design = new DesignItem().setMenuDesign(MenuDesign.WHITE);
		
		/* Colors */
		design.setDarkColor(DesignColor.get(66, 66, 66));
		design.setWhiteColor(DesignColor.get(245, 245, 245));
		
		/* Content-Background */
		design.setContentBackground(DesignColor.get(245, 245, 245));
        
		/* Left-Menu */
		design.setMenuLeftBackground(DesignColor.get(224, 224, 224));
		design.setMenuLeftButtonActive(design.getContentBackground());
		design.setMenuLeftButtonHover(DesignColor.get(189, 189, 189));
		
		/* Notifications */
		design.setNotificationBackground(design.getMenuLeftBackground());
		design.setNotificationRemoveButtonHover(DesignColor.get(222, 30, 30));
		design.setNotificationShadow(75);
		
		/* ToolTip */
		design.setTooltipBackground(DesignColor.get(25, 118, 210));
		design.setTooltipActiveBackground(DesignColor.get(43, 194, 78));
		
		return design;
	}
	
	public static DesignItem getDarkDesign() {
		DesignItem design = DesignItem.getWhiteDesign().setMenuDesign(MenuDesign.DARK);
		
		/* Content-Background */
		design.setContentBackground(DesignColor.get(83, 83, 83));
        
		/* Left-Menu */
		design.setMenuLeftBackground(DesignColor.get(53, 53, 53));
		design.setMenuLeftButtonActive(design.getContentBackground());
		design.setMenuLeftButtonHover(DesignColor.get(33, 33, 33));
		
		/* Notifications */
		design.setNotificationBackground(design.getMenuLeftBackground());
		
		return design;
	}
}