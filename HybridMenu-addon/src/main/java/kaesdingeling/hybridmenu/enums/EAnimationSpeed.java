package kaesdingeling.hybridmenu.enums;

import kaesdingeling.hybridmenu.styles.HybridMenuStyles;

public enum EAnimationSpeed {
    NONE(HybridMenuStyles.ANIMATION_SPEED_NONE),
    SLOW(HybridMenuStyles.ANIMATION_SPEED_SLOW),
    MEDIUM(HybridMenuStyles.ANIMATION_SPEED_MEDIUM),
    HIGH(HybridMenuStyles.ANIMATION_SPEED_FAST),
    FAST(HybridMenuStyles.ANIMATION_SPEED_VERY_FAST);

    private final String style;

    EAnimationSpeed(String speed) {
        this.style =  speed;
    }

    public String getStyle() {
        return style;
    }
}