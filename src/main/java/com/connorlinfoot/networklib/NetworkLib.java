package com.connorlinfoot.networklib;

import com.connorlinfoot.networklib.Listeners.PlayerMove;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class NetworkLib extends JavaPlugin {
	private static NetworkLib networkLib;
	private static NetworkAPI networkAPI;

	public void onEnable() {
		networkLib = this;
		getConfig().options().copyDefaults(true);
		saveConfig();
		networkAPI = new NetworkAPI(this);
		registerListeners();

		ConsoleCommandSender console = getServer().getConsoleSender();
		console.sendMessage(ChatColor.GREEN + "Network Lib Version " + getDescription().getVersion() + " has been enabled");
	}

	public void onDisable() {

	}

	private void registerListeners() {
		getServer().getPluginManager().registerEvents(new PlayerMove(), this);
	}

	public static NetworkAPI getAPI() {
		return networkAPI;
	}

	public static NetworkLib getLib() {
		return networkLib;
	}

}
