package pl.margoj.server.api


interface MargoJConfig
{
    interface ServerConfig
    {
        val name: String
    }

    val serverConfig: ServerConfig?

    interface HttpConfig
    {
        val host: String

        val port: Int
    }

    val httpConfig: HttpConfig

    interface EngineConfig
    {
        val targetTps: Int

        val keepAliveSeconds: Int
    }

    val engineConfig: EngineConfig
}