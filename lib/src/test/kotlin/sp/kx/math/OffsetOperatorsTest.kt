package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import sp.kx.math.measure.measureOf

internal class OffsetOperatorsTest {
    @Test
    fun timesDoubleTest() {
        val offset = offsetOf(4.2, 6.4)
        val points = 12
        val delta = 0.00000001
        listOf(
            -0.5 to offsetOf(-2.1, -3.2),
            0.0 to offsetOf(0, 0),
            0.5 to offsetOf(2.1, 3.2),
            1.0 to offsetOf(4.2, 6.4),
            2.0 to offsetOf(8.4, 12.8),
            1.5 to offsetOf(6.3, 9.6),
        ).forEach { (multiplier, expected) ->
            val actual = offset * multiplier
            val message = """
                offset: $offset
                multiplier: $multiplier
                expected: $expected
                actual: $actual
                points: $points
                delta: $delta (${delta.toString(24)})
            """.trimIndent()
            assertEquals(expected.dX, actual.dX, delta, message)
            assertEquals(expected.dY, actual.dY, delta, message)
            assertTrue(expected.eq(other = actual, points = points), message)
        }
    }

    @Test
    fun divDoubleTest() {
        val offset = offsetOf(4.2, 6.4)
        val points = 12
        val delta = 0.00000001
        listOf(
            -2.0 to offsetOf(-2.1, -3.2),
//            0.0 to offsetOf(0, 0),
            2.0 to offsetOf(2.1, 3.2),
            1.0 to offsetOf(4.2, 6.4),
            0.5 to offsetOf(8.4, 12.8),
            (2.0 / 3.0) to offsetOf(6.3, 9.6),
        ).forEach { (multiplier, expected) ->
            val actual = offset / multiplier
            val message = """
                offset: $offset
                multiplier: $multiplier
                expected: $expected
                actual: $actual
                points: $points
                delta: $delta (${delta.toString(24)})
            """.trimIndent()
            assertEquals(expected.dX, actual.dX, delta, message)
            assertEquals(expected.dY, actual.dY, delta, message)
            assertTrue(expected.eq(other = actual, points = points), message)
        }
    }

    @Test
    fun timesMeasureTest() {
        val offset = offsetOf(4.2, 6.4)
        val points = 12
        val delta = 0.00000001
        listOf(
            -0.5 to offsetOf(-2.1, -3.2),
            0.0 to offsetOf(0, 0),
            0.5 to offsetOf(2.1, 3.2),
            1.0 to offsetOf(4.2, 6.4),
            2.0 to offsetOf(8.4, 12.8),
            1.5 to offsetOf(6.3, 9.6),
        ).forEach { (magnitude, expected) ->
            val measure = measureOf(magnitude = magnitude)
            val actual = offset * measure
            val message = """
                offset: $offset
                measure: $measure
                expected: $expected
                actual: $actual
                points: $points
                delta: $delta (${delta.toString(24)})
            """.trimIndent()
            assertEquals(expected.dX, actual.dX, delta, message)
            assertEquals(expected.dY, actual.dY, delta, message)
            assertTrue(expected.eq(other = actual, points = points), message)
        }
    }

    @Test
    fun divMeasureTest() {
        val offset = offsetOf(4.2, 6.4)
        val points = 12
        val delta = 0.00000001
        listOf(
            -2.0 to offsetOf(-2.1, -3.2),
//            0.0 to offsetOf(0, 0),
            2.0 to offsetOf(2.1, 3.2),
            1.0 to offsetOf(4.2, 6.4),
            0.5 to offsetOf(8.4, 12.8),
            (2.0 / 3.0) to offsetOf(6.3, 9.6),
        ).forEach { (magnitude, expected) ->
            val measure = measureOf(magnitude = magnitude)
            val actual = offset / measure
            val message = """
                offset: $offset
                measure: $measure
                expected: $expected
                actual: $actual
                points: $points
                delta: $delta (${delta.toString(24)})
            """.trimIndent()
            assertEquals(expected.dX, actual.dX, delta, message)
            assertEquals(expected.dY, actual.dY, delta, message)
            assertTrue(expected.eq(other = actual, points = points), message)
        }
    }

    @Test
    fun plusOffsetTest() {
        val offset = offsetOf(4.2, 6.4)
        val points = 12
        val delta = 0.00000001
        listOf(
            offsetOf(-4.2, -6.4) to offsetOf(0, 0),
            offsetOf(-1.2, -3.4) to offsetOf(3.0, 3.0),
            offsetOf(-1.2, 3.4) to offsetOf(3.0, 9.8),
            offsetOf(0.0, 0.0) to offsetOf(4.2, 6.4),
            offsetOf(0.0, 1.0) to offsetOf(4.2, 7.4),
            offsetOf(1.0, 0.0) to offsetOf(5.2, 6.4),
            offsetOf(1.2, -3.4) to offsetOf(5.4, 3.0),
            offsetOf(1.2, 3.4) to offsetOf(5.4, 9.8),
        ).forEach { (other, expected) ->
            val actual = offset + other
            val message = """
                offset: $offset
                other: $other
                expected: $expected
                actual: $actual
                points: $points
                delta: $delta (${delta.toString(24)})
            """.trimIndent()
            assertEquals(expected.dX, actual.dX, delta, message)
            assertEquals(expected.dY, actual.dY, delta, message)
            assertTrue(expected.eq(other = actual, points = points), message)
        }
    }

    @Test
    fun minusOffsetTest() {
        val offset = offsetOf(4.2, 6.4)
        val points = 12
        val delta = 0.00000001
        listOf(
            offsetOf(4.2, 6.4) to offsetOf(0, 0),
            offsetOf(1.2, 3.4) to offsetOf(3.0, 3.0),
            offsetOf(1.2, -3.4) to offsetOf(3.0, 9.8),
            offsetOf(0.0, 0.0) to offsetOf(4.2, 6.4),
            offsetOf(0.0, -1.0) to offsetOf(4.2, 7.4),
            offsetOf(-1.0, 0.0) to offsetOf(5.2, 6.4),
            offsetOf(-1.2, 3.4) to offsetOf(5.4, 3.0),
            offsetOf(-1.2, -3.4) to offsetOf(5.4, 9.8),
        ).forEach { (other, expected) ->
            val actual = offset - other
            val message = """
                offset: $offset
                other: $other
                expected: $expected
                actual: $actual
                points: $points
                delta: $delta (${delta.toString(24)})
            """.trimIndent()
            assertEquals(expected.dX, actual.dX, delta, message)
            assertEquals(expected.dY, actual.dY, delta, message)
            assertTrue(expected.eq(other = actual, points = points), message)
        }
    }
}
