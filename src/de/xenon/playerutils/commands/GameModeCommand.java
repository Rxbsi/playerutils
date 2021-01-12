package de.xenon.playerutils.commands;

import de.xenon.playerutils.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GameModeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player))
            return false;

        final Player player = (Player) sender;

        if(player.hasPermission("utils.gm") || player.hasPermission("utils.*")) {
            if (args.length == 0) {
                player.sendMessage(Plugin.PREFIX + "§cEs ist kein Spieler angegeben!");
            } else if (args.length == 1) {
                Player target = Bukkit.getPlayerExact(args[0]);
                Inventory gamemodeInv = Bukkit.createInventory(player, InventoryType.BREWING, target.getDisplayName());

                ItemStack skull = new ItemStack(Material.SKELETON_SKULL);
                ItemMeta skullMeta = skull.getItemMeta();
                skullMeta.setDisplayName("§b" + target.getDisplayName());
                List<String> skullLore = new ArrayList<>();
                skullLore.add("§eMomentaner Game-Mode: §6" + target.getGameMode());
                skullMeta.setLore(skullLore);
                skull.setItemMeta(skullMeta);

                ItemStack ghastTear = new ItemStack(Material.GHAST_TEAR);
                ItemMeta ghastTearMeta = ghastTear.getItemMeta();
                ghastTearMeta.setDisplayName("§7Spectator");
                ghastTear.setItemMeta(ghastTearMeta);

                ItemStack craftingTable = new ItemStack(Material.CRAFTING_TABLE);
                ItemMeta craftingTableMeta = craftingTable.getItemMeta();
                craftingTableMeta.setDisplayName("§eSurvival");
                craftingTable.setItemMeta(craftingTableMeta);

                ItemStack grass = new ItemStack(Material.GRASS_BLOCK);
                ItemMeta grassMeta = grass.getItemMeta();
                grassMeta.setDisplayName("§eCreative");
                grass.setItemMeta(grassMeta);

                ItemStack sword = new ItemStack(Material.IRON_SWORD);
                ItemMeta swordMeta = sword.getItemMeta();
                swordMeta.setDisplayName("§eAdventure");
                sword.setItemMeta(swordMeta);

                gamemodeInv.setItem(4, skull);
                gamemodeInv.setItem(3, ghastTear);
                gamemodeInv.setItem(2, sword);
                gamemodeInv.setItem(1, grass);
                gamemodeInv.setItem(0, craftingTable);

                player.openInventory(gamemodeInv);
            }
        }

        return false;
    }
}
