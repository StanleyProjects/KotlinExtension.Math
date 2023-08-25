package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class SizeIsEmptyTest {
    @Test
    fun isEmptyTest() {
        sizeOf(width = 1.2, height = 4.3).also { size: Size ->
            Assertions.assertFalse(size.isEmpty())
        }
        sizeOf(width = -1.2, height = 4.3).also { size: Size ->
            Assertions.assertFalse(size.isEmpty())
        }
        sizeOf(width = 1.2, height = -4.3).also { size: Size ->
            Assertions.assertFalse(size.isEmpty())
        }
        sizeOf(width = -1.2, height = -4.3).also { size: Size ->
            Assertions.assertFalse(size.isEmpty())
        }
        sizeOf(width = 0.0, height = 4.3).also { size: Size ->
            Assertions.assertFalse(size.isEmpty())
        }
        sizeOf(width = 1.2, height = 0.0).also { size: Size ->
            Assertions.assertFalse(size.isEmpty())
        }
        sizeOf(width = 0.0, height = 0.0).also { size: Size ->
            Assertions.assertTrue(size.isEmpty())
        }
    }

    @Test
    fun isEmptyPointsTest() {
        sizeOf(width = 0.0, height = 0.01).also { size: Size ->
            Assertions.assertTrue(size.isEmpty(points = 1))
            Assertions.assertFalse(size.isEmpty(points = 2))
            Assertions.assertFalse(size.isEmpty(points = 4))
            Assertions.assertFalse(size.isEmpty(points = 8))
            Assertions.assertFalse(size.isEmpty(points = 16))
        }
        sizeOf(width = 0.001, height = 0.0).also { size: Size ->
            Assertions.assertTrue(size.isEmpty(points = 1))
            Assertions.assertTrue(size.isEmpty(points = 2))
            Assertions.assertFalse(size.isEmpty(points = 3))
            Assertions.assertFalse(size.isEmpty(points = 4))
            Assertions.assertFalse(size.isEmpty(points = 8))
            Assertions.assertFalse(size.isEmpty(points = 16))
        }
        sizeOf(width = 0.0, height = 0.00000001).also { size: Size ->
            Assertions.assertTrue(size.isEmpty(points = 1))
            Assertions.assertTrue(size.isEmpty(points = 2))
            Assertions.assertTrue(size.isEmpty(points = 3))
            Assertions.assertTrue(size.isEmpty(points = 4))
            Assertions.assertFalse(size.isEmpty(points = 8))
            Assertions.assertFalse(size.isEmpty(points = 16))
        }
    }

    @Test
    fun isEmptyErrorTest() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            @Suppress("IgnoredReturnValue")
            sizeOf(width = 1.2, height = 4.3).isEmpty(points = 0)
        }
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            @Suppress("IgnoredReturnValue")
            sizeOf(width = 1.2, height = 4.3).isEmpty(points = -1)
        }
    }
}
