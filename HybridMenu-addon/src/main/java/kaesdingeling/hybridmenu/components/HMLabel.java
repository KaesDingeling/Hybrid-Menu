package kaesdingeling.hybridmenu.components;

import java.util.List;

import com.vaadin.server.Resource;
import com.vaadin.ui.Label;

import kaesdingeling.hybridmenu.data.interfaces.MenuComponent;

/**
 * Only for the left menu
 */
public class HMLabel extends Label implements MenuComponent<Label> {
	private static final long serialVersionUID = -1030806788859361123L;

	public static HMLabel get() {
		return new HMLabel();
	}
	
	public HMLabel() {
		setCaptionAsHtml(true);
	}
	
	public HMLabel withCaption(String caption) {
		super.setCaption(caption);
		return this;
	}
	
	public HMLabel withIcon(Resource icon) {
		super.setIcon(icon);
		return this;
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
	public <C extends MenuComponent<?>> HMLabel remove(C c) {
		return null;
	}

	@Override
	public List<MenuComponent<?>> getList() {
		return null;
	}
}