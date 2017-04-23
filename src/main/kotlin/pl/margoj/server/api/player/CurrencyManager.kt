package pl.margoj.server.api.player

interface CurrencyManager
{
    /**
     * Limit gracza który gracz może posiadać przy sobie
     */
    val goldLimit: Long

    /**
     * Ilość złota jaką gracz aktualnie posiada przy sobie
     */
    val gold: Long
}