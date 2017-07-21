package pl.margoj.server.api.plugin

import org.apache.logging.log4j.Logger
import pl.margoj.server.api.Server
import pl.margoj.server.api.commands.CommandListener
import pl.margoj.server.api.event.EventListener

abstract class MargoJPlugin<P : MargoJPlugin<P>>
{
    lateinit var server: Server

    lateinit var logger: Logger

    var enabled: Boolean = false

    abstract fun load()

    abstract fun unload()

    val annotation: Plugin by lazy { this.javaClass.getDeclaredAnnotation(Plugin::class.java) }

    protected fun registerListener(constructor: (P) -> EventListener)
    {
        @Suppress("UNCHECKED_CAST")
        this.server.eventManager.register(this, constructor(this as P));
    }

    protected fun registerCommand(constructor: (P) -> CommandListener, vararg commands: String)
    {
        @Suppress("UNCHECKED_CAST")
        this.server.commandsManager.registerListener(this, constructor(this as P), *commands);
    }
}