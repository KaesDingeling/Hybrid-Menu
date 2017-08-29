package kaesdingeling.hybridmenu.data.leftmenu;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;

import kaesdingeling.hybridmenu.data.MenuConfig;

public class MenuButton extends Button {
	private static final long serialVersionUID = 3197719407068819159L;
	private MenuConfig menuConfig = null;
	private boolean useOwnListener = false;
	private ClickListener clickListener = null;
	private Class<? extends View> navigateTo = null;
	private String navigateToName = null;
	
	@SuppressWarnings("deprecation")
	public void removeDefaultClickListener() {
		removeClickListener(clickListener);
	}
	
	public ClickListener getDefaultClickListener() {
		return clickListener;
	}
	
	public void setUseOwnListener(boolean useOwnListener) {
		this.useOwnListener = useOwnListener;
	}
	
	public void navigateTo(Class<? extends View> _class) {
		navigateTo = _class;
		if (navigateTo != null) {
			navigateToName = navigateTo.getSimpleName();
		}
	}
	
	public void navigateTo(String navigateToName) {
		this.navigateToName = navigateToName;
	}
	
	public Class<? extends View> getNavigateTo() {
		return navigateTo;
	}
	
	public String getNavigateToName() {
		return navigateToName;
	}
	
	public void setConfig(MenuConfig menuConfig) {
		this.menuConfig = menuConfig;
	}
	
	public MenuConfig getConfig() {
		return menuConfig;
	}
	
	public void setActive(boolean active) {
		if (active) {
			if (!isActive()) { 
				addStyleName("active");
			}
		} else {
			if (isActive()) { 
				removeStyleName("active");
			}
		}
	}
	
	public boolean isActive() {
		return getStyleName().contains("active");
	}
	
	public void build() {
		setPrimaryStyleName("menuButton");
		if (menuConfig == null) {
			menuConfig = new MenuConfig();
		}
		setWidth("100%");
		setHeight(menuConfig.getLeftMenuButtonHeight() + "px");
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
			addClickListener(clickListener);
		}
	}
}