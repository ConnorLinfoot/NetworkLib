package com.connorlinfoot.networklib.Modules.Game.Templates;

import com.connorlinfoot.networklib.API.GamePlayer;
import com.connorlinfoot.networklib.Modules.Game.Game;
import com.connorlinfoot.networklib.Modules.Game.GameListener;
import com.connorlinfoot.networklib.Modules.Game.GameState;
import com.connorlinfoot.networklib.NetworkLib;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

public class LastManStanding extends Game {

    public LastManStanding(String name, String slug) {
        super(name, slug, false);
        Bukkit.getPluginManager().registerEvents(new GameListener(this) {
            @EventHandler
            public void onPlayerDeath(PlayerDeathEvent event) {
                if (getGameState() == GameState.INGAME) {
                    GamePlayer gamePlayer = NetworkLib.getAPI().getGamePlayer(event.getEntity());
                    gamePlayer.setSpectator(true);
                    checkIfLastManStanding();
                }
            }
        }, NetworkLib.getLib());
    }

    public void checkIfLastManStanding() {
        if (getGameState() == GameState.INGAME && getAlivePlayers().size() == 1) {
            endGame(getAlivePlayers().get(0));
        } else if (getGameState() == GameState.INGAME && getAlivePlayers().size() == 0) {
            endGame();
        }
    }

}
