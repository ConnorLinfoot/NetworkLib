package com.connorlinfoot.networklib.Listeners;

import com.connorlinfoot.networklib.Events.RealPlayerMoveEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		if (event.getFrom().getBlockX() != event.getTo().getBlockX() || event.getFrom().getBlockZ() != event.getTo().getBlockZ()) {
			RealPlayerMoveEvent realPlayerMoveEvent = new RealPlayerMoveEvent(event);
			Bukkit.getPluginManager().callEvent(realPlayerMoveEvent);
			if (realPlayerMoveEvent.isCanceled())
				event.setTo(event.getFrom());
		}
	}

}
