package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class OffsetPlusTest {
    private class Env(
        val offset: Offset,
        val size: Size,
        val actual: Offset,
        val expected: Offset,
    )

    @Test
    fun plusSizeTest() {
        val delta = 0.0001
        val points = 4
        val issues = listOf(
            -1.0 to -1.0,
            -1.0 to 0.0,
            0.0 to -1.0,
            0.0 to 0.0,
            0.0 to 1.0,
            1.0 to -1.0,
            1.0 to 0.0,
            1.0 to 1.0,
            1.2 to 3.4,
            5.6 to 7.8,
        )
        issues.forEach { o ->
            val offset = offsetOf(dX = o.first, dY = o.second)
            issues.forEach { s ->
                val size = sizeOf(width = s.first, height = s.second)
                val actual = offset + size
                val expected = offsetOf(dX = offset.dX + size.width, dY = offset.dY + size.height)
                val message = """
                    offset: $offset (${offset.toString(24)})
                    size: $size (${size.toString(24)})
                    actual: $actual (${actual.toString(24)})
                    expected: $expected (${expected.toString(24)})
                    delta: $delta (${delta.toString(24)})
                    points: $points
                """.trimIndent()
                assertEquals(actual.dX, expected.dX, delta, message)
                assertEquals(actual.dY, expected.dY, delta, message)
                assertEquals(expected, actual, message)
                assertTrue(expected.eq(other = actual, points = points), message)
            }
        }
    }

    @Test
    fun plusSizeMultiplierTest() {
        val delta = 0.0001
        val points = 4
        val issues = listOf(
            -1.0 to -1.0,
            -1.0 to 0.0,
            0.0 to -1.0,
            0.0 to 0.0,
            0.0 to 1.0,
            1.0 to -1.0,
            1.0 to 0.0,
            1.0 to 1.0,
            1.2 to 3.4,
            5.6 to 7.8,
        )
        val multipliers = setOf(
            -1.0,
            0.0,
            0.5,
            1.0,
            1.2,
            2.0,
        )
        issues.forEach { o ->
            val offset = offsetOf(dX = o.first, dY = o.second)
            issues.forEach { s ->
                val size = sizeOf(width = s.first, height = s.second)
                multipliers.forEach { multiplier ->
                    val actual = offset.plus(size = size, multiplier = multiplier)
                    val expected = offsetOf(dX = offset.dX + size.width * multiplier, dY = offset.dY + size.height * multiplier)
                    val message = """
                        offset: $offset (${offset.toString(24)})
                        size: $size (${size.toString(24)})
                        actual: $actual (${actual.toString(24)})
                        expected: $expected (${expected.toString(24)})
                        delta: $delta (${delta.toString(24)})
                        points: $points
                    """.trimIndent()
                    assertEquals(actual.dX, expected.dX, delta, message)
                    assertEquals(actual.dY, expected.dY, delta, message)
                    assertEquals(expected, actual, message)
                    assertTrue(expected.eq(other = actual, points = points), message)
                }
            }
        }
    }
}
