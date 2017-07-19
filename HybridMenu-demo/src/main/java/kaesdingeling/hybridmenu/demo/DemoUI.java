package kaesdingeling.hybridmenu.demo;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.UI;
import kaesdingeling.hybridmenu.data.MenuItemBuilder;
import kaesdingeling.hybridmenu.demo.page.HomePage;
import kaesdingeling.hybridmenu.demo.page.MemberPage;
import kaesdingeling.hybridmenu.enums.EMenuItemPosition;
import kaesdingeling.hybridmenu.enums.EMenuType;
import kaesdingeling.hybridmenu.enums.ETopMenuPosition;
import kaesdingeling.hybridmenu.menu.HybridMenu;
import kaesdingeling.hybridmenu.menu.HybridMenuBuilder;
import kaesdingeling.hybridmenu.page.DefaultPage;

import javax.servlet.annotation.WebServlet;

@Theme("demo")
@Title("HybridMenu Add-on Demo")
@SuppressWarnings("serial")
public class DemoUI extends UI {
    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = true, ui = DemoUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        HybridMenu hybridMenu = HybridMenuBuilder.get()
                .withMenuType(EMenuType.COMBINED)
                .withItemTitle(EMenuItemPosition.LEFT, "a1", true)
                .withItem(EMenuItemPosition.LEFT, "a2", VaadinIcons.HOME, HomePage.class, true)
                .withItem(EMenuItemPosition.LEFT, "a3", VaadinIcons.COG, DefaultPage.class, true)
                .withItem(
                        MenuItemBuilder.get("a4", VaadinIcons.FILE_TREE, HomePage.class, true)
                                .withSubMenuItem("a5", VaadinIcons.HOME, HomePage.class, true)
                                .withSubMenuItem("a6", VaadinIcons.HOME, HomePage.class, true)
                                .withSubMenuItem("a7", VaadinIcons.HOME, HomePage.class, true)
                                .withSubMenuItem("a8", VaadinIcons.HOME, HomePage.class, true)
                                .withStyleName(ETopMenuPosition.RIGHT.toString())
                                .build()
                ).withItem(
                        MenuItemBuilder.get("a9", VaadinIcons.FILE_TREE, HomePage.class, true)
                                .withSubMenuItem(
                                        MenuItemBuilder.get("a10", VaadinIcons.HOME, HomePage.class, true)
                                                .withSubMenuItem("a11", VaadinIcons.HOME, HomePage.class, true)
                                                .withSubMenuItem("a12", VaadinIcons.HOME, HomePage.class, true)
                                                .build()
                                ).withSubMenuItem("a13", VaadinIcons.HOME, HomePage.class, true)
                                .withSubMenuItem("a14", VaadinIcons.HOME, HomePage.class, true)
                                .withSubMenuItem("a15", VaadinIcons.HOME, HomePage.class, true)
                                .withStyleName(ETopMenuPosition.RIGHT.toString())
                                .build()
                ).withItem(null, VaadinIcons.SIGN_OUT.getHtml() + "Logout", MemberPage.class, false)
                .build();
        setContent(hybridMenu);
        VaadinSession.getCurrent().setAttribute(HybridMenu.class, hybridMenu);
    }
}
