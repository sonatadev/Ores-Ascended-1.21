package com.github.oresascended.datagen;

import com.github.oresascended.block.BlockInit;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class MyBlockStateProvider extends net.neoforged.neoforge.client.model.generators.BlockStateProvider {

    // Parameter values are provided by GatherDataEvent.
    public MyBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        // Replace "examplemod" with your own mod id.
        super(output, "examplemod", existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // Example block and textures
        Block block = BlockInit.SAPPHIRE_BLOCK.get();
        ResourceLocation exampleTexture = modLoc("block/example_texture");
        ResourceLocation bottomTexture = modLoc("block/example_texture_bottom");
        ResourceLocation topTexture = modLoc("block/example_texture_top");
        ResourceLocation sideTexture = modLoc("block/example_texture_side");
        ResourceLocation frontTexture = modLoc("block/example_texture_front");

        // Create a simple block model with the same texture on each side
        simpleBlock(block);

        // Creating a model with a specific texture
        ModelFile exampleModel = models().cubeAll("sapphire_block", exampleTexture);

        // Registering simple block with custom model
        simpleBlock(block, exampleModel);

        // Registering simple block item with the custom model
        simpleBlockItem(block, exampleModel);

        // Registering a log block (RotatedPillarBlock) assuming 'block' is a log
        logBlock((RotatedPillarBlock) block);

        // Log block with different side and top textures
        axisBlock((RotatedPillarBlock) block, sideTexture, topTexture);

        // Block with horizontal rotation
        horizontalBlock(block, sideTexture, frontTexture, topTexture);

        // Manually specifying model file for horizontal rotation
        horizontalBlock(block, exampleModel);

        // Directional block (can be rotated in all directions)
        directionalBlock(block, exampleModel);

        // Horizontal face block (e.g., buttons, levers attached to sides)
        horizontalFaceBlock(block, exampleModel);

        // Registering a custom ConfiguredModel
        ConfiguredModel.Builder<?> builder = ConfiguredModel.builder()
                .modelFile(exampleModel)
                .rotationX(90)
                .rotationY(180)
                .uvLock(true)
                .weight(5);
        ConfiguredModel[] model = builder.build();

        // Applying the custom model to all states of the block
        getVariantBuilder(block).forAllStates(state -> model);
    }
}