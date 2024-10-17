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
        for (int i = 0; i < containerEntity.getContainerSize(); i++) {
            this.addSlot(new Slot(containerEntity, i, 44 + (i % 9) * 18, 20 + (i / 9) * 18));
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
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        return null;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return false;
    }
}