package pl.margoj.server.api.player

import pl.margoj.server.api.battle.BattleStats
import java.util.Date

/**
 * Podstawowe informacje o danym graczu
 */
interface PlayerData : BattleStats
{
    /**
     * Aktualna ilość punktów doświadczenia gracza
     */
    var xp: Long

    /**
     * Outfit gracza
     */
    val icon: String

    /**
     * Ilość punktów życia postaci
     */
    var hp: Int

    /**
     * Płeć postaci
     */
    val gender: Gender

    /**
     * Punkty statystyk
     */
    val statPoints: Int

    /**
     * Podstawowa siła
     */
    val baseStrength: Int

    /**
     * Podstawowa zręczność
     */
    val baseAgility: Int

    /**
     * Podstawowy intelekt
     */
    val baseIntellect: Int

    /**
     * Wyczerpanie gracza (w minutach)
     */
    val ttl: Int

    /**
     * Data respawnu gracza, może być nullem gdy gracz jest żywy
     */
    val deadUntil: Date?

    /**
     * Dodaje wybraną ilość [xp]
     */
    fun addExp(xp: Long)
}