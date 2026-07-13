package net.darkside.moreore.datagen;

import net.darkside.moreore.block.ModBlocks;
import net.darkside.moreore.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.item.MinecartItem;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;
public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    // <editor-fold desc="a fake region">
    // </editor-fold>

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {

                // <editor-fold desc="Venom Crafting">
                List<ItemConvertible> VENOM = List.of( ModBlocks.VENOM_ORE);

                offerSmelting(VENOM, RecipeCategory.MISC, ModItems.CHUNK_OF_VENOM, 0.25f, 200, "venom_ores");



                createShaped(RecipeCategory.MISC, ModItems.VENOM_PICKAXE)
                        .pattern("RRR")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('R', ModItems.CHUNK_OF_VENOM)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.CHUNK_OF_VENOM), conditionsFromItem(ModItems.CHUNK_OF_VENOM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.VENOM_SWORD)
                        .pattern(" R ")
                        .pattern(" R ")
                        .pattern(" S ")
                        .input('R', ModItems.CHUNK_OF_VENOM)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.CHUNK_OF_VENOM), conditionsFromItem(ModItems.CHUNK_OF_VENOM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.VENOM_HOE)
                        .pattern("RR ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('R', ModItems.CHUNK_OF_VENOM)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.CHUNK_OF_VENOM), conditionsFromItem(ModItems.CHUNK_OF_VENOM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.VENOM_AXE)
                        .pattern(" RR")
                        .pattern(" SR")
                        .pattern(" S ")
                        .input('R', ModItems.CHUNK_OF_VENOM)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.CHUNK_OF_VENOM), conditionsFromItem(ModItems.CHUNK_OF_VENOM))
                        .offerTo(exporter);


                createShaped(RecipeCategory.MISC, ModItems.VENOM_SHOVEL)
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
                offerSmelting(SHADOW, RecipeCategory.MISC, ModItems.SHADOW_SCRAP, 0.45f, 400, "shadow_ores");
                createShaped(RecipeCategory.MISC, ModItems.SHADOW_PICKAXE)
                        .pattern("RRR")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('R', ModItems.SHADOW_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.SHADOW_INGOT), conditionsFromItem(ModItems.SHADOW_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.SHADOW_SWORD)
                        .pattern(" R ")
                        .pattern(" R ")
                        .pattern(" S ")
                        .input('R', ModItems.SHADOW_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.SHADOW_INGOT), conditionsFromItem(ModItems.SHADOW_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.SHADOW_HOE)
                        .pattern("RR ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('R', ModItems.SHADOW_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.SHADOW_INGOT), conditionsFromItem(ModItems.SHADOW_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.SHADOW_AXE)
                        .pattern(" RR")
                        .pattern(" SR")
                        .pattern(" S ")
                        .input('R', ModItems.SHADOW_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.SHADOW_INGOT), conditionsFromItem(ModItems.SHADOW_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.SHADOW_SHOVEL)
                        .pattern(" R ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('R', ModItems.SHADOW_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.SHADOW_INGOT), conditionsFromItem(ModItems.SHADOW_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.SHADOW_INGOT)
                        .pattern("DDD")
                        .pattern(" S ")
                        .pattern("DSD")
                        .input('S', ModItems.SHADOW_SCRAP)
                        .input('D', Items.DIAMOND)
                        .criterion(hasItem(ModItems.SHADOW_SCRAP), conditionsFromItem(ModItems.SHADOW_SCRAP))
                        .offerTo(exporter);
                // </editor-fold>

                // <editor-fold desc="Copy paste stuff>
               /* createShaped(RecipeCategory.MISC, ModBlocks.RAW_PINK_GARNET_BLOCK)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .input('R', ModItems.RAW_PINK_GARNET)
                        .criterion(hasItem(ModItems.RAW_PINK_GARNET), conditionsFromItem(ModItems.RAW_PINK_GARNET))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 9)
                        .input(ModBlocks.RAW_PINK_GARNET_BLOCK)
                        .criterion(hasItem(ModBlocks.RAW_PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.RAW_PINK_GARNET_BLOCK))
                        .offerTo(exporter);*/
// </editor-fold>
            }
        };
    }

    @Override
    public String getName() {
        return "moreores";
    }
}
