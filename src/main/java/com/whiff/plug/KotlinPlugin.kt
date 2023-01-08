package com.whiff.plug;

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin;

class KotlinPlugin : JavaPlugin() {
    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(Listener, this)
        getCommand("TESTPLUGIN")?.setExecutor(Commands)
        logger.info("Hello World!")

    }

    override fun onDisable() {
        
    }
}
