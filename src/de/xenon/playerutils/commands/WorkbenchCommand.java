package de.xenon.playerutils.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class WorkbenchCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player))
            return false;

        final Player player = (Player) sender;

        if(player.hasPermission("utils.wb") || player.hasPermission("utils.*")) {
            if(args.length == 0) {
                player.openWorkbench(player.getLocation(), true);
            }
        }
        return false;
    }
}
