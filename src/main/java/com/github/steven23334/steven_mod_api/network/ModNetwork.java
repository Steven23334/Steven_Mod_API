package com.github.steven23334.steven_mod_api.network;

import com.github.steven23334.steven_mod_api.StevenModAPI;
import com.github.steven23334.steven_mod_api.compat.tlm.ApiContainer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber(modid = StevenModAPI.MOD_ID)
public final class ModNetwork {
    private ModNetwork() {}

    @SubscribeEvent
    public static void register(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar("1");
        registrar.playToServer(
                OpenApiContainerC2SPacket.TYPE,
                OpenApiContainerC2SPacket.STREAM_CODEC,
                (payload, context) -> context.enqueueWork(() -> {
                    var player = context.player();
                    // 关键：第二个参数把 entityId 写进发往客户端的 buffer
                    player.openMenu(ApiContainer.create(payload.entityId()),
                            buf -> buf.writeInt(payload.entityId()));
                }));
    }
}