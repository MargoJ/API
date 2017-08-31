package pl.margoj.server.api.events

import pl.margoj.server.api.commands.Arguments
import pl.margoj.server.api.commands.CommandSender
import pl.margoj.server.api.event.CancellableEvent
import pl.margoj.server.api.event.Event

/**
 * Wykonywane gdy ktoś próbuje wywołać komende
 */
class CommandInvokeEvent(

        /**
         * [CommandSender] który próbuje wykonać komende
         */
        val sender: CommandSender,

        /**
         * Komenda która próbuje być wykonana
         */
        var command: String,

        /**
         * Argumenty komendy
         */
        var args: Arguments
) : Event, CancellableEvent
{
    override val async: Boolean = false

    /**
     * Czy zablokować wywoływanie komendy?
     */
    override var cancelled: Boolean = false
}