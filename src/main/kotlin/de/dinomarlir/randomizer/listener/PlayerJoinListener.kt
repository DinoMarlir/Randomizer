package de.dinomarlir.randomizer.listener

import de.dinomarlir.randomizer.extensions.sendSubtitle
import de.dinomarlir.randomizer.utils.Config
import de.dinomarlir.randomizer.utils.game
import net.axay.kspigot.chat.KColors
import net.axay.kspigot.event.listen
import net.axay.kspigot.gui.GUIType
import net.axay.kspigot.gui.Slots
import net.axay.kspigot.gui.kSpigotGUI
import net.axay.kspigot.gui.openGUI
import net.axay.kspigot.items.itemStack
import net.axay.kspigot.items.meta
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.event.player.PlayerJoinEvent

object PlayerJoinListener {

    init {
        listen<PlayerJoinEvent> {
            val player = it.player

            if (!Config.config.gameStarted) player.openGUI(kSpigotGUI(GUIType.THREE_BY_NINE) {
                defaultPage = 0

                page(0) {
                    title = Component.text("Willst du den Randomizer starten?")

                    button(Slots.RowTwoSlotThree, itemStack(Material.GREEN_BANNER) {
                        meta {
                            displayName(Component.text("Ja!").color(KColors.LIMEGREEN))
                        }
                    }, onClick = {
                        game.startGame()

                        player.closeInventory()
                    })

                    button(Slots.RowTwoSlotSix, itemStack(Material.RED_BANNER) {
                        meta {
                            displayName(Component.text("Nein!").color(KColors.RED))
                        }
                    }, onClick = {
                        player.closeInventory()
                        player.sendSubtitle("So sei es!")
                    })
                }
            })
        }
    }
}