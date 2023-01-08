package com.whiff.plug.cons

import org.bukkit.Chunk
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class ChunkLoader(val block: Block, val owner: Player) {
    private val active = false
    private val chunk: Chunk = block.chunk
    val fuel: ItemStack? = null
    val chunks = getChunks(chunk, fuel)


    fun load () {
        if (active) return
        chunksManager(true)

    }
    fun unload () {
        if (!active) return
        chunksManager(false)
    }
    fun remove () {
        unload()
        block.breakNaturally()
        block.type = Material.AIR
        PluginData.chunkLoaders.remove(this)
    }

    private fun chunksManager(activate: Boolean) {
            for (chunk in chunks) {
                chunk.isForceLoaded = activate
            }
        }

    private fun getChunks(chunk: Chunk, fuel: ItemStack?): List<Chunk> {
        val chunks = mutableListOf<Chunk>()
        if (fuel == null) return chunks
        val fuelMaterial = fuel.type
        //coal
        chunks.add(chunk)
        if (fuelMaterial ==Material.COAL) return chunks
        //iron
        chunks.add(chunk.world.getChunkAt(chunk.x + 1, chunk.z))
        chunks.add(chunk.world.getChunkAt(chunk.x - 1, chunk.z))
        chunks.add(chunk.world.getChunkAt(chunk.x, chunk.z + 1))
        chunks.add(chunk.world.getChunkAt(chunk.x, chunk.z - 1))
        chunks.add(chunk.world.getChunkAt(chunk.x + 1, chunk.z + 1))
        chunks.add(chunk.world.getChunkAt(chunk.x - 1, chunk.z - 1))
        chunks.add(chunk.world.getChunkAt(chunk.x + 1, chunk.z - 1))
        chunks.add(chunk.world.getChunkAt(chunk.x - 1, chunk.z + 1))
        return chunks
    }
    }