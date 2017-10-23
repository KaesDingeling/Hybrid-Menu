package kaesdingeling.hybridmenu.components;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

import kaesdingeling.hybridmenu.data.Notification;
import kaesdingeling.hybridmenu.data.top.TopMenuButton;
import kaesdingeling.hybridmenu.utils.STYLES;

public class NotificationCenter extends VerticalLayout {
	private static final long serialVersionUID = 8240675492290112083L;
	
	private List<Notification> notificationListLow = new ArrayList<Notification>();
	private List<Notification> notificationListMedium = new ArrayList<Notification>();
	private List<Notification> notificationListHigh = new ArrayList<Notification>();
	
	private boolean sortUpwards = true;
	private boolean showAll = false;
	
	private TopMenuButton notiButton = null;
	
	private Thread thread = null;
	
	public NotificationCenter(int initSleep) {
		setStyleName(STYLES.notificationList);
		setMargin(false);
		setSpacing(false);
		thread = runWhileAttached(this, new Runnable() {
			@Override
			public void run() {
				updateToolTip();
				updateItems();
			}
        }, initSleep);
	}
	
	public void add(Notification notification) {
		switch (notification.getPriority()) {
			case LOW:
				if (!notificationListLow.contains(notification)) {
					notification.show();
					notificationListLow.add(notification);
					notificationListMedium.remove(notification);
					notificationListHigh.remove(notification);
					updateList();
				}
				break;
			case MEDIUM:
				if (!notificationListMedium.contains(notification)) {
					notification.show();
					notificationListMedium.add(notification);
					notificationListLow.remove(notification);
					notificationListHigh.remove(notification);
					updateList();
				}
				break;
			case HIGH:
				if (!notificationListHigh.contains(notification)) {
					notification.show();
					notificationListHigh.add(notification);
					notificationListLow.remove(notification);
					notificationListMedium.remove(notification);
					updateList();
				}
				break;
			default:
				break;
		}
	}
	
	public void remove(Notification notification) {
		if (notification.isShow()) {
			notification.hide();
			notification.getContent().addStyleName(STYLES.notificationItemRemove);
		} else if (notification.toRemove()) {
			notificationListLow.remove(notification);
			notificationListMedium.remove(notification);
			notificationListHigh.remove(notification);
			removeComponent(notification.getContent());
		}
	}
	
	public void setNotificationButton(TopMenuButton notiButton) {
		this.notiButton = notiButton;
		notiButton.addClickListener(e -> {
			setShowAll(!isShowAll());
		});
		updateToolTip();
	}
	
	public void updateToolTip() {
		if (notiButton != null) {
			int unReaded = unReaded();
			if (unReaded > 0) {
				notiButton.setToolTip(String.valueOf(unReaded));
			} else {
				notiButton.setToolTip(null);
			}
		}
	}
	
	public void setShowAll(boolean showAll) {
		this.showAll = showAll;
		if (showAll) {
			for (Notification notification : notificationListHigh) {
				notification.show();
			}
			for (Notification notification : notificationListMedium) {
				notification.show();
			}
			for (Notification notification : notificationListLow) {
				notification.show();
			}
		} else {
			for (Notification notification : notificationListHigh) {
				notification.hide();
			}
			for (Notification notification : notificationListMedium) {
				notification.hide();
			}
			for (Notification notification : notificationListLow) {
				notification.hide();
			}
		}
	}
	
	public int unReaded() {
		int unReaded = 0;
		for (Notification notification : notificationListHigh) {
			if (!notification.isReaded()) {
				unReaded++;
			}
		}
		for (Notification notification : notificationListMedium) {
			if (!notification.isReaded()) {
				unReaded++;
			}
		}
		for (Notification notification : notificationListLow) {
			if (!notification.isReaded()) {
				unReaded++;
			}
		}
		return unReaded;
	}
	
	public boolean isShowAll() {
		return showAll;
	}
	
	public void sortDownwards() {
		sortUpwards = false;
	}
	
	public void sortUpwards() {
		sortUpwards = true;
	}
	
	public Thread getThread() {
		return thread;
	}
	
	private void updateList() {
		if (sortUpwards) {
			notificationListLow = notificationListLow.stream().sorted(Comparator.comparingLong(Notification::getCreated).reversed()).collect(Collectors.toList());
			notificationListMedium = notificationListMedium.stream().sorted(Comparator.comparingLong(Notification::getCreated).reversed()).collect(Collectors.toList());
			notificationListHigh = notificationListHigh.stream().sorted(Comparator.comparingLong(Notification::getCreated).reversed()).collect(Collectors.toList());
		} else {
			notificationListLow = notificationListLow.stream().sorted(Comparator.comparingLong(Notification::getCreated)).collect(Collectors.toList());
			notificationListMedium = notificationListMedium.stream().sorted(Comparator.comparingLong(Notification::getCreated)).collect(Collectors.toList());
			notificationListHigh = notificationListHigh.stream().sorted(Comparator.comparingLong(Notification::getCreated)).collect(Collectors.toList());
		}
		removeAllComponents();
		updateItems();
	}
	
	private void updateItems() {
		for (int i = 0; i < notificationListHigh.size(); i++) {
			updateItem(notificationListHigh.get(i));
		}
		for (int i = 0; i < notificationListMedium.size(); i++) {
			updateItem(notificationListMedium.get(i));
		}
		for (int i = 0; i < notificationListLow.size(); i++) {
			updateItem(notificationListLow.get(i));
		}
		updateToolTip();
	}
	
	private void updateItem(Notification notification) {
		if (notification.toRemove()) {
			remove(notification);
		} else {
			notification.update();
			addComponent(notification.getContent());
		}
	}
	
	public static Thread runWhileAttached(final Component component, final Runnable task, final int initSleep) {
        final Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(initSleep);
                    while (component.getUI() != null && component.getUI().isAttached()) {
                        Future<Void> future = component.getUI().access(task);
                        future.get();
                        Thread.sleep(initSleep);
                    }
                } catch (Exception e) {
                	e.printStackTrace();
                }
            }
        };
        thread.start();
        return thread;
    }
}