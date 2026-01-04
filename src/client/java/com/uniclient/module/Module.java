package com.uniclient.module;

public abstract class Module {
    private final String name;
    private boolean enabled;
    private int key;

    public Module(String name, int key) {
        this.name = name;
        this.key = key;
    }

    public void toggle() {
        enabled = !enabled;
        if (enabled) onEnable();
        else onDisable();
    }

    protected void onEnable() {}
    protected void onDisable() {}

    public String getName() { return name; }
    public boolean isEnabled() { return enabled; }
    public int getKey() { return key; }
    public void setKey(int key) { this.key = key; }
}