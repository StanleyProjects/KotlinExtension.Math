package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class MutableOffsetOperatorsTest {
    @Test
    fun timesAssignTest() {
        val initial = offsetOf(4.2, 6.4)
        val points = 8
        val delta = 0.00000001
        listOf(
            -0.5 to offsetOf(-2.1, -3.2),
            0.0 to offsetOf(0, 0),
            0.5 to offsetOf(2.1, 3.2),
            1.0 to offsetOf(4.2, 6.4),
            1.5 to offsetOf(6.3, 9.6),
            2.0 to offsetOf(8.4, 12.8),
        ).forEach { (multiplier, expected) ->
            val actual = MutableOffset(dX = initial.dX, dY = initial.dY)
            actual *= multiplier
            assert(expected = expected, actual = actual, points = points, delta = delta)
        }
    }

    @Test
    fun divAssignTest() {
        val initial = offsetOf(4.2, 6.4)
        val points = 8
        val delta = 0.00000001
        listOf(
            -2.0 to offsetOf(-2.1, -3.2),
            2.0 to offsetOf(2.1, 3.2),
            1.0 to offsetOf(4.2, 6.4),
            0.5 to offsetOf(8.4, 12.8),
            (2.0 / 3.0) to offsetOf(6.3, 9.6),
        ).forEach { (multiplier, expected) ->
            val actual = MutableOffset(dX = initial.dX, dY = initial.dY)
            actual /= multiplier
            assert(expected = expected, actual = actual, points = points, delta = delta)
        }
    }

    @Test
    fun plusAssignOffsetTest() {
        val initial = offsetOf(1.2, 3.4)
        val points = 8
        val delta = 0.00000001
        listOf(
            offsetOf(-1.2, -3.4) to offsetOf(0.0, 0.0),
            offsetOf(-1.2, 0.0) to offsetOf(0.0, 3.4),
            offsetOf(0.0, -3.4) to offsetOf(1.2, 0.0),
            offsetOf(0.0, 0.0) to offsetOf(1.2, 3.4),
            offsetOf(0.0, 1.0) to offsetOf(1.2, 4.4),
            offsetOf(1.0, 0.0) to offsetOf(2.2, 3.4),
            offsetOf(1.0, 1.0) to offsetOf(2.2, 4.4),
            offsetOf(2.8, 0.6) to offsetOf(4.0, 4.0),
        ).forEach { (other, expected) ->
            val actual = MutableOffset(dX = initial.dX, dY = initial.dY)
            actual += other
            assert(expected = expected, actual = actual, points = points, delta = delta)
        }
    }

    @Test
    fun minusAssignOffsetTest() {
        val initial = offsetOf(1.2, 3.4)
        val points = 8
        val delta = 0.00000001
        listOf(
            offsetOf(1.2, 3.4) to offsetOf(0.0, 0.0),
            offsetOf(1.2, 0.0) to offsetOf(0.0, 3.4),
            offsetOf(0.0, 3.4) to offsetOf(1.2, 0.0),
            offsetOf(0.0, 0.0) to offsetOf(1.2, 3.4),
            offsetOf(0.0, -1.0) to offsetOf(1.2, 4.4),
            offsetOf(-1.0, 0.0) to offsetOf(2.2, 3.4),
            offsetOf(-1.0, -1.0) to offsetOf(2.2, 4.4),
            offsetOf(-2.8, -0.6) to offsetOf(4.0, 4.0),
        ).forEach { (other, expected) ->
            val actual = MutableOffset(dX = initial.dX, dY = initial.dY)
            actual -= other
            assert(expected = expected, actual = actual, points = points, delta = delta)
        }
    }

    companion object {
        private fun assert(expected: Offset, actual: Offset, points: Int, delta: Double) {
            val message = """
                expected: $expected
                actual: $actual
                points: $points
                delta: ${delta.toString(24)}
            """.trimIndent()
            assertEquals(expected.dX, actual.dX, delta, message)
            assertEquals(expected.dY, actual.dY, delta, message)
            assertTrue(expected.eq(other = actual, points = points), message)
        }
    }
}
