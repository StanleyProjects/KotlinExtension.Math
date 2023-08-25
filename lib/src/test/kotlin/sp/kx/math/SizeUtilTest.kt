package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class SizeUtilTest {
    @Test
    fun toOffsetTest() {
        val width = 1.2
        val height = 3.4
        val size: Size = sizeOf(width = width, height = height)
        Assertions.assertNotEquals(size.width, size.height)
        Assertions.assertEquals(width, size.width)
        Assertions.assertEquals(height, size.height)
        val offset: Offset = size.toOffset()
        Assertions.assertFalse(offset === size)
        Assertions.assertEquals(width, offset.dX)
        Assertions.assertEquals(height, offset.dY)
        Assertions.assertEquals(size.width, offset.dX)
        Assertions.assertEquals(size.height, offset.dY)
    }

    @Test
    fun centerTest() {
        val width = 1.2
        val height = 3.4
        val size: Size = sizeOf(width = width, height = height)
        Assertions.assertNotEquals(size.width, size.height)
        Assertions.assertEquals(width, size.width)
        Assertions.assertEquals(height, size.height)
        val offset: Offset = size.center()
        Assertions.assertNotEquals(width, offset.dX)
        Assertions.assertNotEquals(height, offset.dY)
        Assertions.assertNotEquals(size.width, offset.dX)
        Assertions.assertNotEquals(size.height, offset.dY)
        Assertions.assertEquals(width / 2, offset.dX)
        Assertions.assertEquals(height / 2, offset.dY)
        Assertions.assertEquals(size.width / 2, offset.dX)
        Assertions.assertEquals(size.height / 2, offset.dY)
    }

    @Test
    fun centerPointTest() {
        val width = 1.2
        val height = 3.4
        val size: Size = sizeOf(width = width, height = height)
        Assertions.assertNotEquals(size.width, size.height)
        Assertions.assertEquals(width, size.width)
        Assertions.assertEquals(height, size.height)
        val point: Point = size.centerPoint()
        Assertions.assertNotEquals(width, point.x)
        Assertions.assertNotEquals(height, point.y)
        Assertions.assertNotEquals(size.width, point.x)
        Assertions.assertNotEquals(size.height, point.y)
        Assertions.assertEquals(width / 2, point.x)
        Assertions.assertEquals(height / 2, point.y)
        Assertions.assertEquals(size.width / 2, point.x)
        Assertions.assertEquals(size.height / 2, point.y)
    }

    @Test
    fun toStringTest() {
        val size: Size = sizeOf(width = 1.234, height = 5.67)
        Assertions.assertEquals("1x6", size.toString(points = 0))
        Assertions.assertEquals("1.2x5.7", size.toString(points = 1))
        Assertions.assertEquals("1.23x5.67", size.toString(points = 2))
        Assertions.assertEquals("1.234x5.670", size.toString(points = 3))
        Assertions.assertEquals("1.23400000x5.67000000", size.toString(points = 8))
    }

    @Test
    fun toStringErrorTest() {
        Assertions.assertThrows(IllegalStateException::class.java) {
            @Suppress("IgnoredReturnValue")
            sizeOf(width = 1.2, height = 4.3).toString(points = -1)
        }
    }

    @Test
    fun eqTest() {
        val size: Size = sizeOf(width = 1.23, height = 5.67)
        Assertions.assertTrue(size.eq(other = sizeOf(width = 1.2, height = 5.6), points = 1))
        Assertions.assertTrue(size.eq(other = sizeOf(width = 1.23, height = 5.67), points = 1))
        Assertions.assertTrue(size.eq(other = sizeOf(width = 1.23, height = 5.67), points = 2))
        Assertions.assertTrue(size.eq(other = sizeOf(width = 1.2356789, height = 5.67891234), points = 1))
        Assertions.assertTrue(size.eq(other = sizeOf(width = 1.2356789, height = 5.67891234), points = 2))
    }

    @Test
    fun eqNotTest() {
        val size: Size = sizeOf(width = 1.23, height = 5.67)
        Assertions.assertFalse(size.eq(other = sizeOf(width = -1.23, height = 5.67), points = 1))
        Assertions.assertFalse(size.eq(other = sizeOf(width = 1.23, height = -5.67), points = 1))
        Assertions.assertFalse(size.eq(other = sizeOf(width = 1.23, height = 5.67891234), points = 3))
        Assertions.assertFalse(size.eq(other = sizeOf(width = 1.2356789, height = 5.67), points = 3))
        Assertions.assertFalse(size.eq(other = sizeOf(width = 1.2356789, height = 5.67891234), points = 3))
        Assertions.assertFalse(size.eq(other = sizeOf(width = 1.2356789, height = 5.67891234), points = 4))
        Assertions.assertFalse(size.eq(other = sizeOf(width = 1.2356789, height = 5.67891234), points = 8))
    }

    @Test
    fun eqErrorTest() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            @Suppress("IgnoredReturnValue")
            sizeOf(width = 1.2, height = 4.3).eq(other = sizeOf(width = 1.2, height = 4.3), points = -1)
        }
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            @Suppress("IgnoredReturnValue")
            sizeOf(width = 1.2, height = 4.3).eq(other = sizeOf(width = 1.2, height = 4.3), points = 0)
        }
    }

    @Test
    fun sizeOfTest() {
        val foo: Size = sizeOf(
            width = 1,
            height = 2,
        )
        Assertions.assertNotEquals(foo.width, foo.height)
        Assertions.assertEquals(1.0, foo.width)
        Assertions.assertEquals(2.0, foo.height)
    }
}
