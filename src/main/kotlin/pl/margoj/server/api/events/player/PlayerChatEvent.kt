package pl.margoj.server.api.events.player

import pl.margoj.server.api.event.CancellableEvent
import pl.margoj.server.api.player.Player

/**
 * Event wywoływany gdy gracz wysyła wiadomość na chatcie
 */
open class PlayerChatEvent(
        override val player: Player,

        /**
         * Wiadomość do wysłania
         */
        val message: String

) : PlayerEvent(), CancellableEvent
{
    override val async: Boolean = false

    /**
     * Czy zablokować wysyłanie wiadomosci?
     */
    override var cancelled: Boolean = false
}