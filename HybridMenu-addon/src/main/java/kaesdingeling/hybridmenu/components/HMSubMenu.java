package kaesdingeling.hybridmenu.components;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.server.Resource;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

import kaesdingeling.hybridmenu.data.MenuConfig;
import kaesdingeling.hybridmenu.data.interfaces.MenuComponent;
import kaesdingeling.hybridmenu.utils.Utils;

public class HMSubMenu extends VerticalLayout implements MenuComponent<VerticalLayout> {
	private static final long serialVersionUID = 5694189462883703860L;
	
	private HMButton button = new HMButton("");
	private VerticalLayout content = new VerticalLayout();
	
	public static HMSubMenu get() {
		return new HMSubMenu("");
	}
	
	public HMSubMenu(String caption) {
		build(caption, null);
	}
	
	public HMSubMenu(Resource icon) {
		build(null, icon);
	}
	
	public HMSubMenu(String caption, Resource icon) {
		build(caption, icon);
	}
	
	private void build(String caption, Resource icon) {
		button = new HMButton(caption, icon);
		button.withToolTip(VaadinSession.getCurrent().getAttribute(MenuConfig.class).getSubMenuIcon().getHtml());
		button.addClickListener(e -> toggle());
		button.setPrimaryStyleName(button.getClass().getSimpleName());
		content.setMargin(false);
		content.setSpacing(false);
		super.setMargin(false);
		super.setSpacing(false);
		super.addComponents(button, content);
	}
	
	public HMSubMenu withCaption(String caption) {
		button.withCaption(caption);
		return this;
	}
	
	public HMSubMenu withIcon(Resource icon) {
		button.withIcon(icon);
		return this;
	}
	
	public HMSubMenu toggle() {
		if (isOpen()) {
			close();
		} else {
			open();
		}
		return this;
	}
	
	public HMSubMenu open() {
		addStyleName("open");
		return this;
	}
	
	public HMSubMenu close() {
		removeStyleName("open");
		return this;
	}
	
	public boolean isOpen() {
		return getStyleName().contains("open");
	}
	
	@Override
	public String getRootStyle() {
		return this.getClass().getSimpleName();
	}
	
	public <C extends MenuComponent<?>> C add(C c) {
		content.addComponent(Utils.setDefaults(c));
		return c;
	}
	
	@Override
	public <C extends MenuComponent<?>> C addAsFirst(C c) {
		content.addComponentAsFirst(Utils.setDefaults(c));
		return c;
	}

	@Override
	public <C extends MenuComponent<?>> C addAt(C c, int index) {
		content.addComponent(Utils.setDefaults(c), index);
		return c;
	}
	
	@Override
	public <C extends MenuComponent<?>> HMSubMenu remove(C c) {
		content.removeComponent(c);
		return this;
	}

	@Override
	public int count() {
		return getList().size();
	}
	
	public List<MenuComponent<?>> getList() {
		List<MenuComponent<?>> menuComponentList = new ArrayList<MenuComponent<?>>();
		for (int i = 0; i < content.getComponentCount(); i++) {
			Component component = content.getComponent(i);
			if (component instanceof MenuComponent<?>) {
				menuComponentList.add((MenuComponent<?>) component);
			}
		}
		return menuComponentList;
	}
}