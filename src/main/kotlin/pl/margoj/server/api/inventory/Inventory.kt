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
    operator fun get(index: Int): ItemStack?

    /**
     * Ustawia przedmiot znajdujący się na pozycji [index]
     * i zwraca stary przedmiot które został podmieniony lub null gdy slot był pusty
     */
    operator fun set(index: Int, item: ItemStack?): ItemStack?

    /**
     * Lista wszystkich przedmiotow znajdujacych sie w ekwipunku
     */
    val allItems: Array<ItemStack?>
}