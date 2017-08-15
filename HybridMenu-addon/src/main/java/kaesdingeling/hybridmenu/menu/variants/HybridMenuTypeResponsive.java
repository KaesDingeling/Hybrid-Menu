package kaesdingeling.hybridmenu.menu.variants;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;
import kaesdingeling.hybridmenu.data.CustomMenuItem;
import kaesdingeling.hybridmenu.data.MenuItem;
import kaesdingeling.hybridmenu.enums.EAlignment;
import kaesdingeling.hybridmenu.enums.EMenuItemPosition;
import kaesdingeling.hybridmenu.enums.EMenuPosition;
import kaesdingeling.hybridmenu.enums.ETopMenuPosition;
import kaesdingeling.hybridmenu.utils.StyleName;

import java.util.List;

import static kaesdingeling.hybridmenu.styles.HybridMenuStyles.*;

/**
 * Created by appreciated on 14.07.2017.
 */
public class HybridMenuTypeResponsive extends HybridMenuVariant {

    private CssLayout topMenu = new CssLayout();
    private CssLayout topMenuHeader = new CssLayout();
    private CssLayout topMenuContent = new CssLayout();
    private CssLayout topMenuFooter = new CssLayout();

    private CssLayout leftMenu = new CssLayout();
    private CssLayout leftMenuHeader = new CssLayout();
    private CssLayout leftMenuContent = new CssLayout();
    private CssLayout leftMenuFooter = new CssLayout();

    private Label menuTitle;
    private Button menuToggle;
    private Component[] components;

    @Override
    public void onInit() {
        menuTitle = new Label();
        menuToggle = new Button();
        menuToggle.addStyleName(ValoTheme.BUTTON_BORDERLESS);
        topMenu.addStyleName(MENU_TOP);
        leftMenu.addStyleName(MENU_LEFT);
        leftMenu.addStyleName(getAnimationSpeed().getStyle());
        components = new Component[]{topMenu, leftMenu};

        leftMenuHeader.addStyleName(MENU_LEFT_HEADER);
        leftMenuContent.addStyleName(MENU_LEFT_CONTENT);
        leftMenuFooter.addStyleName(MENU_LEFT_FOOTER);

        menuTitle.setCaptionAsHtml(true);
        menuTitle.setCaption("<b>Hybrid</b> Menu");
        menuTitle.addStyleName(MENU_TITLE);
        menuTitle.addStyleName(ETopMenuPosition.LEFT.toString());

        menuToggle.setIcon(VaadinIcons.MENU);
        menuToggle.addStyleName(ETopMenuPosition.LEFT.toString());
        menuToggle.addClickListener(e -> {
            StyleName.toggle(leftMenu, MENU_RESPONSIVE_OPEN);
        });
        topMenuHeader.addComponents(menuToggle, menuTitle);
        topMenu.addStyleName("flex-row");
        leftMenu.addStyleName("flex-column");

        topMenuContent.addStyleNames("grow", "shrink");
        leftMenuContent.addStyleNames("grow", "shrink");

        topMenu.addComponents(topMenuHeader, topMenuContent, topMenuFooter);
        leftMenu.addComponents(leftMenuHeader, leftMenuContent, leftMenuFooter);
    }

    @Override
    public String getStyle() {
        return MENU_TYPE_RESPONSIVE;
    }

    public Component[] getComponents() {
        return components;
    }

    @Override
    public void removeComponent(Component component) {
        if (component != null) {
            if (topMenu.getComponentIndex(component) != -1) { // -1 will be returned if the provider is not a child
                topMenu.removeComponent(component);
            }
            if (leftMenu.getComponentIndex(component) != -1) { // if a provider was added to both layout both will be removed
                leftMenu.removeComponent(component);
            }
        }
    }

    @Override
    public void addItem(MenuItem menuItem) {
        if (menuItem.getTargetClass() != null) {
            getMenu().getNavigator().addView(menuItem.getTitle(), menuItem.getTargetClass());
        }
        EMenuItemPosition position = menuItem.getMenuItemPosition();
        if (position == EMenuItemPosition.LEFT || position == EMenuItemPosition.COMBINED) {
            leftMenuContent.addComponent(getProvider().getComponent(menuItem));
        }
        if (position == EMenuItemPosition.TOP || position == EMenuItemPosition.COMBINED) {
            leftMenuContent.addComponent(getProvider().getComponent(menuItem));
        }
    }

    @Override
    public void addCustomItems(List<CustomMenuItem> customItems) {
        customItems.stream().forEach(customMenuItem -> {
            Component component = customMenuItem.getComponent();
            addComponent(component, customMenuItem.getPosition(), customMenuItem.getAlignment());
        });
    }

    public void addComponent(Component component, EMenuPosition position, EAlignment alignment) {
        switch (position) {
            case TOP:
                switch (alignment) {
                    case LEFT:
                        topMenuHeader.addComponent(component);
                        break;
                    case RIGHT:
                        topMenuFooter.addComponent(component);
                        break;
                    default:
                        topMenuContent.addComponent(component);
                }
                break;
            case LEFT:
                component.setWidth(100, Sizeable.Unit.PERCENTAGE);
                switch (alignment) {
                    case TOP:
                        leftMenuHeader.addComponent(component);
                        break;
                    case BOTTOM:
                        leftMenuFooter.addComponent(component);
                        break;
                    default:
                        leftMenuContent.addComponent(component);
                }
                break;
        }
    }


}
