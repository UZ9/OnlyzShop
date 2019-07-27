package com.yerti.onlyzshop.core.utils;

import com.yerti.onlyzshop.utils.Variables;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Utilities {

    /**
     * Checks if the player can fit the ItemStack within their inventory.
     */
    public static boolean hasInventorySpace(Player player, ItemStack itemStack) {

        int freeSpace = 0;

        for (int i = 0; i < 36; i++) {
            ItemStack currentItemStack = player.getInventory().getItem(i);

            //Itemstack is Material.AIR
            if (currentItemStack == null) {
                freeSpace += itemStack.getMaxStackSize();
            //Item has same item meta
            } else if (currentItemStack.isSimilar(itemStack)) {
                freeSpace += itemStack.getMaxStackSize() - currentItemStack.getAmount();
            }

        }

        if (freeSpace >= itemStack.getAmount()) return true;

        return false;
    }

    public static boolean canRemoveItems(Player player, Material material, int amount) {
        for (ItemStack stack : player.getInventory().getContents()) {

            if (stack != null) {
                if (!stack.getType().equals(Material.AIR)) {
                    if (stack.getType().equals(material)) {
                        if (stack.getAmount() >= amount) {
                            //Success
                            stack.setAmount(stack.getAmount() - amount);
                            return true;
                        }
                    }
                }
            }


        }

        Variables.printPrefixMessage(ChatColor.RED + "Not enough diamonds!", player);
        player.playSound(player.getLocation(), Sound.ANVIL_LAND, 1, 1);
        return false;
    }

    public static boolean hasOpenSlots(Player player, int slots) {

        int freeSlots = 0;

        for (int i = 0; i < 36; i++) {
            ItemStack currentItemStack = player.getInventory().getItem(i);

            if (currentItemStack == null) {
                freeSlots++;
            }
        }

        return freeSlots >= slots;
    }






}
