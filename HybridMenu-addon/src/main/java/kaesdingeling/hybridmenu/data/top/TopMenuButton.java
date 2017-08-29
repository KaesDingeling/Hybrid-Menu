package kaesdingeling.hybridmenu.data.top;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.UI;

import kaesdingeling.hybridmenu.data.MenuTopItem;

public class TopMenuButton extends MenuTopItem {
	private Button component = null;
	private ClickListener clickListener = null;
	private Class<? extends View> navigateTo = null;
	private String navigateToName = null;
	private String orginalCapation = null;
	private String toolTip = null;
	private boolean useOwnListener = false;
	private boolean hideCaption = true;
	
	public TopMenuButton() {
		component = new Button();
		component.setCaptionAsHtml(true);
		setComponent(component);
	}
	
	public void setCaption(String caption) {
		orginalCapation = caption;
		if (caption != null) {
			if (caption.contains("</")) {
				component.setCaptionAsHtml(true);
			}
		}
		component.setCaption(caption);
		if (isBuilded()) {
			updateCaption();
		}
	}
	
	public Class<? extends View> getNavigateTo() {
		return navigateTo;
	}

	public void setNavigateTo(Class<? extends View> navigateTo) {
		this.navigateTo = navigateTo;
	}
	
	public void setToolTip(String toolTip) {
		this.toolTip = toolTip;
		if (isBuilded()) {
			updateCaption();
		}
	}
	
	public void setActive(boolean active) {
		if (active) {
			if (!isActive()) {
				component.addStyleName("active");
			}
		} else {
			if (isActive()) {
				component.removeStyleName("active");
			}
		}
	}
	
	public boolean isActive() {
		return component.getStyleName().contains("active");
	}

	public String getNavigateToName() {
		return navigateToName;
	}

	public void setNavigateToName(String navigateToName) {
		this.navigateToName = navigateToName;
	}

	public void setHideCaption(boolean hideCaption) {
		this.hideCaption = hideCaption;
	}

	public void setUseOwnListener(boolean useOwnListener) {
		this.useOwnListener = useOwnListener;
	}
	
	public void addClickListener(ClickListener clickListener) {
		if (clickListener == null) {
			this.clickListener = clickListener;
		}
		component.addClickListener(clickListener);
	}

	@Override
	public Button getComponent() {
		return component;
	}

	public void build() {
		component.setPrimaryStyleName("menuButton");
		if (hideCaption) {
			addStyleName("captionOutside");
		}
		if (!useOwnListener && (navigateTo != null || navigateToName != null)) {
			clickListener = new ClickListener() {
				private static final long serialVersionUID = 1431465190138819027L;
				@Override
				public void buttonClick(ClickEvent event) {
					if (navigateToName == null && navigateTo != null) {
						UI.getCurrent().getNavigator().navigateTo(navigateTo.getSimpleName());
					} else if (navigateToName != null) {
						UI.getCurrent().getNavigator().navigateTo(navigateToName);
					}
				}
			};
			component.addClickListener(clickListener);
		}
		updateCaption();
		super.build();
	}
	
	public void updateCaption() {
		if (toolTip == null) {
			if (hideCaption) {
				component.setCaption("<span class=\"caption\">" + orginalCapation + "</span>");
			} else {
				component.setCaption(orginalCapation);
			}
		} else {
			if (orginalCapation == null) {
				component.setCaption("<span class=\"toolTop\">" + toolTip + "</span>");
			} else {
				component.setCaption("<span class=\"toolTop\">" + toolTip + "</span><span class=\"caption\">" + orginalCapation + "</span>");
			}
		}
	}
}