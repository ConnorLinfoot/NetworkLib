package com.connorlinfoot.networklib.Modules;

public abstract class Module {
    protected String name;
    protected String slug;

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
