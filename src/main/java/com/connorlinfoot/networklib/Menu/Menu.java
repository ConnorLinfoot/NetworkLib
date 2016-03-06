package com.connorlinfoot.networklib.Menu;

import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class Menu {
    private String title;
    private HashMap<ItemStack,MenuItemCallback> items = new HashMap<ItemStack, MenuItemCallback>();

    public Menu(String title) {
        this.title = title;
    }

    public void addItem(ItemStack itemStack, MenuItemCallback callback) {
        callback.run();
    }

}