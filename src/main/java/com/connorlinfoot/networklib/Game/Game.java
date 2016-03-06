package com.connorlinfoot.networklib.Game;

import com.connorlinfoot.networklib.NetworkAPI;
import com.connorlinfoot.networklib.NetworkLib;
import org.bukkit.Bukkit;

public class Game {
	private NetworkAPI networkAPI;
	private String gameTitle;
	private String gameName;
	private GameSettings gameSettings;
	private GameState gameState = GameState.WAITING;

	public Game(String gameTitle, String gameName, GameSettings gameSettings) {
		this.networkAPI = NetworkLib.getAPI();
		this.gameTitle = gameTitle;
		this.gameName = gameName;
		this.gameSettings = gameSettings;
		Bukkit.getPluginManager().registerEvents(new GameListener(this), NetworkLib.getLib());
		startTimer();
	}

	public Game(String gameTitle, String gameName, GameSettings gameSettings, boolean startTimer) {
		this.networkAPI = NetworkLib.getAPI();
		this.gameTitle = gameTitle;
		this.gameName = gameName;
		this.gameSettings = gameSettings;
		Bukkit.getPluginManager().registerEvents(new GameListener(this), NetworkLib.getLib());
		if (startTimer) startTimer();
	}

	public void startTimer() {

	}

	public void prepareGame() {

	}

	public void startGame() {

	}

	public void endGame() {

	}

	public void onDisable() {

	}

	public GameSettings getGameSettings() {
		return gameSettings;
	}

	public GameState getGameState() {
		return gameState;
	}

}
