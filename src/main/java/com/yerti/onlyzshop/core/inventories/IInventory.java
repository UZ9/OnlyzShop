package com.yerti.onlyzshop.core.inventories;

import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public interface IInventory extends InventoryHolder {

    public void onGUI(Player player, int slot, ItemStack clickedItem);

}
