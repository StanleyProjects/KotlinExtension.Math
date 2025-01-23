package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

internal class PointPlusTest {
    @Test
    fun plusTest() {
        val foo = pointOf(x = 1.2, y = 3.4)
        assertNotEquals(foo.x, foo.y)
        assertEquals(1.2, foo.x)
        assertEquals(3.4, foo.y)
        (5.6 to 7.8).also { (dX, dY) ->
            assertNotEquals(dX, dY)
            val bar = foo.plus(dX = dX, dY = dY)
            assertEquals(1.2, foo.x)
            assertEquals(3.4, foo.y)
            assertNotEquals(bar.x, bar.y)
            assertEquals(1.2 + dX, bar.x)
            assertEquals(3.4 + dY, bar.y)
            assertEquals(foo.x + dX, bar.x)
            assertEquals(foo.y + dY, bar.y)
        }
        (-1.28 to -2.56).also { (dX, dY) ->
            assertNotEquals(dX, dY)
            val bar = foo.plus(dX = dX, dY = dY)
            assertEquals(1.2, foo.x)
            assertEquals(3.4, foo.y)
            assertNotEquals(bar.x, bar.y)
            assertEquals(1.2 + dX, bar.x)
            assertEquals(3.4 + dY, bar.y)
            assertEquals(foo.x + dX, bar.x)
            assertEquals(foo.y + dY, bar.y)
        }
    }

    @Test
    fun plusOffsetTest() {
        val points = 8
        val delta = 0.00000001
        val point = pointOf(x = 1.2, y = 3.4)
        assertNotEquals(point.x, point.y)
        assertEquals(1.2, point.x)
        assertEquals(3.4, point.y)
        listOf(
            offsetOf(dX = 5.6, dY = 7.8),
            offsetOf(dX = -1.28, dY = -2.56),
        ).forEach { offset ->
            assertNotEquals(offset.dX, offset.dY)
            val actual = point + offset
            val message = """
                point: $point
                offset: $offset
                actual: $actual
                points: $points
                delta: ${delta.toString(24)}
            """.trimIndent()
            assertEquals(1.2, point.x, delta, message)
            assertEquals(3.4, point.y, delta, message)
            assertNotEquals(actual.x, actual.y)
            assertEquals(1.2 + offset.dX, actual.x, delta, message)
            assertEquals(3.4 + offset.dY, actual.y, delta, message)
            assertEquals(point.x + offset.dX, actual.x, delta, message)
            assertEquals(point.y + offset.dY, actual.y, delta, message)
        }
    }
}
