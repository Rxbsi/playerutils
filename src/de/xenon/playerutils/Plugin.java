package de.xenon.playerutils;

import de.xenon.playerutils.commands.PlayerCommand;
import de.xenon.playerutils.listener.InventoryClickListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {

    public static final String PREFIX = "§7[§ePlayer§7-§eUtils§7]§r ";
    private static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        Bukkit.getConsoleSender().sendMessage(PREFIX + "§aPlugin aktiviert!");

        registerCommand();
        registerListener();
    }

    private void registerCommand() {
        this.getCommand("player").setExecutor(new PlayerCommand());
    }

    private void registerListener() {
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
    }

    public static Plugin getPlugin() {
        return plugin;
    }

}
