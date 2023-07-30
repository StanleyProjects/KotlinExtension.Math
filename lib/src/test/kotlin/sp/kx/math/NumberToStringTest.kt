package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber", "StringLiteralDuplication")
internal class NumberToStringTest {
    @Test
    fun toStringTest() {
        val actual = 1.234567
        Assertions.assertEquals("1", actual.toString(points = 0))
        Assertions.assertEquals("1.2", actual.toString(points = 1))
        Assertions.assertEquals("1.23", actual.toString(points = 2))
        Assertions.assertEquals("1.235", actual.toString(points = 3))
        Assertions.assertEquals("1.2346", actual.toString(points = 4))
        Assertions.assertEquals("1.23457", actual.toString(points = 5))
        Assertions.assertEquals("1.234567", actual.toString(points = 6))
        Assertions.assertEquals("1.2345670", actual.toString(points = 7))
        Assertions.assertEquals("1.23456700", actual.toString(points = 8))
    }

    @Test
    fun toStringErrorTest() {
        Assertions.assertThrows(IllegalStateException::class.java) {
            @Suppress("IgnoredReturnValue")
            1.234.toString(points = -1)
        }
    }

    @Test
    fun toStringFractionalTest() {
        val actual = 1.234567
        Assertions.assertEquals("1", actual.toString(total = 1, points = 0))
        Assertions.assertEquals("01", actual.toString(total = 2, points = 0))
        Assertions.assertEquals("001", actual.toString(total = 3, points = 0))
        Assertions.assertEquals("1.2", actual.toString(total = 2, points = 1))
        Assertions.assertEquals("1.2", actual.toString(total = 3, points = 1))
        Assertions.assertEquals("01.2", actual.toString(total = 4, points = 1))
        Assertions.assertEquals("001.2", actual.toString(total = 5, points = 1))
        Assertions.assertEquals("0001.2", actual.toString(total = 6, points = 1))
        Assertions.assertEquals("1.23", actual.toString(total = 3, points = 2))
        Assertions.assertEquals("1.23", actual.toString(total = 4, points = 2))
        Assertions.assertEquals("1.235", actual.toString(total = 4, points = 3))
        Assertions.assertEquals("1.235", actual.toString(total = 5, points = 3))
        Assertions.assertEquals("1.2346", actual.toString(total = 5, points = 4))
        Assertions.assertEquals("1.2346", actual.toString(total = 6, points = 4))
        Assertions.assertEquals("1.23457", actual.toString(total = 6, points = 5))
        Assertions.assertEquals("1.23457", actual.toString(total = 7, points = 5))
        Assertions.assertEquals("1.234567", actual.toString(total = 7, points = 6))
        Assertions.assertEquals("1.234567", actual.toString(total = 8, points = 6))
        Assertions.assertEquals("1.2345670", actual.toString(total = 8, points = 7))
        Assertions.assertEquals("1.2345670", actual.toString(total = 9, points = 7))
        Assertions.assertEquals("1.23456700", actual.toString(total = 9, points = 8))
        Assertions.assertEquals("1.23456700", actual.toString(total = 10, points = 8))
        Assertions.assertEquals("1.234567000", actual.toString(total = 10, points = 9))
        Assertions.assertEquals("1.234567000", actual.toString(total = 11, points = 9))
        Assertions.assertEquals("0001.234567000", actual.toString(total = 14, points = 9))
    }

    @Test
    fun toStringFractionalErrorTest() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            @Suppress("IgnoredReturnValue")
            1.2.toString(total = 0, points = -1)
        }
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            @Suppress("IgnoredReturnValue")
            1.2.toString(total = 0, points = 0)
        }
        Assertions.assertThrows(IllegalStateException::class.java) {
            @Suppress("IgnoredReturnValue")
            1.2.toString(total = 1, points = -1)
        }
    }
}
