package net.darkside.moreore.item;

import net.darkside.moreore.MoreOre;
import net.darkside.moreore.item.CustomTools.Venom.*;
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
            "venom_sword", setting -> new VenomSwordClass(ModToolMaterials.VENOM_TOOLS, .5f, -2.6f, setting));
    public static final Item VENOM_AXE = registerItem(
            "venom_axe", setting -> new VenomAxe(ModToolMaterials.VENOM_TOOLS, 1.5f, -3f, setting));
    public static final Item VENOM_HOE = registerItem(
            "venom_hoe", setting -> new VenomHoe(ModToolMaterials.VENOM_TOOLS, -4, -2.8f, setting));
    public static final Item VENOM_SHOVEL = registerItem(
            "venom_shovel", setting -> new VenomShovel(ModToolMaterials.VENOM_TOOLS, -1, -2.8f, setting));


    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(MoreOre.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOre.MOD_ID, name)))));
    }

    public static void registerModItems() {
        MoreOre.LOGGER.info("Registering Mod Items for " + MoreOre.MOD_ID);


    }
}
