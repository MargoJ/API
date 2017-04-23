package pl.margoj.server.api.tests

import org.junit.Assert
import org.junit.Test
import pl.margoj.server.api.utils.GoldUtils

class GameTest
{
    @Test
    fun testGold()
    {
        Assert.assertEquals(754321L, GoldUtils.parseGold("754321"))
        Assert.assertEquals(2_000L, GoldUtils.parseGold("2k"))
        Assert.assertEquals(777_000L, GoldUtils.parseGold("777k"))
        Assert.assertEquals(1_000_000L, GoldUtils.parseGold("1m"))
        Assert.assertEquals(124_000_000L, GoldUtils.parseGold("124m"))
        Assert.assertEquals(125_000_000L, GoldUtils.parseGold("125kk"))
        Assert.assertEquals(3_000_000_000L, GoldUtils.parseGold("3g"))
        Assert.assertEquals(323_000_000_000L, GoldUtils.parseGold("323g"))
        Assert.assertEquals(643_000_000_000L, GoldUtils.parseGold("643mm"))
        Assert.assertEquals(12_000_000_000L, GoldUtils.parseGold("12kkk"))

        Assert.assertEquals(1500L, GoldUtils.parseGold("1.5k"))
        Assert.assertEquals(17_465_432_000L, GoldUtils.parseGold("17.465432g"))
    }
}