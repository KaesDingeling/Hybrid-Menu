package kaesdingeling.hybridmenu.menu.variants;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;
import kaesdingeling.hybridmenu.data.MenuItem;
import kaesdingeling.hybridmenu.enums.EMenuItemPosition;
import kaesdingeling.hybridmenu.enums.ETopMenuPosition;

import static kaesdingeling.hybridmenu.styles.HybridMenuStyles.*;

/**
 * Created by appreciated on 14.07.2017.
 */
public class HybridMenuTypeCombined extends HybridMenuVariant {

    private CssLayout topMenu;
    private CssLayout leftMenu;
    private Label menuTitle;
    private Button menuResize;
    private Component[] components;

    @Override
    public void onInit() {
        menuTitle = new Label();
        menuResize = new Button();
        menuResize.addStyleName(ValoTheme.BUTTON_BORDERLESS);
        topMenu = new CssLayout();
        leftMenu = new CssLayout();
        topMenu.addStyleName(MENU_TOP);
        leftMenu.addStyleName(MENU_LEFT);
        leftMenu.addStyleName(animationSpeed.getStyle());
        components = new Component[]{topMenu, leftMenu};

        menuTitle.setCaptionAsHtml(true);
        menuTitle.setCaption("<b>Hybrid</b> Menu");
        menuTitle.addStyleName(MENU_TITLE);
        menuTitle.addStyleName(ETopMenuPosition.LEFT.toString());

        menuResize.setIcon(VaadinIcons.ANGLE_LEFT);
        menuResize.addStyleName(ETopMenuPosition.LEFT.toString());
        menuResize.addClickListener(e -> {
            if (menu.getStyleName().contains(MENU_MINIMAL)) {
                menuResize.setIcon(VaadinIcons.ANGLE_LEFT);
                menu.removeStyleName(MENU_MINIMAL);
            } else {
                menuResize.setIcon(VaadinIcons.ANGLE_RIGHT);
                menu.addStyleName(MENU_MINIMAL);
            }
        });
        topMenu.addComponents(menuTitle, menuResize);
    }

    @Override
    public String getStyle() {
        return MENU_TYPE_COMBINED;
    }

    public Component[] getComponents() {
        return components;
    }

    @Override
    public void removeComponent(Component component) {
        if (component != null) {
            if (topMenu.getComponentIndex(component) != -1) { // -1 will be returned if the component is not a child
                topMenu.removeComponent(component);
            }
            if (leftMenu.getComponentIndex(component) != -1) { // if a component was added to both layout both will be removed
                leftMenu.removeComponent(component);
            }
        }
    }

    @Override
    public void addItem(MenuItem menuItem) {
        if (menuItem.getTargetClass() != null) {
            menu.getNavigator().addView(menuItem.getTitle(), menuItem.getTargetClass());
        }
        EMenuItemPosition position = menuItem.getMenuItemPosition();
        if (position == EMenuItemPosition.LEFT || position == EMenuItemPosition.COMBINED) {
            leftMenu.addComponent(getProvider().getComponent(menuItem));
        }
        if (position == EMenuItemPosition.TOP || position == EMenuItemPosition.COMBINED) {
            topMenu.addComponent(getProvider().getComponent(menuItem));
        }
    }
}
