package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class MutableVectorOperatorsTest {
    @Test
    fun timesAssignTest() {
        val initial = pointOf(1.2, 3.4) + pointOf(5.6, 7.8)
        val points = 12
        val delta = 0.00000001
        listOf(
            -1.0 to vectorOf(-1.2, -3.4, -5.6, -7.8),
            0.0 to vectorOf(0.0, 0.0, 0.0, 0.0),
            0.5 to vectorOf(0.6, 1.7, 2.8, 3.9),
            1.0 to vectorOf(1.2, 3.4, 5.6, 7.8),
            1.2 to vectorOf(1.44, 4.08, 6.72, 9.36),
            1.5 to vectorOf(1.8, 5.1, 8.4, 11.7),
            2.0 to vectorOf(2.4, 6.8, 11.2, 15.6),
        ).forEach { (multiplier, expected) ->
            val actual = MutableVector(
                start = MutablePoint(x = initial.start.x, y = initial.start.y),
                finish = MutablePoint(x = initial.finish.x, y = initial.finish.y),
            )
            actual *= multiplier
            assert(expected = expected, actual = actual, points = points, delta = delta)
        }
    }

    @Test
    fun divAssignTest() {
        val initial = pointOf(1.2, 3.4) + pointOf(5.6, 7.8)
        val points = 12
        val delta = 0.00000001
        listOf(
            -1.0 to vectorOf(-1.2, -3.4, -5.6, -7.8),
            0.5 to vectorOf(2.4, 6.8, 11.2, 15.6),
            1.0 to vectorOf(1.2, 3.4, 5.6, 7.8),
            2.0 to vectorOf(0.6, 1.7, 2.8, 3.9),
        ).forEach { (multiplier, expected) ->
            val actual = MutableVector(
                start = MutablePoint(x = initial.start.x, y = initial.start.y),
                finish = MutablePoint(x = initial.finish.x, y = initial.finish.y),
            )
            actual /= multiplier
            assert(expected = expected, actual = actual, points = points, delta = delta)
        }
    }

    @Test
    fun plusAssignOffsetTest() {
        val initial = pointOf(1.2, 3.4) + pointOf(5.6, 7.8)
        val points = 8
        val delta = 0.00000001
        listOf(
            offsetOf(-1.2, -3.4) to vectorOf(0.0, 0.0, 4.4, 4.4),
            offsetOf(-1.2, 0.0) to vectorOf(0.0, 3.4, 4.4, 7.8),
            offsetOf(0.0, -3.4) to vectorOf(1.2, 0.0, 5.6, 4.4),
            offsetOf(0.0, 0.0) to vectorOf(1.2, 3.4, 5.6, 7.8),
            offsetOf(0.0, 1.0) to vectorOf(1.2, 4.4, 5.6, 8.8),
            offsetOf(1.0, 0.0) to vectorOf(2.2, 3.4, 6.6, 7.8),
            offsetOf(1.0, 1.0) to vectorOf(2.2, 4.4, 6.6, 8.8),
            offsetOf(2.8, 0.6) to vectorOf(4.0, 4.0, 8.4, 8.4),
        ).forEach { (offset, expected) ->
            val actual = MutableVector(
                start = MutablePoint(x = initial.start.x, y = initial.start.y),
                finish = MutablePoint(x = initial.finish.x, y = initial.finish.y),
            )
            actual += offset
            assert(expected = expected, actual = actual, points = points, delta = delta)
        }
    }

    @Test
    fun minusAssignOffsetTest() {
        val initial = pointOf(1.2, 3.4) + pointOf(5.6, 7.8)
        val points = 8
        val delta = 0.00000001
        listOf(
            offsetOf(1.2, 3.4) to vectorOf(0.0, 0.0, 4.4, 4.4),
            offsetOf(1.2, 0.0) to vectorOf(0.0, 3.4, 4.4, 7.8),
            offsetOf(0.0, 3.4) to vectorOf(1.2, 0.0, 5.6, 4.4),
            offsetOf(0.0, 0.0) to vectorOf(1.2, 3.4, 5.6, 7.8),
            offsetOf(0.0, -1.0) to vectorOf(1.2, 4.4, 5.6, 8.8),
            offsetOf(-1.0, 0.0) to vectorOf(2.2, 3.4, 6.6, 7.8),
            offsetOf(-1.0, -1.0) to vectorOf(2.2, 4.4, 6.6, 8.8),
            offsetOf(-2.8, -0.6) to vectorOf(4.0, 4.0, 8.4, 8.4),
        ).forEach { (offset, expected) ->
            val actual = MutableVector(
                start = MutablePoint(x = initial.start.x, y = initial.start.y),
                finish = MutablePoint(x = initial.finish.x, y = initial.finish.y),
            )
            actual -= offset
            assert(expected = expected, actual = actual, points = points, delta = delta)
        }
    }

    companion object {
        private fun assert(expected: Vector, actual: Vector, points: Int, delta: Double) {
            val message = """
                expected: $expected
                actual: $actual
                points: $points
                delta: ${delta.toString(24)}
            """.trimIndent()
            assertEquals(expected.start.x, actual.start.x, delta, message)
            assertEquals(expected.start.x, actual.start.x, delta, message)
            assertEquals(expected.finish.y, actual.finish.y, delta, message)
            assertEquals(expected.finish.y, actual.finish.y, delta, message)
            assertTrue(expected.eq(other = actual, points = points), message)
        }
    }
}
