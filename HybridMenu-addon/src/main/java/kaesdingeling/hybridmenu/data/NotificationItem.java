package kaesdingeling.hybridmenu.data;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Component;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import kaesdingeling.hybridmenu.enums.EMenuPosition;

public class NotificationItem extends MenuItem {
	private NativeButton button = new NativeButton();
	private VerticalLayout notificationsList = new VerticalLayout();
	
	public NotificationItem() {
		build();
	}
	
	public NotificationItem(String desc) {
		button.setDescription(desc);
		build();
	}
	
	private void build() {
		super.setMenuPosition(EMenuPosition.TOP);
		super.setButton(button);
		super.setComponent(notificationsList);
		notificationsList.setStyleName("notiContainerBox");
		button.setCaptionAsHtml(true);
		buildButtonCaption();
		ClickListener buttonClickListener = new ClickListener() {
			private static final long serialVersionUID = -3682549455759888061L;
			@Override
			public void buttonClick(ClickEvent event) {
				notificationsList.setVisible(!notificationsList.isVisible());
			}
		};
		button.addClickListener(buttonClickListener);
		super.setButtonClickListener(buttonClickListener);
		notificationsList.setVisible(false);
	}
	
	public int sizeAll() {
		return notificationsList.getComponentCount();
	}
	
	public int size() {
		int returnValue = 0;
		for (int i = 0; i < sizeAll(); i++) {
			if (!notificationsList.getComponent(i).getStyleName().contains("readed")) {
				returnValue++;
			}
		}
		return returnValue;
	}
	
	public void clear() {
		notificationsList.removeAllComponents();
	}
	
	public void removeNotification(Component component) {
		notificationsList.removeComponent(component);
		buildButtonCaption();
	}
	
	public void addNotification(Component component) {
		notificationsList.addComponent(component);
		buildButtonCaption();
	}
	
	private void buildButtonCaption() {
		button.setCaption(VaadinIcons.BELL.getHtml() + "<i class=\"notiCounter\">" + size() + "</i>");
	}
}