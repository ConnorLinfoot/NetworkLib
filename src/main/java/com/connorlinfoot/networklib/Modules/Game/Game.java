package com.connorlinfoot.networklib.Modules.Game;

import com.connorlinfoot.networklib.API.GamePlayer;
import com.connorlinfoot.networklib.Modules.Module;
import com.connorlinfoot.networklib.NetworkAPI;
import com.connorlinfoot.networklib.NetworkLib;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Game extends Module {
    private GameState gameState = GameState.WAITING;
    private Integer minPlayers = 2;
    private Integer maxPlayers = 2;

    public Game(String name, String slug) {
        this(name, slug, true);
    }

    public Game(String name, String slug, boolean registerListener) {
        super(name, slug);
        if (registerListener)
            Bukkit.getPluginManager().registerEvents(new GameListener(this), NetworkLib.getLib());
    }

    public void onEnable() {
        startTimer();
    }

    public void onDisable() {

    }

    public void startTimer() {

    }

    public void prepareGame() {

    }

    public void startGame() {

    }

    public void endGame(GamePlayer gamePlayer) {
        endGame(gamePlayer.getPlayer());
    }

    public void endGame(Player player) {
        endGame(player.getName());
    }

    public void endGame() {
        endGame((String) null);
    }

    public void endGame(String winner) {

    }

    public NetworkAPI getNetworkAPI() {
        return NetworkLib.getAPI();
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setMinPlayers(Integer minPlayers) {
        this.minPlayers = minPlayers;
    }

    public Integer getMinPlayers() {
        return minPlayers;
    }

    public void setMaxPlayers(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public ArrayList<GamePlayer> getAlivePlayers() {
        ArrayList<GamePlayer> players = new ArrayList<>();
        for (GamePlayer gamePlayer : NetworkLib.getAPI().getOnlineGamePlayers()) {
            if (!gamePlayer.isSpectator())
                players.add(gamePlayer);
        }
        return players;
    }

}
