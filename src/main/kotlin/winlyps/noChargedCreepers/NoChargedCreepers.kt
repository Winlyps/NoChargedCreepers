package winlyps.noChargedCreepers

import org.bukkit.entity.Creeper
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.CreeperPowerEvent
import org.bukkit.event.entity.EntitySpawnEvent
import org.bukkit.plugin.java.JavaPlugin

class NoChargedCreepers : JavaPlugin(), Listener {

    override fun onEnable() {
        server.pluginManager.registerEvents(this, this)
    }

    @EventHandler
    fun onCreeperPower(event: CreeperPowerEvent) {
        event.isCancelled = true
    }

    @EventHandler
    fun onEntitySpawn(event: EntitySpawnEvent) {
        if (event.entityType != EntityType.CREEPER) return
        val creeper = event.entity as Creeper
        if (creeper.isPowered) {
            creeper.isPowered = false
        }
    }
}

