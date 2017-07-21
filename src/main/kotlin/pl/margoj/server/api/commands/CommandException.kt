package pl.margoj.server.api.commands

/**
 * Exception który po wyrzucenie w CommandListenerze wyświetli daną wiadomość
 */
class CommandException(message: String?) : RuntimeException(message)
{
    override fun fillInStackTrace(): Throwable
    {
        return this
    }
}