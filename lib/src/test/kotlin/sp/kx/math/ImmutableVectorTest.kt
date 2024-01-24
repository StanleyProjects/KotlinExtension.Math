package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class ImmutableVectorTest {
    @Test
    fun constructorTest() {
        val actual = ImmutableVector(
            start = pointOf(x = 1.2, y = 3.4),
            finish = pointOf(x = 5.6, y = 7.8),
        )
        Assertions.assertNotEquals(actual.start.x, actual.start.y)
        Assertions.assertNotEquals(actual.finish.x, actual.finish.y)
        Assertions.assertEquals(1.2, actual.start.x)
        Assertions.assertEquals(3.4, actual.start.y)
        Assertions.assertEquals(5.6, actual.finish.x)
        Assertions.assertEquals(7.8, actual.finish.y)
    }

    @Suppress("NullableToStringCall") // ?
    @Test
    fun toStringTest() {
        ImmutableVector(
            start = pointOf(x = 1.2, y = 3.4),
            finish = pointOf(x = 5.6, y = 7.8),
        ).also { actual ->
            Assertions.assertEquals("{x: 1.20, y: 3.40} -> {x: 5.60, y: 7.80}", actual.toString())
        }
        ImmutableVector(
            start = pointOf(x = 1.23, y = 3.45),
            finish = pointOf(x = 5.67, y = 7.89),
        ).also { actual ->
            Assertions.assertEquals("{x: 1.23, y: 3.45} -> {x: 5.67, y: 7.89}", actual.toString())
        }
        ImmutableVector(
            start = pointOf(x = 1.234, y = 3.456),
            finish = pointOf(x = 5.678, y = 7.891),
        ).also { actual ->
            Assertions.assertEquals("{x: 1.23, y: 3.46} -> {x: 5.68, y: 7.89}", actual.toString())
        }
    }

    @Test
    fun equalsTest() {
        val foo = ImmutableVector(
            start = pointOf(x = 1.2, y = 3.4),
            finish = pointOf(x = 5.6, y = 7.8),
        )
        val bar = ImmutableVector(
            start = pointOf(x = 1.2, y = 3.4),
            finish = pointOf(x = 5.6, y = 7.8),
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
        val actual = ImmutableVector(
            start = pointOf(x = 1.2, y = 3.4),
            finish = pointOf(x = 5.6, y = 7.8),
        )
        Assertions.assertFalse(actual.equals(Unit))
    }

    @Test
    fun equalsNotFinishTest() {
        val actual = ImmutableVector(
            start = pointOf(x = 1.2, y = 3.4),
            finish = pointOf(x = 5.6, y = 7.8),
        )
        ImmutableVector(
            start = pointOf(x = 1.2, y = 3.4),
            finish = pointOf(x = 5.6, y = 7.9),
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
        ImmutableVector(
            start = pointOf(x = 1.2, y = 3.4),
            finish = pointOf(x = 5.7, y = 7.8),
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
        val actual = ImmutableVector(
            start = pointOf(x = 1.2, y = 3.4),
            finish = pointOf(x = 5.6, y = 7.8),
        )
        ImmutableVector(
            start = pointOf(x = 1.2, y = 3.5),
            finish = pointOf(x = 5.6, y = 7.8),
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
        ImmutableVector(
            start = pointOf(x = 1.3, y = 3.4),
            finish = pointOf(x = 5.6, y = 7.8),
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
        ImmutableVector(
            start = pointOf(x = 1.2, y = 3.4),
            finish = pointOf(x = 5.6, y = 7.8),
        ).hashCode()
    }
}
