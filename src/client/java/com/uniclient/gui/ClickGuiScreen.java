package com.uniclient.gui;

import com.uniclient.module.Module;
import com.uniclient.module.ModuleManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGuiScreen extends Screen {

    private final GuiAnimation animation = new GuiAnimation();

    private int startX = 40;
    private int startY = 40;
    private int width = 120;
    private int height = 18;

    public ClickGuiScreen() {
        super(Text.literal("UniClient"));
    }

    @Override
    protected void init() {
        animation.reset();
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        animation.update();

        float scale = animation.get();

        context.getMatrices().push();
        context.getMatrices().scale(scale, scale, 1f);

        // Background
        context.fill(0, 0,
                (int) (this.width / scale),
                (int) (this.height / scale),
                0xFF000000);

        int y = startY;

        for (Module module : ModuleManager.getModules()) {
            int color = module.isEnabled()
                    ? 0xFFFFFFFF
                    : 0xFF555555;

            context.fill(startX, y, startX + width, y + height, 0xFF111111);

            context.drawText(
                    textRenderer,
                    module.getName(),
                    startX + 6,
                    y + 5,
                    color,
                    false
            );

            y += height + 4;
        }

        context.getMatrices().pop();
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button != 0) return false;

        int y = startY;

        for (Module module : ModuleManager.getModules()) {
            if (mouseX >= startX && mouseX <= startX + width &&
                mouseY >= y && mouseY <= y + height) {

                module.toggle();
                return true;
            }
            y += height + 4;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}