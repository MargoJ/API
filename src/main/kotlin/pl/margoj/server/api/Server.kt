package pl.margoj.server.api

import org.apache.logging.log4j.Logger
import pl.margoj.server.api.chat.ChatManager
import pl.margoj.server.api.commands.CommandsManager
import pl.margoj.server.api.entity.EntityManager
import pl.margoj.server.api.map.Town
import pl.margoj.server.api.player.Player
import pl.margoj.server.api.sync.Scheduler
import pl.margoj.server.api.sync.Ticker

/**
 * Reprezentuje serwer gry i zapewnia podstawowe metody
 */
interface Server
{
    /**
     * Wersja serwera
     */
    val version: String

    /**
     * Konfiguracja serwera
     */
    val config: MargoJConfig

    /**
     * Ticker serwera
     */
    val ticker: Ticker

    /**
     * Scheduler (harmonogram serwera)
     */
    val scheduler: Scheduler

    /**
     * Menedżer komend
     */
    val commandsManager: CommandsManager

    /**
     * Menedżer entity
     */
    val entityManager: EntityManager

    /**
     * Menedżer chatu
     */
    val chatManager: ChatManager

    /**
     * Lista wszystkich graczy znajdujacych sie obecnie na serwerze
     */
    val players: Collection<Player>

    /**
     * Lista wszystkich map
     */
    val towns: Collection<Town>

    /**
     * Czy serwer jest uruchomiony?
     */
    val running: Boolean

    /**
     * Pobierz liste miast za pomoca id
     *
     * @param id unikalne id
     */
    fun getTownById(id: String): Town?

    /**
     * Wyłącza serwer
     */
    fun shutdown()

    /**
     * Głównny logger serwera
     */
    val logger: Logger
}