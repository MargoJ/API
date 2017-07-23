package pl.margoj.server.api.commands

import pl.margoj.server.api.player.Player

/**
 * Reprezentuje argumenty komendy
 */
interface Arguments
{
    /**
     * Sprawdza czy podana komenda posiada argument o indexie [i]
     */
    fun has(i: Int): Boolean

    /**
     * Pobiera dany argument jako string
     */
    fun asString(i: Int): String

    /**
     * Pobiera dany argument jako int, lub zwraca nulla gdy podana wartosc nie jest intem
     */
    fun asInt(i: Int): Int?

    /**
     * Pobiera dany argument jako int, lub zwraca nulla gdy podana wartosc nie jest longiem
     */
    fun asLong(i: Int): Long?

    /**
     * Pobiera dany argument jako gracza, lub zwraca nulla gdy dany gracz nie mógł być znaleziony
     */
    fun asPlayer(i: Int): Player?

    /**
     * Sprawdza czy podany warunek zwraca true,
     * jesli nie wyrzuca wyjatek [CommandException]
     */
    @Throws(CommandException::class)
    fun ensureTrue(condition: () -> Boolean)

    /**
     * Sprawdza czy podany warunek zwraca true,
     * jesli nie wyrzuca wyjatek [CommandException] z podaną wiadomościa [message]
     */
    @Throws(CommandException::class)
    fun ensureTrue(condition: () -> Boolean, message: String)

    /**
     * Sprawdza czy podana wartość nie jest nullem  i ją zwraca,
     * jesli jest nullem wyrzuca wyjatek [CommandException]
     */
    @Throws(CommandException::class)
    fun ensureNotNull(value: Any?)

    /**
     * Sprawdza czy podana wartość nie jest nullem  i ją zwraca,
     * jesli jest nullem wyrzuca wyjatek [CommandException] z podaną wiadomościa [message]
     */
    @Throws(CommandException::class)
    fun ensureNotNull(value: Any?, message: String)
}