package pl.margoj.server.api.events

import pl.margoj.server.api.Server
import pl.margoj.server.api.event.Event

/**
 * Event wywoływany po gdy serwer w pełni się uruchomii
 */
open class ServerReadyEvent(

        /**
         * Instancja serwera który wywołuje event
         */
        val server: Server

) : Event
{
    override val async: Boolean = false
}