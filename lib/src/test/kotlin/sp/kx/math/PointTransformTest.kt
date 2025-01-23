package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class PointTransformTest {
    @Test
    fun pointOfTest() {
        val points = 8
        val delta = 0.00000001
        listOf(
            -0.5 to pointOf(-2.1, -3.2),
            0.0 to pointOf(0, 0),
            0.5 to pointOf(2.1, 3.2),
            1.0 to pointOf(4.2, 6.4),
            2.0 to pointOf(8.4, 12.8),
            1.5 to pointOf(6.3, 9.6),
        ).forEach { (multiplier, expected) ->
            val actual = pointOf(x = 4.2, y = 6.4) { it * multiplier }
            assert(expected = expected, actual = actual, points = points, delta = delta)
        }
    }

    @Test
    fun mapTest() {
        val point = pointOf(x = 4.2, y = 6.4)
        val points = 8
        val delta = 0.00000001
        listOf(
            -0.5 to pointOf(-2.1, -3.2),
            0.0 to pointOf(0, 0),
            0.5 to pointOf(2.1, 3.2),
            1.0 to pointOf(4.2, 6.4),
            2.0 to pointOf(8.4, 12.8),
            1.5 to pointOf(6.3, 9.6),
        ).forEach { (multiplier, expected) ->
            val actual = point.map { it * multiplier }
            assert(expected = expected, actual = actual, points = points, delta = delta)
        }
    }

    @Test
    fun pointOfMultiplierTest() {
        val points = 8
        val delta = 0.00000001
        listOf(
            -0.5 to pointOf(-2.1, -3.2),
            0.0 to pointOf(0, 0),
            0.5 to pointOf(2.1, 3.2),
            1.0 to pointOf(4.2, 6.4),
            2.0 to pointOf(8.4, 12.8),
            1.5 to pointOf(6.3, 9.6),
        ).forEach { (multiplier, expected) ->
            val actual = pointOf(x = 4.2, y = 6.4, multiplier = multiplier)
            assert(expected = expected, actual = actual, points = points, delta = delta)
        }
    }

    companion object {
        private fun assert(expected: Point, actual: Point, points: Int, delta: Double) {
            val message = """
                expected: $expected
                actual: $actual
                points: $points
                delta: ${delta.toString(24)}
            """.trimIndent()
            assertEquals(expected.x, actual.x, delta, message)
            assertEquals(expected.y, actual.y, delta, message)
            assertTrue(expected.eq(other = actual, points = points), message)
        }
    }
}
