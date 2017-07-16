package kaesdingeling.hybridmenu.component;

import com.vaadin.event.LayoutEvents;
import com.vaadin.server.Sizeable;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.*;
import kaesdingeling.hybridmenu.data.MenuItem;
import kaesdingeling.hybridmenu.interfaces.MenuItemComponentProvider;

import static kaesdingeling.hybridmenu.styles.HybridMenuStyles.MENU_SUBMENU;
import static kaesdingeling.hybridmenu.styles.HybridMenuStyles.MENU_SUBMENU_OPEN;

/**
 * Created by appreciated on 14.07.2017.
 */
public class DefaultMenuItemComponentProvider implements MenuItemComponentProvider {

    @Override
    public Component getComponent(MenuItem item) {
        if (item.getChildItems() == null) {
            return getButton(item);
        } else {
            VerticalLayout layout = new VerticalLayout();
            layout.setMargin(false);
            layout.setSpacing(false);
            layout.setWidth(100, Sizeable.Unit.PERCENTAGE);
            layout.setHeightUndefined();

            //Parent Button
            HorizontalLayout parentButton = getButton(item);
            VerticalLayout submenu = new VerticalLayout();
            submenu.setMargin(false);
            submenu.setSpacing(false);
            submenu.addStyleName(MENU_SUBMENU);
            parentButton.addLayoutClickListener((LayoutEvents.LayoutClickListener) layoutClickEvent -> {
                if (layoutClickEvent.getButton() == MouseEventDetails.MouseButton.LEFT) {
                    if (!submenu.getStyleName().contains(MENU_SUBMENU_OPEN)) {
                        submenu.addStyleName(MENU_SUBMENU_OPEN);
                    } else {
                        submenu.removeStyleName(MENU_SUBMENU_OPEN);
                    }
                }
            });
            layout.addComponent(parentButton);
            for (MenuItem child : item.getChildItems()) {
                submenu.addComponent(getComponent(child)); // recursion
            }
            layout.addComponent(submenu);
            return layout;
        }
    }

    private HorizontalLayout getButton(MenuItem item) {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSpacing(false);
        layout.setWidth(100, Sizeable.Unit.PERCENTAGE);
        Image image = new Image(null, item.getIcon());
        image.setWidth(50, Sizeable.Unit.PIXELS);
        Label label = new Label(item.getTitle());
        layout.addComponent(image);
        layout.addComponent(label);
        layout.setExpandRatio(label, 1.0f);
        if (item.isAllowClickToNavigate()) {
            layout.addLayoutClickListener((LayoutEvents.LayoutClickListener) layoutClickEvent -> {
                if (layoutClickEvent.getButton() == MouseEventDetails.MouseButton.LEFT) {
                    item.onClick();
                }
            });
        }
        return layout;
    }
}
