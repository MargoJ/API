package pl.margoj.server.api.sync

import pl.margoj.server.api.plugin.MargoJPlugin

/**
 * Harmonogram serwera, zarządza taskami
 */
interface Scheduler
{
    /**
     * Tworzy nowy builder [TaskBuilder]
     *
     * @param plugin plugin który tworzy taska
     */
    fun task(plugin: MargoJPlugin<*>): TaskBuilder

    /**
     * Anuluje task o podanym [id]
     */
    fun cancelTask(id: Int)

    /**
     * Anuluje wszystkie taski zarejestrowane przez dany [plugin]
     */
    fun cancelAll(plugin: MargoJPlugin<*>)
}