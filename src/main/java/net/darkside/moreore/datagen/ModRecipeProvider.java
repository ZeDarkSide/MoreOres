package net.darkside.moreore.datagen;

import net.darkside.moreore.block.ModBlocks;
import net.darkside.moreore.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;
import java.util.function.Consumer;
public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
                // <editor-fold desc="Venom Crafting">
                List<ItemConvertible> VENOM = List.of( ModBlocks.VENOM_ORE);

                offerSmelting(exporter, VENOM, RecipeCategory.MISC, ModItems.CHUNK_OF_VENOM, 0.25f, 200, "venom_ores");



                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VENOM_PICKAXE)
                        .pattern("RRR")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('R', ModItems.CHUNK_OF_VENOM)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.CHUNK_OF_VENOM), conditionsFromItem(ModItems.CHUNK_OF_VENOM))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VENOM_SWORD)
                        .pattern(" R ")
                        .pattern(" R ")
                        .pattern(" S ")
                        .input('R', ModItems.CHUNK_OF_VENOM)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.CHUNK_OF_VENOM), conditionsFromItem(ModItems.CHUNK_OF_VENOM))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VENOM_HOE)
                        .pattern("RR ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('R', ModItems.CHUNK_OF_VENOM)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.CHUNK_OF_VENOM), conditionsFromItem(ModItems.CHUNK_OF_VENOM))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VENOM_AXE)
                        .pattern(" RR")
                        .pattern(" SR")
                        .pattern(" S ")
                        .input('R', ModItems.CHUNK_OF_VENOM)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.CHUNK_OF_VENOM), conditionsFromItem(ModItems.CHUNK_OF_VENOM))
                        .offerTo(exporter);


                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VENOM_SHOVEL)
                        .pattern(" R ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('R', ModItems.CHUNK_OF_VENOM)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.CHUNK_OF_VENOM), conditionsFromItem(ModItems.CHUNK_OF_VENOM))
                        .offerTo(exporter);
// </editor-fold>

                // <editor-fold desc="Shadow Crafting">
                List<ItemConvertible> SHADOW = List.of( ModBlocks.SHADOW_ORE);
                offerSmelting(exporter, SHADOW, RecipeCategory.MISC, ModItems.SHADOW_SCRAP, 0.45f, 400, "shadow_ores");
                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SHADOW_PICKAXE)
                        .pattern("RRR")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('R', ModItems.SHADOW_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.SHADOW_INGOT), conditionsFromItem(ModItems.SHADOW_INGOT))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SHADOW_SWORD)
                        .pattern(" R ")
                        .pattern(" R ")
                        .pattern(" S ")
                        .input('R', ModItems.SHADOW_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.SHADOW_INGOT), conditionsFromItem(ModItems.SHADOW_INGOT))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SHADOW_HOE)
                        .pattern("RR ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('R', ModItems.SHADOW_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.SHADOW_INGOT), conditionsFromItem(ModItems.SHADOW_INGOT))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SHADOW_AXE)
                        .pattern(" RR")
                        .pattern(" SR")
                        .pattern(" S ")
                        .input('R', ModItems.SHADOW_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.SHADOW_INGOT), conditionsFromItem(ModItems.SHADOW_INGOT))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SHADOW_SHOVEL)
                        .pattern(" R ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('R', ModItems.SHADOW_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.SHADOW_INGOT), conditionsFromItem(ModItems.SHADOW_INGOT))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SHADOW_INGOT)
                        .pattern("DDD")
                        .pattern(" S ")
                        .pattern("DSD")
                        .input('S', ModItems.SHADOW_SCRAP)
                        .input('D', Items.DIAMOND)
                        .criterion(hasItem(ModItems.SHADOW_SCRAP), conditionsFromItem(ModItems.SHADOW_SCRAP))
                        .offerTo(exporter);
                // </editor-fold>

                // <editor-fold desc="Emberstone Crafting">
                List<ItemConvertible> EMBERSTONE = List.of(ModBlocks.EMBERSTONE_ORE);
                offerSmelting(exporter, EMBERSTONE, RecipeCategory.MISC, ModItems.EMBERSTONE_INGOT, 0.5f, 300, "emberstone_ores");

                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EMBERSTONE_PICKAXE)
                        .pattern("RRR")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('R', ModItems.EMBERSTONE_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.EMBERSTONE_INGOT), conditionsFromItem(ModItems.EMBERSTONE_INGOT))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EMBERSTONE_SWORD)
                        .pattern(" R ")
                        .pattern(" R ")
                        .pattern(" S ")
                        .input('R', ModItems.EMBERSTONE_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.EMBERSTONE_INGOT), conditionsFromItem(ModItems.EMBERSTONE_INGOT))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EMBERSTONE_HOE)
                        .pattern("RR ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('R', ModItems.EMBERSTONE_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.EMBERSTONE_INGOT), conditionsFromItem(ModItems.EMBERSTONE_INGOT))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EMBERSTONE_AXE)
                        .pattern(" RR")
                        .pattern(" SR")
                        .pattern(" S ")
                        .input('R', ModItems.EMBERSTONE_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.EMBERSTONE_INGOT), conditionsFromItem(ModItems.EMBERSTONE_INGOT))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EMBERSTONE_SHOVEL)
                        .pattern(" R ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('R', ModItems.EMBERSTONE_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.EMBERSTONE_INGOT), conditionsFromItem(ModItems.EMBERSTONE_INGOT))
                        .offerTo(exporter);
                // </editor-fold>

                // <editor-fold desc="Fire Tree Crafting">
                List<ItemConvertible> FIRE_LOGS = List.of(ModBlocks.FIRE_LOG);
                offerSmelting(exporter, FIRE_LOGS, RecipeCategory.MISC, Items.CHARCOAL, 0.15f, 200, "coal");

                ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIRE_PLANKS, 4)
                        .input(ModBlocks.FIRE_LOG)
                        .criterion(hasItem(ModBlocks.FIRE_LOG), conditionsFromItem(ModBlocks.FIRE_LOG))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.FIRE_DOOR, 3)
                        .pattern("##")
                        .pattern("##")
                        .pattern("##")
                        .input('#', ModBlocks.FIRE_PLANKS)
                        .criterion(hasItem(ModBlocks.FIRE_PLANKS), conditionsFromItem(ModBlocks.FIRE_PLANKS))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.FIRE_TRAPDOOR, 2)
                        .pattern("###")
                        .pattern("###")
                        .input('#', ModBlocks.FIRE_PLANKS)
                        .criterion(hasItem(ModBlocks.FIRE_PLANKS), conditionsFromItem(ModBlocks.FIRE_PLANKS))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIRE_STAIRS, 4)
                        .pattern("#  ")
                        .pattern("## ")
                        .pattern("###")
                        .input('#', ModBlocks.FIRE_PLANKS)
                        .criterion(hasItem(ModBlocks.FIRE_PLANKS), conditionsFromItem(ModBlocks.FIRE_PLANKS))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIRE_SLAB, 6)
                        .pattern("###")
                        .input('#', ModBlocks.FIRE_PLANKS)
                        .criterion(hasItem(ModBlocks.FIRE_PLANKS), conditionsFromItem(ModBlocks.FIRE_PLANKS))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.FIRE_FENCE, 3)
                        .pattern("W#W")
                        .pattern("W#W")
                        .input('W', ModBlocks.FIRE_PLANKS)
                        .input('#', Items.STICK)
                        .criterion(hasItem(ModBlocks.FIRE_PLANKS), conditionsFromItem(ModBlocks.FIRE_PLANKS))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.FIRE_FENCE_GATE)
                        .pattern("#W#")
                        .pattern("#W#")
                        .input('W', ModBlocks.FIRE_PLANKS)
                        .input('#', Items.STICK)
                        .criterion(hasItem(ModBlocks.FIRE_PLANKS), conditionsFromItem(ModBlocks.FIRE_PLANKS))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.FIRE_PRESSURE_PLATE)
                        .pattern("##")
                        .input('#', ModBlocks.FIRE_PLANKS)
                        .criterion(hasItem(ModBlocks.FIRE_PLANKS), conditionsFromItem(ModBlocks.FIRE_PLANKS))
                        .offerTo(exporter);

                ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.FIRE_BUTTON)
                        .input(ModBlocks.FIRE_PLANKS)
                        .criterion(hasItem(ModBlocks.FIRE_PLANKS), conditionsFromItem(ModBlocks.FIRE_PLANKS))
                        .offerTo(exporter);
                // </editor-fold>

                // <editor-fold desc="Copy paste stuff>
               /* ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RAW_PINK_GARNET_BLOCK)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .input('R', ModItems.RAW_PINK_GARNET)
                        .criterion(hasItem(ModItems.RAW_PINK_GARNET), conditionsFromItem(ModItems.RAW_PINK_GARNET))
                        .offerTo(exporter);

                ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 9)
                        .input(ModBlocks.RAW_PINK_GARNET_BLOCK)
                        .criterion(hasItem(ModBlocks.RAW_PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.RAW_PINK_GARNET_BLOCK))
                        .offerTo(exporter);*/
// </editor-fold>
    }

    @Override
    public String getName() {
        return "moreores";
    }
}
