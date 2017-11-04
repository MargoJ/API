package pl.margoj.server.api

import org.apache.logging.log4j.Logger
import pl.margoj.server.api.chat.ChatManager
import pl.margoj.server.api.commands.CommandsManager
import pl.margoj.server.api.commands.ConsoleCommandSender
import pl.margoj.server.api.entity.EntityManager
import pl.margoj.server.api.entity.LivingEntity
import pl.margoj.server.api.event.EventManager
import pl.margoj.server.api.inventory.Item
import pl.margoj.server.api.inventory.ItemStack
import pl.margoj.server.api.map.Town
import pl.margoj.server.api.player.Player
import pl.margoj.server.api.plugin.PluginManager
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
     * Nazwa serwera
     */
    val name: String

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
     * Menedżer pluginów
     */
    val pluginManager: PluginManager

    /**
     * Menedżer eventów
     */
    val eventManager: EventManager

    /**
     * Menedżer komend
     */
    val commandsManager: CommandsManager

    /**
     * Konsola serwera
     */
    val consoleCommandSender: ConsoleCommandSender

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
     * Lista wszystkim przedmiotow
     */
    val items: Collection<Item>

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
     * Pobierz przedmiot za pomoca id
     *
     * @param id unikalne id
     */
    fun getItemById(id: String): Item?

    /**
     * Tworzy nową instancje [ItemStack]
     */
    fun newItemStack(item: Item): ItemStack

    /**
     * Rozpoczyna nową walke pomiędzy dwoma drużynami
     *
     * @param teamA drużyna pierwsza, zazwyczaj drużyna atakująca
     * @param teamB drużyna druga
     *
     * @throws BattleUnableToStartException gdy walka nie może być rozpoczęta
     */
    fun startBattle(teamA: List<LivingEntity>, teamB: List<LivingEntity>)

    /**
     * Wyłącza serwer
     */
    fun shutdown()

    /**
     * Głównny logger serwera
     */
    val logger: Logger

    /**
     * Logger do logowania informacji o grze
     */
    val gameLogger: Logger

    /**
     * Player lub null, gdy offline
     */
    fun getPlayer(name: String): Player?

    /**
     * Player lub null, gdy offline
     */
    fun getPlayer(id: Int): Player?
}