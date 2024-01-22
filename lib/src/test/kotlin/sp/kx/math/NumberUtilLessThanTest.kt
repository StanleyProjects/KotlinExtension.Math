package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.RoundingMode
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
                value = 0.0,
                other = 0.123456789,
                points = 8,
                isLessThan = true,
                expected = true,
            ),
            DataSet(
                value = 0.0,
                other = 0.123456789,
                points = 16,
                isLessThan = true,
                expected = true,
            ),
            DataSet(
                value = 0.0,
                other = 0.123456789,
                points = 32,
                isLessThan = true,
                expected = true,
            ),
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
        check(issues.size == 6)
        check(issues.toSet().size == issues.size)
        issues.forEach(::assertIssue)
    }

    @Test
    fun lessThanDeltaPointsFalseTest() {
        val issues = listOf(
            0.12 to 0.13,
            0.123 to 0.124,
            0.1234 to 0.1235,
            0.12345 to 0.12346,
            0.123456 to 0.123457,
            0.1234567 to 0.1234568,
            0.12345678 to 0.12345679,
            0.123456789 to 0.12345679,
        )
        check(issues.size == 8)
        check(issues.toSet().size == issues.size)
        issues.forEachIndexed { index, (value, other) ->
            (1..9).forEach { points ->
                assertIssue(
                    DataSet(
                        value = value,
                        other = other,
                        points = points,
                        isLessThan = true,
                        expected = points > index + 1,
                    ),
                )
            }
        }
    }

    @Test
    fun lessThanDeltaPointsTest() {
        val issues = listOf(
            0.1,
            0.12,
            0.123,
            0.1234,
            0.12345,
            0.123456,
            0.1234567,
            0.12345678,
        )
        check(issues.size == 8)
        check(issues.toSet().size == issues.size)
        issues.forEachIndexed { index, value ->
            (1..9).forEach { points ->
                assertIssue(
                    DataSet(
                        value = value,
                        other = 0.123456789,
                        points = points,
                        isLessThan = true,
                        expected = points > index + 1,
                    ),
                )
            }
        }
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
        val issues = listOf(
            DataSet(
                value = 0.1235,
                other = 0.1234,
                points = 4,
                isLessThan = false,
                expected = false,
            ),
            DataSet(
                value = 0.21,
                other = 0.20,
                points = 2,
                isLessThan = false,
                expected = false,
            ),
            DataSet(
                value = 0.2,
                other = 0.1,
                points = 1,
                isLessThan = false,
                expected = false,
            ),
            DataSet(
                value = 0.2,
                other = 0.21,
                points = 1,
                isLessThan = true,
                expected = false,
            ),
            DataSet(
                value = 0.2,
                other = 0.21,
                points = 2,
                isLessThan = true,
                expected = true,
            ),
            DataSet(
                value = 0.2,
                other = 0.20000001,
                points = 1,
                isLessThan = true,
                expected = false,
            ),
            DataSet(
                value = 0.2,
                other = 0.20000001,
                points = 8,
                isLessThan = true,
                expected = true,
            ),
        )
        check(issues.size == 7)
        check(issues.toSet().size == issues.size)
        issues.forEach(::assertIssue)
    }

    @Test
    fun lessThanErrorTest() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            1.2.lt(other = 3.4, points = -1)
        }
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            1.2.lt(other = 3.4, points = 0)
        }
    }

    companion object {
        private fun assertIssue(issue: DataSet) {
            check(issue.value < issue.other == issue.isLessThan)
            val actual = issue.value.lt(other = issue.other, points = issue.points)
            Assertions.assertEquals(issue.expected, actual) {
                // todo
                val value = issue.value
                val other = issue.other
                val points = issue.points
                val diff = (value - other).absoluteValue
                val delta = 10.0.pow(points)
                val bd1 = BigDecimal(value)
                val bd2 = BigDecimal(other)
                val bDiff = bd1 - bd2
                val bDelta = BigDecimal(10).pow(points)
                val bScaled1 = (bDiff * bDelta).setScale(1, RoundingMode.HALF_EVEN)
                """
                    points: $points
                    value: ${value.toString(points = 32)}(${value.toString(points = points)})
                    other: ${other.toString(points = 32)}(${other.toString(points = points)})
                    diff: ${diff.toString(points = 32)}
                    ---
                    bd1: $bd1
                    bd2: $bd2
                    bDiff: $bDiff
                    bDelta: $bDelta
                    scaled(1): $bScaled1
                    ---
                    10^$points: ${delta.toString(points = 32)}
                    diff * 10^$points: ${(diff * delta).toString(points = 32)}(${(diff * delta).toInt()})
                """.trimIndent()
            }
        }
    }
}
