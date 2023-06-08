package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class OffsetUtilTest {
    @Test
    fun toStringTest() {
        val actual = offsetOf(dX = 1.234, dY = 5.67)
        Assertions.assertEquals("{dX: 1, dY: 6}", actual.toString(points = 0))
        Assertions.assertEquals("{dX: 1.2, dY: 5.7}", actual.toString(points = 1))
        Assertions.assertEquals("{dX: 1.23, dY: 5.67}", actual.toString(points = 2))
        Assertions.assertEquals("{dX: 1.234, dY: 5.670}", actual.toString(points = 3))
        Assertions.assertEquals("{dX: 1.23400000, dY: 5.67000000}", actual.toString(points = 8))
    }

    @Test
    fun toStringErrorTest() {
        Assertions.assertThrows(IllegalStateException::class.java) {
            @Suppress("IgnoredReturnValue")
            offsetOf(dX = 1.2, dY = 5.6).toString(points = -1)
        }
    }

    @Test
    fun eqTest() {
        val actual = offsetOf(dX = 1.234, dY = 5.67)
        Assertions.assertTrue(actual.eq(other = offsetOf(dX = 1.2, dY = 5.6), points = 1))
        Assertions.assertTrue(actual.eq(other = offsetOf(dX = 1.23, dY = 5.67), points = 1))
        Assertions.assertTrue(actual.eq(other = offsetOf(dX = 1.23, dY = 5.67), points = 2))
        Assertions.assertTrue(actual.eq(other = offsetOf(dX = 1.2356789, dY = 5.67891234), points = 1))
        Assertions.assertTrue(actual.eq(other = offsetOf(dX = 1.2356789, dY = 5.67891234), points = 2))
    }

    @Test
    fun eqNotTest() {
        val actual = offsetOf(dX = 1.234, dY = 5.67)
        Assertions.assertFalse(actual.eq(other = offsetOf(dX = -1.23, dY = 5.67), points = 1))
        Assertions.assertFalse(actual.eq(other = offsetOf(dX = 1.23, dY = -5.67), points = 1))
        Assertions.assertFalse(actual.eq(other = offsetOf(dX = 1.23, dY = 5.67891234), points = 3))
        Assertions.assertFalse(actual.eq(other = offsetOf(dX = 1.2356789, dY = 5.67), points = 3))
        Assertions.assertFalse(actual.eq(other = offsetOf(dX = 1.2356789, dY = 5.67891234), points = 3))
        Assertions.assertFalse(actual.eq(other = offsetOf(dX = 1.2356789, dY = 5.67891234), points = 4))
        Assertions.assertFalse(actual.eq(other = offsetOf(dX = 1.2356789, dY = 5.67891234), points = 8))
    }

    @Test
    fun eqErrorTest() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            @Suppress("IgnoredReturnValue")
            offsetOf(dX = 1.2, dY = 5.6).eq(other = offsetOf(dX = 1.2, dY = 5.6), points = -1)
        }
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            @Suppress("IgnoredReturnValue")
            offsetOf(dX = 1.2, dY = 5.6).eq(other = offsetOf(dX = 1.2, dY = 5.6), points = 0)
        }
    }

    @Test
    fun copyTest() {
        val foo = offsetOf(dX = 1.2, dY = 3.4)
        Assertions.assertNotEquals(foo.dX, foo.dY)
        Assertions.assertEquals(1.2, foo.dX)
        Assertions.assertEquals(3.4, foo.dY)
        foo.copy().also { bar ->
            Assertions.assertFalse(foo === bar)
            Assertions.assertEquals(foo, bar)
        }
        foo.copy(dX = 5.6).also { bar ->
            Assertions.assertFalse(foo === bar)
            Assertions.assertNotEquals(foo, bar)
            Assertions.assertEquals(5.6, bar.dX)
            Assertions.assertEquals(foo.dY, bar.dY)
        }
        foo.copy(dY = 5.6).also { bar ->
            Assertions.assertFalse(foo === bar)
            Assertions.assertNotEquals(foo, bar)
            Assertions.assertEquals(foo.dX, bar.dX)
            Assertions.assertEquals(5.6, bar.dY)
        }
        foo.copy(dX = 5.6, dY = 7.8).also { bar ->
            Assertions.assertFalse(foo === bar)
            Assertions.assertNotEquals(foo, bar)
            Assertions.assertEquals(5.6, bar.dX)
            Assertions.assertEquals(7.8, bar.dY)
        }
    }

    @Test
    fun swappedTest() {
        val foo = offsetOf(dX = 1.2, dY = 3.4)
        Assertions.assertNotEquals(foo.dX, foo.dY)
        Assertions.assertEquals(1.2, foo.dX)
        Assertions.assertEquals(3.4, foo.dY)
        foo.swapped().also { bar ->
            Assertions.assertFalse(foo === bar)
            Assertions.assertNotEquals(foo, bar)
            Assertions.assertNotEquals(foo.dX, bar.dX)
            Assertions.assertEquals(foo.dX, bar.dY)
            Assertions.assertNotEquals(foo.dY, bar.dY)
            Assertions.assertEquals(foo.dY, bar.dX)
        }
    }
}
