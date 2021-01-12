package de.xenon.playerutils.utils;

import de.xenon.playerutils.Plugin;
import org.bukkit.entity.Player;

public class TeleportUtil {

    public static void teleportPlayer(Player player, Player target) {
        if (player != null) {
            player.teleport(target);
            player.sendMessage(Plugin.PREFIX + "§7Du wurdest zu dem Spieler §e" + target.getDisplayName() + "§7 teleportiert.");
        } else {
            player.sendMessage(Plugin.PREFIX + "§7Der angegebene Spieler ist §cnicht §7online.");
        }

    }

}
