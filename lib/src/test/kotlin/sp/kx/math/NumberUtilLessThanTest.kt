package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class NumberUtilLessThanTest {
    private data class DataSet(
        val value: Double,
        val other: Double,
        val points: Int,
        val isLessThan: Boolean,
        val expected: Boolean,
    )

    @Test
    fun lessThanTest() {
        val issues = listOf(
            DataSet(
                value = 1.23,
                other = 1.234,
                points = 3,
                isLessThan = true,
                expected = true,
            ),
            DataSet(
                value = 1.23,
                other = 1.234,
                points = 2,
                isLessThan = true,
                expected = false,
            ),
            DataSet(
                value = 1.23,
                other = 1.23,
                points = 2,
                isLessThan = false,
                expected = false,
            ),
        )
        check(issues.size == 3)
        check(issues.toSet().size == issues.size)
        issues.forEach { issue ->
            check(issue.value < issue.other == issue.isLessThan)
            val actual = issue.value.lt(other = issue.other, points = issue.points)
            Assertions.assertEquals(issue.expected, actual)
        }
    }

    @Test
    fun lessThanDeltaTest() {
        kotlin.math.cos(0.0).also { expected ->
            val actual = 1.0
            Assertions.assertEquals(expected, actual)
            Assertions.assertTrue(actual.lt(other = expected, points = 1))
            Assertions.assertEquals(expected, actual, 0.1)
            Assertions.assertTrue(actual.lt(other = expected, points = 1))
            Assertions.assertEquals(expected, actual, 0.00000001)
            Assertions.assertTrue(actual.lt(other = expected, points = 8))
        }
        kotlin.math.cos(kotlin.math.PI / 4).also { expected ->
            val actual = 0.70710678 // 0.7071067811865476
            Assertions.assertEquals(expected, actual, 0.1)
            Assertions.assertTrue(actual.lt(other = expected, points = 1))
            Assertions.assertEquals(expected, actual, 0.00000001)
            Assertions.assertTrue(actual.lt(other = expected, points = 8))
        }
        kotlin.math.cos(kotlin.math.PI / 2).also { expected ->
            val actual = 0.00000000000000006 // 0.00000000000000006123233995736766
            Assertions.assertEquals(expected, actual, 0.1)
            Assertions.assertTrue(actual.lt(other = expected, points = 1))
            Assertions.assertEquals(expected, actual, 0.00000000000000001)
            Assertions.assertTrue(actual.lt(other = expected, points = 17))
        }
        kotlin.math.cos(kotlin.math.PI / 2 + kotlin.math.PI / 4).also { expected ->
            val actual = -0.70710678 // -0.7071067811865476
            Assertions.assertEquals(expected, actual, 0.1)
            Assertions.assertTrue(actual.lt(other = expected, points = 1))
            Assertions.assertEquals(expected, actual, 0.00000001)
            Assertions.assertTrue(actual.lt(other = expected, points = 8))
        }
        kotlin.math.cos(kotlin.math.PI).also { expected ->
            val actual = -1.0
            Assertions.assertEquals(expected, actual)
            Assertions.assertTrue(actual.lt(other = expected, points = 1))
            Assertions.assertEquals(expected, actual, 0.1)
            Assertions.assertTrue(actual.lt(other = expected, points = 1))
            Assertions.assertEquals(expected, actual, 0.00000001)
            Assertions.assertTrue(actual.lt(other = expected, points = 8))
        }
    }

    @Test
    fun lessThanNotTest() {
        val actual = 1.23
        Assertions.assertFalse(actual.lt(other = 1.0, points = 1))
        Assertions.assertFalse(actual.lt(other = 1.2, points = 2))
        Assertions.assertFalse(actual.lt(other = -1.23, points = 2))
        Assertions.assertFalse(actual.lt(other = 1.234, points = 3))
        Assertions.assertFalse(actual.lt(other = 1.23456789, points = 3))
        Assertions.assertFalse(actual.lt(other = 1.23456789, points = 4))
        Assertions.assertFalse(actual.lt(other = 1.23456789, points = 8))
        Assertions.assertFalse(actual.lt(other = 2.0, points = 1))
    }

    @Test
    fun lessThanNotDeltaTest() {
        kotlin.math.cos(0.0).also { expected ->
            val actual = 1.1
            Assertions.assertEquals(expected, actual, 0.2)
            Assertions.assertNotEquals(expected, actual, 0.01)
            Assertions.assertFalse(actual.lt(other = expected, points = 1))
            Assertions.assertNotEquals(expected, actual, 0.00000001)
            Assertions.assertFalse(actual.lt(other = expected, points = 8))
        }
        kotlin.math.cos(kotlin.math.PI / 4).also { expected ->
            val actual = 0.70710678 // 0.7071067811865476
            Assertions.assertEquals(expected, actual, 0.1)
            Assertions.assertTrue(actual.lt(other = expected, points = 1))
            Assertions.assertNotEquals(expected, actual, 0.000000001)
            Assertions.assertFalse(actual.lt(other = expected, points = 9))
        }
        kotlin.math.cos(kotlin.math.PI / 2).also { expected ->
            val actual = 0.00000000000000006 // 0.00000000000000006123233995736766
            Assertions.assertEquals(expected, actual, 0.1)
            Assertions.assertTrue(actual.lt(other = expected, points = 1))
            Assertions.assertNotEquals(expected, actual, 0.000000000000000001)
            Assertions.assertFalse(actual.lt(other = expected, points = 18))
        }
        kotlin.math.cos(kotlin.math.PI / 2 + kotlin.math.PI / 4).also { expected ->
            val actual = -0.70710678 // -0.7071067811865476
            Assertions.assertEquals(expected, actual, 0.1)
            Assertions.assertTrue(actual.lt(other = expected, points = 1))
            Assertions.assertNotEquals(expected, actual, 0.000000001)
            Assertions.assertFalse(actual.lt(other = expected, points = 9))
        }
        kotlin.math.cos(kotlin.math.PI).also { expected ->
            val actual = -1.1
            Assertions.assertEquals(expected, actual, 0.2)
            Assertions.assertNotEquals(expected, actual, 0.01)
            Assertions.assertFalse(actual.lt(other = expected, points = 1))
            Assertions.assertNotEquals(expected, actual, 0.00000001)
            Assertions.assertFalse(actual.lt(other = expected, points = 8))
        }
    }

    @Test
    fun lessThanErrorTest() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            @Suppress("IgnoredReturnValue")
            1.2.lt(other = 3.4, points = -1)
        }
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            @Suppress("IgnoredReturnValue")
            1.2.lt(other = 3.4, points = 0)
        }
    }
}
