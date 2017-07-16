package kaesdingeling.hybridmenu.menu;

import com.vaadin.navigator.View;
import com.vaadin.server.FontIcon;
import kaesdingeling.hybridmenu.data.MenuItem;
import kaesdingeling.hybridmenu.enums.EMenuItemPosition;
import kaesdingeling.hybridmenu.enums.EMenuPosition;

/**
 * Created by appreciated on 09.07.2017.
 */
public class HybridMenuBuilder {
    HybridMenu hybridMenu;

    private HybridMenuBuilder(HybridMenu hybridMenu) {
        this.hybridMenu = hybridMenu;
    }

    public static HybridMenuBuilder get() {
        return new HybridMenuBuilder(new HybridMenu());
    }


    public HybridMenuBuilder withItem(EMenuItemPosition menuPosition, String title, Class<? extends View> _class,
                                      boolean addItem) {
        hybridMenu.addItem(new MenuItem(menuPosition, title, _class, addItem));
        return this;
    }

    public HybridMenuBuilder withItem(EMenuItemPosition menuPosition, FontIcon icon, boolean addItem) {
        hybridMenu.addItem(new MenuItem(menuPosition, icon, addItem));
        return this;
    }

    public HybridMenuBuilder withItem(EMenuItemPosition menuPosition, String title, FontIcon icon, Class<? extends View> _class,
                                      boolean addItem) {
        hybridMenu.addItem(new MenuItem(menuPosition, title, icon, _class, addItem));
        return this;
    }

    public HybridMenuBuilder withItem(EMenuItemPosition menuPosition, String title, FontIcon icon, Class<? extends View> _class,
                                      String navigateTo, boolean addItem) {
        hybridMenu.addItem(new MenuItem(menuPosition, title, icon, _class, navigateTo, addItem));
        return this;
    }

    public HybridMenuBuilder withItemTitle(EMenuItemPosition menuPosition, String title, boolean addItem) {
        hybridMenu.addItem(new MenuItem(menuPosition, title, addItem));
        return this;
    }

    public HybridMenu build() {
        hybridMenu.build();
        return hybridMenu;
    }

    public HybridMenuBuilder withItem(MenuItem home) {
        hybridMenu.addItem(home);
        return this;
    }
}
