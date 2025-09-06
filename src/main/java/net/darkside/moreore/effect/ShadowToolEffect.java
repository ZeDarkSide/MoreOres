package net.darkside.moreore.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class ShadowToolEffect extends StatusEffect {
    public ShadowToolEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // no per-tick logic; we’re just using attribute modifiers
        return false;
    }
}
