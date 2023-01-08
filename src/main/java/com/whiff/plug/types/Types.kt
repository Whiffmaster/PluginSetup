package com.whiff.plug.types

import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.inventory.ItemStack

/**
 * @author Whiff
 * @param typesForSupaBuilds
 * @see myDickUFag
 */

class Types {
    /**
     * Recepe for custom items
     * @param recepe - recepe for custom item (map of slots and items)
     * in format - listOf(x) to ItemStack(Material.X)
     * @param item - custom item to be crafted
     * @see CustomItem
     */
    interface CustomRecepe {
        fun getRecepe(): MutableMap<List<Int>,ItemStack>
        fun getItem(): CustomItem
    }
    interface CustomItem {
        fun getItem(): ItemStack
        fun getItemName(): String
        fun getId(): Int
        fun getDamage(): Int?
    }

    interface CustomPlayer{
        val name: String
        val uuid: String
    }

    interface Area {
        val owner: CustomPlayer
        val point1: Block
        var point2: Block?
        var point3 : Block?
        var range: Int?
        fun showArea(){

        }
    }
    interface Structure{
        val name: String
        var blocks: List<Block>
        val owner : CustomPlayer
    }
}