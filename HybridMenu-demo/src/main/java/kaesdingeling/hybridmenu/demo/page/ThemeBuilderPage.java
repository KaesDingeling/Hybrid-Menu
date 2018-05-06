package kaesdingeling.hybridmenu.demo.page;

import com.google.gson.Gson;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Slider;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import kaesdingeling.hybridmenu.components.ColorPicker;
import kaesdingeling.hybridmenu.components.Notification;
import kaesdingeling.hybridmenu.components.NotificationCenter;
import kaesdingeling.hybridmenu.demo.DemoUI;
import kaesdingeling.hybridmenu.design.DesignColor;
import kaesdingeling.hybridmenu.design.DesignItem;

public class ThemeBuilderPage extends VerticalLayout implements View {
	private static final long serialVersionUID = 1L;
	
	private DesignItem designItem = null;
	private boolean lockForLoad = true;

	/* Colors */
	private FormLayout colorsForm = buildForm("Colors");
	private ColorPicker darkColor = buildPicker(colorsForm, "Dark-Color");
	private ColorPicker whiteColor = buildPicker(colorsForm, "White-Color");
	
	/* Content-Background */
	private FormLayout contentBackgroundForm = buildForm("Content-Background");
	private ColorPicker contentBackground = buildPicker(contentBackgroundForm, "Content-Background");
	
	/* Notifications */
	private FormLayout notificationForm = buildForm("Notifications");
	private ColorPicker notificationBackground = buildPicker(notificationForm, "Notification-Background");
	private Slider notificationShadow = buildSlider(notificationForm, "Notification-Shadow");
	private ColorPicker notificationRemoveButtonHover = buildPicker(notificationForm, "Notification-Remove-Button-Hover");
	
	/* Left-Menu */
	private FormLayout leftMenuForm = buildForm("Left-Menu");
	private ColorPicker leftMenuBackground = buildPicker(leftMenuForm, "Left-Menu-Background");
	private ColorPicker menuLeftButtonHover = buildPicker(leftMenuForm, "Left-Menu-Button-Hover");
	private ColorPicker menuLeftButtonActive = buildPicker(leftMenuForm, "Left-Menu-Button-Active");
	
	/* ToolTip */
	private FormLayout tooltip = buildForm("ToolTip");
	private ColorPicker tooltipBackground = buildPicker(tooltip, "Left-Menu-Button-Tooltip");
	private ColorPicker tooltipActiveBackground = buildPicker(tooltip, "Left-Menu-Button-Active-Tooltip");
	
	private TextArea jsonOutput = new TextArea("JSON-Output");
	
	private Button importButton = new Button("Import JSON");

	@Override
	public void enter(ViewChangeEvent event) {
		Label title = new Label();
		
		title.setCaption("Theme Builder");
		title.setValue("Here you have the possibility to create your own colour scheme");
		
		jsonOutput.setWidth("100%");
		jsonOutput.setHeight("500px");
		
		HorizontalLayout defaultThemes = new HorizontalLayout(new Button("Dark Theme", e -> {
			lockForLoad = true;
			designItem = DesignItem.getDarkDesign();
			load();
			update();
			lockForLoad = false;
		}), new Button("White Theme", e -> {
			lockForLoad = true;
			designItem = DesignItem.getWhiteDesign();
			load();
			update();
			lockForLoad = false;
		}));

		addComponents(title, defaultThemes, colorsForm, contentBackgroundForm, notificationForm, leftMenuForm, tooltip, jsonOutput, importButton);
		
		buildNewObject();
		load();
		
		importButton.addClickListener(e -> {
			lockForLoad = true;
			try {
				designItem = new Gson().fromJson(jsonOutput.getValue(), DesignItem.class);
				VaadinSession.getCurrent().getAttribute(NotificationCenter.class).add(Notification.get()
						.withCloseable()
						.withTitle("Import successful")
						.withIcon(VaadinIcons.INFO)
						.withAutoRemove()
						.withContent("The design adapts itself automatically"));
			} catch (Exception e2) {
				VaadinSession.getCurrent().getAttribute(NotificationCenter.class).add(Notification.get()
						.withCloseable()
						.withTitle("Import failed")
						.withIcon(VaadinIcons.INFO)
						.withAutoRemove()
						.withContent("The entry was rejected: " + e2.getMessage()));
				buildNewObject();
			} finally {
				load();
				update();
				lockForLoad = false;
			}
		});
		
		update();
		lockForLoad = false;
	}
	
	private void load() {
		/* Colors */
		darkColor.setValue(designItem.getDarkColor());
		whiteColor.setValue(designItem.getWhiteColor());
		
		/* Content-Background */
		contentBackground.setValue(designItem.getContentBackground());
		
		/* Left-Menu */
		leftMenuBackground.setValue(designItem.getMenuLeftBackground());
		menuLeftButtonHover.setValue(designItem.getMenuLeftButtonHover());
		menuLeftButtonActive.setValue(designItem.getMenuLeftButtonActive());
		
		/* Notifications */
		notificationBackground.setValue(designItem.getNotificationBackground());
		notificationShadow.setValue(designItem.getNotificationShadow());
		notificationRemoveButtonHover.setValue(designItem.getNotificationRemoveButtonHover());
		
	    /* tooltip */
		tooltipBackground.setValue(designItem.getTooltipBackground());
		tooltipActiveBackground.setValue(designItem.getTooltipActiveBackground());
	}
	
	private void write() {
		if (!lockForLoad) {
			/* Colors */
			designItem.setDarkColor(DesignColor.get(darkColor.getValue()));
			designItem.setWhiteColor(DesignColor.get(whiteColor.getValue()));
			
			/* Content-Background */
			designItem.setContentBackground(DesignColor.get(contentBackground.getValue()));
			
			/* Notifications */
			designItem.setNotificationBackground(DesignColor.get(notificationBackground.getValue()));
			designItem.setNotificationShadow(notificationShadow.getValue());
			designItem.setNotificationRemoveButtonHover(DesignColor.get(notificationRemoveButtonHover.getValue()));
			
			/* Left-Menu */
			designItem.setMenuLeftBackground(DesignColor.get(leftMenuBackground.getValue()));
			designItem.setMenuLeftButtonHover(DesignColor.get(menuLeftButtonHover.getValue()));
			designItem.setMenuLeftButtonActive(DesignColor.get(menuLeftButtonActive.getValue()));
			
			/* tooltip */
			designItem.setTooltipBackground(DesignColor.get(tooltipBackground.getValue()));
			designItem.setTooltipActiveBackground(DesignColor.get(tooltipActiveBackground.getValue()));
		}
	}
	
	private void update() {
		write();
		((DemoUI) UI.getCurrent()).getHybridMenu().switchTheme(designItem);
		jsonOutput.setValue(new Gson().toJson(designItem));
	}
	
	private void buildNewObject() {
		designItem = DesignItem.getDarkDesign();
	}

	private FormLayout buildForm(String caption) {
		FormLayout formLayout = new FormLayout();
		formLayout.setCaption(caption);
		return formLayout;
	}

	private ColorPicker buildPicker(Layout layout, String caption) {
		HorizontalLayout content = new HorizontalLayout();
		ColorPicker colorPicker = new ColorPicker(true);
		content.setCaption(caption);
		colorPicker.addValueChangeListener(e -> update());
		content.addComponent(colorPicker);
		layout.addComponent(content);
		return colorPicker;
	}
	
	private Slider buildSlider(Layout layout, String caption) {
		HorizontalLayout content = new HorizontalLayout();
		Slider slider = new Slider();
		Label hexCode = new Label();
		content.setCaption(caption);
		slider.setMin(0.0);
		slider.setMax(100.0);
		slider.addStyleName("ticks");
		slider.setWidth("300px");
		slider.addValueChangeListener(e -> {
			hexCode.setValue(String.valueOf(((Double) slider.getValue()).intValue()) + " %");
			update();
		});
		hexCode.setValue(String.valueOf(((Double) slider.getValue()).intValue()) + " %");
		content.addComponents(slider, hexCode);
		layout.addComponent(content);
		return slider;
	}
}