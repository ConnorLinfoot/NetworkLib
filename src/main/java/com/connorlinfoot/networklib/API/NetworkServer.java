package com.connorlinfoot.networklib.API;

import com.connorlinfoot.networklib.Modules.Game.Game;
import com.connorlinfoot.networklib.Modules.Module;

public class NetworkServer {
    private ServerType serverType = ServerType.OTHER;
    private Module module = null;

    public NetworkServer() {

    }

    public void switchModule(Module module) {
        disableModule();
        this.module = module;
        enableModule();
    }

    private void enableModule() {
        if (getModule() == null) {
            return;
        }
        if (getModule() instanceof Game) {
            this.serverType = ServerType.GAME;
        } else {
            this.serverType = ServerType.OTHER;
        }
        getModule().onEnable();
    }

    private void disableModule() {
        if (getModule() == null) {
            return;
        }
        getModule().onDisable();
        this.module = null;
    }

    public Module getModule() {
        return module;
    }

    public ServerType getServerType() {
        return serverType;
    }

}
