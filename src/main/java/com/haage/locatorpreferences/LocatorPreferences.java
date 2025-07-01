package com.haage.locatorpreferences;

import org.bukkit.plugin.java.JavaPlugin;

public final class LocatorPreferences extends JavaPlugin {
    @Override
    public void onEnable() {
        // 1) Register the /locatorpreference executor & tab-completer
        this.getCommand("locatorpreference").setExecutor(new LocatorPreferenceCommand());
        this.getCommand("locatorpreference").setTabCompleter(new LocatorPreferenceTabCompleter());

        // 2) Register the listener that strips out any namespaced suggestions
        getServer().getPluginManager().registerEvents(
                new CommandSuggestionListener(),
                this
        );
    }
}
