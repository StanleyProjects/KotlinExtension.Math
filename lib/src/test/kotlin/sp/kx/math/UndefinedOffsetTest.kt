package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import java.util.Objects

internal class UndefinedOffsetTest {
    @Test
    fun toStringTest() {
        assertEquals(offsetOf(Double.NaN, Double.NaN).toString(), Offset.Undefined.toString())
    }

    @Test
    fun equalsTest() {
        assertEquals(Offset.Undefined.dX, Offset.Undefined.dY)
        assertEquals(Double.NaN, Offset.Undefined.dX)
        assertEquals(Double.NaN, Offset.Undefined.dY)
        assert(Offset.Undefined, Offset.Undefined, expected = true)
        assert(Offset.Undefined, offsetOf(Double.NaN, Double.NaN), expected = false)
        assertFalse(Offset.Undefined.equals(null))
        listOf(
            offsetOf(Double.NaN, Double.NaN),
            offsetOf(Double.NaN, 0.0),
            offsetOf(0.0, Double.NaN),
        ).forEach { unexpected ->
            assertNotEquals(unexpected, Offset.Undefined)
            assertFalse(Offset.Undefined == unexpected)
        }
        assertNotEquals(Unit, Offset.Undefined)
        assertFalse(Offset.Undefined.equals(Unit))
    }

    @Test
    fun hashCodeTest() {
        val expected = Objects.hash(Double.NaN, Double.NaN)
        val actual = Offset.Undefined.hashCode()
        assertEquals(expected, actual)
    }

    companion object {
        private fun assert(o1: Offset, o2: Offset, expected: Boolean) {
            val actual = o1 == o2
            val message = """
                o1: ${o1.toString(24)}
                o2: ${o2.toString(24)}
                actual: $actual
                expected: $expected
            """.trimIndent()
            assertEquals(actual, expected, message)
        }
    }
}
