package kaesdingeling.hybridmenu.components;

import java.util.HashSet;
import java.util.Set;

import com.vaadin.shared.ui.colorpicker.Color;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;

import kaesdingeling.hybridmenu.data.interfaces.ValueChangeListener;
import kaesdingeling.hybridmenu.design.DesignColor;

public class ColorPicker extends Button {
	private static final long serialVersionUID = 2366670234096059323L;
	
	private Color value = null;
	private boolean showCss = false;
	private Set<ValueChangeListener<Color>> valueChangeListenerList = new HashSet<ValueChangeListener<Color>>();

	public ColorPicker() {
		build();
	}
	
	public ColorPicker(boolean showCss) {
		this.showCss = showCss;
		build();
	}
	
	public ColorPicker(Color value) {
		this.value = value;
		build();
	}
	
	public ColorPicker(DesignColor value) {
		this.value = value.getColor();
		build();
	}
	
	public ColorPicker(Color value, boolean showCss) {
		this.showCss = showCss;
		this.value = value;
		build();
	}
	
	public void build() {
		setCaptionAsHtml(true);
		addClickListener(e -> {
			UI.getCurrent().addWindow(new ColorPickerWindow(this));
		});
		updateCaption();
	}
	private void updateCaption() {
		if (value == null) {
			value = Color.WHITE;
		}
		String caption = "<span style=\"background: rgb(" + value.getRed() + ", " + value.getGreen() + ", " + value.getBlue() + ");width: calc(100% - 4px);height: calc(100% - 4px);position: absolute;left: 2px;top: 2px;border-radius: 3px;\"></span>";
		if (showCss) {
			caption += "<span style=\"position: absolute;left: calc(100% + 8px);top: 4px;\">" + value.getCSS() + "</span>";
		}
		setCaption(caption);
	}
	public void addValueChangeListener(ValueChangeListener<Color> valueChangeListener) {
		valueChangeListenerList.add(valueChangeListener);
	}
	
	public Color getValue() {
		return value;
	}
	
	public DesignColor getDesignValue() {
		return DesignColor.get(value);
	}
	
	public void setValue(DesignColor value) {
		setValue(value.getColor());
	}
	
	public void setValue(Color value) {
		this.value = value;
		updateCaption();
		for (ValueChangeListener<Color> valueChangeListener : valueChangeListenerList) {
			valueChangeListener.change(value);
		}
	}
	public boolean isShowCss() {
		return showCss;
	}
	public void setShowCss(boolean showCss) {
		this.showCss = showCss;
	}
}