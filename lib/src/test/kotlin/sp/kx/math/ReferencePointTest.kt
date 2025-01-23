package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.Objects

internal class ReferencePointTest {
    @Test
    fun toStringTest() {
        assertEquals(pointOf(x = 1.0, y = 1.0).toString(), Point.Reference.toString())
    }

    @Test
    fun equalsTest() {
        assertEquals(Point.Reference.x, Point.Reference.y)
        assertEquals(1.0, Point.Reference.x)
        assertEquals(1.0, Point.Reference.y)
        val expected = pointOf(x = 1.0, y = 1.0)
        assertEquals(expected, Point.Reference)
        assertTrue(Point.Reference == expected)
        listOf(
            pointOf(1.0, 0.0),
            pointOf(0.0, 1.0),
        ).forEach { unexpected ->
            assertNotEquals(unexpected, Point.Reference)
            assertFalse(Point.Reference == unexpected)
        }
        assertFalse(Point.Reference.equals(null))
        assertNotEquals(Unit, Point.Reference)
        assertFalse(Point.Reference.equals(Unit))
    }

    @Test
    fun hashCodeTest() {
        val expected = Objects.hash(1.0, 1.0)
        val actual = Point.Reference.hashCode()
        assertEquals(expected, actual)
    }
}
