package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.Objects

internal class ReferenceSizeTest {
    @Test
    fun toStringTest() {
        assertEquals(sizeOf(1.0, 1.0).toString(), Size.Reference.toString())
    }

    @Test
    fun equalsTest() {
        assertEquals(Size.Reference.width, Size.Reference.height)
        assertEquals(1.0, Size.Reference.width)
        assertEquals(1.0, Size.Reference.height)
        val expected = sizeOf(1.0, 1.0)
        assertEquals(expected, Size.Reference)
        assertTrue(Size.Reference == expected)
        listOf(
            sizeOf(1.0, 0.0),
            sizeOf(0.0, 1.0),
        ).forEach { unexpected ->
            assertNotEquals(unexpected, Size.Reference)
            assertFalse(Size.Reference == unexpected)
        }
        assertFalse(Size.Reference.equals(null))
        assertNotEquals(Unit, Size.Reference)
        assertFalse(Size.Reference.equals(Unit))
    }

    @Test
    fun hashCodeTest() {
        val expected = Objects.hash(1.0, 1.0)
        val actual = Size.Reference.hashCode()
        assertEquals(expected, actual)
    }
}
