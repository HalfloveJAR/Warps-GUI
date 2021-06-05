package us.halflove.warpsgui

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import us.halflove.warpsgui.commands.WarpsCommand
import us.halflove.warpsgui.gui.MenuClick
import us.halflove.warpsgui.storage.StorageFile

/*
*
* @author Halflove
*
* https://Halflove.us
* https://github.com/HalfloveJAR
*
*/

class Main : JavaPlugin() {

    override fun onEnable(){

        //Registers commands and events
        getCommand("warps")?.setExecutor(WarpsCommand)
        Bukkit.getPluginManager().registerEvents(MenuClick(), this)

        //Checks and creates data.yml
        StorageFile.createDataFile(this)

    }

    override fun onDisable(){

    }

}