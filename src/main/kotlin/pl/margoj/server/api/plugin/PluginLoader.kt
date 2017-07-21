package pl.margoj.server.api.plugin

import java.io.File

/**
 * Plugin loader
 */
interface PluginLoader
{
    /**
     * Aktualny [PluginManager] którego używa ten loader
     */
    val pluginManager: PluginManager

    /**
     * Sprawdza czy dany PluginLoader jest w stanie załadować plugin z podanego pliku
     *
     * @param file plik do przetestoawnia
     */
    fun canLoad(file: File): Boolean

    /**
     * Ładuje plugin z podanego pliku
     *
     * @param file plik z pluginem
     */
    fun load(file: File): MargoJPlugin<*>
}