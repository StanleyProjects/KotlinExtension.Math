package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import java.util.Objects

internal class UndefinedPointTest {
    @Test
    fun toStringTest() {
        assertEquals(pointOf(x = Double.NaN, y = Double.NaN).toString(), Point.Undefined.toString())
    }

    @Test
    fun equalsTest() {
        assertEquals(Point.Undefined.x, Point.Undefined.y)
        assertEquals(Double.NaN, Point.Undefined.x)
        assertEquals(Double.NaN, Point.Undefined.y)
        assert(p1 = Point.Undefined, p2 = Point.Undefined, expected = true)
        assert(p1 = Point.Undefined, p2 = pointOf(x = Double.NaN, y = Double.NaN), expected = false)
        assertNotEquals(null, Point.Undefined)
        listOf(
            pointOf(x = Double.NaN, y = Double.NaN),
            pointOf(Double.NaN, 0.0),
            pointOf(0.0, Double.NaN),
        ).forEach { unexpected ->
            assertNotEquals(unexpected, Point.Undefined)
            assertFalse(Point.Undefined == unexpected)
        }
        assertNotEquals(Unit, Point.Undefined)
        assertFalse(Point.Undefined.equals(Unit))
    }

    @Test
    fun hashCodeTest() {
        val expected = Objects.hash(Double.NaN, Double.NaN)
        val actual = Point.Undefined.hashCode()
        assertEquals(expected, actual)
    }

    companion object {
        private fun assert(p1: Point, p2: Point, expected: Boolean) {
            val actual = p1 == p2
            val message = """
                p1: ${p1.toString(24)}
                p2: ${p2.toString(24)}
                actual: $actual
                expected: $expected
            """.trimIndent()
            assertEquals(actual, expected, message)
        }
    }
}
