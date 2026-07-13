package net.darkside.moreore.item.CustomTools;

import net.darkside.moreore.effect.ModEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;
import net.darkside.moreore.util.ModTags;

public class ShadowSword extends SwordItem {
    private static final int DURATION = 60;
    private static final int AMP = 0;
    private static final int DARK_LEVEL = 4;

    public ShadowSword(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (world.isClient || !(entity instanceof LivingEntity player)) return;

        boolean holdingShadow = player.getMainHandStack().isIn(ModTags.Items.SHADOW_TOOLS)
                || player.getOffHandStack().isIn(ModTags.Items.SHADOW_TOOLS);

        boolean isNight = !world.isDay();
        int light = world.getLightLevel(player.getBlockPos());
        boolean isDark = light <= DARK_LEVEL;

        if (holdingShadow && (isNight || isDark)) {
            player.addStatusEffect(new StatusEffectInstance(
                    ModEffect.SHADOW_WEAPON,
                    DURATION,
                    AMP,
                    true,
                    false,
                    false
            ));
        } else {
            var cur = player.getStatusEffect(ModEffect.SHADOW_WEAPON);
            if (cur != null && cur.isAmbient() && !cur.shouldShowIcon()) {
                player.removeStatusEffect(ModEffect.SHADOW_WEAPON);
            }
        }
    }
}
