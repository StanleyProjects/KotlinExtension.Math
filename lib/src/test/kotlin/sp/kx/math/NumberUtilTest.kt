package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class NumberUtilTest {
    @Test
    fun toStringTest() {
        val actual = 1.234567
        Assertions.assertEquals("1", actual.toString(points = 0))
        Assertions.assertEquals("1.2", actual.toString(points = 1))
        Assertions.assertEquals("1.23", actual.toString(points = 2))
        Assertions.assertEquals("1.235", actual.toString(points = 3))
        Assertions.assertEquals("1.2346", actual.toString(points = 4))
        Assertions.assertEquals("1.23457", actual.toString(points = 5))
        Assertions.assertEquals("1.234567", actual.toString(points = 6))
        Assertions.assertEquals("1.2345670", actual.toString(points = 7))
        Assertions.assertEquals("1.23456700", actual.toString(points = 8))
    }

    @Test
    fun toStringErrorTest() {
        Assertions.assertThrows(IllegalStateException::class.java) {
            @Suppress("IgnoredReturnValue")
            1.234.toString(points = -1)
        }
    }

    @Test
    fun eqTest() {
        val actual = 1.23
        Assertions.assertTrue(actual.eq(other = 1.0, points = 0))
        Assertions.assertTrue(actual.eq(other = 1.2, points = 1))
        Assertions.assertTrue(actual.eq(other = 1.23, points = 2))
        Assertions.assertTrue(actual.eq(other = 1.234, points = 2))
        Assertions.assertTrue(actual.eq(other = 1.23456789, points = 2))
    }

    @Test
    fun eqNotTest() {
        val actual = 1.23
        Assertions.assertFalse(actual.eq(other = 1.0, points = 1))
        Assertions.assertFalse(actual.eq(other = 1.2, points = 2))
        Assertions.assertFalse(actual.eq(other = -1.23, points = 2))
        Assertions.assertFalse(actual.eq(other = 1.234, points = 3))
        Assertions.assertFalse(actual.eq(other = 1.23456789, points = 3))
        Assertions.assertFalse(actual.eq(other = 1.23456789, points = 4))
        Assertions.assertFalse(actual.eq(other = 1.23456789, points = 8))
    }

    @Test
    fun eqErrorTest() {
        Assertions.assertThrows(IllegalStateException::class.java) {
            @Suppress("IgnoredReturnValue")
            1.2.eq(other = 3.4, points = -1)
        }
    }
}
