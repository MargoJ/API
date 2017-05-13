package pl.margoj.server.api.entity

import pl.margoj.server.api.map.Location

/**
 * Reprezentuje Entity (byt) w grze (npc, gracze)
 */
interface Entity
{
    /**
     * Unikalny identyfikator dla entity
     */
    val id: Int

    /**
     * Wyświetlana nazwa entity
     */
    val name: String

    /**
     * Lokacja entity
     */
    val location: Location

    /**
     * Kierunek entity
     */
    val direction: Int
}
