package kaesdingeling.hybridmenu.data.top;

import com.vaadin.ui.Button;

import kaesdingeling.hybridmenu.data.MenuTopItem;
import kaesdingeling.hybridmenu.data.enums.EMenuStyle;

public class TopMenuLabel extends MenuTopItem {
	private Button component = null;
	
	public TopMenuLabel() {
		component = new Button();
		setComponent(component);
	}
	
	public void setCaption(String caption) {
		if (caption != null) {
			if (caption.contains("</")) {
				component.setCaptionAsHtml(true);
			}
		}
		component.setCaption(caption);
	}
	
	@Override
	public Button getComponent() {
		return component;
	}

	public void build() {
		component.setPrimaryStyleName("menuLabel");
		component.addStyleName(EMenuStyle.LABEL_TITLE.getName());
		super.build();
	}
}