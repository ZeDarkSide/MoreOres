package net.darkside.moreore.item.CustomTools.Emberstone;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.ServerRecipeManager;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.TypeFilter;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

public class EmberstoneAutoSmelt {
    private static final ServerRecipeManager.MatchGetter<SingleStackRecipeInput, SmeltingRecipe> SMELTING_MATCHER =
            ServerRecipeManager.createCachedMatchGetter(RecipeType.SMELTING);
    private static final double SEARCH_RADIUS = 1.0;

    private record PendingSmelt(ServerWorld world, BlockPos pos, Set<Integer> preExistingItemIds) {
    }

    private static final Queue<PendingSmelt> PENDING = new ArrayDeque<>();

    public static void schedule(ServerWorld world, BlockPos pos) {

        Set<Integer> preExisting = new HashSet<>();
        for (ItemEntity entity : world.getEntitiesByType(TypeFilter.instanceOf(ItemEntity.class), searchBox(pos), e -> true)) {
            preExisting.add(entity.getId());
        }
        PENDING.add(new PendingSmelt(world, pos.toImmutable(), preExisting));
    }

    private static Box searchBox(BlockPos pos) {
        return new Box(pos).expand(SEARCH_RADIUS);
    }

    public static void register() {
        ServerTickEvents.END_WORLD_TICK.register(EmberstoneAutoSmelt::processWorld);
    }

    private static void processWorld(ServerWorld world) {
        if (PENDING.isEmpty()) {
            return;
        }
        List<PendingSmelt> toProcess = new ArrayList<>();
        PENDING.removeIf(pending -> {
            if (pending.world() == world) {
                toProcess.add(pending);
                return true;
            }
            return false;
        });
        for (PendingSmelt pending : toProcess) {
            process(world, pending.pos(), pending.preExistingItemIds());
        }
    }

    private static void process(ServerWorld world, BlockPos pos, Set<Integer> preExistingItemIds) {
        List<ItemEntity> nearby = world.getEntitiesByType(TypeFilter.instanceOf(ItemEntity.class),
                searchBox(pos), item -> !preExistingItemIds.contains(item.getId()));

        boolean smelted = false;
        for (ItemEntity itemEntity : nearby) {
            ItemStack stack = itemEntity.getStack();
            SingleStackRecipeInput input = new SingleStackRecipeInput(new ItemStack(stack.getItem()));
            Optional<RecipeEntry<SmeltingRecipe>> match = SMELTING_MATCHER.getFirstMatch(input, world);
            if (match.isEmpty()) {
                continue;
            }

            ItemStack singleResult = match.get().value().craft(input, world.getRegistryManager());
            if (singleResult.isEmpty()) {
                continue;
            }

            ItemStack smeltedStack = singleResult.copy();
            smeltedStack.setCount(singleResult.getCount() * stack.getCount());
            itemEntity.setStack(smeltedStack);
            smelted = true;
        }

        if (smelted) {
            world.spawnParticles(ParticleTypes.LARGE_SMOKE,
                    pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    10, 0.3, 0.3, 0.3, 0.02);
            world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_BURN, SoundCategory.BLOCKS, 0.6f, 1.1f);
        }
    }
}
