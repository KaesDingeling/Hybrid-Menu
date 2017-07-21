package kaesdingeling.hybridmenu.data;

import com.vaadin.navigator.View;
import com.vaadin.server.Resource;
import kaesdingeling.hybridmenu.enums.EMenuPosition;

/**
 * Created by appreciated on 09.07.2017.
 */
public class MenuItemBuilder {

    final MenuItem item;

    private MenuItemBuilder(EMenuPosition position, String title, Resource icon, Class<? extends View> pageClass, boolean b) {
        item = new MenuItem(title, icon, pageClass, b);
    }

    public MenuItemBuilder(EMenuPosition position, Resource resource, boolean b) {
        item = new MenuItem(resource, b);
    }

    public static MenuItemBuilder get(String title, Resource icon, Class<? extends View> pageClass, boolean b) {
        return new MenuItemBuilder(null, title, icon, pageClass, b);
    }

    public MenuItemBuilder withSubMenuItem(EMenuPosition position, String title, Resource icon, Class<? extends View> pageClass, boolean b) {
        item.addSubMenuItem(new MenuItem(title, icon, pageClass, b));
        return this;
    }

    public MenuItemBuilder withStyleName(String s) {
        return this;
    }

    public static MenuItemBuilder get(EMenuPosition top, Resource themeResource, boolean b) {
        return new MenuItemBuilder(top, themeResource, b);
    }

    public MenuItem build() {
        return item;
    }

    public MenuItemBuilder withSubMenuItem(MenuItem item) {
        this.item.addSubMenuItem(item);
        return this;
    }

    public MenuItemBuilder withSubMenuItem(String title, Resource icon, Class<? extends View> pageClass, boolean b) {
        item.addSubMenuItem(new MenuItem(title, icon, pageClass, b));
        return this;
    }
}
