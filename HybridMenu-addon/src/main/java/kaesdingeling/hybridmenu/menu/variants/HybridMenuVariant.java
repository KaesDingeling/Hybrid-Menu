package kaesdingeling.hybridmenu.menu.variants;


import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import kaesdingeling.hybridmenu.provider.VerticalMenuItemComponentProvider;
import kaesdingeling.hybridmenu.data.CustomMenuItem;
import kaesdingeling.hybridmenu.data.MenuItem;
import kaesdingeling.hybridmenu.enums.EAnimationSpeed;
import kaesdingeling.hybridmenu.enums.EAnimationSpeedSubMenu;
import kaesdingeling.hybridmenu.enums.EMenuNavigator;
import kaesdingeling.hybridmenu.provider.MenuItemComponentProvider;
import kaesdingeling.hybridmenu.menu.HybridMenu;

import java.util.List;

import static kaesdingeling.hybridmenu.styles.HybridMenuStyles.MENU_BODY;

/**
 * Created by appreciated on 14.07.2017.
 */
public abstract class HybridMenuVariant {

    private HybridMenu menu;
    private EAnimationSpeed animationSpeed;
    private EAnimationSpeedSubMenu subMenuAnimationSpeed;
    private EMenuNavigator navigator;

    public void init(HybridMenu menu, EAnimationSpeed animationSpeed, EAnimationSpeedSubMenu subMenuAnimationSpeed, EMenuNavigator navigator) {
        this.menu = menu;
        this.animationSpeed = animationSpeed;
        this.subMenuAnimationSpeed = subMenuAnimationSpeed;
        this.navigator = navigator;
        onInit();
    }

    protected abstract void onInit();

    public abstract String getStyle();

    public abstract Component[] getComponents();

    public ComponentContainer getContentComponent() {
        CssLayout layout = new CssLayout();
        layout.addStyleName(animationSpeed.getStyle());
        layout.addStyleName(MENU_BODY);
        return layout;
    }

    public abstract void removeComponent(Component component);

    public MenuItemComponentProvider getProvider() {
        return new VerticalMenuItemComponentProvider();
    }

    public abstract void addItem(MenuItem menuItem);

    public abstract void addCustomItems(List<CustomMenuItem> customItems);

    public HybridMenu getMenu() {
        return menu;
    }

    public void setMenu(HybridMenu menu) {
        this.menu = menu;
    }

    public EAnimationSpeed getAnimationSpeed() {
        return animationSpeed;
    }

    public void setAnimationSpeed(EAnimationSpeed animationSpeed) {
        this.animationSpeed = animationSpeed;
    }

    public EAnimationSpeedSubMenu getSubMenuAnimationSpeed() {
        return subMenuAnimationSpeed;
    }

    public void setSubMenuAnimationSpeed(EAnimationSpeedSubMenu subMenuAnimationSpeed) {
        this.subMenuAnimationSpeed = subMenuAnimationSpeed;
    }

    public EMenuNavigator getNavigator() {
        return navigator;
    }

    public void setNavigator(EMenuNavigator navigator) {
        this.navigator = navigator;
    }
}
