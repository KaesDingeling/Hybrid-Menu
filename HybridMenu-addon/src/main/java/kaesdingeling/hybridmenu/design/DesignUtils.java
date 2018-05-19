package kaesdingeling.hybridmenu.design;

public class DesignUtils {
	private static DesignColor whiteColor = null;
	private static DesignColor darkColor = null;
	
	public static void setWhiteColor(DesignColor color) {
		whiteColor = color;
	}
	
	public static void setDarkColor(DesignColor color) {
		darkColor = color;
	}
	
	public static String hmBackgroundWithColor(DesignColor background) {
		String style = background(background);
		style += color(hmColorDedect(background));
		return style;
	}
	
	public static String background(DesignColor background) {
		return background(background, 100);
	}
	
	public static String background(DesignColor background, double alpha) {
		return "background: " + colorToRGBA(background, alpha) + " !important;";
	}
	
	public static String color(DesignColor color) {
		return color(color, 100);
	}
	
	public static String color(DesignColor color, double alpha) {
		return "color: " + colorToRGBA(color, alpha) + " !important;";
	}
	
	public static String border(DesignColor color, String position) {
		return border(color, position, 100);
	}
	
	public static String border(DesignColor color, String position, double alpha) {
		return "border-" + position + "-" + color(color, alpha) + " !important;";
	}
	
	public static DesignColor hmColorDedect(DesignColor background) {
		if (background.getRed() + background.getGreen() + background.getBlue() < 3 * 128) {
			return whiteColor;
		} else {
			return darkColor;
		}
	}
	
	public static String colorToRGB(DesignColor color) {
		return "rgb(" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ")";
	}
	
	public static String colorToRGBA(DesignColor color, double alpha) {
		return "rgba(" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ", " + alpha / 100.00 + ")";
	}
}