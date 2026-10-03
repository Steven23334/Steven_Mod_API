package com.github.steven23334.steven_mod_api.network;

import com.github.steven23334.steven_mod_api.StevenModAPI;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public record OpenApiContainerC2SPacket(int entityId) implements CustomPacketPayload {
    public static final Type<OpenApiContainerC2SPacket> TYPE =
            new Type<>(ResourceLocation.fromNamespaceAndPath(StevenModAPI.MOD_ID, "open_api_container"));

    public static final StreamCodec<FriendlyByteBuf, OpenApiContainerC2SPacket> STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.VAR_INT, OpenApiContainerC2SPacket::entityId,
                    OpenApiContainerC2SPacket::new);

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}