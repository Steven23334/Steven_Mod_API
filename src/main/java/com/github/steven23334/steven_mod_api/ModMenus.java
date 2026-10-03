package com.github.steven23334.steven_mod_api;

import com.github.steven23334.steven_mod_api.compat.tlm.ApiContainer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMenus {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, StevenModAPI.MOD_ID);

    // 不在静态初始化里直接注册，只有 TLM 存在时才有值
    public static DeferredHolder<MenuType<?>, MenuType<ApiContainer>> API_CONTAINER = null;

    public static void register(IEventBus bus) {
        if (ModList.get().isLoaded("touhou_little_maid")) {
            API_CONTAINER = MENUS.register("api_container", () -> IMenuTypeExtension.create(
                    (windowId, inv, data) -> new ApiContainer(windowId, inv, data.readInt())));
        }
        MENUS.register(bus);
    }
}