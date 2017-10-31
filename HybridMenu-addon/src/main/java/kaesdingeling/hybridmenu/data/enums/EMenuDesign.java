package kaesdingeling.hybridmenu.data.enums;

public enum EMenuDesign {
	/**
	 * @deprecated 	this function is no longer supported as of version 3.0.0 (2018 at the earliest)
	 * 				please use DesignItem.getWhiteDesign()
	 */
	@Deprecated
	WHITE("design_white"),
	/**
	 * @deprecated 	this function is no longer supported as of version 3.0.0 (2018 at the earliest)
	 * 				please use DesignItem.getWhiteBlueDesign()
	 */
	@Deprecated
	WHITE_BLUE("design_white_blue"),
	/**
	 * @deprecated 	this function is no longer supported as of version 3.0.0 (2018 at the earliest)
	 * 				please use DesignItem.getDarkDesign()
	 */
	@Deprecated
	DARK("design_dark"),
	/**
	 * @deprecated 	this function is no longer supported as of version 3.0.0 (2018 at the earliest)
	 * 				please use DesignItem.getDarkDesign()
	 */
	@Deprecated
	DARK_VAADIN_MATERIAL_CONFORM("design_dark");

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