package pl.margoj.server.api.inventory.player

import pl.margoj.server.api.inventory.Inventory
import pl.margoj.server.api.inventory.ItemStack

/**
 * Reprezentuje pojedyńczą torbe gracza
 */
interface PlayerBagInventory : Inventory
{
    /**
     * Pobiera item znajdujący się na danych koordynatach [x] i [y]
     */
    fun getItemAt(x: Int, y: Int): ItemStack?

    /**
     * Ustawia item znajdujący się na danych koordynatach [x] i [y]
     * i zwraca stary przedmiot które został podmieniony lub null gdy slot był pusty
     */
    fun setItemAt(x: Int, y: Int, item: ItemStack?): ItemStack?
}