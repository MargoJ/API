package pl.margoj.server.api.events.player

import pl.margoj.server.api.event.CancellableEvent
import pl.margoj.server.api.map.Location
import pl.margoj.server.api.player.Player

/**
 * Wywoływane za każdym razem gdy gracz się poruszy
 */
open class PlayerMoveEvent(
        override val player: Player,

        /**
         * Poprzednia lokacja gracza
         */
        val oldLocation: Location,

        /**
         * Nowa lokacja gracza
         */
        val newLocation: Location

) : PlayerEvent(), CancellableEvent
{
    /**
     * Czy ruch ma być anulowany?
     */
    override var cancelled: Boolean = false

    override val async: Boolean = false
}