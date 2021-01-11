package de.xenon.playerutils.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        final Player player = (Player) event.getWhoClicked();

        // World-GUI
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
                    player.performCommand("daytime");
                    break;

                case PAPER:
                    player.performCommand("whitelistgui");
                    break;

                case BELL:
                    player.performCommand("broadcast");
                    break;
            }
        }

        // Player-GUI
        for (Player all : Bukkit.getOnlinePlayers()) {
            if (event.getView().getTitle().equalsIgnoreCase(all.getDisplayName())) {
                event.setCancelled(true);
                switch (event.getCurrentItem().getType()) {

                    case RED_DYE:
                        player.performCommand("health " + event.getView().getTitle());
                        break;

                    case GRASS:
                        player.performCommand("gm " + event.getView().getTitle());
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
                        player.performCommand("teleportutil " + event.getView().getTitle());
                        break;

                    case TNT:
                        player.performCommand("troll " + event.getView().getTitle());
                        break;

                }
            }
        }

    }

}
