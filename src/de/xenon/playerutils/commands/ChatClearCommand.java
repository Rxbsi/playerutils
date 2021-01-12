package de.xenon.playerutils.commands;


import de.xenon.playerutils.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatClearCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player))
            return false;
        final Player player = (Player) sender;
        if (player.hasPermission("utils.cc") || player.hasPermission("utils.*")) {
            if (args.length == 0) {
                for (int i = 0; i < 250; i++) {
                    Bukkit.broadcastMessage("");
                }
                Bukkit.broadcastMessage(Plugin.PREFIX + "§7Der Chat wurde von §e" + player.getDisplayName() + " §7geleert.");
            }
        }
        return false;
    }
}
