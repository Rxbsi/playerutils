package de.xenon.playerutils.commands;

import de.xenon.playerutils.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatlockCommand implements CommandExecutor {

    public static boolean locked = false;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player))
            return false;
        final Player player = (Player) sender;
        if (player.hasPermission("utils.lockchat") || player.hasPermission("utils.*")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("lock")) {
                    if (!locked) {
                        locked = true;
                        player.sendMessage(Plugin.PREFIX + "§7Du hast den Chat §cgesperrt§7.");
                        Bukkit.broadcastMessage(Plugin.PREFIX + "§7Der Chat wurde von §e" + player.getDisplayName() + " §7gesperrt.");
                        player.closeInventory();
                    } else
                        player.sendMessage(Plugin.PREFIX + "§7Der Chat ist bereits §cgesperrt§7.");
                } else if (args[0].equalsIgnoreCase("unlock")) {
                    if (locked) {
                        locked = false;
                        player.sendMessage(Plugin.PREFIX + "§7Du hast den Chat §efreigeschaltet§7.");
                        Bukkit.broadcastMessage(Plugin.PREFIX + "§7Der Chat wurde von §e" + player.getDisplayName() + " §7freigeschaltet.");
                        player.closeInventory();
                    } else
                        player.sendMessage(Plugin.PREFIX + "§7Der Chat ist bereits §efreigeschaltet§7.");
                }
            }
        }
        return false;
    }
}
