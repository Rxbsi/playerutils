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
                case PAPER:
                    player.performCommand("whitelistgui");
                    break;

                case CLOCK:
                    player.performCommand("daytime");
                    break;

                case BARRIER:
                    player.performCommand("chatevent");
                    break;
            }
        }

        // Player-GUI
        for (Player all : Bukkit.getOnlinePlayers()) {
            if (event.getView().getTitle().equalsIgnoreCase(all.getDisplayName())) {
                event.setCancelled(true);
                switch (event.getCurrentItem().getType()) {

                }
            }
        }

    }

}
