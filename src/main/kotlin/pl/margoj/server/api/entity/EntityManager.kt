package pl.margoj.server.api.entity

import pl.margoj.server.api.player.Player

/**
 * Menedżer entity
 */
interface EntityManager
{
    /**
     * Lista wszystkich entity znajdujących się aktualnie na serwerze
     */
    val entities: Collection<Entity>

    /**
     * Lista wszystkich graczy znajdujących się aktualnie na serwerze
     */
    val players: Collection<Player>
}