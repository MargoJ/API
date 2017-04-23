package pl.margoj.server.api.commands

import pl.margoj.server.api.chat.ChatMessage


interface CommandSender
{
    /**
     * Wysyła wiadomość do sendera
     *
     * @param message wiadomość
     */
    fun sendMessage(message: ChatMessage)
}