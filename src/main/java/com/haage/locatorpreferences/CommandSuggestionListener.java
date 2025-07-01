package com.haage.locatorpreferences;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandSendEvent;

import java.util.Iterator;

public class CommandSuggestionListener implements Listener {
    @EventHandler
    public void onPlayerCommandSend(PlayerCommandSendEvent e) {
        Iterator<String> iterator = e.getCommands().iterator();
        while (iterator.hasNext()) {
            String command = iterator.next();
            // Remove any suggestion containing a colon
            if (command.contains(":")) {
                iterator.remove();
            }
        }
    }
}
