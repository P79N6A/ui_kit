package com.hipac.uikit;

public final class UIKitConfig {

    private boolean hotMapEnable;

    private UIKitConfig() {
    }

    public static UIKitConfig getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public boolean isHotMapEnable() {
        return hotMapEnable;
    }

    public void setHotMapEnable(boolean hotMapEnable) {
        this.hotMapEnable = hotMapEnable;
    }

    private static final class InstanceHolder {
        private static final UIKitConfig INSTANCE = new UIKitConfig();
    }

}
