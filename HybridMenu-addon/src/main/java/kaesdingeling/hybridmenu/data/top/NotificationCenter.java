package kaesdingeling.hybridmenu.data.top;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
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
import kaesdingeling.hybridmenu.data.enums.EMenuNotificationCenterSort;

public class NotificationCenter {
	private MenuConfig menuConfig = null;
	private TopMenuSubContent subContent = null;
	private VerticalLayout notificationBox = null;
	private VerticalLayout notiMessages = null;
	private Button goToNotis = null;
	private Label emptyMessage = null;
	private Label title = null;
	private List<MenuNotification> notiList = new ArrayList<MenuNotification>();
	private SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy.MM.dd HH:mm");
	
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
		notificationBox.addComponentDetachListener(e -> {
			System.out.println("detach");
		});
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
			if (menuConfig.getMenuNotificationCenterSort().equals(EMenuNotificationCenterSort.DOWNWARDS)) {
				notiList.sort(Comparator.comparing(MenuNotification::getCreated));
			} else {
				notiList.sort(Comparator.comparing(MenuNotification::getCreated).reversed());
			}
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
		Label created = new Label();
		Button button = new Button();
		
		label.setCaption(menuNotification.getTitle());
		label.setValue(menuNotification.getDescription());
		label.setIcon(menuNotification.getIcon());
		created.setValue(dateFormatter.format(new Date(menuNotification.getCreated())));
		
		horizontalLayout.setPrimaryStyleName("notiMessage");
		label.setPrimaryStyleName("notiMessageContent");
		created.setPrimaryStyleName("notiMessageCreated");
		button.setPrimaryStyleName("notiMessageButton");
		
		created.setStyleName("created");
		
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
		horizontalLayout.addComponents(label, created, button);
		notiMessages.addComponent(horizontalLayout);
		refresh();
	}
	
	public void remove(MenuNotification menuNotification) {
		notiList.remove(menuNotification);
		notiMessages.removeComponent(menuNotification.get());
		refresh();
	}
	
	public List<MenuNotification> getAll() {
		return notiList;
	}
	
	public void removeAll() {
		removeAll(notiList);
	}
	
	public void removeAll(List<MenuNotification> menuNotificationList) {
		for (int i = 0; i < menuNotificationList.size(); i++) {
			remove(menuNotificationList.get(i));
		}
	}
	
	public void open(boolean open) {
		subContent.setOpen(open);
	}
	
	public boolean isOpen() {
		return subContent.isOpen();
	}
}