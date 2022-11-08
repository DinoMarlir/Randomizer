package de.dinomarlir.randomizer.game.event

import de.dinomarlir.randomizer.extensions.sendSubtitle
import net.axay.kspigot.extensions.onlinePlayers

enum class Event(name: String, onEnable: () -> Unit, onDisable: () -> Unit) {
    HEART_RESET("Herz-Reset", {
        net.axay.kspigot.extensions.onlinePlayers.forEach {
            it.health = 1.0
            it.sendSubtitle("Deine Herzen wurden zurückgesetzt!")
        }
    }, {}),
    HUNGER_RESET("Hunger-Reset", {
        onlinePlayers.forEach {
            it.foodLevel = 10
            it.sendSubtitle("Dein Food Level wurde halbiert!")
        }
    }, {})
}