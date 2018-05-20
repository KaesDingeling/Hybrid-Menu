package de.kaesdingeling.hybridmenu.components;

import java.util.List;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcons;
import com.vaadin.flow.component.textfield.TextField;

import de.kaesdingeling.hybridmenu.data.interfaces.MenuComponent;

/**
 * Only for the top menu
 */
@SuppressWarnings("hiding")
public class HMTextField extends TextField implements MenuComponent<HMTextField> {
	private static final long serialVersionUID = -6746020801071116552L;

	public static HMTextField get(VaadinIcons icon, String placeholder) {
		return new HMTextField(icon.create(), placeholder);
	}
	
	public static HMTextField get(Icon icon, String placeholder) {
		return new HMTextField(icon, placeholder);
	}
	
	public HMTextField(Icon icon, String placeholder) {
		setPrefixComponent(icon);
		setPlaceholder(placeholder);
	}

	@Override
	public <MenuComponent extends Component> MenuComponent add(MenuComponent c) {
		return null;
	}

	@Override
	public <MenuComponent extends Component> MenuComponent addAsFirst(MenuComponent c) {
		return null;
	}

	@Override
	public <MenuComponent extends Component> MenuComponent addAt(MenuComponent c, int index) {
		return null;
	}

	@Override
	public int count() {
		return 0;
	}

	@Override
	public <MenuComponent extends Component> HMTextField remove(MenuComponent c) {
		return null;
	}

	@Override
	public List<MenuComponent<?>> getList() {
		return null;
	}
}