package com.connorlinfoot.networklib;

import com.connorlinfoot.networklib.Listeners.PlayerMove;
import com.connorlinfoot.networklib.Modules.Game.GameSettings;
import org.bukkit.plugin.java.JavaPlugin;

public class NetworkLib extends JavaPlugin {
    private static NetworkLib networkLib;
    private static NetworkAPI networkAPI;

    public void onEnable() {
        networkLib = this;
        getConfig().options().copyDefaults(true);
        saveConfig();
        networkAPI = new NetworkAPI();
        registerListeners();

        networkAPI.enableGames();

        System.out.println("HUNGER is currently: " + GameSettings.HUNGER.is());
        System.out.println("Changing HUNGER to true");
        GameSettings.HUNGER.set(true);
        System.out.println("HUNGER is currently: " + GameSettings.HUNGER.is());

        getLogger().info("Successfully enabled NetworkLib v" + getDescription().getVersion());
    }

    public void onDisable() {
        networkAPI.disableGames();
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
