package pl.margoj.server.api.events.player

import pl.margoj.server.api.event.Event
import pl.margoj.server.api.player.Player


/**
 * Podstawowa klasa wszystkich eventów wywoływanych przez gracza
 */
abstract class PlayerEvent : Event
{
    /**
     * Instancja gracza który wywołuje event
     */
    abstract val player: Player
}