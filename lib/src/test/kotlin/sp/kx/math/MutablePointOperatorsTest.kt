package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class MutablePointOperatorsTest {
    @Test
    fun timesAssignTest() {
        val point = pointOf(4.2, 6.4)
        val points = 8
        val delta = 0.00000001
        listOf(
            -0.5 to pointOf(-2.1, -3.2),
            0.0 to pointOf(0, 0),
            0.5 to pointOf(2.1, 3.2),
            1.0 to pointOf(4.2, 6.4),
            1.5 to pointOf(6.3, 9.6),
            2.0 to pointOf(8.4, 12.8),
        ).forEach { (multiplier, expected) ->
            val actual = MutablePoint(x = point.x, y = point.y)
            actual *= multiplier
            val message = """
                point: $point
                multiplier: ${multiplier.toString(24)}
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

    @Test
    fun divAssignTest() {
        val point = pointOf(4.2, 6.4)
        val points = 8
        val delta = 0.00000001
        listOf(
            -2.0 to pointOf(-2.1, -3.2),
//            0.0 to pointOf(0, 0),
            2.0 to pointOf(2.1, 3.2),
            1.0 to pointOf(4.2, 6.4),
            0.5 to pointOf(8.4, 12.8),
            (2.0 / 3.0) to pointOf(6.3, 9.6),
        ).forEach { (multiplier, expected) ->
            val actual = MutablePoint(x = point.x, y = point.y)
            actual /= multiplier
            val message = """
                point: $point
                multiplier: ${multiplier.toString(24)}
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

    @Test
    fun plusAssignTest() {
        val point = pointOf(4.2, 6.4)
        val points = 8
        val delta = 0.00000001
        listOf(
            -6.4 to pointOf(-2.2, 0.0),
            -4.2 to pointOf(0.0, 2.2),
            -0.5 to pointOf(3.7, 5.9),
            0.0 to pointOf(4.2, 6.4),
            0.5 to pointOf(4.7, 6.9),
            1.0 to pointOf(5.2, 7.4),
            1.5 to pointOf(5.7, 7.9),
            2.0 to pointOf(6.2, 8.4),
        ).forEach { (value, expected) ->
            val actual = MutablePoint(x = point.x, y = point.y)
            actual += value
            val message = """
                point: $point
                value: ${value.toString(24)}
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

    @Test
    fun minusAssignTest() {
        val point = pointOf(4.2, 6.4)
        val points = 8
        val delta = 0.00000001
        listOf(
            6.4 to pointOf(-2.2, 0.0),
            4.2 to pointOf(0.0, 2.2),
            0.5 to pointOf(3.7, 5.9),
            0.0 to pointOf(4.2, 6.4),
            -0.5 to pointOf(4.7, 6.9),
            -1.0 to pointOf(5.2, 7.4),
            -1.5 to pointOf(5.7, 7.9),
            -2.0 to pointOf(6.2, 8.4),
        ).forEach { (value, expected) ->
            val actual = MutablePoint(x = point.x, y = point.y)
            actual -= value
            val message = """
                point: $point
                value: ${value.toString(24)}
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

    @Test
    fun plusAssignOffsetTest() {
        val point = pointOf(1.2, 3.4)
        val points = 8
        val delta = 0.00000001
        listOf(
            offsetOf(-1.2, -3.4) to pointOf(0.0, 0.0),
            offsetOf(-1.2, 0.0) to pointOf(0.0, 3.4),
            offsetOf(0.0, -3.4) to pointOf(1.2, 0.0),
            offsetOf(0.0, 0.0) to pointOf(1.2, 3.4),
            offsetOf(0.0, 1.0) to pointOf(1.2, 4.4),
            offsetOf(1.0, 0.0) to pointOf(2.2, 3.4),
            offsetOf(1.0, 1.0) to pointOf(2.2, 4.4),
            offsetOf(2.8, 0.6) to pointOf(4.0, 4.0),
        ).forEach { (offset, expected) ->
            val actual = MutablePoint(x = point.x, y = point.y)
            actual += offset
            val message = """
                point: $point
                offset: $offset
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

    @Test
    fun minusAssignOffsetTest() {
        val point = pointOf(1.2, 3.4)
        val points = 8
        val delta = 0.00000001
        listOf(
            offsetOf(1.2, 3.4) to pointOf(0.0, 0.0),
            offsetOf(1.2, 0.0) to pointOf(0.0, 3.4),
            offsetOf(0.0, 3.4) to pointOf(1.2, 0.0),
            offsetOf(0.0, 0.0) to pointOf(1.2, 3.4),
            offsetOf(0.0, -1.0) to pointOf(1.2, 4.4),
            offsetOf(-1.0, 0.0) to pointOf(2.2, 3.4),
            offsetOf(-1.0, -1.0) to pointOf(2.2, 4.4),
            offsetOf(-2.8, -0.6) to pointOf(4.0, 4.0),
        ).forEach { (offset, expected) ->
            val actual = MutablePoint(x = point.x, y = point.y)
            actual -= offset
            val message = """
                point: $point
                offset: $offset
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
