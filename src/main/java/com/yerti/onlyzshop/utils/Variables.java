package com.yerti.onlyzshop.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Variables {
    public static final String PREFIX = "" + ChatColor.GOLD + ChatColor.BOLD + "OnlyzMc";

    public static void printPrefixMessage(String message, Player player) {
        player.sendMessage(Variables.PREFIX + ChatColor.GRAY + " » " + ChatColor.YELLOW + message);
    }
}
