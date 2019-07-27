package com.yerti.onlyzshop.gui;


import com.yerti.onlyzshop.core.inventories.CustomInventory;
import com.yerti.onlyzshop.core.inventories.IInventory;
import com.yerti.onlyzshop.core.items.CustomItemStack;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GUIShop implements IInventory {


    public Inventory getInventory() {

        CustomInventory inventory = new CustomInventory(this, 27, "Onlyz Shop", new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7));
        //11, 15

        //Set items
        inventory.getInventory().setItem(11, new CustomItemStack(Material.DIAMOND, 1, ChatColor.BLUE + "Diamond Shop", false));
        inventory.getInventory().setItem(15, new CustomItemStack(Material.CHEST, 1, ChatColor.RED + "Coming Soon", false));

        inventory.createBackground();

        return inventory.getInventory();
    }

    public void onGUI(Player player, int slot, ItemStack clickedItem) {

        if (slot == 11) {
            //Open diamond shop GUI
            GUIDiamondShop shop = new GUIDiamondShop();
            player.openInventory(shop.getInventory());
        }

        if (slot == 15) {
            //Kept blank: Coming soon
        }


    }


}
