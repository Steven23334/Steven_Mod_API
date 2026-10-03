package com.github.steven23334.steven_mod_api;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(StevenModAPI.MOD_ID)
public class StevenModAPI {
    public static final String MOD_ID = "steven_mod_api";

    public StevenModAPI(IEventBus modEventBus) {
        // 注册创造模式标签页
        ModCreativeModeTabs.register(modEventBus);
        // 注册物品
        ModItems.register(modEventBus);
        // 客户端界面注册在 StevenModAPIClient 里通过 @EventBusSubscriber 完成
        ModMenus.register(modEventBus);
    }
}