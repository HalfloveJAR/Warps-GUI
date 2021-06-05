package us.halflove.warpsgui.gui

import org.bukkit.Bukkit
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import us.halflove.warpsgui.storage.Entries
import us.halflove.warpsgui.storage.StorageFile

/*
*
* @author Halflove
*
* https://Halflove.us
* https://github.com/HalfloveJAR
*
*/

object WarpMenu {

    private fun getMenu(): Inventory{
        val warpMenu: Inventory = Bukkit.createInventory(null, 45, "Warps")
        val warps: ConfigurationSection? = StorageFile.data.getConfigurationSection("warps")
        if(warps != null){
            for(key in warps.getKeys(false)){
                val item: ItemStack = Entries.getEntry(key, "item") as ItemStack
                val slot: Int = Entries.getEntry(key, "slot") as Int
                warpMenu.setItem(slot, item)
            }
        }

        return warpMenu
    }

    fun openMenu(player: Player) { player.openInventory(getMenu()) }

}