package de.dinomarlir.randomizer.game.randomizer

import net.axay.kspigot.event.listen
import net.axay.kspigot.items.itemStack
import org.bukkit.Material
import org.bukkit.event.block.BlockDropItemEvent

object BlockDropRandomizer {
    private var availableItems: MutableList<Material> = Material.values().toMutableList()
    private var items = HashMap<Material, Material>()

    init {
        listen<BlockDropItemEvent> {
            it.items.forEach {
                item ->
                if (!items.containsKey(item.itemStack.type)) {
                    val randomItem = availableItems.random()
                    items.put(item.itemStack.type, randomItem)
                    availableItems.remove(randomItem)
                }
                item.itemStack = itemStack(items[item.itemStack.type]!!) {}
            }
        }
    }
}