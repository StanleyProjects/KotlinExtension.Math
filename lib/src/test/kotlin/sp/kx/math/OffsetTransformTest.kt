package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class OffsetTransformTest {
    @Test
    fun offsetOfTest() {
        val points = 8
        val delta = 0.00000001
        listOf(
            -0.5 to offsetOf(-2.1, -3.2),
            0.0 to offsetOf(0, 0),
            0.5 to offsetOf(2.1, 3.2),
            1.0 to offsetOf(4.2, 6.4),
            2.0 to offsetOf(8.4, 12.8),
            1.5 to offsetOf(6.3, 9.6),
        ).forEach { (multiplier, expected) ->
            val actual = offsetOf(dX = 4.2, dY = 6.4) { it * multiplier }
            assert(expected = expected, actual = actual, points = points, delta = delta)
        }
    }

    @Test
    fun mapTest() {
        val initial = offsetOf(4.2, 6.4)
        val points = 8
        val delta = 0.00000001
        listOf(
            -0.5 to offsetOf(-2.1, -3.2),
            0.0 to offsetOf(0, 0),
            0.5 to offsetOf(2.1, 3.2),
            1.0 to offsetOf(4.2, 6.4),
            2.0 to offsetOf(8.4, 12.8),
            1.5 to offsetOf(6.3, 9.6),
        ).forEach { (multiplier, expected) ->
            val actual = initial.map { it * multiplier }
            assert(expected = expected, actual = actual, points = points, delta = delta)
        }
    }

    @Test
    fun offsetOfMultiplierTest() {
        val points = 8
        val delta = 0.00000001
        listOf(
            -0.5 to offsetOf(-2.1, -3.2),
            0.0 to offsetOf(0, 0),
            0.5 to offsetOf(2.1, 3.2),
            1.0 to offsetOf(4.2, 6.4),
            2.0 to offsetOf(8.4, 12.8),
            1.5 to offsetOf(6.3, 9.6),
        ).forEach { (multiplier, expected) ->
            val actual = offsetOf(dX = 4.2, dY = 6.4, multiplier = multiplier)
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
