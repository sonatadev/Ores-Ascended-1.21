package com.github.oresascended.item.tools;

import com.github.oresascended.item.misc.AlloyInit;
import com.github.oresascended.item.misc.OreInit;
import com.github.oresascended.tags.TagsInit;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class MyToolTiers {
    public static final Tier SAPPHIRE_TIER = new SimpleTier(TagsInit.Blocks.INCORRECT_FOR_SAPPHIRE,
            1024, 8.0F, 3.0F, 12, () -> Ingredient.of(OreInit.SAPPHIRE));

    public static final Tier RUBY_TIER = new SimpleTier(TagsInit.Blocks.INCORRECT_FOR_RUBY,
            2048, 9.0F, 4.0F, 16, () -> Ingredient.of(OreInit.RUBY));

    public static final Tier AETHERIUM_TIER = new SimpleTier(TagsInit.Blocks.INCORRECT_FOR_RUBY,
            3072, 10.0F, 5.0F, 20, () -> Ingredient.of(OreInit.AETHERIUM));

    public static final Tier AQUAMARINE_TIER = new SimpleTier(TagsInit.Blocks.INCORRECT_FOR_AQUAMARINE,
            512, 9.0F, 4.0F, 24, () -> Ingredient.of(AlloyInit.AQUAMARINE));

    public static final Tier CELESTIUM_TIER = new SimpleTier(TagsInit.Blocks.INCORRECT_FOR_CELESTIUM,
            3072, 10.0F, 5.0F, 20, () -> Ingredient.of(AlloyInit.CELESTIUM));

    public static final Tier CRIMSONITE_TIER = new SimpleTier(TagsInit.Blocks.INCORRECT_FOR_CRIMSONITE,
            4096, 11.0F, 6.0F, 22, () -> Ingredient.of(AlloyInit.CRIMSONITE));



}
