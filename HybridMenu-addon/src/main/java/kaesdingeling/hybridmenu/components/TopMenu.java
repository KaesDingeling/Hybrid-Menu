package kaesdingeling.hybridmenu.components;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;

import kaesdingeling.hybridmenu.data.interfaces.MenuComponent;
import kaesdingeling.hybridmenu.utils.Utils;

public class TopMenu extends HorizontalLayout implements MenuComponent<HorizontalLayout> {
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
		addComponent(Utils.setTopMenuDefaults(c));
		return c;
	}
	
	@Override
	public <C extends MenuComponent<?>> C addAsFirst(C c) {
		addComponentAsFirst(Utils.setTopMenuDefaults(c));
		return c;
	}

	@Override
	public <C extends MenuComponent<?>> C addAt(C c, int index) {
		addComponent(Utils.setTopMenuDefaults(c), index);
		return c;
	}
	
	@Override
	public int count() {
		return getList().size();
	}
	
	@Override
	public <C extends MenuComponent<?>> TopMenu remove(C c) {
		removeComponent(c);
		return this;
	}
	
	@Override
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
	
	@Override
	public String getRootStyle() {
		return super.getPrimaryStyleName();
	}
}