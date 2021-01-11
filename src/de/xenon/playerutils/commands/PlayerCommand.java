package de.xenon.playerutils.commands;

import de.xenon.playerutils.Plugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player))
            return false;

        final Player player = (Player) sender;

        if (player.hasPermission("playerutils.player") || player.hasPermission("playerutils.*")) {
            player.sendMessage(Plugin.PREFIX + "Klappt");
            player.sendMessage(Plugin.PREFIX + "Sogar 2x!");
        }

        return false;
    }
}
