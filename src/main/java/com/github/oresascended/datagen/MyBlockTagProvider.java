package com.github.oresascended.datagen;

import com.github.oresascended.OresAscended;
import com.github.oresascended.block.BlockInit;
import com.github.oresascended.item.TagsInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
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
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                //dropSelf Blocks
                .add(BlockInit.SAPPHIRE_BLOCK.get())
                .add(BlockInit.RUBY_BLOCK.get())
                //dropOre Blocks
                .add(BlockInit.SAPPHIRE_ORE.get())
                .add(BlockInit.DEEPSLATE_SAPPHIRE_ORE.get())
                .add(BlockInit.RUBY_ORE.get())
                .add(BlockInit.DEEPSLATE_RUBY_ORE.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                //dropSelf Blocks
                .add(BlockInit.SAPPHIRE_BLOCK.get())
                //dropOre Blocks
                .add(BlockInit.SAPPHIRE_ORE.get())
                .add(BlockInit.DEEPSLATE_SAPPHIRE_ORE.get());
        tag(TagsInit.Blocks.NEEDS_SAPPHIRE_TOOL)
                .add(BlockInit.RUBY_ORE.get())
                .add(BlockInit.DEEPSLATE_RUBY_ORE.get());
    }
}
