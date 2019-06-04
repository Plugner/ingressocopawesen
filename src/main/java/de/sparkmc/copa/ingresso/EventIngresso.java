package de.sparkmc.copa.ingresso;

import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class EventIngresso implements Listener {
    @EventHandler
    public void onServerJoin(ServerConnectEvent e ){
        ProxiedPlayer p = e.getPlayer();
        ServerInfo server = e.getTarget();
        if(server.getName().equalsIgnoreCase("copa")) {
            if(DataBase.players.contains(p.getName())) {
                p.sendMessage("§6§lCOPA §rBem vindo á §6§lCOPA HG§r.");
            }else{
                p.sendMessage("§6§lCOPA §rVocê não possui §eingresso §rpara a §6§lCOPA HG§r.");
            }
        }else{
            e.setCancelled(false);
            return;
        }
    }
}
