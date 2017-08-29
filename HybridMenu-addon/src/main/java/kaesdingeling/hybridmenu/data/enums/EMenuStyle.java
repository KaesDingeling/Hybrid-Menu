package kaesdingeling.hybridmenu.data.enums;

public enum EMenuStyle {
	LABEL_TITLE("labelTitle"), ICON_RIGHT("iconRight"), PROFILVIEW("profilView");
	
	private String name = null;
	
	EMenuStyle(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name();
	}

	public String getName() {
		return name;
	}
}