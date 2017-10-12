package kaesdingeling.hybridmenu.data.enums;

public enum EMenuDesign {
	WHITE("design_white"), WHITE_BLUE("design_white_blue"), DARK("design_dark"), DARK_VAADIN_MATERIAL_CONFORM("design_dark_vaadin_material_conform");
	
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