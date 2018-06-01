package de.kaesdingeling.hybridmenu.components;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import de.kaesdingeling.hybridmenu.data.interfaces.MenuComponent;
import de.kaesdingeling.hybridmenu.utils.Styles;

@SuppressWarnings("hiding")
public class BreadCrumbs extends HorizontalLayout implements MenuComponent<BreadCrumbs> {
	private static final long serialVersionUID = 5825929144162024583L;
	
	private HMButton root = null;
	
	public BreadCrumbs() {
		getClassNames().add(Styles.breadCrumbs);
		setWidth("100%");
		setMargin(false);
		setSpacing(true);
	}
	
	public BreadCrumbs setRoot(HMButton root) {
		this.root = HMButton.get().withCaption(root.getText()).withStyleName("clickable").withClickListener(e -> root.click());
		add(this.root);
		return this;
	}
	
	public HMButton getRoot() {
		return this.root;
	}
	
	public BreadCrumbs clear() {
		for (MenuComponent<?> menuComponent : getList()) {
			if (!menuComponent.equals(root)) {
				remove((Component) menuComponent);
			}
		}
		return this;
	}
	
	@Override
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
	public <MenuComponent extends Component> BreadCrumbs remove(MenuComponent c) {
		super.remove(c);
		return this;
	}

	@Override
	public int count() {
		return getList().size();
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