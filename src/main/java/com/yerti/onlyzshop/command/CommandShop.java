package com.yerti.onlyzshop.command;


import com.yerti.onlyzshop.core.commands.CustomCommand;
import com.yerti.onlyzshop.gui.GUIShop;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandShop extends CustomCommand {


    public CommandShop(String command) {
        super(command, null);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        GUIShop shop = new GUIShop();

        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.openInventory(shop.getInventory());
        }

        return false;
    }
}
