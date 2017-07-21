package pl.margoj.server.api.player

import pl.margoj.server.api.Server
import pl.margoj.server.api.chat.ChatMessage
import pl.margoj.server.api.commands.CommandSender
import pl.margoj.server.api.entity.Entity
import pl.margoj.server.api.inventory.player.PlayerInventory
import pl.margoj.server.api.map.Location

/**
 * Reprezentuje gracza online na serwerze
 */
interface Player : Entity, CommandSender
{
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
     * Ekwipunek gracza
     */
    val inventory: PlayerInventory

    /**
     * Pokazuje wiadomość w oknie alertu
     */
    fun displayAlert(alert: String)

    /**
     * Wysyła wiadomśc na chatcie do gracza
     */
    fun sendChatMessage(message: ChatMessage)

    /**
     * Pokazuje wiadomość na środku ekranu gracza
     */
    fun displayScreenMessage(message: String)

    /**
     * Wysyła wiadomość do konsli gracza
     */
    fun logToConsole(text: String, severity: CommandSender.MessageSeverity = CommandSender.MessageSeverity.LOG)

    /**
     * Teleportuje gracza do wybranej lokacji
     */
    fun teleport(location: Location)
}