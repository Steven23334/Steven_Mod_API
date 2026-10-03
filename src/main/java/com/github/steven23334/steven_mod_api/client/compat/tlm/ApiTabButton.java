package com.github.steven23334.steven_mod_api.client.compat.tlm;

import com.github.steven23334.steven_mod_api.ModItems;
import com.github.tartaricacid.touhoulittlemaid.TouhouLittleMaid;
import com.github.tartaricacid.touhoulittlemaid.api.client.gui.ITooltipButton;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class ApiTabButton extends Button implements ITooltipButton {
    private static final ResourceLocation SIDE =
            ResourceLocation.fromNamespaceAndPath(TouhouLittleMaid.MOD_ID, "textures/gui/maid_gui_side.png");
    private static final int TAB_TEXTURE_X = 182;

    private final Component tooltipTitle;
    private final Component tooltipDesc;

    public ApiTabButton(int x, int y, boolean selected,
                        Component tooltipTitle, Component tooltipDesc, OnPress onPress) {
        super(Button.builder(Component.empty(), onPress).pos(x, y).size(24, 26));
        this.active = !selected;
        this.tooltipTitle = tooltipTitle;
        this.tooltipDesc = tooltipDesc;
    }

    @Override
    protected void renderWidget(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        RenderSystem.enableDepthTest();
        if (!this.active) {
            graphics.blit(SIDE, getX(), getY(), TAB_TEXTURE_X, 21, width, height, 256, 256);
        }
        graphics.renderItem(ModItems.ICON_ITEM.get().getDefaultInstance(), getX() + 4, getY() + 6);
    }

    @Override
    public boolean isTooltipHovered() {
        return this.active && this.isHovered();
    }

    @Override
    public void renderTooltip(GuiGraphics graphics, Minecraft mc, int mouseX, int mouseY) {
        Font font = Minecraft.getInstance().font;
        graphics.renderComponentTooltip(font, List.of(tooltipTitle, tooltipDesc), mouseX, mouseY);
    }
}