package kaesdingeling.hybridmenu;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.VaadinSession;

import kaesdingeling.hybridmenu.components.LeftMenu;
import kaesdingeling.hybridmenu.components.NotificationCenter;
import kaesdingeling.hybridmenu.components.Style;
import kaesdingeling.hybridmenu.components.TopMenu;
import kaesdingeling.hybridmenu.data.DefaultViewChangeManager;
import kaesdingeling.hybridmenu.data.MenuConfig;
import kaesdingeling.hybridmenu.data.enums.MenuDesign;
import kaesdingeling.hybridmenu.data.interfaces.HybridMenuRouter;
import kaesdingeling.hybridmenu.data.interfaces.ViewChangeManager;
import kaesdingeling.hybridmenu.design.DesignItem;
import kaesdingeling.hybridmenu.utils.Styles;

public abstract class HybridMenu extends VerticalLayout implements RouterLayout, AfterNavigationObserver, HybridMenuRouter {
	private static final long serialVersionUID = -4055770717384786366L;

	private ViewChangeManager viewChangeManager = new DefaultViewChangeManager();
	private MenuConfig config = null;
	private boolean buildRunning = false;

	/* Components */
	private HorizontalLayout content = new HorizontalLayout();
	
	private TopMenu topMenu = new TopMenu();
	private LeftMenu leftMenu = new LeftMenu();
	private NotificationCenter notiCenter = new NotificationCenter();
	
	private Style style = new Style();
	private Style customStyles = new Style();
	
	public HybridMenu() {
		if (Styles.style == null) {
			Styles.style = getFile("styles/hybridMenu.css");
		}
		style.setStyle(Styles.style);
		setSizeFull();
		getClassNames().add(Styles.hybridMenu);
		setMargin(false);
		setPadding(false);
		setSpacing(false);
		
		boolean build = init(VaadinSession.getCurrent(), UI.getCurrent());
		
		if (build) {
			build();
		}
	}

	public HybridMenu build() {
		if (!buildRunning) {
			content.setSizeFull();
			content.setMargin(false);
			content.setSpacing(false);
			content.getClassNames().add(Styles.rootContent);
			content.add(leftMenu, notiCenter);
			
			add(style/*, customStyles*/, topMenu, content);
			expand(content);
			
			notiCenter.setNotificationPosition(config.getNotificationPosition());

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
	
	public NotificationCenter getNotificationCenter() {
		return notiCenter;
	}
	
	public MenuConfig getConfig() {
		return config;
	}

	public HybridMenu withConfig(MenuConfig config) {
		VaadinSession.getCurrent().setAttribute(MenuConfig.class, config);
		this.config = config;
		return this;
	}
	
	public void switchTheme(DesignItem designItem) {
		if (designItem != null) {
			if (designItem.getMenuDesign() == null) {
				designItem.setMenuDesign(config.getDesignItem().getMenuDesign());
			} else {
				for (MenuDesign menuDesign : MenuDesign.values()) {
					getClassNames().remove(menuDesign.getName());
				}
				
				getClassNames().add(designItem.getMenuDesign().getName());
			}
			config.withDesignItem(designItem);
			customStyles.setStyle(designItem.convertToStyle());
		} else {
			customStyles.clear();
		}
	}

	public void setViewChangeManager(ViewChangeManager viewChangeManager) {
		this.viewChangeManager = viewChangeManager;
	}
	
	@Override
	public void showRouterLayoutContent(HasElement content) {
        if (content != null) {
        	Component component = content.getElement().getComponent().get();
        	
        	content.getElement().getStyle().set("width", "100%");
        	content.getElement().getClassList().add(Styles.contentBox);
        	
        	this.content.add(component);
        	this.expand(component);
        }
    }

	@Override
	public void afterNavigation(AfterNavigationEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	private String getFile(String fileName) {
		StringBuilder result = new StringBuilder("");
		
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());

		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line).append("\n");
			}

			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
			
		return result.toString();
	}
}