package com.yerti.onlyzshop.gui;

import com.yerti.onlyzshop.core.inventories.CustomInventory;
import com.yerti.onlyzshop.core.inventories.IInventory;
import com.yerti.onlyzshop.core.items.CustomItemStack;
import com.yerti.onlyzshop.core.items.ItemStackUtils;
import com.yerti.onlyzshop.core.utils.Utilities;
import com.yerti.onlyzshop.utils.Variables;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionType;

public class GUIDiamondShop implements IInventory {


    public Inventory getInventory() {
        CustomInventory inventory = new CustomInventory(this, 54, "Diamond Shop", new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7));




        inventory.getInventory().setItem(10, new CustomItemStack(Material.GOLDEN_APPLE, 1, ChatColor.YELLOW + "Golden Apple", false, ChatColor.AQUA + "Diamonds: 5"));
        inventory.getInventory().setItem(14, ItemStackUtils.getPotionItemStack(PotionType.SPEED, 1, false, ChatColor.YELLOW + "Speed 1", ChatColor.AQUA + "Diamonds: 15"));
        inventory.getInventory().setItem(16, ItemStackUtils.getPotionItemStack(PotionType.SPEED, 2, false, ChatColor.YELLOW + "Speed 2", ChatColor.AQUA + "Diamonds: 20"));
        inventory.getInventory().setItem(12, new CustomItemStack(Material.FISHING_ROD, 1, ChatColor.YELLOW + "Fishing Rod", false, ChatColor.AQUA + "Diamonds: 10"));





        inventory.createBackground();

        return inventory.getInventory();
    }

    public void onGUI(Player player, int slot, ItemStack clickedItem) {
        if (clickedItem.getType() != Material.STAINED_GLASS_PANE) {
            if (clickedItem.getItemMeta().getLore() != null) {
                String loreNumber = clickedItem.getItemMeta().getLore().get(0).substring((ChatColor.AQUA + "Diamonds:").length()).trim();
                if (Integer.valueOf(loreNumber) != 0) {
                    int cost = Integer.valueOf(loreNumber);
                    //Check if player has specified amount of diamonds
                    ItemStack diamondStack = new ItemStack(Material.DIAMOND, cost);
                    if (Utilities.hasInventorySpace(player, clickedItem)) {
                        if (Utilities.canRemoveItems(player, diamondStack.getType(), diamondStack.getAmount())) {
                            ItemStack clonedItemStack = clickedItem.clone();
                            ItemMeta meta = clonedItemStack.getItemMeta();
                            meta.setLore(null);
                            clonedItemStack.setItemMeta(meta);
                            player.getInventory().addItem(clonedItemStack);
                            player.updateInventory();
                            player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
                        }
                    } else {
                        Variables.printPrefixMessage(ChatColor.RED + "Your inventory is full!", player);
                        player.playSound(player.getLocation(), Sound.ANVIL_LAND, 1, 1);
                    }

                }
            }

        }
    }


}
