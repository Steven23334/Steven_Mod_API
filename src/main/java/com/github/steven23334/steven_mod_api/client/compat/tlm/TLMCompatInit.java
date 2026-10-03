package com.github.steven23334.steven_mod_api.client.compat.tlm;

import com.github.steven23334.steven_mod_api.network.OpenApiContainerC2SPacket;
import com.github.tartaricacid.touhoulittlemaid.api.event.client.MaidContainerGuiEvent;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.network.PacketDistributor;

public final class TLMCompatInit {
    private TLMCompatInit() {}

    public static void init() {
        NeoForge.EVENT_BUS.register(TLMCompatInit.class);
    }

    @SubscribeEvent
    public static void onMaidContainerInit(MaidContainerGuiEvent.Init event) {
        int x = event.getLeftPos() + 169;
        int y = event.getTopPos() + 5;

        // 关键：如果当前 GUI 就是 ApiContainerGui，说明已经打开 API 页面 → 高亮
        boolean selected = event.getGui() instanceof ApiContainerGui;

        event.addButton("steven_mod_api:api_tab",
                new ApiTabButton(x, y, selected,
                        Component.literal("API 界面"),
                        Component.literal("打开 API 界面"),
                        b -> {
                            // 已经在 API 页面就不重复打开
                            if (!(event.getGui() instanceof ApiContainerGui)) {
                                PacketDistributor.sendToServer(
                                        new OpenApiContainerC2SPacket(event.getGui().getMaid().getId()));
                            }
                        }));
    }
}