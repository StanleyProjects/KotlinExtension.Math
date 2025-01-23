package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class MutableSizeTest {
    @Test
    fun constructorTest() {
        val size = MutableSize(
            width = 1.2,
            height = 3.4,
        )
        assertNotEquals(size.width, size.height)
        assertEquals(1.2, size.width)
        assertEquals(3.4, size.height)
        size.width = 5.6
        assertEquals(5.6, size.width)
        assertEquals(3.4, size.height)
        size.height = 7.8
        assertEquals(5.6, size.width)
        assertEquals(7.8, size.height)
    }

    @Test
    fun toStringTest() {
        MutableSize(
            width = 1.2,
            height = 5.6,
        ).also { size: Size ->
            assertEquals("1.20x5.60", size.toString())
        }
        MutableSize(
            width = 1.23,
            height = 5.67,
        ).also { size: Size ->
            assertEquals("1.23x5.67", size.toString())
        }
        MutableSize(
            width = 1.234,
            height = 5.678,
        ).also { size: Size ->
            assertEquals("1.23x5.68", size.toString())
        }
    }

    @Test
    fun equalsTest() {
        val foo = MutableSize(
            width = 1.2,
            height = 3.4,
        )
        val bar = MutableSize(
            width = 1.2,
            height = 3.4,
        )
        assertEquals(foo, bar)
        assertFalse(foo === bar)
        assertTrue(foo == bar)
    }

    @Test
    fun equalsNotTest() {
        val foo = MutableSize(
            width = 1.2,
            height = 3.4,
        )
        assertNotEquals(MutableSize(1.2, 1.2), foo)
        assertFalse(MutableSize(1.2, 1.2) == foo)
        assertNotEquals(MutableSize(3.4, 3.4), foo)
        assertFalse(MutableSize(3.4, 3.4) == foo)
        assertNotEquals(MutableSize(3.4, 1.2), foo)
        assertFalse(MutableSize(3.4, 1.2) == foo)
        assertFalse(foo.equals(Unit))
    }

    @Test
    fun hashCodeTest() {
        MutableSize(
            width = 1.2,
            height = 3.4,
        ).hashCode()
    }

    @Test
    fun setTest() {
        val actual = MutableSize(
            width = 1.2,
            height = 3.4,
        )
        assertNotEquals(actual.width, actual.height)
        assertEquals(1.2, actual.width)
        assertEquals(3.4, actual.height)
        actual.set(width = 5.6, height = 7.8)
        assertNotEquals(actual.width, actual.height)
        assertEquals(5.6, actual.width)
        assertEquals(7.8, actual.height)
    }

    @Test
    fun setSizeTest() {
        val foo = MutableSize(
            width = 1.2,
            height = 3.4,
        )
        assertNotEquals(foo.width, foo.height)
        assertEquals(1.2, foo.width)
        assertEquals(3.4, foo.height)
        val bar = sizeOf(width = 5.6, height = 7.8)
        assertNotEquals(foo, bar)
        foo.set(bar)
        assertEquals(5.6, foo.width)
        assertEquals(7.8, foo.height)
        assertEquals(foo, bar)
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
        ).forEach { (width, height) ->
            val expected = sizeOf(width = width, height = height)
            val actual = expected.mut()
            check(width == expected.width)
            check(height == expected.height)
            val message = """
                expected: $expected
                actual: $actual
                delta: $delta (${delta.toString(24)})
            """.trimIndent()
            assertEquals(actual::class.java, MutableSize::class.java, message)
            assertEquals(width, actual.width, delta, message)
            assertEquals(height, actual.height, delta, message)
            assertEquals(expected, actual, message)
            val value = 128.0
            actual.width = value
            assertEquals(value, actual.width, delta, message)
        }
    }

    @Test
    fun clearTest() {
        listOf(
            -9.0 to 1.2,
            -1.2 to 2.4,
            1.0 to 1.0,
            1.2 to 3.4,
            5.6 to -7.8,
            5.6 to 7.8,
        ).forEach { (width, height) ->
            val size = MutableSize(width = width, height = height)
            assertNotEquals(0.0, size.width)
            assertNotEquals(0.0, size.height)
            size.clear()
            assertEquals(0.0, size.width)
            assertEquals(0.0, size.height)
        }
    }

    @Test
    fun clearZeroTest() {
        val size = MutableSize(width = 0.0, height = 0.0)
        assertEquals(0.0, size.width)
        assertEquals(0.0, size.height)
        size.clear()
        assertEquals(0.0, size.width)
        assertEquals(0.0, size.height)
    }

    @Test
    fun addTest() {
        val delta = 0.00000001
        listOf(
            -9.0 to 1.2,
            -1.2 to 2.4,
            1.0 to 1.0,
            1.2 to 3.4,
            5.6 to -7.8,
            5.6 to 7.8,
        ).forEach { (dX, dY) ->
            val size = MutableSize(width = 1.2, height = 3.4)
            size.add(dX = dX, dY = dY)
            assertEquals(1.2 + dX, size.width, delta)
            assertEquals(3.4 + dY, size.height, delta)
        }
    }

    @Test
    fun swapTest() {
        val delta = 0.00000001
        listOf(
            -9.0 to 1.2,
            -1.2 to 2.4,
            1.0 to 1.0,
            1.2 to 3.4,
            5.6 to -7.8,
            5.6 to 7.8,
        ).forEach { (width, height) ->
            val size = MutableSize(width = width, height = height)
            assertEquals(width, size.width, delta)
            assertEquals(height, size.height, delta)
            size.swap()
            assertEquals(height, size.width, delta)
            assertEquals(width, size.height, delta)
        }
    }
}
