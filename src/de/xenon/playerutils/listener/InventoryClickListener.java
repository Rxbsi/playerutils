package de.xenon.playerutils.listener;

import com.sun.istack.internal.NotNull;
import de.xenon.playerutils.Plugin;
import de.xenon.playerutils.commands.ChateventCommand;
import de.xenon.playerutils.commands.UtilsCommand;
import de.xenon.playerutils.utils.TeleportUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        final Player player = (Player) event.getWhoClicked();

        // WORLD-GUI
        if (event.getView().getTitle().equalsIgnoreCase("§eWorld§7-§eSettings")) {
            event.setCancelled(true);
            switch (event.getCurrentItem().getType()) {

                case CRAFTING_TABLE:
                    player.performCommand("workbench");
                    break;

                case BARRIER:
                    player.performCommand("chatevents");
                    break;

                case CLOCK:
                    player.performCommand("daytimegui");
                    break;

                case PAPER:
                    player.performCommand("whitelistgui");
                    break;

                case BELL:
                    player.performCommand("broadcast");
                    break;
            }
        }

        // WHITELIST FIRST GUI
        if (event.getView().getTitle().equalsIgnoreCase("§7Manage Whitelist")) {
            event.setCancelled(true);

            switch (event.getCurrentItem().getType()) {
                case EMERALD_BLOCK:
                    Bukkit.setWhitelist(true);
                    player.sendMessage(Plugin.PREFIX + "§aYou activated the whitelist!");
                    break;

                case PLAYER_HEAD:
                    player.performCommand("whitelistguiplayers");
                    break;

                case REDSTONE_BLOCK:
                    Bukkit.setWhitelist(false);
                    player.sendMessage(Plugin.PREFIX + "§cYou deactivated the whitelist!");
                    break;
            }

        }

        // WHITELIST SECOND GUI
        if (event.getView().getTitle().equalsIgnoreCase("§7Whitelisted Players")) {
            event.setCancelled(true);
            switch (event.getCurrentItem().getType()) {
                case PLAYER_HEAD:
                    if (event.isRightClick()) {
                        player.performCommand("whitelist remove " + event.getCurrentItem().getItemMeta().getDisplayName());
                        player.sendMessage(Plugin.PREFIX + "§eYou unwhitelisted §b" + event.getCurrentItem().getItemMeta().getDisplayName() + "§e!");
                        player.performCommand("kick " + event.getView().getTitle());
                        player.closeInventory();
                    }
                    break;
            }
        }

        // PLAYER-GUI
        for (Player all : Bukkit.getOnlinePlayers()) {
            if (event.getView().getTitle().equalsIgnoreCase(all.getDisplayName())) {
                event.setCancelled(true);
                switch (event.getCurrentItem().getType()) {

                    case RED_DYE:
                        player.performCommand("health " + event.getView().getTitle());
                        break;

                    case GRASS_BLOCK:
                        player.performCommand("gm " + event.getView().getTitle());
                        break;

                    case EXPERIENCE_BOTTLE:
                        player.performCommand("setxp " + event.getView().getTitle());
                        break;

                    case BARRIER:
                        player.performCommand("bannkick " + event.getView().getTitle());
                        break;

                    case CHEST:
                        player.performCommand("invsee " + event.getView().getTitle());
                        break;

                    case GHAST_TEAR:
                        player.performCommand("vanish " + event.getView().getTitle());
                        break;

                    case FEATHER:
                        player.performCommand("fly " + event.getView().getTitle());
                        break;

                    case ENDER_PEARL:
                        player.performCommand("tpgui");
                        break;

                    case TNT:
                        player.performCommand("troll " + event.getView().getTitle());
                        break;
                    case IRON_DOOR:
                        player.closeInventory();
                        break;

                }
            }
        }

        // CHAT-EVENT GUI
        if (event.getView().getTitle().equalsIgnoreCase("§6Chat§7-§6Events")) {
            event.setCancelled(true);
            switch (event.getCurrentItem().getType()) {
                case FIRE_CHARGE:
                    player.performCommand("cc");
                    break;
                case BARRIER:
                    player.performCommand("clgui");
                    break;
                case IRON_DOOR:
                    player.closeInventory();
                    player.openInventory(UtilsCommand.worldInventory);
                    break;
            }
        }

        // CHAT-LOCK GUI
        if (event.getView().getTitle().equalsIgnoreCase("§6Chat§7-§6Lock")) {
            event.setCancelled(true);
            switch (event.getCurrentItem().getType()) {
                case EMERALD_BLOCK:
                    player.performCommand("cl unlock");
                    break;
                case REDSTONE_BLOCK:
                    player.performCommand("cl lock");
                    break;
                case IRON_DOOR:
                    player.closeInventory();
                    player.openInventory(ChateventCommand.chatINV);
                    break;
            }
        }

        // TIME GUI
        if (event.getView().getTitle().equalsIgnoreCase("§6Time§7-§6Managment")) {
            event.setCancelled(true);
            switch (event.getCurrentItem().getType()) {
                case SUNFLOWER:
                    player.performCommand("time set day");
                    break;
                case CAMPFIRE:
                    player.performCommand("time set night");
                    break;
                case IRON_DOOR:
                    player.closeInventory();
                    player.openInventory(UtilsCommand.worldInventory);
                    break;
            }
        }

        // TELEPORT GUI
        if (event.getView().getTitle().equalsIgnoreCase("§6Teleport§7-§6Menu")) {
            event.setCancelled(true);
            switch (event.getCurrentItem().getType()) {
                case ENDER_PEARL:
                    TeleportUtil.teleportPlayer(player, UtilsCommand.target);
                    break;
                case ENDER_EYE:
                    TeleportUtil.teleportPlayer(UtilsCommand.target, player);
                    break;
                case IRON_DOOR:
                    player.closeInventory();
                    player.openInventory(UtilsCommand.worldInventory);
                    break;
            }
        }

        // GAMEMODE-GUI
        if (event.getView().getTitle().equalsIgnoreCase(event.getView().getTitle()) && event.getView().getType().equals(InventoryType.BREWING)) {
            event.setCancelled(true);
            switch (event.getCurrentItem().getType()) {
                case GHAST_TEAR:
                    player.performCommand("gamemode spectator " + event.getView().getTitle());
                    player.sendMessage(Plugin.PREFIX + "§aDer Spieler §e" + event.getView().getTitle() + " §aist nun im GameMode §eSpectator");
                    player.closeInventory();
                    break;

                case CRAFTING_TABLE:
                    player.performCommand("gamemode survival " + event.getView().getTitle());
                    player.sendMessage(Plugin.PREFIX + "§aDer Spieler §e" + event.getView().getTitle() + " §aist nun im GameMode §eSurvival");
                    player.closeInventory();
                    break;

                case GRASS_BLOCK:
                    player.performCommand("gamemode creative " + event.getView().getTitle());
                    player.sendMessage(Plugin.PREFIX + "§aDer Spieler §e" + event.getView().getTitle() + " §aist nun im GameMode §eCreative");
                    player.closeInventory();
                    break;

                case IRON_SWORD:
                    player.performCommand("gamemode adventure " + event.getView().getTitle());
                    player.sendMessage(Plugin.PREFIX + "§aDer Spieler §e" + event.getView().getTitle() + " §aist nun im GameMode §eAdventure");
                    player.closeInventory();
                    break;
            }
        }


    }

}
