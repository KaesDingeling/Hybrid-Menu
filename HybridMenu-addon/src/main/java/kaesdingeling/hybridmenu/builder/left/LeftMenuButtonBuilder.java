package kaesdingeling.hybridmenu.builder.left;

import com.vaadin.navigator.View;
import com.vaadin.server.Resource;
import com.vaadin.ui.Button.ClickListener;

import kaesdingeling.hybridmenu.HybridMenu;
import kaesdingeling.hybridmenu.data.MenuConfig;
import kaesdingeling.hybridmenu.data.leftmenu.MenuButton;

public class LeftMenuButtonBuilder {
	private MenuButton menuButton;

    private LeftMenuButtonBuilder(MenuButton menuButton) {
        this.menuButton = menuButton;
    }

    public static LeftMenuButtonBuilder get() {
        return new LeftMenuButtonBuilder(new MenuButton());
    }
    
    public LeftMenuButtonBuilder setIcon(Resource icon) {
    	menuButton.setIcon(icon);
    	return this;
    }
    
    public LeftMenuButtonBuilder setCaption(String caption) {
    	menuButton.setCaption(caption);
    	return this;
    }
    
    public LeftMenuButtonBuilder setUseOwnListener(boolean useOwnListener) {
    	menuButton.setUseOwnListener(useOwnListener);
    	return this;
    }
    
    public LeftMenuButtonBuilder addClickListener(ClickListener clickListener) {
    	menuButton.addClickListener(clickListener);
    	return this;
    }
    
    public LeftMenuButtonBuilder addStyleName(String style) {
    	menuButton.addStyleName(style);
    	return this;
    }
    
    public LeftMenuButtonBuilder navigateTo(Class<? extends View> _class) {
    	menuButton.navigateTo(_class);
    	return this;
	}
	
	public LeftMenuButtonBuilder navigateTo(String navigateToName) {
		menuButton.navigateTo(navigateToName);
    	return this;
	}
	
	public LeftMenuButtonBuilder setConfig(MenuConfig menuConfig) {
		menuButton.setConfig(menuConfig);
    	return this;
	}
    
    public MenuButton build() {
    	menuButton.build();
    	return menuButton;
    }
    
    public MenuButton build(HybridMenu hybridMenu) {
    	menuButton.build();
    	hybridMenu.addLeftMenuButton(menuButton);
    	return menuButton;
    }
}