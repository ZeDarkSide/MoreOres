package net.darkside.moreore.block;

import net.darkside.moreore.MoreOre;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.function.Function;

public class ModBlocks {

    public static final Block UNKNOW_BLOCK = registerBlock("unknow_block",
            AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE));

    public static final Block VENOM_ORE = registerBlock("venom_ore", key ->
            new net.darkside.moreore.block.VenomOreBlock(
                    UniformIntProvider.create(1, 4),
                    AbstractBlock.Settings.create()
                            .strength(4f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.STONE)
                            .registryKey(key)
            )
    );

    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            AbstractBlock.Settings.create()
                    .strength(5f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE));

    public static final Block SHADOW_ORE = registerBlock("shadow_ore",
            AbstractBlock.Settings.create()
                    .strength(5f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE));

    private static Block registerBlock(String name, AbstractBlock.Settings settings) {
        return registerBlock(name, key -> new Block(settings.registryKey(key)));
    }

    private static Block registerBlock(String name, Function<RegistryKey<Block>, Block> factory) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreOre.MOD_ID, name));
        Block block = factory.apply(key);
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, key, block);
    }

    private static void registerBlockItem(String name, Block block) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOre.MOD_ID, name));
        BlockItem item = new BlockItem(block, new Item.Settings().registryKey(key));
        Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModBlocks() {
        MoreOre.LOGGER.info("Mod Blocks loaded for " + MoreOre.MOD_ID);
    }
}
