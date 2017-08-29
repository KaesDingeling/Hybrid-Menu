package kaesdingeling.hybridmenu.data.top;

import com.vaadin.ui.Label;

import kaesdingeling.hybridmenu.data.MenuTopItem;

public class TopMenuLabel extends MenuTopItem {
	private Label component = null;
	
	public TopMenuLabel() {
		component = new Label();
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
	public Label getComponent() {
		return component;
	}

	public void build() {
		component.setPrimaryStyleName("menuLabel");
		super.build();
	}
}