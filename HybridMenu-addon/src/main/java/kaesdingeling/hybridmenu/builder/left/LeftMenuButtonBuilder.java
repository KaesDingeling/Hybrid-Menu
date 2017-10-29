package kaesdingeling.hybridmenu.builder.left;

import com.vaadin.navigator.View;
import com.vaadin.server.Resource;
import com.vaadin.ui.Button.ClickListener;

import kaesdingeling.hybridmenu.HybridMenu;
import kaesdingeling.hybridmenu.data.MenuConfig;
import kaesdingeling.hybridmenu.data.leftmenu.MenuButton;
import kaesdingeling.hybridmenu.data.leftmenu.MenuSubMenu;

public class LeftMenuButtonBuilder {
	private MenuButton menuButton;

    private LeftMenuButtonBuilder(MenuButton menuButton) {
        this.menuButton = menuButton;
    }

    public static LeftMenuButtonBuilder get() {
        return new LeftMenuButtonBuilder(new MenuButton());
    }
    
    public LeftMenuButtonBuilder withIcon(Resource icon) {
    	menuButton.setIcon(icon);
    	return this;
    }
    
    public LeftMenuButtonBuilder withCaption(String caption) {
    	menuButton.setCaption(caption);
    	return this;
    }
    
    public LeftMenuButtonBuilder withUseOwnListener(boolean useOwnListener) {
    	menuButton.setUseOwnListener(useOwnListener);
    	return this;
    }
    
    public LeftMenuButtonBuilder withClickListener(ClickListener clickListener) {
    	menuButton.addClickListener(clickListener);
    	return this;
    }
    
    public LeftMenuButtonBuilder withStyleName(String style) {
    	menuButton.addStyleName(style);
    	return this;
    }
    
    public LeftMenuButtonBuilder withNavigateTo(Class<? extends View> _class) {
    	menuButton.navigateTo(_class);
    	return this;
	}
	
	public LeftMenuButtonBuilder withNavigateTo(String navigateToName) {
		menuButton.navigateTo(navigateToName);
    	return this;
	}
	
	public LeftMenuButtonBuilder withConfig(MenuConfig menuConfig) {
		menuButton.setConfig(menuConfig);
    	return this;
	}
    
    
	/**
	 * @deprecated please use withIcon(...)
	 */
    public LeftMenuButtonBuilder setIcon(Resource icon) {
    	return this.withIcon(icon);
    }
    
    /**
	 * @deprecated please use withCaption(...)
	 */
    public LeftMenuButtonBuilder setCaption(String caption) {
    	return this.withCaption(caption);
    }
    
    /**
	 * @deprecated please use withUseOwnListener(...)
	 */
    public LeftMenuButtonBuilder setUseOwnListener(boolean useOwnListener) {
    	return this.withUseOwnListener(useOwnListener);
    }
    
    /**
	 * @deprecated please use withClickListener(...)
	 */
    public LeftMenuButtonBuilder addClickListener(ClickListener clickListener) {
    	return this.withClickListener(clickListener);
    }
    
    /**
	 * @deprecated please use withStyleName(...)
	 */
    public LeftMenuButtonBuilder addStyleName(String style) {
    	return this.withStyleName(style);
    }
    
    /**
	 * @deprecated please use withNavigateTo(...)
	 */
    public LeftMenuButtonBuilder navigateTo(Class<? extends View> _class) {
    	return this.withNavigateTo(_class);
	}
	
    /**
	 * @deprecated please use withNavigateTo(...)
	 */
	public LeftMenuButtonBuilder navigateTo(String navigateToName) {
    	return this.withNavigateTo(navigateToName);
	}
	
	/**
	 * @deprecated please use withConfig(...)
	 */
	public LeftMenuButtonBuilder setConfig(MenuConfig menuConfig) {
    	return this.withConfig(menuConfig);
	}
    
    public MenuButton build() {
    	menuButton.build();
    	return menuButton;
    }
    
    public MenuButton build(MenuSubMenu menuSubMenu) {
    	menuButton.build();
    	menuSubMenu.addLeftMenuButton(menuButton);
    	return menuButton;
    }
    
    public MenuButton build(HybridMenu hybridMenu) {
    	menuButton.build();
    	hybridMenu.addLeftMenuButton(menuButton);
    	return menuButton;
    }
}