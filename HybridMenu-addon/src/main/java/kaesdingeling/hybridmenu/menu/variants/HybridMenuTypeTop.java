package kaesdingeling.hybridmenu.menu.variants;

import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import kaesdingeling.hybridmenu.provider.HorizontalMenuItemComponentProvider;
import kaesdingeling.hybridmenu.data.CustomMenuItem;
import kaesdingeling.hybridmenu.data.MenuItem;
import kaesdingeling.hybridmenu.provider.MenuItemComponentProvider;

import java.util.List;

import static kaesdingeling.hybridmenu.styles.HybridMenuStyles.MENU_TOP;
import static kaesdingeling.hybridmenu.styles.HybridMenuStyles.MENU_TYPE_TOP;

/**
 * Created by appreciated on 14.07.2017.
 */
public class HybridMenuTypeTop extends HybridMenuVariant {

    private CssLayout topMenu;
    private Component[] components;

    @Override
    public void onInit() {
        topMenu = new CssLayout();
        topMenu.addStyleName(MENU_TOP);
        components = new Component[]{topMenu};
    }

    @Override
    public String getStyle() {
        return MENU_TYPE_TOP;
    }

    @Override
    public Component[] getComponents() {
        return components;
    }

    @Override
    public void removeComponent(Component component) {

    }

    @Override
    public MenuItemComponentProvider getProvider() {
        return new HorizontalMenuItemComponentProvider();
    }

    @Override
    public void addItem(MenuItem menuItem) {
        topMenu.addComponent(getProvider().getComponent(menuItem));
    }

    @Override
    public void addCustomItems(List<CustomMenuItem> customItems) {

    }

}
