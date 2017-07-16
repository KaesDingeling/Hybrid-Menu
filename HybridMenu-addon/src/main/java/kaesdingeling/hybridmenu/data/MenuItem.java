package kaesdingeling.hybridmenu.data;

import com.vaadin.navigator.View;
import com.vaadin.server.Resource;
import kaesdingeling.hybridmenu.enums.EMenuItemPosition;
import kaesdingeling.hybridmenu.interfaces.MenuItemClickListener;

import java.util.LinkedHashSet;
import java.util.Set;

public class MenuItem {

    private EMenuItemPosition menuItemPosition;
    private Class<? extends View> targetClass;
    private String navigateTo;
    private boolean allowNavigateToSamePage = false;
    private boolean allowClickToNavigate = true;
    private Set<MenuItem> childItems = new LinkedHashSet<>();
    private MenuItem parent;
    private String title;
    private Class<? extends View> aClass;
    private boolean addItem;
    private Resource icon;
    private Class<? extends View> homePageClass;
    private boolean b;
    private MenuItemClickListener listener;

    public MenuItem(String title, Resource icon, Class<? extends View> homepageclass, boolean b) {
        this.title = title;
        this.icon = icon;
        this.homePageClass = homepageclass;
        this.b = b;
    }

    public MenuItem(Resource icon, boolean b) {
        this.icon = icon;
        this.b = b;
    }

    public MenuItem(EMenuItemPosition menuItemPosition, String title, Class<? extends View> aClass, boolean addItem) {
        this.menuItemPosition = menuItemPosition;
        this.title = title;
        this.aClass = aClass;
        this.addItem = addItem;
    }

    public MenuItem(EMenuItemPosition menuItemPosition, Resource icon, boolean addItem) {
        this.menuItemPosition = menuItemPosition;
        this.icon = icon;
        this.addItem = addItem;
    }

    public MenuItem(EMenuItemPosition menuItemPosition, String title, Resource icon, Class<? extends View> aClass, boolean addItem) {
        this.menuItemPosition = menuItemPosition;
        this.title = title;
        this.icon = icon;
        this.aClass = aClass;
        this.addItem = addItem;
    }

    public MenuItem(EMenuItemPosition menuItemPosition, String title, Resource icon, Class<? extends View> aClass, String navigateTo, boolean addItem) {
        this.menuItemPosition = menuItemPosition;
        this.title = title;
        this.icon = icon;
        this.aClass = aClass;
        this.navigateTo = navigateTo;
        this.addItem = addItem;
    }

    public MenuItem(EMenuItemPosition menuItemPosition, String title, boolean addItem) {
        this.menuItemPosition = menuItemPosition;
        this.title = title;
        this.addItem = addItem;
    }

    public Class<? extends View> getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class<? extends View> targetClass) {
        this.targetClass = targetClass;
    }

    public MenuItem getParent() {
        return parent;
    }

    public void setParent(MenuItem parent) {
        this.parent = parent;
    }

    public boolean isAllowClickToNavigate() {
        return allowClickToNavigate;
    }

    public void setAllowClickToNavigate(boolean allowClickToNavigate) {
        this.allowClickToNavigate = allowClickToNavigate;
    }

    public String getNavigateTo() {
        return navigateTo;
    }

    public void setNavigateTo(String navigateTo) {
        this.navigateTo = navigateTo;
    }

    public boolean isAllowNavigateToSamePage() {
        return allowNavigateToSamePage;
    }

    public void setAllowNavigateToSamePage(boolean allowNavigateToSamePage) {
        this.allowNavigateToSamePage = allowNavigateToSamePage;
    }

    public Set<MenuItem> getChildItems() {
        return childItems;
    }

    public void setChildItems(Set<MenuItem> childItems) {
        this.childItems = childItems;
    }

    public void addSubMenuItem(MenuItem subMenuItem) {
        childItems.add(subMenuItem);
    }

    public Resource getIcon() {
        return icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void onClick() {
        if (listener != null) {
            listener.onClick();
        }
    }

    public void setOnClickListener(MenuItemClickListener listener) {
        this.listener = listener;
    }

    public EMenuItemPosition getMenuItemPosition() {
        return menuItemPosition;
    }
}