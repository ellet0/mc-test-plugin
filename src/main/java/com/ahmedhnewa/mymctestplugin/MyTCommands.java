package com.ahmedhnewa.mymctestplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class MyTCommands implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("telegram")) {
            sender.sendMessage("Nicee");
        } else {
            sender.sendMessage("Unknown");
        }
        return true;
    }
}
