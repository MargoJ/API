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
     * Czy ta mapa jest głównym miastem?
     */
    val isTown: Boolean

    /**
     * Czy ta mapa jest główna?
     */
    val isMain: Boolean

    /**
     * Nadrzedna mapa, lub null gdy ta mapa jest główna
     */
    val parentMap: Town?

    /**
     * Lokalizacja spawnu, gdzie gracz trafi po śmierci na tej mapie
     */
    val respawnMap: Town

    /**
     * Mapa kolizji.
     * Każdy element w tej tablicy reprezentuje jedną kratke na mape
     */
    val collisions: Array<BooleanArray>

    /**
     * Mapa poziomu wody na mapie.
     * Każdy element w tej tablicy reprezentuje jedną kratke na mape
     */
    val water: Array<IntArray>

    /**
     * Status PvP na aktualnej mapie
     */
    val pvp: PvPStatus

    /**
     * Ekwipunek mapy, zawiera wszystkie przedmioty lezace na ziemii na danej mapie
     */
    val inventory: MapInventory

    /**
     * Spawn point mapy
     */
    val spawnPoint: ImmutableLocation
}
