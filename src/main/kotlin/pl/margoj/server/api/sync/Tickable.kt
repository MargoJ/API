package pl.margoj.server.api.sync

/**
 * Tickable, task wykonywany w glownym watku raz na tick
 */
@FunctionalInterface
interface Tickable
{
    /**
     * Wykonywane w kazdym ticku serwera
     */
    fun tick(currentTick: Long)
}