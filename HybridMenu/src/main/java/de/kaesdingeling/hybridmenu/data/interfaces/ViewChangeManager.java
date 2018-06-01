package de.kaesdingeling.hybridmenu.data.interfaces;

import java.util.List;

import com.vaadin.flow.router.AfterNavigationEvent;

import de.kaesdingeling.hybridmenu.HybridMenu;

public interface ViewChangeManager {
	List<MenuComponent<?>> init(HybridMenu hybridMenu);
	boolean manage(HybridMenu hybridMenu, MenuComponent<?> menuContent, AfterNavigationEvent event, List<MenuComponent<?>> menuContentList);
	void finish(HybridMenu hybridMenu, List<MenuComponent<?>> menuContentList);
}