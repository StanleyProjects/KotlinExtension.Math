package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.absoluteValue
import kotlin.math.pow

internal class OffsetUtilEqTest {
    @Test
    fun eqDeltaTest() {
        val value = 128.0001
        val other = 128.00010001
        (1..4).forEach { points ->
            assert(
                it = offsetOf(dX = value, dY = value),
                other = offsetOf(dX = other, dY = other),
                points = points,
                expected = true,
            )
        }
        assert(
            it = offsetOf(dX = value, dY = value),
            other = offsetOf(dX = other, dY = other),
            points = 8,
            expected = false,
        )
        val abs = (value - other).absoluteValue
        val delta = 10.0.pow(-4)
        assert(
            it = offsetOf(dX = abs, dY = abs),
            other = offsetOf(dX = delta, dY = delta),
            points = 3,
            expected = true,
        )
//        assert(
//            it = offsetOf(dX = abs, dY = abs),
//            other = offsetOf(dX = delta, dY = delta),
//            points = 4,
//            expected = false,
//        )
        assert(
            it = offsetOf(dX = abs, dY = abs),
            other = offsetOf(dX = delta, dY = delta),
            points = 5,
            expected = false,
        )
    }

    @Test
    fun eqOneTest() {
        for (points in 1..16) {
            for (e in 1..16) {
                if (points == e) continue
                assert(
                    it = offsetOf(dX = 0.0, dY = 0.0),
                    other = offsetOf(dX = 10.0.pow(-e), dY = 0.0),
                    points = points,
                    expected = points < e,
                )
            }
        }
    }

    @Test
    fun eqTest() {
        (1..5).forEach { points ->
            assert(
                it = offsetOf(dX = 9.12345, dY = 9.123456789),
                other = offsetOf(dX = 9.123456789, dY = 9.123456789),
                points = points,
                expected = true,
            )
        }
        (6..9).forEach { points ->
            assert(
                it = offsetOf(dX = 9.12345, dY = 9.123456789),
                other = offsetOf(dX = 9.123456789, dY = 9.123456789),
                points = points,
                expected = false,
            )
        }
        (1..7).forEach { points ->
            assert(
                it = offsetOf(dX = 9.1234567, dY = 9.123456789),
                other = offsetOf(dX = 9.123456789, dY = 9.123456789),
                points = points,
                expected = true,
            )
        }
        (8..9).forEach { points ->
            assert(
                it = offsetOf(dX = 9.1234567, dY = 9.123456789),
                other = offsetOf(dX = 9.123456789, dY = 9.123456789),
                points = points,
                expected = false,
            )
        }
        assert(
            it = offsetOf(dX = 9.1234567, dY = 9.123456789),
            other = offsetOf(dX = 9.123456789, dY = 9.123456789),
            points = 8,
            expected = false,
        )
        assert(
            it = offsetOf(dX = 0.1234567, dY = 0.123456789),
            other = offsetOf(dX = 0.123456789, dY = 0.123456789),
            points = 8,
            expected = false,
        )
        assert(
            it = offsetOf(dX = 0.0, dY = 0.0),
            other = offsetOf(dX = 0.000000089, dY = 0.000000089),
            points = 7,
            expected = true,
        )
        assert(
            it = offsetOf(dX = 0.0, dY = 0.0),
            other = offsetOf(dX = 0.000000089, dY = 0.000000089),
            points = 8,
            expected = false,
        )
        assert(
            it = offsetOf(dX = 0.0, dY = 0.0),
            other = offsetOf(dX = 0.00000001, dY = 0.0),
            points = 7,
            expected = true,
        )
        assert(
            it = offsetOf(dX = 0.0, dY = 0.0),
            other = offsetOf(dX = 0.00000001, dY = 0.0),
            points = 8,
            expected = false,
        )
        val actual = offsetOf(dX = 1.234, dY = 5.67)
        assert(it = actual, other = offsetOf(dX = 1.2, dY = 5.6), points = 1, expected = true)
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
            offsetOf(dX = 1.2, dY = 5.6).eq(other = offsetOf(dX = 1.2, dY = 5.6), points = -1)
        }
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            offsetOf(dX = 1.2, dY = 5.6).eq(other = offsetOf(dX = 1.2, dY = 5.6), points = 0)
        }
    }

    companion object {
        private fun assert(it: Offset, other: Offset, points: Int, expected: Boolean) {
            val actual = it.eq(other = other, points = points)
            val message = """
                this: $it (${it.toString(24)})
                that: $other (${other.toString(24)})
                points: $points
                expected: $expected
                actual: $actual
            """.trimIndent()
            Assertions.assertEquals(expected, actual, message)
        }
    }
}
