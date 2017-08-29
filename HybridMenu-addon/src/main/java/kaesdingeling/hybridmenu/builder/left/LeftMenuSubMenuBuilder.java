package kaesdingeling.hybridmenu.builder.left;

import com.vaadin.server.Resource;

import kaesdingeling.hybridmenu.HybridMenu;
import kaesdingeling.hybridmenu.data.MenuConfig;
import kaesdingeling.hybridmenu.data.leftmenu.MenuSubMenu;

public class LeftMenuSubMenuBuilder {
	private MenuSubMenu menuSubMenu;

    private LeftMenuSubMenuBuilder(MenuSubMenu menuSubMenu) {
        this.menuSubMenu = menuSubMenu;
    }

    public static LeftMenuSubMenuBuilder get() {
        return new LeftMenuSubMenuBuilder(new MenuSubMenu());
    }
    
    public LeftMenuSubMenuBuilder setIcon(Resource icon) {
    	menuSubMenu.setIcon(icon);
    	return this;
    }
    
    public LeftMenuSubMenuBuilder setCaption(String caption) {
    	menuSubMenu.setCaption(caption);
    	return this;
    }
    
    public LeftMenuSubMenuBuilder addStyleName(String style) {
    	menuSubMenu.addStyleName(style);
    	return this;
    }
	
	public LeftMenuSubMenuBuilder setConfig(MenuConfig menuConfig) {
		menuSubMenu.setConfig(menuConfig);
    	return this;
	}
    
    public MenuSubMenu build() {
    	menuSubMenu.build();
    	return menuSubMenu;
    }
    
    public MenuSubMenu build(HybridMenu hybridMenu) {
    	menuSubMenu.build();
    	hybridMenu.addLeftMenuSubMenu(menuSubMenu);
    	return menuSubMenu;
    }
    
    public MenuSubMenu build(MenuSubMenu menuSubMenu) {
    	this.menuSubMenu.build();
    	menuSubMenu.addLeftMenuSubMenu(this.menuSubMenu);
    	return this.menuSubMenu;
    }
}