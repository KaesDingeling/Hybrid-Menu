package kaesdingeling.hybridmenu.data;

import com.vaadin.ui.Component;
import kaesdingeling.hybridmenu.enums.EAlignment;
import kaesdingeling.hybridmenu.enums.EMenuPosition;

public class CustomMenuItem {
    private final Component component;
    private final EMenuPosition position;
    private final EAlignment top;

    public CustomMenuItem(Component component, EMenuPosition position, EAlignment top) {
        this.component = component;
        this.position = position;
        this.top = top;
    }

    public Component getComponent() {
        return component;
    }

    public EMenuPosition getPosition() {
        return position;
    }

    public EAlignment getAlignment() {
        return top;
    }
}
