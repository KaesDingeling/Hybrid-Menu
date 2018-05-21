package kaesdingeling.hybridmenu.data;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

import kaesdingeling.hybridmenu.HybridMenu;
import kaesdingeling.hybridmenu.components.HMButton;
import kaesdingeling.hybridmenu.components.HMLabel;
import kaesdingeling.hybridmenu.components.HMSubMenu;
import kaesdingeling.hybridmenu.components.LeftMenu;
import kaesdingeling.hybridmenu.data.interfaces.MenuComponent;
import kaesdingeling.hybridmenu.data.interfaces.ViewChangeManager;

public class DefaultViewChangeManager implements ViewChangeManager {
	@Override
	public List<MenuComponent<?>> init(HybridMenu hybridMenu) {
		hybridMenu.getBreadCrumbs().clear();
		return new ArrayList<MenuComponent<?>>();
	}
	
	public boolean manage(HybridMenu hybridMenu, MenuComponent<?> menuComponent, ViewChangeEvent event, List<MenuComponent<?>> menuContentList) {
		boolean foundActiveButton = false;
		if (menuComponent != null) {
			if (menuComponent instanceof HMButton) {
				if (checkButton((HMButton) menuComponent, event)) {
					add(hybridMenu, HMButton.get().withCaption(menuComponent.getCaption()).withStyleName("clickable").withClickListener(e -> ((HMButton) menuComponent).click()), menuContentList);
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
						HMButton breadCrumButton = HMButton.get().withCaption(hmSubMenu.getCaption());
						breadCrumButton.setToolTip(hmSubMenu.getButton().getToolTip());
						breadCrumButton.removeToolTip();
						add(hybridMenu, breadCrumButton, menuContentList);
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
		if (hybridMenu.getBreadCrumbs().getRoot() != null  || menuContentList.size() > 0) {
			menuContentList.add(HMLabel.get().withIcon(hybridMenu.getConfig().getBreadcrumbSeperatorIcon()));
		}
		menuContentList.add(menuComponent);
	}
	
	public boolean checkButton(HMButton button, ViewChangeEvent event) {
		boolean check = false;
		
		if (button.getNavigateTo() != null) {
			if (button.getNavigateTo().startsWith(event.getNewView().getClass().getSimpleName())) {
				if (button.getNavigateTo().equals(event.getViewName())) {
					check = true;
				} else if (button.getNavigateTo().equals(event.getViewName() + "/" + event.getParameters())) {
					check = true;
				}
			} else {
				if (button.getNavigateTo().equals(event.getViewName())) {
					check = true;
				}
			}
		}
		
		button.setActive(check);
		
		return check;
	}

	@Override
	public void finish(HybridMenu hybridMenu, List<MenuComponent<?>> menuContentList) {
		if (hybridMenu.getBreadCrumbs().getRoot() != null && menuContentList.size() == 2) {
			MenuComponent<?> menuContent = menuContentList.get(1);
			if (hybridMenu.getBreadCrumbs().getRoot().getCaption().equals(menuContent.getCaption())) {
				menuContentList.clear();
			}
		}
		
		for (MenuComponent<?> menuComponent : menuContentList) {
			hybridMenu.getBreadCrumbs().add(menuComponent);
		}
	}
}