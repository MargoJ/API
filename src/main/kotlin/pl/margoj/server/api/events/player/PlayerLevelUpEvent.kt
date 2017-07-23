package pl.margoj.server.api.events.player

import pl.margoj.server.api.player.Player

/**
 * Event wywoływany gdy gracz zdobywa nowy level
 */
open class PlayerLevelUpEvent(
        override val player: Player,

        /**
         * Poprzedni level gracza
         */
        val previousLevel: Int,

        /**
         * Nowy level gracza
         */
        val newLevel: Int

) : PlayerEvent()
{
    override val async: Boolean = false
}