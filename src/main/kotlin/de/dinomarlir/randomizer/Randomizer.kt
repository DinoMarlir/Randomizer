package de.dinomarlir.randomizer

import de.dinomarlir.randomizer.listener.PlayerJoinListener
import de.dinomarlir.randomizer.utils.Config
import de.dinomarlir.randomizer.utils.game
import net.axay.kspigot.main.KSpigot

class Randomizer : KSpigot() {

    override fun load() {

    }

    override fun startup() {
        Config.config

        PlayerJoinListener

        if (Config.config.gameStarted) {
            game
        }
    }

    override fun shutdown() {

    }
}