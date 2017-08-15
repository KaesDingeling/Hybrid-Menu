package kaesdingeling.hybridmenu.enums;

import kaesdingeling.hybridmenu.menu.variants.HybridMenuTypeCombined;
import kaesdingeling.hybridmenu.menu.variants.HybridMenuTypeLeft;
import kaesdingeling.hybridmenu.menu.variants.HybridMenuTypeTop;
import kaesdingeling.hybridmenu.menu.variants.HybridMenuVariant;

public enum EMenuType {
    LEFT(HybridMenuTypeLeft.class),
    TOP(HybridMenuTypeTop.class),
    COMBINED(HybridMenuTypeCombined.class);

    private Class<? extends HybridMenuVariant> variant;

    EMenuType(Class<? extends HybridMenuVariant> variant) {
        this.variant = variant;
    }

    public HybridMenuVariant getVariant() {
        try {
            return variant.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}