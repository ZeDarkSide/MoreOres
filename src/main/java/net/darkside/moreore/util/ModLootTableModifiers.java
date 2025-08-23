package net.darkside.moreore.util;

import net.darkside.moreore.item.ModItems;
import net.darkside.moreore.block.ModBlocks;
import net.darkside.moreore.util.ModTags;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
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
import net.minecraft.predicate.item.EnchantmentsPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.predicate.item.ItemSubPredicateTypes;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;


import java.util.List;

public final class ModLootTableModifiers {
    private static final Identifier DIAMOND_ORE_ID = Identifier.of("minecraft", "blocks/diamond_ore");
    private static final Identifier DEEPSLATE_DIAMOND_ORE_ID = Identifier.of("minecraft", "blocks/deepslate_diamond_ore");

    public static void register() {
        LootTableEvents.REPLACE.register((key, original, source, registries) -> {
            if (key.getValue().equals(DIAMOND_ORE_ID)) {
                return makeDiamondLikeTable(
                        registries,
                        /* silk drop: */ ItemEntry.builder(Items.DIAMOND_ORE), // if you want silk to drop vanilla diamond_ore instead, swap to ItemEntry.builder(Items.DIAMOND_ORE)
                        /* default drop: */ ItemEntry.builder(Items.DIAMOND),
                        /* venom drop: */ ItemEntry.builder(ModItems.CHUNK_OF_VENOM)
                );
            }
            if (key.getValue().equals(DEEPSLATE_DIAMOND_ORE_ID)) {
                return makeDiamondLikeTable(
                        registries,
                        /* silk drop: */ ItemEntry.builder(Items.DEEPSLATE_DIAMOND_ORE), // or Items.DEEPSLATE_DIAMOND_ORE for pure vanilla silk behavior
                        /* default drop: */ ItemEntry.builder(Items.DIAMOND),
                        /* venom drop: */ ItemEntry.builder(ModItems.CHUNK_OF_VENOM)
                );
            }
            return null;
        });
    }

    private static LootTable makeDiamondLikeTable(
            RegistryWrapper.WrapperLookup registries,
            ItemEntry.Builder<?> silkDrop,
            ItemEntry.Builder<?> defaultDrop,
            ItemEntry.Builder<?> venomDrop
    ) {
        RegistryWrapper.Impl<Enchantment> enchReg = registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        RegistryWrapper.Impl<Item>        itemReg = registries.getOrThrow(RegistryKeys.ITEM);

        LootCondition.Builder silkTouch = MatchToolLootCondition.builder(
                ItemPredicate.Builder.create().subPredicate(
                        ItemSubPredicateTypes.ENCHANTMENTS,
                        EnchantmentsPredicate.enchantments(List.of(
                                new EnchantmentPredicate(enchReg.getOrThrow(Enchantments.SILK_TOUCH),
                                        NumberRange.IntRange.atLeast(1))
                        ))
                )
        );


        LootCondition.Builder isVenomTool = MatchToolLootCondition.builder(
                ItemPredicate.Builder.create().tag(itemReg, ModTags.Items.VENOM_TOOLS)
        );


        defaultDrop = defaultDrop
                .apply(ApplyBonusLootFunction.oreDrops(enchReg.getOrThrow(Enchantments.FORTUNE)))
                .apply(ExplosionDecayLootFunction.builder());

        venomDrop = venomDrop
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
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
