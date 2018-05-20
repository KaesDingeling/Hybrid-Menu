package de.kaesdingeling.hybridmenu.data.interfaces;

import java.util.List;

import com.vaadin.flow.component.Component;

@SuppressWarnings("hiding")
public interface MenuComponent<T extends Component> {
	public <MenuComponent extends Component> MenuComponent add(MenuComponent c);
	public <MenuComponent extends Component> MenuComponent addAsFirst(MenuComponent c);
	public <MenuComponent extends Component> MenuComponent addAt(MenuComponent c, int index);
	public int count();
	public <MenuComponent extends Component> T remove(MenuComponent c);
	public List<MenuComponent<?>> getList();
}