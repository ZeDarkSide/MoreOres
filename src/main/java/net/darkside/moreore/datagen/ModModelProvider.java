package net.darkside.moreore.datagen;

import net.darkside.moreore.MoreOre;
import net.darkside.moreore.block.ModBlocks;
import net.darkside.moreore.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.TexturedModel;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    private static final int FIRE_LEAVES_TINT = -2537457;

    private static final int WASTELAND_GRASS_TINT = -13354961;

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.UNKNOW_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VENOM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SHADOW_ORE);

        TexturedModel.Factory froststeelOreModel = TexturedModel.CUBE_ALL.andThen(
                textures -> textures.put(TextureKey.ALL, new Identifier(MoreOre.MOD_ID, "block/froststeel_ore_stone")));
        blockStateModelGenerator.registerSingleton(ModBlocks.FROSTSTEEL_ORE, froststeelOreModel);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FROSTSTEEL_PACKED_ICE_ORE);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FIRE_PLANKS)
                .stairs(ModBlocks.FIRE_STAIRS)
                .slab(ModBlocks.FIRE_SLAB)
                .fence(ModBlocks.FIRE_FENCE)
                .fenceGate(ModBlocks.FIRE_FENCE_GATE)
                .pressurePlate(ModBlocks.FIRE_PRESSURE_PLATE)
                .button(ModBlocks.FIRE_BUTTON);

        TextureMap fireLogTextures = TextureMap.sideEnd(
                new Identifier(MoreOre.MOD_ID, "block/fire_log_side_1"),
                new Identifier(MoreOre.MOD_ID, "block/fire_log_top_1"));
        blockStateModelGenerator.new LogTexturePool(fireLogTextures).log(ModBlocks.FIRE_LOG);

        TexturedModel.Factory fireLeavesModel = TexturedModel.LEAVES.andThen(
                textures -> textures.put(TextureKey.ALL, new Identifier(MoreOre.MOD_ID, "block/fire_leaves_1")));
        blockStateModelGenerator.registerSingleton(ModBlocks.FIRE_LEAVES, fireLeavesModel);

        blockStateModelGenerator.registerTintableCross(ModBlocks.FIRE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        // WASTELAND_GRASS_BLOCK blockstate/model are hand-authored in resources (grass-tint layout); not datagen'd.

        blockStateModelGenerator.registerDoor(ModBlocks.FIRE_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.FIRE_TRAPDOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.UNKOWN_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHUNK_OF_VENOM, Models.GENERATED);
        itemModelGenerator.register(ModItems.DECAYED_DIAMOND, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHADOW_SCRAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHADOW_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMBERSTONE_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.VENOM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VENOM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VENOM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VENOM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VENOM_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.SHADOW_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHADOW_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHADOW_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHADOW_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHADOW_SWORD, Models.HANDHELD);

        itemModelGenerator.register(ModItems.EMBERSTONE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMBERSTONE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMBERSTONE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMBERSTONE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMBERSTONE_SWORD, Models.HANDHELD);
    }
}
