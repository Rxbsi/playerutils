package de.xenon.playerutils.commands;

import de.xenon.playerutils.Plugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UtilsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player))
            return false;

        final Player player = (Player) sender;

        if (player.hasPermission("utils.gui") || player.hasPermission("utils.*")) {
            if (args.length == 0) {
                player.sendMessage(Plugin.PREFIX + "§eKlappt 1a");
            }
        }

        return false;
    }
}
