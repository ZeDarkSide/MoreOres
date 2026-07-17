package net.darkside.moreore.item.CustomTools.Emberstone;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class EmberstoneHoe extends HoeItem {
    private static final int BURN_SECONDS = 4;

    public EmberstoneHoe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
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
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.moreore.emberstone_tool.line1").formatted(Formatting.GOLD));
        tooltip.add(Text.translatable("tooltip.moreore.emberstone_tool.line2", BURN_SECONDS)
                .formatted(Formatting.RED));
    }
}
