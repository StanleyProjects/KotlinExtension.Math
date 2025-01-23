package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.Objects

internal class EmptySizeTest {
    @Test
    fun toStringTest() {
        assertEquals(sizeOf(0.0, 0.0).toString(), Size.Empty.toString())
    }

    @Test
    fun equalsTest() {
        assertEquals(Size.Empty.width, Size.Empty.height)
        assertEquals(0.0, Size.Empty.width)
        assertEquals(0.0, Size.Empty.height)
        val expected = sizeOf(0.0, 0.0)
        assertEquals(expected, Size.Empty)
        assertTrue(Size.Empty == expected)
        listOf(
            sizeOf(1.0, 0.0),
            sizeOf(0.0, 1.0),
        ).forEach { unexpected ->
            assertNotEquals(unexpected, Size.Empty)
            assertFalse(Size.Empty == unexpected)
        }
        assertFalse(Size.Empty.equals(null))
        assertNotEquals(Unit, Size.Empty)
        assertFalse(Size.Empty.equals(Unit))
    }

    @Test
    fun hashCodeTest() {
        val expected = Objects.hash(0.0, 0.0)
        val actual = Size.Empty.hashCode()
        assertEquals(expected, actual)
    }
}
