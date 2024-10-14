package com.github.oresascended.datagen;

import com.github.oresascended.OresAscended;
import com.github.oresascended.block.BlockInit;
import com.github.oresascended.item.ItemInit;
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
        List<ItemLike> SAPPHIRE_SMELTABLES = List.of(BlockInit.SAPPHIRE_ORE, BlockInit.DEEPSLATE_SAPPHIRE_ORE);
        List<ItemLike> RUBY_SMELTABLES = List.of(BlockInit.RUBY_ORE, BlockInit.DEEPSLATE_RUBY_ORE);

        //shaped recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockInit.SAPPHIRE_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ItemInit.SAPPHIRE.get())
                .unlockedBy("has_sapphire", has(ItemInit.SAPPHIRE)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockInit.RUBY_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ItemInit.RUBY.get())
                .unlockedBy("has_ruby", has(ItemInit.RUBY)).save(recipeOutput);

        //shapeless recipes
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.SAPPHIRE.get(), 9)
                .requires(BlockInit.SAPPHIRE_BLOCK)
                .unlockedBy("has_sapphire_block", has(BlockInit.SAPPHIRE_BLOCK)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.RUBY.get(), 9)
                .requires(BlockInit.RUBY_BLOCK)
                .unlockedBy("has_ruby_block", has(BlockInit.RUBY_BLOCK)).save(recipeOutput);
        //smelting recipes
        oreSmelting(recipeOutput, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ItemInit.SAPPHIRE.get(), 0.25f, 200, "sapphire");
        oreSmelting(recipeOutput, RUBY_SMELTABLES, RecipeCategory.MISC, ItemInit.RUBY.get(), 0.25f, 200, "ruby");

        oreBlasting(recipeOutput, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ItemInit.SAPPHIRE.get(), 0.25f, 100, "sapphire");
        oreBlasting(recipeOutput, RUBY_SMELTABLES, RecipeCategory.MISC, ItemInit.RUBY.get(), 0.25f, 100, "ruby");



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
