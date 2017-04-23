package pl.margoj.server.api.map

/**
 * Reprezentuje miasto (mape) w grze.
 */
interface Town
{
    /**
     * Unikalny identyfikator miasta
     */
    val id: String

    /**
     * Wyświetlana nazwe miasta
     */
    val name: String

    /**
    Szerokość mapy (w kartach 32x32)
     */
    val width: Int

    /**
     * Wysokość mapy (w kartach 32x32)
     */
    val height: Int

    /**
     * Mape kolizji.
     * Każdy element w tej tablicy reprezentuje jedną kratke na mape
     */
    val collisions: Array<BooleanArray>
}
