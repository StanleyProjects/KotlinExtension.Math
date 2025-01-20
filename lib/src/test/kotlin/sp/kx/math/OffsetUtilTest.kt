package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class OffsetUtilTest {
    @Test
    fun toStringTest() {
        val actual = offsetOf(dX = 1.234, dY = 5.67)
        assertEquals("{dX: 1, dY: 6}", actual.toString(points = 0))
        assertEquals("{dX: 1.2, dY: 5.7}", actual.toString(points = 1))
        assertEquals("{dX: 1.23, dY: 5.67}", actual.toString(points = 2))
        assertEquals("{dX: 1.234, dY: 5.670}", actual.toString(points = 3))
        assertEquals("{dX: 1.23400000, dY: 5.67000000}", actual.toString(points = 8))
    }

    @Test
    fun toStringErrorTest() {
        assertThrows(IllegalStateException::class.java) {
            offsetOf(dX = 1.2, dY = 5.6).toString(points = -1)
        }
    }

    @Test
    fun copyTest() {
        val foo = offsetOf(dX = 1.2, dY = 3.4)
        assertNotEquals(foo.dX, foo.dY)
        assertEquals(1.2, foo.dX)
        assertEquals(3.4, foo.dY)
        foo.copy().also { bar ->
            assertFalse(foo === bar)
            assertEquals(foo, bar)
        }
        foo.copy(dX = 5.6).also { bar ->
            assertFalse(foo === bar)
            assertNotEquals(foo, bar)
            assertEquals(5.6, bar.dX)
            assertEquals(foo.dY, bar.dY)
        }
        foo.copy(dY = 5.6).also { bar ->
            assertFalse(foo === bar)
            assertNotEquals(foo, bar)
            assertEquals(foo.dX, bar.dX)
            assertEquals(5.6, bar.dY)
        }
        foo.copy(dX = 5.6, dY = 7.8).also { bar ->
            assertFalse(foo === bar)
            assertNotEquals(foo, bar)
            assertEquals(5.6, bar.dX)
            assertEquals(7.8, bar.dY)
        }
    }

    @Test
    fun swappedTest() {
        val foo = offsetOf(dX = 1.2, dY = 3.4)
        assertNotEquals(foo.dX, foo.dY)
        assertEquals(1.2, foo.dX)
        assertEquals(3.4, foo.dY)
        foo.swapped().also { bar ->
            assertFalse(foo === bar)
            assertNotEquals(foo, bar)
            assertNotEquals(foo.dX, bar.dX)
            assertEquals(foo.dX, bar.dY)
            assertNotEquals(foo.dY, bar.dY)
            assertEquals(foo.dY, bar.dX)
        }
    }

    @Test
    fun isEmptyTest() {
        assertFalse(offsetOf(dX = 0.0, dY = 0.1).isEmpty())
        assertFalse(offsetOf(dX = 0.1, dY = 0.0).isEmpty())
        assertTrue(offsetOf(dX = 0.0, dY = 0.0).isEmpty())
        assertTrue(Offset.Empty.isEmpty())
    }

    @Test
    fun isEmptyPointsTest() {
        offsetOf(dX = 0.0, dY = 0.01).also { offset: Offset ->
            assertTrue(offset.isEmpty(points = 1))
            assertFalse(offset.isEmpty(points = 2))
        }
        offsetOf(dX = 0.0, dY = 0.001).also { offset: Offset ->
            assertTrue(offset.isEmpty(points = 1))
            assertTrue(offset.isEmpty(points = 2))
            assertFalse(offset.isEmpty(points = 3))
            assertFalse(offset.isEmpty(points = 4))
            assertFalse(offset.isEmpty(points = 8))
            assertFalse(offset.isEmpty(points = 16))
        }
        offsetOf(dX = 0.0001, dY = 0.0).also { offset: Offset ->
            assertTrue(offset.isEmpty(points = 1))
            assertTrue(offset.isEmpty(points = 2))
            assertTrue(offset.isEmpty(points = 3))
            assertFalse(offset.isEmpty(points = 4))
            assertFalse(offset.isEmpty(points = 8))
            assertFalse(offset.isEmpty(points = 16))
        }
        offsetOf(dX = 0.0, dY = 0.00001).also { offset: Offset ->
            assertTrue(offset.isEmpty(points = 1))
            assertTrue(offset.isEmpty(points = 2))
            assertTrue(offset.isEmpty(points = 3))
            assertTrue(offset.isEmpty(points = 4))
            assertFalse(offset.isEmpty(points = 5))
            assertFalse(offset.isEmpty(points = 8))
            assertFalse(offset.isEmpty(points = 16))
        }
    }

    @Test
    fun isEmptyErrorTest() {
        assertThrows(IllegalArgumentException::class.java) {
            val foo = offsetOf(dX = 0.0, dY = 0.0)
            foo.isEmpty(points = 0)
        }
        assertThrows(IllegalArgumentException::class.java) {
            val foo = offsetOf(dX = 0.0, dY = 0.0)
            foo.isEmpty(points = -1)
        }
    }

    @Test
    fun offsetOfIntsTest() {
        offsetOf(dX = 0, dY = 0).also { actual: Offset ->
            assertEquals(actual.dX, actual.dY)
            assertEquals(0.0, actual.dX)
            assertEquals(0.0, actual.dY)
            assertEquals(Offset.Empty, actual)
        }
        offsetOf(dX = 1, dY = 1).also { actual: Offset ->
            assertEquals(actual.dX, actual.dY)
            assertEquals(1.0, actual.dX)
            assertEquals(1.0, actual.dY)
        }
        offsetOf(dX = 1, dY = 2).also { actual: Offset ->
            assertNotEquals(actual.dX, actual.dY)
            assertEquals(1.0, actual.dX)
            assertEquals(2.0, actual.dY)
        }
        offsetOf(dX = -3, dY = -4).also { actual: Offset ->
            assertNotEquals(actual.dX, actual.dY)
            assertEquals(-3.0, actual.dX)
            assertEquals(-4.0, actual.dY)
        }
    }

    @Test
    fun reversedTest() {
        val delta = 0.0001
        val points = 4
        listOf(
            -1.0 to -1.0,
            -1.0 to 0.0,
            0.0 to -1.0,
            0.0 to 0.0,
            0.0 to 1.0,
            1.0 to -1.0,
            1.0 to 0.0,
            1.0 to 1.0,
            1.2 to 3.4,
            5.6 to 7.8,
        ).forEach { (dX, dY) ->
            val offset = offsetOf(dX = dX, dY = dY)
            val actual = offset.reversed()
            val expected = offsetOf(dX = dX * -1.0, dY = dY * -1.0)
            val message = """
                offset: $offset (${offset.toString(24)})
                actual: $actual (${actual.toString(24)})
                expected: $expected (${expected.toString(24)})
                delta: $delta (${delta.toString(24)})
                points: $points
            """.trimIndent()
            assertEquals(actual.dX, expected.dX, delta, message)
            assertEquals(actual.dY, expected.dY, delta, message)
            assertEquals(expected, actual, message)
            assertTrue(expected.eq(other = actual, points = points), message)
        }
    }
}
