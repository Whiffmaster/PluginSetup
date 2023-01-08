package com.whiff.plug.enums

import com.whiff.plug.types.Types
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

enum class CustomItems: Types.CustomItem {
    CHUNKLOADER{
        override fun getItem(): ItemStack {
            return ItemStack(Material.BLUE_GLAZED_TERRACOTTA).apply {
                itemMeta = itemMeta?.apply {
                    setDisplayName("Chunk Loader")
                }
            }
        }
        override fun getItemName(): String {
            return "Chunk Loader"
        }
        override fun getId(): Int {
            return 6661
        }
        override fun getDamage(): Int? {
            return null
        }
    },
    SUPAAXE{
        override fun getItem(): ItemStack {
            return ItemStack(Material.DIAMOND_AXE,1).apply {
                itemMeta = itemMeta?.apply {
                    setDisplayName("Supa Axe")
                }
            }
        }
        override fun getItemName(): String {
            return "Supa Axe"
        }
        override fun getId(): Int {
            return 6662
        }
        override fun getDamage(): Int? {
            return 20
        }
    },
    SCANNER{
        override fun getItem(): ItemStack {
            return ItemStack(Material.YELLOW_GLAZED_TERRACOTTA).apply {
                itemMeta = itemMeta?.apply {
                    setDisplayName("Scanner")
                    setLocalizedName("6663")
                    lore = listOf("place to oposite corners of build to scan it")
                }
            }
        }
        override fun getItemName(): String {
            return "Scanner block"
        }
        override fun getId(): Int {
            return 6663
        }
        override fun getDamage(): Int? {
            return null
        }
        fun scan() {
            TODO()
        }
    },

   //TODO: BUILDER
    //TODO: SINGLE SLOT CRAFTS


}