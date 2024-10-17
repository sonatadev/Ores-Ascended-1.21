package com.github.oresascended.block.tile;

import com.github.oresascended.OresAscended;
import com.github.oresascended.block.BlockInit;
import com.github.oresascended.block.tile.storage.MyContainerEntity;
import com.github.oresascended.util.GroupEntities;
import com.mojang.datafixers.Typed;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockEntityInit {
    private static final String MODID = OresAscended.MODID;

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MODID);

    public static final Supplier<BlockEntityType<MyContainerEntity>> MY_CONTAINER_ENTITY = BLOCK_ENTITY_TYPES.register(
            "my_block_entity",
            // The block entity type, created using a builder.
            () -> BlockEntityType.Builder.of(
                            // The supplier to use for constructing the block entity instances.
                            MyContainerEntity::new,
                            // A vararg of blocks that can have this block entity.
                            // This assumes the existence of the referenced blocks as DeferredBlock<Block>s.
                            BlockInit.CONTAINER_BLOCK.get(), BlockInit.CONTAINER_BLOCK.get())
                    // Build using null; vanilla does some datafixer shenanigans with the parameter that we don't need.
                    .build(null)
    );

    public static void register(){
        GroupEntities.addBlockEntityRegister(BLOCK_ENTITY_TYPES);
    }

}
