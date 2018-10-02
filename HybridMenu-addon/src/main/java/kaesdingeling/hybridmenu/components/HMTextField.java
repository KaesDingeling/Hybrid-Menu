package kaesdingeling.hybridmenu.components;

import java.util.List;

import com.vaadin.server.Resource;
import com.vaadin.ui.TextField;

import kaesdingeling.hybridmenu.data.interfaces.MenuComponent;

/**
 * Only for the top menu
 */
public class HMTextField extends TextField implements MenuComponent<TextField> {
	private static final long serialVersionUID = -6746020801071116552L;

	public static HMTextField get(Resource icon, String placeholder) {
		return new HMTextField(icon, placeholder);
	}
	
	public HMTextField(Resource icon, String placeholder) {
		setIcon(icon);
		setPlaceholder(placeholder);
	}
	
	@Override
	public void setPrimaryStyleName(String style) {
		super.addStyleName(style);
	}

	@Override
	public String getRootStyle() {
		return this.getClass().getSimpleName();
	}

	@Override
	public <C extends MenuComponent<?>> C add(C c) {
		return null;
	}

	@Override
	public <C extends MenuComponent<?>> C addAsFirst(C c) {
		return null;
	}

	@Override
	public <C extends MenuComponent<?>> C addAt(C c, int index) {
		return null;
	}

	@Override
	public int count() {
		return 0;
	}

	@Override
	public <C extends MenuComponent<?>> HMTextField remove(C c) {
		return null;
	}

	@Override
	public List<MenuComponent<?>> getList() {
		return null;
	}
}