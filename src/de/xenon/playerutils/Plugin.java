package de.xenon.playerutils;

import de.xenon.playerutils.commands.*;
import de.xenon.playerutils.listener.AsyncPlayerChatListener;
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

        this.registerCommand();
        this.registerListener();
    }

    private void registerCommand() {
        this.getCommand("utils").setExecutor(new UtilsCommand());
        this.getCommand("whitelistgui").setExecutor(new WhitelistGuiCommand());
        this.getCommand("whitelistguiplayers").setExecutor(new WhitelistGuiPlayersCommand());
        this.getCommand("workbench").setExecutor(new WorkbenchCommand());
        this.getCommand("chatevents").setExecutor(new ChateventCommand());
        this.getCommand("cc").setExecutor(new ChatClearCommand());
        this.getCommand("cl").setExecutor(new ChatlockCommand());
        this.getCommand("clgui").setExecutor(new ChatlockGuiCommand());
        this.getCommand("daytimegui").setExecutor(new DaytimeGuiCommand());
        this.getCommand("tpgui").setExecutor(new TeleportGuiCommand());
        this.getCommand("gm").setExecutor(new GameModeCommand());
        this.getCommand("setxp").setExecutor(new SetXPCommand());
    }

    private void registerListener() {

        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
        Bukkit.getPluginManager().registerEvents(new AsyncPlayerChatListener(), this);
    }

    public static Plugin getPlugin() {
        return plugin;
    }

}
