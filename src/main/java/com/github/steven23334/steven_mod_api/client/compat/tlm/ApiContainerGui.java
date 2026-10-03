package com.github.steven23334.steven_mod_api.client.compat.tlm;

import com.github.steven23334.steven_mod_api.client.screen.ApiScreenContributor;
import com.github.steven23334.steven_mod_api.client.screen.ApiScreenRegistry;
import com.github.steven23334.steven_mod_api.compat.tlm.ApiContainer;
import com.github.tartaricacid.touhoulittlemaid.client.gui.entity.maid.AbstractMaidContainerGui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

import java.util.List;

public class ApiContainerGui extends AbstractMaidContainerGui<ApiContainer> {

    private static final String KEY_TITLE = "gui.steven_mod_api.maid_screen_title";
    private static final String KEY_ID_FORMAT = "gui.steven_mod_api.id_format";

    public ApiContainerGui(ApiContainer menu, Inventory inventory, Component title) {
        super(menu, inventory, Component.translatable(KEY_TITLE));
    }

    @Override
    protected void initAdditionWidgets() {
        // 不加任何 widget
    }

    @Override
    protected void renderAddition(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        // 标题
        graphics.drawCenteredString(font, Component.translatable(KEY_TITLE),
                leftPos + 164, topPos + 36, 0xFF404040);

        // 内容区：只显示第一个 contributor 的 ID
        List<ApiScreenContributor> contributors = ApiScreenRegistry.getAll();
        if (contributors.isEmpty()) {
            return;
        }
        ApiScreenContributor current = contributors.getFirst();
        graphics.drawString(font, Component.translatable(KEY_ID_FORMAT, current.id()),
                leftPos + 90, topPos + 50, 0xFF404040, false);
    }
}