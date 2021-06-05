package us.halflove.warpsgui.gui

import org.bukkit.Bukkit
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
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

class MenuClick : Listener{

    @EventHandler
    fun clickInventory(event: InventoryClickEvent){

        if(event.view.title == "Warps"){

            val warps: ConfigurationSection? = StorageFile.data.getConfigurationSection("warps")
            if(warps != null) {
                for (key in warps.getKeys(false)) {
                    if(event.currentItem == Entries.getEntry(key, "item")){
                        event.whoClicked.closeInventory()
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Entries.getEntry(key, "command") as String + " ${event.whoClicked.name}")
                    }
                }
            }
            event.isCancelled = true

        }

    }

}