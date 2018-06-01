package de.kaesdingeling.hybridmenu.demo;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcons;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import de.kaesdingeling.hybridmenu.demo.page.GroupPage;
import de.kaesdingeling.hybridmenu.demo.page.HomePage;
import de.kaesdingeling.hybridmenu.demo.page.MemberPage;
import de.kaesdingeling.hybridmenu.demo.page.NotificationBuilderPage;
import de.kaesdingeling.hybridmenu.demo.page.SettingsPage;
import de.kaesdingeling.hybridmenu.HybridMenu;
import de.kaesdingeling.hybridmenu.components.HMButton;
import de.kaesdingeling.hybridmenu.components.HMLabel;
import de.kaesdingeling.hybridmenu.components.HMSubMenu;
import de.kaesdingeling.hybridmenu.components.HMTextField;
import de.kaesdingeling.hybridmenu.components.LeftMenu;
import de.kaesdingeling.hybridmenu.components.TopMenu;
import de.kaesdingeling.hybridmenu.data.MenuConfig;
import de.kaesdingeling.hybridmenu.design.DesignItem;

@Push
@Theme(Lumo.class)
@BodySize(height = "100vh", width = "100vw")
public class DemoRouterLayout extends HybridMenu {
	private static final long serialVersionUID = 2766167599243004212L;

	@Override
	public boolean init(VaadinSession vaadinSession, UI ui) {
		withConfig(MenuConfig.get().withDesignItem(DesignItem.getWhiteDesign()));
		
		TopMenu topMenu = getTopMenu();
		
		topMenu.add(HMTextField.get(VaadinIcons.SEARCH, "Search ..."));
		
		topMenu.add(HMButton.get()
				.withIcon(VaadinIcons.HOME)
				.withDescription("Home")
				.withNavigateTo(HomePage.class));
		
		getNotificationCenter()
				.setNotiButton(topMenu.add(HMButton.get()
						.withDescription("Notifications")));
		
		LeftMenu leftMenu = getLeftMenu();
		
		leftMenu.add(HMLabel.get()
				.withCaption("<b>Hybrid</b> Menu")
				.withIcon(new Image("./frontend/logo.png", "HybridMenu Logo")));
		
		getBreadCrumbs().setRoot(leftMenu.add(HMButton.get()
				.withCaption("Home")
				.withIcon(VaadinIcons.HOME)
				.withNavigateTo(HomePage.class)));
		
		leftMenu.add(HMButton.get()
				.withCaption("Notification Builder")
				.withIcon(VaadinIcons.BELL)
				.withNavigateTo(NotificationBuilderPage.class));
		
		/*
		leftMenu.add(HMButton.get()
				.withCaption("Theme Builder")
				.withIcon(FontAwesome.WRENCH)
				.withNavigateTo(ThemeBuilderPage.class));
		*/

		HMSubMenu memberList = leftMenu.add(HMSubMenu.get()
				.withCaption("Member")
				.withIcon(VaadinIcons.USERS));
		
		memberList.add(HMButton.get()
				.withCaption("Settings")
				.withIcon(VaadinIcons.COGS)
				.withNavigateTo(SettingsPage.class));
		
		memberList.add(HMButton.get()
				.withCaption("Member")
				.withIcon(VaadinIcons.USERS)
				.withNavigateTo(MemberPage.class));
		
		memberList.add(HMButton.get()
				.withCaption("Group")
				.withIcon(VaadinIcons.USERS)
				.withNavigateTo(GroupPage.class));

		HMSubMenu memberListTwo = memberList.add(HMSubMenu.get()
				.withCaption("Member")
				.withIcon(VaadinIcons.USERS));

		memberListTwo.add(HMButton.get()
				.withCaption("Settings")
				.withIcon(VaadinIcons.COGS)
				.withNavigateTo(SettingsPage.class));
		
		memberListTwo.add(HMButton.get()
				.withCaption("Member")
				.withIcon(VaadinIcons.USERS)
				.withNavigateTo(MemberPage.class));


		HMSubMenu demoSettings = leftMenu.add(HMSubMenu.get()
				.withCaption("Settings")
				.withIcon(VaadinIcons.COGS));
		
		demoSettings.add(HMButton.get()
				.withCaption("White Theme")
				.withIcon(VaadinIcons.PALETE)
				.withClickListener(e -> switchTheme(DesignItem.getWhiteDesign())));

		demoSettings.add(HMButton.get()
				.withCaption("Dark Theme")
				.withIcon(VaadinIcons.PALETE)
				.withClickListener(e -> switchTheme(DesignItem.getDarkDesign())));
		
		demoSettings.add(HMButton.get()
				.withCaption("Minimal")
				.withIcon(VaadinIcons.COG)
				.withClickListener(e -> getLeftMenu().toggleSize()));
		
		
		return true; // build menu
	}
}