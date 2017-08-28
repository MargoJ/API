package pl.margoj.server.api.player

/**
 * Reprezentuje płeć postaci
 */
enum class Gender(val id: Char)
{
    /**
     * Mężczyzna
     */
    MALE('m'),

    /**
     * Kobieta
     */
    FEMALE('k'),

    /**
     * Unknown
     */
    UNKNOWN('x');

    companion object
    {
        @JvmStatic
        fun getById(id: Char): Gender?
        {
            return Gender.values().firstOrNull { it.id == id }
        }
    }
}