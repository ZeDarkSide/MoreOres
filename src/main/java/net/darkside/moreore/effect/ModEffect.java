package net.darkside.moreore.effect;

import net.darkside.moreore.MoreOre;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffect {
    public static final RegistryEntry<StatusEffect> SHADOW_TOOL = registerStatusEffect("shadow_tool",
            new ShadowToolEffect(StatusEffectCategory.BENEFICIAL, 0x4B0082)
                    .addAttributeModifier(EntityAttributes.BLOCK_BREAK_SPEED,
                            Identifier.of(MoreOre.MOD_ID, "shadow_tool_attack_speed"),
                            0.6f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static final RegistryEntry<StatusEffect> SHADOW_WEAPON = registerStatusEffect("shadow_weapon",
            new ShadowToolEffect(StatusEffectCategory.BENEFICIAL, 0x4B0082)
                    .addAttributeModifier(EntityAttributes.ATTACK_DAMAGE,
                            Identifier.of(MoreOre.MOD_ID, "shadow_weapon_attack_damage"),
                            0.3f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect effect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MoreOre.MOD_ID, name), effect);
    }

    public static void registerEffects() {
        MoreOre.LOGGER.info("Registering Mod Effects for " + MoreOre.MOD_ID);
    }
}
