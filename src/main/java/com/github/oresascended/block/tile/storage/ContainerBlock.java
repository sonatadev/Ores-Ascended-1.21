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
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
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
    public InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        // This method handles interaction without an item
        if (!pLevel.isClientSide) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof MyContainerEntity) {
                // Open the custom menu
                pPlayer.openMenu((MenuProvider) blockEntity);
            }
        }
        return InteractionResult.SUCCESS; // Indicate the interaction was successful
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        // This method handles interaction while holding an item
        if (!pLevel.isClientSide) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof MyContainerEntity) {
                // Open the custom menu
                pPlayer.openMenu((MenuProvider) blockEntity);
                // Consume the item if needed, otherwise return PASS
                return ItemInteractionResult.CONSUME; // Indicate the item was consumed
            }
        }
        return ItemInteractionResult.FAIL; // Indicate that the interaction did not consume the item
    }
}
