package com.github.oresascended.datagen;

import com.github.oresascended.OresAscended;
import com.github.oresascended.block.BlockInit;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.*;

public class MyBlockStateProvider extends BlockStateProvider {
    public MyBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, OresAscended.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        BlockInit.BLOCKS.getEntries().stream().map(DeferredHolder::get).forEach(block -> {
            blockWithItem(block);
        });
    }
    //register as block items
    private void blockWithItem(Block block){
        simpleBlockWithItem(block, cubeAll(block));
    }
}