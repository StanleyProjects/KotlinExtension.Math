package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

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
}
