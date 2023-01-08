package com.whiff.plug.cons

import com.whiff.plug.types.Types
import org.bukkit.block.Block

object AreaManager {

    fun createSphere(block: Block, radius: Int){
        val x = block.x
        val y = block.y
        val z = block.z
        val r = radius
        val r2 = r * r
        for (dx in -r..r) {
            for (dy in -r..r) {
                for (dz in -r..r) {
                    if (dx * dx + dy * dy + dz * dz <= r2) {
                        val b = block.world.getBlockAt(x + dx, y + dy, z + dz)
                        b.type = block.type
                    }
                }
            }
        }

    }

}