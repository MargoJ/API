package pl.margoj.server.api.player

/**
 * Menedżer walut, przypisany do danego gracza
 */
interface CurrencyManager
{
    /**
     * Limit gracza który gracz może posiadać przy sobie
     */
    val goldLimit: Long

    /**
     * Ilość złota jaką gracz aktualnie posiada przy sobie
     */
    var gold: Long
}