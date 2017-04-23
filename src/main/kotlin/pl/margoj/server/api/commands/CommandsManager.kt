package pl.margoj.server.api.commands

interface CommandsManager
{
    /**
     * Parsuje i uruchamia sendera
     *
     * @param sender sender uruchamiajacy komende
     * @param string niesparsowana komenda
     */
    fun dispatchCommand(sender: CommandSender, string: String)
}