package kaesdingeling.hybridmenu.data.top;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import kaesdingeling.hybridmenu.HybridMenu;
import kaesdingeling.hybridmenu.builder.top.TopMenuSubContentBuilder;
import kaesdingeling.hybridmenu.data.MenuConfig;

public class NotificationCenter {
	private MenuConfig menuConfig = null;
	private TopMenuSubContent subContent = null;
	private VerticalLayout notificationBox = null;
	private VerticalLayout notiMessages = null;
	private Button goToNotis = null;
	private Label emptyMessage = null;
	private Label title = null;
	private List<MenuNotification> notiList = new ArrayList<MenuNotification>();
	
	@Deprecated
	public NotificationCenter() {
	}
	
	public NotificationCenter(String emptyMessage, String title, Alignment alignment, HybridMenu hybridMenu) {
		buildStep1(alignment, hybridMenu);
		if (title != null) {
			buildStep2(title);
		}
		buildStep3(emptyMessage);
	}
	
	public NotificationCenter(String emptyMessage, Alignment alignment, HybridMenu hybridMenu) {
		buildStep1(alignment, hybridMenu);
		buildStep3(emptyMessage);
	}
	
	private void buildStep1(Alignment alignment, HybridMenu hybridMenu) {
		menuConfig = hybridMenu.getConfig();
		if (menuConfig == null) {
			menuConfig = new MenuConfig();
		}
		subContent = TopMenuSubContentBuilder.get()
    			.setButtonIcon(menuConfig.getNotificationCenterEmptyIcon())
    			.setAlignment(alignment)
    			.build(hybridMenu);
		subContent.getButton().addStyleName("captionOutside");
		notificationBox = subContent.getSubContent();
		notificationBox.setWidth("350px");
		notificationBox.addStyleName("notificationBox");
	}
	
	private void buildStep2(String title) {
		if (title != null) {
			this.title = new Label(title);
			this.title.setPrimaryStyleName("notificationTitle");
			notificationBox.addComponent(this.title);
		}
	}
	
	private void buildStep3(String emptyMessage) {
		this.emptyMessage = new Label(emptyMessage);
		this.emptyMessage.setPrimaryStyleName("notificationEmptyMessage");
		notiMessages = new VerticalLayout();
		notiMessages.setSpacing(false);
		notiMessages.setMargin(false);
		notiMessages.setWidth("100%");
		notiMessages.setPrimaryStyleName("messageBox");
		notificationBox.addComponents(this.emptyMessage, notiMessages);
		refresh();
	}
	
	public void setShowAllButton(String caption, ClickListener clickListener) {
		goToNotis = new Button(caption, clickListener);
		goToNotis.setPrimaryStyleName("goToNotisButton");
		notificationBox.addComponent(goToNotis);
	}
	
	public void refresh() {
		if (notiList.size() == 0 && notiMessages.isVisible()) {
			emptyMessage.setVisible(true);
			notiMessages.setVisible(false);
			subContent.getButton().setIcon(menuConfig.getNotificationCenterEmptyIcon());
			subContent.getButton().setToolTip(null);
		} else if (!notiMessages.isVisible()) {
			emptyMessage.setVisible(false);
			notiMessages.setVisible(true);
			subContent.getButton().setIcon(menuConfig.getNotificationCenterIcon());
			subContent.getButton().setToolTip(String.valueOf(notiList.size()));
		} else {
			subContent.getButton().setToolTip(String.valueOf(notiList.size()));
		}
	}
	
	public void add(MenuNotification menuNotification) {
		notiList.add(menuNotification);
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		Label label = new Label();
		Button button = new Button();
		
		label.setCaption(menuNotification.getTitle());
		label.setValue(menuNotification.getDescription());
		label.setIcon(menuNotification.getIcon());
		
		horizontalLayout.setPrimaryStyleName("notiMessage");
		label.setPrimaryStyleName("notiMessageContent");
		button.setPrimaryStyleName("notiMessageButton");
		
		button.setIcon(menuConfig.getNotificationRemoveIcon());
		
		if (menuNotification.getNotificationCenter() == null) {
			menuNotification.setNotificationCenter(this);
		}
		menuNotification.setMessageLayout(horizontalLayout);
		
		button.addClickListener(e -> {
			remove(menuNotification);
		});
		
		horizontalLayout.setWidth("100%");
		horizontalLayout.setMargin(false);
		horizontalLayout.setSpacing(false);
		horizontalLayout.addComponents(label, button);
		notiMessages.addComponent(horizontalLayout);
		refresh();
	}
	
	public void remove(MenuNotification menuNotification) {
		notiList.remove(menuNotification);
		notiMessages.removeComponent(menuNotification.get());
		refresh();
	}
}