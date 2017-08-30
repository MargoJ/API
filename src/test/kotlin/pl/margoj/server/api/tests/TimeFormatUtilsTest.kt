package pl.margoj.server.api.tests

import org.junit.Assert
import org.junit.Test
import pl.margoj.server.api.utils.TimeFormatUtils
import java.util.Random
import java.util.concurrent.TimeUnit

class TimeFormatUtilsTest
{
    @Test
    fun testParseTime()
    {
        Assert.assertEquals(TimeFormatUtils.parseTime("1"), TimeUnit.SECONDS.toMillis(1))
        Assert.assertEquals(TimeFormatUtils.parseTime("1s"), TimeUnit.SECONDS.toMillis(1))
        Assert.assertEquals(TimeFormatUtils.parseTime("1m"), TimeUnit.MINUTES.toMillis(1))
        Assert.assertEquals(TimeFormatUtils.parseTime("1h"), TimeUnit.HOURS.toMillis(1))
        Assert.assertEquals(TimeFormatUtils.parseTime("1d"), TimeUnit.DAYS.toMillis(1))

        val random = Random()
        var rand = 0L
        fun random()
        {
            rand = random.nextInt(100_000).toLong()
        }

        random()
        Assert.assertEquals(TimeFormatUtils.parseTime("$rand"), TimeUnit.SECONDS.toMillis(rand))
        random()
        Assert.assertEquals(TimeFormatUtils.parseTime("${rand}s"), TimeUnit.SECONDS.toMillis(rand))
        random()
        Assert.assertEquals(TimeFormatUtils.parseTime("${rand}h"), TimeUnit.HOURS.toMillis(rand))
        random()
        Assert.assertEquals(TimeFormatUtils.parseTime("${rand}d"), TimeUnit.DAYS.toMillis(rand))
        random()
        Assert.assertEquals(TimeFormatUtils.parseTime("${rand}m"), TimeUnit.MINUTES.toMillis(rand))

        var test = 0L
        var str = ""

        random()
        test += TimeUnit.DAYS.toMillis(rand)
        str += "${rand}d"

        random()
        test += TimeUnit.HOURS.toMillis(rand)
        str += "${rand}h"

        random()
        test += TimeUnit.MINUTES.toMillis(rand)
        str += "${rand}m"

        random()
        test += TimeUnit.SECONDS.toMillis(rand)
        str += "${rand}s"

        Assert.assertEquals(TimeFormatUtils.parseTime(str), test)
    }

    @Test
    fun testToReadableString()
    {
        fun assert(format: String, expected: String)
        {
            Assert.assertEquals(expected, TimeFormatUtils.getReadableTime(TimeFormatUtils.parseTime(format)))
        }

        assert("1s", "1 sekunda")
        assert("1m", "1 minuta")
        assert("1h", "1 godzina")
        assert("1d", "1 dzień")

        assert("2m", "2 minuty")
        assert("3m", "3 minuty")
        assert("4m", "4 minuty")
        assert("5m", "5 minut")
        assert("6m", "6 minut")

        assert("10m", "10 minut")
        assert("11m", "11 minut")
        assert("12m", "12 minut")

        assert("161d17h58m1s", "161 dni 17 godzin 58 minut 1 sekunda")
        assert("11s", "11 sekund")
        assert("21s", "21 sekund")
        assert("12s", "12 sekund")
        assert("22s", "22 sekundy")
        assert("27m", "27 minut")
        assert("24m", "24 minuty")
    }
}