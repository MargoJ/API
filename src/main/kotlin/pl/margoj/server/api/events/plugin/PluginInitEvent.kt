package pl.margoj.server.api.events.plugin

import pl.margoj.server.api.event.CancellableEvent
import pl.margoj.server.api.plugin.MargoJPlugin

/**
 * Event wywoływany gdy nowy plugin ma być załadowany
 * Może być anulowany co będzie skutkowało anulowanie załadowania pluginu
 */
open class PluginInitEvent(override val plugin: MargoJPlugin<*>) : PluginEvent(), CancellableEvent
{
    override val async: Boolean = false

    override var cancelled: Boolean = false
}