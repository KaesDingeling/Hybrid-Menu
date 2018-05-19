package kaesdingeling.hybridmenu.components;

import java.util.List;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;

import kaesdingeling.hybridmenu.data.interfaces.MenuComponent;

/**
 * Only for the left menu
 */
@SuppressWarnings("hiding")
public class HMLabel extends Label implements MenuComponent<HMLabel> {
	private static final long serialVersionUID = -1030806788859361123L;

	public static HMLabel get() {
		return new HMLabel();
	}
	
	public HMLabel() {
		//setCaptionAsHtml(true);
	}
	
	public HMLabel withCaption(String caption) {
		super.setText(caption);
		return this;
	}
	
	public HMLabel withIcon(Icon icon) {
		//super.setIcon(icon);
		return this;
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
	public <MenuComponent extends Component> HMLabel remove(MenuComponent c) {
		return null;
	}

	@Override
	public List<MenuComponent<?>> getList() {
		return null;
	}
}