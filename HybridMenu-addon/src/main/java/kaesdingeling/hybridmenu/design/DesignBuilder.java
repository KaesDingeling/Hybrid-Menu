package kaesdingeling.hybridmenu.design;

import java.util.ArrayList;
import java.util.List;

import kaesdingeling.hybridmenu.HybridMenu;

public class DesignBuilder extends DesignClass {
	public static DesignBuilder get() {
		return new DesignBuilder();
	}
	
	public DesignBuilder() {
		super(null, "." + HybridMenu.CLASS_NAME);
	}
	
	@Override
	public DesignClass and() {
		return this;
	}
	
	public String build() {
		List<String> lines = new ArrayList<String>();
		
		String styles = "";
		
		for (DesignClass child : childs) {
			child.build(styleClass, lines);
		}
		
		for (String line : lines) {
			styles += line;
		}
		
		return styles;
	}
}