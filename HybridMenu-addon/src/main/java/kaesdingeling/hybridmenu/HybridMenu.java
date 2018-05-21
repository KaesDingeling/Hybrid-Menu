package kaesdingeling.hybridmenu;

import java.util.List;
import java.util.logging.Logger;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import kaesdingeling.hybridmenu.components.BreadCrumbs;
import kaesdingeling.hybridmenu.components.LeftMenu;
import kaesdingeling.hybridmenu.components.NotificationCenter;
import kaesdingeling.hybridmenu.components.TopMenu;
import kaesdingeling.hybridmenu.data.DefaultViewChangeManager;
import kaesdingeling.hybridmenu.data.MenuConfig;
import kaesdingeling.hybridmenu.data.interfaces.MenuComponent;
import kaesdingeling.hybridmenu.data.interfaces.ViewChangeManager;
import kaesdingeling.hybridmenu.design.DesignItem;
import kaesdingeling.hybridmenu.page.DefaultPage;

public class HybridMenu extends VerticalLayout {
	private static final long serialVersionUID = -4055770717384786366L;
	private final static Logger log = Logger.getLogger(HybridMenu.class.getName());
	
	public static final String CLASS_NAME = "hybridMenu";
	
	private ViewChangeManager viewChangeManager = new DefaultViewChangeManager();
	private MenuConfig config = null;
	private boolean buildRunning = false;
	private boolean initNavigator = true;
	private boolean initViewChangeManager = true;

	/* Components */
	private HorizontalLayout content = new HorizontalLayout();
	
	private BreadCrumbs breadcrumbs = null;
	private Layout naviRootContent = null;
	private VerticalLayout rootContent = new VerticalLayout();
	private TopMenu topMenu = new TopMenu();
	private LeftMenu leftMenu = new LeftMenu();
	private NotificationCenter notiCenter = new NotificationCenter();
	
	private Label css = new Label("", ContentMode.HTML);

	public static HybridMenu get() {
		return new HybridMenu();
	}
	
	public HybridMenu() {
		super();
		setSizeFull();
		setStyleName(CLASS_NAME);
		setMargin(false);
		setSpacing(false);
	}

	public HybridMenu build() {
		if (!buildRunning) {
			UI ui = UI.getCurrent();
			
			if (config == null) {
				config = new MenuConfig();
			}
			if (naviRootContent == null) {
				naviRootContent = new VerticalLayout();
			}
			
			naviRootContent.setWidth(100, Unit.PERCENTAGE);
			naviRootContent.setStyleName("contentBox");
			
			if (initNavigator) {
				new Navigator(ui, naviRootContent);
				ui.getNavigator().setErrorView(DefaultPage.class);
			}
			
			if (initViewChangeManager) {
				if (null == ui.getNavigator()) {
					log.severe("You have configured to not initialize a Navigator! Make sure a Navigator exists in the UI");
				}
				ui.getNavigator().addViewChangeListener(new ViewChangeListener() {
					private static final long serialVersionUID = 5012642635022164196L;
					@Override
					public boolean beforeViewChange(ViewChangeEvent event) {
						return true;
					}
					@Override
					public void afterViewChange(ViewChangeEvent event) {
						List<MenuComponent<?>> menuContentList = viewChangeManager.init(HybridMenu.this);
						viewChangeManager.manage(HybridMenu.this, leftMenu, event, menuContentList);
						viewChangeManager.finish(HybridMenu.this, menuContentList);
					}
				});
			}
			
			addComponent(topMenu);
			
			content.setSizeFull();
			content.setMargin(false);
			content.setSpacing(false);
			content.setStyleName("rootContent");
			addComponent(content);
			setExpandRatio(content, 1f);
			
			css.setHeight(0, Unit.PIXELS);
			css.setStyleName("customCss");
			
			notiCenter.setNotificationPosition(config.getNotificationPosition());
			
			content.addComponents(leftMenu, rootContent, notiCenter, css);
			content.setExpandRatio(rootContent, 1f);
			
			rootContent.setMargin(false);
			rootContent.setSpacing(true);
			
			if (config.isBreadcrumbs()) {
				breadcrumbs = new BreadCrumbs();
				rootContent.addComponent(breadcrumbs);
			}
			
			rootContent.addComponent(naviRootContent);

			switchTheme(config.getDesignItem());
			VaadinSession.getCurrent().setAttribute(MenuConfig.class, config);
			VaadinSession.getCurrent().setAttribute(HybridMenu.class, this);
			buildRunning = true;
		}
		return this;
	}
	
	public LeftMenu getLeftMenu() {
		return leftMenu;
	}
	
	public TopMenu getTopMenu() {
		return topMenu;
	}
	
	public BreadCrumbs getBreadCrumbs() {
		return breadcrumbs;
	}
	
	public NotificationCenter getNotificationCenter() {
		return notiCenter;
	}

	public Layout getNaviContent() {
		return naviRootContent;
	}
	
	public HybridMenu withNaviContent(Layout naviRootContent) {
		this.naviRootContent = naviRootContent;
		return this;
	}
	
	public HybridMenu withInitNavigator(boolean initNavigator) {
		this.initNavigator = initNavigator;
		return this;
	}
	
	public MenuConfig getConfig() {
		return config;
	}

	public HybridMenu withConfig(MenuConfig config) {
		this.config = config;
		return this;
	}
	
	public void switchTheme(DesignItem designItem) {
		if (designItem != null) {
			if (designItem.getMenuDesign() == null) {
				designItem.setMenuDesign(config.getDesignItem().getMenuDesign());
			} else {
				setStyleName(CLASS_NAME);
				addStyleName(designItem.getMenuDesign().getName());
			}
			config.withDesignItem(designItem);
			css.setValue("<style type=\"text/css\">" + designItem.convertToStyle() + "</style>");
		} else {
			css.setValue("");
		}
	}

	public void setViewChangeManager(ViewChangeManager viewChangeManager) {
		this.viewChangeManager = viewChangeManager;
	}
}