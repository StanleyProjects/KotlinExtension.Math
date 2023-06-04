package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class MutablePointTest {
    @Test
    fun constructorTest() {
        val actual = MutablePoint(
            x = 1.2,
            y = 3.4,
        )
        Assertions.assertNotEquals(actual.x, actual.y)
        Assertions.assertEquals(1.2, actual.x)
        Assertions.assertEquals(3.4, actual.y)
        actual.x = 5.6
        Assertions.assertEquals(5.6, actual.x)
        Assertions.assertEquals(3.4, actual.y)
        actual.y = 7.8
        Assertions.assertEquals(5.6, actual.x)
        Assertions.assertEquals(7.8, actual.y)
    }

    @Test
    fun toStringTest() {
        MutablePoint(x = 1.2, y = 5.6).also { actual ->
            Assertions.assertEquals("{x: 1.20, y: 5.60}", actual.toString())
        }
        MutablePoint(x = 1.23, y = 5.67).also { actual ->
            Assertions.assertEquals("{x: 1.23, y: 5.67}", actual.toString())
        }
        MutablePoint(x = 1.234, y = 5.678).also { actual ->
            Assertions.assertEquals("{x: 1.23, y: 5.68}", actual.toString())
        }
    }

    @Test
    fun equalsTest() {
        val first = MutablePoint(
            x = 1.2,
            y = 3.4,
        )
        val second = MutablePoint(
            x = 1.2,
            y = 3.4,
        )
        Assertions.assertEquals(first, second)
        Assertions.assertTrue(first == second)
    }

    @Test
    fun equalsNotTest() {
        val actual = MutablePoint(
            x = 1.2,
            y = 3.4,
        )
        Assertions.assertNotEquals(MutablePoint(1.2, 1.2), actual)
        Assertions.assertFalse(MutablePoint(1.2, 1.2) == actual)
        Assertions.assertNotEquals(MutablePoint(3.4, 3.4), actual)
        Assertions.assertFalse(MutablePoint(3.4, 3.4) == actual)
        Assertions.assertNotEquals(MutablePoint(3.4, 1.2), actual)
        Assertions.assertFalse(MutablePoint(3.4, 1.2) == actual)
        Assertions.assertFalse(actual.equals(Unit))
    }

    @Test
    fun hashCodeTest() {
        @Suppress("IgnoredReturnValue")
        MutablePoint(
            x = 1.2,
            y = 3.4,
        ).hashCode()
    }

    @Test
    fun setTest() {
        val actual = MutablePoint(
            x = 1.2,
            y = 3.4,
        )
        Assertions.assertNotEquals(actual.x, actual.y)
        Assertions.assertEquals(1.2, actual.x)
        Assertions.assertEquals(3.4, actual.y)
        actual.set(x = 5.6, y = 7.8)
        Assertions.assertNotEquals(actual.x, actual.y)
        Assertions.assertEquals(5.6, actual.x)
        Assertions.assertEquals(7.8, actual.y)
    }

    @Test
    fun setPointTest() {
        val foo = MutablePoint(
            x = 1.2,
            y = 3.4,
        )
        Assertions.assertNotEquals(foo.x, foo.y)
        Assertions.assertEquals(1.2, foo.x)
        Assertions.assertEquals(3.4, foo.y)
        val bar = pointOf(x = 5.6, y = 7.8)
        Assertions.assertNotEquals(foo, bar)
        foo.set(bar)
        Assertions.assertEquals(foo, bar)
    }

    @Test
    fun swapTest() {
        val actual = MutablePoint(
            x = 1.2,
            y = 3.4,
        )
        Assertions.assertNotEquals(actual.x, actual.y)
        Assertions.assertEquals(1.2, actual.x)
        Assertions.assertEquals(3.4, actual.y)
        actual.swap()
        Assertions.assertEquals(3.4, actual.x)
        Assertions.assertEquals(1.2, actual.y)
    }
}
