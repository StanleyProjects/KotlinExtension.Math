package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class VectorUtilTest {
    @Test
    fun toStringTest() {
        val actual = pointOf(x = 1.23, y = 4.56) + pointOf(x = 7.89, y = 10.1)
        Assertions.assertEquals("{x: 1, y: 5} -> {x: 8, y: 10}", actual.toString(points = 0))
        Assertions.assertEquals("{x: 1.2, y: 4.6} -> {x: 7.9, y: 10.1}", actual.toString(points = 1))
        Assertions.assertEquals("{x: 1.23, y: 4.56} -> {x: 7.89, y: 10.10}", actual.toString(points = 2))
        Assertions.assertEquals("{x: 1.230, y: 4.560} -> {x: 7.890, y: 10.100}", actual.toString(points = 3))
        val expected = "{x: 1.23000000, y: 4.56000000} -> {x: 7.89000000, y: 10.10000000}"
        Assertions.assertEquals(expected, actual.toString(points = 8))
    }

    @Test
    fun toStringErrorTest() {
        Assertions.assertThrows(IllegalStateException::class.java) {
            val actual = pointOf(x = 1.23, y = 4.56) + pointOf(x = 7.89, y = 10.1)
            @Suppress("IgnoredReturnValue")
            actual.toString(points = -1)
        }
    }

    @Test
    fun eqTest() {
        val actual = pointOf(x = 1.23, y = 4.56) + pointOf(x = 7.89, y = 10.1)
        (pointOf(x = 1.2, y = 4.5) + pointOf(x = 7.8, y = 10.1)).also { expected: Vector ->
            Assertions.assertTrue(actual.eq(other = expected, points = 1))
        }
        (pointOf(x = 1.24, y = 4.54) + pointOf(x = 7.84, y = 10.14)).also { expected: Vector ->
            Assertions.assertTrue(actual.eq(other = expected, points = 1))
        }
        (pointOf(x = 1.23, y = 4.56) + pointOf(x = 7.89, y = 10.1)).also { expected: Vector ->
            Assertions.assertTrue(actual.eq(other = expected, points = 2))
        }
        (pointOf(x = 1.24444444, y = 4.54444444) + pointOf(x = 7.84444444, y = 10.14444444)).also { expected: Vector ->
            Assertions.assertTrue(actual.eq(other = expected, points = 1))
        }
        (pointOf(x = 1.23444444, y = 4.56444444) + pointOf(x = 7.89444444, y = 10.10444444)).also { expected: Vector ->
            Assertions.assertTrue(actual.eq(other = expected, points = 2))
        }
    }

    @Test
    fun eqNotTest() {
        val actual = pointOf(x = 1.23, y = 4.56) + pointOf(x = 7.89, y = 10.1)
        (pointOf(x = 2.0, y = 4.0) + pointOf(x = 7.0, y = 10.0)).also { expected: Vector ->
            Assertions.assertFalse(actual.eq(other = expected, points = 1)) {
                """
                    Actual: $actual
                    Expected: $expected
                """.trimIndent()
            }
        }
        (pointOf(x = 1.0, y = -2.0) + pointOf(x = 7.0, y = 10.0)).also { expected: Vector ->
            Assertions.assertFalse(actual.eq(other = expected, points = 1))
        }
        (pointOf(x = 1.0, y = 4.0) + pointOf(x = 2.0, y = 10.0)).also { expected: Vector ->
            Assertions.assertFalse(actual.eq(other = expected, points = 1))
        }
        (pointOf(x = 1.0, y = 4.0) + pointOf(x = 7.0, y = -12.0)).also { expected: Vector ->
            Assertions.assertFalse(actual.eq(other = expected, points = 1))
        }
        (pointOf(x = 1.234, y = 4.56) + pointOf(x = 7.89, y = 10.1)).also { expected: Vector ->
            Assertions.assertFalse(actual.eq(other = expected, points = 3))
        }
        (pointOf(x = 1.23, y = -4.564) + pointOf(x = 7.89, y = 10.1)).also { expected: Vector ->
            Assertions.assertFalse(actual.eq(other = expected, points = 3))
        }
        (pointOf(x = 1.23, y = 4.56) + pointOf(x = 7.894, y = 10.1)).also { expected: Vector ->
            Assertions.assertFalse(actual.eq(other = expected, points = 3))
        }
        (pointOf(x = 1.23, y = 4.56) + pointOf(x = 7.89, y = -10.104)).also { expected: Vector ->
            Assertions.assertFalse(actual.eq(other = expected, points = 3))
        }
    }

    @Test
    fun eqErrorTest() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            val foo = pointOf(x = 1.23, y = 4.56) + pointOf(x = 7.89, y = 10.1)
            val bar = pointOf(x = 1.23, y = 4.56) + pointOf(x = 7.89, y = 10.1)
            @Suppress("IgnoredReturnValue")
            foo.eq(other = bar, points = -1)
        }
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            val foo = pointOf(x = 1.23, y = 4.56) + pointOf(x = 7.89, y = 10.1)
            val bar = pointOf(x = 1.23, y = 4.56) + pointOf(x = 7.89, y = 10.1)
            @Suppress("IgnoredReturnValue")
            foo.eq(other = bar, points = 0)
        }
    }
}
