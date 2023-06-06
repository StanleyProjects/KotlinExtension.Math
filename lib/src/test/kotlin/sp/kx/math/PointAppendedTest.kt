package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class PointAppendedTest {
    @Test
    fun appendedTest() {
        val foo = pointOf(x = 1.2, y = 3.4)
        Assertions.assertNotEquals(foo.x, foo.y)
        Assertions.assertEquals(1.2, foo.x)
        Assertions.assertEquals(3.4, foo.y)
        (5.6 to 7.8).also { (dX, dY) ->
            Assertions.assertNotEquals(dX, dY)
            val bar = foo.appended(dX = dX, dY = dY)
            Assertions.assertEquals(1.2, foo.x)
            Assertions.assertEquals(3.4, foo.y)
            Assertions.assertNotEquals(bar.x, bar.y)
            Assertions.assertEquals(1.2 + dX, bar.x)
            Assertions.assertEquals(3.4 + dY, bar.y)
            Assertions.assertEquals(foo.x + dX, bar.x)
            Assertions.assertEquals(foo.y + dY, bar.y)
        }
        (-1.28 to -2.56).also { (dX, dY) ->
            Assertions.assertNotEquals(dX, dY)
            val bar = foo.appended(dX = dX, dY = dY)
            Assertions.assertEquals(1.2, foo.x)
            Assertions.assertEquals(3.4, foo.y)
            Assertions.assertNotEquals(bar.x, bar.y)
            Assertions.assertEquals(1.2 + dX, bar.x)
            Assertions.assertEquals(3.4 + dY, bar.y)
            Assertions.assertEquals(foo.x + dX, bar.x)
            Assertions.assertEquals(foo.y + dY, bar.y)
        }
    }

    @Test
    fun appendedOffsetTest() {
        val foo = pointOf(x = 1.2, y = 3.4)
        Assertions.assertNotEquals(foo.x, foo.y)
        Assertions.assertEquals(1.2, foo.x)
        Assertions.assertEquals(3.4, foo.y)
        offsetOf(dX = 5.6, dY = 7.8).also { offset ->
            Assertions.assertNotEquals(offset.dX, offset.dY)
            val bar = foo.appended(offset = offset)
            Assertions.assertEquals(1.2, foo.x)
            Assertions.assertEquals(3.4, foo.y)
            Assertions.assertNotEquals(bar.x, bar.y)
            Assertions.assertEquals(1.2 + offset.dX, bar.x)
            Assertions.assertEquals(3.4 + offset.dY, bar.y)
            Assertions.assertEquals(foo.x + offset.dX, bar.x)
            Assertions.assertEquals(foo.y + offset.dY, bar.y)
        }
        offsetOf(dX = -1.28, dY = -2.56).also { offset ->
            Assertions.assertNotEquals(offset.dX, offset.dY)
            val bar = foo.appended(offset = offset)
            Assertions.assertEquals(1.2, foo.x)
            Assertions.assertEquals(3.4, foo.y)
            Assertions.assertNotEquals(bar.x, bar.y)
            Assertions.assertEquals(1.2 + offset.dX, bar.x)
            Assertions.assertEquals(3.4 + offset.dY, bar.y)
            Assertions.assertEquals(foo.x + offset.dX, bar.x)
            Assertions.assertEquals(foo.y + offset.dY, bar.y)
        }
    }
}
