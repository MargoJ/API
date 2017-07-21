package pl.margoj.server.api.commands

import pl.margoj.server.api.plugin.MargoJPlugin

/**
 * Menedżer komend
 */
interface CommandsManager
{
    /**
     * Parsuje i uruchamia sendera
     *
     * @param sender sender uruchamiajacy komende
     * @param string niesparsowana komenda
     *
     * @return zwraca czy jakakolwik komenda została wykonana
     */
    fun dispatchCommand(sender: CommandSender, string: String): Boolean

    /**
     * Rejestruje nowy command listener
     *
     * @param plugin plugin rejestrujacy listnener
     * @param listener listener do zarejestrowania
     * @param commands lista komend do zarejestrowania
     */
    fun registerListener(plugin: MargoJPlugin<*>, listener: CommandListener, vararg commands: String)

    /**
     * Odrejestrowuje podany listener
     *
     * @return czy cokolwiek bylo odrejestrowane
     */
    fun unregisterListener(listener: CommandListener): Boolean

    /**
     * Odrejestrowuje listenery zarejestrowane przez dany plugin
     *
     * @return czy cokolwiek bylo odrejestrowane
     */
    fun unregisterAll(owner: MargoJPlugin<*>): Boolean
}