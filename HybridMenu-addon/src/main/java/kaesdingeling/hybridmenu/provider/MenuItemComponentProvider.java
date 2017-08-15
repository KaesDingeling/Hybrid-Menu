package kaesdingeling.hybridmenu.provider;

import com.vaadin.ui.Component;
import kaesdingeling.hybridmenu.data.MenuItem;

/**
 * Created by appreciated on 14.07.2017.
 */
public interface MenuItemComponentProvider {
    Component getComponent(MenuItem item);
}
