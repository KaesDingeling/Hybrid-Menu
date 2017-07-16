package kaesdingeling.hybridmenu.menu.variants;

import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import kaesdingeling.hybridmenu.data.MenuItem;
import kaesdingeling.hybridmenu.enums.EMenuType;

import java.util.HashSet;

/**
 * Created by appreciated on 14.07.2017.
 */
public class HybridMenuTypeTop extends HybridMenuVariant {

    private CssLayout topMenu;
    private HashSet leftMenuList;
    private CssLayout leftMenu;
    private HashSet topMenuList;


    @Override
    public void onInit() {
        if (navigator.equals(EMenuType.TOP)) {
            topMenu = new CssLayout();
            leftMenuList = new HashSet<>();
        } else {
            leftMenu = new CssLayout();
            topMenuList = new HashSet<>();
            leftMenu.addStyleName(animationSpeed.getStyle());
        }
    }

    @Override
    public String getStyle() {
        return "kdHybridMenuTopMenu";
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
