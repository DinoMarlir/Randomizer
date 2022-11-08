package de.dinomarlir.randomizer.game

import de.dinomarlir.randomizer.extensions.sendSubtitle
import de.dinomarlir.randomizer.game.event.Event
import de.dinomarlir.randomizer.game.randomizer.BlockDropRandomizer
import de.dinomarlir.randomizer.game.randomizer.EntityDropRandomizer
import de.dinomarlir.randomizer.utils.Config
import de.dinomarlir.randomizer.utils.game
import net.axay.kspigot.extensions.onlinePlayers

class Game {
    val currentEvent: Event? = null

    init {
        if (Config.config.entityDropRandomizer) EntityDropRandomizer
        if (Config.config.blockDropRandomizer) BlockDropRandomizer
    }

    fun startGame() {
        onlinePlayers.forEach {
            game
            it.sendSubtitle("Der Randomizer-Zyklus wird gestartet!")
            Config.config.gameStarted = true //TODO: bugfix
            //timer.startTimer() //TODO: not finished
        }
    }

    fun setupGame() {
        //TODO: Spawn
    }

    fun startRandomEvent() {
        //Event.values().random().onCall
    }
}