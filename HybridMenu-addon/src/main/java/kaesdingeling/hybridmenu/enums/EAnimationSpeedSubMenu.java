package kaesdingeling.hybridmenu.enums;

import kaesdingeling.hybridmenu.styles.HybridMenuStyles;

public enum EAnimationSpeedSubMenu {
    NONE(HybridMenuStyles.SUBMENU_ANIMATION_SPEED_NONE),
    SLOW(HybridMenuStyles.SUBMENU_ANIMATION_SPEED_SLOW),
    MEDIUM(HybridMenuStyles.SUBMENU_ANIMATION_SPEED_MEDIUM),
    HIGH(HybridMenuStyles.SUBMENU_ANIMATION_SPEED_FAST),
    FAST(HybridMenuStyles.SUBMENU_ANIMATION_SPEED_VERY_FAST);

    private final String style;

    EAnimationSpeedSubMenu(String speed) {
        this.style = speed;
    }

    public String getStyle() {
        return style;
    }
}