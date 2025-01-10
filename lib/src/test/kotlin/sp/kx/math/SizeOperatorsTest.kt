package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import sp.kx.math.measure.measureOf

internal class SizeOperatorsTest {
    @Test
    fun timesDoubleTest() {
        val size = sizeOf(4, 6)
        listOf(
            -0.5 to sizeOf(-2, -3),
            0.0 to sizeOf(0, 0),
            0.5 to sizeOf(2, 3),
            1.0 to sizeOf(4, 6),
            2.0 to sizeOf(8, 12),
            1.5 to sizeOf(6, 9),
        ).forEach { (multiplier, expected) ->
            val actual = size * multiplier
            val message = """
                size: $size
                multiplier: $multiplier
            """.trimIndent()
            assertEquals(expected, actual, message)
        }
    }

    @Test
    fun divDoubleTest() {
        val size = sizeOf(4, 6)
        listOf(
            -2.0 to sizeOf(-2, -3),
//            0.0 to sizeOf(0, 0),
            2.0 to sizeOf(2, 3),
            1.0 to sizeOf(4, 6),
            0.5 to sizeOf(8, 12),
            (2.0/3.0) to sizeOf(6, 9),
        ).forEach { (multiplier, expected) ->
            val actual = size / multiplier
            val message = """
                size: $size
                multiplier: $multiplier
            """.trimIndent()
            assertEquals(expected, actual, message)
        }
    }

    @Test
    fun timesMeasureTest() {
        val size = sizeOf(4, 6)
        listOf(
            -0.5 to sizeOf(-2, -3),
            0.0 to sizeOf(0, 0),
            0.5 to sizeOf(2, 3),
            1.0 to sizeOf(4, 6),
            2.0 to sizeOf(8, 12),
            1.5 to sizeOf(6, 9),
        ).forEach { (magnitude, expected) ->
            val measure = measureOf(magnitude = magnitude)
            val actual = size * measure
            val message = """
                size: $size
                measure: $measure
            """.trimIndent()
            assertEquals(expected, actual, message)
        }
    }

    @Test
    fun divMeasureTest() {
        val size = sizeOf(4, 6)
        listOf(
            -2.0 to sizeOf(-2, -3),
//            0.0 to sizeOf(0, 0),
            2.0 to sizeOf(2, 3),
            1.0 to sizeOf(4, 6),
            0.5 to sizeOf(8, 12),
            (2.0/3.0) to sizeOf(6, 9),
        ).forEach { (magnitude, expected) ->
            val measure = measureOf(magnitude = magnitude)
            val actual = size / measure
            val message = """
                size: $size
                measure: $measure
            """.trimIndent()
            assertEquals(expected, actual, message)
        }
    }

    @Test
    fun plusSizeTest() {
        val size = sizeOf(4, 6)
        listOf(
            sizeOf(-1, -1) to sizeOf(3, 5),
            sizeOf(-1, 0) to sizeOf(3, 6),
            sizeOf(0, -1) to sizeOf(4, 5),
            sizeOf(0, 0) to sizeOf(4, 6),
            sizeOf(1, 1) to sizeOf(5, 7),
            sizeOf(3, 2) to sizeOf(7, 8),
        ).forEach { (other, expected) ->
            val actual = size + other
            assertEquals(expected, actual)
        }
    }

    @Test
    fun minusSizeTest() {
        val size = sizeOf(4, 6)
        listOf(
            sizeOf(1, 1) to sizeOf(3, 5),
            sizeOf(1, 0) to sizeOf(3, 6),
            sizeOf(0, 1) to sizeOf(4, 5),
            sizeOf(0, 0) to sizeOf(4, 6),
            sizeOf(-1, -1) to sizeOf(5, 7),
            sizeOf(-3, -2) to sizeOf(7, 8),
        ).forEach { (other, expected) ->
            val actual = size - other
            assertEquals(expected, actual)
        }
    }
}
