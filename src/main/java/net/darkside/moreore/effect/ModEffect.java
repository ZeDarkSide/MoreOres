package net.darkside.moreore.effect;

import net.darkside.moreore.MoreOre;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.UUID;

public class ModEffect {
    private static final UUID SHADOW_WEAPON_ATTACK_DAMAGE_ID =
            UUID.nameUUIDFromBytes("moreore_shadow_weapon_attack_damage".getBytes());

    public static final StatusEffect SHADOW_TOOL = registerStatusEffect("shadow_tool",
            new ShadowToolEffect(StatusEffectCategory.BENEFICIAL, 0x4B0082));

    public static final StatusEffect SHADOW_WEAPON = registerStatusEffect("shadow_weapon",
            new ShadowToolEffect(StatusEffectCategory.BENEFICIAL, 0x4B0082)
                    .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                            SHADOW_WEAPON_ATTACK_DAMAGE_ID.toString(),
                            0.3f,
                            EntityAttributeModifier.Operation.MULTIPLY_TOTAL));

    private static StatusEffect registerStatusEffect(String name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(MoreOre.MOD_ID, name), effect);
    }

    public static void registerEffects() {
        MoreOre.LOGGER.info("Registering Mod Effects for " + MoreOre.MOD_ID);
    }
}
