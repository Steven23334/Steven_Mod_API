package com.github.steven23334.steven_mod_api.client.screen;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.util.function.Supplier;

public interface ApiScreenContributor {

    String KEY_ID_FORMAT = "gui.steven_mod_api.id_format";

    String id();
    Component displayName();
    Supplier<Screen> screenFactory();

    /**
     * 内容区预览。tab 点击后显示这个。默认渲染名称和 ID。
     * 子模组可以覆盖它，把自己的界面画进内容区。
     */
    default void renderPreview(GuiGraphics graphics, Font font,
                               int x, int y, int width, int height,
                               int mouseX, int mouseY) {
        graphics.drawString(font, displayName(), x, y, 0xFFF0E2C7, false);
        graphics.drawString(font, Component.translatable(KEY_ID_FORMAT, id()),
                x, y + 16, 0xFF858585, false);
    }
}