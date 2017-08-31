package pl.margoj.server.api.events.player

import pl.margoj.server.api.event.CancellableEvent
import pl.margoj.server.api.player.Player

/**
 * Event wywoływany gdy gracz zdobywa lub traci doświadczenie
 */
open class PlayerExpChangeEvent(
        override val player: Player,

        /**
         * Poprzednia ilość doświadczenia
         */
        val previousXp: Long,

        /**
         * Nowa ilość doświadczenia
         */
        var newXp: Long,

        /**
         * O ile zmieniło się doświadczenie
         */
        val change: Long

) : PlayerEvent(), CancellableEvent
{
    override val async: Boolean = false

    override var cancelled: Boolean = false
}