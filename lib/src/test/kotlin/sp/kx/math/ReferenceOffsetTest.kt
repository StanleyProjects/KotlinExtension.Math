package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.Objects

internal class ReferenceOffsetTest {
    @Test
    fun toStringTest() {
        assertEquals(offsetOf(1.0, 1.0).toString(), Offset.Reference.toString())
    }

    @Test
    fun equalsTest() {
        assertEquals(Offset.Reference.dX, Offset.Reference.dY)
        assertEquals(1.0, Offset.Reference.dX)
        assertEquals(1.0, Offset.Reference.dY)
        val expected = offsetOf(1.0, 1.0)
        assertEquals(expected, Offset.Reference)
        assertTrue(Offset.Reference == expected)
        listOf(
            offsetOf(1.0, 0.0),
            offsetOf(0.0, 1.0),
        ).forEach { unexpected ->
            assertNotEquals(unexpected, Offset.Reference)
            assertFalse(Offset.Reference == unexpected)
        }
        assertFalse(Offset.Reference.equals(null))
        assertNotEquals(Unit, Offset.Reference)
        assertFalse(Offset.Reference.equals(Unit))
    }

    @Test
    fun hashCodeTest() {
        val expected = Objects.hash(1.0, 1.0)
        val actual = Offset.Reference.hashCode()
        assertEquals(expected, actual)
    }
}
