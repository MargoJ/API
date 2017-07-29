package pl.margoj.server.api.commands

import pl.margoj.server.api.Server

/**
 * Reprezentuje wszystko co może wykonać komende (konsola, gracz, zdalny executor)
 */
interface CommandSender
{
    /**
     * Serwer do którego przypisany jest ten sender
     */
    val server: Server

    /**
     * Nazwa sndera
     */
    val name: String

    /**
     * Wysyła wiadomość do sendera
     *
     * @param message wiadomość
     */
    fun sendMessage(message: String, messageSeverity: MessageSeverity = MessageSeverity.LOG)

    enum class MessageSeverity(val packet: String)
    {
        LOG("n"),
        WARN("w"),
        ERROR("e")
    }
}