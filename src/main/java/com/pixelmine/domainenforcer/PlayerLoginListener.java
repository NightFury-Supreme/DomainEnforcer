package com.pixelmine.domainenforcer;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.util.List;

public class PlayerLoginListener implements Listener {

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        if (!DomainEnforcer.getInstance().isPluginEnabled()) {
            return; // Do nothing if the plugin is disabled
        }

        String hostname = event.getHostname().split(":")[0]; // Extract hostname without port
        List<String> requiredDomains = DomainEnforcer.getInstance().getConfig().getStringList("required-domains");

        boolean isDomain = false;
        for (String domain : requiredDomains) {
            if (domain.equalsIgnoreCase(hostname)) {
                isDomain = true;
                break;
            }
        }

        boolean isIP = hostname.matches("\\d+\\.\\d+\\.\\d+\\.\\d+");

        if (!isDomain && !isIP) {
            List<String> invalidDomainMessage = DomainEnforcer.getInstance().getConfig().getStringList("invalid-domain-message");
            StringBuilder message = new StringBuilder();
            for (String line : invalidDomainMessage) {
                message.append(ChatColor.translateAlternateColorCodes('&', line)).append("\n");
            }
            event.disallow(PlayerLoginEvent.Result.KICK_OTHER, message.toString().trim());
        } else if (isIP) {
            List<String> ipWarningMessage = DomainEnforcer.getInstance().getConfig().getStringList("ip-warning-message");
            StringBuilder message = new StringBuilder();
            for (String line : ipWarningMessage) {
                event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', line));
            }
        }
    }
}
