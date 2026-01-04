package com.uniclient.gui;

public class GuiAnimation {

    private float value = 0f;
    private final float speed = 0.15f;

    public void reset() {
        value = 0f;
    }

    public void update() {
        value += (1f - value) * speed;
    }

    public float get() {
        return value;
    }
}