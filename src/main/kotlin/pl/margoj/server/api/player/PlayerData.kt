package pl.margoj.server.api.player

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