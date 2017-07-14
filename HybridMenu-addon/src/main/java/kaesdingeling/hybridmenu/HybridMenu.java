package kaesdingeling.hybridmenu;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import kaesdingeling.hybridmenu.component.DefaultMenuItemComponentProvider;
import kaesdingeling.hybridmenu.data.MenuItem;
import kaesdingeling.hybridmenu.enums.EMenuNavigator;
import kaesdingeling.hybridmenu.enums.EMenuPosition;
import kaesdingeling.hybridmenu.enums.EMenuType;
import kaesdingeling.hybridmenu.enums.ETopMenuPosition;
import kaesdingeling.hybridmenu.interfaces.MenuItemComponentProvider;
import kaesdingeling.hybridmenu.page.DefaultPage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HybridMenu extends CssLayout {
    private static final long serialVersionUID = 1L;


    @SuppressWarnings("unused")
    private EMenuNavigator naviType = null;
    private EMenuType menuType = null;

    private CssLayout leftMenu = null;
    private CssLayout topMenu = null;
    private CssLayout content = null;

    /* Intern Data */
    private Set<MenuItem> leftMenuList = null;
    private Set<MenuItem> topMenuList = null;

    private HashMap<MenuItem, Component> components = new HashMap<>();

    private HashMap<Class<? extends View>, View> instances = new HashMap<>();

    private MenuItemComponentProvider provider = new DefaultMenuItemComponentProvider();

    private boolean allowChangeView = true;

    /* Default Content */
    private Label menuTitle = new Label();
    private NativeButton menuResize = new NativeButton();

    public HybridMenu() {
        build(EMenuNavigator.AUTO, EMenuType.COMBINED, false);
    }

    public HybridMenu(boolean customNavigator) {
        build(EMenuNavigator.AUTO, EMenuType.COMBINED, customNavigator);
    }

    public HybridMenu(EMenuNavigator naviType) {
        if (naviType == null) {
            naviType = EMenuNavigator.AUTO;
        }
        build(naviType, EMenuType.COMBINED, false);
    }

    public HybridMenu(EMenuNavigator naviType, boolean ownNavigator) {
        if (naviType == null) {
            naviType = EMenuNavigator.AUTO;
        }
        build(naviType, EMenuType.COMBINED, ownNavigator);
    }

    public HybridMenu(EMenuType menuType) {
        if (menuType == null) {
            menuType = EMenuType.COMBINED;
        }
        build(EMenuNavigator.AUTO, menuType, false);
    }

    public HybridMenu(EMenuType menuType, boolean ownNavigator) {
        if (menuType == null) {
            menuType = EMenuType.COMBINED;
        }
        build(EMenuNavigator.AUTO, menuType, ownNavigator);
    }

    public HybridMenu(EMenuNavigator naviType, EMenuType menuType) {
        if (menuType == null) {
            menuType = EMenuType.COMBINED;
        }
        if (naviType == null) {
            naviType = EMenuNavigator.AUTO;
        }
        build(naviType, menuType, false);
    }

    public HybridMenu(EMenuNavigator naviType, EMenuType menuType, boolean ownNavigator) {
        if (menuType == null) {
            menuType = EMenuType.COMBINED;
        }
        if (naviType == null) {
            naviType = EMenuNavigator.AUTO;
        }
        build(naviType, menuType, ownNavigator);
    }

    private void build(EMenuNavigator naviType, EMenuType menuType, boolean customNavigator) {
        if (menuType.equals(EMenuType.COMBINED)) {
            topMenu = new CssLayout();
            leftMenu = new CssLayout();
            topMenu.setStyleName("kdHybridMenuTop");
            leftMenu.setStyleName("kdHybridMenuLeft");
            addComponents(topMenu, leftMenu);
            setStyleName("kdHybridMenu");
            if (naviType.equals(EMenuNavigator.AUTO)) {
                content = new CssLayout();
                content.setStyleName("kdHybridMenuBody");
                if (!customNavigator) {
                    new Navigator(UI.getCurrent(), content);
                }
                setErrorView(DefaultPage.class);
                addComponent(content);
            }
            menuTitle.setCaptionAsHtml(true);
            menuTitle.setCaption("<b>Hybrid</b> Menu");
            menuTitle.setStyleName("menuTitle");
            menuTitle.addStyleName(ETopMenuPosition.LEFT.toString());

            menuResize.setIcon(VaadinIcons.ANGLE_LEFT);
            menuResize.setStyleName(ETopMenuPosition.LEFT.toString());
            menuResize.addClickListener(e -> {
                if (getStyleName().contains("minimalView")) {
                    menuResize.setIcon(VaadinIcons.ANGLE_LEFT);
                    removeStyleName("minimalView");
                } else {
                    menuResize.setIcon(VaadinIcons.ANGLE_RIGHT);
                    addStyleName("minimalView");
                }
            });
            topMenu.addComponents(menuTitle, menuResize);
        } else {
            naviType = EMenuNavigator.MANUALL;
            if (menuType.equals(EMenuType.TOP)) {
                topMenu = new CssLayout();
                leftMenuList = new HashSet<>();
                setStyleName("kdHybridMenuTopMenu");
            } else {
                leftMenu = new CssLayout();
                topMenuList = new HashSet<MenuItem>();
                setStyleName("kdHybridMenuLeftMenu");
            }
        }
        if (naviType.equals(EMenuNavigator.SEMI_AUTOMATIC) || naviType.equals(EMenuNavigator.AUTO)) {

            UI.getCurrent().getNavigator().addViewChangeListener(new ViewChangeListener() {
                private static final long serialVersionUID = 1L;

                @Override
                public boolean beforeViewChange(ViewChangeEvent event) {
                    return allowChangeView;
                }
            });
        }
        this.menuType = menuType;
        this.naviType = naviType;
    }



    public void navigateTo(String viewName) {
        UI.getCurrent().getNavigator().navigateTo(viewName);
    }

    public void addItem(MenuItem item) {
        components.put(item, provider.getComponent(item));
        addItem(EMenuPosition.LEFT, components.get(item));
        item.setOnClickListener(() -> navigateTo(item));
    }

    public void addItem(EMenuPosition menuPosition, Component component) {
        if (menuType.equals(EMenuType.COMBINED)) {
            if (menuPosition == null) {
                menuPosition = EMenuPosition.LEFT;
            }
            if (menuPosition.equals(EMenuPosition.TOP)) {
                topMenu.addComponent(component);
            } else {
                leftMenu.addComponent(component);
            }
        } else {
            addComponent(component);
        }
    }

    public void navigateTo(Class<? extends View> _class) {
        this.content.removeAllComponents();
        this.content.addComponent((Component) instances.get(_class));
    }

    public void navigateTo(MenuItem item) {
        navigateTo(item.getTargetClass());
    }

    public void removeItem(Component component) {
        if (component != null) {
            if (topMenu.getComponentIndex(component) != -1) { // -1 will be returned if the component is not a child
                topMenu.removeComponent(component);
            }
            if (leftMenu.getComponentIndex(component) != -1) { // if a component was added to both layout both will be removed
                leftMenu.removeComponent(component);
            }
        }
    }

    public MenuItemComponentProvider getProvider() {
        return provider;
    }

    public void setProvider(MenuItemComponentProvider provider) {
        this.provider = provider;
    }

    public Label getTopMenuLabel() {
        return menuTitle;
    }

    public CssLayout getBody() {
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
}