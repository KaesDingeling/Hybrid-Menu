package kaesdingeling.hybridmenu.data.enums;

public enum MenuDesign {
	WHITE("white"),
	DARK("dark");

	private String name = null;

	MenuDesign(String name) {
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