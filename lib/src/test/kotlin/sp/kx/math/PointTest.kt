package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.Objects

internal class PointTest {
    @Test
    fun pointOfTest() {
        val actual: Point = pointOf(
            x = 1.2,
            y = 3.4,
        )
        assertNotEquals(actual.x, actual.y)
        assertEquals(1.2, actual.x)
        assertEquals(3.4, actual.y)
    }

    @Test
    fun centerTest() {
        assertEquals(Point.Center.x, Point.Center.y)
        assertEquals(0.0, Point.Center.x)
        assertEquals(0.0, Point.Center.y)
        assertEquals(pointOf(0.0, 0.0).toString(points = 2), Point.Center.toString())
        assertEquals(Objects.hash(0.0, 0.0), Point.Center.hashCode())
        assertEquals(pointOf(0.0, 0.0), Point.Center)
        assertTrue(Point.Center == pointOf(0.0, 0.0))
        assertNotEquals(pointOf(1.0, 0.0), Point.Center)
        assertFalse(Point.Center == pointOf(1.0, 0.0))
        assertNotEquals(pointOf(0.0, 1.0), Point.Center)
        assertFalse(Point.Center == pointOf(0.0, 1.0))
        assertNotEquals(null, Point.Center)
        assertNotEquals(Unit, Point.Center)
        assertFalse(Point.Center.equals(Unit))
    }

    @Test
    fun pointOfIntsTest() {
        pointOf(x = 0, y = 0).also { actual ->
            assertEquals(actual.x, actual.y)
            assertEquals(.0, actual.x)
            assertEquals(.0, actual.y)
        }
        pointOf(x = 1, y = 3).also { actual ->
            assertNotEquals(actual.x, actual.y)
            assertEquals(1.0, actual.x)
            assertEquals(3.0, actual.y)
        }
        pointOf(x = -2, y = -5).also { actual ->
            assertNotEquals(actual.x, actual.y)
            assertEquals(-2.0, actual.x)
            assertEquals(-5.0, actual.y)
        }
    }
}
