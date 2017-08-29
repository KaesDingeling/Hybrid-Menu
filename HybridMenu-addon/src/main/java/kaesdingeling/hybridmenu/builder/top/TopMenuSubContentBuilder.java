package kaesdingeling.hybridmenu.builder.top;

import com.vaadin.server.Resource;
import com.vaadin.ui.Alignment;

import kaesdingeling.hybridmenu.HybridMenu;
import kaesdingeling.hybridmenu.data.enums.EMenuStyle;
import kaesdingeling.hybridmenu.data.top.TopMenuSubContent;

public class TopMenuSubContentBuilder {
	private TopMenuButtonBuilder buttonBuilder;
	private TopMenuSubContent topMenuSubContent;

    private TopMenuSubContentBuilder(TopMenuSubContent topMenuSubContent) {
    	buttonBuilder = TopMenuButtonBuilder.get().setUseOwnListener(true).setHideCaption(false);
        this.topMenuSubContent = topMenuSubContent;
    }

    public static TopMenuSubContentBuilder get() {
        return new TopMenuSubContentBuilder(new TopMenuSubContent());
    }
    
    public TopMenuSubContentBuilder addStyleName(String style) {
    	topMenuSubContent.addStyleName(style);
    	return this;
    }
    
    public TopMenuSubContentBuilder setAlignment(Alignment alignment) {
		topMenuSubContent.setAlignment(alignment);
    	return this;
	}
    
    public TopMenuSubContentBuilder setButtonIcon(Resource icon) {
    	buttonBuilder.setIcon(icon);
    	return this;
    }
    
    public TopMenuSubContentBuilder setButtonCaption(String caption) {
    	buttonBuilder.setCaption(caption);
    	return this;
    }
    
    public TopMenuSubContentBuilder addButtonStyleName(String style) {
    	buttonBuilder.addStyleName(style);
    	return this;
    }
    
    public TopMenuSubContentBuilder addButtonStyleName(EMenuStyle style) {
    	buttonBuilder.addStyleName(style.getName());
    	return this;
    }
	
	public TopMenuSubContentBuilder setButtonToolTip(String toolTip) {
		buttonBuilder.setToolTip(toolTip);
    	return this;
	}
    
    public TopMenuSubContentBuilder buildButton() {
    	topMenuSubContent.setButton(buttonBuilder.build());
    	return this;
    }
    
    public TopMenuSubContent build() {
    	buildButton();
    	topMenuSubContent.build();
    	return topMenuSubContent;
    }
    
    public TopMenuSubContent build(HybridMenu hybridMenu) {
    	buildButton();
    	topMenuSubContent.build();
    	hybridMenu.addMenuItem(topMenuSubContent);
    	return topMenuSubContent;
    }
}