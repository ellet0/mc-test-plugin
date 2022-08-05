package com.ahmedhnewa.mymctestplugin

import org.bukkit.ChatColor
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    override fun onEnable() {
        val command = MyCommands(this)
        server.pluginManager.registerEvents(EventsTest(), this)
        getCommand("telegram")?.setExecutor(command)
        getCommand("test")?.setExecutor(command)
        getCommand("ping")?.setExecutor(command)
        server.consoleSender.sendMessage("${ChatColor.GREEN} [${getPluginName()}]: Plugin is enabled!")
    }

    private fun getPluginName(): String {
        val config = classLoader.getResourceAsStream("plugin.yml")?.bufferedReader()?.readText() ?: ""
        val yamlConfiguration = YamlConfiguration()
        yamlConfiguration.loadFromString(config)
        return yamlConfiguration.getString("name") ?: "UnknownPlugin"
    }

    override fun onDisable() {
        server.consoleSender.sendMessage("${ChatColor.RED} [${getPluginName()}]: Plugin is disabled!")
    }



}