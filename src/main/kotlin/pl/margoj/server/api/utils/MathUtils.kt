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