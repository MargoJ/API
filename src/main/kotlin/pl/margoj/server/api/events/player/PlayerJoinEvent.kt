package pl.margoj.server.api.events.player

import pl.margoj.server.api.player.Player

/**
 * Event wywoływany gdy gracz wchodzi na serwer
 */
open class PlayerJoinEvent(override val player: Player) : PlayerEvent()
{
    override val async: Boolean = false
}