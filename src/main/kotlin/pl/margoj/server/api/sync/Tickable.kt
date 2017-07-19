package pl.margoj.server.api.sync

@FunctionalInterface
interface Tickable
{
    fun tick(currentTick: Long)
}