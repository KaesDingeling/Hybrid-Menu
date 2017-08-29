package kaesdingeling.hybridmenu.builder;

import com.vaadin.server.Resource;
import com.vaadin.ui.HorizontalLayout;

import kaesdingeling.hybridmenu.data.top.MenuNotification;
import kaesdingeling.hybridmenu.data.top.NotificationCenter;

public class MenuNotificationCenter {
	private MenuNotification menuNotification;
	
	private MenuNotificationCenter(MenuNotification menuNotification) {
        this.menuNotification = menuNotification;
    }

    public static MenuNotificationCenter get(String title) {
        return new MenuNotificationCenter(new MenuNotification(title));
    }
    
    public static void remove(MenuNotification menuNotification) {
    	menuNotification.remove();
    }
    
    public static void add(MenuNotification menuNotification) {
    	menuNotification.add();
    }
    
    public static HorizontalLayout get(MenuNotification menuNotification) {
    	return menuNotification.get();
    }
    
    public MenuNotificationCenter withTitle(String title) {
    	menuNotification.setTitle(title);
    	return this;
    }
    
    public MenuNotificationCenter withIcon(Resource icon) {
    	menuNotification.setIcon(icon);
    	return this;
    }
    
    public MenuNotificationCenter withDescription(String description) {
    	menuNotification.setDescription(description);
    	return this;
    }
    
    public MenuNotification add(NotificationCenter notificationCenter) {
    	menuNotification.setNotificationCenter(notificationCenter);
    	menuNotification.add();
    	return menuNotification;
    }
}