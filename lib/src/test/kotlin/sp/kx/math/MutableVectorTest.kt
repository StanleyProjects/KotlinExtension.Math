package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class MutableVectorTest {
    @Test
    fun constructorTest() {
        val actual = MutableVector(
            start = MutablePoint(x = 1.2, y = 3.4),
            finish = MutablePoint(x = 5.6, y = 7.8),
        )
        Assertions.assertNotEquals(actual.start.x, actual.start.y)
        Assertions.assertNotEquals(actual.finish.x, actual.finish.y)
        Assertions.assertEquals(1.2, actual.start.x)
        Assertions.assertEquals(3.4, actual.start.y)
        Assertions.assertEquals(5.6, actual.finish.x)
        Assertions.assertEquals(7.8, actual.finish.y)
        actual.start.x = 1.28
        Assertions.assertEquals(1.28, actual.start.x)
        Assertions.assertEquals(3.4, actual.start.y)
        Assertions.assertEquals(5.6, actual.finish.x)
        Assertions.assertEquals(7.8, actual.finish.y)
        actual.start.y = 2.56
        Assertions.assertEquals(1.28, actual.start.x)
        Assertions.assertEquals(2.56, actual.start.y)
        Assertions.assertEquals(5.6, actual.finish.x)
        Assertions.assertEquals(7.8, actual.finish.y)
        actual.finish.x = 5.12
        Assertions.assertEquals(1.28, actual.start.x)
        Assertions.assertEquals(2.56, actual.start.y)
        Assertions.assertEquals(5.12, actual.finish.x)
        Assertions.assertEquals(7.8, actual.finish.y)
        actual.finish.y = 10.24
        Assertions.assertEquals(1.28, actual.start.x)
        Assertions.assertEquals(2.56, actual.start.y)
        Assertions.assertEquals(5.12, actual.finish.x)
        Assertions.assertEquals(10.24, actual.finish.y)
    }

    @Test
    fun toStringTest() {
        MutableVector(
            start = MutablePoint(x = 1.2, y = 3.4),
            finish = MutablePoint(x = 5.6, y = 7.8),
        ).also { actual ->
            Assertions.assertEquals("{x: 1.20, y: 3.40} -> {x: 5.60, y: 7.80}", actual.toString())
        }
        MutableVector(
            start = MutablePoint(x = 1.23, y = 3.45),
            finish = MutablePoint(x = 5.67, y = 7.89),
        ).also { actual ->
            Assertions.assertEquals("{x: 1.23, y: 3.45} -> {x: 5.67, y: 7.89}", actual.toString())
        }
        MutableVector(
            start = MutablePoint(x = 1.234, y = 3.456),
            finish = MutablePoint(x = 5.678, y = 7.891),
        ).also { actual ->
            Assertions.assertEquals("{x: 1.23, y: 3.46} -> {x: 5.68, y: 7.89}", actual.toString())
        }
    }

    @Test
    fun equalsTest() {
        val foo = MutableVector(
            start = MutablePoint(x = 1.2, y = 3.4),
            finish = MutablePoint(x = 5.6, y = 7.8),
        )
        val bar = MutableVector(
            start = MutablePoint(x = 1.2, y = 3.4),
            finish = MutablePoint(x = 5.6, y = 7.8),
        )
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
        val actual = MutableVector(
            start = MutablePoint(x = 1.2, y = 3.4),
            finish = MutablePoint(x = 5.6, y = 7.8),
        )
        Assertions.assertFalse(actual.equals(Unit))
    }

    @Test
    fun equalsNotFinishTest() {
        val actual = MutableVector(
            start = MutablePoint(x = 1.2, y = 3.4),
            finish = MutablePoint(x = 5.6, y = 7.8),
        )
        MutableVector(
            start = MutablePoint(x = 1.2, y = 3.4),
            finish = MutablePoint(x = 5.6, y = 7.9),
        ).also { unexpected ->
            Assertions.assertFalse(unexpected === actual)
            Assertions.assertNotEquals(unexpected, actual)
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
        MutableVector(
            start = MutablePoint(x = 1.2, y = 3.4),
            finish = MutablePoint(x = 5.7, y = 7.8),
        ).also { unexpected ->
            Assertions.assertFalse(unexpected === actual)
            Assertions.assertNotEquals(unexpected, actual)
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
    fun equalsNotStartTest() {
        val actual = MutableVector(
            start = MutablePoint(x = 1.2, y = 3.4),
            finish = MutablePoint(x = 5.6, y = 7.8),
        )
        MutableVector(
            start = MutablePoint(x = 1.2, y = 3.5),
            finish = MutablePoint(x = 5.6, y = 7.8),
        ).also { unexpected ->
            Assertions.assertFalse(unexpected === actual)
            Assertions.assertNotEquals(unexpected, actual)
            Assertions.assertFalse(unexpected == actual)
            Assertions.assertFalse(actual.start === unexpected.start)
            Assertions.assertFalse(actual.start == unexpected.start)
            Assertions.assertNotEquals(actual.start, unexpected.start)
            Assertions.assertEquals(actual.start.x, unexpected.start.x)
            Assertions.assertNotEquals(actual.start.y, unexpected.start.y)
            Assertions.assertFalse(actual.finish === unexpected.finish)
            Assertions.assertTrue(actual.finish == unexpected.finish)
            Assertions.assertEquals(actual.finish, unexpected.finish)
        }
        MutableVector(
            start = MutablePoint(x = 1.3, y = 3.4),
            finish = MutablePoint(x = 5.6, y = 7.8),
        ).also { unexpected ->
            Assertions.assertFalse(unexpected === actual)
            Assertions.assertNotEquals(unexpected, actual)
            Assertions.assertFalse(unexpected == actual)
            Assertions.assertFalse(actual.start === unexpected.start)
            Assertions.assertFalse(actual.start == unexpected.start)
            Assertions.assertNotEquals(actual.start, unexpected.start)
            Assertions.assertNotEquals(actual.start.x, unexpected.start.x)
            Assertions.assertEquals(actual.start.y, unexpected.start.y)
            Assertions.assertFalse(actual.finish === unexpected.finish)
            Assertions.assertTrue(actual.finish == unexpected.finish)
            Assertions.assertEquals(actual.finish, unexpected.finish)
        }
    }

    @Test
    fun hashCodeTest() {
        @Suppress("IgnoredReturnValue")
        MutableVector(
            start = MutablePoint(x = 1.2, y = 3.4),
            finish = MutablePoint(x = 5.6, y = 7.8),
        ).hashCode()
    }

    @Test
    fun setTest() {
        val actual = MutableVector(
            start = MutablePoint(x = 1.2, y = 3.4),
            finish = MutablePoint(x = 5.6, y = 7.8),
        )
        Assertions.assertNotEquals(actual.start.x, actual.start.y)
        Assertions.assertEquals(1.2, actual.start.x)
        Assertions.assertEquals(3.4, actual.start.y)
        Assertions.assertNotEquals(actual.finish.x, actual.finish.y)
        Assertions.assertEquals(5.6, actual.finish.x)
        Assertions.assertEquals(7.8, actual.finish.y)
        actual.set(
            start = pointOf(x = 9.1, y = -11.12),
            finish = pointOf(x = -13.14, y = 15.16),
        )
        Assertions.assertNotEquals(actual.start.x, actual.start.y)
        Assertions.assertEquals(9.1, actual.start.x)
        Assertions.assertEquals(-11.12, actual.start.y)
        Assertions.assertNotEquals(actual.finish.x, actual.finish.y)
        Assertions.assertEquals(-13.14, actual.finish.x)
        Assertions.assertEquals(15.16, actual.finish.y)
    }

    @Test
    fun setVectorTest() {
        val actual = MutableVector(
            start = MutablePoint(x = 1.2, y = 3.4),
            finish = MutablePoint(x = 5.6, y = 7.8),
        )
        Assertions.assertNotEquals(actual.start.x, actual.start.y)
        Assertions.assertEquals(1.2, actual.start.x)
        Assertions.assertEquals(3.4, actual.start.y)
        Assertions.assertNotEquals(actual.finish.x, actual.finish.y)
        Assertions.assertEquals(5.6, actual.finish.x)
        Assertions.assertEquals(7.8, actual.finish.y)
        actual.set(other = pointOf(x = 9.1, y = -11.12) + pointOf(x = -13.14, y = 15.16))
        Assertions.assertNotEquals(actual.start.x, actual.start.y)
        Assertions.assertEquals(9.1, actual.start.x)
        Assertions.assertEquals(-11.12, actual.start.y)
        Assertions.assertNotEquals(actual.finish.x, actual.finish.y)
        Assertions.assertEquals(-13.14, actual.finish.x)
        Assertions.assertEquals(15.16, actual.finish.y)
    }

    @Test
    fun swapTest() {
        val actual = MutableVector(
            start = MutablePoint(x = 1.2, y = 3.4),
            finish = MutablePoint(x = 5.6, y = 7.8),
        )
        Assertions.assertNotEquals(actual.start.x, actual.start.y)
        Assertions.assertEquals(1.2, actual.start.x)
        Assertions.assertEquals(3.4, actual.start.y)
        Assertions.assertNotEquals(actual.finish.x, actual.finish.y)
        Assertions.assertEquals(5.6, actual.finish.x)
        Assertions.assertEquals(7.8, actual.finish.y)
        actual.swap()
        Assertions.assertNotEquals(actual.start.x, actual.start.y)
        Assertions.assertEquals(5.6, actual.start.x)
        Assertions.assertEquals(7.8, actual.start.y)
        Assertions.assertNotEquals(actual.finish.x, actual.finish.y)
        Assertions.assertEquals(1.2, actual.finish.x)
        Assertions.assertEquals(3.4, actual.finish.y)
    }
}
