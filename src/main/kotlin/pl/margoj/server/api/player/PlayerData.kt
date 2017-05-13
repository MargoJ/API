package pl.margoj.server.api.player

/**
 * Podstawowe informacje o danym graczu
 */
interface PlayerData
{
    /**
     * Aktualny poziom doświadczenia gracza
     */
    var level: Int

    /**
     * Aktualna ilość punktów doświadczenia gracza
     */
    var xp: Long

    /**
     * Outfit gracza
     */
    var icon: String

    /**
     * Profesja gracza
     */
    val profession: Profession
}