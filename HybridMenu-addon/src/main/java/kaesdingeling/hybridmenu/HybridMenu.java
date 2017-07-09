package kaesdingeling.hybridmenu;

import java.util.HashSet;
import java.util.Set;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Resource;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.UI;

import kaesdingeling.hybridmenu.data.MenuItem;
import kaesdingeling.hybridmenu.enums.EMenuNavigator;
import kaesdingeling.hybridmenu.enums.EMenuPosition;
import kaesdingeling.hybridmenu.enums.EMenuType;
import kaesdingeling.hybridmenu.enums.ETopMenuPosition;
import kaesdingeling.hybridmenu.page.DefaultPage;
import kaesdingeling.hybridmenu.utils.ViewChangeManager;

public class HybridMenu extends CssLayout {
	private static final long serialVersionUID = 1L;

	private ViewChangeManager viewChangeManager = null;

	@SuppressWarnings("unused")
	private EMenuNavigator naviType = null;
	private EMenuType menuType = null;

	private CssLayout leftMenu = null;
	private CssLayout topMenu = null;
	private CssLayout content = null;

	/* Intern Data */
	private Set<MenuItem> leftMenuList = null;
	private Set<MenuItem> topMenuList = null;

	private boolean allowChangeView = true;

	/* Default Content */
	private Label menuTitle = new Label();
	private NativeButton menuResize = new NativeButton();
	
	public HybridMenu() {
		build(EMenuNavigator.AUTO, EMenuType.COMBONED, false);
	}

	public HybridMenu(boolean customNavigator) {
		build(EMenuNavigator.AUTO, EMenuType.COMBONED, customNavigator);
	}
	
	public HybridMenu(EMenuNavigator naviType) {
		if (naviType == null) {
			naviType = EMenuNavigator.AUTO;
		}
		build(naviType, EMenuType.COMBONED, false);
	}

	public HybridMenu(EMenuNavigator naviType, boolean ownNavigator) {
		if (naviType == null) {
			naviType = EMenuNavigator.AUTO;
		}
		build(naviType, EMenuType.COMBONED, ownNavigator);
	}
	
	public HybridMenu(EMenuType menuType) {
		if (menuType == null) {
			menuType = EMenuType.COMBONED;
		}
		build(EMenuNavigator.AUTO, menuType, false);
	}

	public HybridMenu(EMenuType menuType, boolean ownNavigator) {
		if (menuType == null) {
			menuType = EMenuType.COMBONED;
		}
		build(EMenuNavigator.AUTO, menuType, ownNavigator);
	}
	
	public HybridMenu(EMenuNavigator naviType, EMenuType menuType) {
		if (menuType == null) {
			menuType = EMenuType.COMBONED;
		}
		if (naviType == null) {
			naviType = EMenuNavigator.AUTO;
		}
		build(naviType, menuType, false);
	}

	public HybridMenu(EMenuNavigator naviType, EMenuType menuType, boolean ownNavigator) {
		if (menuType == null) {
			menuType = EMenuType.COMBONED;
		}
		if (naviType == null) {
			naviType = EMenuNavigator.AUTO;
		}
		build(naviType, menuType, ownNavigator);
	}

	private void build(EMenuNavigator naviType, EMenuType menuType, boolean customNavigator) {
		if (menuType.equals(EMenuType.COMBONED)) {
			topMenu = new CssLayout();
			leftMenu = new CssLayout();
			topMenu.setStyleName("kdHybridMenuTop");
			leftMenu.setStyleName("kdHybridMenuLeft");
			leftMenuList = new HashSet<MenuItem>();
			topMenuList = new HashSet<MenuItem>();
			addComponents(topMenu, leftMenu);
			setStyleName("kdHybridMenu");
			if (naviType.equals(EMenuNavigator.AUTO)) {
				content = new CssLayout();
				content.setStyleName("kdHybridMenuBody");
				if (!customNavigator) {
					new Navigator(UI.getCurrent(), content);
				}
				setErrorView(DefaultPage.class);
				addComponent(content);
			}
			menuTitle.setCaptionAsHtml(true);
			menuTitle.setCaption("<b>Hybrid</b> Menu");
			menuTitle.setStyleName("menuTitle");
			menuTitle.addStyleName(ETopMenuPosition.LEFT.toString());

			menuResize.setIcon(VaadinIcons.ANGLE_LEFT);
			menuResize.setStyleName(ETopMenuPosition.LEFT.toString());
			menuResize.addClickListener(e -> {
				if (getStyleName().contains("minimalView")) {
					menuResize.setIcon(VaadinIcons.ANGLE_LEFT);
					removeStyleName("minimalView");
				} else {
					menuResize.setIcon(VaadinIcons.ANGLE_RIGHT);
					addStyleName("minimalView");
				}
			});
			topMenu.addComponents(menuTitle, menuResize);
		} else {
			naviType = EMenuNavigator.MANUALL;
			if (menuType.equals(EMenuType.TOP)) {
				topMenu = new CssLayout();
				leftMenuList = new HashSet<MenuItem>();
				setStyleName("kdHybridMenuTopMenu");
			} else {
				leftMenu = new CssLayout();
				topMenuList = new HashSet<MenuItem>();
				setStyleName("kdHybridMenuLeftMenu");
			}
		}
		if (naviType.equals(EMenuNavigator.SEMI_AUTOMATIC) || naviType.equals(EMenuNavigator.AUTO)) {
			viewChangeManager = new ViewChangeManager();
			UI.getCurrent().getNavigator().addViewChangeListener(new ViewChangeListener() {
				private static final long serialVersionUID = 1L;

				@Override
				public boolean beforeViewChange(ViewChangeEvent event) {
					return allowChangeView;
				}

				@Override
				public void afterViewChange(ViewChangeEvent event) {
					if (allowChangeView) {
						if (leftMenuList != null) {
							viewChangeManager.manage(leftMenuList, event);
						}
						if (topMenuList != null) {
							viewChangeManager.manage(topMenuList, event);
						}
					}
				}
			});
		}
		this.menuType = menuType;
		this.naviType = naviType;
	}

	public Label getTopMenuLabel() {
		return menuTitle;
	}

	public CssLayout getBody() {
		return content;
	}

	public void setAllowViewChange(boolean allowChangeView) {
		this.allowChangeView = allowChangeView;
	}

	public boolean isAllowViewChange() {
		return allowChangeView;
	}

	public void setErrorView(Class<? extends View> _class) {
		UI.getCurrent().getNavigator().setErrorView(_class);
	}

	public void addView(Class<? extends View> _class) {
		UI.getCurrent().getNavigator().addView(_class.getSimpleName(), _class);
	}

	public void removeView(Class<? extends View> _class) {
		UI.getCurrent().getNavigator().removeView(_class.getSimpleName());
	}

	public void navigateTo(String viewName) {
		UI.getCurrent().getNavigator().navigateTo(viewName);
	}

	public MenuItem createItemTitle(EMenuPosition menuPosition) {
		MenuItem menuItem = new MenuItem();
		menuItem.setMenuPosition(menuPosition);
		return menuItem;
	}

	public MenuItem createItem(EMenuPosition menuPosition, String title, Class<? extends View> _class,
			boolean addItem) {
		MenuItem menuItem = createItemTitle(menuPosition);
		NativeButton button = new NativeButton();
		if (menuPosition != null) {
			if (menuPosition.equals(EMenuPosition.TOP)) {
				button.setDescription(title);
			} else {
				button.setCaption(title);
			}
		} else {
			button.setCaption(title);
		}
		button.setCaptionAsHtml(true);
		menuItem.setButton(button);
		if (_class != null) {
			menuItem.setTargetClass(_class);
			menuItem.setNavigateTo(_class.getSimpleName());
		}
		if (addItem) {
			addItem(menuItem);
		}
		return menuItem;
	}

	public MenuItem createItem(EMenuPosition menuPosition, Resource icon, boolean addItem) {
		MenuItem menuItem = createItemTitle(menuPosition);
		NativeButton button = new NativeButton();
		menuItem.setButton(button);
		if (menuItem.getButton() != null) {
			if (icon != null) {
				menuItem.getButton().setIcon(icon);
			}
		}
		if (addItem) {
			addItem(menuItem);
		}
		return menuItem;
	}

	public MenuItem createItem(EMenuPosition menuPosition, String title, Resource icon, Class<? extends View> _class,
			boolean addItem) {
		MenuItem menuItem = createItem(menuPosition, title, _class, false);
		if (menuItem.getButton() != null) {
			if (icon != null) {
				menuItem.getButton().setIcon(icon);
			}
		}
		if (addItem) {
			addItem(menuItem);
		}
		return menuItem;
	}

	public MenuItem createItem(EMenuPosition menuPosition, String title, Resource icon, Class<? extends View> _class,
			String navigateTo, boolean addItem) {
		MenuItem menuItem = createItem(menuPosition, title, icon, _class, false);
		if (navigateTo != null) {
			menuItem.setNavigateTo(navigateTo);
		}
		if (addItem) {
			addItem(menuItem);
		}
		return menuItem;
	}

	public MenuItem createItemTitle(EMenuPosition menuPosition, String title, boolean addItem) {
		MenuItem menuItem = createItemTitle(menuPosition);
		Label label = new Label();
		label.setCaptionAsHtml(true);
		label.setCaption(title);
		menuItem.setTitle(label);
		if (addItem) {
			addItem(menuItem);
		}
		return menuItem;
	}

	public MenuItem createItemIconTitle(EMenuPosition menuPosition, String title, boolean addItem) {
		MenuItem menuItem = createItemTitle(menuPosition, title, false);
		menuItem.getTitle().addStyleName("withIcon");
		if (addItem) {
			addItem(menuItem);
		}
		return menuItem;
	}

	public boolean addItem(MenuItem menuItem) {
		if (menuItem != null) {
			if (menuItem.getParent() != null) {
				if (menuItem.getParent().getButton() != null && menuItem.getParent().getSubMenuContent().getComponentCount() == 0) {
					Label title = new Label(menuItem.getParent().getButton().getCaption());
					title.setStyleName("subMenuTitle");
					menuItem.getParent().getSubMenuContent().addComponent(title);
				}
				addItem(menuItem, menuItem.getParent().getSubMenuContent());
			} else {
				EMenuPosition cachePosition = EMenuPosition.LEFT;
				if (menuItem.getMenuPosition() == null) {
					if (menuType.equals(EMenuType.TOP)) {
						cachePosition = EMenuPosition.TOP;
					}
				} else if (menuItem.getMenuPosition().equals(EMenuPosition.TOP)) {
					cachePosition = EMenuPosition.TOP;
				}
				menuItem.setMenuPosition(cachePosition);
				if (menuItem.getMenuPosition().equals(EMenuPosition.TOP)) {
					topMenuList.add(menuItem);
				} else {
					leftMenuList.add(menuItem);
				}
				if (menuType.equals(EMenuType.COMBONED)) {
					if (menuItem.getMenuPosition().equals(EMenuPosition.TOP)) {
						addItem(menuItem, topMenu);
					} else {
						addItem(menuItem, leftMenu);
					}
				} else {
					addItem(menuItem, this);
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public void addItem(MenuItem menuItem, CssLayout layout) {
		CssLayout buttonMainContent = null;
		if (menuItem.getTargetClass() != null) {
			addView(menuItem.getTargetClass());
			if (menuItem.getNavigateTo() == null) {
				menuItem.setNavigateTo(menuItem.getTargetClass().getSimpleName());
			}
		}
		if (menuItem.getSubMenu() != null) {
			if (menuItem.getSubMenuContent() == null) {
				menuItem.setSubMenuContent(new CssLayout());
			}
			if (!menuItem.getSubMenuContent().getStyleName().contains("subMenu")) {
				menuItem.getSubMenuContent().setStyleName("subMenu");
			}
			for (MenuItem subMenuItem : menuItem.getSubMenu()) {
				subMenuItem.setParent(menuItem);
				addItem(subMenuItem);
			}
		}
		if (menuItem.getSubMenu() != null && menuItem.getSubMenuContent() != null) {
			buttonMainContent = new CssLayout();
			buttonMainContent.setStyleName("subMenuMasterContent");
			if (menuItem.getTitle() != null) {
				buttonMainContent.addComponent(menuItem.getTitle());
			}
			if (menuItem.getImage() != null) {
				buttonMainContent.addComponent(menuItem.getImage());
			}
		} else {
			if (menuItem.getTitle() != null) {
				layout.addComponent(menuItem.getTitle());
			}
			if (menuItem.getImage() != null) {
				layout.addComponent(menuItem.getImage());
			}
		}
		if (menuItem.getButton() != null) {
			if (menuItem.getSubMenu() != null && menuItem.getSubMenuContent() != null) {
				if (menuItem.getButton().getStyleName().contains(ETopMenuPosition.RIGHT.toString())) {
					buttonMainContent.addStyleName(ETopMenuPosition.RIGHT.toString());
				}
				buttonMainContent.addComponent(menuItem.getButton());
				menuItem.getButton().setCaption(menuItem.getButton().getCaption() + VaadinIcons.ANGLE_LEFT.getHtml());
				menuItem.getButton().addClickListener(e -> {
					if (menuItem.getSubMenuContent().getStyleName().contains("open")) {
						menuItem.getSubMenuContent().removeStyleName("open");
						if (menuItem.getButton().getCaption().contains(VaadinIcons.ANGLE_DOWN.getHtml())) {
							menuItem.getButton().setCaption(menuItem.getButton().getCaption()
									.replaceAll(VaadinIcons.ANGLE_DOWN.getHtml(), VaadinIcons.ANGLE_LEFT.getHtml()));
						}
					} else {
						menuItem.getSubMenuContent().addStyleName("open");
						if (menuItem.getButton().getCaption().contains(VaadinIcons.ANGLE_LEFT.getHtml())) {
							menuItem.getButton().setCaption(menuItem.getButton().getCaption()
									.replaceAll(VaadinIcons.ANGLE_LEFT.getHtml(), VaadinIcons.ANGLE_DOWN.getHtml()));
						}
					}
				});
			} else {
				layout.addComponent(menuItem.getButton());
				if (menuItem.getNavigateTo() != null && menuItem.isAllowClickToNavigate()) {
					menuItem.getButton().addClickListener(e -> {
						if (allowChangeView) {
							if (UI.getCurrent().getNavigator().getCurrentView().getClass().getSimpleName()
									.equals(menuItem.getNavigateTo())) {
								if (menuItem.isAllowNavigateToSamePage()) {
									navigateTo(menuItem.getNavigateTo());
								}
							} else {
								navigateTo(menuItem.getNavigateTo());
							}
						}
					});
				}
			}
		}
		if (menuItem.getSubMenu() != null && menuItem.getSubMenuContent() != null) {
			if (menuItem.getComponent() != null) {
				buttonMainContent.addComponent(menuItem.getComponent());
			}
			if (menuItem.getSubMenuContent() != null) {
				buttonMainContent.addComponent(menuItem.getSubMenuContent());
			}
			layout.addComponent(buttonMainContent);
		} else {
			if (menuItem.getComponent() != null) {
				layout.addComponent(menuItem.getComponent());
			}
			if (menuItem.getSubMenuContent() != null) {
				layout.addComponent(menuItem.getSubMenuContent());
			}
		}
	}

	public void addItem(EMenuPosition menuPosition, Component component) {
		if (menuType.equals(EMenuType.COMBONED)) {
			if (menuPosition == null) {
				menuPosition = EMenuPosition.LEFT;
			}
			if (menuPosition.equals(EMenuPosition.TOP)) {
				topMenu.addComponent(component);
			} else {
				leftMenu.addComponent(component);
			}
		} else {
			addComponent(component);
		}
	}

	public boolean removeItem(MenuItem menuItem) {
		if (menuItem != null) {
			if (leftMenuList != null) {
				int leftMenuListSize = leftMenuList.size();
				leftMenuList.remove(menuItem);
				if (leftMenuListSize > leftMenuList.size()) {
					removeItem(EMenuPosition.LEFT, menuItem.getButton());
					removeItem(EMenuPosition.LEFT, menuItem.getTitle());
					removeItem(EMenuPosition.LEFT, menuItem.getImage());
					removeItem(EMenuPosition.LEFT, menuItem.getComponent());
					if (menuItem.getSubMenu() != null) {
						for (MenuItem subMenuItem : menuItem.getSubMenu()) {
							removeItem(subMenuItem);
						}
					}
					removeItem(EMenuPosition.LEFT, menuItem.getSubMenuContent());
					return true;
				}
			}
			if (topMenuList != null) {
				int topMenuListSize = topMenuList.size();
				topMenuList.remove(menuItem);
				if (topMenuListSize > topMenuList.size()) {
					removeItem(EMenuPosition.TOP, menuItem.getButton());
					removeItem(EMenuPosition.TOP, menuItem.getTitle());
					removeItem(EMenuPosition.TOP, menuItem.getImage());
					removeItem(EMenuPosition.TOP, menuItem.getComponent());
					if (menuItem.getSubMenu() != null) {
						for (MenuItem subMenuItem : menuItem.getSubMenu()) {
							removeItem(subMenuItem);
						}
					}
					removeItem(EMenuPosition.TOP, menuItem.getSubMenuContent());
					return true;
				}
			}
		}
		return false;
	}

	public void removeItem(EMenuPosition menuPosition, Component component) {
		if (component != null) {
			if (menuType.equals(EMenuType.COMBONED)) {
				if (menuPosition.equals(EMenuPosition.TOP)) {
					topMenu.removeComponent(component);
				} else {
					leftMenu.removeComponent(component);
				}
			} else {
				removeComponent(component);
			}
		}
	}
}