package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import sp.kx.math.measure.measureOf

internal class SizeOperatorsTest {
    @Test
    fun timesDoubleTest() {
        val size = sizeOf(4.2, 6.4)
        val points = 12
        listOf(
            -0.5 to sizeOf(-2.1, -3.2),
            0.0 to sizeOf(0, 0),
            0.5 to sizeOf(2.1, 3.2),
            1.0 to sizeOf(4.2, 6.4),
            2.0 to sizeOf(8.4, 12.8),
            1.5 to sizeOf(6.3, 9.6),
        ).forEach { (multiplier, expected) ->
            val actual = size * multiplier
            val message = """
                size: $size
                multiplier: $multiplier
                expected: $expected
                expected:width: ${expected.width}
                expected:height: ${expected.height}
                actual: $actual
                actual:width: ${actual.width}
                actual:height: ${actual.height}
                points: $points
            """.trimIndent()
            assertTrue(expected.eq(other = actual, points = points), message)
        }
    }

    @Test
    fun divDoubleTest() {
        val size = sizeOf(4.2, 6.4)
        val points = 12
        listOf(
            -2.0 to sizeOf(-2.1, -3.2),
//            0.0 to sizeOf(0, 0),
            2.0 to sizeOf(2.1, 3.2),
            1.0 to sizeOf(4.2, 6.4),
            0.5 to sizeOf(8.4, 12.8),
            (2.0 / 3.0) to sizeOf(6.3, 9.6),
        ).forEach { (multiplier, expected) ->
            val actual = size / multiplier
            val message = """
                size: $size
                multiplier: $multiplier
                expected: $expected
                expected:width: ${expected.width}
                expected:height: ${expected.height}
                actual: $actual
                actual:width: ${actual.width}
                actual:height: ${actual.height}
                points: $points
            """.trimIndent()
            assertTrue(expected.eq(other = actual, points = points), message)
        }
    }

    @Test
    fun timesMeasureTest() {
        val size = sizeOf(4.2, 6.4)
        val points = 12
        listOf(
            -0.5 to sizeOf(-2.1, -3.2),
            0.0 to sizeOf(0, 0),
            0.5 to sizeOf(2.1, 3.2),
            1.0 to sizeOf(4.2, 6.4),
            2.0 to sizeOf(8.4, 12.8),
            1.5 to sizeOf(6.3, 9.6),
        ).forEach { (magnitude, expected) ->
            val measure = measureOf(magnitude = magnitude)
            val actual = size * measure
            val message = """
                size: $size
                measure: $measure
                expected: $expected
                expected:width: ${expected.width}
                expected:height: ${expected.height}
                actual: $actual
                actual:width: ${actual.width}
                actual:height: ${actual.height}
                points: $points
            """.trimIndent()
            assertTrue(expected.eq(other = actual, points = points), message)
        }
    }

    @Test
    fun divMeasureTest() {
        val size = sizeOf(4.2, 6.4)
        val points = 12
        listOf(
            -2.0 to sizeOf(-2.1, -3.2),
//            0.0 to sizeOf(0, 0),
            2.0 to sizeOf(2.1, 3.2),
            1.0 to sizeOf(4.2, 6.4),
            0.5 to sizeOf(8.4, 12.8),
            (2.0 / 3.0) to sizeOf(6.3, 9.6),
        ).forEach { (magnitude, expected) ->
            val measure = measureOf(magnitude = magnitude)
            val actual = size / measure
            val message = """
                size: $size
                measure: $measure
                expected: $expected
                expected:width: ${expected.width}
                expected:height: ${expected.height}
                actual: $actual
                actual:width: ${actual.width}
                actual:height: ${actual.height}
                points: $points
            """.trimIndent()
            assertTrue(expected.eq(other = actual, points = points), message)
        }
    }

    @Test
    fun plusSizeTest() {
        val size = sizeOf(4.2, 6.4)
        val points = 12
        listOf(
            sizeOf(-1.1, -1.4) to sizeOf(3.1, 5.0),
            sizeOf(-1.2, +0.5) to sizeOf(3.0, 6.9),
            sizeOf(+0.3, -1.6) to sizeOf(4.5, 4.8),
            sizeOf(+0.0, +0.0) to sizeOf(4.2, 6.4),
            sizeOf(+1.7, +1.9) to sizeOf(5.9, 8.3),
            sizeOf(+3.8, +2.0) to sizeOf(8.0, 8.4),
        ).forEach { (other, expected) ->
            val actual = size + other
            val message = """
                size:width: ${size.width}
                size:height: ${size.height}
                other:width: ${other.width}
                other:height: ${other.height}
                expected:width: ${expected.width}
                expected:height: ${expected.height}
                actual:width: ${actual.width}
                actual:height: ${actual.height}
                points: $points
            """.trimIndent()
            assertTrue(expected.eq(other = actual, points = points), message)
        }
    }

    @Test
    fun minusSizeTest() {
        val size = sizeOf(4.2, 6.4)
        val delta = 0.0000000000001
        listOf(
            sizeOf(+1.1, +1.4) to sizeOf(3.1, 5.0),
            sizeOf(+1.2, -0.5) to sizeOf(3.0, 6.9),
            sizeOf(-0.3, +1.6) to sizeOf(4.5, 4.8),
            sizeOf(-0.0, -0.0) to sizeOf(4.2, 6.4),
            sizeOf(-1.7, -1.9) to sizeOf(5.9, 8.3),
            sizeOf(-3.8, -2.0) to sizeOf(8.0, 8.4),
        ).forEach { (other, expected) ->
            val actual = size - other
            val message = """
                size:width: ${size.width}
                size:height: ${size.height}
                other:width: ${other.width}
                other:height: ${other.height}
                expected:width: ${expected.width}
                expected:height: ${expected.height}
                actual:width: ${actual.width}
                actual:height: ${actual.height}
                delta: $delta
            """.trimIndent()
            assertEquals(
                expected.width,
                actual.width,
                delta,
                message,
            )
            assertEquals(
                expected.height,
                actual.height,
                delta,
                message,
            )
        }
    }
}
