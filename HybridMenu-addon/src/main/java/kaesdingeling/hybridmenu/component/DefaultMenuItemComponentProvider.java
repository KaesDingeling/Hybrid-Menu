package kaesdingeling.hybridmenu.component;

import com.vaadin.server.Sizeable;
import com.vaadin.ui.*;
import kaesdingeling.hybridmenu.data.MenuItem;
import kaesdingeling.hybridmenu.interfaces.MenuItemComponentProvider;

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
            layout.setWidth(100, Sizeable.Unit.PERCENTAGE);
            layout.setHeightUndefined();
            layout.addStyleName("menu-item-with-children");

            //Parent Button
            layout.addComponent(getButton(item));
            for (MenuItem child : item.getChildItems()) {
                layout.addComponent(getComponent(child)); // recursion
            }
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
        return layout;
    }
}
