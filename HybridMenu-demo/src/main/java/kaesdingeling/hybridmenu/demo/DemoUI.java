package kaesdingeling.hybridmenu.demo;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import kaesdingeling.hybridmenu.HybridMenu;
import kaesdingeling.hybridmenu.builder.HybridMenuBuilder;
import kaesdingeling.hybridmenu.builder.MenuNotificationCenter;
import kaesdingeling.hybridmenu.builder.left.LeftMenuButtonBuilder;
import kaesdingeling.hybridmenu.builder.left.LeftMenuSubMenuBuilder;
import kaesdingeling.hybridmenu.builder.top.TopMenuButtonBuilder;
import kaesdingeling.hybridmenu.builder.top.TopMenuLabelBuilder;
import kaesdingeling.hybridmenu.builder.top.TopMenuSubContentBuilder;
import kaesdingeling.hybridmenu.data.enums.EMenuComponents;
import kaesdingeling.hybridmenu.data.enums.EMenuDesign;
import kaesdingeling.hybridmenu.data.enums.EMenuStyle;
import kaesdingeling.hybridmenu.data.leftmenu.MenuButton;
import kaesdingeling.hybridmenu.data.leftmenu.MenuSubMenu;
import kaesdingeling.hybridmenu.data.top.NotificationCenter;
import kaesdingeling.hybridmenu.data.top.TopMenuButton;
import kaesdingeling.hybridmenu.data.top.TopMenuSubContent;
import kaesdingeling.hybridmenu.demo.page.GroupPage;
import kaesdingeling.hybridmenu.demo.page.HomePage;
import kaesdingeling.hybridmenu.demo.page.MemberPage;
import kaesdingeling.hybridmenu.demo.page.SettingsPage;

@Theme("demo")
@Title("HybridMenu Add-on Demo")
@SuppressWarnings("serial")
public class DemoUI extends UI {
    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = true, ui = DemoUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
    	HybridMenu hybridMenu = HybridMenuBuilder.get()
    			.setContent(new VerticalLayout())
    			.setMenuComponent(EMenuComponents.LEFT_WITH_TOP)
    			.setDesign(EMenuDesign.DEFALT_DARK)
    			.build();
    	
    	UI.getCurrent().getNavigator().addView(HomePage.class.getSimpleName(), HomePage.class);
    	UI.getCurrent().getNavigator().addView(GroupPage.class.getSimpleName(), GroupPage.class);
    	UI.getCurrent().getNavigator().addView(MemberPage.class.getSimpleName(), MemberPage.class);
    	UI.getCurrent().getNavigator().addView(SettingsPage.class.getSimpleName(), SettingsPage.class);
    	
    	MenuButton homeButton = LeftMenuButtonBuilder.get()
    			.setCaption("Home")
    			.setIcon(VaadinIcons.HOME)
    			.navigateTo(HomePage.class)
    			.build();
    	
    	hybridMenu.addLeftMenuButton(homeButton);
    	
    	MenuButton settingsButton = LeftMenuButtonBuilder.get()
    			.setCaption("Settings")
    			.setIcon(VaadinIcons.COGS)
    			.navigateTo(SettingsPage.class)
    			.build();
    	
    	hybridMenu.addLeftMenuButton(settingsButton);
    	
    	
    	
    	MenuSubMenu memberList = LeftMenuSubMenuBuilder.get()
    			.setCaption("Member")
    			.setIcon(VaadinIcons.USERS)
    			.setConfig(hybridMenu.getConfig())
    			.build(hybridMenu);
    	
    	memberList.addLeftMenuButton(LeftMenuButtonBuilder.get()
    			.setCaption("Settings")
    			.setIcon(VaadinIcons.COGS)
    			.navigateTo(SettingsPage.class)
    			.build());
    	
    	memberList.addLeftMenuButton(LeftMenuButtonBuilder.get()
    			.setCaption("Member")
    			.setIcon(VaadinIcons.USER)
    			.navigateTo(MemberPage.class)
    			.build());
    	
    	memberList.addLeftMenuButton(LeftMenuButtonBuilder.get()
    			.setCaption("Group")
    			.setIcon(VaadinIcons.USERS)
    			.navigateTo(GroupPage.class)
    			.build());
    	
    	
    	MenuSubMenu memberListTwo = LeftMenuSubMenuBuilder.get()
    			.setCaption("member")
    			.setIcon(VaadinIcons.USERS)
    			.setConfig(hybridMenu.getConfig())
    			.build(memberList);
    	
    	memberListTwo.addLeftMenuButton(LeftMenuButtonBuilder.get()
    			.setCaption("Settings")
    			.setIcon(VaadinIcons.COGS)
    			.navigateTo(SettingsPage.class)
    			.build());
    	
    	memberListTwo.addLeftMenuButton(LeftMenuButtonBuilder.get()
    			.setCaption("Member")
    			.setIcon(VaadinIcons.USER)
    			.navigateTo(MemberPage.class)
    			.build());
    	
    	
    	
    	MenuSubMenu demoSettings = LeftMenuSubMenuBuilder.get()
    			.setCaption("Settings")
    			.setIcon(VaadinIcons.COGS)
    			.setConfig(hybridMenu.getConfig())
    			.build(hybridMenu);
    	
    	MenuButton darkThemeButton = LeftMenuButtonBuilder.get()
    			.setCaption("Dark Theme")
    			.setIcon(VaadinIcons.PALETE)
    			.setUseOwnListener(true)
    			.build();
    	darkThemeButton.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				hybridMenu.switchTheme(EMenuDesign.DEFALT_DARK);
			}
		});
    	demoSettings.addLeftMenuButton(darkThemeButton);
    	
    	MenuButton whiteThemeButton = LeftMenuButtonBuilder.get()
    			.setCaption("White Theme")
    			.setIcon(VaadinIcons.PALETE)
    			.setUseOwnListener(true)
    			.build();
    	whiteThemeButton.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				hybridMenu.switchTheme(EMenuDesign.DEFAULT);
			}
		});
    	demoSettings.addLeftMenuButton(whiteThemeButton);
    	
    	MenuButton toggleMinimalViewButton = LeftMenuButtonBuilder.get()
    			.setCaption("Toggle MinimalView")
    			.setIcon(VaadinIcons.PALETE)
    			.setUseOwnListener(true)
    			.build();
    	toggleMinimalViewButton.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				hybridMenu.setLeftMenuMinimal(!hybridMenu.isLeftMenuMinimal());
			}
		});
    	demoSettings.addLeftMenuButton(toggleMinimalViewButton);
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
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
    	
    	NotificationCenter notificationCenter = new NotificationCenter("No notifications found!", "Notifications", Alignment.MIDDLE_RIGHT, hybridMenu);
    	
    	notificationCenter.setShowAllButton("See All Notifications >", e -> {
    		
    	});
    	
    	TopMenuLabelBuilder.get()
    			.setCaption("<b>Hybrid</b> Menu")
    			.addStyleName(EMenuStyle.LABEL_TITLE)
    			.setIcon(new ThemeResource("images/hybridmenu-Logo.png"))
    			.build(hybridMenu);
    	
    	TopMenuButton testNoti = TopMenuButtonBuilder.get()
				.setCaption("Add test noti")
				.setIcon(VaadinIcons.BELL_O)
				.setUseOwnListener(true)
				.build(hybridMenu);
    	
    	testNoti.addClickListener(e -> {
    		MenuNotificationCenter.get("Test")
    			.withDescription("deasdasd")
    			.withIcon(VaadinIcons.ANCHOR)
    			.add(notificationCenter);
    	});
    	
    	
    	TopMenuButtonBuilder.get()
				.setCaption("Home")
				.setIcon(VaadinIcons.HOME)
				.setNavigateTo(HomePage.class)
				.build(hybridMenu);
    	
    	setContent(hybridMenu);
    	VaadinSession.getCurrent().setAttribute(HybridMenu.class, hybridMenu);
    }
}
