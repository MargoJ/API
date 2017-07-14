package pl.margoj.server.api.inventory

/**
 * Reprezentuje ekwipunek
 */
interface Inventory
{
    /**
     * Wielkość ekwipunku
     */
    val size: Int

    /**
     * Pobiera przedmiot znajdujący się na pozycji [index]
     */
    operator fun get(index: Int): ItemStack
}