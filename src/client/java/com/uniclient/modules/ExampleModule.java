package com.uniclient.modules;

import com.uniclient.module.Module;
import org.lwjgl.glfw.GLFW;

public class ExampleModule extends Module {

    public ExampleModule() {
        super("ExampleModule", GLFW.GLFW_KEY_R);
    }

    @Override
    protected void onEnable() {
        System.out.println("ExampleModule enabled");
    }

    @Override
    protected void onDisable() {
        System.out.println("ExampleModule disabled");
    }
}