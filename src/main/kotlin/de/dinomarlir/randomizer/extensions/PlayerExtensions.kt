package de.dinomarlir.randomizer.extensions

import net.axay.kspigot.chat.KColors
import net.axay.kspigot.extensions.bukkit.title
import net.kyori.adventure.text.Component
import org.bukkit.entity.Player

fun Player.sendSubtitle(text: String) {
    this.title(Component.empty(), Component.text(text).color(KColors.BLUE))
}