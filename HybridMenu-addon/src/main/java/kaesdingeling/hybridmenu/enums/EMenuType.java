package kaesdingeling.hybridmenu.enums;

import kaesdingeling.hybridmenu.menu.variants.HybridMenuTypeCombined;
import kaesdingeling.hybridmenu.menu.variants.HybridMenuTypeLeft;
import kaesdingeling.hybridmenu.menu.variants.HybridMenuTypeTop;
import kaesdingeling.hybridmenu.menu.variants.HybridMenuVariant;

public enum EMenuType {
    LEFT, TOP, COMBINED;

    EMenuType() {
    }

    public HybridMenuVariant getVariant() {
        switch (this) {
            case LEFT:
                return new HybridMenuTypeLeft();
            case TOP:
                return new HybridMenuTypeTop();
            case COMBINED:
                return new HybridMenuTypeCombined();
        }
        return null;
    }

}