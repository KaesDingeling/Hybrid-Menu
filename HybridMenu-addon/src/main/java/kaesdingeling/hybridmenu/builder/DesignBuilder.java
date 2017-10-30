package kaesdingeling.hybridmenu.builder;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.shared.ui.colorpicker.Color;

import kaesdingeling.hybridmenu.HybridMenu;
import kaesdingeling.hybridmenu.data.DesignColor;

public class DesignBuilder {
	private String path = null;
	private List<String> values = new ArrayList<String>();
	private Color whiteColor = null;
	private Color darkColor = null;
	
	public static DesignBuilder get() {
		return new DesignBuilder();
	}
	
	public DesignBuilder withWhiteColor(Color whiteColor) {
		this.whiteColor = whiteColor;
		return this;
	}
	
	public DesignBuilder withWhiteColor(DesignColor color) {
		this.whiteColor = color.getColor();
		return this;
	}
	
	public DesignBuilder withDarkColor(Color darkColor) {
		this.darkColor = darkColor;
		return this;
	}
	
	public DesignBuilder withDarkColor(DesignColor color) {
		this.darkColor = color.getColor();
		return this;
	}
	
	public DesignBuilder newBuilder() {
		return DesignBuilder.get().withDarkColor(darkColor).withWhiteColor(whiteColor);
	}
	
	public DesignBuilder withClass(String path) {
		this.path = path;
		return this;
	}
	
	public DesignBuilder withColor(DesignColor color) {
		return this.withValue("color: " + colorToRGB(color) + ";");
	}
	
	public DesignBuilder withColorImp(DesignColor color) {
		return this.withValue("color: " + colorToRGB(color) + " !important;");
	}
	
	public DesignBuilder withColor(DesignColor color, double alpha) {
		return this.withValue("color: " + colorToRGBA(color, alpha) + ";");
	}
	
	public DesignBuilder withDetectColor(DesignColor color) {
		return this.withValue("color: " + colorToRGB(colorDetect(color)) + ";");
	}
	
	public DesignBuilder withDetectColor(DesignColor color, double alpha) {
		return this.withValue("color: " + colorToRGBA(colorDetect(color), alpha) + ";");
	}
	
	public DesignBuilder withBackground(DesignColor color) {
		return this.withValue("background: " + colorToRGB(color) + ";");
	}
	
	public DesignBuilder withBackground(DesignColor color, double alpha) {
		return this.withValue("background: " + colorToRGBA(color, alpha) + ";");
	}
	
	public DesignBuilder withDetectBackground(DesignColor color) {
		return this.withValue("background: " + colorToRGB(colorDetect(color)) + ";");
	}
	
	public DesignBuilder withDetectBackground(DesignColor color, double alpha) {
		return this.withValue("background: " + colorToRGBA(colorDetect(color), alpha) + ";");
	}
	
	public DesignBuilder withBorderLeftColor(DesignColor color) {
		return this.withValue("border-left-color: " + colorToRGB(color) + ";");
	}
	
	public DesignBuilder withBorderLeftColor(DesignColor color, double alpha) {
		return this.withValue("border-left-color: " + colorToRGBA(color, alpha) + ";");
	}
	
	public DesignBuilder withDetectBorderLeftColor(DesignColor color) {
		return this.withValue("border-left-color: " + colorToRGB(colorDetect(color)) + ";");
	}
	
	public DesignBuilder withDetectBorderLeftColor(DesignColor color, double alpha) {
		return this.withValue("border-left-color: " + colorToRGBA(colorDetect(color), alpha) + ";");
	}
	
	public DesignBuilder withBoxShadow(int val1, int val2, int val3, int val4, DesignColor color) {
		return this.withValue("box-shadow: " + val1 + " " + val2 + " " + val3 + " " + val4 + " " + colorToRGB(color) + ";");
	}
	
	public DesignBuilder withBoxShadow(int val1, int val2, int val3, int val4, String color) {
		return this.withValue("box-shadow: " + val1 + "px " + val2 + "px " + val3 + "px " + val4 + "px " + color + ";");
	}
	
	public DesignBuilder withValue(String value) {
		values.add(value);
		return this;
	}
	
	public String build() {
		String content = "." + HybridMenu.CLASS_NAME;
		if (path != null) {
			content += " " + path;
		}
		String values = "";
		for (String value : this.values) {
			values += value;
		}
		content += " { " + values + "} ";
		return content;
	}
	
	private Color colorDetect(DesignColor color) {
		if (color.getRed() + color.getGreen() + color.getBlue() < 3 * 128) {
			return whiteColor;
		} else {
			return darkColor;
		}
	}
	
	public static String colorToRGB(DesignColor color) {
		return "rgb(" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ")";
	}
	
	public static String colorToRGB(Color color) {
		return colorToRGB(new DesignColor(color));
	}
	
	public static String colorToRGBA(DesignColor color, double alpha) {
		return "rgba(" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ", " + alpha + ")";
	}
	
	public static String colorToRGBA(Color color, double alpha) {
		return colorToRGBA(new DesignColor(color), alpha);
	}
}