package pl.margoj.server.api.sync

/**
 * Ticker serwera
 */
interface Ticker
{
    /**
     * Sprawdza czy aktualny wątek to wątek głowny
     */
    val isInMainThread: Boolean

    /**
     * Docelowa ilość tpsów, ustawiona w configu
     */
    val targetTps: Int

    /**
     * Akualny tick
     */
    val currentTick: Long

    /**
     * 3-elementowa tablica zawierająca średnią ilość tpsów z 1, 5 i 15 minut
     */
    val recentTps: DoubleArray

    /**
     * Wszystkie zarejestrowane [Tickable]
     */
    val tickables: List<Tickable>

    /**
     * Rejestruje nowe [Tickable]
     */
    fun registerTickable(tickable: Tickable)

    /**
     * Odrejestrowuje podane [Tickable]
     */
    fun unregisterTickable(tickable: Tickable): Boolean

    /**
     * Wykonuje podane [Tickable] dokładnie raz w kolejnym ticku
     */
    fun tickOnce(tickable: Tickable)

    /**
     * Rejestruje nowe [Waitable]
     */
    fun <T> registerWaitable(runnable: () -> T): Waitable<T>

    /**
     * Uruchamia [runnable] w wątku asynchronicznym
     */
    fun runAsync(runnable: Runnable)

    companion object
    {
        val NANOS_IN_MILLI = 1_000_000L
        val NANOS_IN_SECOND = 1_000_000_000L
    }
}

