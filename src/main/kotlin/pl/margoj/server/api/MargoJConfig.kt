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

    interface MySQLConfig
    {
        val ip: String

        val database: String

        val username: String

        val password: String

        val maxConnectionPoolSize: Int

        val saveIntervalSeconds: Int
    }

    val mySQLConfig: MySQLConfig
}