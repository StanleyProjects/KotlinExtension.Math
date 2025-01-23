package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import sp.kx.math.measure.measureOf

internal class VectorOperatorsTest {
    @Test
    fun timesDoubleTest() {
        val vector = pointOf(1.2, 3.4) + pointOf(5.6, 7.8)
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
            val actual = vector * multiplier
            val message = """
                vector: $vector
                multiplier: $multiplier
                expected: $expected
                actual: $actual
                points: $points
                delta: $delta (${delta.toString(24)})
            """.trimIndent()
            assertEquals(expected.start.x, actual.start.x, delta, message)
            assertEquals(expected.start.x, actual.start.x, delta, message)
            assertEquals(expected.finish.y, actual.finish.y, delta, message)
            assertEquals(expected.finish.y, actual.finish.y, delta, message)
            assertTrue(expected.eq(other = actual, points = points), message)
        }
    }

    @Test
    fun divDoubleTest() {
        val vector = pointOf(1.2, 3.4) + pointOf(5.6, 7.8)
        val points = 12
        val delta = 0.00000001
        listOf(
            -1.0 to vectorOf(-1.2, -3.4, -5.6, -7.8),
            0.5 to vectorOf(2.4, 6.8, 11.2, 15.6),
            1.0 to vectorOf(1.2, 3.4, 5.6, 7.8),
            2.0 to vectorOf(0.6, 1.7, 2.8, 3.9),
        ).forEach { (multiplier, expected) ->
            val actual = vector / multiplier
            val message = """
                vector: $vector
                multiplier: $multiplier
                expected: $expected
                actual: $actual
                points: $points
                delta: $delta (${delta.toString(24)})
            """.trimIndent()
            assertEquals(expected.start.x, actual.start.x, delta, message)
            assertEquals(expected.start.x, actual.start.x, delta, message)
            assertEquals(expected.finish.y, actual.finish.y, delta, message)
            assertEquals(expected.finish.y, actual.finish.y, delta, message)
            assertTrue(expected.eq(other = actual, points = points), message)
        }
    }

    @Test
    fun timesMeasureTest() {
        val vector = pointOf(1.2, 3.4) + pointOf(5.6, 7.8)
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
        ).forEach { (magnitude, expected) ->
            val measure = measureOf(magnitude = magnitude)
            val actual = vector * measure
            val message = """
                vector: $vector
                measure: $measure
                expected: $expected
                actual: $actual
                points: $points
                delta: $delta (${delta.toString(24)})
            """.trimIndent()
            assertEquals(expected.start.x, actual.start.x, delta, message)
            assertEquals(expected.start.x, actual.start.x, delta, message)
            assertEquals(expected.finish.y, actual.finish.y, delta, message)
            assertEquals(expected.finish.y, actual.finish.y, delta, message)
            assertTrue(expected.eq(other = actual, points = points), message)
        }
    }

    @Test
    fun divMeasureTest() {
        val vector = pointOf(1.2, 3.4) + pointOf(5.6, 7.8)
        val points = 12
        val delta = 0.00000001
        listOf(
            -1.0 to vectorOf(-1.2, -3.4, -5.6, -7.8),
            0.5 to vectorOf(2.4, 6.8, 11.2, 15.6),
            1.0 to vectorOf(1.2, 3.4, 5.6, 7.8),
            2.0 to vectorOf(0.6, 1.7, 2.8, 3.9),
        ).forEach { (magnitude, expected) ->
            val measure = measureOf(magnitude = magnitude)
            val actual = vector / measure
            val message = """
                vector: $vector
                measure: $measure
                expected: $expected
                actual: $actual
                points: $points
                delta: $delta (${delta.toString(24)})
            """.trimIndent()
            assertEquals(expected.start.x, actual.start.x, delta, message)
            assertEquals(expected.start.x, actual.start.x, delta, message)
            assertEquals(expected.finish.y, actual.finish.y, delta, message)
            assertEquals(expected.finish.y, actual.finish.y, delta, message)
            assertTrue(expected.eq(other = actual, points = points), message)
        }
    }

    @Test
    fun plusOffsetTest() {
        val vector = pointOf(x = 1.2, y = 3.4) + pointOf(x = 5.6, y = 7.8)
        offsetOf(dX = 1.23, dY = 4.56).also { offset: Offset ->
            val actual = vector + offset
            assertEquals(actual.start.x, vector.start.x + offset.dX)
            assertEquals(actual.start.y, vector.start.y + offset.dY)
            assertEquals(actual.finish.x, vector.finish.x + offset.dX)
            assertEquals(actual.finish.y, vector.finish.y + offset.dY)
        }
        offsetOf(dX = -7.89, dY = -10.1112).also { offset: Offset ->
            val actual = vector + offset
            assertEquals(actual.start.x, vector.start.x + offset.dX)
            assertEquals(actual.start.y, vector.start.y + offset.dY)
            assertEquals(actual.finish.x, vector.finish.x + offset.dX)
            assertEquals(actual.finish.y, vector.finish.y + offset.dY)
        }
    }
}
