package net.darkside.moreore.datagen;

import net.darkside.moreore.block.ModBlocks;
import net.darkside.moreore.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.intprovider.IntProvider;

import java.util.concurrent.CompletableFuture;

public class MOdLootTableProvider extends FabricBlockLootTableProvider {
    public MOdLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.VENOM_ORE, CustomOreDrops(ModBlocks.VENOM_ORE, ModItems.CHUNK_OF_VENOM, 1,3));
        addDrop(ModBlocks.RUBY_ORE, CustomOreDrops(ModBlocks.VENOM_ORE, ModItems.CHUNK_OF_VENOM, 2,4)); //temp
        addDrop(ModBlocks.SHADOW_ORE, ModBlocks.SHADOW_ORE);
        addDrop(ModBlocks.EMBERSTONE_ORE, CustomOreDrops(ModBlocks.EMBERSTONE_ORE, ModItems.EMBERSTONE_INGOT, 1, 1));
        addDrop(ModBlocks.FROSTSTEEL_ORE, ModBlocks.FROSTSTEEL_ORE);
        addDrop(ModBlocks.FROSTSTEEL_PACKED_ICE_ORE, ModBlocks.FROSTSTEEL_PACKED_ICE_ORE);

        addDrop(ModBlocks.FIRE_LOG);
        addDrop(ModBlocks.FIRE_PLANKS);
        addDrop(ModBlocks.FIRE_SAPLING);
        addDrop(ModBlocks.FIRE_LEAVES, leavesDrops(ModBlocks.FIRE_LEAVES, ModBlocks.FIRE_SAPLING, SAPLING_DROP_CHANCE));

        addDrop(ModBlocks.WASTELAND_GRASS_BLOCK, drops(ModBlocks.WASTELAND_GRASS_BLOCK, Blocks.DIRT));

        addDrop(ModBlocks.FIRE_DOOR, doorDrops(ModBlocks.FIRE_DOOR));
        addDrop(ModBlocks.FIRE_TRAPDOOR);

        addDrop(ModBlocks.FIRE_STAIRS);
        addDrop(ModBlocks.FIRE_SLAB, slabDrops(ModBlocks.FIRE_SLAB));
        addDrop(ModBlocks.FIRE_FENCE);
        addDrop(ModBlocks.FIRE_FENCE_GATE);
        addDrop(ModBlocks.FIRE_PRESSURE_PLATE);
        addDrop(ModBlocks.FIRE_BUTTON);
    }

    public LootTable.Builder CustomOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.
                                        builder(UniformLootNumberProvider.
                                                create(minDrops, maxDrops)))
                                .apply(ApplyBonusLootFunction.oreDrops(impl.
                                        getOrThrow(Enchantments.FORTUNE)))

                )
        );
    }
}
