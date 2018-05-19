package kaesdingeling.hybridmenu.design;

public class DesignItem {
	/* Colors */
    public DesignColor darkColor; // rgb(66, 66, 66)
    public DesignColor whiteColor; // rgb(245, 245, 245)
    
    /* Content Background */
    public DesignColor contentBackground; // rgb(245, 245, 245)
    
    /* Notifications */
    public DesignColor notificationCenterBackground; // rgba(224, 224, 224, 0.75)
    public DesignColor notificationCenterFooterButtonBackground; // rgb(245, 245, 245)
    public DesignColor notificationCenterFooterHoverButtonBackground; // rgb(189, 189, 189)
    public DesignColor notificationBackground; // rgba(224, 224, 224, 0.8)
    public DesignColor notificationButtonRemoveBackground; // rgba(189, 189, 189, 0)
    public DesignColor notificationHoverButtonRemoveBackground; // rgba(189, 189, 189, 0.5)
    public DesignColor notificationHoverButtonRemoveColor; // rgb(222, 30, 30)
    
    /* Left Menu */
    public DesignColor menuLeftBackground; // rgb(224, 224, 224)
    public DesignColor menuLeftItemBackground; // rgba(0, 0, 0, 0)
    public DesignColor menuLeftItemActiveBackground; // rgb(245, 245, 245)
    public DesignColor menuLeftItemHoverBackground; // rgb(189, 189, 189)
    
    /* Top Menu */
    public DesignColor menuTopItemBackground; // rgb(240, 240, 240)
    public DesignColor menuTopItemHoverBackground; // rgb(224, 224, 224)
    
    /* Tool Tip */
    public DesignColor menuItemBorder; // rgb(25, 118, 210)
    public DesignColor menuItemActiveBorder; // rgb(43, 194, 78)
    public DesignColor tooltipBackground; // rgb(25, 118, 210)
    
    public String convertToStyle() {
    	DesignUtils.setWhiteColor(whiteColor);
    	DesignUtils.setDarkColor(darkColor);
    	
    	DesignBuilder designBuilder = DesignBuilder.get();
    	
    	designBuilder
    		.with(".rootContent")
    			.add(DesignUtils.hmBackgroundWithColor(contentBackground))
    			.and()
    		.with(".topMenu")
    			.with("vaadin-button")
    				.add(DesignUtils.color(DesignUtils.hmColorDedect(menuTopItemBackground)))
    				.add(DesignUtils.boxShadow(0, 0, 2, 0, menuTopItemBackground.copy().setAlpha(0.75)))
    				.with("> div")
    					.add(DesignUtils.background(menuTopItemBackground))
    					.and()
    				.with("iron-icon")
	    				.add(DesignUtils.color(DesignUtils.hmColorDedect(menuTopItemBackground)))
	    				.and()
	        		.with("&:hover")
	        			.add(DesignUtils.border(menuItemBorder, "top"))
	    				.with("> div")
		    				.add(DesignUtils.background(menuTopItemHoverBackground))
		    				.and()
	    				.and()
        			.with("&.active")
	    				.add(DesignUtils.border(menuItemActiveBorder, "top"))
	    				.and()
    				.with(".toolTip")
	    				.add(DesignUtils.hmBackgroundWithColor(tooltipBackground))
	    				.add(DesignUtils.boxShadow(0, 0, 2, 0, tooltipBackground.copy().setAlpha(0.75)))
	    				.and()
	    			.and()
    			.with("vaadin-text-field")
    				.add(DesignUtils.color(DesignUtils.hmColorDedect(menuTopItemBackground)))
    				.add(DesignUtils.boxShadow(0, 0, 2, 0, menuTopItemBackground.copy().setAlpha(0.75)))
        			.with(".vaadin-text-field")
        				.add(DesignUtils.background(menuTopItemBackground))
        				.and()
        			.with("&:hover")
        				.add(DesignUtils.border(menuItemBorder, "top"))
        				.with(".vaadin-text-field")
	        				.add(DesignUtils.background(menuTopItemHoverBackground))
	        				.and()
        				.and()
        			.with("&.active")
	    				.add(DesignUtils.border(menuItemActiveBorder, "top"))
	    				.and()
    				.with("iron-icon")
    					.add(DesignUtils.color(DesignUtils.hmColorDedect(menuTopItemBackground)))
    					.and()
    				.and()
    			.and()
    		.with(".leftMenu")
				.add(DesignUtils.hmBackgroundWithColor(menuLeftBackground))
				.add(DesignUtils.boxShadow(0, 0, 2, 0, DesignUtils.hmColorDedect(menuLeftBackground).copy().setAlpha(0.25)))
				.add(DesignUtils.border(DesignUtils.hmColorDedect(menuLeftBackground).copy().setAlpha(0.25), "right"))
				.with("> label")
					.add(DesignUtils.border(DesignUtils.hmColorDedect(menuLeftBackground).copy().setAlpha(0.25), "bottom"))
					.and()
    			.with("vaadin-button")
    				.add(DesignUtils.hmBackgroundWithColor(menuLeftItemBackground))
    				.add(DesignUtils.border(menuItemBorder, "left"))
    				.with("&.active")
    					.add(DesignUtils.background(menuLeftItemActiveBackground))
        				.add(DesignUtils.border(menuItemActiveBorder, "left"))
        				.and()
    				.with("&:hover")
    					.add(DesignUtils.background(menuLeftItemHoverBackground))
        				.and()
	    			.with(".toolTip")
	    				.add(DesignUtils.hmBackgroundWithColor(tooltipBackground))
	    				.add(DesignUtils.boxShadow(0, 0, 2, 0, tooltipBackground.copy().setAlpha(0.75)))
	    				.and()
	    			.and()
	    		.with("vaadin-vertical-layout.subMenu > vaadin-vertical-layout")
					.add(DesignUtils.border(DesignUtils.hmColorDedect(menuLeftBackground).copy().setAlpha(0.25), "left"))
					.and()
				.and()
			.with(".notificationCenter")
				.add(DesignUtils.hmBackgroundWithColor(notificationCenterBackground))
				.with(".notification")
					.add(DesignUtils.hmBackgroundWithColor(notificationBackground))
    				.add(DesignUtils.boxShadow(0, 0, 2, 0, notificationBackground.copy().setAlpha(0.75)))
					.with("> iron-icon")
						.add(DesignUtils.border(DesignUtils.hmColorDedect(notificationBackground).copy().setAlpha(0.25), "right"))
						.and()
					.with(".timeAgo:before")
						.add(DesignUtils.background(DesignUtils.hmColorDedect(notificationBackground)))
						.and()
					.with("vaadin-button")
						.add(DesignUtils.hmBackgroundWithColor(notificationButtonRemoveBackground))
						.with("&:hover")
							.add(DesignUtils.color(notificationHoverButtonRemoveColor))
							.add(DesignUtils.background(notificationHoverButtonRemoveBackground))
							.and()
						.and()
					.and()
				.with(".footer vaadin-button")
					.add(DesignUtils.hmBackgroundWithColor(notificationCenterFooterButtonBackground))
					.with("&:hover")
						.add(DesignUtils.hmBackgroundWithColor(notificationCenterFooterHoverButtonBackground));
    	
    	return designBuilder.build();
    }
	
	public static DesignItem getWhiteDesign() {
		DesignItem design = new DesignItem();
		
		/* Colors */
		design.darkColor = DesignColor.get(66, 66, 66);
		design.whiteColor = DesignColor.get(245, 245, 245);
		
	    /* Content Background */
		design.contentBackground = design.whiteColor.copy();
	    
	    /* Notifications */
		design.notificationCenterBackground = DesignColor.get(224, 224, 224, 0.75);
		design.notificationCenterFooterButtonBackground = design.whiteColor.copy().setAlpha(1);
		design.notificationCenterFooterHoverButtonBackground = DesignColor.get(189, 189, 189);
		design.notificationBackground = design.notificationCenterBackground.setAlpha(0.8);
		design.notificationButtonRemoveBackground = design.notificationCenterFooterHoverButtonBackground.copy().setAlpha(0);
		design.notificationHoverButtonRemoveBackground = design.notificationCenterFooterHoverButtonBackground.copy().setAlpha(0.5);
		design.notificationHoverButtonRemoveColor = DesignColor.get(222, 30, 30);
	    
		/* Left Menu */
		design.menuLeftBackground = DesignColor.get(224, 224, 224);
		design.menuLeftItemBackground = design.notificationCenterFooterHoverButtonBackground.copy().setAlpha(0);
		design.menuLeftItemActiveBackground = design.whiteColor.copy();
		design.menuLeftItemHoverBackground = design.notificationCenterFooterHoverButtonBackground.copy();
		
		/* Top Menu */
		design.menuTopItemBackground = DesignColor.get(240, 240, 240);
		design.menuTopItemHoverBackground = design.menuLeftBackground.copy();
	    
	    /* Tool Tip */
		design.menuItemBorder = DesignColor.get(25, 118, 210);
		design.menuItemActiveBorder = DesignColor.get(43, 194, 78);
		design.tooltipBackground = design.menuItemBorder.copy();
		
		return design;
	}
	
	public static DesignItem getDarkDesign() {
		DesignItem design = DesignItem.getWhiteDesign();
		
		/* Content-Background */
		design.contentBackground = DesignColor.get(83, 83, 83);
	    
	    /* Notifications */
		design.notificationCenterBackground = design.darkColor.copy().setAlpha(0.75);
		design.notificationCenterFooterButtonBackground = design.darkColor.copy().setAlpha(1);
		design.notificationCenterFooterHoverButtonBackground = DesignColor.get(33, 33, 33);
		design.notificationBackground = design.darkColor.copy().setAlpha(0.8);
		design.notificationButtonRemoveBackground = design.notificationCenterFooterHoverButtonBackground.copy().setAlpha(0);
		design.notificationHoverButtonRemoveBackground = design.notificationCenterFooterHoverButtonBackground.copy().setAlpha(0.5);
	    
		/* Left Menu */
		design.menuLeftBackground = DesignColor.get(53, 53, 53);
		design.menuLeftItemBackground = design.notificationCenterFooterHoverButtonBackground.copy().setAlpha(0);
		design.menuLeftItemActiveBackground = design.contentBackground.copy();
		design.menuLeftItemHoverBackground = design.notificationCenterFooterHoverButtonBackground.copy();
		
		/* Top Menu */
		design.menuTopItemBackground = design.menuLeftBackground.copy();
		design.menuTopItemHoverBackground = DesignColor.get(33, 33, 33);
		
		return design;
	}
}