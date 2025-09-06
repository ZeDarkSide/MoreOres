package net.darkside.moreore.datagen;

import net.darkside.moreore.item.ModItems;
import net.darkside.moreore.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }


    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.CHUNK_OF_VENOM)
                .add(ModItems.SHADOW_SCRAP)
                .add(ModItems.SHADOW_INGOT);

        getOrCreateTagBuilder(ModTags.Items.VENOM_TOOLS)
                .add(ModItems.VENOM_SHOVEL)
                .add(ModItems.VENOM_HOE)
                .add(ModItems.VENOM_AXE)
                .add(ModItems.VENOM_SWORD)
                .add(ModItems.VENOM_PICKAXE);
        getOrCreateTagBuilder(ModTags.Items.SHADOW_TOOLS)
                .add(ModItems.SHADOW_SHOVEL)
                .add(ModItems.SHADOW_HOE)
                .add(ModItems.SHADOW_AXE)
                .add(ModItems.SHADOW_SWORD)
                .add(ModItems.SHADOW_PICKAXE);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.VENOM_PICKAXE)
                .add(ModItems.SHADOW_PICKAXE);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.VENOM_SWORD)
                .add(ModItems.SHADOW_SWORD);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.VENOM_AXE)
                .add(ModItems.SHADOW_AXE);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.VENOM_HOE)
                .add(ModItems.SHADOW_HOE);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.VENOM_SHOVEL)
                .add(ModItems.SHADOW_SHOVEL);
    }
}
