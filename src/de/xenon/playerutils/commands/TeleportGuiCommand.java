package de.xenon.playerutils.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class TeleportGuiCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player))
            return false;

        final Player player = (Player) sender;

        if(player.hasPermission("utils.tp") || player.hasPermission("utils.*")) {
            if(args.length == 0) {
                Inventory inventory = Bukkit.createInventory(player, 9, "§6Teleport§7-§6Menu");

                ItemStack cc = new ItemStack(Material.ENDER_PEARL);
                ItemMeta ccMeta = cc.getItemMeta();
                ccMeta.setDisplayName("§bTeleport§7-§bThere");
                List<String> ccLore = new ArrayList<String>();
                ccLore.add("§eTeleportiere dich zu dem Spieler.");
                ccMeta.setLore(ccLore);
                cc.setItemMeta(ccMeta);

                ItemStack cl = new ItemStack(Material.ENDER_EYE);
                ItemMeta clMeta = cl.getItemMeta();
                clMeta.setDisplayName("§bTeleport§7-§bHere");
                List<String> clLore = new ArrayList<String>();
                clLore.add("§eTeleportiere den Spieler zu dir.");
                clMeta.setLore(clLore);
                cl.setItemMeta(clMeta);

                ItemStack exit = new ItemStack(Material.IRON_DOOR);
                ItemMeta exitMeta = exit.getItemMeta();
                exitMeta.setDisplayName("§cExit");
                List<String> exitLore = new ArrayList<String>();
                exitLore.add("§eKehre in das vorherige GUI zurück!");
                exitMeta.setLore(exitLore);
                exit.setItemMeta(exitMeta);

                inventory.setItem(2, cc);
                inventory.setItem(4, cl);
                inventory.setItem(7, exit);

                player.openInventory(inventory);

            }

        }
        return false;
    }
}
