package com.github.oresascended.block.tile.storage;

import com.github.oresascended.block.tile.BlockEntityInit;
import com.github.oresascended.menu.MyContainerMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;
import net.minecraft.world.InteractionHand;

public class ContainerBlock extends Block implements EntityBlock {
    public ContainerBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MyContainerEntity(pos, state);
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        openContainerMenu(level, pos, player);
        return InteractionResult.SUCCESS; // Indicate interaction was successful
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        openContainerMenu(level, pos, player);
        return ItemInteractionResult.SUCCESS; // Indicate interaction was successful and item was consumed
    }

    private void openContainerMenu(Level level, BlockPos pos, Player player) {
        if (!level.isClientSide) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof MyContainerEntity) {
                // Open the custom menu using the block entity as a MenuProvider
                player.openMenu((MenuProvider) blockEntity);
            }
        }
    }
}
