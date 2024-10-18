package com.github.oresascended.menu;

import com.github.oresascended.block.tile.storage.MyContainerEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class MyContainerMenu extends AbstractContainerMenu {
    private final MyContainerEntity containerEntity;

    public MyContainerMenu(int id, Inventory playerInventory, MyContainerEntity containerEntity) {
        super(MenuInit.MY_CONTAINER_MENU_TYPE.get(), id);
        this.containerEntity = containerEntity; // Ensure this is initialized properly

        // Add slots for the container
        for (int i = 0; i < 27; i++) { // Loop for 27 slots
            int slotX = 8 + (i % 9) * 18; // X position for the slots
            int slotY = 18 + (i / 9) * 18; // Y position for the slots
            this.addSlot(new Slot(containerEntity, i, slotX, slotY));
        }

        // Add player inventory slots
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 9; k++) {
                this.addSlot(new Slot(playerInventory, k + j * 9 + 9, 8 + k * 18, 84 + j * 18));
            }
        }

        // Add the hotbar slots
        for (int l = 0; l < 9; l++) {
            this.addSlot(new Slot(playerInventory, l, 8 + l * 18, 142));
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        Slot slot = this.slots.get(index);
        if (slot.hasItem()) {
            ItemStack itemStack = slot.getItem();
            ItemStack itemStackCopy = itemStack.copy();

            // Check if the item is in the container's slots
            if (index < containerEntity.getContainerSize()) {
                // Try to move it to the player's inventory
                if (!this.moveItemStackTo(itemStack, containerEntity.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY; // If it couldn't be moved, return empty
                }
            } else {
                // Try to move it to the container
                if (!this.moveItemStackTo(itemStack, 0, containerEntity.getContainerSize(), false)) {
                    return ItemStack.EMPTY; // If it couldn't be moved, return empty
                }
            }

            slot.set(itemStack.isEmpty() ? ItemStack.EMPTY : itemStack);
            return itemStackCopy; // Return the item that was moved
        }
        return ItemStack.EMPTY; // If the slot was empty
    }



    @Override
    public boolean stillValid(Player player) {
        return containerEntity.isWithinDistance(player);
    }
}