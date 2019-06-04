package de.sparkmc.copa.ingresso;

import net.md_5.bungee.api.plugin.Plugin;

public final class Ingresso extends Plugin {

    @Override
    public void onEnable() {
        this.getProxy().getPluginManager().registerCommand(this, new CommandIngresso("ingresso"));
        this.getProxy().getPluginManager().registerListener(this,new EventIngresso());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
