package kaesdingeling.hybridmenu.design;

import com.vaadin.shared.ui.colorpicker.Color;

public class DesignColor {
	private int red = 255;
    private int green = 255;
    private int blue = 255;
    private int alpha = 255;
    
    public static DesignColor get() {
    	return new DesignColor();
    }
    public static DesignColor get(Color color) {
    	return new DesignColor(color);
    }
    public static DesignColor get(int red, int green, int blue) {
    	return new DesignColor(red, green, blue);
    }
    
    public DesignColor() {
    	
    }
    public DesignColor(Color color) {
    	convert(color);
    }
    public DesignColor(int red, int green, int blue) {
    	this.red = red;
    	this.green = green;
    	this.blue = blue;
    }
	public int getRed() {
		return red;
	}
	public void setRed(int red) {
		this.red = red;
	}
	public int getGreen() {
		return green;
	}
	public void setGreen(int green) {
		this.green = green;
	}
	public int getBlue() {
		return blue;
	}
	public void setBlue(int blue) {
		this.blue = blue;
	}
	public int getAlpha() {
		return alpha;
	}
	public void setAlpha(int alpha) {
		this.alpha = alpha;
	}
	public void convert(Color color) {
		red = color.getRed();
	    green = color.getGreen();
	    blue = color.getBlue();
	    alpha = color.getAlpha();
	}
	public Color getColor() {
		return new Color(red, green, blue, alpha);
	}
}