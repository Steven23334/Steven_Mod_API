package com.github.steven23334.steven_mod_api;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(StevenModAPI.MOD_ID)
public class StevenModAPI {
    public static final String MOD_ID = "steven_mod_api";

    public StevenModAPI(IEventBus modEventBus) {
        // 将自定义标签页注册到 MOD 事件总线
        ModCreativeModeTabs.register(modEventBus);
        // 如果有物品，也一并注册
        ModItems.register(modEventBus);
    }
}