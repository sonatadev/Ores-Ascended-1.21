package com.github.oresascended.item;

import com.github.oresascended.OresAscended;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class TagsInit {
    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(OresAscended.MODID, name));
        }
        //needs tags
        public static final TagKey<Block> NEEDS_SAPPHIRE_TOOL = createTag("needs_sapphire_tool");
        public static final TagKey<Block> NEEDS_RUBY_TOOL = createTag("needs_ruby_tool");

        public static final TagKey<Block> NEEDS_AQUAMARINE_TOOL = createTag("needs_aquamarine_tool");
        public static final TagKey<Block> NEEDS_CELESTIUM_TOOL = createTag("needs_celestium_tool");
        public static final TagKey<Block> NEEDS_CRIMSONITE_TOOL = createTag("needs_crimsonite_tool");
        //incorrect for tags
        public static final TagKey<Block> INCORRECT_FOR_SAPPHIRE = createTag("incorrect_for_sapphire");
        public static final TagKey<Block> INCORRECT_FOR_RUBY = createTag("incorrect_for_ruby");

        public static final TagKey<Block> INCORRECT_FOR_AQUAMARINE = createTag("incorrect_for_aquamarine");
        public static final TagKey<Block> INCORRECT_FOR_CELESTIUM = createTag("incorrect_for_celestium");
        public static final TagKey<Block> INCORRECT_FOR_CRIMSONITE = createTag("incorrect_for_crimsonite");

    }


    public static class Items {
        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(OresAscended.MODID, name));
        }

        public static final TagKey<Item> ALLOYED_ITEMS = createTag("alloyed_items");

    }
}
