package kaesdingeling.hybridmenu.data.interfaces;

import com.vaadin.flow.router.AfterNavigationEvent;

public interface ViewChangeManager {
	boolean manage(MenuComponent<?> menuContent, AfterNavigationEvent event);
}