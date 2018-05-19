package kaesdingeling.hybridmenu.design;

public class DesignColor {
	private int red = 255;
    private int green = 255;
    private int blue = 255;
    private double alpha = 1;
    
    public static DesignColor get(int red, int green, int blue) {
    	return new DesignColor(red, green, blue);
    }
    public static DesignColor get(int red, int green, int blue, double alpha) {
    	return new DesignColor(red, green, blue, alpha);
    }
    public DesignColor(int red, int green, int blue) {
    	this.red = red;
    	this.green = green;
    	this.blue = blue;
    }
    public DesignColor(int red, int green, int blue, double alpha) {
    	this.red = red;
    	this.green = green;
    	this.blue = blue;
    	this.alpha = alpha;
    }
    
	public int getRed() {
		return red;
	}
	public DesignColor setRed(int red) {
		this.red = red;
		return this;
	}
	public int getGreen() {
		return green;
	}
	public DesignColor setGreen(int green) {
		this.green = green;
		return this;
	}
	public int getBlue() {
		return blue;
	}
	public DesignColor setBlue(int blue) {
		this.blue = blue;
		return this;
	}
	public double getAlpha() {
		return alpha;
	}
	public DesignColor setAlpha(double alpha) {
		this.alpha = alpha;
		return this;
	}
	public DesignColor copy() {
		return DesignColor.get(red, green, blue, alpha);
	}
}