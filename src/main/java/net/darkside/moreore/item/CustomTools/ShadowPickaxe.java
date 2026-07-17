package net.darkside.moreore.item.CustomTools;

import net.darkside.moreore.effect.ModEffect;
import net.minecraft.entity.Entity;
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
import net.darkside.moreore.util.ModTags;

import java.util.List;

public class ShadowPickaxe extends PickaxeItem {
    private static final int DURATION = 60;
    private static final int AMP = 5;
    private static final int DARK_LEVEL = 4;

    public ShadowPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
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
                    ModEffect.SHADOW_TOOL,
                    DURATION,
                    AMP,
                    true,
                    false,
                    false
            ));
            player.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.HASTE,
                    DURATION,
                    1,
                    true,
                    false,
                    false
            ));
        } else {
            var cur = player.getStatusEffect(ModEffect.SHADOW_TOOL);
            if (cur != null && cur.isAmbient() && !cur.shouldShowIcon()) {
                player.removeStatusEffect(ModEffect.SHADOW_TOOL);
                player.removeStatusEffect(StatusEffects.HASTE);
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.moreore.shadow_tool.line1").formatted(Formatting.DARK_PURPLE));
        tooltip.add(Text.translatable("tooltip.moreore.shadow_tool.line2").formatted(Formatting.GRAY));
    }
}
