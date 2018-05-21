package kaesdingeling.hybridmenu.data.interfaces;

import java.util.List;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

import kaesdingeling.hybridmenu.HybridMenu;

public interface ViewChangeManager {
	List<MenuComponent<?>> init(HybridMenu hybridMenu);
	boolean manage(HybridMenu hybridMenu, MenuComponent<?> menuContent, ViewChangeEvent event, List<MenuComponent<?>> menuContentList);
	void finish(HybridMenu hybridMenu, List<MenuComponent<?>> menuContentList);
}