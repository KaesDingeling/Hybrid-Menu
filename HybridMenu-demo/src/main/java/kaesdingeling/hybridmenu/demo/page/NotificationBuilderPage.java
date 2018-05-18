package kaesdingeling.hybridmenu.demo.page;

import java.util.concurrent.Future;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Slider;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import kaesdingeling.hybridmenu.components.Notification;
import kaesdingeling.hybridmenu.components.NotificationCenter;
import kaesdingeling.hybridmenu.data.enums.NotificationPosition;

public class NotificationBuilderPage extends VerticalLayout implements View {
	private static final long serialVersionUID = 1L;

	@Override
	public void enter(ViewChangeEvent event) {
		Label title = new Label();
		
		title.setCaption("Notification Builder");
		title.setValue("Here you can click a notification together");
		
		FormLayout form = new FormLayout();
		
		form.setSizeFull();
		
		HorizontalLayout outputPosition = new HorizontalLayout(new Button("Top", e -> VaadinSession.getCurrent().getAttribute(NotificationCenter.class).setNotificationPosition(NotificationPosition.TOP)), new Button("Bottom", e -> VaadinSession.getCurrent().getAttribute(NotificationCenter.class).setNotificationPosition(NotificationPosition.BOTTOM)));
		
		TextField caption = new TextField("Title");
		TextArea content = new TextArea("Content");
		
		ComboBox<VaadinIcons> icon = new ComboBox<VaadinIcons>("Icon");
		
		icon.setItemIconGenerator((i) -> i);
		icon.setItems(VaadinIcons.values());
		
		Slider displayTime = new Slider("Display time (ms)");
		
		displayTime.setMin(1000);
		displayTime.setMax(10000);
		displayTime.setValue(5000.0);
		displayTime.addStyleName("ticks");
		
		CheckBox closeable = new CheckBox("Closeable");
		
		CheckBox autoRemove = new CheckBox("Autoremove");
		
		CheckBox makeAsReaded = new CheckBox("Make as readed");
		
		CheckBox showDescriptionOnPopup = new CheckBox("Show description on popup");
		
		showDescriptionOnPopup.setValue(true);
		
		Slider autoRemoveTime = new Slider("Autoremove display offset delay (ms)");
		
		autoRemoveTime.setMin(0);
		autoRemoveTime.setMax(5000);
		autoRemoveTime.setValue(0.0);
		autoRemoveTime.addStyleName("ticks");
		
		Button execute = new Button("Execute", VaadinIcons.CODE);
		
		//execute.setDisableOnClick(true);
		execute.addClickListener(e -> {
			NotificationCenter notificationCenter = VaadinSession.getCurrent().getAttribute(NotificationCenter.class);
			
			if (notificationCenter.queueSize() < 10) {
				Notification notification = Notification.get()
						.withTitle(caption.getValue())
						.withContent(content.getValue())
						.withIcon(icon.getValue())
						.withDisplayTime(displayTime.getValue().longValue());
				
				if (closeable.getValue()) {
					notification.withCloseable();
				}
				
				if (makeAsReaded.getValue()) {
					notification.makeAsReaded();
				}
				
				if (autoRemove.getValue()) {
					if (autoRemoveTime.getValue() > 0) {
						notification.withAutoRemove(autoRemoveTime.getValue().longValue());
					} else {
						notification.withAutoRemove();
					}
				}
				
				notificationCenter.add(notification, showDescriptionOnPopup.getValue());
			}
		});
		
		caption.setWidth(100, Unit.PERCENTAGE);
		content.setWidth(100, Unit.PERCENTAGE);
		icon.setWidth(100, Unit.PERCENTAGE);
		displayTime.setWidth(100, Unit.PERCENTAGE);
		closeable.setWidth(100, Unit.PERCENTAGE);
		makeAsReaded.setWidth(100, Unit.PERCENTAGE);
		autoRemove.setWidth(100, Unit.PERCENTAGE);
		autoRemoveTime.setWidth(100, Unit.PERCENTAGE);
		
		form.addComponents(outputPosition, caption, content, icon, displayTime, closeable, makeAsReaded, autoRemove, autoRemoveTime, execute);
		
		addComponents(title, form);
	}
	
	public static void runOneAttached(final Component component, final Runnable task, final int initialPause) {
        final Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                	if (initialPause > 0) {
                		Thread.sleep(initialPause);
                	}
                	if (component.getUI() != null && component.getUI().isAttached()) {
	                    Future<Void> future = component.getUI().access(task);
	                    future.get();
	                }
                } catch (Exception e) {
                	e.printStackTrace();
                }
            }
        };
        thread.start();
    }

}