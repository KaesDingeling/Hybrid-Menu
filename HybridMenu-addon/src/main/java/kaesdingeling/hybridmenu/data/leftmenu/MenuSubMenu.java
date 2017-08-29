package kaesdingeling.hybridmenu.data.leftmenu;

import com.vaadin.server.FontIcon;
import com.vaadin.server.Resource;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

import kaesdingeling.hybridmenu.data.MenuConfig;

public class MenuSubMenu extends VerticalLayout {
	private static final long serialVersionUID = 3197719407068819159L;
	private MenuConfig menuConfig = null;
	private MenuButton menuButton = new MenuButton();
	private VerticalLayout subMenuContent = new VerticalLayout();
	
	public MenuSubMenu() {
		super();
	}
	
	public MenuSubMenu(Component... components) {
		super();
	}
	
	@Override
	public void setCaption(String caption) {
		menuButton.setCaption(caption);
	}
	
	@Override
	public void setIcon(Resource icon) {
		menuButton.setIcon(icon);
	}
	
	public void build() {
		if (menuConfig == null) {
			menuConfig = new MenuConfig();
		}
		FontIcon icon = null;
		try {
			icon = (FontIcon) menuConfig.getSubMenuIcon();
			menuButton.addStyleName("subMenuButton");
			menuButton.setCaptionAsHtml(true);
			menuButton.setCaption(menuButton.getCaption() + icon.getHtml());
		} catch (Exception e) {
			icon = null;
		}
		setMargin(false);
		setSpacing(false);
		setWidth("100%");
		menuButton.setConfig(menuConfig);
		menuButton.addClickListener(e -> {
			setOpen(!isOpen());
		});
		menuButton.build();
		setPrimaryStyleName("menuSubMenu");
		subMenuContent.setStyleName("menuSubMenuContent");
		subMenuContent.setWidth("100%");
		subMenuContent.setMargin(false);
		subMenuContent.setSpacing(false);
		super.addComponents(menuButton, subMenuContent);
	}
	
	public MenuButton getButton() {
		return menuButton;
	}
	
	public void setConfig(MenuConfig menuConfig) {
		this.menuConfig = menuConfig;
	}
	
	public void setOpen(boolean open) {
		if (open) {
			if (!isOpen()) {
				menuButton.setActive(true);
				subMenuContent.addStyleName("open");
			}
		} else {
			if (isOpen()) {
				menuButton.setActive(false);
				subMenuContent.removeStyleName("open");
			}
		}
	}
	
	public boolean isOpen() {
		return subMenuContent.getStyleName().contains("open");
	}
	
	public VerticalLayout getSubMenuContent() {
		return subMenuContent;
	}
	
	public void addLeftMenuButton(MenuButton menuButton) {
		subMenuContent.addComponent(menuButton);
	}
	
	public void addLeftMenuSubMenu(MenuSubMenu menuSubMenu) {
		subMenuContent.addComponent(menuSubMenu);
	}
}