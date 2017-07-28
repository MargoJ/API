package pl.margoj.server.api.map

import pl.margoj.server.api.inventory.map.MapInventory

/**
 * Reprezentuje miasto (mape) w grze.
 */
interface Town
{
    /**
     * Numeryczne ID miasta, może się zmieniać
     */
    val numericId: Int

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

    /**
     * Status PvP na aktualnej mapie
     */
    val pvp: PvPStatus

    /**
     * Ekwipunek mapy, zawiera wszystkie przedmioty lezace na ziemii na danej mapie
     */
    val inventory: MapInventory
}
