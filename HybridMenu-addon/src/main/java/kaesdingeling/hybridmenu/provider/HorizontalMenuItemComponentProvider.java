package kaesdingeling.hybridmenu.provider;

import com.vaadin.ui.Component;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.themes.ValoTheme;
import kaesdingeling.hybridmenu.data.MenuItem;

/**
 * Created by appreciated on 14.07.2017.
 */
public class HorizontalMenuItemComponentProvider implements MenuItemComponentProvider {

    @Override
    public Component getComponent(final MenuItem item) {
        MenuBar bar = new MenuBar();
        bar.addStyleName(ValoTheme.MENUBAR_BORDERLESS);
        if (item.getChildItems().size() > 0) {
            MenuBar.MenuItem menuItem = bar.addItem(item.getTitle(), item.getIcon(), null);
            item.getChildItems().stream().forEach(subItem -> addChildren(menuItem, subItem));
        } else {
            bar.addItem(item.getTitle(), item.getIcon(), command -> item.onClick());
        }
        return bar;
    }

    public void addChildren(MenuBar.MenuItem menuItem, MenuItem item) {
        if (item.getChildItems().size() > 0) {
            MenuBar.MenuItem subItem = menuItem.addItem(item.getTitle(), item.getIcon(), null);
            item.getChildItems().stream().forEach(subChild -> addChildren(subItem, subChild));  // Recursion
        } else {
            menuItem.addItem(item.getTitle(), item.getIcon(), menuItem1 -> item.onClick());
        }
    }

}
