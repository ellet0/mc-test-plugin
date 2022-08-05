package com.ahmedhnewa.mymctestplugin

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class MyT2Commands : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (command.name.equals("telegram", ignoreCase = true)) {
            sender.sendMessage("Nicee")
        } else {
            sender.sendMessage("Unknown")
        }
        return true
    }
}