package kaesdingeling.hybridmenu.data;

import java.util.List;

import com.vaadin.flow.router.AfterNavigationEvent;

import kaesdingeling.hybridmenu.components.HMButton;
import kaesdingeling.hybridmenu.components.HMSubMenu;
import kaesdingeling.hybridmenu.data.interfaces.MenuComponent;
import kaesdingeling.hybridmenu.data.interfaces.ViewChangeManager;

public class DefaultViewChangeManager implements ViewChangeManager {

	public boolean manage(MenuComponent<?> menuComponent, AfterNavigationEvent event) {
		boolean foundActiveButton = false;
		if (menuComponent != null) {
			if (menuComponent instanceof HMButton) {
				if (checkButton((HMButton) menuComponent, event)) {
					foundActiveButton = true;
				}
			} else {
				List<MenuComponent<?>> menuComponentList = menuComponent.getList();
				if (menuComponentList != null) {
					for (MenuComponent<?> cacheMenuComponent : menuComponentList) {
						if (manage(cacheMenuComponent, event)) {
							foundActiveButton = true;
						}
					}
					
					if (menuComponent instanceof HMSubMenu) {
						if (foundActiveButton) {
							((HMSubMenu) menuComponent).open();
						} else {
							((HMSubMenu) menuComponent).close();
						}
					}
				}
			}
		}
		return foundActiveButton;
	}
	
	public boolean checkButton(HMButton button, AfterNavigationEvent event) {
		boolean check = false;
		
		if (button.getNavigateTo() != null) {
			if (button.getNavigateTo().equals(event.getLocation().getPath())) {
				check = true;
			}
		}
		
		button.setActive(check);
		
		return check;
	}
}