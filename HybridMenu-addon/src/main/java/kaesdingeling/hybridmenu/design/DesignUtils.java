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
		return element("background", colorToRGBA(background));
	}
	
	public static String color(DesignColor color) {
		return element("color", colorToRGBA(color));
	}
	
	public static String border(DesignColor color, String position) {
		return element("border-" + position + "-color", colorToRGBA(color));
	}
	
	public static String boxShadow(int left, int top, int shadow, int width, DesignColor color) {
		return element("box-shadow", left + "px " + top + "px " + shadow + "px " + width + "px " + colorToRGBA(color));
	}
	
	public static String element(String element, String value) {
		return element(element, value, false);
	}
	
	public static String element(String element, String value, boolean important) {
		return element + ": " + value + (important ? " !important;" : ";");
	}
	
	public static String colorToRGBA(DesignColor color) {
		if (color.getAlpha() == 1) {
			return "rgb(" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ")";
		} else {
			return "rgba(" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ", " + color.getAlpha() + ")";
		}
	}
	
	public static DesignColor hmColorDedect(DesignColor background) {
		if (background.getRed() + background.getGreen() + background.getBlue() < 3 * 128) {
			return whiteColor;
		} else {
			return darkColor;
		}
	}
}