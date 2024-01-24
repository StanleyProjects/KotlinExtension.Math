package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress(
    "ForEachOnRange",
    "MagicNumber",
)
internal class NumberUtilGreaterThanTest {
    private data class DataSet(
        val value: Double,
        val other: Double,
        val points: Int,
        val isGreaterThan: Boolean,
        val expected: Boolean,
    )

    @Test
    fun greaterThanTest() {
        val issues = listOf(
            DataSet(
                value = 0.123456789,
                other = 0.0,
                points = 8,
                isGreaterThan = true,
                expected = true,
            ),
            DataSet(
                value = 0.123456789,
                other = 0.0,
                points = 16,
                isGreaterThan = true,
                expected = true,
            ),
            DataSet(
                value = 0.123456789,
                other = 0.0,
                points = 32,
                isGreaterThan = true,
                expected = true,
            ),
            DataSet(
                value = 1.234,
                other = 1.23,
                points = 1,
                isGreaterThan = true,
                expected = false,
            ),
            DataSet(
                value = 1.234,
                other = 1.23,
                points = 2,
                isGreaterThan = true,
                expected = false,
            ),
            DataSet(
                value = 1.234,
                other = 1.23,
                points = 3,
                isGreaterThan = true,
                expected = true,
            ),
        )
        check(issues.size == 6)
        check(issues.toSet().size == issues.size)
        issues.forEach(::assertIssue)
    }

    @Suppress("FunctionMaxLength")
    @Test
    fun greaterThanDeltaPointsFalseTest() {
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
        issues.forEachIndexed { index, (other, value) ->
            (1..9).forEach { points ->
                assertIssue(
                    DataSet(
                        value = value,
                        other = other,
                        points = points,
                        isGreaterThan = true,
                        expected = points > index + 1,
                    ),
                )
            }
        }
    }

    @Test
    fun greaterThanDeltaPointsTest() {
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
        issues.forEachIndexed { index, other ->
            (1..9).forEach { points ->
                assertIssue(
                    DataSet(
                        value = 0.123456789,
                        other = other,
                        points = points,
                        isGreaterThan = true,
                        expected = points > index + 1,
                    ),
                )
            }
        }
    }

    @Test
    fun greaterThanDeltaTest() {
        val issues = listOf(
            DataSet(
                value = 0.00010001,
                other = 0.0001,
                points = 1,
                isGreaterThan = true,
                expected = false,
            ),
            DataSet(
                value = 0.00010001,
                other = 0.0001,
                points = 4,
                isGreaterThan = true,
                expected = false,
            ),
            DataSet(
                value = 0.00010001,
                other = 0.0001,
                points = 6,
                isGreaterThan = true,
                expected = false,
            ),
            DataSet(
                value = 0.00010001,
                other = 0.0001,
                points = 8,
                isGreaterThan = true,
                expected = true,
            ),
        )
        check(issues.size == 4)
        check(issues.toSet().size == issues.size)
        issues.forEach(::assertIssue)
    }

    @Test
    fun greaterThanNotTest() {
        val issues = listOf(
            DataSet(
                value = 0.1,
                other = 0.1,
                points = 1,
                isGreaterThan = false,
                expected = false,
            ),
            DataSet(
                value = 0.123456789,
                other = 0.123456789,
                points = 8,
                isGreaterThan = false,
                expected = false,
            ),
            DataSet(
                value = 0.1,
                other = 0.2,
                points = 1,
                isGreaterThan = false,
                expected = false,
            ),
            DataSet(
                value = 0.1,
                other = 0.123456789,
                points = 1,
                isGreaterThan = false,
                expected = false,
            ),
            DataSet(
                value = 0.1,
                other = 0.123456789,
                points = 8,
                isGreaterThan = false,
                expected = false,
            ),
        )
        check(issues.size == 5)
        check(issues.toSet().size == issues.size)
        issues.forEach(::assertIssue)
    }

    @Test
    fun greaterThanErrorTest() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            @Suppress("IgnoredReturnValue")
            1.2.gt(other = 3.4, points = -1)
        }
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            @Suppress("IgnoredReturnValue")
            1.2.gt(other = 3.4, points = 0)
        }
    }

    companion object {
        private fun assertIssue(issue: DataSet) {
            check(issue.value > issue.other == issue.isGreaterThan)
            val actual = issue.value.gt(other = issue.other, points = issue.points)
            Assertions.assertEquals(issue.expected, actual)
        }
    }
}
