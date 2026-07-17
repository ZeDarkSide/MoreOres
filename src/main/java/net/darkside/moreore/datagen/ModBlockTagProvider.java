package net.darkside.moreore.datagen;

import net.darkside.moreore.block.ModBlocks;
import net.darkside.moreore.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.VENOM_ORE)
                .add(ModBlocks.RUBY_ORE)
                .add(ModBlocks.SHADOW_ORE)
                .add(ModBlocks.EMBERSTONE_ORE)
                .add(ModBlocks.FROSTSTEEL_ORE)
                .add(ModBlocks.FROSTSTEEL_PACKED_ICE_ORE);



        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.VENOM_ORE)
                .add(ModBlocks.EMBERSTONE_ORE)
                .add(ModBlocks.FROSTSTEEL_ORE)
                .add(ModBlocks.FROSTSTEEL_PACKED_ICE_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RUBY_ORE)
                .add(ModBlocks.SHADOW_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                ;
        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_VENOM_TOOLS)
                .addTag(BlockTags.NEEDS_IRON_TOOL);


        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_SHADOW_TOOLS)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_EMBERSTONE_TOOLS)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        getOrCreateTagBuilder(BlockTags.LOGS)
                .add(ModBlocks.FIRE_LOG);
        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(ModBlocks.FIRE_LEAVES);
        getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .add(ModBlocks.FIRE_SAPLING);
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.FIRE_LOG)
                .add(ModBlocks.FIRE_PLANKS);
        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.FIRE_PLANKS);
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.FIRE_LEAVES);
        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.WASTELAND_GRASS_BLOCK);

        getOrCreateTagBuilder(BlockTags.DIRT)
                .add(ModBlocks.WASTELAND_GRASS_BLOCK);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.FIRE_DOOR)
                .add(ModBlocks.FIRE_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.DOORS)
                .add(ModBlocks.FIRE_DOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.FIRE_DOOR);
        getOrCreateTagBuilder(BlockTags.TRAPDOORS)
                .add(ModBlocks.FIRE_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.FIRE_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.FIRE_STAIRS)
                .add(ModBlocks.FIRE_SLAB)
                .add(ModBlocks.FIRE_FENCE)
                .add(ModBlocks.FIRE_FENCE_GATE)
                .add(ModBlocks.FIRE_PRESSURE_PLATE)
                .add(ModBlocks.FIRE_BUTTON);

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.FIRE_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.FIRE_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.FIRE_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.FIRE_SLAB);
        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.FIRE_FENCE);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.FIRE_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.FIRE_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.FIRE_PRESSURE_PLATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.FIRE_PRESSURE_PLATE);
        getOrCreateTagBuilder(BlockTags.BUTTONS)
                .add(ModBlocks.FIRE_BUTTON);
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.FIRE_BUTTON);
    }
}
