package kaesdingeling.hybridmenu.data;

import com.vaadin.navigator.View;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import kaesdingeling.hybridmenu.HybridMenu;
import kaesdingeling.hybridmenu.enums.EMenuPosition;

/**
 * Created by Johannes on 09.07.2017.
 */
public class MenuItemBuilder {

    MenuItem item;
    HybridMenu menu;

    private MenuItemBuilder(EMenuPosition top, String home, FontAwesome home1, Class<? extends View> homePageClass, boolean b) {
        HybridMenu menu = new HybridMenu();
        item = menu.createItem(top, home, homePageClass, b);
    }

    public MenuItemBuilder(EMenuPosition top, ThemeResource themeResource, boolean b) {
        HybridMenu menu = new HybridMenu();
        item = menu.createItem(top, themeResource, b);
    }

    public static MenuItemBuilder get(EMenuPosition top, String home, FontAwesome home1, Class<? extends View> homePageClass, boolean b) {
        return new MenuItemBuilder(top, home, home1, homePageClass, b);
    }

    public MenuItemBuilder withSubMenuItem(EMenuPosition top, String home, FontAwesome home1, Class<? extends View> homePageClass, boolean b) {
        item.addSubMenuItem(menu.createItem(top, home, home1, homePageClass, b));
        return this;
    }

    public MenuItemBuilder withStyleName(String s) {
        return this;
    }

    public static MenuItemBuilder get(EMenuPosition top, ThemeResource themeResource, boolean b) {
        return new MenuItemBuilder(top, themeResource, b);
    }

    public MenuItem build() {
        return item;
    }
}
