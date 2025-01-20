package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.Objects

internal class EmptyVectorTest {
    @Test
    fun constructorTest() {
        val point = pointOf(x = 1.2, y = 3.4)
        assertNotEquals(point.x, point.y)
        val actual = EmptyVector(start = point)
        assertNotEquals(actual.start.x, actual.start.y)
        assertNotEquals(actual.finish.x, actual.finish.y)
        assertEquals(actual.start, actual.finish)
        assertEquals(actual.start, point)
        assertEquals(point.x, actual.start.x)
        assertEquals(point.y, actual.start.y)
        assertEquals(point.x, actual.finish.x)
        assertEquals(point.y, actual.finish.y)
    }

    @Test
    fun toStringTest() {
        listOf(
            pointOf(x = -1, y = -1),
            pointOf(x = -1, y = 0),
            pointOf(x = 0, y = -1),
            pointOf(x = 0, y = 0),
            pointOf(x = 1, y = 3),
            pointOf(x = 1.2, y = 3.4),
            pointOf(x = 1.23, y = 3.45),
            pointOf(x = 1.234, y = 3.456),
        ).forEach { point ->
            assertEquals((point + point).toString(), point.toVector().toString())
        }
    }

    @Test
    fun equalsTest() {
        val foo: Vector = EmptyVector(start = pointOf(x = 1, y = 3))
        val bar: Vector = pointOf(x = 1, y = 3) + pointOf(x = 1, y = 3)
        assertEquals(foo, bar)
        assertFalse(foo === bar)
        assertTrue(foo == bar)
        assertFalse(foo.start === bar.start)
        assertTrue(foo.start == bar.start)
        assertEquals(foo.start, bar.start)
        assertFalse(foo.finish === bar.finish)
        assertTrue(foo.finish == bar.finish)
        assertEquals(foo.finish, bar.finish)
    }

    @Test
    fun equalsNotTest() {
        val vector: Vector = EmptyVector(start = pointOf(x = 1, y = 3))
        assertFalse(vector.equals(Unit))
    }

    @Test
    fun equalsNotStartTest() {
        val actual: Vector = EmptyVector(start = pointOf(x = 1, y = 3))
        (pointOf(x = 1, y = 4) + pointOf(x = 1, y = 3)).also { unexpected: Vector ->
            assertFalse(unexpected === actual)
            assertNotEquals(unexpected, actual)
            assertFalse(actual == unexpected)
            assertFalse(unexpected == actual)
            assertFalse(actual.finish === unexpected.finish)
            assertTrue(actual.finish == unexpected.finish)
            assertEquals(actual.finish, unexpected.finish)
            assertFalse(actual.start === unexpected.start)
            assertFalse(actual.start == unexpected.start)
            assertNotEquals(actual.start, unexpected.start)
            assertEquals(actual.start.x, unexpected.start.x)
            assertNotEquals(actual.start.y, unexpected.start.y)
        }
        (pointOf(x = 2, y = 3) + pointOf(x = 1, y = 3)).also { unexpected: Vector ->
            assertFalse(unexpected === actual)
            assertNotEquals(unexpected, actual)
            assertFalse(actual == unexpected)
            assertFalse(unexpected == actual)
            assertFalse(actual.finish === unexpected.finish)
            assertTrue(actual.finish == unexpected.finish)
            assertEquals(actual.finish, unexpected.finish)
            assertFalse(actual.start === unexpected.start)
            assertFalse(actual.start == unexpected.start)
            assertNotEquals(actual.start, unexpected.start)
            assertNotEquals(actual.start.x, unexpected.start.x)
            assertEquals(actual.start.y, unexpected.start.y)
        }
    }

    @Test
    fun equalsNotFinishTest() {
        val actual: Vector = EmptyVector(start = pointOf(x = 1, y = 3))
        (pointOf(x = 1, y = 3) + pointOf(x = 1, y = 4)).also { unexpected: Vector ->
            assertFalse(unexpected === actual)
            assertNotEquals(unexpected, actual)
            assertFalse(actual == unexpected)
            assertFalse(unexpected == actual)
            assertFalse(actual.start === unexpected.start)
            assertTrue(actual.start == unexpected.start)
            assertEquals(actual.start, unexpected.start)
            assertFalse(actual.finish === unexpected.finish)
            assertFalse(actual.finish == unexpected.finish)
            assertNotEquals(actual.finish, unexpected.finish)
            assertEquals(actual.finish.x, unexpected.finish.x)
            assertNotEquals(actual.finish.y, unexpected.finish.y)
        }
        (pointOf(x = 1, y = 3) + pointOf(x = 2, y = 3)).also { unexpected: Vector ->
            assertFalse(unexpected === actual)
            assertNotEquals(unexpected, actual)
            assertFalse(actual == unexpected)
            assertFalse(unexpected == actual)
            assertFalse(actual.start === unexpected.start)
            assertTrue(actual.start == unexpected.start)
            assertEquals(actual.start, unexpected.start)
            assertFalse(actual.finish === unexpected.finish)
            assertFalse(actual.finish == unexpected.finish)
            assertNotEquals(actual.finish, unexpected.finish)
            assertNotEquals(actual.finish.x, unexpected.finish.x)
            assertEquals(actual.finish.y, unexpected.finish.y)
        }
    }

    @Test
    fun hashCodeTest() {
        val point = pointOf(x = 1.2, y = 3.4)
        val expected = Objects.hash(point.x, point.y, point.x, point.y)
        val actual = EmptyVector(start = point).hashCode()
        assertEquals(expected, actual)
    }

    @Test
    fun toVectorTest() {
        val point = pointOf(x = 1.2, y = 3.4)
        assertNotEquals(point.x, point.y)
        val actual: Vector = point.toVector()
        assertNotEquals(actual.start.x, actual.start.y)
        assertNotEquals(actual.finish.x, actual.finish.y)
        assertEquals(actual.start, actual.finish)
        assertEquals(actual.start, point)
        assertEquals(point.x, actual.start.x)
        assertEquals(point.y, actual.start.y)
        assertEquals(point.x, actual.finish.x)
        assertEquals(point.y, actual.finish.y)
    }
}
