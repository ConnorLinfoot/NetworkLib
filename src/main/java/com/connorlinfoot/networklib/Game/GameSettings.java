package com.connorlinfoot.networklib.Game;

import org.bukkit.GameMode;
import org.bukkit.Location;

public class GameSettings {
	private boolean build = false;
	private boolean destroy = false;
	private boolean pvp = true;
	private boolean pve = true;
	private boolean hunger = false;
	private boolean dropItems = false;
	private boolean pickupItems = false;
	private boolean buckets = false;
	private boolean stats = true;
	private boolean frozen = false;
	private boolean damage = true;
	private boolean dropItemsOnDeath = false;
	private boolean chatInLobby = true;
	private boolean chatInGame = true;
	private boolean deadBodies = false;
	private boolean forceRespawn = true;
	private boolean autoPopulateChests = false;
	private boolean includeKitSelector = true;
	private boolean giveKitsOnStart = true;
	private Location gameLobby = null;
	private GameMode defaultGameMode = GameMode.ADVENTURE;

	public GameSettings() {
	}

	public void setBuild(boolean build) {
		this.build = build;
	}

	public boolean isBuild() {
		return build;
	}

	public void setDestroy(boolean destroy) {
		this.destroy = destroy;
	}

	public boolean isDestroy() {
		return destroy;
	}

	public void setPvp(boolean pvp) {
		this.pvp = pvp;
	}

	public boolean isPvp() {
		return pvp;
	}

	public void setPve(boolean pve) {
		this.pve = pve;
	}

	public boolean isPve() {
		return pve;
	}

	public void setHunger(boolean hunger) {
		this.hunger = hunger;
	}

	public boolean isHunger() {
		return hunger;
	}

	public void setDropItems(boolean dropItems) {
		this.dropItems = dropItems;
	}

	public boolean isDropItems() {
		return dropItems;
	}

	public void setPickupItems(boolean pickupItems) {
		this.pickupItems = pickupItems;
	}

	public boolean isPickupItems() {
		return pickupItems;
	}

	public void setBuckets(boolean buckets) {
		this.buckets = buckets;
	}

	public boolean isBuckets() {
		return buckets;
	}

	public void setStats(boolean stats) {
		this.stats = stats;
	}

	public boolean isStats() {
		return stats;
	}

	public void setFrozen(boolean frozen) {
		this.frozen = frozen;
	}

	public boolean isFrozen() {
		return frozen;
	}

	public void setDamage(boolean damage) {
		this.damage = damage;
	}

	public boolean isDamage() {
		return damage;
	}

	public void setDropItemsOnDeath(boolean dropItemsOnDeath) {
		this.dropItemsOnDeath = dropItemsOnDeath;
	}

	public boolean isDropItemsOnDeath() {
		return dropItemsOnDeath;
	}

	public void setChatInLobby(boolean chatInLobby) {
		this.chatInLobby = chatInLobby;
	}

	public boolean isChatInLobby() {
		return chatInLobby;
	}

	public void setChatInGame(boolean chatInGame) {
		this.chatInGame = chatInGame;
	}

	public boolean isChatInGame() {
		return chatInGame;
	}

	public void setDeadBodies(boolean deadBodies) {
		this.deadBodies = deadBodies;
	}

	public boolean isDeadBodies() {
		return deadBodies;
	}

	public void setForceRespawn(boolean forceRespawn) {
		this.forceRespawn = forceRespawn;
	}

	public boolean isForceRespawn() {
		return forceRespawn;
	}

	public void setAutoPopulateChests(boolean autoPopulateChests) {
		this.autoPopulateChests = autoPopulateChests;
	}

	public boolean isAutoPopulateChests() {
		return autoPopulateChests;
	}

	public void setIncludeKitSelector(boolean includeKitSelector) {
		this.includeKitSelector = includeKitSelector;
	}

	public boolean isIncludeKitSelector() {
		return includeKitSelector;
	}

	public void setGiveKitsOnStart(boolean giveKitsOnStart) {
		this.giveKitsOnStart = giveKitsOnStart;
	}

	public boolean isGiveKitsOnStart() {
		return giveKitsOnStart;
	}

	public void setGameLobby(Location gameLobby) {
		this.gameLobby = gameLobby;
	}

	public Location getGameLobby() {
		return gameLobby;
	}

	public void setDefaultGameMode(GameMode defaultGameMode) {
		this.defaultGameMode = defaultGameMode;
	}

	public GameMode getDefaultGameMode() {
		return defaultGameMode;
	}

}
