package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class EmptyVectorTest {
    @Test
    fun constructorTest() {
        val point = pointOf(x = 1.2, y = 3.4)
        Assertions.assertNotEquals(point.x, point.y)
        val actual = EmptyVector(start = point)
        Assertions.assertNotEquals(actual.start.x, actual.start.y)
        Assertions.assertNotEquals(actual.finish.x, actual.finish.y)
        Assertions.assertEquals(actual.start, actual.finish)
        Assertions.assertEquals(actual.start, point)
        Assertions.assertEquals(point.x, actual.start.x)
        Assertions.assertEquals(point.y, actual.start.y)
        Assertions.assertEquals(point.x, actual.finish.x)
        Assertions.assertEquals(point.y, actual.finish.y)
    }

    @Test
    fun toStringTest() {
        EmptyVector(start = pointOf(x = 1, y = 3)).also { vector: Vector ->
            Assertions.assertEquals("EmptyVector{x: 1.00, y: 3.00}", vector.toString())
        }
        EmptyVector(start = pointOf(x = 1.2, y = 3.4)).also { vector: Vector ->
            Assertions.assertEquals("EmptyVector{x: 1.20, y: 3.40}", vector.toString())
        }
        EmptyVector(start = pointOf(x = 1.23, y = 3.45)).also { vector: Vector ->
            Assertions.assertEquals("EmptyVector{x: 1.23, y: 3.45}", vector.toString())
        }
        EmptyVector(start = pointOf(x = 1.234, y = 3.456)).also { vector: Vector ->
            Assertions.assertEquals("EmptyVector{x: 1.23, y: 3.46}", vector.toString())
        }
    }

    @Test
    fun equalsTest() {
        val foo: Vector = EmptyVector(start = pointOf(x = 1, y = 3))
        val bar: Vector = pointOf(x = 1, y = 3) + pointOf(x = 1, y = 3)
        Assertions.assertEquals(foo, bar)
        Assertions.assertFalse(foo === bar)
        Assertions.assertTrue(foo == bar)
        Assertions.assertFalse(foo.start === bar.start)
        Assertions.assertTrue(foo.start == bar.start)
        Assertions.assertEquals(foo.start, bar.start)
        Assertions.assertFalse(foo.finish === bar.finish)
        Assertions.assertTrue(foo.finish == bar.finish)
        Assertions.assertEquals(foo.finish, bar.finish)
    }

    @Test
    fun equalsNotTest() {
        val vector: Vector = EmptyVector(start = pointOf(x = 1, y = 3))
        Assertions.assertFalse(vector.equals(Unit))
    }

    @Test
    fun equalsNotStartTest() {
        val actual: Vector = EmptyVector(start = pointOf(x = 1, y = 3))
        (pointOf(x = 1, y = 4) + pointOf(x = 1, y = 3)).also { unexpected: Vector ->
            Assertions.assertFalse(unexpected === actual)
            Assertions.assertNotEquals(unexpected, actual)
            Assertions.assertFalse(actual == unexpected)
            Assertions.assertFalse(unexpected == actual)
            Assertions.assertFalse(actual.finish === unexpected.finish)
            Assertions.assertTrue(actual.finish == unexpected.finish)
            Assertions.assertEquals(actual.finish, unexpected.finish)
            Assertions.assertFalse(actual.start === unexpected.start)
            Assertions.assertFalse(actual.start == unexpected.start)
            Assertions.assertNotEquals(actual.start, unexpected.start)
            Assertions.assertEquals(actual.start.x, unexpected.start.x)
            Assertions.assertNotEquals(actual.start.y, unexpected.start.y)
        }
        (pointOf(x = 2, y = 3) + pointOf(x = 1, y = 3)).also { unexpected: Vector ->
            Assertions.assertFalse(unexpected === actual)
            Assertions.assertNotEquals(unexpected, actual)
            Assertions.assertFalse(actual == unexpected)
            Assertions.assertFalse(unexpected == actual)
            Assertions.assertFalse(actual.finish === unexpected.finish)
            Assertions.assertTrue(actual.finish == unexpected.finish)
            Assertions.assertEquals(actual.finish, unexpected.finish)
            Assertions.assertFalse(actual.start === unexpected.start)
            Assertions.assertFalse(actual.start == unexpected.start)
            Assertions.assertNotEquals(actual.start, unexpected.start)
            Assertions.assertNotEquals(actual.start.x, unexpected.start.x)
            Assertions.assertEquals(actual.start.y, unexpected.start.y)
        }
    }

    @Test
    fun equalsNotFinishTest() {
        val actual: Vector = EmptyVector(start = pointOf(x = 1, y = 3))
        (pointOf(x = 1, y = 3) + pointOf(x = 1, y = 4)).also { unexpected: Vector ->
            Assertions.assertFalse(unexpected === actual)
            Assertions.assertNotEquals(unexpected, actual)
            Assertions.assertFalse(actual == unexpected)
            Assertions.assertFalse(unexpected == actual)
            Assertions.assertFalse(actual.start === unexpected.start)
            Assertions.assertTrue(actual.start == unexpected.start)
            Assertions.assertEquals(actual.start, unexpected.start)
            Assertions.assertFalse(actual.finish === unexpected.finish)
            Assertions.assertFalse(actual.finish == unexpected.finish)
            Assertions.assertNotEquals(actual.finish, unexpected.finish)
            Assertions.assertEquals(actual.finish.x, unexpected.finish.x)
            Assertions.assertNotEquals(actual.finish.y, unexpected.finish.y)
        }
        (pointOf(x = 1, y = 3) + pointOf(x = 2, y = 3)).also { unexpected: Vector ->
            Assertions.assertFalse(unexpected === actual)
            Assertions.assertNotEquals(unexpected, actual)
            Assertions.assertFalse(actual == unexpected)
            Assertions.assertFalse(unexpected == actual)
            Assertions.assertFalse(actual.start === unexpected.start)
            Assertions.assertTrue(actual.start == unexpected.start)
            Assertions.assertEquals(actual.start, unexpected.start)
            Assertions.assertFalse(actual.finish === unexpected.finish)
            Assertions.assertFalse(actual.finish == unexpected.finish)
            Assertions.assertNotEquals(actual.finish, unexpected.finish)
            Assertions.assertNotEquals(actual.finish.x, unexpected.finish.x)
            Assertions.assertEquals(actual.finish.y, unexpected.finish.y)
        }
    }

    @Test
    fun hashCodeTest() {
        @Suppress("IgnoredReturnValue")
        EmptyVector(start = pointOf(x = 1.2, y = 3.4)).hashCode()
    }

    @Test
    fun toVectorTest() {
        val point = pointOf(x = 1.2, y = 3.4)
        Assertions.assertNotEquals(point.x, point.y)
        val actual: Vector = point.toVector()
        Assertions.assertNotEquals(actual.start.x, actual.start.y)
        Assertions.assertNotEquals(actual.finish.x, actual.finish.y)
        Assertions.assertEquals(actual.start, actual.finish)
        Assertions.assertEquals(actual.start, point)
        Assertions.assertEquals(point.x, actual.start.x)
        Assertions.assertEquals(point.y, actual.start.y)
        Assertions.assertEquals(point.x, actual.finish.x)
        Assertions.assertEquals(point.y, actual.finish.y)
    }
}
