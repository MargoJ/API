package pl.margoj.server.api.events.plugin

import pl.margoj.server.api.plugin.MargoJPlugin

/**
 * Event wywoływany gdy nowy plugin jest ładowany
 */
open class PluginEnableEvent(override val plugin: MargoJPlugin<*>) : PluginEvent()
{
    override val async: Boolean = false
}