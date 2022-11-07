package de.dinomarlir.randomizer.utils

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import net.axay.kspigot.config.kSpigotConfig
import java.io.File

object Config {

    @Serializable
    data class Config(
        var gameStarted: Boolean,
        var spawnBuilt: Boolean,
        var entityDropRandomizer: Boolean,
        var blockDropRandomizer: Boolean,
        var texturePackEnabled: Boolean
    )

    private fun setupFile(): File {
        val file = File("plugins/randomizer/config.json")
        if (!file.parentFile.exists()) file.parentFile.mkdir()
        if (!file.exists()) file.createNewFile()
        return file
    }
    var config by kSpigotConfig<Config>(setupFile(), stringFormat = Json { prettyPrint = true }, default = { Config (
        false,
        false,
        true,
        true,
        false //TODO: not yet implemented
    )})
}