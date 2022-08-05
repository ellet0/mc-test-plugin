package com.ahmedhnewa.mymctestplugin

import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.player.AsyncPlayerChatEvent

class EventsTest : Listener {
    @EventHandler()
    fun onChatMsg(event: AsyncPlayerChatEvent) {
//        event.player.sendMessage("Listen up")
        sendMessageToTelegram(event.player, "<pre>${event.player.name}:</pre> <b>${event.message}</b>")
    }

    @EventHandler
    fun onBlockBreak(event: BlockBreakEvent) {
        val player = event.player
        val brokenBlock = event.block
//        player.sendMessage("كافي شبيك")
        if (brokenBlock.type == Material.DIAMOND_ORE) {
            sendMessageToTelegram(player, "فضييحة ${player.name}" + " حيث لكة دايموند ")
            player.sendMessage("واوو دايموند, خل افضحك بالكروب")
        }
    }
}