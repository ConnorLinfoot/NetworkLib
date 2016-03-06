package com.connorlinfoot.networklib.Game;

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
		if ((game.getGameState() != GameState.WAITING && !game.getGameSettings().isChatInLobby()) || !game.getGameSettings().isChatInGame()) {
			event.setCancelled(true);
		}
	}

	@EventHandler(priority = EventPriority.LOW)
	public void onRealPlayerMove(RealPlayerMoveEvent event) {
		if (game.getGameSettings().isFrozen())
			event.setCanceled(true);
	}

	@EventHandler(priority = EventPriority.LOW)
	public void onHungerChange(FoodLevelChangeEvent event) {
		if (game.getGameState() != GameState.INGAME || !game.getGameSettings().isHunger())
			event.setCancelled(true);
	}

	@EventHandler(priority = EventPriority.LOW)
	public void onItemDrop(PlayerDropItemEvent event) {
		if (game.getGameState() != GameState.INGAME || !game.getGameSettings().isDropItems())
			event.setCancelled(true);
	}

	@EventHandler(priority = EventPriority.LOW)
	public void onItemPickup(PlayerPickupItemEvent event) {
		if (game.getGameState() != GameState.INGAME || !game.getGameSettings().isPickupItems())
			event.setCancelled(true);
	}

	@EventHandler(priority = EventPriority.LOW)
	public void onBlockBreak(BlockBreakEvent event) {
		if (game.getGameState() != GameState.INGAME || !game.getGameSettings().isDestroy())
			event.setCancelled(true);
	}

	@EventHandler(priority = EventPriority.LOW)
	public void onBlockPlace(BlockPlaceEvent event) {
		if (game.getGameState() != GameState.INGAME || !game.getGameSettings().isBuild())
			event.setCancelled(true);
	}

	@EventHandler(priority = EventPriority.LOW)
	public void onBucketUse(PlayerInteractEvent event) {
		if (game.getGameState() == GameState.INGAME && !game.getGameSettings().isBuckets() && event.getItem() != null && event.getItem().getType().toString().toUpperCase().contains("BUCKET"))
			event.setCancelled(true);
	}

}
