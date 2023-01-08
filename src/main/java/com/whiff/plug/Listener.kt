package com.whiff.plug
import com.whiff.plug.cons.ChunkLoader
import com.whiff.plug.cons.Construct
import com.whiff.plug.cons.PlayerManager
import com.whiff.plug.cons.PluginData
import com.whiff.plug.types.Types
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerJoinEvent
import java.util.*


object Listener :  Listener {
    @EventHandler
    fun onPlayerJoin(e: PlayerJoinEvent) {
        val player = e.player
        PlayerManager(player).verify()
    }
    @EventHandler
    fun onBlockPlace(e: BlockPlaceEvent) {
        val block = e.block
        val player = e.player
        //FIXME: I FUCKED UP -- Jakub 2023
        player.sendMessage("You placed a ${e.itemInHand.itemMeta?.localizedName}")

        if (e.itemInHand.itemMeta?.localizedName == "6661") {
            val chunkLoader = ChunkLoader(block, player)
            PluginData.chunkLoaders.add(chunkLoader)
            chunkLoader.load()
            player.sendMessage("Chunk loader placed")

        } else if (e.itemInHand != null) {
                val cusPlayer = Construct.CustomPlayer(player.name,player.uniqueId.toString())
                PluginData.areas[player.uniqueId.toString()] = Construct.Area(cusPlayer,block)
                player.sendMessage("Base block was placed")
                player.sendMessage("use /supaStructure create sphere <range> / supaStructure create cube <width> <length> <height> to create area")

        }
    }

    @EventHandler
    fun onBlockBrake(e: BlockBreakEvent){
        val block = e.block
        val player = e.player
        if (e.block.type != Material.BLUE_GLAZED_TERRACOTTA) return
            for (chunkLoader in PluginData.chunkLoaders) {
                if (chunkLoader.block == block && chunkLoader.owner == player) {
                    chunkLoader.remove()
                    return
                }
            }
    }

    @EventHandler
    fun onBlockClick(e: PlayerInteractEvent) {
        val player = e.player
        val entity = e.clickedBlock ?: return
        if (entity.type != Material.CRAFTING_TABLE ) return
        val tear = player.world.getBlockAt(entity.x, entity.y, entity.z-1)
        //TODO: crafting recepies
        when (tear.type) {
            Material.IRON_BLOCK -> {
                player.sendMessage("Iron")
            }
            Material.GOLD_BLOCK -> {
                player.sendMessage("Gold")
            }
            Material.DIAMOND_BLOCK -> {
                player.sendMessage("Diamond")
            }
            else -> {
                player.sendMessage("No tear found")
            }
        }
    }
}