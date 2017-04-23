package pl.margoj.server.api.utils

object TimeUtils
{
    fun getTimestampLong(): Long = System.currentTimeMillis() / 1000L

    fun getTimestampDouble(): Double = System.currentTimeMillis().toDouble() / 1_000f.toDouble()
}