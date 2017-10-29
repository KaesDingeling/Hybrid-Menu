package kaesdingeling.hybridmenu.components;

import com.vaadin.shared.ui.colorpicker.Color;
import com.vaadin.ui.AbstractColorPicker.Coordinates2Color;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Slider;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.components.colorpicker.ColorPickerGradient;
import com.vaadin.ui.components.colorpicker.ColorPickerPreview;
import com.vaadin.ui.themes.ValoTheme;

public class ColorPickerWindow extends Window {
	private static final long serialVersionUID = 6096067828360570112L;
	
	private Color color = null;
	private Color orginalValue = null;
	
	private TabSheet tabs = new TabSheet();
	private VerticalLayout content = new VerticalLayout();
	private HorizontalLayout footer = new HorizontalLayout();
	
	private Button okButton = new Button("Ok");
	private Button cancelButton = new Button("Cancel");
	
	/* RGB - Tab */
	private ColorPickerPreview colorRgbPreview = null;
	private ColorPickerGradient colorRgbGradient = null;
	private Slider redRgbSlider = null;
	private Slider greenRgbSlider = null;
	private Slider blueRgbSlider = null;
	
	public ColorPickerWindow(ColorPicker colorPicker) {
		color = colorPicker.getValue();
		orginalValue = new Color(colorPicker.getValue().getRed(), colorPicker.getValue().getGreen(), colorPicker.getValue().getBlue(), colorPicker.getValue().getAlpha());
		
		tabs.setSizeFull();
		tabs.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);
		tabs.addStyleName(ValoTheme.TABSHEET_ICONS_ON_TOP);
		tabs.addStyleName(ValoTheme.TABSHEET_CENTERED_TABS);
		tabs.setSelectedTab(1);
		
		content.setSizeFull();
		content.setMargin(false);
		content.addComponent(tabs);
		content.setExpandRatio(tabs, 1f);
		
		okButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
		okButton.addClickListener(e -> {
			colorPicker.setValue(color);
			close();
		});
		
		cancelButton.setStyleName(ValoTheme.BUTTON_DANGER);
		cancelButton.addClickListener(e -> {
			colorPicker.setValue(orginalValue);
			close();
		});
		
		footer.addComponents(okButton, cancelButton);
		footer.setComponentAlignment(okButton, Alignment.MIDDLE_CENTER);
		footer.setComponentAlignment(cancelButton, Alignment.MIDDLE_CENTER);
		footer.addStyleName(ValoTheme.WINDOW_BOTTOM_TOOLBAR);
		footer.setWidth(100.0f, Unit.PERCENTAGE);
		
		content.addComponent(footer);
		
		center();
		setClosable(false);
		setResizable(false);
		setWidth("400px");
		setHeight("680px");
		setContent(content);
		
        tabs.addComponent(rgbTab());
	}
	
	private VerticalLayout rgbTab() {
		VerticalLayout rgbTab = new VerticalLayout();
		rgbTab.setCaption("RGB");
		rgbTab.setWidth(100.0f, Unit.PERCENTAGE);
		rgbTab.setSpacing(true);
		rgbTab.setMargin(false);
		
		colorRgbPreview = new ColorPickerPreview(color);
		colorRgbPreview.addValueChangeListener(e -> update(e.getValue()));
		
		colorRgbGradient = new ColorPickerGradient("rgb-gradient", rgbConverter);
		colorRgbGradient.addValueChangeListener(e -> update(e.getValue()));
		colorRgbGradient.setValue(color);
		
		VerticalLayout sliders = new VerticalLayout();
        sliders.setStyleName("rgb-sliders");
        
        redRgbSlider = new Slider("Red", 0, 255);
        greenRgbSlider = new Slider("Green", 0, 255);
        blueRgbSlider = new Slider("Blue", 0, 255);
        
        redRgbSlider.setValue(color.getRed() + 0.0);
        greenRgbSlider.setValue(color.getGreen() + 0.0);
        blueRgbSlider.setValue(color.getBlue() + 0.0);
        
        redRgbSlider.setStyleName("rgb-slider");
        greenRgbSlider.setStyleName("rgb-slider");
        blueRgbSlider.setStyleName("rgb-slider");

        redRgbSlider.setWidth("90%");
        greenRgbSlider.setWidth("90%");
        blueRgbSlider.setWidth("90%");
        
        redRgbSlider.addStyleName("red");
        greenRgbSlider.addStyleName("green");
        blueRgbSlider.addStyleName("blue");
        
        redRgbSlider.addStyleName("ticks");
        greenRgbSlider.addStyleName("ticks");
        blueRgbSlider.addStyleName("ticks");
        
        redRgbSlider.addValueChangeListener(e -> update(new Color(e.getValue().intValue(), color.getGreen(), color.getBlue(), color.getAlpha())));
        greenRgbSlider.addValueChangeListener(e -> update(new Color(color.getRed(), e.getValue().intValue(), color.getBlue(), color.getAlpha())));
        blueRgbSlider.addValueChangeListener(e -> update(new Color(color.getRed(), color.getGreen(), e.getValue().intValue(), color.getAlpha())));
        
        sliders.addComponents(redRgbSlider, greenRgbSlider, blueRgbSlider);
        sliders.setComponentAlignment(redRgbSlider, Alignment.MIDDLE_CENTER);
        sliders.setComponentAlignment(greenRgbSlider, Alignment.MIDDLE_CENTER);
        sliders.setComponentAlignment(blueRgbSlider, Alignment.MIDDLE_CENTER);
        
        rgbTab.addComponents(colorRgbPreview, colorRgbGradient, sliders);
        rgbTab.setComponentAlignment(colorRgbGradient, Alignment.MIDDLE_CENTER);
        rgbTab.setComponentAlignment(sliders, Alignment.MIDDLE_CENTER);
        
        return rgbTab;
	}
	
	private void update(Color color) {
		if (!this.color.getCSS().equals(color.getCSS())) {
			this.color = color;
			colorRgbPreview.setValue(color);
			colorRgbGradient.setValue(color);
			redRgbSlider.setValue(color.getRed() + 0.0);
	        greenRgbSlider.setValue(color.getGreen() + 0.0);
	        blueRgbSlider.setValue(color.getBlue() + 0.0);
		}
	}
    
    /** An RGB color converter. */
    private Coordinates2Color rgbConverter = new Coordinates2Color() {
		private static final long serialVersionUID = 5791469391054350784L;

		@Override
        public Color calculate(int x, int y) {
            float h = x / 220f;
            float s = 1f;
            float v = 1f;

            if (y < 110) {
                s = y / 110f;
            } else if (y > 110) {
                v = 1f - (y - 110f) / 110f;
            }

            return new Color(Color.HSVtoRGB(h, s, v));
        }

        @Override
        public int[] calculate(Color color) {

            float[] hsv = color.getHSV();

            int x = Math.round(hsv[0] * 220f);
            int y = 0;

            // lower half
            if (hsv[1] == 1f) {
                y = Math.round(110f - (hsv[1] + hsv[2]) * 110f);
            } else {
                y = Math.round(hsv[1] * 110f);
            }

            return new int[] { x, y };
        }
    };
}