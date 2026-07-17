package net.darkside.moreore.world;

import net.darkside.moreore.MoreOre;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.function.Predicate;

public class ModWorldGen {
    private static final RegistryKey<PlacedFeature> EMBERSTONE_ORE_OVERWORLD = RegistryKey.of(
            RegistryKeys.PLACED_FEATURE, new Identifier(MoreOre.MOD_ID, "emberstone_ore_overworld"));
    private static final RegistryKey<PlacedFeature> EMBERSTONE_ORE_NETHER = RegistryKey.of(
            RegistryKeys.PLACED_FEATURE, new Identifier(MoreOre.MOD_ID, "emberstone_ore_nether"));
    private static final RegistryKey<PlacedFeature> VENOM_ORE = RegistryKey.of(
            RegistryKeys.PLACED_FEATURE, new Identifier(MoreOre.MOD_ID, "venom_ore"));
    private static final RegistryKey<PlacedFeature> SHADOW_ORE = RegistryKey.of(
            RegistryKeys.PLACED_FEATURE, new Identifier(MoreOre.MOD_ID, "shadow_ore"));
    private static final RegistryKey<PlacedFeature> FROSTSTEEL_ORE = RegistryKey.of(
            RegistryKeys.PLACED_FEATURE, new Identifier(MoreOre.MOD_ID, "froststeel_ore"));
    private static final RegistryKey<PlacedFeature> FROSTSTEEL_ORE_ICE_SPIKES_RARE = RegistryKey.of(
            RegistryKeys.PLACED_FEATURE, new Identifier(MoreOre.MOD_ID, "froststeel_ore_ice_spikes_rare"));
    private static final RegistryKey<PlacedFeature> FROSTSTEEL_PACKED_ICE_ORE = RegistryKey.of(
            RegistryKeys.PLACED_FEATURE, new Identifier(MoreOre.MOD_ID, "froststeel_packed_ice_ore"));
    private static final RegistryKey<PlacedFeature> FROSTSTEEL_PACKED_ICE_ORE_GROUND = RegistryKey.of(
            RegistryKeys.PLACED_FEATURE, new Identifier(MoreOre.MOD_ID, "froststeel_packed_ice_ore_ground"));

    private static Predicate<BiomeSelectionContext> snowyBiomesExcludingIceSpikes() {
        return BiomeSelectors.includeByKey(
                BiomeKeys.SNOWY_PLAINS,
                BiomeKeys.SNOWY_TAIGA,
                BiomeKeys.SNOWY_SLOPES,
                BiomeKeys.SNOWY_BEACH,
                BiomeKeys.FROZEN_PEAKS,
                BiomeKeys.GROVE,
                BiomeKeys.FROZEN_RIVER,
                BiomeKeys.FROZEN_OCEAN,
                BiomeKeys.DEEP_FROZEN_OCEAN);
    }

    public static void registerOreGeneration() {
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                EMBERSTONE_ORE_OVERWORLD);

        BiomeModifications.addFeature(
                BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                EMBERSTONE_ORE_NETHER);

        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                VENOM_ORE);

        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                SHADOW_ORE);

        BiomeModifications.addFeature(
                snowyBiomesExcludingIceSpikes(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                FROSTSTEEL_ORE);

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(BiomeKeys.ICE_SPIKES),
                GenerationStep.Feature.UNDERGROUND_ORES,
                FROSTSTEEL_ORE_ICE_SPIKES_RARE);

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(BiomeKeys.ICE_SPIKES),
                GenerationStep.Feature.UNDERGROUND_ORES,
                FROSTSTEEL_PACKED_ICE_ORE);

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(BiomeKeys.ICE_SPIKES),
                GenerationStep.Feature.UNDERGROUND_ORES,
                FROSTSTEEL_PACKED_ICE_ORE_GROUND);
    }
}
