package kaesdingeling.hybridmenu.menu.variants;

import com.vaadin.ui.Component;
import kaesdingeling.hybridmenu.data.MenuItem;

import static kaesdingeling.hybridmenu.styles.HybridMenuStyles.MENU_TYPE_LEFT;

/**
 * Created by appreciated on 15.07.2017.
 */
public class HybridMenuTypeLeft extends HybridMenuVariant {

    @Override
    public void onInit() {

    }

    @Override
    public String getStyle() {
        return MENU_TYPE_LEFT;
    }

    @Override
    public Component[] getComponents() {
        return new Component[0];
    }

    @Override
    public void removeComponent(Component component) {

    }

    @Override
    public void addItem(MenuItem menuItem) {

    }

}
