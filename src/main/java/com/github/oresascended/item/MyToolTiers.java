package com.github.oresascended.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class MyToolTiers {
    public static final Tier SAPPHIRE_TIER = new SimpleTier(TagsInit.Blocks.INCORRECT_FOR_SAPPHIRE,
            1400, 9.0F, 3.0F, 12, () -> Ingredient.of(ItemInit.SAPPHIRE));

    public static final Tier RUBY_TIER = new SimpleTier(TagsInit.Blocks.INCORRECT_FOR_RUBY,
            2048, 10F, 4.0F, 16, () -> Ingredient.of(ItemInit.RUBY));

    public static final Tier AQUAMARINE_TIER = new SimpleTier(TagsInit.Blocks.INCORRECT_FOR_AQUAMARINE,
            512, 12.0F, 4.0F, 24, () -> Ingredient.of(ItemInit.AQUAMARINE));

    public static final Tier CELESTIUM_TIER = new SimpleTier(TagsInit.Blocks.INCORRECT_FOR_CELESTIUM,
            2400, 10.0F, 5F, 20, () -> Ingredient.of(ItemInit.CELESTIUM));

    public static final Tier CRIMSONITE_TIER = new SimpleTier(TagsInit.Blocks.INCORRECT_FOR_CRIMSONITE,
            3200, 12.0F, 6.0F, 20, () -> Ingredient.of(ItemInit.CRIMSONITE));


}
