package de.kaesdingeling.hybridmenu.components;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.VaadinSession;

import de.kaesdingeling.hybridmenu.data.enums.ToggleMode;
import de.kaesdingeling.hybridmenu.data.interfaces.MenuComponent;
import de.kaesdingeling.hybridmenu.utils.Styles;

@SuppressWarnings("hiding")
public class LeftMenu extends VerticalLayout implements MenuComponent<VerticalLayout> {
	private static final long serialVersionUID = 8774849625123603883L;
	
	/*
	private VerticalLayout content = new VerticalLayout();
	private HorizontalLayout footer = null;
	*/

	public LeftMenu() {
		super();
		setWidth("250px");
		setHeight("100%");
		getStyle().set("min-width", "250px");
		getStyle().set("max-width", "250px");
		getClassNames().add(Styles.leftMenu);
		setMargin(false);
		setPadding(false);
		setSpacing(false);
		/*
		content.setSizeFull();
		content.setSpacing(false);
		content.setMargin(false);
		content.setStyleName("content");
		addComponentsAndExpand(content);
		*/
	}
	
	public LeftMenu toggleSize() {
		if (getToggleMode().equals(ToggleMode.NORMAL)) {
			setToggleMode(ToggleMode.MINIMAL);
		} else {
			setToggleMode(ToggleMode.NORMAL);
		}
		return this;
	}
	
	public LeftMenu setToggleMode(ToggleMode toggleMode) {
		if (toggleMode != null) {
			switch (toggleMode) {
				case MINIMAL:
					setWidth("50px");
					getStyle().set("min-width", "50px");
					getStyle().set("max-width", "50px");
					getParent().get().getElement().getClassList().add(ToggleMode.MINIMAL.name().toLowerCase());
					break;
				case NORMAL:
					setWidth("250px");
					getStyle().set("min-width", "250px");
					getStyle().set("max-width", "250px");
					getParent().get().getElement().getClassList().remove(ToggleMode.MINIMAL.name().toLowerCase());
					break;
			}
			VaadinSession session = VaadinSession.getCurrent();
			if (session != null) {
				session.setAttribute(ToggleMode.class, toggleMode);
			}
		}
		return this;
	}
	
	public ToggleMode getToggleMode() {
		VaadinSession session = VaadinSession.getCurrent();
		if (session != null) {
			ToggleMode toggleMode = session.getAttribute(ToggleMode.class);
			if (toggleMode != null) {
				return toggleMode;
			}
		}
		return ToggleMode.NORMAL;
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
	public int count() {
		return getList().size();
	}
	
	@Override
	public <MenuComponent extends Component> LeftMenu remove(MenuComponent c) {
		super.remove(c);
		return this;
	}
	
	/*
	public HMButton addToFooter(HMButton c) {
		if (footer == null) {
			footer = new HorizontalLayout();
			footer.setMargin(false);
			footer.setSpacing(true);
			footer.setStyleName("footer");
			footer.setWidth(100, Unit.PERCENTAGE);
			addComponent(footer);
		}
		footer.addComponent(c);
		return c;
	}
	*/
	
	/*
	public LeftMenu removeFromFooter(HMButton component) {
		if (footer != null) {
			footer.removeComponent(component);
		}
		return this;
	}
	
	public List<Component> getFooterComponents() {
		List<Component> componentsList = new ArrayList<Component>();
		if (footer != null) {
			for (int i = 0; i < footer.getComponentCount(); i++) {
				componentsList.add(footer.getComponent(i));
			}
		}
		return componentsList;
	}
	*/
	
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