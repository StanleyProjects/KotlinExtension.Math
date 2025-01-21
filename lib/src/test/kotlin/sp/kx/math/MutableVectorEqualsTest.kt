package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class MutableVectorEqualsTest {
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
}
