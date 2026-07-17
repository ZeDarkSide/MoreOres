package net.darkside.moreore.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.feature.FeatureConfig;

public record EmberstoneOreFeatureConfig(int size, int spread, int searchRadius) implements FeatureConfig {
    public static final Codec<EmberstoneOreFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("size").forGetter(EmberstoneOreFeatureConfig::size),
            Codec.INT.fieldOf("spread").forGetter(EmberstoneOreFeatureConfig::spread),
            Codec.INT.fieldOf("search_radius").forGetter(EmberstoneOreFeatureConfig::searchRadius)
    ).apply(instance, EmberstoneOreFeatureConfig::new));
}
