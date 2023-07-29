package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber", "StringLiteralDuplication")
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
    fun toStringFractionalTest() {
        val actual = 1.234567
        Assertions.assertEquals("1", actual.toString(total = 1, points = 0))
        Assertions.assertEquals("01", actual.toString(total = 2, points = 0))
        Assertions.assertEquals("001", actual.toString(total = 3, points = 0))
        Assertions.assertEquals("1.2", actual.toString(total = 2, points = 1))
        Assertions.assertEquals("1.2", actual.toString(total = 3, points = 1))
        Assertions.assertEquals("01.2", actual.toString(total = 4, points = 1))
        Assertions.assertEquals("001.2", actual.toString(total = 5, points = 1))
        Assertions.assertEquals("0001.2", actual.toString(total = 6, points = 1))
        Assertions.assertEquals("1.23", actual.toString(total = 3, points = 2))
        Assertions.assertEquals("1.23", actual.toString(total = 4, points = 2))
        Assertions.assertEquals("1.235", actual.toString(total = 4, points = 3))
        Assertions.assertEquals("1.235", actual.toString(total = 5, points = 3))
        Assertions.assertEquals("1.2346", actual.toString(total = 5, points = 4))
        Assertions.assertEquals("1.2346", actual.toString(total = 6, points = 4))
        Assertions.assertEquals("1.23457", actual.toString(total = 6, points = 5))
        Assertions.assertEquals("1.23457", actual.toString(total = 7, points = 5))
        Assertions.assertEquals("1.234567", actual.toString(total = 7, points = 6))
        Assertions.assertEquals("1.234567", actual.toString(total = 8, points = 6))
        Assertions.assertEquals("1.2345670", actual.toString(total = 8, points = 7))
        Assertions.assertEquals("1.2345670", actual.toString(total = 9, points = 7))
        Assertions.assertEquals("1.23456700", actual.toString(total = 9, points = 8))
        Assertions.assertEquals("1.23456700", actual.toString(total = 10, points = 8))
        Assertions.assertEquals("1.234567000", actual.toString(total = 10, points = 9))
        Assertions.assertEquals("1.234567000", actual.toString(total = 11, points = 9))
        Assertions.assertEquals("0001.234567000", actual.toString(total = 14, points = 9))
    }

    @Test
    fun toStringFractionalErrorTest() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            @Suppress("IgnoredReturnValue")
            1.2.toString(total = 0, points = -1)
        }
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            @Suppress("IgnoredReturnValue")
            1.2.toString(total = 0, points = 0)
        }
        Assertions.assertThrows(IllegalStateException::class.java) {
            @Suppress("IgnoredReturnValue")
            1.2.toString(total = 1, points = -1)
        }
    }

    @Test
    fun radiansTest() {
        val actual = kotlin.math.PI * 2 + kotlin.math.PI / 3
        Assertions.assertTrue(actual > kotlin.math.PI * 2)
        val delta = 0.00000000000001
        Assertions.assertEquals(kotlin.math.PI / 3, actual.radians(), delta)
        Assertions.assertEquals(kotlin.math.PI / 3, (kotlin.math.PI * 2 + actual).radians(), delta)
        Assertions.assertEquals(kotlin.math.PI / 3, (kotlin.math.PI * 4 + actual).radians(), delta)
    }

    @Test
    fun radiansNegativeTest() {
        val actual = -kotlin.math.PI / 3
        Assertions.assertTrue(actual < 0)
        val delta = 0.00000000000001
        Assertions.assertEquals(kotlin.math.PI * 2 - kotlin.math.PI / 3, actual.radians(), delta)
        Assertions.assertEquals(kotlin.math.PI * 2 - kotlin.math.PI / 3, (kotlin.math.PI * 2 + actual).radians(), delta)
        Assertions.assertEquals(kotlin.math.PI * 2 - kotlin.math.PI / 3, (kotlin.math.PI * 4 + actual).radians(), delta)
    }

    @Test
    fun ctKTest() {
        val k = 128.0
        val value = 42.0
        val actual = k + k + value
        Assertions.assertEquals(value, actual.ct(k = k))
        Assertions.assertEquals(value, (k + actual).ct(k = k))
        Assertions.assertEquals(value, (k * 2 + actual).ct(k = k))
        Assertions.assertEquals(value, (k * 3 + actual).ct(k = k))
        Assertions.assertEquals(value, (k * 4 + actual).ct(k = k))
    }

    @Test
    fun ctKNegativeTest() {
        val k = 128.0
        val value = 42.0
        val actual = -value
        Assertions.assertEquals(k - value, actual.ct(k = k))
        Assertions.assertEquals(k - value, (k + actual).ct(k = k))
        Assertions.assertEquals(k - value, (k * 2 + actual).ct(k = k))
        Assertions.assertEquals(k - value, (k * 3 + actual).ct(k = k))
        Assertions.assertEquals(k - value, (k * 4 + actual).ct(k = k))
    }

    @Test
    fun divAbsTest() {
        Assertions.assertEquals(1.0, 1.0.divAbs())
        Assertions.assertEquals(-1.0, (-1.0).divAbs())
        Assertions.assertEquals(1.0, 5.0.divAbs())
        Assertions.assertEquals(-1.0, (-42.0).divAbs())
        Assertions.assertEquals(1.0, Double.MAX_VALUE.divAbs())
        Assertions.assertEquals(1.0, Double.MIN_VALUE.divAbs())
        Assertions.assertEquals(-1.0, (-Double.MIN_VALUE).divAbs())
        Assertions.assertEquals(-1.0, (-Double.MAX_VALUE).divAbs())
        Assertions.assertTrue(Double.NaN.divAbs().isNaN())
        Assertions.assertTrue(Double.POSITIVE_INFINITY.divAbs().isNaN())
        Assertions.assertTrue(Double.NEGATIVE_INFINITY.divAbs().isNaN())
    }

    @Test
    fun orNullTest() {
        Assertions.assertNotNull(Double.NEGATIVE_INFINITY.orNull())
        Assertions.assertNotNull(0.0.orNull())
        Assertions.assertNotNull(Double.MIN_VALUE.orNull())
        Assertions.assertNotNull(1.0.orNull())
        Assertions.assertNotNull(42.0.orNull())
        Assertions.assertNotNull(Double.MAX_VALUE.orNull())
        Assertions.assertNotNull(Double.POSITIVE_INFINITY.orNull())
        Assertions.assertNull(Double.NaN.orNull())
    }

    @Test
    fun orDefaultTest() {
        Assertions.assertEquals(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY.orDefault())
        Assertions.assertEquals(0.0, 0.0.orDefault())
        Assertions.assertEquals(Double.MIN_VALUE, Double.MIN_VALUE.orDefault())
        Assertions.assertEquals(1.0, 1.0.orDefault())
        Assertions.assertEquals(42.0, 42.0.orDefault())
        Assertions.assertEquals(Double.MAX_VALUE, Double.MAX_VALUE.orDefault())
        Assertions.assertEquals(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY.orDefault())
        Assertions.assertEquals(Double.NEGATIVE_INFINITY, Double.NaN.orDefault(Double.NEGATIVE_INFINITY))
        Assertions.assertEquals(-1.0, Double.NaN.orDefault(-1.0))
        Assertions.assertEquals(0.0, Double.NaN.orDefault())
        Assertions.assertEquals(0.0, Double.NaN.orDefault(0.0))
        Assertions.assertEquals(Double.MIN_VALUE, Double.NaN.orDefault(Double.MIN_VALUE))
        Assertions.assertEquals(1.0, Double.NaN.orDefault(1.0))
        Assertions.assertEquals(42.0, Double.NaN.orDefault(42.0))
        Assertions.assertEquals(Double.MAX_VALUE, Double.NaN.orDefault(Double.MAX_VALUE))
        Assertions.assertEquals(Double.POSITIVE_INFINITY, Double.NaN.orDefault(Double.POSITIVE_INFINITY))
        Assertions.assertTrue(Double.NaN.orDefault(Double.NaN).isNaN())
    }
}
