package pl.margoj.server.api.events.plugin

import pl.margoj.server.api.plugin.MargoJPlugin

/**
 * Event wywoływany gdy nowy plugin jest ładowany
 */
open class PluginDisableEvent(override val plugin: MargoJPlugin<*>) : PluginEvent()
{
    override val async: Boolean = false
}