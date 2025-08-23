package net.darkside.moreore.item;

import net.darkside.moreore.MoreOre;
import net.darkside.moreore.item.CustomTools.VenomSwordClass;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.ItemGroups;
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
    public static final Item VENOM_PICKAXE = registerItem("venom_pickaxe",
            setting -> new PickaxeItem(ModToolMaterials.VENOM_TOOLS, -1, -2.8f, setting));
    public static final Item VENOM_SWORD = registerItem(
            "venom_sword", setting -> new VenomSwordClass(ModToolMaterials.VENOM_TOOLS, 2, -2.6f, setting));
    public static final Item VENOM_AXE = registerItem(
            "venom_axe", setting -> new AxeItem(ModToolMaterials.VENOM_TOOLS, 3, -3f, setting));
    public static final Item VENOM_HOE = registerItem(
            "venom_hoe", setting -> new HoeItem(ModToolMaterials.VENOM_TOOLS, -2, -2.8f, setting));
    public static final Item VENOM_SHOVEL = registerItem(
            "venom_shovel", setting -> new ShovelItem(ModToolMaterials.VENOM_TOOLS, -2, -2.8f, setting));

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(MoreOre.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOre.MOD_ID, name)))));
    }

    public static void registerModItems() {
        MoreOre.LOGGER.info("Registering Mod Items for " + MoreOre.MOD_ID);


    }
}
