package com.ahmedhnewa.mymctestplugin

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.ChatColor
import org.bukkit.plugin.Plugin

class MyCommands(private val plugin: Plugin): CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("You are not a player!!")
            return true
        }
//            val player = sender as Player

        if (command.name.equals("telegram", ignoreCase = true)) {
            sender.sendMessage("Sending Message...")
            return if (args.isNotEmpty()) {
                sendMessageToTelegram(sender, args[0])
                true
            } else {
                sender.sendMessage("${ChatColor.RED}Empty args")
                false
            }
        }

        if (command.name.equals("test", ignoreCase = true)) {
            sender.sendMessage(plugin.dataFolder.absolutePath)
            return true
        }

        if (command.name.equals("ping", ignoreCase = true)) {
            sender.sendMessage(sender.ping.toString())
            sender.sendMessage(sender.player?.locale)
            sender.sendMessage(sender.player.toString())
            return true
        }


        return true
    }
}