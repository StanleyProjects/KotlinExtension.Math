package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class PointMinusTest {
    @Test
    fun minusTest() {
        val foo = pointOf(x = 1.2, y = 3.4)
        Assertions.assertNotEquals(foo.x, foo.y)
        Assertions.assertEquals(1.2, foo.x)
        Assertions.assertEquals(3.4, foo.y)
        foo.minus(x = 5.6, y = 8.9).also { offset ->
            Assertions.assertEquals(1.2, foo.x)
            Assertions.assertEquals(3.4, foo.y)
            Assertions.assertNotEquals(offset.dX, offset.dY)
            Assertions.assertEquals(foo.x - 5.6, offset.dX)
            Assertions.assertEquals(foo.y - 8.9, offset.dY)
            Assertions.assertEquals(-4.4, offset.dX, 0.000001)
            Assertions.assertTrue((-4.4).eq(offset.dX, points = 6))
            Assertions.assertEquals(-5.5, offset.dY)
        }
        foo.minus(x = -1.28, y = -2.56).also { offset ->
            Assertions.assertEquals(1.2, foo.x)
            Assertions.assertEquals(3.4, foo.y)
            Assertions.assertNotEquals(offset.dX, offset.dY)
            Assertions.assertEquals(foo.x + 1.28, offset.dX)
            Assertions.assertEquals(foo.y + 2.56, offset.dY)
            Assertions.assertEquals(2.48, offset.dX)
            Assertions.assertEquals(5.96, offset.dY)
        }
    }

    @Test
    fun minusPointTest() {
        val foo = pointOf(x = 1.2, y = 3.4)
        Assertions.assertNotEquals(foo.x, foo.y)
        Assertions.assertEquals(1.2, foo.x)
        Assertions.assertEquals(3.4, foo.y)
        pointOf(x = 5.6, y = 8.9).also { bar ->
            val offset = foo - bar
            Assertions.assertEquals(1.2, foo.x)
            Assertions.assertEquals(3.4, foo.y)
            Assertions.assertNotEquals(bar.x, bar.y)
            Assertions.assertNotEquals(offset.dX, offset.dY)
            Assertions.assertEquals(foo.x - bar.x, offset.dX)
            Assertions.assertEquals(foo.y - bar.y, offset.dY)
            Assertions.assertEquals(-4.4, offset.dX, 0.000001)
            Assertions.assertTrue((-4.4).eq(offset.dX, points = 6))
            Assertions.assertEquals(-5.5, offset.dY)
        }
        pointOf(x = -1.28, y = -2.56).also { bar ->
            val offset = foo - bar
            Assertions.assertEquals(1.2, foo.x)
            Assertions.assertEquals(3.4, foo.y)
            Assertions.assertNotEquals(bar.x, bar.y)
            Assertions.assertNotEquals(offset.dX, offset.dY)
            Assertions.assertEquals(foo.x - bar.x, offset.dX)
            Assertions.assertEquals(foo.y - bar.y, offset.dY)
            Assertions.assertEquals(2.48, offset.dX)
            Assertions.assertEquals(5.96, offset.dY)
        }
    }

    @Test
    fun minusOffsetTest() {
        val foo = pointOf(x = 1.2, y = 3.4)
        Assertions.assertNotEquals(foo.x, foo.y)
        Assertions.assertEquals(1.2, foo.x)
        Assertions.assertEquals(3.4, foo.y)
        offsetOf(dX = 5.6, dY = 7.8).also { offset ->
            Assertions.assertNotEquals(offset.dX, offset.dY)
            val bar = foo - offset
            Assertions.assertEquals(1.2, foo.x)
            Assertions.assertEquals(3.4, foo.y)
            Assertions.assertNotEquals(bar.x, bar.y)
            Assertions.assertEquals(1.2 - offset.dX, bar.x)
            Assertions.assertEquals(3.4 - offset.dY, bar.y)
            Assertions.assertEquals(foo.x - offset.dX, bar.x)
            Assertions.assertEquals(foo.y - offset.dY, bar.y)
        }
        offsetOf(dX = -1.28, dY = -2.56).also { offset ->
            Assertions.assertNotEquals(offset.dX, offset.dY)
            val bar = foo - offset
            Assertions.assertEquals(1.2, foo.x)
            Assertions.assertEquals(3.4, foo.y)
            Assertions.assertNotEquals(bar.x, bar.y)
            Assertions.assertEquals(1.2 - offset.dX, bar.x)
            Assertions.assertEquals(3.4 - offset.dY, bar.y)
            Assertions.assertEquals(foo.x - offset.dX, bar.x)
            Assertions.assertEquals(foo.y - offset.dY, bar.y)
        }
    }
}
