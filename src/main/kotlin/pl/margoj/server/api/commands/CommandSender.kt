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

    /**
     * Ustawia aktualne zadanie do potwierdzenia za pomoca komendy .confirm i wysyla wiadomosc
     */
    fun addConfirmationTask(task: (CommandSender) -> Unit, message: String)

    /**
     * Wykonuje aktualny confirmation task
     *
     * @see addConfirmationTask
     */
    fun executeConfirmationTask(): Boolean

    enum class MessageSeverity(val packet: String)
    {
        LOG("n"),
        WARN("w"),
        ERROR("e")
    }
}