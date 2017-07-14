package kaesdingeling.hybridmenu.component;

import com.vaadin.server.Sizeable;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import kaesdingeling.hybridmenu.data.MenuItem;
import kaesdingeling.hybridmenu.interfaces.MenuItemComponentProvider;

/**
 * Created by appreciated on 14.07.2017.
 */
public class DefaultMenuItemComponentProvider implements MenuItemComponentProvider {

    @Override
    public Component getComponent(MenuItem item) {
        if (item.getChildItems() == null) {
            Button button = new Button();
            button.setWidth(100, Sizeable.Unit.PERCENTAGE);
            button.addStyleName(ValoTheme.BUTTON_BORDERLESS);
            button.setIcon(item.getIcon());
            button.setCaption(item.getTitle());
            return button;
        } else {
            VerticalLayout layout = new VerticalLayout();
            layout.setMargin(false);
            layout.setWidth(100, Sizeable.Unit.PERCENTAGE);
            layout.setHeightUndefined();
            layout.addStyleName("menu-item-with-children");

            //Parent Button
            Button button = new Button();
            button.setWidth(100, Sizeable.Unit.PERCENTAGE);
            button.addStyleName(ValoTheme.BUTTON_BORDERLESS);
            button.setIcon(item.getIcon());
            button.setCaption(item.getTitle());
            layout.addComponent(button);

            for (MenuItem child : item.getChildItems()) {
                layout.addComponent(getComponent(child)); // recursion
            }

            return layout;
        }
    }
}
