package net.darkside.moreore.block;

import net.darkside.moreore.MoreOre;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.ButtonBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.block.WoodType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.TallBlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {

    public static final Block UNKNOW_BLOCK = registerBlock("unknow_block",
            AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE));

    public static final Block VENOM_ORE = registerBlock("venom_ore", () ->
            new net.darkside.moreore.block.CustomBlocks.VenomOreBlock(
                    UniformIntProvider.create(1, 4),
                    AbstractBlock.Settings.create()
                            .strength(4f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.STONE)
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

    public static final Block FROSTSTEEL_ORE = registerBlock("froststeel_ore",
            AbstractBlock.Settings.create()
                    .strength(3.5f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE));

    public static final Block FROSTSTEEL_PACKED_ICE_ORE = registerBlock("froststeel_packed_ice_ore",
            AbstractBlock.Settings.create()
                    .strength(3.5f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE));

    public static final Block EMBERSTONE_ORE = registerBlock("emberstone_ore", () ->
            new net.darkside.moreore.block.CustomBlocks.EmberstoneOreBlock(
                    UniformIntProvider.create(3, 7),
                    AbstractBlock.Settings.create()
                            .strength(3.0f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.STONE)
            ), true
    );

    private static final RegistryKey<ConfiguredFeature<?, ?>> FIRE_TREE = RegistryKey.of(
            RegistryKeys.CONFIGURED_FEATURE, new Identifier(MoreOre.MOD_ID, "fire_tree"));

    private static final SaplingGenerator FIRE_SAPLING_GENERATOR = new SaplingGenerator() {
        @Override
        protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
            return FIRE_TREE;
        }
    };

    public static final Block FIRE_LOG = registerBlock("fire_log", () ->
            new PillarBlock(
                    AbstractBlock.Settings.create()
                            .strength(2.0f)
                            .sounds(BlockSoundGroup.WOOD)
            ), true
    );

    public static final Block FIRE_PLANKS = registerBlock("fire_planks", () ->
            new Block(
                    AbstractBlock.Settings.create()
                            .strength(2.0f, 3.0f)
                            .sounds(BlockSoundGroup.WOOD)
            ), true
    );

    public static final Block FIRE_LEAVES = registerBlock("fire_leaves", () ->
            new LeavesBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.2f)
                            .ticksRandomly()
                            .sounds(BlockSoundGroup.GRASS)
                            .nonOpaque()
                            .allowsSpawning(Blocks::canSpawnOnLeaves)
                            .suffocates(Blocks::never)
                            .blockVision(Blocks::never)
            ), true
    );

    public static final Block WASTELAND_GRASS_BLOCK = registerBlock("wasteland_grass_block", () ->
            new GrassBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.DARK_GREEN)
                            .ticksRandomly()
                            .strength(0.6f)
                            .sounds(BlockSoundGroup.GRASS)
            )
    );

    public static final Block FIRE_DOOR = registerBlock("fire_door", () ->
            new DoorBlock(
                    AbstractBlock.Settings.create()
                            .strength(3.0f)
                            .nonOpaque()
                            .pistonBehavior(PistonBehavior.DESTROY),
                    BlockSetType.OAK
            ), true, TallBlockItem::new
    );

    public static final Block FIRE_TRAPDOOR = registerBlock("fire_trapdoor", () ->
            new TrapdoorBlock(
                    AbstractBlock.Settings.create()
                            .strength(3.0f)
                            .nonOpaque()
                            .allowsSpawning(Blocks::never),
                    BlockSetType.OAK
            ), true
    );

    public static final Block FIRE_STAIRS = registerBlock("fire_stairs", () ->
            new StairsBlock(
                    FIRE_PLANKS.getDefaultState(),
                    AbstractBlock.Settings.copy(FIRE_PLANKS)
            ), true
    );

    public static final Block FIRE_SLAB = registerBlock("fire_slab", () ->
            new SlabBlock(AbstractBlock.Settings.copy(FIRE_PLANKS)), true
    );

    public static final Block FIRE_FENCE = registerBlock("fire_fence", () ->
            new FenceBlock(AbstractBlock.Settings.copy(FIRE_PLANKS)), true
    );

    public static final Block FIRE_FENCE_GATE = registerBlock("fire_fence_gate", () ->
            new FenceGateBlock(
                    AbstractBlock.Settings.copy(FIRE_PLANKS),
                    WoodType.OAK
            ), true
    );

    public static final Block FIRE_PRESSURE_PLATE = registerBlock("fire_pressure_plate", () ->
            new PressurePlateBlock(
                    PressurePlateBlock.ActivationRule.EVERYTHING,
                    AbstractBlock.Settings.create()
                            .noCollision()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.WOOD)
                            .pistonBehavior(PistonBehavior.DESTROY),
                    BlockSetType.OAK
            ), true
    );

    public static final Block FIRE_BUTTON = registerBlock("fire_button", () ->
            new ButtonBlock(
                    AbstractBlock.Settings.create()
                            .noCollision()
                            .strength(0.5f)
                            .pistonBehavior(PistonBehavior.DESTROY),
                    BlockSetType.OAK,
                    30,
                    false
            ), true
    );

    public static final Block FIRE_SAPLING = registerBlock("fire_sapling", () ->
            new SaplingBlock(
                    FIRE_SAPLING_GENERATOR,
                    AbstractBlock.Settings.create()
                            .noCollision()
                            .ticksRandomly()
                            .breakInstantly()
                            .sounds(BlockSoundGroup.GRASS)
                            .pistonBehavior(PistonBehavior.DESTROY)
            )
    );

    private static Block registerBlock(String name, AbstractBlock.Settings settings) {
        return registerBlock(name, () -> new Block(settings));
    }

    private static Block registerBlock(String name, Supplier<Block> factory) {
        return registerBlock(name, factory, false);
    }

    private static Block registerBlock(String name, Supplier<Block> factory, boolean fireproof) {
        return registerBlock(name, factory, fireproof, BlockItem::new);
    }

    private static Block registerBlock(String name, Supplier<Block> factory, boolean fireproof,
                                        BiFunction<Block, Item.Settings, BlockItem> itemFactory) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, new Identifier(MoreOre.MOD_ID, name));
        Block block = factory.get();
        registerBlockItem(name, block, fireproof, itemFactory);
        return Registry.register(Registries.BLOCK, key, block);
    }

    private static void registerBlockItem(String name, Block block, boolean fireproof,
                                           BiFunction<Block, Item.Settings, BlockItem> itemFactory) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, new Identifier(MoreOre.MOD_ID, name));
        Item.Settings settings = new Item.Settings();
        if (fireproof) {
            settings = settings.fireproof();
        }
        BlockItem item = itemFactory.apply(block, settings);
        Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModBlocks() {
        MoreOre.LOGGER.info("Mod Blocks loaded for " + MoreOre.MOD_ID);
    }
}
