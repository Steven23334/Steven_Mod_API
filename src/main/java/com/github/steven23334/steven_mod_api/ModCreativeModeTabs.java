package com.github.steven23334.steven_mod_api;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModCreativeModeTabs {
    // 延迟注册器：Registries.CREATIVE_MODE_TAB 是 NeoForge 21.1 的正确注册表引用
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StevenModAPI.MOD_ID);

    // 注册一个名为 "steven_tab" 的标签页
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> STEVEN_TAB =
            CREATIVE_MODE_TABS.register("steven_tab", () -> CreativeModeTab.builder()
                    // 图标：使用任意物品堆叠，这里假设你注册了一个物品，也可以直接用原版物品如 Items.DIAMOND
                    .icon(() -> new ItemStack(ModItems.ICON_ITEM.get()))
                    // 标题：语言文件键为 itemGroup.steven_mod_api.steven_tab
                    .title(Component.translatable("itemGroup.steven_mod_api.steven_tab"))
                    // 向标签页填充物品
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.ICON_ITEM.get());                 // API 自己的物品
                        ApiTabContributors.collectAll().forEach(output::accept); // 子模组贡献的物品
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}