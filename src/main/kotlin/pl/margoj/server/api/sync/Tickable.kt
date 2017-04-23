package pl.margoj.server.api.sync

interface Tickable
{
    fun tick(currentTick: Long)
}