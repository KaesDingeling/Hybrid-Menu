package kaesdingeling.hybridmenu.components;

import java.util.List;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.Resource;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;

import kaesdingeling.hybridmenu.data.interfaces.MenuComponent;

public class HMButton extends Button implements MenuComponent<Button> {
	private static final long serialVersionUID = -2388630513509376470L;
	
	private String toolTip = null;
	private String navigateTo = null;
	
	public static HMButton get() {
		return new HMButton("");
	}
	
	/**
	 * Only for the left menu
	 * 
	 * The caption is not displayed in the left menu
	 * 
	 * @param caption
	 */
	public HMButton(String caption) {
		build(caption, null, null);
	}
	
	public HMButton(Resource icon) {
		build(null, icon, null);
	}
	
	/**
	 * Only for the left menu
	 * 
	 * The caption is not displayed in the left menu
	 * 
	 * @param caption
	 */
	public HMButton(String caption, Resource icon) {
		build(caption, icon, null);
	}
	
	/**
	 * Only for the left menu
	 * 
	 * The caption is not displayed in the left menu
	 * 
	 * @param caption
	 */
	public HMButton(String caption, ClickListener clickListener) {
		build(caption, null, clickListener);
	}
	
	public HMButton(Resource icon, ClickListener clickListener) {
		build(null, icon, clickListener);
	}
	
	/**
	 * Only for the left menu
	 * 
	 * The caption is not displayed in the left menu
	 * 
	 * @param caption
	 */
	public HMButton(String caption, Resource icon, ClickListener clickListener) {
		build(caption, icon, clickListener);
	}
	
	private void build(String caption, Resource icon, ClickListener clickListener) {
		withCaption(caption);
		withIcon(icon);
		if (clickListener != null) {
			withClickListener(clickListener);
		}
	}
	
	/**
	 * Only for the left menu
	 * 
	 * The caption is not displayed in the left menu
	 * 
	 * @param caption
	 */
	public HMButton withCaption(String caption) {
		super.setCaption(caption);
		removeToolTip();
		updateToolTip();
		return this;
	}
	
	public HMButton withIcon(Resource icon) {
		super.setIcon(icon);
		return this;
	}
	
	public HMButton withClickListener(ClickListener clickListener) {
		super.addClickListener(clickListener);
		return this;
	}
	
	public HMButton withDescription(String description) {
		super.setDescription(description);
		return this;
	}
	
	public HMButton withNavigateTo(String link) {
		navigateTo = link;
		return this.withClickListener(e -> {
			UI.getCurrent().getNavigator().navigateTo(link);
		});
	}
	
	public <T extends View> HMButton withNavigateTo(Class<T> viewClass) {
		withNavigateTo(viewClass.getSimpleName(), viewClass);
		return this;
	}
	
	public <T extends View> HMButton withNavigateTo(String viewName, Class<T> viewClass) {
		navigateTo = viewName;
		
		Navigator navigator = UI.getCurrent().getNavigator();
		
		navigator.removeView(viewName);
		navigator.addView(viewName, viewClass);
		
		return this.withClickListener(e -> {
			navigator.navigateTo(navigateTo);
		});
	}
	
	public HMButton updateToolTip() {
		String toolTip = "";
		String caption = getCaption();
		if (caption != null && !caption.isEmpty()) {
			toolTip += caption;
		}
		if (this.toolTip != null && !this.toolTip.isEmpty()) {
			toolTip += "<div class=\"toolTip\">" + this.toolTip + "</div>";
		}
		setCaption(toolTip);
		return this;
	}
	
	/**
	 * Only for the top menu and internal
	 * 
	 * @param toolTip
	 * @return
	 */
	public HMButton withToolTip(String toolTip) {
		setCaptionAsHtml(true);
		removeToolTip();
		if (toolTip == null || toolTip.isEmpty()) {
			this.toolTip = null;
		} else {
			this.toolTip = toolTip;
		}
		updateToolTip();
		return this;
	}
	
	/**
	 * Only for the top menu
	 * 
	 * @param toolTip
	 * @return
	 */
	public HMButton withToolTip(int toolTip) {
		setCaptionAsHtml(true);
		removeToolTip();
		if (toolTip == 0) {
			this.toolTip = null;
		} else {
			this.toolTip = String.valueOf(toolTip);
		}
		updateToolTip();
		return this;
	}
	
	public HMButton removeToolTip() {
		String caption = getCaption();
		if (toolTip != null && !toolTip.isEmpty() && caption != null && !caption.isEmpty()) {
			setCaption(caption.replaceAll("<div class=\"toolTip\">" + toolTip + "</div>", ""));
		}
		return this;
	}
	
	public boolean isActive() {
		return getStyleName().contains("active");
	}
	
	public HMButton setActive(boolean active) {
		if (active && !isActive()) {
			addStyleName("active");
		} else {
			removeStyleName("active");
		}
		return this;
	}
	
	public String getNavigateTo() {
		return navigateTo;
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
	public <C extends MenuComponent<?>> HMButton remove(C c) {
		return null;
	}

	@Override
	public List<MenuComponent<?>> getList() {
		return null;
	}
}