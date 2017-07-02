package kaesdingeling.hybridmenu.utils;

import java.util.Set;

import com.vaadin.icons.VaadinIcons;

import kaesdingeling.hybridmenu.data.MenuItem;

public class ViewChangeManager {
	public boolean manage(Set<MenuItem> menuItemList, String viewName) {
		boolean foundActiveButton = false;
		if (menuItemList != null) {
			for (MenuItem menuItem : menuItemList) {
				boolean setButtonActive = false;
				if (menuItem.getButton() != null) {
					if (menuItem.getSubMenu() != null) {
						setButtonActive = manage(menuItem.getSubMenu(), viewName);
					}
					if (menuItem.getNavigateTo() != null) {
						if (menuItem.getNavigateTo().equals(viewName)) {
							setButtonActive = true;
						}
					}
					if (setButtonActive) {
						foundActiveButton = true;
						if (!menuItem.getButton().getStyleName().contains("active")) {
							menuItem.getButton().addStyleName("active");
						}
						if (menuItem.getSubMenuContent() != null) {
							if (menuItem.getButton().getCaption().contains(VaadinIcons.ANGLE_LEFT.getHtml())) {
								menuItem.getButton().setCaption(menuItem.getButton().getCaption().replaceAll(VaadinIcons.ANGLE_LEFT.getHtml(), VaadinIcons.ANGLE_DOWN.getHtml()));
							}
							if (!menuItem.getSubMenuContent().getStyleName().contains("open")) {
								menuItem.getSubMenuContent().addStyleName("open");
							}
						}
					} else {
						if (menuItem.getButton().getStyleName().contains("active")) {
							menuItem.getButton().removeStyleName("active");
						}
						if (menuItem.getSubMenuContent() != null) {
							if (menuItem.getButton().getCaption().contains(VaadinIcons.ANGLE_DOWN.getHtml())) {
								menuItem.getButton().setCaption(menuItem.getButton().getCaption().replaceAll(VaadinIcons.ANGLE_DOWN.getHtml(), VaadinIcons.ANGLE_LEFT.getHtml()));
							}
							if (menuItem.getSubMenuContent().getStyleName().contains("open")) {
								menuItem.getSubMenuContent().removeStyleName("open");
							}
						}
					}
				}
			}
		}
		return foundActiveButton;
	}
}