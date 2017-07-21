package pl.margoj.server.api.events.player

import pl.margoj.server.api.player.Player

/**
 * Event wywoływany gdy gracz wychodzi z serwera
 */
open class PlayerQuitEvent(override val player: Player) : PlayerEvent()
{
    override val async: Boolean = false
}