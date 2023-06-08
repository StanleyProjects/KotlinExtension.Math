package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class PointUtilTest {
    @Test
    fun toStringTest() {
        val actual = pointOf(x = 1.234, y = 5.67)
        Assertions.assertEquals("{x: 1, y: 6}", actual.toString(points = 0))
        Assertions.assertEquals("{x: 1.2, y: 5.7}", actual.toString(points = 1))
        Assertions.assertEquals("{x: 1.23, y: 5.67}", actual.toString(points = 2))
        Assertions.assertEquals("{x: 1.234, y: 5.670}", actual.toString(points = 3))
        Assertions.assertEquals("{x: 1.23400000, y: 5.67000000}", actual.toString(points = 8))
    }

    @Test
    fun toStringErrorTest() {
        Assertions.assertThrows(IllegalStateException::class.java) {
            @Suppress("IgnoredReturnValue")
            pointOf(x = 1.2, y = 5.6).toString(points = -1)
        }
    }

    @Test
    fun eqTest() {
        val actual = pointOf(x = 1.23, y = 5.67)
        Assertions.assertTrue(actual.eq(other = pointOf(x = 1.2, y = 5.6), points = 1))
        Assertions.assertTrue(actual.eq(other = pointOf(x = 1.23, y = 5.67), points = 1))
        Assertions.assertTrue(actual.eq(other = pointOf(x = 1.23, y = 5.67), points = 2))
        Assertions.assertTrue(actual.eq(other = pointOf(x = 1.2356789, y = 5.67891234), points = 1))
        Assertions.assertTrue(actual.eq(other = pointOf(x = 1.2356789, y = 5.67891234), points = 2))
    }

    @Test
    fun eqNotTest() {
        val actual = pointOf(x = 1.23, y = 5.67)
        Assertions.assertFalse(actual.eq(other = pointOf(x = -1.23, y = 5.67), points = 1))
        Assertions.assertFalse(actual.eq(other = pointOf(x = 1.23, y = -5.67), points = 1))
        Assertions.assertFalse(actual.eq(other = pointOf(x = 1.23, y = 5.67891234), points = 3))
        Assertions.assertFalse(actual.eq(other = pointOf(x = 1.2356789, y = 5.67), points = 3))
        Assertions.assertFalse(actual.eq(other = pointOf(x = 1.2356789, y = 5.67891234), points = 3))
        Assertions.assertFalse(actual.eq(other = pointOf(x = 1.2356789, y = 5.67891234), points = 4))
        Assertions.assertFalse(actual.eq(other = pointOf(x = 1.2356789, y = 5.67891234), points = 8))
    }

    @Test
    fun eqErrorTest() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            @Suppress("IgnoredReturnValue")
            pointOf(x = 1.2, y = 5.6).eq(other = pointOf(x = 1.2, y = 5.6), points = -1)
        }
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            @Suppress("IgnoredReturnValue")
            pointOf(x = 1.2, y = 5.6).eq(other = pointOf(x = 1.2, y = 5.6), points = 0)
        }
    }

    @Test
    fun copyTest() {
        val foo = pointOf(x = 1.2, y = 3.4)
        Assertions.assertNotEquals(foo.x, foo.y)
        Assertions.assertEquals(1.2, foo.x)
        Assertions.assertEquals(3.4, foo.y)
        foo.copy().also { bar ->
            Assertions.assertFalse(foo === bar)
            Assertions.assertEquals(foo, bar)
        }
        foo.copy(x = 5.6).also { bar ->
            Assertions.assertFalse(foo === bar)
            Assertions.assertEquals(5.6, bar.x)
            Assertions.assertEquals(foo.y, bar.y)
        }
        foo.copy(y = 5.6).also { bar ->
            Assertions.assertFalse(foo === bar)
            Assertions.assertEquals(foo.x, bar.x)
            Assertions.assertEquals(5.6, bar.y)
        }
        foo.copy(x = 5.6, y = 7.8).also { bar ->
            Assertions.assertFalse(foo === bar)
            Assertions.assertEquals(5.6, bar.x)
            Assertions.assertEquals(7.8, bar.y)
        }
    }

    @Test
    fun swappedTest() {
        val foo = pointOf(x = 1.2, y = 3.4)
        Assertions.assertNotEquals(foo.x, foo.y)
        Assertions.assertEquals(1.2, foo.x)
        Assertions.assertEquals(3.4, foo.y)
        foo.swapped().also { bar ->
            Assertions.assertFalse(foo === bar)
            Assertions.assertNotEquals(foo, bar)
            Assertions.assertNotEquals(bar.x, foo.x)
            Assertions.assertEquals(bar.x, foo.y)
            Assertions.assertNotEquals(bar.y, foo.y)
            Assertions.assertEquals(bar.y, foo.x)
        }
    }
}
