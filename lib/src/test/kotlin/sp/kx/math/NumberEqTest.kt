package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.absoluteValue
import kotlin.math.pow

@Suppress("MagicNumber")
internal class NumberEqTest {
    @Test
    fun eq1Test() {
        val actual = 1.1
        val expected = 1.0
        Assertions.assertEquals(1.0, expected)
        Assertions.assertNotEquals(expected, actual)
        Assertions.assertNotEquals(expected, actual, 0.1)
        assertDoubles(
            value = actual,
            other = expected,
            points = 1,
            equals = false,
        )
        Assertions.assertFalse(actual.eq(other = expected, points = 2))
        Assertions.assertFalse(actual.eq(other = expected, points = 4))
        Assertions.assertFalse(actual.eq(other = expected, points = 8))
        assertDoubles(
            value = actual,
            other = expected,
            points = 16,
            equals = false,
        )
    }

    @Test
    fun eq2Test() {
        val actual = 1.01
        val expected = 1.0
        Assertions.assertEquals(1.0, expected)
        Assertions.assertNotEquals(expected, actual)
        assertDoubles(
            value = actual,
            other = expected,
            points = 1,
            equals = true,
        )
        Assertions.assertEquals(expected, actual, 0.1)
        Assertions.assertNotEquals(expected, actual, 0.01)
        Assertions.assertFalse(actual.eq(other = expected, points = 2))
        Assertions.assertFalse(actual.eq(other = expected, points = 4))
        Assertions.assertFalse(actual.eq(other = expected, points = 8))
        Assertions.assertFalse(actual.eq(other = expected, points = 16))
    }

    @Test
    fun eq3Test() {
        val actual = 1.001
        val expected = 1.0
        Assertions.assertEquals(1.0, expected)
        Assertions.assertNotEquals(actual, expected)
        Assertions.assertTrue(actual.eq(other = expected, points = 1))
        Assertions.assertTrue(actual.eq(other = expected, points = 2))
//        Assertions.assertEquals(expected, actual, 0.001) // ?
        assertDoubles(value = actual, other = expected, points = 3, equals = false)
        Assertions.assertNotEquals(expected, actual, 0.0009)
        Assertions.assertFalse(actual.eq(other = expected, points = 4))
        Assertions.assertFalse(actual.eq(other = expected, points = 8))
        Assertions.assertFalse(actual.eq(other = expected, points = 16))
    }

    @Test
    fun eq4Test() {
        val actual = 1.0001
        val expected = 1.0
        Assertions.assertEquals(1.0, expected)
        Assertions.assertNotEquals(actual, expected)
        Assertions.assertTrue(actual.eq(other = expected, points = 1))
        Assertions.assertTrue(actual.eq(other = expected, points = 2))
        Assertions.assertTrue(actual.eq(other = expected, points = 3))
//        Assertions.assertEquals(expected, actual, 0.0001) // ?
        assertDoubles(value = actual, other = expected, points = 4, equals = false)
        Assertions.assertNotEquals(expected, actual, 0.00009)
        Assertions.assertFalse(actual.eq(other = expected, points = 5))
        Assertions.assertFalse(actual.eq(other = expected, points = 8))
        Assertions.assertFalse(actual.eq(other = expected, points = 16))
    }

    @Test
    fun eq8Test() {
        val actual = 1.00000001
        val expected = 1.0
        Assertions.assertEquals(1.0, expected)
        Assertions.assertNotEquals(actual, expected)
        Assertions.assertTrue(actual.eq(other = expected, points = 1))
        Assertions.assertTrue(actual.eq(other = expected, points = 2))
        Assertions.assertTrue(actual.eq(other = expected, points = 3))
        Assertions.assertTrue(actual.eq(other = expected, points = 4))
//        Assertions.assertEquals(expected, actual, 0.00000001) // ?
        assertDoubles(value = actual, other = expected, points = 8, equals = false)
        Assertions.assertNotEquals(expected, actual, 0.000000009)
        Assertions.assertFalse(actual.eq(other = expected, points = 9))
        Assertions.assertFalse(actual.eq(other = expected, points = 16))
    }

    companion object {
        private fun assertDoubles(value: Double, other: Double, points: Int, equals: Boolean) {
            Assertions.assertEquals(equals, value.eq(other = other, points = points)) {
                val diff = (value - other).absoluteValue
                val delta = 10.0.pow(points)
                """
                    points: $points
                    value: ${value.toString(points = 32)}(${value.toString(points = points)})
                    other: ${other.toString(points = 32)}(${other.toString(points = points)})
                    diff: ${diff.toString(points = 32)}
                    10^$points: ${delta.toString(points = 32)}
                    diff * 10^$points: ${(diff * delta).toString(points = 32)}(${(diff * delta).toInt()})
                """.trimIndent()
            }
        }
    }
}
