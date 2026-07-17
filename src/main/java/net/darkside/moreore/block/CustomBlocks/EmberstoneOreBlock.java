package net.darkside.moreore.block.CustomBlocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.World;

public class EmberstoneOreBlock extends ExperienceDroppingBlock {
    public EmberstoneOreBlock(IntProvider xp, Settings settings) {
        super(xp, settings);
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (world instanceof ServerWorld serverWorld) {
            serverWorld.spawnParticles(ParticleTypes.LARGE_SMOKE,
                    pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    12, 0.3, 0.3, 0.3, 0.02);
        }
        return super.onBreak(world, pos, state, player);
    }
}
