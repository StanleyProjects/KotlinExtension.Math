package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import java.util.Objects

internal class UndefinedVectorTest {
    @Test
    fun toStringTest() {
        val expected = vectorOf(Double.NaN, Double.NaN, Double.NaN, Double.NaN).toString()
        val actual = Vector.Undefined.toString()
        assertEquals(expected, actual)
    }

    @Test
    fun equalsTest() {
        assertEquals(Vector.Undefined.start, Vector.Undefined.start)
        assertEquals(Vector.Undefined.finish, Vector.Undefined.finish)
        assertEquals(Vector.Undefined.start, Vector.Undefined.finish)
        assertEquals(Double.NaN, Vector.Undefined.start.x)
        assertEquals(Double.NaN, Vector.Undefined.start.y)
        assertEquals(Double.NaN, Vector.Undefined.finish.x)
        assertEquals(Double.NaN, Vector.Undefined.finish.y)
        assert(Vector.Undefined, Vector.Undefined, expected = true)
        assert(Vector.Undefined, vectorOf(Double.NaN, Double.NaN, Double.NaN, Double.NaN), expected = false)
        assertFalse(Vector.Undefined.equals(null))
        listOf(
            vectorOf(Double.NaN, Double.NaN, Double.NaN, Double.NaN),
            vectorOf(Double.NaN, Double.NaN, Double.NaN, 0.0),
            vectorOf(Double.NaN, Double.NaN, 0.0, Double.NaN),
            vectorOf(Double.NaN, Double.NaN, 0.0, 0.0),
            vectorOf(Double.NaN, 0.0, Double.NaN, Double.NaN),
            vectorOf(Double.NaN, 0.0, Double.NaN, 0.0),
            vectorOf(Double.NaN, 0.0, 0.0, Double.NaN),
            vectorOf(Double.NaN, 0.0, 0.0, 0.0),
            vectorOf(0.0, Double.NaN, Double.NaN, Double.NaN),
        ).forEach { unexpected ->
            assertNotEquals(unexpected, Vector.Undefined)
            assertFalse(Vector.Undefined == unexpected)
        }
        assertNotEquals(Unit, Vector.Undefined)
        assertFalse(Vector.Undefined.equals(Unit))
    }

    @Test
    fun hashCodeTest() {
        val expected = Objects.hash(Double.NaN, Double.NaN, Double.NaN, Double.NaN)
        val actual = Vector.Undefined.hashCode()
        assertEquals(expected, actual)
    }

    companion object {
        private fun assert(v1: Vector, v2: Vector, expected: Boolean) {
            val actual = v1 == v2
            val message = """
                v1: ${v1.toString(24)}
                v2: ${v2.toString(24)}
                actual: $actual
                expected: $expected
            """.trimIndent()
            assertEquals(actual, expected, message)
        }
    }
}
