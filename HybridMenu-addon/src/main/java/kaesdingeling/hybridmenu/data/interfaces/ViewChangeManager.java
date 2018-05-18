package kaesdingeling.hybridmenu.data.interfaces;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

public interface ViewChangeManager {
	boolean manage(MenuComponent<?> menuContent, ViewChangeEvent event);
}