package pl.margoj.server.api.battle

import pl.margoj.server.api.player.Profession

/**
 * Reprezentuje statystyki danego gracza lub potwora
 */
interface BattleStats
{
    /**
     * Aktualny poziom doświadczenia
     */
    val level: Int

    /**
     * Profesja entity
     */
    val profession: Profession

    /**
     * Podstawowe obrażenia
     */
    val damage: IntRange

    /**
     * Siła
     */
    val strength: Int

    /**
     * Zręczność
     */
    val agility: Int

    /**
     * Intelekt
     */
    val intellect: Int

    /**
     * Szybkość ataku (SA)
     */
    val attackSpeed: Double

    /**
     * Maksymalna ilość hp
     */
    val maxHp: Int
}