package kaesdingeling.hybridmenu.data;

import com.vaadin.ui.Alignment;

public abstract class MenuTopItem extends MenuItem {
	private Alignment alignment = null;
	
	public Alignment getAlignment() {
		if (alignment == null) {
			alignment = Alignment.MIDDLE_LEFT;
		}
		return alignment;
	}
	public void setAlignment(Alignment alignment) {
		this.alignment = alignment;
	}
}