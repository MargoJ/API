package pl.margoj.server.api.events.plugin

import pl.margoj.server.api.event.Event
import pl.margoj.server.api.plugin.MargoJPlugin

/**
 * Podstawowa klasa wszystkich eventów wywoływanych przez plugin
 */
abstract class PluginEvent : Event
{
    /**
     * Instancja pluginu który wywołuje event
     */
    abstract val plugin: MargoJPlugin<*>
}