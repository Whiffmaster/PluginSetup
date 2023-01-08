package com.whiff.plug.enums

import com.whiff.plug.types.Types
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

object Tears {
    enum class RecepeTear1 : Types.CustomRecepe {
        CHUNKLOADER{
            override fun getRecepe(): MutableMap<List<Int>, ItemStack> {
                return mutableMapOf(
                    listOf(1,3,7,9) to ItemStack(Material.DIAMOND),
                    listOf(5) to ItemStack(Material.ENDER_EYE,10),
                    listOf(2,4,6,8) to ItemStack(Material.OBSIDIAN)
                )
            }
            override fun getItem(): Types.CustomItem {
                return CustomItems.CHUNKLOADER
            }
        },
        SUPAAXE{
            override fun getRecepe(): MutableMap<List<Int>, ItemStack> {
                return mutableMapOf(
                    listOf(1,2,4) to ItemStack(Material.DIAMOND,10),
                    listOf(5,8) to ItemStack(Material.STICK),
                )
            }

            override fun getItem(): Types.CustomItem {
                return CustomItems.SUPAAXE
            }
        },
    }
}