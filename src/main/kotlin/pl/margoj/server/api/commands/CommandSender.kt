package pl.margoj.server.api.commands

import pl.margoj.server.api.chat.ChatMessage

/**
 * Reprezentuje wszystko co może wykonać komende (konsola, gracz, zdalny executor)
 */
interface CommandSender
{
    /**
     * Wysyła wiadomość do sendera
     *
     * @param message wiadomość
     */
    fun sendMessage(message: ChatMessage)
}