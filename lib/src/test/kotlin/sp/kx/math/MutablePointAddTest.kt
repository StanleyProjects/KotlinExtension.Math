package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class MutablePointAddTest {
    @Test
    fun addTest() {
        val actual = MutablePoint(x = 1.2, y = 3.4)
        Assertions.assertNotEquals(actual.x, actual.y)
        Assertions.assertEquals(1.2, actual.x)
        Assertions.assertEquals(3.4, actual.y)
        (5.6 to 7.8).also { (dX, dY) ->
            Assertions.assertNotEquals(dX, dY)
            actual.add(dX = dX, dY = dY)
            Assertions.assertNotEquals(actual.x, actual.y)
            Assertions.assertEquals(1.2 + dX, actual.x)
            Assertions.assertEquals(3.4 + dY, actual.y)
        }
        (-1.28 to -2.56).also { (dX, dY) ->
            Assertions.assertNotEquals(dX, dY)
            actual.add(dX = dX, dY = dY)
            Assertions.assertNotEquals(actual.x, actual.y)
            Assertions.assertEquals(1.2 + 5.6 + dX, actual.x)
            Assertions.assertEquals(3.4 + 7.8 + dY, actual.y)
        }
    }

    @Test
    fun addOffsetTest() {
        val actual = MutablePoint(x = 1.2, y = 3.4)
        Assertions.assertNotEquals(actual.x, actual.y)
        Assertions.assertEquals(1.2, actual.x)
        Assertions.assertEquals(3.4, actual.y)
        offsetOf(dX = 5.6, dY = 7.8).also { offset ->
            Assertions.assertNotEquals(offset.dX, offset.dY)
            actual.add(offset = offset)
            Assertions.assertNotEquals(actual.x, actual.y)
            Assertions.assertEquals(1.2 + offset.dX, actual.x)
            Assertions.assertEquals(3.4 + offset.dY, actual.y)
        }
        offsetOf(dX = -1.28, dY = -2.56).also { offset ->
            Assertions.assertNotEquals(offset.dX, offset.dY)
            actual.add(offset = offset)
            Assertions.assertNotEquals(actual.x, actual.y)
            Assertions.assertEquals(1.2 + 5.6 + offset.dX, actual.x)
            Assertions.assertEquals(3.4 + 7.8 + offset.dY, actual.y)
        }
    }
}
