package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class SizeUtilTest {
    @Test
    fun toOffsetTest() {
        val width = 1.2
        val height = 3.4
        val size: Size = sizeOf(width = width, height = height)
        assertNotEquals(size.width, size.height)
        assertEquals(width, size.width)
        assertEquals(height, size.height)
        val offset: Offset = size.toOffset()
        assertFalse(offset === size)
        assertEquals(width, offset.dX)
        assertEquals(height, offset.dY)
        assertEquals(size.width, offset.dX)
        assertEquals(size.height, offset.dY)
    }

    @Test
    fun centerTest() {
        val width = 1.2
        val height = 3.4
        val size: Size = sizeOf(width = width, height = height)
        assertNotEquals(size.width, size.height)
        assertEquals(width, size.width)
        assertEquals(height, size.height)
        val offset: Offset = size.center()
        assertNotEquals(width, offset.dX)
        assertNotEquals(height, offset.dY)
        assertNotEquals(size.width, offset.dX)
        assertNotEquals(size.height, offset.dY)
        assertEquals(width / 2, offset.dX)
        assertEquals(height / 2, offset.dY)
        assertEquals(size.width / 2, offset.dX)
        assertEquals(size.height / 2, offset.dY)
    }

    @Test
    fun centerPointTest() {
        val width = 1.2
        val height = 3.4
        val size: Size = sizeOf(width = width, height = height)
        assertNotEquals(size.width, size.height)
        assertEquals(width, size.width)
        assertEquals(height, size.height)
        val point: Point = size.centerPoint()
        assertNotEquals(width, point.x)
        assertNotEquals(height, point.y)
        assertNotEquals(size.width, point.x)
        assertNotEquals(size.height, point.y)
        assertEquals(width / 2, point.x)
        assertEquals(height / 2, point.y)
        assertEquals(size.width / 2, point.x)
        assertEquals(size.height / 2, point.y)
    }

    @Test
    fun toStringTest() {
        val size: Size = sizeOf(width = 1.234, height = 5.67)
        assertEquals("1x6", size.toString(points = 0))
        assertEquals("1.2x5.7", size.toString(points = 1))
        assertEquals("1.23x5.67", size.toString(points = 2))
        assertEquals("1.234x5.670", size.toString(points = 3))
        assertEquals("1.23400000x5.67000000", size.toString(points = 8))
    }

    @Test
    fun toStringErrorTest() {
        assertThrows(IllegalStateException::class.java) {
            sizeOf(width = 1.2, height = 4.3).toString(points = -1)
        }
    }

    @Test
    fun sizeOfTest() {
        val foo: Size = sizeOf(
            width = 1,
            height = 2,
        )
        assertNotEquals(foo.width, foo.height)
        assertEquals(1.0, foo.width)
        assertEquals(2.0, foo.height)
    }

    @Test
    fun diagonalTest() {
        val delta = 0.0001
        val points = 4
        listOf(
            Triple(-1.2, -3.4, 3.6055),
            Triple(-1.2, 3.4, 3.6055),
            Triple(0.0, 0.0, 0.0),
            Triple(1.0, 1.0, 1.4142),
            Triple(1.2, -3.4, 3.6055),
            Triple(1.2, 3.4, 3.6055),
            Triple(5.6, 7.8, 9.6020),
        ).forEach { (width, height, expected) ->
            val size = sizeOf(width = width, height = height)
            val actual = size.diagonal()
            val message = """
                size: $size
                actual: $actual (${actual.toString(24)})
                expected: $expected (${expected.toString(24)})
                delta: $delta (${delta.toString(24)})
                points: $points
            """.trimIndent()
            assertEquals(expected, actual, delta, message)
            assertTrue(expected.eq(other = actual, points = points), message)
            val vector = Point.Center + pointOf(width, height)
            assertEquals(vector.length(), actual, delta, message)
        }
    }

    @Test
    fun diagonalAngle() {
        val delta = 0.0001
        val points = 4
        listOf(
            Triple(-1.2, -3.4, -1.91),
            Triple(-1.2, 3.4, 1.91),
            Triple(-1.0, -1.0, -(kotlin.math.PI / 4) * 3),
            Triple(-1.0, 1.0, (kotlin.math.PI / 4) * 3),
//            Triple(0.0, 0.0, 0.0),
            Triple(1.0, -1.0, -(kotlin.math.PI / 4) * 1),
            Triple(1.0, 1.0, (kotlin.math.PI / 4) * 1),
            Triple(1.2, -3.4, -1.2315),
            Triple(1.2, 3.4, 1.2315),
            Triple(1.0, 2.0, 1.1071),
            Triple(5.6, 7.8, 0.9481),
        ).forEach { (width, height, expected) ->
            val size = sizeOf(width = width, height = height)
            val actual = size.diagonalAngle()
            val message = """
                size: $size
                actual: $actual (${actual.toString(24)})
                expected: $expected (${expected.toString(24)})
                delta: $delta (${delta.toString(24)})
                points: $points
            """.trimIndent()
            assertEquals(expected, actual, delta, message)
            assertTrue(expected.eq(other = actual, points = points), message)
            val vector = Point.Center + pointOf(width, height)
            assertEquals(vector.angle(), actual, delta, message)
        }
    }
}
