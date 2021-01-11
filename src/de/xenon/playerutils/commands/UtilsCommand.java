package de.xenon.playerutils.commands;

import de.xenon.playerutils.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class UtilsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player))
            return false;

        final Player player = (Player) sender;

        if (player.hasPermission("utils.gui") || player.hasPermission("utils.*")) {
            if (args.length == 0) {
                Inventory worldInventory = Bukkit.createInventory(player, 9, "§eWorld§7-§eSettings");

                ItemStack workbench = new ItemStack(Material.CRAFTING_TABLE);
                ItemMeta workbenchMeta = workbench.getItemMeta();
                workbenchMeta.setDisplayName("§bWorkbench");
                List<String> workbenchLore = new ArrayList<String>();
                workbenchLore.add("§eÖffnet eine portable Workbench");
                workbenchMeta.setLore(workbenchLore);
                workbench.setItemMeta(workbenchMeta);

                ItemStack barrier = new ItemStack(Material.BARRIER);
                ItemMeta barrierMeta = barrier.getItemMeta();
                barrierMeta.setDisplayName("§bChat§7-§bEvents");
                List<String> barrierLore = new ArrayList<String>();
                barrierLore.add("§eLässt dich den Chat clearen");
                barrierMeta.setLore(barrierLore);
                barrier.setItemMeta(barrierMeta);

                ItemStack clock = new ItemStack(Material.CLOCK);
                ItemMeta clockMeta = clock.getItemMeta();
                clockMeta.setDisplayName("§bDaytime");
                List<String> clockLore = new ArrayList<String>();
                clockLore.add("§eLässt dich die Uhrzeit einstellen");
                clockMeta.setLore(clockLore);
                clock.setItemMeta(clockMeta);

                ItemStack paper = new ItemStack(Material.PAPER);
                ItemMeta paperMeta = paper.getItemMeta();
                paperMeta.setDisplayName("§bWhitelist");
                List<String> paperLore = new ArrayList<String>();
                paperLore.add("§eLässt dich die Whitelist einstellen!");
                paperMeta.setLore(paperLore);
                paper.setItemMeta(paperMeta);

                ItemStack bell = new ItemStack(Material.BELL);
                ItemMeta bellMeta = bell.getItemMeta();
                bellMeta.setDisplayName("§bBroadcast");
                List<String> bellLore = new ArrayList<String>();
                bellLore.add("§eLässt dich eine Broadcast-Nachricht schicken");
                bellMeta.setLore(bellLore);
                bell.setItemMeta(bellMeta);

                worldInventory.setItem(2, workbench);
                worldInventory.setItem(3, barrier);
                worldInventory.setItem(4, clock);
                worldInventory.setItem(5, paper);
                worldInventory.setItem(6, bell);

                player.openInventory(worldInventory);

            } else if (args.length == 1) {
                final Player target = Bukkit.getPlayerExact(args[0]);
                if (target != null) {
                    Inventory playerInventory = Bukkit.createInventory(player, 18, target.getDisplayName());

                    ItemStack skull = new ItemStack(Material.SKELETON_SKULL);
                    ItemMeta skullMeta = skull.getItemMeta();
                    skullMeta.setDisplayName(target.getDisplayName());
                    List<String> skullLore = new ArrayList<String>();
                    skullLore.add("§eGame§7§eMode: " + target.getGameMode());
                    skullLore.add("§eOperator: " + target.isOp());
                    skullLore.add("§eKoordinaten: §7X: §8" + target.getLocation().getX() + "§7Y: §8" + target.getLocation().getY() + "§7Z: §8" + target.getLocation().getZ());
                    skullLore.add("§eIP-Adresse: " + target.getAddress());
                    skullMeta.setLore(skullLore);
                    skull.setItemMeta(skullMeta);

                    ItemStack glassPane = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
                    ItemMeta glassPaneMeta = glassPane.getItemMeta();
                    glassPaneMeta.setDisplayName("§7////////");
                    glassPane.setItemMeta(glassPaneMeta);

                    ItemStack redDye = new ItemStack(Material.RED_DYE);
                    ItemMeta redDyeMeta = redDye.getItemMeta();
                    redDyeMeta.setDisplayName("§bHealth");
                    List<String> redDyeLore = new ArrayList<String>();
                    redDyeLore.add("§eLässt dich den Spieler heilen.");
                    redDyeMeta.setLore(redDyeLore);
                    redDye.setItemMeta(redDyeMeta);

                    ItemStack grass = new ItemStack(Material.GRASS_BLOCK);
                    ItemMeta grassMeta = grass.getItemMeta();
                    grassMeta.setDisplayName("§bGame§7-§bMode");
                    List<String> grassLore = new ArrayList<String>();
                    grassLore.add("§eLässt dich den Spieler heilen.");
                    grassMeta.setLore(grassLore);
                    grass.setItemMeta(grassMeta);

                    ItemStack xp = new ItemStack(Material.EXPERIENCE_BOTTLE);
                    ItemMeta xpMeta = xp.getItemMeta();
                    redDyeMeta.setDisplayName("§bExperience");
                    List<String> xpLore = new ArrayList<String>();
                    xpLore.add("§eLässt dich die XP des Spielers setzen.");
                    xpMeta.setLore(xpLore);
                    xp.setItemMeta(xpMeta);

                    ItemStack barrier = new ItemStack(Material.BARRIER);
                    ItemMeta barrierMeta = barrier.getItemMeta();
                    barrierMeta.setDisplayName("§cBann§7/§cKick");
                    List<String> barrierLore = new ArrayList<String>();
                    barrierLore.add("§eLässt dich den Spieler Bannen/Kicken");
                    barrierMeta.setLore(barrierLore);
                    barrier.setItemMeta(barrierMeta);

                    ItemStack chest = new ItemStack(Material.CHEST);
                    ItemMeta chestMeta = chest.getItemMeta();
                    chestMeta.setDisplayName("§bInvsee");
                    List<String> chestLore = new ArrayList<String>();
                    chestLore.add("§eLässt dich in das Inventar des Spielers schauen");
                    chestMeta.setLore(chestLore);
                    chest.setItemMeta(chestMeta);

                    ItemStack vanish = new ItemStack(Material.GHAST_TEAR);
                    ItemMeta vanishMeta = vanish.getItemMeta();
                    vanishMeta.setDisplayName("§bVanish");
                    List<String> vanishLore = new ArrayList<String>();
                    vanishLore.add("§eMacht dich Unsichtbar");
                    vanishMeta.setLore(vanishLore);
                    vanish.setItemMeta(vanishMeta);

                    ItemStack feather = new ItemStack(Material.FEATHER);
                    ItemMeta featherMeta = feather.getItemMeta();
                    featherMeta.setDisplayName("§bFly");
                    List<String> featherLore = new ArrayList<String>();
                    featherLore.add("§eLässt den Spieler fliegen");
                    featherMeta.setLore(featherLore);
                    feather.setItemMeta(featherMeta);

                    ItemStack enderpearl = new ItemStack(Material.ENDER_PEARL);
                    ItemMeta enderpearlMeta = enderpearl.getItemMeta();
                    enderpearlMeta.setDisplayName("§bTeleport");
                    List<String> enderpearlLore = new ArrayList<String>();
                    enderpearlLore.add("§eTeleportier dich zum angegebenen Spieler");
                    enderpearlMeta.setLore(enderpearlLore);
                    enderpearl.setItemMeta(enderpearlMeta);

                    ItemStack tnt = new ItemStack(Material.TNT);
                    ItemMeta tntMeta = tnt.getItemMeta();
                    tntMeta.setDisplayName("§4Troll");
                    List<String> tntLore = new ArrayList<String>();
                    tntLore.add("§eÖffnet ein Troll-Menue für den angegebenen Spieler");
                    tntMeta.setLore(tntLore);
                    tnt.setItemMeta(tntMeta);

                    playerInventory.setItem(0, glassPane);
                    playerInventory.setItem(1, glassPane);
                    playerInventory.setItem(2, glassPane);
                    playerInventory.setItem(3, glassPane);
                    playerInventory.setItem(4, skull);
                    playerInventory.setItem(5, glassPane);
                    playerInventory.setItem(6, glassPane);
                    playerInventory.setItem(7, glassPane);
                    playerInventory.setItem(8, glassPane);
                    playerInventory.setItem(9, redDye);
                    playerInventory.setItem(10, grass);
                    playerInventory.setItem(11, xp);
                    playerInventory.setItem(12, barrier);
                    playerInventory.setItem(13, chest);
                    playerInventory.setItem(14, vanish);
                    playerInventory.setItem(15, feather);
                    playerInventory.setItem(16, enderpearl);
                    playerInventory.setItem(17, tnt);

                    player.openInventory(playerInventory);

                } else {
                    player.sendMessage(Plugin.PREFIX + "§cDer Spieler ist nicht online!");
                }
            }
        }

        return false;
    }
}
