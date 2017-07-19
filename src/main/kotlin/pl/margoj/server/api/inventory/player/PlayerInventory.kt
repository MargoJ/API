package pl.margoj.server.api.inventory.player

import pl.margoj.server.api.inventory.Inventory
import pl.margoj.server.api.inventory.ItemStack
import pl.margoj.server.api.player.Player

/**
 * Reprezentuje ekwiupnek gracza
 */
interface PlayerInventory : Inventory
{
    /**
     * Wlasciciel ekwipunku
     */
    val player: Player

    /**
     * Zwraca zalozone przedmioty gracza
     */
    val equipment: PlayerEquipment

    /**
     * Zawartosci orby gracza
     */
    val bagInventories: List<PlayerBagInventory>

    /**
     * Pobiera torbe gracza, lub null gdy dany [slot] na tobre jest pusty
     *
     * 0 - pierwsza torba
     * 1 - druga torba
     * 2 - trzecia torba
     * 3 - torba na klucze
     */
    fun getBag(slot: Int): ItemStack?
    {
        return this.get(9 + slot);
    }

    /**
     * Pobiera torbe gracza, lub null gdy dany [slot] na tobre jest pusty
     *
     * 0 - pierwsza torba
     * 1 - druga torba
     * 2 - trzecia torba
     * 3 - torba na klucze
     */
    fun setBag(slot: Int, itemStack: ItemStack?): ItemStack?
    {
        return this.set(9 + slot, itemStack)
    }

    /**
     * Pobiera zawartosc torby gracza, lub null gdy dany [slot] na tobre jest pusty
     *
     * 1 - pierwsza torba
     * 2 - druga torba
     * 3 - trzecia torba
     * 4 - torba na klucze
     */
    fun getBagInventory(slot: Int): PlayerBagInventory
    {
        return bagInventories[slot]
    }
}