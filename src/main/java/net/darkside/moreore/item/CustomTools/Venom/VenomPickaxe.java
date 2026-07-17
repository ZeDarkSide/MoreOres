package net.darkside.moreore.item.CustomTools.Venom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class VenomPickaxe extends PickaxeItem {
    public VenomPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    private static final int POISON_DURATION = 100;
    private static final int POISON_AMPLIFIER = 3;
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = attacker.getWorld();
        if (!world.isClient) {
            target.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.POISON,
                    POISON_DURATION,
                    POISON_AMPLIFIER,
                    false,
                    false
            ), attacker);
        }


        return super.postHit(stack, target, attacker);
    }
    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        int seconds = POISON_DURATION / 20;
        tooltip.add(Text.translatable("tooltip.moreore.venom_tool.line1").formatted(Formatting.GREEN));
        tooltip.add(Text.translatable("tooltip.moreore.venom_tool.line2", POISON_AMPLIFIER + 1, seconds)
                .formatted(Formatting.DARK_GREEN));
    }
}
