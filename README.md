# Steven's Mod API(English)

A personal NeoForge API library that shares common code — such as creative tabs and utility classes — across my other mods.   

[![Available on GitHub](https://wsrv.nl/?url=https%3A%2F%2Fcdn.jsdelivr.net%2Fnpm%2F%40intergrav%2Fdevins-badges%403%2Fassets%2Fcozy%2Favailable%2Fgithub_vector.svg&n=-1)](https://github.com/Steven23334/Steven_Mod_API)

## 📦 Features

- **Creative Tab Contribution**
  Sub-mods can register their items into this API's creative tab `steven_tab`:

  ```java
  ApiTabContributors.register(() -> List.of(
      new ItemStack(MyItems.MY_ITEM.get())
  ));
  ```

## 🔧 Adding as a Dependency

**Option 1: Source Subproject**

`settings.gradle`:
```groovy
include ':steven_mod_api'
project(':steven_mod_api').projectDir = file('../Steven_Mod_API')
```

`build.gradle`:
```groovy
dependencies {
    implementation project(':steven_mod_api')
}
```

**Option 2: Local JAR**

Place the built JAR into `libs/`, then:
```groovy
implementation 'blank:steven_mod_api:1.0.0'
```

`neoforge.mods.toml`:
```toml
[[dependencies.your_mod_id]]
    modId = "steven_mod_api"
    type = "required"
    versionRange = "[1.0.0,)"
    ordering = "AFTER"
    side = "BOTH"
```

## 🧩 Public API

- `ApiTabContributors.register(Supplier<List<ItemStack>>)` — Register items to be shown in the API's creative tab
- `ApiTabContributors.collectAll()` — Collect all contributed items (internal use)

## ⚠️ Requirements

- **Minecraft**: 1.21.1
- **NeoForge**: 21.1.188+
- **Java**: 21

## 📜 License

- Assets and Code: [MIT License](https://mit-license.org/)

## 🙏 Authors

- Programmer: Steven23334   
---

# Steven's Mod API（中文）

一个个人向的 NeoForge 前置 API 库，用于在我的其他模组之间共享公共代码（如物品标签页、工具类等）。   

[![Available on GitHub](https://wsrv.nl/?url=https%3A%2F%2Fcdn.jsdelivr.net%2Fnpm%2F%40intergrav%2Fdevins-badges%403%2Fassets%2Fcozy%2Favailable%2Fgithub_vector.svg&n=-1)](https://github.com/Steven23334/Steven_Mod_API)

## 📦 功能

- **物品标签页贡献**
  子模组可以把物品注册进本 API 的创造模式标签页 `steven_tab`：

  ```java
  ApiTabContributors.register(() -> List.of(
      new ItemStack(MyItems.MY_ITEM.get())
  ));
  ```

## 🔧 作为前置引入

**方式一：源码子项目**

`settings.gradle`：
```groovy
include ':steven_mod_api'
project(':steven_mod_api').projectDir = file('../Steven_Mod_API')
```

`build.gradle`：
```groovy
dependencies {
    implementation project(':steven_mod_api')
}
```

**方式二：本地 JAR**

把构建出的 JAR 放入 `libs/`，然后：
```groovy
implementation 'blank:steven_mod_api:1.0.0'
```

`neoforge.mods.toml`：
```toml
[[dependencies.your_mod_id]]
    modId = "steven_mod_api"
    type = "required"
    versionRange = "[1.0.0,)"
    ordering = "AFTER"
    side = "BOTH"
```

## 🧩 公开 API

- `ApiTabContributors.register(Supplier<List<ItemStack>>)` — 注册要显示在 API 标签页里的物品
- `ApiTabContributors.collectAll()` — 收集所有贡献物品（内部使用）

## ⚠️ 前置要求

- **Minecraft**：1.21.1
- **NeoForge**：21.1.188+
- **Java**：21

## 📜 许可证

- 资产与代码：[MIT License](https://mit-license.org/)

## 🙏 作者

- 程序：Steven23334