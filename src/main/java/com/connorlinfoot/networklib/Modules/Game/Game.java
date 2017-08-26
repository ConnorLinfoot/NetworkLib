package com.connorlinfoot.networklib.Modules.Game;

import com.connorlinfoot.networklib.API.GamePlayer;
import com.connorlinfoot.networklib.API.NetworkPlayer;
import com.connorlinfoot.networklib.Modules.Module;
import com.connorlinfoot.networklib.NetworkAPI;
import com.connorlinfoot.networklib.NetworkLib;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Game extends Module {
    protected GameState gameState = GameState.WAITING;
    protected Integer minPlayers = 2;
    protected Integer maxPlayers = 2;
    protected int timer = 60;
    protected int defaultTimer = 60;
    protected boolean gamePrepared = false;

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
        Bukkit.getScheduler().runTaskTimer(NetworkLib.getLib(), new Runnable() {
            @Override
            public void run() {
                doTimer();
            }
        }, 20L, 20L);
    }

    private void doTimer() {
        if (getGameState() == GameState.INGAME || getGameState() == GameState.FINISHED)
            return;

        if (Bukkit.getOnlinePlayers().size() < getMinPlayers()) {
            timer = defaultTimer;
            return;
        }

        if (getGameState() == GameState.STARTING)
            setGameState(GameState.WAITING);

        if (timer == 0) {
            startGame();
        } else if (timer <= 1) {
            for (GamePlayer player : NetworkLib.getAPI().getOnlineGamePlayers()) {
                player.sendTitle(ChatColor.GOLD + "Game Starting In", ChatColor.RED.toString() + timer, 0, 40, 0);
                player.getPlayer().setLevel(timer);
                player.getPlayer().setExp(0);
            }
        } else if (timer <= 5) {
            for (GamePlayer player : NetworkLib.getAPI().getOnlineGamePlayers()) {
                player.sendTitle(ChatColor.GOLD + "Game Starting In", ChatColor.YELLOW.toString() + timer, 0, 40, 0);
                player.getPlayer().setLevel(timer);
                player.getPlayer().setExp(0);
            }
        } else if (timer <= 10) {
            for (GamePlayer player : NetworkLib.getAPI().getOnlineGamePlayers()) {
                player.sendTitle(ChatColor.GOLD + "Game Starting In", ChatColor.GREEN.toString() + timer, 0, 40, 0);
                player.getPlayer().setLevel(timer);
                player.getPlayer().setExp(0);
            }
            if (timer == 10) {
                prepareGame();
            }
        } else if (timer <= 30) {
            for (GamePlayer player : NetworkLib.getAPI().getOnlineGamePlayers()) {
                player.sendActionBar(ChatColor.GOLD + "Starting in " + timer + "...");
                player.getPlayer().setLevel(timer);
                player.getPlayer().setExp(0);
            }
        } else {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.setLevel(timer);
                player.setExp(0);
            }
        }

        timer--;
    }

    public void prepareGame() {
        /** This method is usually best for map loading or anything that may take a little while... It runs 10 seconds before start */
        if (isGamePrepared()) // Stop game preparation from ever running more than once
            return;
        setGamePrepared(true);
    }

    public void startGame() {
        if (Bukkit.getOnlinePlayers().size() == 0) Bukkit.shutdown();
        if (getGameState() == GameState.INGAME) return;
        setGameState(GameState.INGAME);

        // Sort inventory's and kits etc.
        for (GamePlayer player : NetworkLib.getAPI().getOnlineGamePlayers()) {
            player.getPlayer().setMaxHealth(20);
            player.getPlayer().setHealth(20);
            player.getPlayer().setSaturation(20);
            player.getPlayer().setFoodLevel(20);
            player.getPlayer().closeInventory();
            player.getPlayer().closeInventory();
            player.getPlayer().getInventory().clear();
            player.getPlayer().setLevel(0);
            player.getPlayer().setExp(0);
            player.getPlayer().setGameMode(GameMode.SURVIVAL); // TODO Use an option for this?
//            addStats(covePlayer.getPlayer(), StatType.PLAY, 1, null); // TODO stat system
//            if (!getDescription().equals("")) { // TODO Description support
//                covePlayer.sendCentredMessage("");
//                covePlayer.sendCentredMessage(getDescription());
//                covePlayer.sendCentredMessage("");
//            }
        }

//        if (getGameSettings().isGiveKitsOnStart()) // TODO Kit system
//            giveAllPlayersKits();
//        doAllScoreboards(); // TODO Scoreboards
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

    public void setGamePrepared(boolean gamePrepared) {
        this.gamePrepared = gamePrepared;
    }

    public boolean isGamePrepared() {
        return gamePrepared;
    }

    public NetworkAPI getNetworkAPI() {
        return NetworkLib.getAPI();
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
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
