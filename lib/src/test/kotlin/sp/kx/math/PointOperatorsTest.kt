package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import sp.kx.math.measure.measureOf

internal class PointOperatorsTest {
    @Test
    fun timesDoubleTest() {
        val point = pointOf(4.2, 6.4)
        val points = 12
        val delta = 0.00000001
        listOf(
            -0.5 to pointOf(-2.1, -3.2),
            0.0 to pointOf(0, 0),
            0.5 to pointOf(2.1, 3.2),
            1.0 to pointOf(4.2, 6.4),
            2.0 to pointOf(8.4, 12.8),
            1.5 to pointOf(6.3, 9.6),
        ).forEach { (multiplier, expected) ->
            val actual = point * multiplier
            val message = """
                point: $point
                multiplier: $multiplier
                expected: $expected
                actual: $actual
                points: $points
                delta: $delta (${delta.toString(24)})
            """.trimIndent()
            assertEquals(expected.x, actual.x, delta, message)
            assertEquals(expected.y, actual.y, delta, message)
            assertTrue(expected.eq(other = actual, points = points), message)
        }
    }

    @Test
    fun divDoubleTest() {
        val point = pointOf(4.2, 6.4)
        val points = 12
        val delta = 0.00000001
        listOf(
            -2.0 to pointOf(-2.1, -3.2),
//            0.0 to pointOf(0, 0),
            2.0 to pointOf(2.1, 3.2),
            1.0 to pointOf(4.2, 6.4),
            0.5 to pointOf(8.4, 12.8),
            (2.0 / 3.0) to pointOf(6.3, 9.6),
        ).forEach { (multiplier, expected) ->
            val actual = point / multiplier
            val message = """
                point: $point
                multiplier: $multiplier
                expected: $expected
                actual: $actual
                points: $points
                delta: $delta (${delta.toString(24)})
            """.trimIndent()
            assertEquals(expected.x, actual.x, delta, message)
            assertEquals(expected.y, actual.y, delta, message)
            assertTrue(expected.eq(other = actual, points = points), message)
        }
    }

    @Test
    fun timesMeasureTest() {
        val point = pointOf(4.2, 6.4)
        val points = 12
        val delta = 0.00000001
        listOf(
            -0.5 to pointOf(-2.1, -3.2),
            0.0 to pointOf(0, 0),
            0.5 to pointOf(2.1, 3.2),
            1.0 to pointOf(4.2, 6.4),
            2.0 to pointOf(8.4, 12.8),
            1.5 to pointOf(6.3, 9.6),
        ).forEach { (magnitude, expected) ->
            val measure = measureOf(magnitude = magnitude)
            val actual = point * measure
            val message = """
                point: $point
                measure: $measure
                expected: $expected
                actual: $actual
                points: $points
                delta: $delta (${delta.toString(24)})
            """.trimIndent()
            assertEquals(expected.x, actual.x, delta, message)
            assertEquals(expected.y, actual.y, delta, message)
            assertTrue(expected.eq(other = actual, points = points), message)
        }
    }

    @Test
    fun divMeasureTest() {
        val point = pointOf(4.2, 6.4)
        val points = 12
        val delta = 0.00000001
        listOf(
            -2.0 to pointOf(-2.1, -3.2),
//            0.0 to pointOf(0, 0),
            2.0 to pointOf(2.1, 3.2),
            1.0 to pointOf(4.2, 6.4),
            0.5 to pointOf(8.4, 12.8),
            (2.0 / 3.0) to pointOf(6.3, 9.6),
        ).forEach { (magnitude, expected) ->
            val measure = measureOf(magnitude = magnitude)
            val actual = point / measure
            val message = """
                point: $point
                measure: $measure
                expected: $expected
                actual: $actual
                points: $points
                delta: $delta (${delta.toString(24)})
            """.trimIndent()
            assertEquals(expected.x, actual.x, delta, message)
            assertEquals(expected.y, actual.y, delta, message)
            assertTrue(expected.eq(other = actual, points = points), message)
        }
    }
}
