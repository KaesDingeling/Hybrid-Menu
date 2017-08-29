package kaesdingeling.hybridmenu.data.enums;

public enum EMenuAnimationSpeed {
	NONE(null), LOW("animiLow"), MIDDLE("animiMiddle"), HIGH("animiHigh"), FAST("animiFast");
	
	private String name = null;
	
	EMenuAnimationSpeed(String name) {
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