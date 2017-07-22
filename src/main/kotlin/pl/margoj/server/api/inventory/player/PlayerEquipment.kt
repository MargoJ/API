package pl.margoj.server.api.inventory.player

import pl.margoj.server.api.inventory.Inventory
import pl.margoj.server.api.inventory.ItemStack

/**
 * Reprezentuje przedmioty ktore gracz ma na sobie
 */
interface PlayerEquipment : Inventory
{
    /**
     * Zakłada item na odpowiedni slot, zwraca poprzedni item znajdujacy sie na danym slocie
     */
    fun tryEquip(item: ItemStack): ItemStack?

    /**
     * Hełm
     */
    var helmet: ItemStack?

    /**
     * Pierścień
     */
    var ring: ItemStack?

    /**
     * Naszyjnik
     */
    var neckless: ItemStack?

    /**
     * Rękawice
     */
    var gloves: ItemStack?

    /**
     * Broń główna
     */
    var weapon: ItemStack?

    /**
     * Zbroja
     */
    var armor: ItemStack?

    /**
     * Broń pomocnicza
     */
    var helper: ItemStack?

    /**
     * Buty
     */
    var boots: ItemStack?

    /**
     * Sakwa
     */
    var purse: ItemStack?
}