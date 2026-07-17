package net.darkside.moreore.world;

import com.mojang.serialization.Codec;
import net.darkside.moreore.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class EmberstoneOreFeature extends Feature<EmberstoneOreFeatureConfig> {
    public EmberstoneOreFeature(Codec<EmberstoneOreFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<EmberstoneOreFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        Random random = context.getRandom();
        BlockPos origin = context.getOrigin();
        EmberstoneOreFeatureConfig config = context.getConfig();

        int searchRadius = config.searchRadius();
        List<BlockPos> lavaPositions = new ArrayList<>();
        for (BlockPos pos : BlockPos.iterate(origin.add(-searchRadius, -searchRadius, -searchRadius),
                origin.add(searchRadius, searchRadius, searchRadius))) {
            if (world.getBlockState(pos).isOf(Blocks.LAVA)) {
                lavaPositions.add(pos.toImmutable());
            }
        }
        if (lavaPositions.isEmpty()) {
            return false;
        }

        Set<BlockPos> touchingLava = new LinkedHashSet<>();
        for (BlockPos lavaPos : lavaPositions) {
            for (Direction direction : Direction.values()) {
                BlockPos neighbor = lavaPos.offset(direction);
                if (isReplaceable(world.getBlockState(neighbor))) {
                    touchingLava.add(neighbor.toImmutable());
                }
            }
        }
        if (touchingLava.isEmpty()) {
            return false;
        }

        int spread = config.spread();
        Set<BlockPos> candidates = new LinkedHashSet<>(touchingLava);
        for (BlockPos anchor : touchingLava) {
            for (BlockPos pos : BlockPos.iterate(anchor.add(-spread, -spread, -spread),
                    anchor.add(spread, spread, spread))) {
                if (isReplaceable(world.getBlockState(pos))) {
                    candidates.add(pos.toImmutable());
                }
            }
        }

        List<BlockPos> shuffled = new ArrayList<>(candidates);
        for (int i = shuffled.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            BlockPos tmp = shuffled.get(i);
            shuffled.set(i, shuffled.get(j));
            shuffled.set(j, tmp);
        }

        int placed = 0;
        for (BlockPos pos : shuffled) {
            if (placed >= config.size()) break;
            world.setBlockState(pos, ModBlocks.EMBERSTONE_ORE.getDefaultState(), Block.NOTIFY_LISTENERS);
            placed++;
        }
        return placed > 0;
    }

    private static boolean isReplaceable(BlockState state) {
        return state.isIn(BlockTags.BASE_STONE_OVERWORLD) || state.isIn(BlockTags.BASE_STONE_NETHER);
    }
}
