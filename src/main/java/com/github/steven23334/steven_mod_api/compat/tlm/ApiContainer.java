package com.github.steven23334.steven_mod_api.compat.tlm;

import com.github.steven23334.steven_mod_api.ModMenus;
import com.github.tartaricacid.touhoulittlemaid.inventory.container.AbstractMaidContainer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;

public class ApiContainer extends AbstractMaidContainer {

    public static final String KEY_CONTAINER_TITLE = "container.steven_mod_api.api";

    public ApiContainer(int id, Inventory inventory, int entityId) {
        super(ModMenus.API_CONTAINER.get(), id, inventory, entityId);
    }

    public static MenuProvider create(int entityId) {
        return new MenuProvider() {
            @Override
            public Component getDisplayName() {
                return Component.translatable(KEY_CONTAINER_TITLE);
            }

            @Override
            public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                return new ApiContainer(id, inventory, entityId);
            }
        };
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return ItemStack.EMPTY;
    }
}