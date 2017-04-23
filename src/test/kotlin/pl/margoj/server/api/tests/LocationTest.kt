package pl.margoj.server.api.tests

import org.junit.Assert
import org.junit.Test
import pl.margoj.server.api.map.ImmutableLocation
import pl.margoj.server.api.map.Location

class LocationTest
{
    @Test
    fun testMutability()
    {
        val loc1 = Location(null, 1, 2)
        val loc2 = loc1.copy()
        val loc3 = loc2.copyImmutable()

        loc1.x = 55
        loc1.y = 12

        Assert.assertTrue("Original location hasn't been changed", loc1.x == 55 && loc1.y == 12)
        Assert.assertTrue("Cloned location has been changed", loc2.x == 1 && loc2.y == 2)
        Assert.assertTrue("Cloned immutable location has been changed", loc3.x == 1 && loc3.y == 2)
        Assert.assertTrue("Cloned immutable location isn't immutable", loc3 is ImmutableLocation)

        loc1.copyValuesTo(loc2)

        Assert.assertTrue("Target location hasn't been changed", loc2.x == 55 && loc2.y == 12)

        try
        {
            loc1.copyValuesTo(loc3)
            Assert.fail("Modified immutable location")
        }
        catch (ignored: UnsupportedOperationException)
        {
        }
    }

    @Test
    fun testNear()
    {
        val location = Location(null, 50, 50)

        Assert.assertTrue(location.isNear(Location(null, 50, 49)))
        Assert.assertTrue(location.isNear(Location(null, 50, 51)))
        Assert.assertTrue(location.isNear(Location(null, 49, 50)))
        Assert.assertTrue(location.isNear(Location(null, 51, 50)))

        Assert.assertFalse(location.isNear(Location(null, 51, 51)))
        Assert.assertFalse(location.isNear(Location(null, 49, 49)))
        Assert.assertFalse(location.isNear(Location(null, 51, 49)))
        Assert.assertFalse(location.isNear(Location(null, 49, 51)))

        Assert.assertTrue(location.isNear(Location(null, 51, 51), true))
        Assert.assertTrue(location.isNear(Location(null, 49, 49), true))
        Assert.assertTrue(location.isNear(Location(null, 51, 49), true))
        Assert.assertTrue(location.isNear(Location(null, 49, 51), true))
    }
}