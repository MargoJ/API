package pl.margoj.server.api.commands

/**
 * Listener nasłuchujący komendy
 */
interface CommandListener
{
    /**
     * Metoda wywoływana gdy komenda jest wykonywana
     */
    fun commandPerformed(command: String, sender: CommandSender, args: Arguments)
}