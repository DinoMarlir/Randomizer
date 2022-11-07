package de.dinomarlir.randomizer.game

import de.dinomarlir.randomizer.utils.game
import net.axay.kspigot.extensions.console
import net.axay.kspigot.extensions.onlinePlayers
import net.axay.kspigot.runnables.KSpigotRunnable
import net.axay.kspigot.runnables.task
import net.axay.kspigot.runnables.taskRunLater
import java.util.concurrent.ThreadLocalRandom

class Timer {
    var timer: KSpigotRunnable? = null

    fun startTimer() {
        timer = task(true, randomTime) {
            game.startRandomEvent()
            startTimer()
        }
    }

    val randomTime: Long
    get() {
        return ThreadLocalRandom.current().nextLong(10*20, 120*20 + 1)
    }
}