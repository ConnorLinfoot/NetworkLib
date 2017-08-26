package com.connorlinfoot.networklib.Modules.Game;

public enum GameSettings {
    BUILD(false),
    DESTROY(false),
    PVP(true),
    PVE(true),
    HUNGER(false),
    DROP_ITEMS(false),
    PICKUP_ITEMS(false),
    BUCKETS(false),
    DAMAGE(true),
    DROP_ITEMS_ON_DEATH(false),
    CHAT_IN_LOBBY(true),
    CHAT_IN_GAME(true),
    FORCE_RESPAWN(true);
    private boolean value;

    GameSettings(boolean value) {
        this.value = value;
    }

    public void set(boolean value) {
        this.value = value;
    }

    public boolean is() {
        return value;
    }

}
