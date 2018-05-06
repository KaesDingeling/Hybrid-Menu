package kaesdingeling.hybridmenu.components;

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
}