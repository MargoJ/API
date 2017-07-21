package pl.margoj.server.api.event

import pl.margoj.server.api.plugin.MargoJPlugin

/**
 * Menedżer eventów
 */
interface EventManager
{
    /**
     * Rejesteruje nowy [EventListener]
     *
     * @param owner plugin który jest właścicielem eventu
     * @param listener listener do zarejestrowania
     */
    fun register(owner: MargoJPlugin<*>, listener: EventListener)

    /**
     * Odrejestrowuje dany [EventListener]
     *
     * @param listener listener do odrejestrowania
     * @return czy odrejestrowano jakikolwiek listener
     */
    fun unregister(listener: EventListener): Boolean

    /**
     * Odrejestrowuje wszystkie listenery których właścicielem jest [EventListener]
     *
     * @param owner plugin które jest właścicielem listenerow
     * @return czy odrejestrowano jakikolwiek listener
     */
    fun unregisterAll(owner: MargoJPlugin<*>): Boolean

    /**
     * Wywołuje dany [Event] na wszystkich zarejestrowanych [EventListener]
     */
    fun call(event: Event)
}