package de.xenon.playerutils.commands;

import de.xenon.playerutils.Plugin;
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

public class DaytimeGuiCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player))
            return false;

        final Player player = (Player) sender;

        if (player.hasPermission("utils.time") || player.hasPermission("utils.*")) {
            if (args.length == 0) {
                Inventory inventory = Bukkit.createInventory(player, 9, "§6Time§7-§6Managment");

                ItemStack cc = new ItemStack(Material.SUNFLOWER);
                ItemMeta ccMeta = cc.getItemMeta();
                ccMeta.setDisplayName("§bTime§7-§bDay");
                List<String> ccLore = new ArrayList<String>();
                ccLore.add("§eSetzte die Zeit auf \"Tag\"");
                ccMeta.setLore(ccLore);
                cc.setItemMeta(ccMeta);

                ItemStack cl = new ItemStack(Material.CAMPFIRE);
                ItemMeta clMeta = cl.getItemMeta();
                clMeta.setDisplayName("§bTime§7-§bNight");
                List<String> clLore = new ArrayList<String>();
                clLore.add("§eSetzte die Zeit auf \"Nacht\"");
                clMeta.setLore(clLore);
                cl.setItemMeta(clMeta);

                ItemStack exit = new ItemStack(Material.IRON_DOOR);
                ItemMeta exitMeta = exit.getItemMeta();
                exitMeta.setDisplayName("§cExit");
                List<String> exitLore = new ArrayList<String>();
                ccLore.add("§eKehre in das vorherige GUI zurück!");
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
