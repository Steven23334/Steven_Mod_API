package com.github.steven23334.steven_mod_api;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(StevenModAPI.MOD_ID);

    // 注册一个示例物品，作为标签页的图标和内容
    public static final DeferredItem<Item> ICON_ITEM =
            ITEMS.registerSimpleItem("icon_item", new Item.Properties());

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}