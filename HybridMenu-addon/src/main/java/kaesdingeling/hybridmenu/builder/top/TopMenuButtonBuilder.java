package kaesdingeling.hybridmenu.builder.top;

import com.vaadin.navigator.View;
import com.vaadin.server.Resource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button.ClickListener;

import kaesdingeling.hybridmenu.HybridMenu;
import kaesdingeling.hybridmenu.data.enums.EMenuStyle;
import kaesdingeling.hybridmenu.data.top.TopMenuButton;

public class TopMenuButtonBuilder {
	private TopMenuButton menuButton;

    protected TopMenuButtonBuilder(TopMenuButton menuButton) {
        this.menuButton = menuButton;
    }

    public static TopMenuButtonBuilder get() {
        return new TopMenuButtonBuilder(new TopMenuButton());
    }
    
    public TopMenuButtonBuilder setIcon(Resource icon) {
    	menuButton.setIcon(icon);
    	return this;
    }
    
    public TopMenuButtonBuilder setCaption(String caption) {
    	menuButton.setCaption(caption);
    	return this;
    }
    
    public TopMenuButtonBuilder setUseOwnListener(boolean useOwnListener) {
    	menuButton.setUseOwnListener(useOwnListener);
    	return this;
    }
    
    public TopMenuButtonBuilder addClickListener(ClickListener clickListener) {
    	menuButton.addClickListener(clickListener);
    	return this;
    }
    
    public TopMenuButtonBuilder addStyleName(String style) {
    	menuButton.addStyleName(style);
    	return this;
    }
    
    public TopMenuButtonBuilder addStyleName(EMenuStyle style) {
    	menuButton.addStyleName(style.getName());
    	return this;
    }
    
    public TopMenuButtonBuilder setNavigateTo(Class<? extends View> _class) {
    	menuButton.setNavigateTo(_class);
    	return this;
	}
	
	public TopMenuButtonBuilder setNavigateToName(String navigateToName) {
		menuButton.setNavigateToName(navigateToName);
    	return this;
	}
	
	public TopMenuButtonBuilder setToolTip(String toolTip) {
		menuButton.setToolTip(toolTip);
    	return this;
	}
	
	public TopMenuButtonBuilder setAlignment(Alignment alignment) {
		menuButton.setAlignment(alignment);
    	return this;
	}
	
	public TopMenuButtonBuilder setHideCaption(boolean hideCaption) {
		menuButton.setHideCaption(hideCaption);
    	return this;
	}
    
    public TopMenuButton build() {
    	menuButton.build();
    	return menuButton;
    }
    
    public TopMenuButton build(HybridMenu hybridMenu) {
    	menuButton.build();
    	hybridMenu.addMenuItem(menuButton);
    	return menuButton;
    }
}