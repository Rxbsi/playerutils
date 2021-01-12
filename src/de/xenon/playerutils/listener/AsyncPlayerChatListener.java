package de.xenon.playerutils.listener;

import de.xenon.playerutils.Plugin;
import de.xenon.playerutils.commands.ChatlockCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChatListener implements Listener {

    @EventHandler
    public void onAsyncChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        if (ChatlockCommand.locked) {
            event.setCancelled(true);
            player.sendMessage(Plugin.PREFIX + "§7Der Chat ist derzeit §cgesperrt§7.");
        }


    }

}
