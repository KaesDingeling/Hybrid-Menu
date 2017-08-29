package kaesdingeling.hybridmenu.data;

import com.vaadin.server.Resource;
import com.vaadin.ui.Component;

public abstract class MenuItem {
	private Component component = null;
	private boolean isBuilded = false;
	
	public String getStyleName() {
		return component.getStyleName();
	}
	public void removeStyleName(String style) {
		component.removeStyleName(style);
	}
	public void addStyleName(String style) {
		component.addStyleName(style);
	}
	public void setCaption(String caption) {
		component.setCaption(caption);
	}
	public void setIcon(Resource icon) {
		component.setIcon(icon);
	}
	public Component getComponent() {
		return component;
	}
	protected void setComponent(Component component) {
		this.component = component;
	}
	protected void build() {
		isBuilded = true;
	}
	protected boolean isBuilded() {
		return isBuilded;
	}
}