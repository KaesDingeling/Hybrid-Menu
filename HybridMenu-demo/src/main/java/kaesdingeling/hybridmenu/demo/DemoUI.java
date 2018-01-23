package kaesdingeling.hybridmenu.demo;

import javax.servlet.annotation.WebServlet;

import com.google.gwt.user.client.ui.SimplePanel;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.debug.internal.AnalyzeLayoutsPanel;
import com.vaadin.client.debug.internal.HierarchyPanel;
import com.vaadin.client.debug.internal.Highlight;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ClientConnector.DetachListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.JavaScript;
import com.vaadin.ui.JavaScriptFunction;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import elemental.json.JsonArray;
import kaesdingeling.hybridmenu.HybridMenu;
import kaesdingeling.hybridmenu.builder.HybridMenuBuilder;
import kaesdingeling.hybridmenu.builder.NotificationBuilder;
import kaesdingeling.hybridmenu.builder.left.LeftMenuButtonBuilder;
import kaesdingeling.hybridmenu.builder.left.LeftMenuSubMenuBuilder;
import kaesdingeling.hybridmenu.builder.top.TopMenuButtonBuilder;
import kaesdingeling.hybridmenu.builder.top.TopMenuLabelBuilder;
import kaesdingeling.hybridmenu.builder.top.TopMenuSubContentBuilder;
import kaesdingeling.hybridmenu.components.NotificationCenter;
import kaesdingeling.hybridmenu.data.DesignItem;
import kaesdingeling.hybridmenu.data.MenuConfig;
import kaesdingeling.hybridmenu.data.enums.EMenuComponents;
import kaesdingeling.hybridmenu.data.enums.EMenuStyle;
import kaesdingeling.hybridmenu.data.enums.ENotificationPriority;
import kaesdingeling.hybridmenu.data.leftmenu.MenuButton;
import kaesdingeling.hybridmenu.data.leftmenu.MenuSubMenu;
import kaesdingeling.hybridmenu.data.top.TopMenuButton;
import kaesdingeling.hybridmenu.data.top.TopMenuLabel;
import kaesdingeling.hybridmenu.data.top.TopMenuSubContent;
import kaesdingeling.hybridmenu.demo.page.GroupPage;
import kaesdingeling.hybridmenu.demo.page.HomePage;
import kaesdingeling.hybridmenu.demo.page.MemberPage;
import kaesdingeling.hybridmenu.demo.page.SettingsPage;
import kaesdingeling.hybridmenu.demo.page.ThemeBuilderPage;

@Theme("demo")
@Title("HybridMenu Add-on Demo")
@SuppressWarnings({ "serial", "deprecation" })
public class DemoUI extends UI implements DetachListener {
    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = true, ui = DemoUI.class)
    public static class Servlet extends VaadinServlet {
    }
    //private SimplePanel content = new SimplePanel();
    
    private NotificationCenter notiCenter = null;
    private HybridMenu hybridMenu = null;

    @Override
    protected void init(VaadinRequest request) {
    	UI.getCurrent().setPollInterval(5000);
    	
    	MenuConfig menuConfig = new MenuConfig();
    	menuConfig.setDesignItem(DesignItem.getDarkDesign());
    	
    	notiCenter = new NotificationCenter(5000);
    	
    	hybridMenu = HybridMenuBuilder.get()
    			.setContent(new VerticalLayout())
    			.setMenuComponent(EMenuComponents.LEFT_WITH_TOP)
    			.setConfig(menuConfig)
    			.withNotificationCenter(notiCenter)
    			.build();
    	
    	UI.getCurrent().getNavigator().addView(HomePage.class.getSimpleName(), HomePage.class);
    	UI.getCurrent().getNavigator().addView(GroupPage.class.getSimpleName(), GroupPage.class);
    	UI.getCurrent().getNavigator().addView(MemberPage.class.getSimpleName(), MemberPage.class);
    	UI.getCurrent().getNavigator().addView(SettingsPage.class.getSimpleName(), SettingsPage.class);
    	UI.getCurrent().getNavigator().addView(ThemeBuilderPage.class.getSimpleName(), ThemeBuilderPage.class);

		if(hybridMenu.getMenuComponents().equals(EMenuComponents.ONLY_LEFT))
    	buildLeftMenu(hybridMenu);
		else
			if(hybridMenu.getMenuComponents().equals(EMenuComponents.LEFT_WITH_TOP)) {
				buildLeftMenu(hybridMenu);
				buildTopOnlyMenu(hybridMenu);
			}else
				buildTopOnlyMenu(hybridMenu);

    	getNavigator().addViewChangeListener(new ViewChangeListener() {
			@Override
			public boolean beforeViewChange(ViewChangeEvent event) {
				if (event.getOldView() != null && event.getOldView().getClass().getSimpleName().equals(ThemeBuilderPage.class.getSimpleName())) {
					hybridMenu.switchTheme(DesignItem.getDarkDesign());
				}
				return true;
			}
		});
    	
    	//hybridMenu.addComponent(content);

    	setContent(hybridMenu);
    	VaadinSession.getCurrent().setAttribute(HybridMenu.class, hybridMenu);
    	
    	JavaScript.getCurrent().addFunction("aboutToClose", new JavaScriptFunction() {
			private static final long serialVersionUID = 1L;
			@Override
            public void call(JsonArray arguments) {
                detach();
            }
        });
    	
    	System.out.println("odsafdf");
    	
    	//UI.getCurrent().addContextClickListener(e -> System.out.println(e.getComponent().getClass().getSimpleName()));
    	
    	/*
    	UI.getCurrent().addClickListener(e -> {
    		System.out.println(e.getComponent());
    	});
    	*/
    	
    	
    	System.out.println("meddel");

        Page.getCurrent().getJavaScript().execute("window.onbeforeunload = function (e) { var e = e || window.event; aboutToClose(); return; };");
    }
    
    private void printState(ServerConnector connector, boolean serverDebug) {
    	System.out.println(connector.getClass().getSimpleName());
}

	private void buildTopOnlyMenu(HybridMenu hybridMenu) {
		TopMenuButtonBuilder.get()
				.setCaption("Home")
				.setIcon(VaadinIcons.HOME)
				.setAlignment(Alignment.MIDDLE_RIGHT)
				.setNavigateTo(HomePage.class)
				.build(hybridMenu);

		TopMenuButtonBuilder.get()
				.setCaption("Member")
				.setIcon(VaadinIcons.USER)
				.setAlignment(Alignment.MIDDLE_RIGHT)
				.setHideCaption(false)
				.setNavigateTo(MemberPage.class)
				.build(hybridMenu);

		TopMenuButtonBuilder.get()
				.setCaption("Member")
				.setIcon(VaadinIcons.USER)
				.setAlignment(Alignment.MIDDLE_RIGHT)
				.setHideCaption(false)
				.addStyleName(EMenuStyle.ICON_RIGHT)
				.setNavigateTo(MemberPage.class)
				.build(hybridMenu);

		TopMenuSubContent userAccountMenu = TopMenuSubContentBuilder.get()
				.setButtonCaption("Test User")
				.setButtonIcon(new ThemeResource("images/profilDummy.jpg"))
				.addButtonStyleName(EMenuStyle.ICON_RIGHT)
				.addButtonStyleName(EMenuStyle.PROFILVIEW)
				.setAlignment(Alignment.MIDDLE_RIGHT)
				.build(hybridMenu);

		userAccountMenu.addLabel("Account");
		userAccountMenu.addHr();
		userAccountMenu.addButton("Test");
		userAccountMenu.addHr();
		userAccountMenu.addButton("Test 2");

		TopMenuButtonBuilder.get()
				.setCaption("Home")
				.setIcon(VaadinIcons.HOME)
				.setAlignment(Alignment.MIDDLE_RIGHT)
				.setToolTip("5")
				.setNavigateTo(HomePage.class)
				.build(hybridMenu);
		
		TopMenuButton notiButton = TopMenuButtonBuilder.get()
			.setIcon(VaadinIcons.BELL_O)
			.setAlignment(Alignment.MIDDLE_RIGHT)
			.build(hybridMenu);
		
		notiCenter.setNotificationButton(notiButton);

		TopMenuLabel label = TopMenuLabelBuilder.get()
				.setCaption("<b>Hybrid</b> Menu")
				.setIcon(new ThemeResource("images/hybridmenu-Logo.png"))
				.build(hybridMenu);

		label.getComponent().addClickListener(e -> {
			UI.getCurrent().getNavigator().navigateTo(HomePage.class.getSimpleName());
		});

		TopMenuButton notiButtonLow = TopMenuButtonBuilder.get()
				.setCaption("Add Low noti")
				.setIcon(VaadinIcons.BELL_O)
				.setUseOwnListener(true)
				.build(hybridMenu);
		
		TopMenuButton notiButtonMedium = TopMenuButtonBuilder.get()
				.setCaption("Add Medium noti")
				.setIcon(VaadinIcons.BELL_O)
				.setUseOwnListener(true)
				.build(hybridMenu);
		
		TopMenuButton notiButtonHigh = TopMenuButtonBuilder.get()
				.setCaption("Add High noti")
				.setIcon(VaadinIcons.BELL_O)
				.setUseOwnListener(true)
				.build(hybridMenu);
		
		notiButtonLow.addClickListener(e -> {
			NotificationBuilder.get(notiCenter)
			.withCaption("Test")
			.withDescription("descriptifghhgjghjkfjhgjfhjfoikjrsadopherduiothjreouithruetijpertheriuhton")
			.withPriority(ENotificationPriority.LOW)
			.withCloseButton()
			.build();
		});
		
		notiButtonMedium.addClickListener(e -> {
			NotificationBuilder.get(notiCenter)
			.withCaption("Test")
			.withDescription("sdfgdfhg")
			.build();
		});
		
		notiButtonHigh.addClickListener(e -> {
			NotificationBuilder.get(notiCenter)
				.withCaption("Test")
				.withDescription("descriptifghhgjghjkfjhgjfhjfoikjrsadopherduiothjreouithruetijpertheriuhton")
				.withPriority(ENotificationPriority.HIGH)
				.withIcon(VaadinIcons.INFO)
				.withCloseButton()
				.build();
		});


		TopMenuButtonBuilder.get()
				.setCaption("Home")
				.setIcon(VaadinIcons.HOME)
				.setNavigateTo(HomePage.class)
				.build(hybridMenu);

	}

	private void buildLeftMenu(HybridMenu hybridMenu) {
		MenuButton homeButton = LeftMenuButtonBuilder.get()
				.withCaption("Home")
				.withIcon(VaadinIcons.HOME)
				.withNavigateTo(HomePage.class)
				.build();

		hybridMenu.addLeftMenuButton(homeButton);
		
		MenuButton themeBuilderButton = LeftMenuButtonBuilder.get()
				.withCaption("Theme Builder")
				.withIcon(FontAwesome.WRENCH)
				.withNavigateTo(ThemeBuilderPage.class)
				.build();

		hybridMenu.addLeftMenuButton(themeBuilderButton);

		MenuButton settingsButton = LeftMenuButtonBuilder.get()
				.withCaption("Settings")
				.withIcon(VaadinIcons.COGS)
				.withNavigateTo(SettingsPage.class)
				.build();

		hybridMenu.addLeftMenuButton(settingsButton);



		MenuSubMenu memberList = LeftMenuSubMenuBuilder.get()
				.setCaption("Member")
				.setIcon(VaadinIcons.USERS)
				.setConfig(hybridMenu.getConfig())
				.build(hybridMenu);

		memberList.addLeftMenuButton(LeftMenuButtonBuilder.get()
				.withCaption("Settings")
				.withIcon(VaadinIcons.COGS)
				.withNavigateTo(SettingsPage.class)
				.build());

		memberList.addLeftMenuButton(LeftMenuButtonBuilder.get()
				.withCaption("Member")
				.withIcon(VaadinIcons.USER)
				.withNavigateTo(MemberPage.class)
				.build());

		memberList.addLeftMenuButton(LeftMenuButtonBuilder.get()
				.withCaption("Group")
				.withIcon(VaadinIcons.USERS)
				.withNavigateTo(GroupPage.class)
				.build());


		MenuSubMenu memberListTwo = LeftMenuSubMenuBuilder.get()
				.setCaption("member")
				.setIcon(VaadinIcons.USERS)
				.setConfig(hybridMenu.getConfig())
				.build(memberList);

		memberListTwo.addLeftMenuButton(LeftMenuButtonBuilder.get()
				.withCaption("Settings")
				.withIcon(VaadinIcons.COGS)
				.withNavigateTo(SettingsPage.class)
				.build());

		memberListTwo.addLeftMenuButton(LeftMenuButtonBuilder.get()
				.withCaption("Member")
				.withIcon(VaadinIcons.USER)
				.withNavigateTo(MemberPage.class)
				.build());



		MenuSubMenu demoSettings = LeftMenuSubMenuBuilder.get()
			.setCaption("Settings")
			.setIcon(VaadinIcons.COGS)
			.setConfig(hybridMenu.getConfig())
			.build(hybridMenu);

		LeftMenuButtonBuilder.get()
			.withCaption("White Theme")
			.withIcon(VaadinIcons.PALETE)
			.withClickListener(e -> hybridMenu.switchTheme(DesignItem.getWhiteDesign()))
			.build(demoSettings);
		
		LeftMenuButtonBuilder.get()
			.withCaption("White Color Theme")
			.withIcon(VaadinIcons.PALETE)
			.withClickListener(e -> hybridMenu.switchTheme(DesignItem.getWhiteBlueDesign()))
			.build(demoSettings);

		LeftMenuButtonBuilder.get()
			.withCaption("Dark Theme")
			.withIcon(VaadinIcons.PALETE)
			.withClickListener(e -> hybridMenu.switchTheme(DesignItem.getDarkDesign()))
			.build(demoSettings);

		LeftMenuButtonBuilder.get()
			.withCaption("Toggle MinimalView")
			.withIcon(VaadinIcons.PALETE)
			.withClickListener(e -> hybridMenu.setLeftMenuMinimal(!hybridMenu.isLeftMenuMinimal()))
			.build(demoSettings);
	}
	
	public HybridMenu getHybridMenu() {
		return hybridMenu; 
	}
	
	@Override
	public void detach(DetachEvent event) {
		getUI().close();
	}
}
