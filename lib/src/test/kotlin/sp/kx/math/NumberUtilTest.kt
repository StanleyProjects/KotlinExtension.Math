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
    fun eqTest() {
        val actual = 1.23
        Assertions.assertTrue(actual.eq(other = 1.2, points = 1))
        Assertions.assertTrue(actual.eq(other = 1.23, points = 2))
        Assertions.assertTrue(actual.eq(other = 1.234, points = 2))
        Assertions.assertTrue(actual.eq(other = 1.23456789, points = 2))
    }

    @Test
    fun eqDeltaTest() {
        kotlin.math.cos(0.0).also { expected ->
            val actual = 1.0
            Assertions.assertEquals(expected, actual)
            Assertions.assertTrue(actual.eq(other = expected, points = 1))
            Assertions.assertEquals(expected, actual, 0.1)
            Assertions.assertTrue(actual.eq(other = expected, points = 1))
            Assertions.assertEquals(expected, actual, 0.00000001)
            Assertions.assertTrue(actual.eq(other = expected, points = 8))
        }
        kotlin.math.cos(kotlin.math.PI / 4).also { expected ->
            val actual = 0.70710678 // 0.7071067811865476
            Assertions.assertEquals(expected, actual, 0.1)
            Assertions.assertTrue(actual.eq(other = expected, points = 1))
            Assertions.assertEquals(expected, actual, 0.00000001)
            Assertions.assertTrue(actual.eq(other = expected, points = 8))
        }
        kotlin.math.cos(kotlin.math.PI / 2).also { expected ->
            val actual = 0.00000000000000006 // 0.00000000000000006123233995736766
            Assertions.assertEquals(expected, actual, 0.1)
            Assertions.assertTrue(actual.eq(other = expected, points = 1))
            Assertions.assertEquals(expected, actual, 0.00000000000000001)
            Assertions.assertTrue(actual.eq(other = expected, points = 17))
        }
        kotlin.math.cos(kotlin.math.PI / 2 + kotlin.math.PI / 4).also { expected ->
            val actual = -0.70710678 // -0.7071067811865476
            Assertions.assertEquals(expected, actual, 0.1)
            Assertions.assertTrue(actual.eq(other = expected, points = 1))
            Assertions.assertEquals(expected, actual, 0.00000001)
            Assertions.assertTrue(actual.eq(other = expected, points = 8))
        }
        kotlin.math.cos(kotlin.math.PI).also { expected ->
            val actual = -1.0
            Assertions.assertEquals(expected, actual)
            Assertions.assertTrue(actual.eq(other = expected, points = 1))
            Assertions.assertEquals(expected, actual, 0.1)
            Assertions.assertTrue(actual.eq(other = expected, points = 1))
            Assertions.assertEquals(expected, actual, 0.00000001)
            Assertions.assertTrue(actual.eq(other = expected, points = 8))
        }
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
        Assertions.assertFalse(actual.eq(other = 2.0, points = 1))
    }

    @Test
    fun eqNotDeltaTest() {
        kotlin.math.cos(0.0).also { expected ->
            val actual = 1.1
            Assertions.assertEquals(expected, actual, 0.2)
            Assertions.assertNotEquals(expected, actual, 0.01)
            Assertions.assertFalse(actual.eq(other = expected, points = 1))
            Assertions.assertNotEquals(expected, actual, 0.00000001)
            Assertions.assertFalse(actual.eq(other = expected, points = 8))
        }
        kotlin.math.cos(kotlin.math.PI / 4).also { expected ->
            val actual = 0.70710678 // 0.7071067811865476
            Assertions.assertEquals(expected, actual, 0.1)
            Assertions.assertTrue(actual.eq(other = expected, points = 1))
            Assertions.assertNotEquals(expected, actual, 0.000000001)
            Assertions.assertFalse(actual.eq(other = expected, points = 9))
        }
        kotlin.math.cos(kotlin.math.PI / 2).also { expected ->
            val actual = 0.00000000000000006 // 0.00000000000000006123233995736766
            Assertions.assertEquals(expected, actual, 0.1)
            Assertions.assertTrue(actual.eq(other = expected, points = 1))
            Assertions.assertNotEquals(expected, actual, 0.000000000000000001)
            Assertions.assertFalse(actual.eq(other = expected, points = 18))
        }
        kotlin.math.cos(kotlin.math.PI / 2 + kotlin.math.PI / 4).also { expected ->
            val actual = -0.70710678 // -0.7071067811865476
            Assertions.assertEquals(expected, actual, 0.1)
            Assertions.assertTrue(actual.eq(other = expected, points = 1))
            Assertions.assertNotEquals(expected, actual, 0.000000001)
            Assertions.assertFalse(actual.eq(other = expected, points = 9))
        }
        kotlin.math.cos(kotlin.math.PI).also { expected ->
            val actual = -1.1
            Assertions.assertEquals(expected, actual, 0.2)
            Assertions.assertNotEquals(expected, actual, 0.01)
            Assertions.assertFalse(actual.eq(other = expected, points = 1))
            Assertions.assertNotEquals(expected, actual, 0.00000001)
            Assertions.assertFalse(actual.eq(other = expected, points = 8))
        }
    }

    @Test
    fun eqErrorTest() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            @Suppress("IgnoredReturnValue")
            1.2.eq(other = 3.4, points = -1)
        }
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            @Suppress("IgnoredReturnValue")
            1.2.eq(other = 3.4, points = 0)
        }
    }

    @Test
    fun ctTest() {
        val actual = kotlin.math.PI * 2 + kotlin.math.PI / 3
        Assertions.assertTrue(actual > kotlin.math.PI * 2)
        val delta = 0.00000000000001
        Assertions.assertEquals(kotlin.math.PI / 3, actual.ct(), delta)
        Assertions.assertEquals(kotlin.math.PI / 3, (kotlin.math.PI * 2 + actual).ct(), delta)
        Assertions.assertEquals(kotlin.math.PI / 3, (kotlin.math.PI * 4 + actual).ct(), delta)
    }

    @Test
    fun ctNegativeTest() {
        val actual = - kotlin.math.PI / 3
        Assertions.assertTrue(actual < 0)
        val delta = 0.00000000000001
        Assertions.assertEquals(kotlin.math.PI * 2 - kotlin.math.PI / 3, actual.ct(), delta)
        Assertions.assertEquals(kotlin.math.PI * 2 - kotlin.math.PI / 3, (kotlin.math.PI * 2 + actual).ct(), delta)
        Assertions.assertEquals(kotlin.math.PI * 2 - kotlin.math.PI / 3, (kotlin.math.PI * 4 + actual).ct(), delta)
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
}
