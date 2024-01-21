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
            Assertions.assertEquals(issue.expected, actual)
        }
    }
}
