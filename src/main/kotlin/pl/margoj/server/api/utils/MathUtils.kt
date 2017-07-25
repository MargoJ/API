package pl.margoj.server.api.utils

infix fun Double.pow(exponent: Double): Double
{
    return Math.pow(this, exponent)
}

infix fun Int.pow(exponent: Int): Int
{
    return Math.pow(this.toDouble(), exponent.toDouble()).toInt()
}

infix fun Int.pow(exponent: Double): Int
{
    return Math.pow(this.toDouble(), exponent).toInt()
}

fun Double.floor(): Int
{
    return Math.floor(this).toInt()
}

fun Int.fastPow2(): Int
{
    return this * this
}

fun Int.fastPow3(): Int
{
    return this * this * this
}

fun Int.fastPow4(): Int
{
    return this * this * this * this
}

fun Long.fastPow2(): Long
{
    return this * this
}

fun Long.fastPow3(): Long
{
    return this * this * this
}

fun Long.fastPow4(): Long
{
    return this * this * this * this
}

