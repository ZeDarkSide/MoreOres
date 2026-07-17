package net.darkside.moreore.item;

import net.darkside.moreore.MoreOre;
import net.darkside.moreore.item.CustomTools.ShadowPickaxe;
import net.darkside.moreore.item.CustomTools.ShadowAxe;
import net.darkside.moreore.item.CustomTools.ShadowShovel;
import net.darkside.moreore.item.CustomTools.ShadowHoe;
import net.darkside.moreore.item.CustomTools.ShadowSword;
import net.darkside.moreore.item.CustomTools.Venom.*;
import net.darkside.moreore.item.CustomTools.Emberstone.EmberstonePickaxe;
import net.darkside.moreore.item.CustomTools.Emberstone.EmberstoneAxe;
import net.darkside.moreore.item.CustomTools.Emberstone.EmberstoneShovel;
import net.darkside.moreore.item.CustomTools.Emberstone.EmberstoneHoe;
import net.darkside.moreore.item.CustomTools.Emberstone.EmberstoneSword;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {


    public static final Item UNKOWN_ITEM=registerItem
            ("unknow_item", Item::new);
    public static final Item CHUNK_OF_VENOM=registerItem
            ("chunk_of_venom", Item::new);

    public static final Item DECAYED_DIAMOND=registerItem
            ("decayed_diamond", Item::new);

    public static final Item SHADOW_SCRAP =registerItem
            ("shadow_scrap", Item::new);
    public static final Item SHADOW_INGOT =registerItem
            ("shadow_ingot", Item::new);
    public static final Item EMBERSTONE_INGOT = registerItem(
            "emberstone_ingot", setting -> new Item(setting.fireproof()));
//Tools


    /*

WOODEN    ATT   SPEED
  Sword   → 4 / 1.6
  Pickaxe → 2 / 1.2
  Axe     → 7 / 0.8
  Shovel  → 2.5 / 1.0
  Hoe     → 1 / 1.0

STONE
  Sword   → 5 / 1.6
  Pickaxe → 3 / 1.2
  Axe     → 9 / 0.8
  Shovel  → 3.5 / 1.0
  Hoe     → 1 / 2.0

IRON
  Sword   → 6 / 1.6
  Pickaxe → 4 / 1.2
  Axe     → 9 / 0.9
  Shovel  → 4.5 / 1.0
  Hoe     → 1 / 3.0

DIAMOND
  Sword   → 7 / 1.6
  Pickaxe → 5 / 1.2
  Axe     → 9 / 1.0
  Shovel  → 5.5 / 1.0
  Hoe     → 1 / 4.0

NETHERITE
  Sword   → 8 / 1.6
  Pickaxe → 6 / 1.2
  Axe     → 10 / 1.0
  Shovel  → 6.5 / 1.0
  Hoe     → 1 / 4.0

GOLD
  Sword   → 4 / 1.6
  Pickaxe → 2 / 1.2
  Axe     → 7 / 1.0
  Shovel  → 2.5 / 1.0
  Hoe     → 1 / 1.0

*/

    public static final Item VENOM_PICKAXE = registerItem("venom_pickaxe",
            setting -> new VenomPickaxe(ModToolMaterials.VENOM_TOOLS, -2, -2.8f, setting));
    public static final Item VENOM_SWORD = registerItem(
            "venom_sword", setting -> new VenomSwordClass(ModToolMaterials.VENOM_TOOLS, 1, -2.6f, setting));
    public static final Item VENOM_AXE = registerItem(
            "venom_axe", setting -> new VenomAxe(ModToolMaterials.VENOM_TOOLS, 1.5f, -3f, setting));
    public static final Item VENOM_HOE = registerItem(
            "venom_hoe", setting -> new VenomHoe(ModToolMaterials.VENOM_TOOLS, -4, -2.8f, setting));
    public static final Item VENOM_SHOVEL = registerItem(
            "venom_shovel", setting -> new VenomShovel(ModToolMaterials.VENOM_TOOLS, -1, -2.8f, setting));



    public static final Item SHADOW_PICKAXE = registerItem("shadow_pickaxe",
            setting -> new ShadowPickaxe(ModToolMaterials.SHADOW_TOOLS, -2, -2.5f, setting));

    public static final Item SHADOW_AXE = registerItem(
            "shadow_axe", setting -> new ShadowAxe(ModToolMaterials.SHADOW_TOOLS, 1.5f, -3.0f, setting));
    public static final Item SHADOW_SHOVEL = registerItem(
            "shadow_shovel", setting -> new ShadowShovel(ModToolMaterials.SHADOW_TOOLS, -1f, -2.8f, setting));
    public static final Item SHADOW_HOE = registerItem(
            "shadow_hoe", setting -> new ShadowHoe(ModToolMaterials.SHADOW_TOOLS, -4, -2.8f, setting));
    public static final Item SHADOW_SWORD = registerItem(
            "shadow_sword", setting -> new ShadowSword(ModToolMaterials.SHADOW_TOOLS, 1, -2.6f, setting));

    public static final Item EMBERSTONE_PICKAXE = registerItem("emberstone_pickaxe",
            setting -> new EmberstonePickaxe(ModToolMaterials.EMBERSTONE_TOOLS, 2, -2.9f, setting.fireproof()));
    public static final Item EMBERSTONE_AXE = registerItem("emberstone_axe",
            setting -> new EmberstoneAxe(ModToolMaterials.EMBERSTONE_TOOLS, 6.0f, -3.1f, setting.fireproof()));
    public static final Item EMBERSTONE_SHOVEL = registerItem("emberstone_shovel",
            setting -> new EmberstoneShovel(ModToolMaterials.EMBERSTONE_TOOLS, 2.5f, -3.1f, setting.fireproof()));
    public static final Item EMBERSTONE_HOE = registerItem("emberstone_hoe",
            setting -> new EmberstoneHoe(ModToolMaterials.EMBERSTONE_TOOLS, -3, -0.1f, setting.fireproof()));
    public static final Item EMBERSTONE_SWORD = registerItem("emberstone_sword",
            setting -> new EmberstoneSword(ModToolMaterials.EMBERSTONE_TOOLS, 4, -2.5f, setting.fireproof()));

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, new Identifier(MoreOre.MOD_ID, name),
                function.apply(new Item.Settings()));
    }

    public static void registerModItems() {
        MoreOre.LOGGER.info("Registering Mod Items for " + MoreOre.MOD_ID);


    }
}
