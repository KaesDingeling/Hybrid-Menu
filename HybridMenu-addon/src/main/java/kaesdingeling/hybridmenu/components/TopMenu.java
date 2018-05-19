package kaesdingeling.hybridmenu.components;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import kaesdingeling.hybridmenu.data.interfaces.MenuComponent;
import kaesdingeling.hybridmenu.utils.Styles;

@SuppressWarnings("hiding")
public class TopMenu extends HorizontalLayout implements MenuComponent<TopMenu> {
	private static final long serialVersionUID = -1591746194262213773L;
	
	public TopMenu() {
		super();
		setHeight("0px");
		getClassNames().add(Styles.topMenu);
		setMargin(false);
		setSpacing(false);
	}
	
	public <MenuComponent extends Component> MenuComponent add(MenuComponent c) {
		super.add(c);
		return c;
	}
	
	@Override
	public <MenuComponent extends Component> MenuComponent addAsFirst(MenuComponent c) {
		//super.addAsFirst(c);
		return c;
	}

	@Override
	public <MenuComponent extends Component> MenuComponent addAt(MenuComponent c, int index) {
		//super.addAt(c, index);
		return c;
	}
	
	@Override
	public int count() {
		return getList().size();
	}
	
	@Override
	public <MenuComponent extends Component> TopMenu remove(MenuComponent c) {
		remove(c);
		return this;
	}
	
	@Override
	public List<MenuComponent<?>> getList() {
		List<MenuComponent<?>> menuComponentList = new ArrayList<MenuComponent<?>>();
		for (int i = 0; i < getComponentCount(); i++) {
			Component component = getComponentAt(i);
			if (component instanceof MenuComponent<?>) {
				menuComponentList.add((MenuComponent<?>) component);
			}
		}
		return menuComponentList;
	}
}