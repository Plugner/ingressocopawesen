package de.sparkmc.copa.ingresso;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.plugin.Command;

public class CommandIngresso extends Command {
    public CommandIngresso(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if(commandSender instanceof ProxiedPlayer) {
            ProxiedPlayer p = (ProxiedPlayer)commandSender;
            if(p.hasPermission("copa.ingresso")) {
                if(strings.length != 2) {
                    p.sendMessage("§6§lCOPA §rUse: /ingresso add player");
                }

                String alvo = strings[1];
                String type = strings[0];
                if(type.equalsIgnoreCase("add")) {
                    ProxiedPlayer pp = ProxyServer.getInstance().getPlayer(alvo);
                    if(pp == null) {p.sendMessage("§6§lCOPA §rJogador " + alvo + " §c§lOFFLINE§r.");return;}
                    DataBase.players.add(p.getName());
                    p.sendMessage("§6§lCOPA §rO Jogador " + pp.getName() + " ganhou um ingresso.");
                    pp.sendMessage("§6§lCOPA §rParabéns você ganhou um ingresso para a COPA HG.");
                }else{
                    p.sendMessage("§6§lCOPA §rUse: /ingresso add player");
                }


            }else{
                p.sendMessage("§6§LCOPA §rVocê não pode definir ingressos.");
            }
        }else{

        }

    }
}
