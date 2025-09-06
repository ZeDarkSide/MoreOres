package net.darkside.moreore.item;

import net.darkside.moreore.MoreOre;
import net.darkside.moreore.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemGroups {


    public static final ItemGroup CHUNK_Of_VENOM = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MoreOre.MOD_ID, "chunk_of_venom"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.CHUNK_OF_VENOM))
                    .displayName(Text.translatable("itemgroup.moreore.unknow"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.DECAYED_DIAMOND);
                        entries.add(ModBlocks.VENOM_ORE);
                        entries.add(ModItems.CHUNK_OF_VENOM);
                        entries.add(ModItems.VENOM_PICKAXE);
                        entries.add(ModItems.VENOM_AXE);
                        entries.add(ModItems.VENOM_SHOVEL);
                        entries.add(ModItems.VENOM_HOE);
                        entries.add(ModItems.VENOM_SWORD);
                        entries.add(ModBlocks.SHADOW_ORE);
                        entries.add(ModItems.SHADOW_SCRAP);
                        entries.add(ModItems.SHADOW_INGOT);
                        entries.add(ModItems.SHADOW_PICKAXE);
                        entries.add(ModItems.SHADOW_AXE);
                        entries.add(ModItems.SHADOW_SHOVEL);
                        entries.add(ModItems.SHADOW_HOE);
                        entries.add(ModItems.SHADOW_SWORD);
                    }).build());



    public static void registerItemGroup(){
        MoreOre.LOGGER.info("Registering Mod Items for " + MoreOre.MOD_ID);


    }
}
