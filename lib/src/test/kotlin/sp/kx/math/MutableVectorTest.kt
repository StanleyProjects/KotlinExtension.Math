package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

internal class MutableVectorTest {
    @Test
    fun constructorTest() {
        val actual = MutableVector(
            start = MutablePoint(x = 1.2, y = 3.4),
            finish = MutablePoint(x = 5.6, y = 7.8),
        )
        assertNotEquals(actual.start.x, actual.start.y)
        assertNotEquals(actual.finish.x, actual.finish.y)
        assertEquals(1.2, actual.start.x)
        assertEquals(3.4, actual.start.y)
        assertEquals(5.6, actual.finish.x)
        assertEquals(7.8, actual.finish.y)
        actual.start.x = 1.28
        assertEquals(1.28, actual.start.x)
        assertEquals(3.4, actual.start.y)
        assertEquals(5.6, actual.finish.x)
        assertEquals(7.8, actual.finish.y)
        actual.start.y = 2.56
        assertEquals(1.28, actual.start.x)
        assertEquals(2.56, actual.start.y)
        assertEquals(5.6, actual.finish.x)
        assertEquals(7.8, actual.finish.y)
        actual.finish.x = 5.12
        assertEquals(1.28, actual.start.x)
        assertEquals(2.56, actual.start.y)
        assertEquals(5.12, actual.finish.x)
        assertEquals(7.8, actual.finish.y)
        actual.finish.y = 10.24
        assertEquals(1.28, actual.start.x)
        assertEquals(2.56, actual.start.y)
        assertEquals(5.12, actual.finish.x)
        assertEquals(10.24, actual.finish.y)
    }

    @Test
    fun toStringTest() {
        MutableVector(
            start = MutablePoint(x = 1.2, y = 3.4),
            finish = MutablePoint(x = 5.6, y = 7.8),
        ).also { actual ->
            assertEquals("{x: 1.20, y: 3.40} -> {x: 5.60, y: 7.80}", actual.toString())
        }
        MutableVector(
            start = MutablePoint(x = 1.23, y = 3.45),
            finish = MutablePoint(x = 5.67, y = 7.89),
        ).also { actual ->
            assertEquals("{x: 1.23, y: 3.45} -> {x: 5.67, y: 7.89}", actual.toString())
        }
        MutableVector(
            start = MutablePoint(x = 1.234, y = 3.456),
            finish = MutablePoint(x = 5.678, y = 7.891),
        ).also { actual ->
            assertEquals("{x: 1.23, y: 3.46} -> {x: 5.68, y: 7.89}", actual.toString())
        }
    }

    @Test
    fun hashCodeTest() {
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
        assertNotEquals(actual.start.x, actual.start.y)
        assertEquals(1.2, actual.start.x)
        assertEquals(3.4, actual.start.y)
        assertNotEquals(actual.finish.x, actual.finish.y)
        assertEquals(5.6, actual.finish.x)
        assertEquals(7.8, actual.finish.y)
        actual.set(
            start = pointOf(x = 9.1, y = -11.12),
            finish = pointOf(x = -13.14, y = 15.16),
        )
        assertNotEquals(actual.start.x, actual.start.y)
        assertEquals(9.1, actual.start.x)
        assertEquals(-11.12, actual.start.y)
        assertNotEquals(actual.finish.x, actual.finish.y)
        assertEquals(-13.14, actual.finish.x)
        assertEquals(15.16, actual.finish.y)
    }

    @Test
    fun setVectorTest() {
        val actual = MutableVector(
            start = MutablePoint(x = 1.2, y = 3.4),
            finish = MutablePoint(x = 5.6, y = 7.8),
        )
        assertNotEquals(actual.start.x, actual.start.y)
        assertEquals(1.2, actual.start.x)
        assertEquals(3.4, actual.start.y)
        assertNotEquals(actual.finish.x, actual.finish.y)
        assertEquals(5.6, actual.finish.x)
        assertEquals(7.8, actual.finish.y)
        actual.set(other = pointOf(x = 9.1, y = -11.12) + pointOf(x = -13.14, y = 15.16))
        assertNotEquals(actual.start.x, actual.start.y)
        assertEquals(9.1, actual.start.x)
        assertEquals(-11.12, actual.start.y)
        assertNotEquals(actual.finish.x, actual.finish.y)
        assertEquals(-13.14, actual.finish.x)
        assertEquals(15.16, actual.finish.y)
    }

    @Test
    fun swapTest() {
        val actual = MutableVector(
            start = MutablePoint(x = 1.2, y = 3.4),
            finish = MutablePoint(x = 5.6, y = 7.8),
        )
        assertNotEquals(actual.start.x, actual.start.y)
        assertEquals(1.2, actual.start.x)
        assertEquals(3.4, actual.start.y)
        assertNotEquals(actual.finish.x, actual.finish.y)
        assertEquals(5.6, actual.finish.x)
        assertEquals(7.8, actual.finish.y)
        actual.swap()
        assertNotEquals(actual.start.x, actual.start.y)
        assertEquals(5.6, actual.start.x)
        assertEquals(7.8, actual.start.y)
        assertNotEquals(actual.finish.x, actual.finish.y)
        assertEquals(1.2, actual.finish.x)
        assertEquals(3.4, actual.finish.y)
    }

    @Test
    fun mutTest() {
        val delta = 0.00000001
        listOf(
            pointOf(x = 1.2, y = 3.4) to pointOf(x = 5.6, y = 7.8),
        ).forEach { (start, finish) ->
            val expected = start + finish
            val actual = expected.mut()
            check(start.x == expected.start.x)
            check(start.y == expected.start.y)
            check(finish.x == expected.finish.x)
            check(finish.y == expected.finish.y)
            val message = """
                expected: $expected
                actual: $actual
                delta: $delta (${delta.toString(24)})
            """.trimIndent()
            assertEquals(actual::class.java, MutableVector::class.java, message)
            assertEquals(start.x, actual.start.x, delta, message)
            assertEquals(start.y, actual.start.y, delta, message)
            assertEquals(finish.x, actual.finish.x, delta, message)
            assertEquals(finish.y, actual.finish.y, delta, message)
            assertEquals(expected, actual, message)
            val value = 128.0
            actual.start.x = value
            assertEquals(value, actual.start.x, delta, message)
        }
    }
}
