package com.github.steven23334.steven_mod_api;

import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ApiTabContributors {
    // 每个贡献者返回一组要显示在 API 标签页里的物品
    private static final List<Supplier<List<ItemStack>>> CONTRIBUTORS = new ArrayList<>();

    public static void register(Supplier<List<ItemStack>> contributor) {
        CONTRIBUTORS.add(contributor);
    }

    public static List<ItemStack> collectAll() {
        List<ItemStack> result = new ArrayList<>();
        for (Supplier<List<ItemStack>> c : CONTRIBUTORS) {
            result.addAll(c.get());
        }
        return result;
    }
}