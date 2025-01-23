package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class OffsetPlusTest {
    @Test
    fun plusDoublesTest() {
        val points = 8
        val delta = 0.00000001
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
            issues.forEach { (dX, dY) ->
                val actual = offset.plus(dX = dX, dY = dY)
                val expected = offsetOf(dX = offset.dX + dX, dY = offset.dY + dY)
                assert(expected = expected, actual = actual, points = points, delta = delta)
            }
        }
    }

    @Test
    fun plusDoublesMultiplierTest() {
        val points = 8
        val delta = 0.00000001
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
            issues.forEach { (dX, dY) ->
                multipliers.forEach { multiplier ->
                    val actual = offset.plus(dX = dX, dY = dY, multiplier = multiplier)
                    val expected = offsetOf(dX = offset.dX + dX * multiplier, dY = offset.dY + dY * multiplier)
                    assert(expected = expected, actual = actual, points = points, delta = delta)
                }
            }
        }
    }

    @Test
    fun plusSizeTest() {
        val points = 8
        val delta = 0.00000001
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
                assert(expected = expected, actual = actual, points = points, delta = delta)
            }
        }
    }

    @Test
    fun plusSizeDoublesTest() {
        val points = 8
        val delta = 0.00000001
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
                issues.forEach { (dX, dY) ->
                    val actual = offset.plus(size = size, dX = dX, dY = dY)
                    val expected = offsetOf(dX = offset.dX + size.width + dX, dY = offset.dY + size.height + dY)
                    assert(expected = expected, actual = actual, points = points, delta = delta)
                }
            }
        }
    }

    @Test
    fun plusSizeMultiplierTest() {
        val points = 8
        val delta = 0.00000001
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
                    assert(expected = expected, actual = actual, points = points, delta = delta)
                }
            }
        }
    }

    @Test
    fun plusSizeDoublesMultiplierTest() {
        val points = 8
        val delta = 0.00000001
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
                issues.forEach { (dX, dY) ->
                    multipliers.forEach { multiplier ->
                        val actual = offset.plus(size = size, dX = dX, dY = dY, multiplier = multiplier)
                        val expected = offsetOf(
                            dX = offset.dX + (size.width + dX) * multiplier,
                            dY = offset.dY + (size.height + dY) * multiplier,
                        )
                        assert(expected = expected, actual = actual, points = points, delta = delta)
                    }
                }
            }
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
