package pl.margoj.server.api.tests

import org.junit.Assert
import org.junit.Test
import pl.margoj.server.api.utils.splitByChar
import java.util.Arrays

class StringUtilsTest
{
    @Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE", "UNUSED_VALUE")
    @Test
    fun testSplit()
    {
        Assert.assertEquals(Arrays.asList("this", "is", "test"), "this|is|test".splitByChar('|'))
        Assert.assertEquals(listOf("thisistest"), "thisistest".splitByChar('|'))
        Assert.assertEquals(Arrays.asList("", "is", ""), "|is|".splitByChar('|'))
        Assert.assertEquals(Arrays.asList("", "is"), "|is".splitByChar('|'))
        Assert.assertEquals(Arrays.asList("is", ""), "is|".splitByChar('|'))

        for (i in 0..99)
        {
            "this|is|test".splitByChar('|')
        }

        val ourStart = System.nanoTime()
        "this|is|test".splitByChar('|')
        val ourEnd = System.nanoTime()

        var out: Array<String>
        for (i in 0..99)
        {
            out = "this|is|test".split("|".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        }

        val javaStart = System.nanoTime()
        out = "this|is|test".split("|".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val javaEnd = System.nanoTime()

        println("Our split: " + (ourEnd - ourStart) + " ns")
        println("Java split: " + (javaEnd - javaStart) + " ns")
    }
}