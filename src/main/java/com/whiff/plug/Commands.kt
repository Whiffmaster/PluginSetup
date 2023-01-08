package com.whiff.plug

import com.whiff.plug.cons.AreaManager
import com.whiff.plug.cons.PluginData
import com.whiff.plug.enums.CustomItems
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object Commands : CommandExecutor{
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) return false
        if(command.name != "supaStructure") return false
        when (args[0]) {

            "getGoods"->{
                val player = sender as Player
                player.inventory.addItem(CustomItems.CHUNKLOADER.getItem())
                player.inventory.addItem(CustomItems.SUPAAXE.getItem())
                player.inventory.addItem(CustomItems.SCANNER.getItem())
            }
            "create"->{
                val player = sender as Player
                if(PluginData.areas[player.uniqueId.toString()] == null) return true

                //TODO: save area
                when(args[1]){
                    "sphere"->{
                        if (args.size != 3) return true
                        val radius = args[2].toInt()
                        PluginData.areas[player.uniqueId.toString()]?.range = radius
                        PluginData.areas[player.uniqueId.toString()]?.point1?.let { AreaManager.createSphere(it, radius) }
                    }
                    "cube"->{
                        if (args.size != 5) return true
                    }
                    else->{
                        player.sendMessage("Invalid arguments")
                    }
                }

            }
        }
        return true
    }
}