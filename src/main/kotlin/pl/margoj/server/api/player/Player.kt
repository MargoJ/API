package pl.margoj.server.api.player

import pl.margoj.server.api.Server
import pl.margoj.server.api.commands.CommandSender
import pl.margoj.server.api.entity.Entity
import pl.margoj.server.api.map.Location

/**
 * Reprezentuje gracza online na serwerze
 */
interface Player : Entity, CommandSender
{
    /**
     * Serwer na którym gracz się znajduej
     */
    val server: Server

    /**
     * Menadżer ruchu przypisany do aktualnego gracza
     *
     * @see MovementManager
     */
    val movementManager: MovementManager

    /**
     * Menadżer waluty przypisany do aktualnego gracza
     *
     * @see CurrencyManager
     */
    val currencyManager: CurrencyManager

    /**
     * Dane aktualnego gracza
     */
    val data: PlayerData

    /**
     * Pokazuje wiadomość w oknie alertu
     */
    fun displayAlert(alert: String)

    /**
     * Pokazuje wiadomość na środku ekranu gracza
     */
    fun displayScreenMessage(message: String)

    /**
     * Wysyła wiadomość do konsli gracza
     */
    fun logToConsole(text: String, severity: ConsoleMessageSeverity = ConsoleMessageSeverity.LOG)

    /**
     * Teleportuje gracza do wybranej lokacji
     */
    fun teleport(location: Location)

    enum class ConsoleMessageSeverity(val packet: String)
    {
        LOG("n"),
        WARN("w"),
        ERROR("e")
    }
}