package com.connorlinfoot.networklib.API;

import java.util.UUID;

public class GamePlayer extends NetworkPlayer {
    private boolean spectator = false;

    public GamePlayer(UUID uuid) {
        super(uuid);
    }

    public void setSpectator(boolean spectator) {
        this.spectator = spectator;
    }

    public boolean isSpectator() {
        return spectator;
    }

}
