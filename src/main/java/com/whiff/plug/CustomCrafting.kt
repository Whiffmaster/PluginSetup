package com.whiff.plug
import org.bukkit.Bukkit.createInventory
import org.bukkit.Material
import org.bukkit.entity.Item
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

object CustomCrafting {
            //TODO
            //template craftingu
            //ziskat itemy z craftingu
            //vytvorit recepty
            //item managemant
            //debug

    fun open(player: Player){
        val inv:MutableList<ItemClass> = mutableListOf()
        //add item
        inv.add(ItemClass(ItemStack(Material.AIR), listOf(11,12,13,20,21,22,24,29,30,31)))
        val newInventory = getNewInventory("Custom Crafting", 36, inv)
        player.openInventory(newInventory)

    }

    private fun getNewInventory( title:String, size: Int, items: List<ItemClass>):Inventory {
        val inventory = createInventory(null, size, title)
        for (item in items) {
            inventory.addItem(item.itemStack)
        }
        for (i in 0 until size) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, ItemStack(Material.BLACK_STAINED_GLASS_PANE))
            }
        }
        return inventory
    }
}

class ItemClass(val itemStack: ItemStack, val slots: List<Int>, val action : () -> Unit? = {}) {
    fun onClick(player: Player) {
        action()
    }
}