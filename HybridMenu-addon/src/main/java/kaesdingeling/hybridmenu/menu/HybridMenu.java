package kaesdingeling.hybridmenu.menu;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.UI;
import kaesdingeling.hybridmenu.component.DefaultMenuItemComponentProvider;
import kaesdingeling.hybridmenu.data.MenuItem;
import kaesdingeling.hybridmenu.enums.EAnimationSpeed;
import kaesdingeling.hybridmenu.enums.EAnimationSpeedSubMenu;
import kaesdingeling.hybridmenu.enums.EMenuNavigator;
import kaesdingeling.hybridmenu.enums.EMenuType;
import kaesdingeling.hybridmenu.interfaces.MenuItemComponentProvider;
import kaesdingeling.hybridmenu.menu.variants.HybridMenuVariant;
import kaesdingeling.hybridmenu.page.DefaultPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static kaesdingeling.hybridmenu.styles.HybridMenuStyles.MENU;

public class HybridMenu extends CssLayout {
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unused")
    private EMenuNavigator naviType = EMenuNavigator.AUTO; // Default Navigator Type
    private EMenuType menuType = EMenuType.COMBINED; // Default Variant
    private EAnimationSpeed animationSpeed = EAnimationSpeed.FAST; // Default Animation Speed
    private EAnimationSpeedSubMenu subMenuAnimationSpeed = EAnimationSpeedSubMenu.FAST; // Default Animation Speed
    private Navigator navigator;
    private ComponentContainer content;
    private HybridMenuVariant variant;
    private View defaultPage = new DefaultPage();

    List<MenuItem> items = new ArrayList<>();

    private HashMap<Class<? extends View>, View> instances = new HashMap<>();

    private MenuItemComponentProvider provider = new DefaultMenuItemComponentProvider();

    private boolean allowChangeView = true;

    public void build() {
        // Navigator need to be initalised first
        variant = menuType.getVariant();
        variant.init(this, animationSpeed, subMenuAnimationSpeed, naviType);

        content = variant.getContentComponent();

        navigator = new Navigator(UI.getCurrent(), content);
        navigator.setErrorView(defaultPage);

        items.stream().forEach(variant::addItem);
        Arrays.stream(variant.getComponents()).forEach(this::addComponent);

        addStyleName(MENU);
        addStyleName(subMenuAnimationSpeed.getStyle());
        addComponent(content);
        if (naviType.equals(EMenuNavigator.SEMI_AUTOMATIC) || naviType.equals(EMenuNavigator.AUTO)) {
            UI.getCurrent().getNavigator().addViewChangeListener(new ViewChangeListener() {
                private static final long serialVersionUID = 1L;

                @Override
                public boolean beforeViewChange(ViewChangeEvent event) {
                    return allowChangeView;
                }
            });
        }
    }

    public void navigateTo(String viewName) {
        UI.getCurrent().getNavigator().navigateTo(viewName);
    }

    public void addItem(MenuItem item) {
        item.setOnClickListener(() -> navigateTo(item.getTitle()));
        items.add(item);
    }

    public void removeItem(Component component) {
        variant.removeComponent(component);
    }

    public MenuItemComponentProvider getProvider() {
        return provider;
    }

    public void setProvider(MenuItemComponentProvider provider) {
        this.provider = provider;
    }

    public EAnimationSpeed getAnimationSpeed() {
        return animationSpeed;
    }

    public void setAnimationSpeed(EAnimationSpeed animationSpeed) {
        this.animationSpeed = animationSpeed;
    }

    public ComponentContainer getBody() {
        return content;
    }

    public void setAllowViewChange(boolean allowChangeView) {
        this.allowChangeView = allowChangeView;
    }

    public boolean isAllowViewChange() {
        return allowChangeView;
    }

    public void setErrorView(Class<? extends View> _class) {
        UI.getCurrent().getNavigator().setErrorView(_class);
    }

    public void addView(Class<? extends View> _class) {
        UI.getCurrent().getNavigator().addView(_class.getSimpleName(), _class);
    }

    public void removeView(Class<? extends View> _class) {
        UI.getCurrent().getNavigator().removeView(_class.getSimpleName());
    }

    public void setNaviType(EMenuNavigator naviType) {
        this.naviType = naviType;
    }

    public void setDefaultPage(View defaultPage) {
        this.defaultPage = defaultPage;
    }

    public Navigator getNavigator() {
        return navigator;
    }
}