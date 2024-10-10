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
        // Placeholders, their usages should be replaced with real values. See above for how to use the model builder,
        // and below for the helpers the model builder offers.
        //ModelFile exampleModel = models().withExistingParent("minecraft:block/cobblestone");
        //ModelFile exampleModel = models().withExistingParent("sapphire_block", "minecraft:block/");

        for (DeferredHolder<Block, ? extends Block> deferredBlock : BlockInit.BLOCKS.getEntries()) {
            Block block = deferredBlock.get();
            String blockName = deferredBlock.getId().getPath();
            ResourceLocation blockTexture = modLoc("block/" + blockName);
            ModelFile blockModel = models().cubeAll(blockName, blockTexture);

            simpleBlock(block, blockModel);
            simpleBlockItem(block, blockModel);
        }

        // Create a simple block model with the same texture on each side.
        // The texture must be located at assets/<namespace>/textures/block/<path>.png, where
        // <namespace> and <path> are the block's registry name's namespace and path, respectively.
        // Used by the majority of (full) blocks, such as planks, cobblestone or bricks.
//        simpleBlock(block);
//        Overload that accepts a model file to use.
//        simpleBlock(block, exampleModel);
//        Overload that accepts one or multiple (vararg) ConfiguredModel objects.
//        See below for more info about ConfiguredModel.
//        simpleBlock(block, ConfiguredModel.builder().build());
//        Adds an item model file with the block's name, parenting the given model file, for a block item to pick up.
//        simpleBlockItem(block, exampleModel);
//        Shorthand for calling #simpleBlock() (model file overload) and #simpleBlockItem.
//        simpleBlockWithItem(block, exampleModel);

        // Adds a log block model. Requires two textures at assets/<namespace>/textures/block/<path>.png and
        // assets/<namespace>/textures/block/<path>_top.png, referencing the side and top texture, respectively.
        // Note that the block input here is limited to RotatedPillarBlock, which is the class vanilla logs use.
        //logBlock(block);
        // Like #logBlock, but the textures are named <path>_side.png and <path>_end.png instead of
        // <path>.png and <path>_top.png, respectively. Used by quartz pillars and similar blocks.
        // Has an overload that allow you to specify a different texture base name, that is then suffixed
        // with _side and _end as needed, an overload that allows you to specify two resource locations
        // for the side and end textures, and an overload that allows specifying side and end model files.
        //axisBlock(block);
        // Variants of #logBlock and #axisBlock that additionally allow for render types to be specified.
        // Comes in string and resource location variants for the render type,
        // in all combinations with all variants of #logBlock and #axisBlock.
        //logBlockWithRenderType(block, "minecraft:cutout");
        //axisBlockWithRenderType(block, mcLoc("cutout_mipped"));

        // Specifies a horizontally-rotatable block model with a side texture, a front texture, and a top texture.
        // The bottom will use the side texture as well. If you don't need the front or top texture,
        // just pass in the side texture twice. Used by e.g. furnaces and similar blocks.
        //horizontalBlock(block, sideTexture, frontTexture, topTexture);
        // Specifies a horizontally-rotatable block model with a model file that will be rotated as needed.
        // Has an overload that instead of a model file accepts a Function<BlockState, ModelFile>,
        // allowing for different rotations to use different models. Used e.g. by the stonecutter.
        //horizontalBlock(block, exampleModel);
        // Specifies a horizontally-rotatable block model that is attached to a face, e.g. for buttons or levers.
        // Accounts for placing the block on the ground and on the ceiling, and rotates them accordingly.
        // Like #horizontalBlock, has an overload that accepts a Function<BlockState, ModelFile> instead.
        //horizontalFaceBlock(block, exampleModel);
        // Similar to #horizontalBlock, but for blocks that are rotatable in all directions, including up and down.
        // Again, has an overload that accepts a Function<BlockState, ModelFile> instead.
        //directionalBlock(block, exampleModel);
    }
}