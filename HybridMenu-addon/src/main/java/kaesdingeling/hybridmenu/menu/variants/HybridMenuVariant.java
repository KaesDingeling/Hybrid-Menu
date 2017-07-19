package kaesdingeling.hybridmenu.menu.variants;


import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import kaesdingeling.hybridmenu.component.LeftMenuItemComponentProvider;
import kaesdingeling.hybridmenu.data.MenuItem;
import kaesdingeling.hybridmenu.enums.EAnimationSpeed;
import kaesdingeling.hybridmenu.enums.EAnimationSpeedSubMenu;
import kaesdingeling.hybridmenu.enums.EMenuNavigator;
import kaesdingeling.hybridmenu.interfaces.MenuItemComponentProvider;
import kaesdingeling.hybridmenu.menu.HybridMenu;

import static kaesdingeling.hybridmenu.styles.HybridMenuStyles.MENU_BODY;

/**
 * Created by appreciated on 14.07.2017.
 */
public abstract class HybridMenuVariant {

    public HybridMenu menu;
    public EAnimationSpeed animationSpeed;
    public EAnimationSpeedSubMenu subMenuAnimationSpeed;
    public EMenuNavigator navigator;

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
        return new LeftMenuItemComponentProvider();
    }

    public abstract void addItem(MenuItem menuItem);
}
