package kaesdingeling.hybridmenu.menu;

import com.vaadin.navigator.View;
import com.vaadin.server.FontIcon;
import com.vaadin.ui.Component;
import kaesdingeling.hybridmenu.data.CustomMenuItem;
import kaesdingeling.hybridmenu.data.MenuItem;
import kaesdingeling.hybridmenu.enums.EAlignment;
import kaesdingeling.hybridmenu.enums.EMenuItemPosition;
import kaesdingeling.hybridmenu.enums.EMenuPosition;
import kaesdingeling.hybridmenu.enums.EMenuType;
import kaesdingeling.hybridmenu.menu.variants.HybridMenuVariant;

/**
 * Created by appreciated on 09.07.2017.
 */
public class HybridMenuBuilder {
    private HybridMenu hybridMenu;

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

    public HybridMenuBuilder withItem(String title, FontIcon icon, Class<? extends View> _class,
                                      boolean addItem) {
        hybridMenu.addItem(new MenuItem(title, icon, _class, addItem));
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
        return hybridMenu.build();
    }

    public HybridMenuBuilder withItem(MenuItem home) {
        hybridMenu.addItem(home);
        return this;
    }

    public HybridMenuBuilder withMenuType(EMenuType top) {
        hybridMenu.setMenuType(top);
        return this;
    }

    /**
     * This overrides the MenuType set with "withMenuType"
     * @param variant
     * @return
     */
    public HybridMenuBuilder withCustomMenuVariant(HybridMenuVariant variant) {
        hybridMenu.setMenuVariant(variant);
        return this;
    }

    public HybridMenuBuilder withCustomComponent(Component component, EAlignment top) {
        hybridMenu.addCustomMenuItem(component, top);
        return this;
    }

    public HybridMenuBuilder withCustomComponent(Component component, EMenuPosition position, EAlignment top) {
        hybridMenu.addCustomMenuItem(component, position, top);
        return this;
    }

    public HybridMenuBuilder withCustomComponent(CustomMenuItem component) {
        hybridMenu.addCustomMenuItem(component);
        return this;
    }

}
