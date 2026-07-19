package net.darkside.moreore;

import net.darkside.moreore.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.RenderLayer;

public class MoreOreClient implements ClientModInitializer {

    private static final int FIRE_LEAVES_BLOCK_TINT = 0xD9480F;

    private static final int WASTELAND_GRASS_FALLBACK_TINT = 0x6B8E23;

    @Override
    public void onInitializeClient(){
        ColorProviderRegistry.BLOCK.register(
                (state, world, pos, tintIndex) -> FIRE_LEAVES_BLOCK_TINT,
                ModBlocks.FIRE_LEAVES);

        ColorProviderRegistry.BLOCK.register(
                (state, world, pos, tintIndex) -> world != null && pos != null
                        ? BiomeColors.getGrassColor(world, pos)
                        : WASTELAND_GRASS_FALLBACK_TINT,
                ModBlocks.WASTELAND_GRASS_BLOCK);

        ColorProviderRegistry.ITEM.register(
                (stack, tintIndex) -> FIRE_LEAVES_BLOCK_TINT,
                ModBlocks.FIRE_LEAVES);

        ColorProviderRegistry.ITEM.register(
                (stack, tintIndex) -> WASTELAND_GRASS_FALLBACK_TINT,
                ModBlocks.WASTELAND_GRASS_BLOCK);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FIRE_LEAVES, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FIRE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WASTELAND_GRASS_BLOCK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FIRE_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FIRE_TRAPDOOR, RenderLayer.getCutout());
    }
}
