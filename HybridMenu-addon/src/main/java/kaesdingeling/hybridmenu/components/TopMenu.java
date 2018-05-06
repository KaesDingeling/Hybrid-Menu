package kaesdingeling.hybridmenu.components;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;

import kaesdingeling.hybridmenu.data.interfaces.MenuComponent;

public class TopMenu extends HorizontalLayout {
	private static final long serialVersionUID = -1591746194262213773L;
	
	public static final String CLASS_NAME = "topMenu";
	
	public TopMenu() {
		super();
		setHeight(0, Unit.PIXELS);
		setStyleName(CLASS_NAME);
		setMargin(false);
		setSpacing(false);
	}
	
	public <C extends MenuComponent<?>> C add(C c) {
		c.setCaption("");
		c.setPrimaryStyleName(c.getRootStyle());
		addComponent(c);
		return c;
	}
	
	public <C extends MenuComponent<?>> TopMenu remove(C c) {
		removeComponent(c);
		return this;
	}
	
	public List<MenuComponent<?>> getList() {
		List<MenuComponent<?>> menuComponentList = new ArrayList<MenuComponent<?>>();
		for (int i = 0; i < getComponentCount(); i++) {
			Component component = getComponent(i);
			if (component instanceof MenuComponent<?>) {
				menuComponentList.add((MenuComponent<?>) component);
			}
		}
		return menuComponentList;
	}
}