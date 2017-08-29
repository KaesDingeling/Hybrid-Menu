package kaesdingeling.hybridmenu.data.enums;

public enum EMenuDesign {
	DEFAULT("hybridTheme_default"), DEFALT_DARK("hybridTheme_default_dark");
	
	private String name = null;
	
	EMenuDesign(String name) {
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