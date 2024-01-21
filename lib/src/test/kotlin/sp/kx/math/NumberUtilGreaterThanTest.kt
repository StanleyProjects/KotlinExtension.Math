package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

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
        check(issues.size == 3)
        check(issues.toSet().size == issues.size)
        issues.forEach(::assertIssue)
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
            1.2.gt(other = 3.4, points = -1)
        }
        Assertions.assertThrows(IllegalArgumentException::class.java) {
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
