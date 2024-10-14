package com.github.oresascended.datagen;

import com.github.oresascended.OresAscended;
import com.github.oresascended.block.BlockInit;
import com.github.oresascended.item.TagsInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.internal.NeoForgeItemTagsProvider;
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

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(BlockInit.SAPPHIRE_BLOCK.get())
                .add(BlockInit.SAPPHIRE_ORE.get())
                .add(BlockInit.DEEPSLATE_SAPPHIRE_ORE.get());
        tag(Tags.Blocks.NEEDS_GOLD_TOOL)
                .addTags(BlockTags.NEEDS_IRON_TOOL);
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(BlockInit.RUBY_BLOCK.get())
                .add(BlockInit.RUBY_ORE.get())
                .add(BlockInit.DEEPSLATE_RUBY_ORE.get());
        tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);

        //sapphire tags
        tag(TagsInit.Blocks.NEEDS_SAPPHIRE_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(TagsInit.Blocks.INCORRECT_FOR_SAPPHIRE)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(TagsInit.Blocks.NEEDS_SAPPHIRE_TOOL);
        //ruby tags
        tag(TagsInit.Blocks.NEEDS_RUBY_TOOL)
                .addTag(Tags.Blocks.NEEDS_NETHERITE_TOOL); //NEED TO CHANGE ASAP

        tag(TagsInit.Blocks.INCORRECT_FOR_RUBY)
                .addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                .remove(TagsInit.Blocks.NEEDS_RUBY_TOOL);

    }
}
