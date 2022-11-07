package de.dinomarlir.randomizer.game.randomizer

import net.axay.kspigot.event.listen
import net.axay.kspigot.items.itemStack
import org.bukkit.Material
import org.bukkit.event.block.BlockDropItemEvent

object BlockDropRandomizer {

    init {
        listen<BlockDropItemEvent> {
            it.items.forEach {
                item ->
                item.itemStack = itemStack(Material.values().random()) {}
            }
        }
    }
}