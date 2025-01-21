package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class MutableOffsetTest {
    @Test
    fun constructorTest() {
        val actual = MutableOffset(
            dX = 1.2,
            dY = 3.4,
        )
        assertNotEquals(actual.dX, actual.dY)
        assertEquals(1.2, actual.dX)
        assertEquals(3.4, actual.dY)
        actual.dX = 5.6
        assertEquals(5.6, actual.dX)
        assertEquals(3.4, actual.dY)
        actual.dY = 7.8
        assertEquals(5.6, actual.dX)
        assertEquals(7.8, actual.dY)
    }

    @Test
    fun toStringTest() {
        MutableOffset(dX = 1.2, dY = 5.6).also { actual ->
            assertEquals("{dX: 1.20, dY: 5.60}", actual.toString())
        }
        MutableOffset(dX = 1.23, dY = 5.67).also { actual ->
            assertEquals("{dX: 1.23, dY: 5.67}", actual.toString())
        }
        MutableOffset(dX = 1.234, dY = 5.678).also { actual ->
            assertEquals("{dX: 1.23, dY: 5.68}", actual.toString())
        }
    }

    @Test
    fun equalsTest() {
        val foo = MutableOffset(dX = 1.2, dY = 3.4)
        val bar = MutableOffset(dX = 1.2, dY = 3.4)
        assertEquals(foo, bar)
        assertFalse(foo === bar)
        assertTrue(foo == bar)
    }

    @Test
    fun equalsNotTest() {
        val actual = MutableOffset(dX = 1.2, dY = 3.4)
        MutableOffset(dX = 1.2, dY = 1.2).also { unexpected ->
            assertFalse(unexpected === actual)
            assertNotEquals(unexpected, actual)
            assertFalse(unexpected == actual)
        }
        MutableOffset(dX = 3.4, dY = 3.4).also { unexpected ->
            assertFalse(unexpected === actual)
            assertNotEquals(unexpected, actual)
            assertFalse(unexpected == actual)
        }
        MutableOffset(dX = 3.4, dY = 1.2).also { unexpected ->
            assertFalse(unexpected === actual)
            assertNotEquals(unexpected, actual)
            assertFalse(unexpected == actual)
        }
        assertFalse(actual.equals(Unit))
    }

    @Test
    fun hashCodeTest() {
        MutableOffset(dX = 1.2, dY = 3.4).hashCode()
    }

    @Test
    fun setTest() {
        val actual = MutableOffset(dX = 1.2, dY = 3.4)
        assertNotEquals(actual.dX, actual.dY)
        assertEquals(1.2, actual.dX)
        assertEquals(3.4, actual.dY)
        actual.set(dX = 5.6, dY = 7.8)
        assertEquals(5.6, actual.dX)
        assertEquals(7.8, actual.dY)
    }

    @Test
    fun setOffsetTest() {
        val foo = MutableOffset(dX = 1.2, dY = 3.4)
        assertNotEquals(foo.dX, foo.dY)
        assertEquals(1.2, foo.dX)
        assertEquals(3.4, foo.dY)
        val bar = offsetOf(dX = 5.6, dY = 7.8)
        assertNotEquals(foo, bar)
        foo.set(bar)
        assertEquals(foo, bar)
    }

    @Test
    fun swapTest() {
        val actual = MutableOffset(dX = 1.2, dY = 3.4)
        assertNotEquals(actual.dX, actual.dY)
        assertEquals(1.2, actual.dX)
        assertEquals(3.4, actual.dY)
        actual.swap()
        assertEquals(3.4, actual.dX)
        assertEquals(1.2, actual.dY)
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
        ).forEach { (dX, dY) ->
            val expected = offsetOf(dX = dX, dY = dY)
            val actual = expected.mut()
            check(dX == expected.dX)
            check(dY == expected.dY)
            val message = """
                expected: $expected
                actual: $actual
                delta: $delta (${delta.toString(24)})
            """.trimIndent()
            assertEquals(actual::class.java, MutableOffset::class.java, message)
            assertEquals(dX, actual.dX, delta, message)
            assertEquals(dY, actual.dY, delta, message)
            assertEquals(expected, actual, message)
            val value = 128.0
            actual.dX = value
            assertEquals(value, actual.dX, delta, message)
        }
    }
}
