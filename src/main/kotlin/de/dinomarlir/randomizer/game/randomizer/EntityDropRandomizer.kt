package de.dinomarlir.randomizer.game.randomizer

import net.axay.kspigot.event.listen
import org.bukkit.Material
import org.bukkit.event.entity.EntityDeathEvent

object EntityDropRandomizer {

    init {
        listen<EntityDeathEvent> {
            it.drops.forEach {
                it.type = Material.values().random()
            }
        }
    }
}