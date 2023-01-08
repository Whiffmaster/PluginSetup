package com.whiff.plug;

import com.whiff.plug.cons.PluginData
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin;

class KotPlug : JavaPlugin() {
    override fun onEnable() {
        getCommand("supaStructure")?.setExecutor(Commands)
        Bukkit.getPluginManager().registerEvents(Listener, this)


    }

    override fun onDisable() {
        PluginData.chunkLoaders.forEach {
            it.remove()
        }
    }
}
