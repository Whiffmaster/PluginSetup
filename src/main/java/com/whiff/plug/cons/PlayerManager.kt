package com.whiff.plug.cons

import com.whiff.plug.types.Types
import com.whiff.plug.connection.Connector
import org.bukkit.entity.Player

class PlayerManager(val player : Player) {
    private val uuid = player.uniqueId.toString()
    private val name = player.name

    fun verify() {
        val savedPlayer : Types.CustomPlayer = Connector.getPlayer(uuid)
        if (savedPlayer.name != name) {
            player.setDisplayName(savedPlayer.name)
            player.setPlayerListName(savedPlayer.name)
            player.sendMessage("Your name has been changed to ${savedPlayer.name}")
        }
        
    }
}