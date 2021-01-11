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

public class ChatlockGuiCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player))
            return false;

        final Player player = (Player) sender;

        if(player.hasPermission("utils.lockchat") || player.hasPermission("utils.*")) {
            if(args.length == 0) {
                Inventory inventory = Bukkit.createInventory(player, 9, "§6Chat§7-§6Lock");

                ItemStack cc = new ItemStack(Material.EMERALD_BLOCK);
                ItemMeta ccMeta = cc.getItemMeta();
                ccMeta.setDisplayName("§bChat§7-§bUnlock");
                List<String> ccLore = new ArrayList<String>();
                ccLore.add("§eGebe den Chat frei");
                ccMeta.setLore(ccLore);
                cc.setItemMeta(ccMeta);

                ItemStack cl = new ItemStack(Material.REDSTONE_BLOCK);
                ItemMeta clMeta = cl.getItemMeta();
                clMeta.setDisplayName("§bChat§7-§bLock");
                List<String> clLore = new ArrayList<String>();
                clLore.add("§eBlockiere den Chat");
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
