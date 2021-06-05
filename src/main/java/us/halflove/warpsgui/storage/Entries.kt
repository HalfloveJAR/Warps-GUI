package us.halflove.warpsgui.storage

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

/*
*
* @author Halflove
*
* https://Halflove.us
* https://github.com/HalfloveJAR
*
*/

object Entries {

    fun getEntry(entry: String, part: String): Any? {

        return when(part){
            "item" -> {
                val itemType: Material = Material.valueOf(StorageFile.data.get("warps.$entry.item.type") as String)
                val itemName: String = StorageFile.data.get("warps.$entry.name") as String
                val itemAmount: Int = StorageFile.data.get("warps.$entry.item.amount") as Int
                var item: ItemStack = ItemStack(itemType, itemAmount)
                var itemMeta: ItemMeta? = item.itemMeta
                itemMeta?.setDisplayName(ChatColor.translateAlternateColorCodes('&', itemName))
                item.itemMeta = itemMeta
                item
            }
            "slot" -> StorageFile.data.get("warps.$entry.slot") as Int
            "command" -> StorageFile.data.get("warps.$entry.command") as String
            else -> null
        }

    }

}