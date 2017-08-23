package kaesdingeling.hybridmenu.utils;

import com.vaadin.ui.Component;

public class StyleName {
    public static void toggle(Component c, String style) {
        if (c.getStyleName().contains(style)) {
            c.removeStyleName(style);
        } else {
            c.addStyleName(style);
        }
    }
}
