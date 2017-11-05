package pl.margoj.server.api.inventory

import pl.margoj.server.api.Server
import pl.margoj.server.api.battle.DamageSource

/**
 * Reprezentuje przedmiot w ekwipunku, ktore moze byc wysylany do gracza,
 * może być stworzoyny używając [Server.newItemStack]
 */
interface ItemStack : DamageSource
{
    /**
     * Przedmiot
     */
    val item: Item

    /**
     * Unikalne ID przedmiotu
     */
    val id: Long

    /**
     * Niszczy ten przedmiot
     */
    fun destroyItem()

    /**
     * Kopiuje wszystkie wlasciwosci z podanego ItemStacka
     */
    fun cloneFrom(other: ItemStack)
}