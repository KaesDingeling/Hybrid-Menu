package kaesdingeling.hybridmenu.components;

import java.util.List;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcons;

import kaesdingeling.hybridmenu.data.interfaces.MenuComponent;
import kaesdingeling.hybridmenu.utils.Styles;

@SuppressWarnings("hiding")
public class HMButton extends Button implements MenuComponent<HMButton> {
	private static final long serialVersionUID = -2388630513509376470L;
	
	private String navigateTo = null;
	
	private Label toolTip = null;
	private Icon otherIcon = null;
	
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
	
	public HMButton(Icon icon) {
		build(null, icon, null);
	}
	
	/**
	 * Only for the left menu
	 * 
	 * The caption is not displayed in the left menu
	 * 
	 * @param caption
	 */
	public HMButton(String caption, Icon icon) {
		build(caption, icon, null);
	}
	
	/**
	 * Only for the left menu
	 * 
	 * The caption is not displayed in the left menu
	 * 
	 * @param caption
	 */
	public HMButton(String caption, ComponentEventListener<ClickEvent<Button>> clickListener) {
		build(caption, null, clickListener);
	}
	
	public HMButton(Icon icon, ComponentEventListener<ClickEvent<Button>> clickListener) {
		build(null, icon, clickListener);
	}
	
	/**
	 * Only for the left menu
	 * 
	 * The caption is not displayed in the left menu
	 * 
	 * @param caption
	 */
	public HMButton(String caption, Icon icon, ComponentEventListener<ClickEvent<Button>> clickListener) {
		build(caption, icon, clickListener);
	}
	
	private void build(String caption, Icon icon, ComponentEventListener<ClickEvent<Button>> clickListener) {
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
		super.setText(caption);
		return this;
	}
	
	public HMButton withIcon(Icon icon) {
		super.setIcon(icon);
		return this;
	}
	
	public HMButton withIcon(VaadinIcons icon) {
		return withIcon(icon.create());
	}
	
	public HMButton withClickListener(ComponentEventListener<ClickEvent<Button>> clickListener) {
		super.addClickListener(clickListener);
		return this;
	}
	
	public HMButton withDescription(String description) {
		super.getElement().setAttribute("title", description);
		return this;
	}
	
	public <T extends Component> HMButton withNavigateTo(Class<T> viewClass) {
		withNavigateTo(UI.getCurrent().getRouter().getUrl(viewClass));
		return this;
	}
	
	public <T extends Component> HMButton withNavigateTo(String link) {
		navigateTo = link;
		return this.withClickListener(e -> UI.getCurrent().navigate(navigateTo));
	}
	
	/**
	 * Only for the left menu
	 * 
	 * @param toolTip
	 * @return
	 */
	public HMButton withOtherIcon(VaadinIcons icon) {
		return withOtherIcon(icon.create());
	}
	
	/**
	 * Only for the left menu
	 * 
	 * @param toolTip
	 * @return
	 */
	public HMButton withOtherIcon(Icon icon) {
		if (otherIcon != null) {
			otherIcon.getElement().removeFromParent();
		}
		otherIcon = icon;
		otherIcon.getClassNames().add(Styles.buttonOtherIcon);
		addToSuffix(icon);
		return this;
	}
	
	public HMButton withToolTip(String toolTip) {
		removeToolTip();
		this.toolTip = new Label(toolTip);
		this.toolTip.getClassNames().add(Styles.toolTip);
		addToSuffix(this.toolTip);
		return this;
	}
	
	public HMButton withToolTip(int toolTip) {
		if (toolTip > 0) {
			withToolTip(String.valueOf(toolTip));
		} else {
			removeToolTip();
		}
		return this;
	}
	
	public HMButton removeToolTip() {
		if (toolTip != null) {
			toolTip.getElement().removeFromParent();
		}
		return this;
	}
	
	public boolean isActive() {
		return getClassNames().contains(Styles.active);
	}
	
	public HMButton setActive(boolean active) {
		if (isActive() != active) {
			if (active) {
				getClassNames().add(Styles.active);
			} else {
				getClassNames().remove(Styles.active);
			}
		}
		return this;
	}
	
	public String getNavigateTo() {
		return navigateTo;
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
	public <MenuComponent extends Component> HMButton remove(MenuComponent c) {
		return null;
	}

	@Override
	public List<MenuComponent<?>> getList() {
		return null;
	}
}