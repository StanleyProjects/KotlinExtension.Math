package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class MutablePointTest {
    @Test
    fun constructorTest() {
        val actual = MutablePoint(
            x = 1.2,
            y = 3.4,
        )
        assertNotEquals(actual.x, actual.y)
        assertEquals(1.2, actual.x)
        assertEquals(3.4, actual.y)
        actual.x = 5.6
        assertEquals(5.6, actual.x)
        assertEquals(3.4, actual.y)
        actual.y = 7.8
        assertEquals(5.6, actual.x)
        assertEquals(7.8, actual.y)
    }

    @Test
    fun toStringTest() {
        MutablePoint(x = 1.2, y = 5.6).also { actual ->
            assertEquals("{x: 1.20, y: 5.60}", actual.toString())
        }
        MutablePoint(x = 1.23, y = 5.67).also { actual ->
            assertEquals("{x: 1.23, y: 5.67}", actual.toString())
        }
        MutablePoint(x = 1.234, y = 5.678).also { actual ->
            assertEquals("{x: 1.23, y: 5.68}", actual.toString())
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
        assertEquals(first, second)
        assertTrue(first == second)
    }

    @Test
    fun equalsNotTest() {
        val actual = MutablePoint(
            x = 1.2,
            y = 3.4,
        )
        assertNotEquals(MutablePoint(1.2, 1.2), actual)
        assertFalse(MutablePoint(1.2, 1.2) == actual)
        assertNotEquals(MutablePoint(3.4, 3.4), actual)
        assertFalse(MutablePoint(3.4, 3.4) == actual)
        assertNotEquals(MutablePoint(3.4, 1.2), actual)
        assertFalse(MutablePoint(3.4, 1.2) == actual)
        assertFalse(actual.equals(Unit))
    }

    @Test
    fun hashCodeTest() {
        MutablePoint(x = 1.2, y = 3.4).hashCode()
    }

    @Test
    fun setTest() {
        val actual = MutablePoint(
            x = 1.2,
            y = 3.4,
        )
        assertNotEquals(actual.x, actual.y)
        assertEquals(1.2, actual.x)
        assertEquals(3.4, actual.y)
        actual.set(x = 5.6, y = 7.8)
        assertNotEquals(actual.x, actual.y)
        assertEquals(5.6, actual.x)
        assertEquals(7.8, actual.y)
    }

    @Test
    fun setPointTest() {
        val foo = MutablePoint(
            x = 1.2,
            y = 3.4,
        )
        assertNotEquals(foo.x, foo.y)
        assertEquals(1.2, foo.x)
        assertEquals(3.4, foo.y)
        val bar = pointOf(x = 5.6, y = 7.8)
        assertNotEquals(foo, bar)
        foo.set(bar)
        assertEquals(foo, bar)
    }

    @Test
    fun swapTest() {
        val actual = MutablePoint(
            x = 1.2,
            y = 3.4,
        )
        assertNotEquals(actual.x, actual.y)
        assertEquals(1.2, actual.x)
        assertEquals(3.4, actual.y)
        actual.swap()
        assertEquals(3.4, actual.x)
        assertEquals(1.2, actual.y)
    }

    @Test
    fun mutTest() {
        val delta = 0.00000001
        listOf(
            -9.0 to 1.2,
            -1.2 to 2.4,
            0.0 to 0.0,
            1.0 to 1.0,
            1.2 to 3.4,
            5.6 to -7.8,
            5.6 to 7.8,
        ).forEach { (x, y) ->
            val expected = pointOf(x = x, y = y)
            val actual = expected.mut()
            check(x == expected.x)
            check(y == expected.y)
            val message = """
                expected: $expected
                actual: $actual
                delta: $delta (${delta.toString(24)})
            """.trimIndent()
            assertEquals(actual::class.java, MutablePoint::class.java, message)
            assertEquals(x, actual.x, delta, message)
            assertEquals(y, actual.y, delta, message)
            assertEquals(expected, actual, message)
            val value = 128.0
            actual.x = value
            assertEquals(value, actual.x, delta, message)
        }
    }
}
