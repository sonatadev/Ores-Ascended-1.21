package com.github.oresascended.block.tile.storage;

import com.github.oresascended.block.tile.BlockEntityInit;
import com.github.oresascended.menu.MyContainerMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class MyContainerEntity extends BaseContainerBlockEntity implements MenuProvider {
    // Assuming that you want a fixed size for the container
    private static final int CONTAINER_SIZE = 27; // Change this to your desired size
    private final NonNullList<ItemStack> items; // Make items a member variable

    public MyContainerEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.MY_CONTAINER_ENTITY.get(), pos, state);
        this.items = NonNullList.withSize(CONTAINER_SIZE, ItemStack.EMPTY); // Initialize items here
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("oresascended.storage_container");
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return items; // Return the initialized items list
    }

    @Override
    protected void setItems(NonNullList<ItemStack> pItems) {
        for (int i = 0; i < pItems.size(); i++) {
            setItem(i, pItems.get(i)); // Store each item in the container
        }
    }

    @Override
    protected AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory) {
        return new MyContainerMenu(pContainerId, pInventory, this);
    }

    @Override
    public int getContainerSize() {
        return CONTAINER_SIZE; // Return the fixed size of the container
    }

    public boolean isWithinDistance(Player player) {
        return player.distanceToSqr(this.getBlockPos().getX(),
                this.getBlockPos().getY(),
                this.getBlockPos().getZ()) <= 8 * 8; // 8 blocks squared
    }
}
