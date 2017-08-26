package com.connorlinfoot.networklib;

import com.connorlinfoot.networklib.API.GamePlayer;
import com.connorlinfoot.networklib.API.NetworkPlayer;
import com.connorlinfoot.networklib.API.NetworkServer;
import com.connorlinfoot.networklib.API.ServerType;
import com.connorlinfoot.networklib.Modules.Game.Game;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class NetworkAPI {
    private final NetworkServer networkServer;
    private HashMap<UUID, NetworkPlayer> players = new HashMap<UUID, NetworkPlayer>();
    public ArrayList<Game> games = new ArrayList<Game>();

    public NetworkAPI() {
        this.networkServer = new NetworkServer();
    }

    public NetworkPlayer getNetworkPlayer(Player player) {
        return getNetworkPlayer(player.getUniqueId());
    }

    public NetworkPlayer getNetworkPlayer(UUID uuid) {
        if (!players.containsKey(uuid)) {
            if (getNetworkServer().getServerType() == ServerType.GAME) {
                players.put(uuid, new GamePlayer(uuid));
            } else {
                players.put(uuid, new NetworkPlayer(uuid));
            }
        }
        return players.get(uuid);
    }

    public GamePlayer getGamePlayer(Player player) {
        return getGamePlayer(player.getUniqueId());
    }

    public GamePlayer getGamePlayer(UUID uuid) {
        if (players.containsKey(uuid) && players.get(uuid) instanceof GamePlayer) {
            return (GamePlayer) players.get(uuid);
        }
        players.put(uuid, new GamePlayer(uuid));
        return (GamePlayer) players.get(uuid);
    }

    public void removePlayer(Player player) {
        removePlayer(player.getUniqueId());
    }

    public void removePlayer(UUID uuid) {
        if (players.containsKey(uuid))
            players.remove(uuid);
    }

    public ArrayList<NetworkPlayer> getOnlineNetworkPlayers() {
        ArrayList<NetworkPlayer> covePlayers = new ArrayList<>();
        for (Player player : Bukkit.getOnlinePlayers())
            covePlayers.add(getNetworkPlayer(player));
        return covePlayers;
    }

    public ArrayList<GamePlayer> getOnlineGamePlayers() {
        ArrayList<GamePlayer> gamePlayers = new ArrayList<>();
        for (Player player : Bukkit.getOnlinePlayers())
            gamePlayers.add(getGamePlayer(player));
        return gamePlayers;
    }

    public void registerGame(Game game) {
        if (game == null)
            return;
        games.add(game);
    }

    public void enableGames() {
        for (Game game : games) {
            game.onEnable();
        }
    }

    public void disableGames() {
        for (Game game : games) {
            game.onDisable();
        }
    }

    public NetworkServer getNetworkServer() {
        return networkServer;
    }

}
