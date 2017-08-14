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
    val allItems: List<ItemStack?>

    /**
     * Próbuje włożyć przedmiot do ekwipunku na pierwszym pustym slocie, i zwraca czy się udało
     */
    fun tryToPut(item: ItemStack): Boolean

    /**
     * Sprawdza czy gracz posiada podany przedmiot
     */
    fun contains(item: Item): Boolean
    {
        return this.allItems.any { it?.item == item }
    }

    /**
     * Pobiera item z ekwipunku uzywajac [id]
     */
    fun getItemstackById(id: Long): ItemStack?
    {
        return allItems.find { it?.id == id }
    }
}