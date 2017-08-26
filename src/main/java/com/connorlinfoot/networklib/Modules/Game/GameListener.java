package com.connorlinfoot.networklib.Modules.Game;

import com.connorlinfoot.networklib.Events.RealPlayerMoveEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class GameListener implements Listener {
    private Game game;

    public GameListener(Game game) {
        this.game = game;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerChatHigh(AsyncPlayerChatEvent event) {
        if ((game.getGameState() != GameState.WAITING && !GameSettings.CHAT_IN_LOBBY.is()) || !GameSettings.CHAT_IN_GAME.is()) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onRealPlayerMove(RealPlayerMoveEvent event) {
//		if (game.getGameSettings().isFrozen()) // TODO
//			event.setCanceled(true);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onHungerChange(FoodLevelChangeEvent event) {
        if (game.getGameState() != GameState.INGAME || !GameSettings.HUNGER.is())
            event.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onItemDrop(PlayerDropItemEvent event) {
        if (game.getGameState() != GameState.INGAME || !GameSettings.DROP_ITEMS.is())
            event.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onItemPickup(PlayerPickupItemEvent event) {
        if (game.getGameState() != GameState.INGAME || !GameSettings.PICKUP_ITEMS.is())
            event.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onBlockBreak(BlockBreakEvent event) {
        if (game.getGameState() != GameState.INGAME || !GameSettings.DESTROY.is())
            event.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onBlockPlace(BlockPlaceEvent event) {
        if (game.getGameState() != GameState.INGAME || !GameSettings.BUILD.is())
            event.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onBucketUse(PlayerInteractEvent event) {
        if (game.getGameState() == GameState.INGAME && !GameSettings.BUCKETS.is() && event.getItem() != null && event.getItem().getType().toString().toUpperCase().contains("BUCKET"))
            event.setCancelled(true);
    }

}
