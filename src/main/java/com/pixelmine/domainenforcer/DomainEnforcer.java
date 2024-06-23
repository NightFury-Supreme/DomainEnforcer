package com.pixelmine.domainenforcer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class DomainEnforcer extends JavaPlugin implements TabCompleter {

    private static DomainEnforcer instance;
    private boolean isEnabled;

    @Override
    public void onEnable() {
        instance = this;
        isEnabled = true;

        // Register events
        Bukkit.getPluginManager().registerEvents(new PlayerLoginListener(), this);

        // Save default config if not exist or update config
        saveDefaultConfig();
        reloadConfig();

        // Set tab completer for domainenforcer command
        PluginCommand command = getCommand("domainenforcer");
        if (command != null) {
            command.setTabCompleter(this);
        }

        logPluginState("enabled");
    }

    @Override
    public void onDisable() {
        logPluginState("disabled");
        instance = null;
        isEnabled = false;
    }

    public static DomainEnforcer getInstance() {
        return instance;
    }

    public boolean isPluginEnabled() {
        return isEnabled;
    }

    public void setPluginEnabled(boolean enabled) {
        this.isEnabled = enabled;
    }

    private void logPluginState(String state) {
        String[] messages = {
                ChatColor.GREEN + "█▀▀▄ █▀▀█ █▀▄▀█ █▀▀█ ░▀░ █▀▀▄ █▀▀ █▀▀▄ █▀▀ █▀▀█ █▀▀█ █▀▀ █▀▀ █▀▀█",
                ChatColor.GREEN + "█░░█ █░░█ █░▀░█ █▄▄█ ▀█▀ █░░█ █▀▀ █░░█ █▀▀ █░░█ █▄▄▀ █░░ █▀▀ █▄▄▀",
                ChatColor.GREEN + "▀▀▀░ ▀▀▀▀ ▀░░░▀ ▀░░▀ ▀▀▀ ▀░░▀ ▀▀▀ ▀░░▀ ▀░░ ▀▀▀▀ ▀░▀▀ ▀▀▀ ▀▀▀ ▀░▀▀",
                ChatColor.AQUA + "    DomainEnforcer " + getDescription().getVersion() + " " + state
        };
        for (String message : messages) {
            Bukkit.getConsoleSender().sendMessage(message);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("domainenforcer")) {
            if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
                sender.sendMessage(ChatColor.YELLOW + "DomainEnforcer Commands:");
                sender.sendMessage(ChatColor.AQUA + "/domainenforcer reload" + ChatColor.WHITE + " - Reload the configuration.");
                sender.sendMessage(ChatColor.AQUA + "/domainenforcer start" + ChatColor.WHITE + " - Start the DomainEnforcer plugin.");
                sender.sendMessage(ChatColor.AQUA + "/domainenforcer stop" + ChatColor.WHITE + " - Stop the DomainEnforcer plugin.");
                return true;
            }
            switch (args[0].toLowerCase()) {
                case "reload":
                    reloadConfig();
                    sender.sendMessage(ChatColor.GREEN + "DomainEnforcer configuration reloaded!");
                    return true;
                case "start":
                    if (isEnabled) {
                        sender.sendMessage(ChatColor.YELLOW + "DomainEnforcer is already running.");
                    } else {
                        setPluginEnabled(true);
                        sender.sendMessage(ChatColor.GREEN + "DomainEnforcer started.");
                    }
                    return true;
                case "stop":
                    if (!isEnabled) {
                        sender.sendMessage(ChatColor.YELLOW + "DomainEnforcer is already stopped.");
                    } else {
                        setPluginEnabled(false);
                        sender.sendMessage(ChatColor.RED + "DomainEnforcer stopped.");
                    }
                    return true;
                default:
                    sender.sendMessage(ChatColor.RED + "Invalid command. Type '/domainenforcer help' for help.");
                    return true;
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();
        if (command.getName().equalsIgnoreCase("domainenforcer") && args.length == 1) {
            List<String> commands = new ArrayList<>();
            commands.add("reload");
            commands.add("start");
            commands.add("stop");
            commands.add("help");
            for (String cmd : commands) {
                if (cmd.startsWith(args[0].toLowerCase())) {
                    completions.add(cmd);
                }
            }
        }
        return completions;
    }
}
