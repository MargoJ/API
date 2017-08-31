package pl.margoj.server.api.plugin

import org.apache.logging.log4j.Logger
import pl.margoj.server.api.Server
import pl.margoj.server.api.commands.CommandListener
import pl.margoj.server.api.event.EventListener

/**
 * Reprezentuje główną klase pluginu
 */
abstract class MargoJPlugin<P : MargoJPlugin<P>>
{
    /**
     * Serwer który załadował ten plugin
     */
    lateinit var server: Server

    /**
     * Logger tego pluginu
     */
    lateinit var logger: Logger

    /**
     * Czy ten plugin jest włączony?
     */
    var enabled: Boolean = false

    /**
     * Wywoływane podczas ładowania pluginu
     */
    abstract fun load()

    /**
     * Wywyoływane podczas odładowywania pluginu
     */
    abstract fun unload()

    /**
     * Adnotacja [Plugin] umieszczona nad ta klasa pluginu
     */
    val annotation: Plugin by lazy { this.javaClass.getDeclaredAnnotation(Plugin::class.java) }

    /**
     * Rejestruje nowy listener uzywajac konstruktora z 1 argumentem (instancja pluginu)
     */
    protected fun registerListener(constructor: (P) -> EventListener)
    {
        @Suppress("UNCHECKED_CAST")
        this.server.eventManager.register(this, constructor(this as P))
    }

    /**
     * Rejestruje nowa komende uzywajac konstruktora z 1 argumentem (instancja pluginu)
     *
     * @param commands komendy do zarejestrowania w tym listenerze
     */
    protected fun registerCommand(constructor: (P) -> CommandListener, vararg commands: String)
    {
        @Suppress("UNCHECKED_CAST")
        this.server.commandsManager.registerListener(this, constructor(this as P), *commands)
    }
}