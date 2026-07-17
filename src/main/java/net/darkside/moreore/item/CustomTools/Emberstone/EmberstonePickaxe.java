package net.darkside.moreore.item.CustomTools.Emberstone;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class EmberstonePickaxe extends PickaxeItem {
    private static final int BURN_SECONDS = 4;

    public EmberstonePickaxe(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = attacker.getWorld();
        if (!world.isClient) {
            target.setOnFireFor(BURN_SECONDS);
        }

        return super.postHit(stack, target, attacker);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (world instanceof ServerWorld serverWorld && !miner.isSneaking()) {
            EmberstoneAutoSmelt.schedule(serverWorld, pos);
        }
        return super.postMine(stack, world, state, pos, miner);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.moreore.emberstone_tool.line1").formatted(Formatting.GOLD));
        tooltip.add(Text.translatable("tooltip.moreore.emberstone_tool.line2", BURN_SECONDS)
                .formatted(Formatting.RED));
        tooltip.add(Text.translatable("tooltip.moreore.emberstone_autosmelt.line1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("tooltip.moreore.emberstone_autosmelt.line2").formatted(Formatting.DARK_GRAY));
    }
}
