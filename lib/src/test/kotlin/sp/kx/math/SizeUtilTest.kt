package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

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
        Assertions.assertFalse(offset === size)
        Assertions.assertNotEquals(width, offset.dX)
        Assertions.assertNotEquals(height, offset.dY)
        Assertions.assertNotEquals(size.width, offset.dX)
        Assertions.assertNotEquals(size.height, offset.dY)
        Assertions.assertEquals(width / 2, offset.dX)
        Assertions.assertEquals(height / 2, offset.dY)
        Assertions.assertEquals(size.width / 2, offset.dX)
        Assertions.assertEquals(size.height / 2, offset.dY)
    }
}
