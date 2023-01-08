package com.whiff.plug;


import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin;

class KotPlug : JavaPlugin() {
    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(Listener, this)

    }

    override fun onDisable() {
        
    }
}
