package net.darkside.moreore.item.CustomTools;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

public class VenomSwordClass extends SwordItem {
    private static final int POISON_DURATION = 100;
    private static final int POISON_AMPLIFIER = 1;

    private static final boolean EXCLUDE_PLAYERS = false;

    public VenomSwordClass(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = attacker.getWorld();
        if (!world.isClient) {
            if (!(EXCLUDE_PLAYERS && target instanceof PlayerEntity)) {
                target.addStatusEffect(new StatusEffectInstance(
                        StatusEffects.POISON,
                        POISON_DURATION,
                        POISON_AMPLIFIER,
                        false,
                        false
                ), attacker);
            }
        }

        // Let vanilla continue its normal flow (including calling postDamageEntity which handles durability)
        return super.postHit(stack, target, attacker);
    }
}
