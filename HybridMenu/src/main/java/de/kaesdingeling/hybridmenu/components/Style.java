package de.kaesdingeling.hybridmenu.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;

@Tag("style")
public class Style extends Component {
	private static final long serialVersionUID = -2892640561000697984L;
	
	public Style() {
		getElement().setProperty("type", "text/css");
	}
	
	public Style setStyle(String style) {
		getElement().setText(style);
		return this;
	}
	
	public Style clear() {
		getElement().setText("");
		return this;
	}
}