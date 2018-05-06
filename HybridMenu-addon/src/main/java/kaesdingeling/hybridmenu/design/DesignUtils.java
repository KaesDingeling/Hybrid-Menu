package kaesdingeling.hybridmenu.design;

import com.vaadin.shared.ui.colorpicker.Color;

public class DesignUtils {
	private static Color whiteColor = null;
	private static Color darkColor = null;
	
	public static void setWhiteColor(Color color) {
		whiteColor = color;
	}
	
	public static void setWhiteColor(DesignColor color) {
		whiteColor = color.getColor();
	}
	
	public static void setDarkColor(Color color) {
		darkColor = color;
	}
	
	public static void setDarkColor(DesignColor color) {
		darkColor = color.getColor();
	}
	
	public static String hmBackgroundWithColor(DesignColor color) {
		return hmBackgroundWithColor(color.getColor());
	}
	
	public static String hmBackgroundWithColor(Color background) {
		String style = background(background);
		style += color(hmColorDedect(background));
		return style;
	}
	
	public static String background(DesignColor background) {
		return background(background.getColor());
	}
	
	public static String background(Color background) {
		return background(background, 100);
	}
	
	public static String background(DesignColor background, double alpha) {
		return background(background.getColor(), alpha);
	}
	
	public static String background(Color background, double alpha) {
		return "background: " + colorToRGBA(background, alpha) + " !important;";
	}
	
	public static String color(DesignColor color) {
		return color(color.getColor());
	}
	
	public static String color(Color color) {
		return color(color, 100);
	}
	
	public static String color(DesignColor color, double alpha) {
		return color(color.getColor(), alpha);
	}
	
	public static String color(Color color, double alpha) {
		return "color: " + colorToRGBA(color, alpha) + " !important;";
	}
	
	public static String border(DesignColor color, String position) {
		return border(color.getColor(), position);
	}
	
	public static String border(Color color, String position) {
		return border(color, position, 100);
	}
	
	public static String border(DesignColor color, String position, double alpha) {
		return border(color.getColor(), position, alpha);
	}
	
	public static String border(Color color, String position, double alpha) {
		return "border-" + position + "-" + color(color, alpha) + " !important;";
	}
	
	public static Color hmColorDedect(DesignColor background) {
		return hmColorDedect(background.getColor());
	}
	
	public static Color hmColorDedect(Color background) {
		if (background.getRed() + background.getGreen() + background.getBlue() < 3 * 128) {
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
		return "rgba(" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ", " + alpha / 100.00 + ")";
	}
	
	public static String colorToRGBA(Color color, double alpha) {
		return colorToRGBA(new DesignColor(color), alpha);
	}
}