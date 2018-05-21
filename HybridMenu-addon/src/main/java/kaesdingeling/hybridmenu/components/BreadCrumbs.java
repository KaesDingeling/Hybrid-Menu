package kaesdingeling.hybridmenu.components;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;

import kaesdingeling.hybridmenu.data.interfaces.MenuComponent;
import kaesdingeling.hybridmenu.utils.Utils;

public class BreadCrumbs extends HorizontalLayout implements MenuComponent<BreadCrumbs> {
	private static final long serialVersionUID = 5825929144162024583L;
	
	private HMButton root = null;
	
	public BreadCrumbs() {
		setStyleName("breadcrumbs");
		setWidth(100, Unit.PERCENTAGE);
		setMargin(false);
		setSpacing(true);
	}
	
	public BreadCrumbs setRoot(HMButton root) {
		this.root = HMButton.get().withCaption(root.getCaption()).withStyleName("clickable").withClickListener(e -> root.click());
		add(this.root);
		return this;
	}
	
	public HMButton getRoot() {
		return this.root;
	}
	
	public BreadCrumbs clear() {
		for (MenuComponent<?> menuComponent : getList()) {
			if (!menuComponent.equals(root)) {
				remove(menuComponent);
			}
		}
		return this;
	}

	public <C extends MenuComponent<?>> C add(C c) {
		addComponent(Utils.setDefaults(c));
		return c;
	}
	
	@Override
	public <C extends MenuComponent<?>> C addAsFirst(C c) {
		addComponentAsFirst(Utils.setDefaults(c));
		return c;
	}

	@Override
	public <C extends MenuComponent<?>> C addAt(C c, int index) {
		addComponent(Utils.setDefaults(c), index);
		return c;
	}

	@Override
	public int count() {
		return getList().size();
	}

	@Override
	public <C extends MenuComponent<?>> BreadCrumbs remove(C c) {
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
		return null;
	}
}