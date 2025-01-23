package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import java.util.Objects

internal class UndefinedSizeTest {
    @Test
    fun toStringTest() {
        assertEquals(sizeOf(Double.NaN, Double.NaN).toString(), Size.Undefined.toString())
    }

    @Test
    fun equalsTest() {
        assertEquals(Size.Undefined.width, Size.Undefined.height)
        assertEquals(Double.NaN, Size.Undefined.width)
        assertEquals(Double.NaN, Size.Undefined.height)
        assert(Size.Undefined, Size.Undefined, expected = true)
        assert(Size.Undefined, sizeOf(Double.NaN, Double.NaN), expected = false)
        assertFalse(Size.Undefined.equals(null))
        listOf(
            sizeOf(Double.NaN, Double.NaN),
            sizeOf(Double.NaN, 0.0),
            sizeOf(0.0, Double.NaN),
        ).forEach { unexpected ->
            assertNotEquals(unexpected, Size.Undefined)
            assertFalse(Size.Undefined == unexpected)
        }
        assertNotEquals(Unit, Size.Undefined)
        assertFalse(Size.Undefined.equals(Unit))
    }

    @Test
    fun hashCodeTest() {
        val expected = Objects.hash(Double.NaN, Double.NaN)
        val actual = Size.Undefined.hashCode()
        assertEquals(expected, actual)
    }

    companion object {
        private fun assert(s1: Size, s2: Size, expected: Boolean) {
            val actual = s1 == s2
            val message = """
                s1: ${s1.toString(24)}
                s2: ${s2.toString(24)}
                actual: $actual
                expected: $expected
            """.trimIndent()
            assertEquals(actual, expected, message)
        }
    }
}
