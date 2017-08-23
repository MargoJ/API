package pl.margoj.server.api.inventory

/**
 * Reprezentuje pojedyńczy przedmiot z zestawu zasobów
 */
interface Item
{
    /**
     * Unikalne ID przedmiotu
     */
    val id: String

    /**
     * Wyświetlana nazwa przedmiotu
     */
    val name: String
}