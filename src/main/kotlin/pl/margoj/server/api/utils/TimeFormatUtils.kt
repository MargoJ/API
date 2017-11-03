package pl.margoj.server.api.utils

import java.util.concurrent.TimeUnit
import java.util.regex.Pattern

object TimeFormatUtils
{
    private val pattern = Pattern.compile("(\\d+)([dhms])?")
    private val SECOND_TO_MILLIS = TimeUnit.SECONDS.toMillis(1L)
    private val MINUTES_TO_MILLIS = TimeUnit.MINUTES.toMillis(1L)
    private val HOURS_TO_MILLIS = TimeUnit.HOURS.toMillis(1L)
    private val DAYS_TO_MILLIS = TimeUnit.DAYS.toMillis(1L)

    /**
     * Zamienia skrotową forme zapisu czasu na milisekundy np. 1m2s -> 62000
     */
    @JvmStatic
    fun parseTime(time: String): Long
    {
        val matcher = pattern.matcher(time)
        var total = 0L

        while (matcher.find())
        {
            val number = matcher.group(1).toLongOrNull() ?: continue
            val modifier = matcher.group(2)
            val multiplier = when (modifier)
            {
                "s" -> SECOND_TO_MILLIS
                "m" -> MINUTES_TO_MILLIS
                "h" -> HOURS_TO_MILLIS
                "d" -> DAYS_TO_MILLIS
                else -> SECOND_TO_MILLIS
            }

            total += number * multiplier
        }

        return total
    }

    /**
     * Zamienia milisekundy w czytelny format np 62000 -> 1 minuta 2 sekundy
     */
    @JvmStatic
    fun getReadableTime(time: Long, accusative: Boolean = false): String
    {
        val out = StringBuilder()
        var seconds = time / 1000L

        fun processTimePart(convert: (Long) -> Long, unit: TimeUnit, form1: String, form2: String, form3: String, accusativeForm: String)
        {
            val converted = convert(seconds)

            if (converted > 0)
            {
                out.append(converted).append(" ")
                if (converted == 1L)
                {
                    out.append(if(accusative) accusativeForm else form1)
                }
                else
                {
                    val lastDigit = converted % 10
                    val nearLastDigit = (converted % 100) / 10

                    if(lastDigit in 2..4L)
                    {
                        if (nearLastDigit == 1L)
                        {
                            out.append(form3)
                        }
                        else
                        {
                            out.append(form2)
                        }
                    }
                    else
                    {
                        out.append(form3)
                    }
                }


                out.append(" ")

                seconds -= unit.toSeconds(converted)
            }
        }

        processTimePart(TimeUnit.SECONDS::toDays, TimeUnit.DAYS, "dzień", "dni", "dni", "dzień")
        processTimePart(TimeUnit.SECONDS::toHours, TimeUnit.HOURS, "godzina", "godziny", "godzin", "godzinę")
        processTimePart(TimeUnit.SECONDS::toMinutes, TimeUnit.MINUTES, "minuta", "minuty", "minut", "minutę")
        processTimePart({ it }, TimeUnit.SECONDS, "sekunda", "sekundy", "sekund", "sekundę")

        if (out.isNotEmpty())
        {
            out.setLength(out.length - 1)
        }

        return out.toString()
    }
}

fun String.toTime(): Long
{
    return TimeFormatUtils.parseTime(this)
}