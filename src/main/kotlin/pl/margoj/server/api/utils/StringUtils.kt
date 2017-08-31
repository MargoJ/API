package pl.margoj.server.api.utils

import org.apache.commons.lang3.Validate
import java.util.Random

/**
 * Funkcje pomocnicze do stringow
 */
object StringUtils
{
    private val DEFAULT_POOL = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789".toCharArray()
    private val random = Random()

    /**
     * Losuje string o podanej wielkosc i puli znakow (domyslnie [DEFAULT_POOL])
     *
     * @param size wielkość striga
     * @param pool pula znaków
     *
     * @return wylosowany string
     */
    @JvmStatic
    fun randomString(size: Int, pool: CharArray = DEFAULT_POOL): String
    {
        Validate.isTrue(size >= 0, "Size can't be negative or zero")
        val builder = StringBuilder()

        for (i in 1..size)
        {
            builder.append(pool[random.nextInt(pool.size)])
        }

        return builder.toString()
    }
}

fun String.ltrim(): String
{
    val chars = this.toCharArray()
    var i = 0

    while (i < this.length && chars[i].isWhitespace())
    {
        i++
    }

    return this.substring(i)
}

fun String.rtrim(): String
{
    val chars = this.toCharArray()
    var i = this.length - 1

    while (i >= 0 && chars[i].isWhitespace())
    {
        i--
    }

    return this.substring(0, i + 1)
}

fun String.splitByChar(c: Char): List<String>
{
    val out = mutableListOf<String>()
    val part = StringBuilder()
    val chars = this.toCharArray()

    for (current in chars)
    {
        if (current == c)
        {
            out.add(part.toString())
            part.setLength(0)
        }
        else
        {
            part.append(current)
        }
    }

    out.add(part.toString())

    return out
}