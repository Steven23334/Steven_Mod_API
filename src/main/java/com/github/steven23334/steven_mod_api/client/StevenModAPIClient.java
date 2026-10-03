package com.github.steven23334.steven_mod_api.client;

import com.github.steven23334.steven_mod_api.ModMenus;
import com.github.steven23334.steven_mod_api.StevenModAPI;
import com.github.steven23334.steven_mod_api.client.compat.tlm.ApiContainerGui;
import com.github.steven23334.steven_mod_api.client.compat.tlm.TLMCompatInit;
import com.github.steven23334.steven_mod_api.client.screen.ApiScreenContributor;
import com.github.steven23334.steven_mod_api.client.screen.ApiScreenRegistry;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(modid = StevenModAPI.MOD_ID, value = Dist.CLIENT)
public final class StevenModAPIClient {
    private StevenModAPIClient() {}

    @SubscribeEvent
    public static void onRegisterMenuScreens(RegisterMenuScreensEvent event) {
        if (!ModList.get().isLoaded("touhou_little_maid")) {
            return;
        }
        event.register(ModMenus.API_CONTAINER.get(), ApiContainerGui::new);
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        ApiScreenRegistry.register(new ApiScreenContributor() {
            @Override
            public String id() {
                return StevenModAPI.MOD_ID + ":main";
            }

            @Override
            public Component displayName() {
                return Component.literal("API 主界面");
            }

            @Override
            public java.util.function.Supplier<net.minecraft.client.gui.screens.Screen> screenFactory() {
                return () -> null;
            }
        });

        if (ModList.get().isLoaded("touhou_little_maid")) {
            TLMCompatInit.init();
        }
    }
}