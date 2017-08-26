package com.connorlinfoot.networklib.Modules;

import com.connorlinfoot.networklib.Modules.Game.GameSettingsOld;
import com.connorlinfoot.networklib.Modules.Game.GameState;

public abstract class Module {
    private String name;
    private String slug;
    private GameSettingsOld gameSettings;
    private GameState gameState = GameState.WAITING;

    public Module(String name, String slug) {
        this.name = name;
        this.slug = slug;
    }

    public abstract void onEnable();

    public abstract void onDisable();

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

}
