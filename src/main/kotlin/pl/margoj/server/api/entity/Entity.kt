package pl.margoj.server.api.entity

import pl.margoj.server.api.Server
import pl.margoj.server.api.map.Location

/**
 * Reprezentuje Entity (byt) w grze (npc, gracze)
 */
interface Entity
{
    /**
     * Serwer entity
     */
    val server: Server

    /**
     * Wyświetlana nazwa entity
     */
    val name: String

    /**
     * Lokacja entity
     */
    val location: Location

    /**
     * Grafika entity
     */
    val icon: String

    /**
     * Kierunek entity
     */
    val direction: Int

    /**
     * Zniszcz entity
     */
    fun destroy()
}
