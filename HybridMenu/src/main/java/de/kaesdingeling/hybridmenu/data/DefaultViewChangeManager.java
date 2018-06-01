package de.kaesdingeling.hybridmenu.data;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.AfterNavigationEvent;

import de.kaesdingeling.hybridmenu.HybridMenu;
import de.kaesdingeling.hybridmenu.components.HMButton;
import de.kaesdingeling.hybridmenu.components.HMLabel;
import de.kaesdingeling.hybridmenu.components.HMSubMenu;
import de.kaesdingeling.hybridmenu.components.LeftMenu;
import de.kaesdingeling.hybridmenu.data.interfaces.MenuComponent;
import de.kaesdingeling.hybridmenu.data.interfaces.ViewChangeManager;

public class DefaultViewChangeManager implements ViewChangeManager {
	@Override
	public List<MenuComponent<?>> init(HybridMenu hybridMenu) {
		hybridMenu.getBreadCrumbs().clear();
		return new ArrayList<MenuComponent<?>>();
	}

	@Override
	public boolean manage(HybridMenu hybridMenu, MenuComponent<?> menuComponent, AfterNavigationEvent event, List<MenuComponent<?>> menuContentList) {
		boolean foundActiveButton = false;
		if (menuComponent != null) {
			if (menuComponent instanceof HMButton) {
				if (checkButton((HMButton) menuComponent, event)) {
					add(hybridMenu, HMButton.get().withCaption(((HMButton) menuComponent).getText()).withStyleName("clickable").withClickListener(e -> ((HMButton) menuComponent).click()), menuContentList);
					foundActiveButton = true;
				}
			} else if (menuComponent instanceof LeftMenu || menuComponent instanceof HMSubMenu) {
				List<MenuComponent<?>> cacheMenuContentList = new ArrayList<MenuComponent<?>>();
				for (MenuComponent<?> cacheMenuComponent : menuComponent.getList()) {
					if (manage(hybridMenu, cacheMenuComponent, event, cacheMenuContentList)) {
						foundActiveButton = true;
					}
				}
				
				if (menuComponent instanceof HMSubMenu) {
					HMSubMenu hmSubMenu = (HMSubMenu) menuComponent;
					if (foundActiveButton) {
						add(hybridMenu, HMButton.get().withCaption(hmSubMenu.getButton().getText()), menuContentList);
						hmSubMenu.open();
					} else {
						hmSubMenu.close();
					}
				}
				
				menuContentList.addAll(cacheMenuContentList);
			}
		}
		return foundActiveButton;
	}
	
	public void add(HybridMenu hybridMenu, MenuComponent<?> menuComponent, List<MenuComponent<?>> menuContentList) {
		if (hybridMenu.getBreadCrumbs().getRoot() != null || menuContentList.size() > 0) {
			menuContentList.add(HMLabel.get().withIcon(hybridMenu.getConfig().getBreadcrumbSeperatorIcon()));
		}
		menuContentList.add(menuComponent);
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
	
	@Override
	public void finish(HybridMenu hybridMenu, List<MenuComponent<?>> menuContentList) {
		if (hybridMenu.getBreadCrumbs().getRoot() != null && menuContentList.size() == 2) {
			MenuComponent<?> menuContent = menuContentList.get(1);
			if (menuContent instanceof HMButton && hybridMenu.getBreadCrumbs().getRoot().getText().equals(((HMButton) menuContent).getText())) {
				menuContentList.clear();
			}
		}
		
		for (MenuComponent<?> menuComponent : menuContentList) {
			hybridMenu.getBreadCrumbs().add((Component) menuComponent);
		}
	}
}