package com.yerti.onlyzshop;


import com.yerti.onlyzshop.command.CommandShop;
import com.yerti.onlyzshop.core.commands.CustomCommand;
import com.yerti.onlyzshop.core.inventories.InventoryHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class OnlyzShop extends JavaPlugin {

    public void onEnable() {

        CustomCommand commandShop = new CommandShop("shop");
        commandShop.initCommand();

        Bukkit.getServer().getPluginManager().registerEvents(new InventoryHandler(), this);


    }



}
