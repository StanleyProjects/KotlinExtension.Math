package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class SizeTransformTest {
    @Test
    fun sizeOfTest() {
        val points = 8
        val delta = 0.00000001
        listOf(
            -0.5 to sizeOf(-2.1, -3.2),
            0.0 to sizeOf(0, 0),
            0.5 to sizeOf(2.1, 3.2),
            1.0 to sizeOf(4.2, 6.4),
            2.0 to sizeOf(8.4, 12.8),
            1.5 to sizeOf(6.3, 9.6),
        ).forEach { (multiplier, expected) ->
            val actual = sizeOf(width = 4.2, height = 6.4) { it * multiplier }
            assert(expected = expected, actual = actual, points = points, delta = delta)
        }
    }

    @Test
    fun mapTest() {
        val initial = sizeOf(4.2, 6.4)
        val points = 8
        val delta = 0.00000001
        listOf(
            -0.5 to sizeOf(-2.1, -3.2),
            0.0 to sizeOf(0, 0),
            0.5 to sizeOf(2.1, 3.2),
            1.0 to sizeOf(4.2, 6.4),
            2.0 to sizeOf(8.4, 12.8),
            1.5 to sizeOf(6.3, 9.6),
        ).forEach { (multiplier, expected) ->
            val actual = initial.map { it * multiplier }
            assert(expected = expected, actual = actual, points = points, delta = delta)
        }
    }

    @Test
    fun sizeOfMultiplierTest() {
        val points = 8
        val delta = 0.00000001
        listOf(
            -0.5 to sizeOf(-2.1, -3.2),
            0.0 to sizeOf(0, 0),
            0.5 to sizeOf(2.1, 3.2),
            1.0 to sizeOf(4.2, 6.4),
            2.0 to sizeOf(8.4, 12.8),
            1.5 to sizeOf(6.3, 9.6),
        ).forEach { (multiplier, expected) ->
            val actual = sizeOf(width = 4.2, height = 6.4, multiplier = multiplier)
            assert(expected = expected, actual = actual, points = points, delta = delta)
        }
    }

    companion object {
        private fun assert(expected: Size, actual: Size, points: Int, delta: Double) {
            val message = """
                expected: $expected
                actual: $actual
                points: $points
                delta: ${delta.toString(24)}
            """.trimIndent()
            assertEquals(expected.width, actual.width, delta, message)
            assertEquals(expected.height, actual.height, delta, message)
            assertTrue(expected.eq(other = actual, points = points), message)
        }
    }
}
