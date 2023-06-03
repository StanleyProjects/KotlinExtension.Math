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
            pointOf(x = 1.234, y = 5.67).toString(points = -1)
        }
    }

    @Test
    fun eqTest() {
        val actual = pointOf(x = 1.23, y = 5.67)
        Assertions.assertTrue(actual.eq(other = pointOf(x = 1.0, y = 5.0), points = 0))
        Assertions.assertTrue(actual.eq(other = pointOf(x = 1.2, y = 5.6), points = 0))
        Assertions.assertTrue(actual.eq(other = pointOf(x = 1.23, y = 5.67), points = 0))
        Assertions.assertTrue(actual.eq(other = pointOf(x = 1.2, y = 5.6), points = 1))
        Assertions.assertTrue(actual.eq(other = pointOf(x = 1.23, y = 5.67), points = 1))
        Assertions.assertTrue(actual.eq(other = pointOf(x = 1.23, y = 5.67), points = 2))
        Assertions.assertTrue(actual.eq(other = pointOf(x = 1.2356789, y = 5.67891234), points = 0))
        Assertions.assertTrue(actual.eq(other = pointOf(x = 1.2356789, y = 5.67891234), points = 1))
        Assertions.assertTrue(actual.eq(other = pointOf(x = 1.2356789, y = 5.67891234), points = 2))
    }

    @Test
    fun eqNotTest() {
        val actual = pointOf(x = 1.23, y = 5.67)
        Assertions.assertFalse(actual.eq(other = pointOf(x = -1.23, y = 5.67), points = 0))
        Assertions.assertFalse(actual.eq(other = pointOf(x = 1.23, y = -5.67), points = 0))
        Assertions.assertFalse(actual.eq(other = pointOf(x = 1.23, y = 5.67891234), points = 3))
        Assertions.assertFalse(actual.eq(other = pointOf(x = 1.2356789, y = 5.67), points = 3))
        Assertions.assertFalse(actual.eq(other = pointOf(x = 1.2356789, y = 5.67891234), points = 3))
        Assertions.assertFalse(actual.eq(other = pointOf(x = 1.2356789, y = 5.67891234), points = 4))
        Assertions.assertFalse(actual.eq(other = pointOf(x = 1.2356789, y = 5.67891234), points = 8))
    }

    @Test
    fun eqErrorTest() {
        Assertions.assertThrows(IllegalStateException::class.java) {
            @Suppress("IgnoredReturnValue")
            pointOf(x = 1.234, y = 5.67).eq(other = pointOf(x = 1.23, y = 5.67), points = -1)
        }
    }
}
