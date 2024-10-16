package com.github.oresascended.datagen;

import com.github.oresascended.OresAscended;
import com.github.oresascended.block.BlockInit;
import com.github.oresascended.block.OreBlockInit;
import com.github.oresascended.item.misc.OreInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MyRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public MyRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> SAPPHIRE_SMELTABLES = List.of(OreBlockInit.SAPPHIRE_ORE, OreBlockInit.DEEPSLATE_SAPPHIRE_ORE);
        List<ItemLike> RUBY_SMELTABLES = List.of(OreBlockInit.RUBY_ORE);
        List<ItemLike> AETHERIUM_SMELTABLES = List.of(OreBlockInit.AETHERIUM_ORE);

        //shaped recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockInit.SAPPHIRE_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', OreInit.SAPPHIRE.get())
                .unlockedBy("has_sapphire", has(OreInit.SAPPHIRE)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockInit.RUBY_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', OreInit.RUBY.get())
                .unlockedBy("has_ruby", has(OreInit.RUBY)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockInit.AETHERIUM_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', OreInit.AETHERIUM.get())
                .unlockedBy("has_aetherium", has(OreInit.AETHERIUM)).save(recipeOutput);

        //shapeless recipes
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OreInit.SAPPHIRE.get(), 9)
                .requires(BlockInit.SAPPHIRE_BLOCK)
                .unlockedBy("has_sapphire_block", has(BlockInit.SAPPHIRE_BLOCK)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OreInit.RUBY.get(), 9)
                .requires(BlockInit.RUBY_BLOCK)
                .unlockedBy("has_ruby_block", has(BlockInit.RUBY_BLOCK)).save(recipeOutput);
        //smelting recipes
        oreSmelting(recipeOutput, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, OreInit.SAPPHIRE.get(), 0.25f, 200, "sapphire");
        oreSmelting(recipeOutput, RUBY_SMELTABLES, RecipeCategory.MISC, OreInit.RUBY.get(), 0.25f, 200, "ruby");
        oreSmelting(recipeOutput, AETHERIUM_SMELTABLES, RecipeCategory.MISC, OreInit.AETHERIUM.get(), 0.25f, 200, "aetherium");

        oreBlasting(recipeOutput, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, OreInit.SAPPHIRE.get(), 0.25f, 100, "sapphire");
        oreBlasting(recipeOutput, RUBY_SMELTABLES, RecipeCategory.MISC, OreInit.RUBY.get(), 0.25f, 100, "ruby");
        oreBlasting(recipeOutput, AETHERIUM_SMELTABLES, RecipeCategory.MISC, OreInit.AETHERIUM.get(), 0.25f, 100, "aetherium");


    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, OresAscended.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
