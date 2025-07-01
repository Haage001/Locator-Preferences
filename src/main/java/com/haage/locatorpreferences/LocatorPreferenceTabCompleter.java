package com.haage.locatorpreferences;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LocatorPreferenceTabCompleter implements TabCompleter {
    private static final List<String> BASE_SUGGESTIONS =
            Arrays.asList("range", "disable", "reset");
    private static final List<String> RANGE_SUGGESTIONS =
            Arrays.asList("1000", "5000", "10000", "100000", "infinite");

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd,
                                      String alias, String[] args) {
        if (args.length == 1) {
            return filter(BASE_SUGGESTIONS, args[0]);
        }
        if (args.length == 2 && args[0].equalsIgnoreCase("range")) {
            return filter(RANGE_SUGGESTIONS, args[1]);
        }
        // no suggestions for disable or reset second arg
        return Collections.emptyList();
    }

    private List<String> filter(List<String> options, String current) {
        List<String> out = new ArrayList<>();
        String lower = current.toLowerCase();
        for (String option : options) {
            if (option.toLowerCase().startsWith(lower)) {
                out.add(option);
            }
        }
        Collections.sort(out);
        return out;
    }
}
