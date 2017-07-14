package kaesdingeling.hybridmenu;

import com.vaadin.navigator.View;
import com.vaadin.server.FontIcon;
import kaesdingeling.hybridmenu.data.MenuItem;
import kaesdingeling.hybridmenu.enums.EMenuNavigator;
import kaesdingeling.hybridmenu.enums.EMenuPosition;
import kaesdingeling.hybridmenu.enums.EMenuType;

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

    public static HybridMenuBuilder get(boolean customNavigator) {
        return new HybridMenuBuilder(new HybridMenu(customNavigator));
    }

    public HybridMenuBuilder get(EMenuNavigator naviType) {
        return new HybridMenuBuilder(new HybridMenu(naviType));
    }

    public HybridMenuBuilder get(EMenuNavigator naviType, boolean ownNavigator) {
        return new HybridMenuBuilder(new HybridMenu(naviType, ownNavigator));
    }

    public HybridMenuBuilder get(EMenuType menuType) {
        return new HybridMenuBuilder(new HybridMenu(menuType));
    }

    public HybridMenuBuilder get(EMenuType menuType, boolean ownNavigator) {
        return new HybridMenuBuilder(new HybridMenu(menuType, ownNavigator));
    }

    public HybridMenuBuilder get(EMenuNavigator naviType, EMenuType menuType) {
        return new HybridMenuBuilder(new HybridMenu(naviType, menuType));
    }

    public HybridMenuBuilder get(EMenuNavigator naviType, EMenuType menuType, boolean ownNavigator) {
        return new HybridMenuBuilder(new HybridMenu(naviType, menuType, ownNavigator));
    }


    public HybridMenuBuilder withItem(EMenuPosition menuPosition, String title, Class<? extends View> _class,
                                      boolean addItem) {
        hybridMenu.addItem(new MenuItem(menuPosition, title, _class, addItem));
        return this;
    }

    public HybridMenuBuilder withItem(EMenuPosition menuPosition, FontIcon icon, boolean addItem) {
        hybridMenu.addItem(new MenuItem(menuPosition, icon, addItem));
        return this;
    }

    public HybridMenuBuilder withItem(EMenuPosition menuPosition, String title, FontIcon icon, Class<? extends View> _class,
                                      boolean addItem) {
        hybridMenu.addItem(new MenuItem(menuPosition, title, icon, _class, addItem));
        return this;
    }

    public HybridMenuBuilder withItem(EMenuPosition menuPosition, String title, FontIcon icon, Class<? extends View> _class,
                                      String navigateTo, boolean addItem) {
        hybridMenu.addItem(new MenuItem(menuPosition, title, icon, _class, navigateTo, addItem));
        return this;
    }

    public HybridMenuBuilder withItemTitle(EMenuPosition menuPosition, String title, boolean addItem) {
        hybridMenu.addItem(new MenuItem(menuPosition, title, addItem));
        return this;
    }

    public HybridMenu build() {
        return hybridMenu;
    }

    public HybridMenuBuilder withItem(MenuItem home) {
        hybridMenu.addItem(home);
        return this;
    }
}
