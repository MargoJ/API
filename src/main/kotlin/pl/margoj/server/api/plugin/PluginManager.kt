package pl.margoj.server.api.plugin

import pl.margoj.server.api.Server
import java.io.File

/**
 * Menedżer pluginów
 */
interface PluginManager
{
    /**
     * Serwer na którym ten PluginManager działa
     */
    val server: Server

    /**
     * Lista PluginLoaderów których ten manager używa
     */
    val pluginLoaders: MutableList<PluginLoader>

    /**
     * Lista wszystkich załadowanych pluginów
     */
    val plugins: Collection<MargoJPlugin<*>>

    /**
     * Ładuje plugin z podanego pliku, ale nie wywołuje metody init
     */
    fun load(file: File): MargoJPlugin<*>

    /**
     * Ładuje plugin z podanego pliku uzywając jednego z zarejestrowanych [pluginLoaders]
     *
     * @param file plik z pluginem
     */
    fun loadOne(file: File): MargoJPlugin<*>

    /**
     * Ładuje wszystkie pluginy z podanego folderu
     *
     * @param directory folder z pluginami
     */
    fun loadAll(directory: File): Collection<MargoJPlugin<*>>

    /**
     * Rejestruje nowy plugin
     */
    fun register(plugin: MargoJPlugin<*>)

    /**
     * Inicjalizuje wybrany plugin
     */
    fun init(plugin: MargoJPlugin<*>)

    /**
     * Wyłącza wybrany plugin
     */
    fun disable(plugin: MargoJPlugin<*>)
}