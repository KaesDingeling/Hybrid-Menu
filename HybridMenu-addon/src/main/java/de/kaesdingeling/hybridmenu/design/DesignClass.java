package de.kaesdingeling.hybridmenu.design;

import java.util.ArrayList;
import java.util.List;

public class DesignClass {
	protected final DesignClass parent;
	protected final String styleClass;
	protected List<String> parameters = new ArrayList<String>();
	protected List<DesignClass> childs = new ArrayList<DesignClass>();
	
	public DesignClass(DesignClass parent, String styleClass) {
		this.parent = parent;
		this.styleClass = styleClass;
	}
	
	public DesignClass and() {
		return parent;
	}
	
	public DesignClass with(String styleClass) {
		DesignClass newDesignClass = new DesignClass(this, styleClass);
		childs.add(newDesignClass);
		return newDesignClass;
	}
	
	public DesignClass add(String parameter) {
		parameters.add(parameter);
		return this;
	}
	
	public void build(String parentStyleClass, List<String> lines) {
		if (styleClass.startsWith("&")) {
			parentStyleClass += styleClass.substring(1);
		} else {
			parentStyleClass += " " + styleClass;
		}
		
		String style = "";
		
		for (String parameter : parameters) {
			style += parameter;
		}
		
		if (!style.isEmpty()) {
			lines.add(parentStyleClass + " {" + style + "}");
		}
		
		for (DesignClass child : childs) {
			child.build(parentStyleClass, lines);
		}
	}
}