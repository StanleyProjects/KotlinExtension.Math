package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.absoluteValue
import kotlin.math.pow

@Suppress("MagicNumber")
internal class NumberUtilEqTest {
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
        0.00010001.also { other ->
            val value = 0.0001
            Assertions.assertTrue(value.eq(other = other, points = 1))
            Assertions.assertTrue(value.eq(other = other, points = 2))
            Assertions.assertTrue(value.eq(other = other, points = 4))
            assertNotEquals(value = (value - other).absoluteValue, other = 10.0.pow(-4), points = 4)
            assertNotEquals(value = value, other = other, points = 8)
        }
        kotlin.math.cos(0.0).also { expected ->
            val actual = 1.0
            Assertions.assertEquals(expected, actual)
            Assertions.assertTrue(actual.eq(other = expected, points = 1)) {
                """
                    points: 1
                    a: ${actual.toString(points = 32)}(${actual.toString(points = 1)})
                    e: ${expected.toString(points = 32)}(${expected.toString(points = 1)})
                """.trimIndent()
            }
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

    companion object {
        private fun assertNotEquals(
            value: Double,
            other: Double,
            points: Int,
        ) {
            val message = """
                points: $points
                value: ${value.toString(points = 32)}(${value.toString(points = points)})
                other: ${other.toString(points = 32)}(${other.toString(points = points)})
                value == other: ${value == other}
            """.trimIndent()
//            Assertions.assertNotEquals(other, value, 10.0.pow(-points)) {
//                message
//            }
            Assertions.assertFalse(value.eq(other = other, points = points)) {
                message
            }
        }
    }
}
