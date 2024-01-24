package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.absoluteValue
import kotlin.math.pow

@Suppress(
    "ForEachOnRange",
    "MagicNumber",
)
internal class OffsetUtilEqTest {
    @Test
    fun eqDeltaTest() {
        val value = 128.0001
        val other = 128.00010001
        (1..4).forEach { points ->
            assertOffsets(
                value = offsetOf(dX = value, dY = value),
                other = offsetOf(dX = other, dY = other),
                points = points,
                equals = true,
            )
        }
        assertOffsets(
            value = offsetOf(dX = value, dY = value),
            other = offsetOf(dX = other, dY = other),
            points = 8,
            equals = false,
        )
        val abs = (value - other).absoluteValue
        val delta = 10.0.pow(-4)
        assertOffsets(
            value = offsetOf(dX = abs, dY = abs),
            other = offsetOf(dX = delta, dY = delta),
            points = 4,
            equals = false,
        )
    }

    @Test
    fun eqOneTest() {
        (1..8).forEach { points ->
            assertOffsets(
                value = offsetOf(dX = 0.0, dY = 0.0),
                other = offsetOf(dX = 10.0.pow(-points), dY = 0.0),
                points = points,
                equals = false,
            )
        }
    }

    @Suppress("LongMethod")
    @Test
    fun eqTest() {
        (1..5).forEach { points ->
            assertOffsets(
                value = offsetOf(dX = 9.12345, dY = 9.123456789),
                other = offsetOf(dX = 9.123456789, dY = 9.123456789),
                points = points,
                equals = true,
            )
        }
        (6..9).forEach { points ->
            assertOffsets(
                value = offsetOf(dX = 9.12345, dY = 9.123456789),
                other = offsetOf(dX = 9.123456789, dY = 9.123456789),
                points = points,
                equals = false,
            )
        }
        (1..7).forEach { points ->
            assertOffsets(
                value = offsetOf(dX = 9.1234567, dY = 9.123456789),
                other = offsetOf(dX = 9.123456789, dY = 9.123456789),
                points = points,
                equals = true,
            )
        }
        (8..9).forEach { points ->
            assertOffsets(
                value = offsetOf(dX = 9.1234567, dY = 9.123456789),
                other = offsetOf(dX = 9.123456789, dY = 9.123456789),
                points = points,
                equals = false,
            )
        }
        assertOffsets(
            value = offsetOf(dX = 9.1234567, dY = 9.123456789),
            other = offsetOf(dX = 9.123456789, dY = 9.123456789),
            points = 8,
            equals = false,
        )
        assertOffsets(
            value = offsetOf(dX = 0.1234567, dY = 0.123456789),
            other = offsetOf(dX = 0.123456789, dY = 0.123456789),
            points = 8,
            equals = false,
        )
        assertOffsets(
            value = offsetOf(dX = 0.0, dY = 0.0),
            other = offsetOf(dX = 0.000000089, dY = 0.000000089),
            points = 7,
            equals = true,
        )
        assertOffsets(
            value = offsetOf(dX = 0.0, dY = 0.0),
            other = offsetOf(dX = 0.000000089, dY = 0.000000089),
            points = 8,
            equals = false,
        )
        assertOffsets(
            value = offsetOf(dX = 0.0, dY = 0.0),
            other = offsetOf(dX = 0.00000001, dY = 0.0),
            points = 7,
            equals = true,
        )
        assertOffsets(
            value = offsetOf(dX = 0.0, dY = 0.0),
            other = offsetOf(dX = 0.00000001, dY = 0.0),
            points = 8,
            equals = false,
        )
        val actual = offsetOf(dX = 1.234, dY = 5.67)
        assertOffsets(value = actual, other = offsetOf(dX = 1.2, dY = 5.6), points = 1, equals = true)
        Assertions.assertTrue(actual.eq(other = offsetOf(dX = 1.23, dY = 5.67), points = 1))
        Assertions.assertTrue(actual.eq(other = offsetOf(dX = 1.23, dY = 5.67), points = 2))
        Assertions.assertTrue(actual.eq(other = offsetOf(dX = 1.2356789, dY = 5.67891234), points = 1))
        Assertions.assertTrue(actual.eq(other = offsetOf(dX = 1.2356789, dY = 5.67891234), points = 2))
    }

    @Test
    fun eqNotTest() {
        val actual = offsetOf(dX = 1.234, dY = 5.67)
        Assertions.assertFalse(actual.eq(other = offsetOf(dX = -1.23, dY = 5.67), points = 1))
        Assertions.assertFalse(actual.eq(other = offsetOf(dX = 1.23, dY = -5.67), points = 1))
        Assertions.assertFalse(actual.eq(other = offsetOf(dX = 1.23, dY = 5.67891234), points = 3))
        Assertions.assertFalse(actual.eq(other = offsetOf(dX = 1.2356789, dY = 5.67), points = 3))
        Assertions.assertFalse(actual.eq(other = offsetOf(dX = 1.2356789, dY = 5.67891234), points = 3))
        Assertions.assertFalse(actual.eq(other = offsetOf(dX = 1.2356789, dY = 5.67891234), points = 4))
        Assertions.assertFalse(actual.eq(other = offsetOf(dX = 1.2356789, dY = 5.67891234), points = 8))
    }

    @Test
    fun eqErrorTest() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            @Suppress("IgnoredReturnValue")
            offsetOf(dX = 1.2, dY = 5.6).eq(other = offsetOf(dX = 1.2, dY = 5.6), points = -1)
        }
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            @Suppress("IgnoredReturnValue")
            offsetOf(dX = 1.2, dY = 5.6).eq(other = offsetOf(dX = 1.2, dY = 5.6), points = 0)
        }
    }

    companion object {
        private fun assertOffsets(value: Offset, other: Offset, points: Int, equals: Boolean) {
            Assertions.assertEquals(equals, value.eq(other = other, points = points))
        }
    }
}
