package com.github.oresascended.datagen;

import com.github.oresascended.OresAscended;
import com.github.oresascended.block.BlockInit;
import com.github.oresascended.block.OreBlockInit;
import com.github.oresascended.tags.TagsInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class MyBlockTagProvider extends BlockTagsProvider {

    public MyBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, OresAscended.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        BlockInit.BLOCKS.getEntries().forEach(deferredBlock -> {
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(deferredBlock.get());

        });

        OreBlockInit.ORE_BLOCKS.getEntries().forEach(deferredOreBlock -> {
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(deferredOreBlock.get());
        });

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(BlockInit.SAPPHIRE_BLOCK.get())
                .add(OreBlockInit.SAPPHIRE_ORE.get())
                .add(OreBlockInit.DEEPSLATE_SAPPHIRE_ORE.get());
        tag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .addTag(Tags.Blocks.NEEDS_NETHERITE_TOOL);
        tag(Tags.Blocks.NEEDS_GOLD_TOOL)
                .addTags(BlockTags.NEEDS_IRON_TOOL);
        tag(BlockTags.INCORRECT_FOR_GOLD_TOOL)
                .addTag(Tags.Blocks.NEEDS_NETHERITE_TOOL);
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(BlockInit.RUBY_BLOCK.get())
                .add(OreBlockInit.RUBY_ORE.get());
        tag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .addTag(Tags.Blocks.NEEDS_NETHERITE_TOOL);

        tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(BlockInit.AETHERIUM_BLOCK.get())
                .add(OreBlockInit.AETHERIUM_ORE.get());

        //sapphire tags
        tag(TagsInit.Blocks.NEEDS_SAPPHIRE_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(TagsInit.Blocks.INCORRECT_FOR_SAPPHIRE)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(TagsInit.Blocks.NEEDS_SAPPHIRE_TOOL);
        //ruby tags
        tag(TagsInit.Blocks.NEEDS_RUBY_TOOL)
                .addTag(Tags.Blocks.NEEDS_NETHERITE_TOOL);

        tag(TagsInit.Blocks.INCORRECT_FOR_RUBY)
                .addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                .remove(TagsInit.Blocks.NEEDS_RUBY_TOOL);
        //aetherium tags
        tag(TagsInit.Blocks.NEEDS_AETHERIUM_TOOL);

        tag(TagsInit.Blocks.INCORRECT_FOR_RUBY)
                .remove(TagsInit.Blocks.NEEDS_AETHERIUM_TOOL);
    }
}
