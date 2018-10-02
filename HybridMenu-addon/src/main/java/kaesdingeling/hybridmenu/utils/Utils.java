package kaesdingeling.hybridmenu.utils;

import kaesdingeling.hybridmenu.data.interfaces.MenuComponent;

public class Utils {
	public static <C extends MenuComponent<?>> C setDefaults(C c) {
		c.setPrimaryStyleName(c.getRootStyle());
		return c;
	}
	
	public static <C extends MenuComponent<?>> C setTopMenuDefaults(C c) {
		if (c.getCaption() != null && !c.getCaption().trim().isEmpty()) {
			c.setCaption(null);
		}
		c.setPrimaryStyleName(c.getRootStyle());
		return c;
	}
}