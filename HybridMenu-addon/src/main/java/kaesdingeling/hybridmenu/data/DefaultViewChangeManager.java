package kaesdingeling.hybridmenu.data;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Component;

import kaesdingeling.hybridmenu.components.HMButton;
import kaesdingeling.hybridmenu.components.HMSubMenu;
import kaesdingeling.hybridmenu.components.LeftMenu;
import kaesdingeling.hybridmenu.data.interfaces.MenuComponent;
import kaesdingeling.hybridmenu.data.interfaces.ViewChangeManager;

public class DefaultViewChangeManager implements ViewChangeManager {

	public boolean manage(AbstractOrderedLayout menuContent, ViewChangeEvent event) {
		boolean foundActiveButton = false;
		if (menuContent != null) {
			if (menuContent instanceof LeftMenu) {
				for (int i = 0; i < menuContent.getComponentCount(); i++) {
					Component component = menuContent.getComponent(i);
					if (component instanceof HMSubMenu) {
						if (checkSubMenu((HMSubMenu) component, event)) {
							foundActiveButton = true;
						}
					} else if (component instanceof HMButton) {
						if (checkButton((HMButton) component, event)) {
							foundActiveButton = true;
						}
					}
				}
			} else if (menuContent instanceof HMSubMenu) {
				HMSubMenu subMenu = (HMSubMenu) menuContent;
				for (MenuComponent<?> menuComponent : subMenu.getList()) {
					if (menuComponent instanceof HMSubMenu) {
						if (checkSubMenu((HMSubMenu) menuComponent, event)) {
							foundActiveButton = true;
						}
					} else if (menuComponent instanceof HMButton) {
						if (checkButton((HMButton) menuComponent, event)) {
							foundActiveButton = true;
						}
					}
				}
				
				if (foundActiveButton) {
					subMenu.open();
				} else {
					subMenu.close();
				}
			}
		}
		return foundActiveButton;
	}
	
	public boolean checkSubMenu(HMSubMenu subMenu, ViewChangeEvent event) {
		return manage(subMenu, event);
	}
	
	public boolean checkButton(HMButton button, ViewChangeEvent event) {
		boolean check = false;
		
		if (button.getNavigateTo() != null) {
			if (button.getNavigateTo().startsWith(event.getNewView().getClass().getSimpleName())) {
				if (button.getNavigateTo() != null && !event.getViewName().isEmpty()) {
					if (button.getNavigateTo().equals(event.getViewName())) {
						check = true;
					} else if (button.getNavigateTo().equals(event.getViewName() + "/" + event.getParameters())) {
						check = true;
					}
				} else {
					check = true;
				}
			}
		}
		
		button.setActive(check);
		
		return check;
	}
}