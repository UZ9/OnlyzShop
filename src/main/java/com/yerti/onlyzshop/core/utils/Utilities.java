package com.yerti.onlyzshop.core.utils;

import com.yerti.onlyzshop.utils.Variables;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

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

                            if (stack.getAmount() == amount) {
                                player.getInventory().remove(stack);
                                return true;
                            }


                            stack.setAmount(stack.getAmount() - amount);
                            return true;
                        }
                    }
                }
            }


        }

        ItemStack stack = new ItemStack(Material.DIAMOND, 1);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName("Bob Diamond");
        List<String> lore = new ArrayList<String>();
        lore.add("This is a diamond.");
        lore.add("Neat!");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DIG_SPEED, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        stack.setItemMeta(meta);




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
