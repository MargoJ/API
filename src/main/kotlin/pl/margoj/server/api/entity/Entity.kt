package pl.margoj.server.api.entity

import pl.margoj.server.api.Server
import pl.margoj.server.api.battle.Battle
import pl.margoj.server.api.battle.BattleStats
import pl.margoj.server.api.map.Location
import pl.margoj.server.api.player.Gender
import java.util.Date

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
     * Poziom entity
     */
    val level: Int

    /**
     * Płeć entity
     */
    val gender: Gender

    /**
     * Grafika entit
     */
    val icon: String

    /**
     * Kierunek entity
     */
    val direction: Int

    /**
     * Ilość punktów życia entity
     */
    var hp: Int

    /**
     * Procenotwa ilość zdrowia entity
     */
    val healthPercent: Int

    /**
     * Statystyki entity
     */
    val stats: BattleStats

    /**
     * Walka w jakiej znajduje sie entity
     */
    val currentBattle: Battle?

    /**
     * Data respawnu entity, może być nullem gdy entity jest żywe
     */
    val deadUntil: Date?

    /**
     * Czy entity jest martwy?
     */
    val isDead: Boolean

    /**
     * Zadaje [amount] obrażeń temu entity
     */
    fun damage(amount: Int)

    /**
     * Zabiaj entity na domyślną ilośc czasu
     */
    fun kill()
}
