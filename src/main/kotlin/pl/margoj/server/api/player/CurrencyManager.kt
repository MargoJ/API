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

    /**
     * Sprawdza czy podana ilosc zlota zmiesci sie do ekwipunku gracza
     */
    fun canFit(gold: Long): Boolean

    /**
     * Dodaje graczowi podana ilosc zlota oraz wyswietla wiadomosc
     */
    fun giveGold(gold: Long)
}