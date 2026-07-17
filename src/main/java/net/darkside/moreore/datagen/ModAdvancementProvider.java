package net.darkside.moreore.datagen;

import net.darkside.moreore.MoreOre;
import net.darkside.moreore.block.ModBlocks;
import net.darkside.moreore.item.ModItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {

        Advancement root = Advancement.Builder.create()
                .display(
                        new ItemStack(ModBlocks.VENOM_ORE),
                        Text.translatable("advancement.moreore.venom_ore.title"),
                        Text.translatable("advancement.moreore.venom_ore.desc"),
                        new Identifier("minecraft", "textures/gui/advancements/backgrounds/stone.png"),
                        AdvancementFrame.TASK,
                        true,   // show toast
                        true,   // announce to chat
                        false   // hidden
                )
                .criterion("got_venom_ore",
                        InventoryChangedCriterion.Conditions.items(ModItems.CHUNK_OF_VENOM.asItem()))
                .build(consumer, id("root"));


        Advancement venomSword = Advancement.Builder.create()
                .parent(root)
                .display(
                        new ItemStack(ModItems.VENOM_SWORD),
                        Text.translatable("advancement.moreore.venom_sword.title"),
                        Text.translatable("advancement.moreore.venom_sword.desc"),
                        null,
                        AdvancementFrame.GOAL,
                        true, true, false
                )
                .criterion("has_venom_sword",
                        InventoryChangedCriterion.Conditions.items(ModItems.VENOM_SWORD))
                .build(consumer, id("venom_sword"));

        Advancement venomPickaxe = Advancement.Builder.create()
                .parent(root)
                .display(
                        new ItemStack(ModItems.VENOM_PICKAXE),
                        Text.translatable("advancement.moreore.venom_pick.title"),
                        Text.translatable("advancement.moreore.venom_pick.desc"),
                        null,
                        AdvancementFrame.GOAL,
                        true, true, false
                )
                .criterion("has_venom_pickaxe",
                        InventoryChangedCriterion.Conditions.items(ModItems.VENOM_PICKAXE))
                .build(consumer, id("venom_pickaxe"));

    }

    private static String id(String path) {
        return MoreOre.MOD_ID + ":" + path;
    }
}
