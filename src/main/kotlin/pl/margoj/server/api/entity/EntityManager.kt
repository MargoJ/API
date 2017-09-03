package pl.margoj.server.api.entity

import pl.margoj.server.api.player.Player

/**
 * Menedżer entity
 */
interface EntityManager
{
    /**
     * Lista wszystkich NPC znajdujących się aktualnie na serwerze
     */
    val npcs: Collection<Entity>

    /**
     * Lista wszystkich graczy znajdujących się aktualnie na serwerze
     */
    val players: Collection<Player>

    /**
     * Lista wszystkich entity znajdujących się aktualnie na serwerze
     */
    val entities: Collection<Entity>

    /**
     * Pobiera gracza uzywajac ID
     */
    fun getPlayerById(id: Int): Player?

    /**
     * Pobiera NPC uzywajac ID
     */
    fun getNpcById(id: Int): Entity?
}