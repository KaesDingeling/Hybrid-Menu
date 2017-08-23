package kaesdingeling.hybridmenu.enums;

import kaesdingeling.hybridmenu.menu.variants.*;

public enum EMenuType {
    LEFT(HybridMenuTypeLeft.class),
    TOP(HybridMenuTypeTop.class),
    COMBINED(HybridMenuTypeCombined.class),
    RESPONSIVE(HybridMenuTypeResponsive.class);

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