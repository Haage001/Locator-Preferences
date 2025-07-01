package com.haage.locatorpreferences;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class LocatorPreferenceCommand implements CommandExecutor {
    private static final double DEFAULT_RANGE = 6.0E7;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd,
                             String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command.");
            return true;
        }

        // /locatorpreference disable
        if (args.length == 1 && args[0].equalsIgnoreCase("disable")) {
            dispatchSet(player, 0);
            player.sendMessage(ChatColor.GREEN + "Locator transmit range disabled");
            return true;
        }

        // /locatorpreference reset
        if (args.length == 1 && args[0].equalsIgnoreCase("reset")) {
            dispatchReset(player);
            player.sendMessage(ChatColor.GREEN + "Locator transmit range reset to default");
            return true;
        }

        // /locatorpreference range <value|infinite>
        if (args.length == 2 && args[0].equalsIgnoreCase("range")) {
            String val = args[1];
            if (val.equalsIgnoreCase("infinite")) {
                // infinite -> reset to default
                dispatchReset(player);
                player.sendMessage(ChatColor.GREEN + "Locator transmit range reset to default");
                return true;
            }
            double value;
            try {
                value = Double.parseDouble(val);
            } catch (NumberFormatException e) {
                player.sendMessage(ChatColor.RED + "'" + val + "' is not a valid number.");
                return true;
            }
            dispatchSet(player, value);
            player.sendMessage(ChatColor.GREEN + "Locator transmit range set to " + value);
            return true;
        }

        // usage hint
        player.sendMessage(ChatColor.YELLOW +
                "Usage: /" + label + " <range <value|infinite> | disable | reset>"
        );
        return true;
    }

    private void dispatchSet(Player player, double value) {
        Bukkit.dispatchCommand(
                Bukkit.getConsoleSender(),
                String.format(
                        "attribute %s minecraft:waypoint_transmit_range base set %s",
                        player.getName(), value
                )
        );
    }

    private void dispatchReset(Player player) {
        Bukkit.dispatchCommand(
                Bukkit.getConsoleSender(),
                String.format(
                        "attribute %s minecraft:waypoint_transmit_range base reset",
                        player.getName()
                )
        );
    }
}
