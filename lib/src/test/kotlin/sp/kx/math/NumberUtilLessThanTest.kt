package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import sp.kx.math.unsafe.eq
import kotlin.math.absoluteValue
import kotlin.math.pow

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
        issues.forEach(::assertIssue)
    }

    @Test
    fun lessThanDeltaTest() {
        val issues = listOf(
            DataSet(
                value = 0.0001,
                other = 0.00010001,
                points = 4,
                isLessThan = true,
                expected = false,
            ),
            DataSet(
                value = 0.0001,
                other = 0.00010001,
                points = 8,
                isLessThan = true,
                expected = true,
            ),
        )
        check(issues.size == 2)
        check(issues.toSet().size == issues.size)
        issues.forEach(::assertIssue)
    }

    @Test
    fun lessThanNotTest() {
        TODO("${this::class.java.name}:lessThanNotTest")
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
        TODO("${this::class.java.name}:lessThanNotDeltaTest")
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
        TODO("${this::class.java.name}:lessThanErrorTest")
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            @Suppress("IgnoredReturnValue")
            1.2.lt(other = 3.4, points = -1)
        }
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            @Suppress("IgnoredReturnValue")
            1.2.lt(other = 3.4, points = 0)
        }
    }

    companion object {
        private fun assertIssue(issue: DataSet) {
            check(issue.value < issue.other == issue.isLessThan)
            val actual = issue.value.lt(other = issue.other, points = issue.points)
            Assertions.assertEquals(issue.expected, actual) {
                val diff = issue.value - issue.other
                val abs = diff.absoluteValue
                val delta = 10.0.pow(-issue.points)
//                val diff = it - other // todo
//                return diff.absoluteValue > 10.0.pow(-points) && diff < 0 // todo
//                val points = 12
//                val points = 16
                val points = 32
                """
                    points: ${issue.points}
                    value: ${issue.value.toString(points = points)}(${issue.value.toString(points = issue.points)})
                    other: ${issue.other.toString(points = points)}(${issue.other.toString(points = issue.points)})
                    diff: ${diff.toString(points = points)}(${diff.toString(points = issue.points)})
                    [diff]: ${abs.toString(points = points)}(${abs.toString(points = issue.points)})
                    1/10^(-${issue.points}): ${delta.toString(points = points)}(${delta.toString(points = issue.points)})
                    [diff] > 1/10^(-${issue.points}): ${abs > delta}
                    [diff] == 1/10^(-${issue.points}): ${eq(it = abs, other = delta, points = issue.points)}
                    diff < 0: ${diff < 0}
                """.trimIndent()
            }
        }
    }
}
