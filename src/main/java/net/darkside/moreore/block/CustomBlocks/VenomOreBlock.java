package net.darkside.moreore.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.World;

public class VenomOreBlock extends ExperienceDroppingBlock {
    private static final int POISON_DURATION = 60; // 3s (20 ticks = 1s)
    private static final int POISON_AMPLIFIER = 2; // Poison I

    public VenomOreBlock(IntProvider xp, Settings settings) {
        super(xp, settings);
    }

    @Override
    public void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        super.onBlockBreakStart(state, world, pos, player);
        if (!world.isClient && !player.isCreative()) {
            if (!player.hasStatusEffect(StatusEffects.POISON)) {
                player.addStatusEffect(new StatusEffectInstance(
                        StatusEffects.POISON,
                        POISON_DURATION,
                        POISON_AMPLIFIER,
                        false,
                        true
                ), player);
            }
        }
    }
}
