package com.github.oresascended.menu.screen;

import com.github.oresascended.menu.MyContainerMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;

public class MyContainerScreen extends AbstractContainerScreen<MyContainerMenu> {

    public MyContainerScreen(MyContainerMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageWidth = 176; // Set your screen width
        this.imageHeight = 166; // Set your screen height
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
        // Render your background here
        // e.g., guiGraphics.blit(TEXTURE_LOCATION, this.leftPos, this.topPos, 0, 0, this.imageWidth,
    }

}