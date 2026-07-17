package net.darkside.moreore.world;

import com.mojang.datafixers.util.Pair;
import net.darkside.moreore.MoreOre;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

import static terrablender.api.ParameterUtils.*;

public class WastelandRegion extends Region {
    public static final RegistryKey<Biome> WASTELAND = RegistryKey.of(RegistryKeys.BIOME, new Identifier(MoreOre.MOD_ID, "wasteland"));

    public WastelandRegion(Identifier name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();

        new ParameterUtils.ParameterPointListBuilder()
                .temperature(Temperature.span(Temperature.COOL, Temperature.WARM))
                .humidity(Humidity.NEUTRAL)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.span(Erosion.EROSION_1, Erosion.EROSION_3))
                .depth(Depth.SURFACE)
                .weirdness(Weirdness.span(Weirdness.LOW_SLICE_NORMAL_DESCENDING, Weirdness.VALLEY))
                .build()
                .forEach(point -> builder.add(point, WASTELAND));

        builder.build().forEach(mapper);
    }
}
