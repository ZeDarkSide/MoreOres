package net.darkside.moreore.util;

import net.darkside.moreore.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.ExplosionDecayLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.item.EnchantmentPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.util.Identifier;

public final class ModLootTableModifiers {
    private static final Identifier DIAMOND_ORE_ID = new Identifier("minecraft", "blocks/diamond_ore");
    private static final Identifier DEEPSLATE_DIAMOND_ORE_ID = new Identifier("minecraft", "blocks/deepslate_diamond_ore");

    public static void register() {
        LootTableEvents.REPLACE.register((resourceManager, lootManager, id, original, source) -> {
            if (id.equals(DIAMOND_ORE_ID)) {
                return makeDiamondLikeTable(
                        /* silk drop: */ ItemEntry.builder(Items.DIAMOND_ORE),
                        /* default drop: */ ItemEntry.builder(Items.DIAMOND),
                        /* venom drop: */ ItemEntry.builder(ModItems.DECAYED_DIAMOND)
                );
            }
            if (id.equals(DEEPSLATE_DIAMOND_ORE_ID)) {
                return makeDiamondLikeTable(
                        /* silk drop: */ ItemEntry.builder(Items.DEEPSLATE_DIAMOND_ORE),
                        /* default drop: */ ItemEntry.builder(Items.DIAMOND),
                        /* venom drop: */ ItemEntry.builder(ModItems.DECAYED_DIAMOND)
                );
            }
            return null;
        });
    }

    private static LootTable makeDiamondLikeTable(
            ItemEntry.Builder<?> silkDrop,
            ItemEntry.Builder<?> defaultDrop,
            ItemEntry.Builder<?> venomDrop
    ) {
        LootCondition.Builder silkTouch = MatchToolLootCondition.builder(
                ItemPredicate.Builder.create().enchantment(
                        new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.atLeast(1))
                )
        );

        LootCondition.Builder isVenomTool = MatchToolLootCondition.builder(
                ItemPredicate.Builder.create().tag(ModTags.Items.VENOM_TOOLS)
        );

        defaultDrop = defaultDrop
                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                .apply(ExplosionDecayLootFunction.builder());

        venomDrop = venomDrop
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 1.0F)))
                .apply(ExplosionDecayLootFunction.builder());

        LootPool.Builder pool = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1.0F))
                .with(
                        silkDrop.conditionally(silkTouch)
                                .alternatively(
                                        venomDrop.conditionally(isVenomTool)
                                                .alternatively(defaultDrop)
                                )
                );

        return LootTable.builder().pool(pool).build();
    }

}
