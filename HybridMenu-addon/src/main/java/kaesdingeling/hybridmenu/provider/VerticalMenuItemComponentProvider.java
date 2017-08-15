package kaesdingeling.hybridmenu.provider;

import com.vaadin.event.LayoutEvents;
import com.vaadin.server.FontIcon;
import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;
import kaesdingeling.hybridmenu.data.MenuItem;

import static kaesdingeling.hybridmenu.styles.HybridMenuStyles.*;

/**
 * Created by appreciated on 14.07.2017.
 */
public class VerticalMenuItemComponentProvider implements MenuItemComponentProvider {

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
            layout.addStyleName(MENU_SUBMENU_MASTER);

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
        layout.addStyleName(MENU_BUTTON);
        layout.setSpacing(false);
        layout.setWidth(100, Sizeable.Unit.PERCENTAGE);
        Component resourceHolder = getResourceHolder(item);

        HorizontalLayout wrapper = new HorizontalLayout(resourceHolder);
        wrapper.addStyleName(MENU_BUTTON_RESOURCE);

        Label label = new Label(item.getTitle());
        label.addStyleName(MENU_BUTTON_CAPTION);

        layout.addComponent(wrapper);
        layout.addComponent(label);
        layout.setComponentAlignment(label, Alignment.MIDDLE_LEFT);
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

    private Component getResourceHolder(MenuItem item) {
        Resource resource = item.getIcon();
        if (resource instanceof FontIcon) {
            return new Label(((FontIcon) resource).getHtml(), ContentMode.HTML);
        } else if (resource != null) {
            return new Image(null, item.getIcon());
        } else {
            return new Label();
        }
    }
}
