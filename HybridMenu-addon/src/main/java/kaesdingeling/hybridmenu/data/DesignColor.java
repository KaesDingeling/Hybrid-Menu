package kaesdingeling.hybridmenu.data;

import com.vaadin.shared.ui.colorpicker.Color;

public class DesignColor {
	private int red;
    private int green;
    private int blue;
    private int alpha;
    
    public DesignColor() {
    	
    }
    public DesignColor(Color color) {
    	convert(color);
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