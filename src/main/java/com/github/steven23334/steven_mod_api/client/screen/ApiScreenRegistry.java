package com.github.steven23334.steven_mod_api.client.screen;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 界面注册表。其他模组通过 {@link #register(ApiScreenContributor)} 注册自己的界面。
 */
public final class ApiScreenRegistry {
    private static final Map<String, ApiScreenContributor> CONTRIBUTORS = new LinkedHashMap<>();

    private ApiScreenRegistry() {
    }

    /** 注册一个界面贡献者。id 重复时覆盖旧值并打印警告 */
    public static void register(ApiScreenContributor contributor) {
        ApiScreenContributor previous = CONTRIBUTORS.put(contributor.id(), contributor);
        if (previous != null) {
            System.err.println("[StevenModAPI] Duplicate screen id: " + contributor.id());
        }
    }

    /** 按注册顺序返回所有贡献者 */
    public static List<ApiScreenContributor> getAll() {
        return List.copyOf(CONTRIBUTORS.values());
    }

    /** 按 id 查找贡献者，找不到返回 null */
    public static ApiScreenContributor get(String id) {
        return CONTRIBUTORS.get(id);
    }
}