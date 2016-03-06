package com.connorlinfoot.networklib.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerMoveEvent;

public class RealPlayerMoveEvent extends Event {
	private static final HandlerList handlers = new HandlerList();
	private final PlayerMoveEvent event;
	private boolean canceled = false;

	public RealPlayerMoveEvent(PlayerMoveEvent event) {
		this.event = event;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	public PlayerMoveEvent getEvent() {
		return event;
	}

	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}

	public boolean isCanceled() {
		return this.canceled;
	}

	public Player getPlayer() {
		return event.getPlayer();
	}

}
