package net.darkside.moreore.world;

import net.darkside.moreore.MoreOre;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFeatures {
    public static final EmberstoneOreFeature EMBERSTONE_ORE = Registry.register(
            Registries.FEATURE, Identifier.of(MoreOre.MOD_ID, "emberstone_ore"),
            new EmberstoneOreFeature(EmberstoneOreFeatureConfig.CODEC));

    public static void registerFeatures() {
        MoreOre.LOGGER.info("Registering Mod Features for " + MoreOre.MOD_ID);
    }
}
