package com.github.oresascended.util;

import com.github.oresascended.block.tile.BlockEntityInit;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class GroupEntities {
    public static List<DeferredRegister<? extends BlockEntityType<?>>> entityRegisters = new ArrayList<>();

    public static void initializeRegisters(){
        BlockEntityInit.register();
    }

    public static void addBlockEntityRegister(DeferredRegister<? extends BlockEntityType<?>> blockEntityRegister){
        entityRegisters.add(blockEntityRegister);
    }
}
