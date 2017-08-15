package kaesdingeling.hybridmenu.enums;

import kaesdingeling.hybridmenu.menu.variants.HybridMenuTypeCombined;
import kaesdingeling.hybridmenu.menu.variants.HybridMenuTypeLeft;
import kaesdingeling.hybridmenu.menu.variants.HybridMenuTypeTop;
import kaesdingeling.hybridmenu.menu.variants.HybridMenuVariant;

public enum EMenuType {
    LEFT(new HybridMenuTypeLeft()),
    TOP(new HybridMenuTypeTop()),
    COMBINED(new HybridMenuTypeCombined());

    private HybridMenuVariant variant;

    EMenuType(HybridMenuVariant variant) {
        this.variant = variant;
    }

    public HybridMenuVariant getVariant() {
        return variant;
    }

}