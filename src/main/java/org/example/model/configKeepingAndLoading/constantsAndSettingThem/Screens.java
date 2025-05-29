package org.example.model.configKeepingAndLoading.constantsAndSettingThem;

public enum Screens {
    MENU ("menu"),
    GAME("game"),
    SETTINGS("settings"),;
    private String name;
    Screens(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
