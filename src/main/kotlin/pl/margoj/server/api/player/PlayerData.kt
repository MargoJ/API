package pl.margoj.server.api.player

/**
 * Podstawowe informacje o danym graczu
 */
interface PlayerData
{
    /**
     * Aktualny poziom doświadczenia gracza
     */
    val level: Int

    /**
     * Aktualna ilość punktów doświadczenia gracza
     */
    var xp: Long

    /**
     * Outfit gracza
     */
    val icon: String

    /**
     * Profesja gracza
     */
    val profession: Profession

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
     * Maksymalna ilość hp gracza
     */
    val maxHp: Int

    /**
     * Dodaje wybraną ilość [xp]
     */
    fun addExp(xp: Long)
}