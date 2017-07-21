package pl.margoj.server.api.sync

interface Ticker
{
    val isInMainThread: Boolean

    val targetTps: Int

    val currentTick: Long

    val recentTps: DoubleArray

    val tickables: List<Tickable>

    fun registerTickable(tickable: Tickable)

    fun unregisterTickable(tickable: Tickable): Boolean

    fun tickOnce(tickable: Tickable)

    fun <T> registerWaitable(runnable: () -> T): Waitable<T>

    companion object
    {
        val NANOS_IN_MILLI = 1_000_000L
        val NANOS_IN_SECOND = 1_000_000_000L
    }
}

