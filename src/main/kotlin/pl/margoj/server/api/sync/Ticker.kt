package pl.margoj.server.api.sync

interface Ticker
{
    val isInMainThread: Boolean

    val targetTps: Int

    val currentTick: Long

    val recentTps: DoubleArray

    val tickables: List<Tickable>

    fun registerTickable(tickable: Tickable): Boolean

    fun unregisterTickable(tickable: Tickable): Boolean

    companion object
    {
        val NANOS_IN_MILLI = 1_000_000L
        val NANOS_IN_SECOND = 1_000_000_000L
    }
}

