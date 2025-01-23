package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

internal class MutablePointAddTest {
    @Test
    fun addTest() {
        val actual = MutablePoint(x = 1.2, y = 3.4)
        assertNotEquals(actual.x, actual.y)
        assertEquals(1.2, actual.x)
        assertEquals(3.4, actual.y)
        (5.6 to 7.8).also { (dX, dY) ->
            assertNotEquals(dX, dY)
            actual.add(dX = dX, dY = dY)
            assertNotEquals(actual.x, actual.y)
            assertEquals(1.2 + dX, actual.x)
            assertEquals(3.4 + dY, actual.y)
        }
        (-1.28 to -2.56).also { (dX, dY) ->
            assertNotEquals(dX, dY)
            actual.add(dX = dX, dY = dY)
            assertNotEquals(actual.x, actual.y)
            assertEquals(1.2 + 5.6 + dX, actual.x)
            assertEquals(3.4 + 7.8 + dY, actual.y)
        }
    }
}
