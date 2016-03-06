package com.connorlinfoot.networklib;

import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class NetworkLib extends JavaPlugin {
    private static NetworkAPI networkAPI;

    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        networkAPI = new NetworkAPI(this);
        ConsoleCommandSender console = getServer().getConsoleSender();
        console.sendMessage(ChatColor.GREEN + "Network Lib Version " + getDescription().getVersion() + " has been enabled" );
    }

    public void onDisable() {

    }

    public static NetworkAPI getAPI() {
        return networkAPI;
    }

}
