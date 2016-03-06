package com.connorlinfoot.networklib.Game;

import com.connorlinfoot.networklib.NetworkAPI;

public class Game {
    private NetworkAPI networkAPI;
    private String gameName;

    public Game(NetworkAPI networkAPI, String gameName) {
        this.networkAPI = networkAPI;
        this.gameName = gameName;
        startTimer();
    }

    public Game(NetworkAPI networkAPI, String gameName, boolean startTimer) {
        this.networkAPI = networkAPI;
        this.gameName = gameName;
        if( startTimer ) startTimer();
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

}
