package pl.margoj.server.api.utils

/**
 * Funkcje dotyczące czasu
 */
object TimeUtils
{
    /**
     * Pobiera czas w longu
     */
    fun getTimestampLong(): Long = System.currentTimeMillis() / 1000L

    /**
     * Pobiera czas w double, wymagany przez margonem w niektorych miejscach
     */
    fun getTimestampDouble(): Double = System.currentTimeMillis().toDouble() / 1_000f.toDouble()
}