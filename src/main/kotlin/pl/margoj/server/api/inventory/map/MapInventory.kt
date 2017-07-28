package pl.margoj.server.api.inventory.map

import pl.margoj.server.api.inventory.Inventory
import pl.margoj.server.api.inventory.ItemStack
import pl.margoj.server.api.map.Town

/**
 * Ile przedmiotow moze lezec maksymalnie na jednej kratce
 */
const val MAP_LAYERS = 2

/**
 * Intefrejs reprezentujacy ekwipunek mapy (przedmioty lezace na ziemii na danej mapie)
 */
interface MapInventory : Inventory
{
    /**
     * Mapa do której należy ten ekwipunek
     */
    val map: Town

    /**
     * Pobiera item znajdujący się danym slocie i indexie
     *
     * @param index index (warstwa) na ktorej znajduje sie dany przedmiot (0 - najnizsza)
     */
    fun getItemAt(x: Int, y: Int, index: Int): ItemStack?

    /**
     * Ustawia item znajdujące sie na danym slocie i indexie
     * @param index index (warstwa) na ktorej znajduje sie dany przedmiot (0 - najnizsza)
     */
    fun setItemAt(x: Int, y: Int, index: Int, item: ItemStack?)

    /**
     * Pobiera wszystkie itemy znajdujace sie na danym slocie
     */
    fun getItemsAt(x: Int, y: Int): Collection<ItemStack?>

    /**
     * Ustawia wszystkie itemy znajdujące sie na danym slocie
     */
    fun setItemsAt(x: Int, y: Int, items: Collection<ItemStack>)

    /**
     * Dodaje przedmiot do ekwipunku na danej warstwie
     *
     * @return true jezeli sie udalo, false jezeli nie bylo miejsca
     */
    fun addItem(x: Int, y: Int, itemStack: ItemStack): Boolean

    /**
     * Pobiera przedmiot znajdujacy sie na wierzchu danej mapy
     */
    fun getItemOnTop(x: Int, y: Int): ItemStack?
}