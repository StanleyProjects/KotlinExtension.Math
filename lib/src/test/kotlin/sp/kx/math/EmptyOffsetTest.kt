package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.Objects

internal class EmptyOffsetTest {
    @Test
    fun toStringTest() {
        assertEquals(offsetOf(0.0, 0.0).toString(), Offset.Empty.toString())
    }

    @Test
    fun equalsTest() {
        assertEquals(Offset.Empty.dX, Offset.Empty.dY)
        assertEquals(0.0, Offset.Empty.dX)
        assertEquals(0.0, Offset.Empty.dY)
        val expected = offsetOf(0.0, 0.0)
        assertEquals(expected, Offset.Empty)
        assertTrue(Offset.Empty == expected)
        listOf(
            offsetOf(1.0, 0.0),
            offsetOf(0.0, 1.0),
        ).forEach { unexpected ->
            assertNotEquals(unexpected, Offset.Empty)
            assertFalse(Offset.Empty == unexpected)
        }
        assertFalse(Offset.Empty.equals(null))
        assertNotEquals(Unit, Offset.Empty)
        assertFalse(Offset.Empty.equals(Unit))
    }

    @Test
    fun hashCodeTest() {
        val expected = Objects.hash(0.0, 0.0)
        val actual = Offset.Empty.hashCode()
        assertEquals(expected, actual)
    }
}
