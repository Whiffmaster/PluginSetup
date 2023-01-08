package com.whiff.plug.cons

import com.whiff.plug.types.Types
import org.bukkit.Chunk
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.block.data.Directional

class Construct {
    data class CustomPlayer(override val name: String, override val uuid: String): Types.CustomPlayer
    data class Area(override val owner: Types.CustomPlayer, override val point1: Block, override var point2: Block? = null, override var point3: Block? = null, override var range: Int? = null): Types.Area
    data class ChunkLoader(val chunk: Chunk, val owner: CustomPlayer)
}