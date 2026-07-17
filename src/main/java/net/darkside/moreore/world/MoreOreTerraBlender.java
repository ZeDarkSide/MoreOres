package net.darkside.moreore.world;

import net.darkside.moreore.MoreOre;
import net.darkside.moreore.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class MoreOreTerraBlender implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new WastelandRegion(new Identifier(MoreOre.MOD_ID, "wasteland_region"), 1));

        MaterialRules.MaterialRule topBlock = MaterialRules.condition(
                MaterialRules.water(0, 0),
                MaterialRules.block(ModBlocks.WASTELAND_GRASS_BLOCK.getDefaultState())
        );
        MaterialRules.MaterialRule wastelandTopsoil = MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, topBlock),
                MaterialRules.condition(
                        MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH_RANGE_6,
                        MaterialRules.block(Blocks.DIRT.getDefaultState())
                )
        );
        MaterialRules.MaterialRule wastelandSurface = MaterialRules.condition(
                MaterialRules.surface(),
                MaterialRules.condition(
                        MaterialRules.biome(WastelandRegion.WASTELAND),
                        wastelandTopsoil
                )
        );
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MoreOre.MOD_ID, wastelandSurface);
    }
}
