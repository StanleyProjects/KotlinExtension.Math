package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.math.absoluteValue
import kotlin.math.pow

internal class SizeUtilEqTest {
    @Test
    fun eqDeltaTest() {
        val value = 128.0001
        val other = 128.00010001
        (1..4).forEach { points ->
            assert(
                it = sizeOf(width = value, height = value),
                other = sizeOf(width = other, height = other),
                points = points,
                expected = true,
            )
        }
        assert(
            it = sizeOf(width = value, height = value),
            other = sizeOf(width = other, height = other),
            points = 8,
            expected = false,
        )
        val abs = (value - other).absoluteValue
        val delta = 10.0.pow(-4)
        assert(
            it = sizeOf(width = abs, height = abs),
            other = sizeOf(width = delta, height = delta),
            points = 3,
            expected = true,
        )
        assert(
            it = sizeOf(width = abs, height = abs),
            other = sizeOf(width = delta, height = delta),
            points = 5,
            expected = false,
        )
    }

    @Test
    fun eqOneTest() {
        for (points in 1..16) {
            for (e in 1..16) {
                if (points == e) continue
                assert(
                    it = sizeOf(width = 0.0, height = 0.0),
                    other = sizeOf(width = 10.0.pow(-e), height = 0.0),
                    points = points,
                    expected = points < e,
                )
            }
        }
    }

    @Test
    fun eqTest() {
        val size: Size = sizeOf(width = 1.23, height = 5.67)
        assertTrue(size.eq(other = sizeOf(width = 1.2, height = 5.6), points = 1))
        assertTrue(size.eq(other = sizeOf(width = 1.23, height = 5.67), points = 1))
        assertTrue(size.eq(other = sizeOf(width = 1.23, height = 5.67), points = 2))
        assertTrue(size.eq(other = sizeOf(width = 1.2356789, height = 5.67891234), points = 1))
        assertTrue(size.eq(other = sizeOf(width = 1.2356789, height = 5.67891234), points = 2))
    }

    @Test
    fun eqNotTest() {
        val size: Size = sizeOf(width = 1.23, height = 5.67)
        assertFalse(size.eq(other = sizeOf(width = -1.23, height = 5.67), points = 1))
        assertFalse(size.eq(other = sizeOf(width = 1.23, height = -5.67), points = 1))
        assertFalse(size.eq(other = sizeOf(width = 1.23, height = 5.67891234), points = 3))
        assertFalse(size.eq(other = sizeOf(width = 1.2356789, height = 5.67), points = 3))
        assertFalse(size.eq(other = sizeOf(width = 1.2356789, height = 5.67891234), points = 3))
        assertFalse(size.eq(other = sizeOf(width = 1.2356789, height = 5.67891234), points = 4))
        assertFalse(size.eq(other = sizeOf(width = 1.2356789, height = 5.67891234), points = 8))
    }

    @Test
    fun eqErrorTest() {
        assertThrows(IllegalArgumentException::class.java) {
            sizeOf(width = 1.2, height = 4.3).eq(other = sizeOf(width = 1.2, height = 4.3), points = -1)
        }
        assertThrows(IllegalArgumentException::class.java) {
            sizeOf(width = 1.2, height = 4.3).eq(other = sizeOf(width = 1.2, height = 4.3), points = 0)
        }
    }

    companion object {
        private fun assert(it: Size, other: Size, points: Int, expected: Boolean) {
            val actual = it.eq(other = other, points = points)
            val message = """
                this: $it (${it.toString(24)})
                that: $other (${other.toString(24)})
                points: $points
                expected: $expected
                actual: $actual
            """.trimIndent()
            assertEquals(expected, actual, message)
        }
    }
}
