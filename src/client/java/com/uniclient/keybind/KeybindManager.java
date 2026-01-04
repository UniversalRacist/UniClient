package com.uniclient.keybind;

import com.uniclient.module.Module;
import com.uniclient.module.ModuleManager;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;

public class KeybindManager {

    public static void init() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (MinecraftClient.getInstance().currentScreen != null) return;

            for (Module module : ModuleManager.getModules()) {
                if (module.getKey() != 0 &&
                    GLFW.glfwGetKey(client.getWindow().getHandle(), module.getKey()) == GLFW.GLFW_PRESS) {
                    module.toggle();
                }
            }
        });
    }
}