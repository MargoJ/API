package pl.margoj.server.api.plugin

import com.google.common.io.Files
import org.apache.commons.io.FileUtils
import org.apache.logging.log4j.Logger
import pl.margoj.server.api.Server
import pl.margoj.server.api.commands.CommandListener
import pl.margoj.server.api.event.EventListener
import java.io.File
import java.io.IOException
import java.io.InputStream

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

    /**
     * InputStream pliku z resources
     */
    protected fun getResource(name: String): InputStream?
    {
        return Files.asByteSource(File("plugins/${this.annotation.name}/$name")).openStream()
    }

    /**
     * Kopiuje plik z resources do wskazanego miejsca, jeśli ten nie istnieje
     */
    protected fun saveResource(name: String)
    {
        try
        {
            val file = File("plugins/${this.annotation.name}/$name")

            if (!file.exists())
            {
                FileUtils.copyURLToFile(this.javaClass.classLoader.getResource(name), file)
            }
        }
        catch (ex: IOException)
        {
            this.logger.error("Błąd podczas zapisywania zasobu '$name'!")
            ex.printStackTrace()
        }
    }

    /**
     * Kopiuje plik z resources do wskazanego miejsca, nadpisujac poprzedni
     */
    protected fun copyResource(name: String, file: File)
    {
        try
        {
            FileUtils.copyURLToFile(this.javaClass.classLoader.getResource(name), file)
        }
        catch (ex: IOException)
        {
            this.logger.error("Błąd podczas kopiowania zasobu '$name'!")
            ex.printStackTrace()
        }
    }

    /**
     * Folder przeznaczony na pliki pluginu; konfiguracje, itd.
     */
    val dataFolder: File = File("plugins/${this.annotation.name}")
}
