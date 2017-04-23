package pl.margoj.server.api.utils

import java.util.regex.Pattern

object GoldUtils
{
    private val pattern = Pattern.compile("([\\d,.]+)(k|m|kk|g|mm|kkk)?")

    fun parseGold(str: String): Long?
    {
        val matcher = pattern.matcher(str)
        if(!matcher.matches())
        {
            return null
        }
        val modifier = matcher.group(2) ?: return Parse.parseLong(matcher.group(1))

        val number: Double
        try
        {
            number = matcher.group(1).replace(',', '.').toDouble()
        }
        catch (e: NumberFormatException)
        {
            return null
        }

        when(modifier) {
            "k" -> return Math.floor(number * 1_000f).toLong()
            "m", "kk" -> return Math.floor(number * 1_000_000f).toLong()
            "g", "mm", "kkk" -> return Math.floor(number * 1_000_000_000f).toLong()
            else -> return null
        }
    }
}