package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class OffsetUtilTest {
    @Test
    fun toStringTest() {
        val actual = offsetOf(dX = 1.234, dY = 5.67)
        Assertions.assertEquals("{dX: 1, dY: 6}", actual.toString(points = 0))
        Assertions.assertEquals("{dX: 1.2, dY: 5.7}", actual.toString(points = 1))
        Assertions.assertEquals("{dX: 1.23, dY: 5.67}", actual.toString(points = 2))
        Assertions.assertEquals("{dX: 1.234, dY: 5.670}", actual.toString(points = 3))
        Assertions.assertEquals("{dX: 1.23400000, dY: 5.67000000}", actual.toString(points = 8))
    }

    @Test
    fun toStringErrorTest() {
        Assertions.assertThrows(IllegalStateException::class.java) {
            @Suppress("IgnoredReturnValue")
            offsetOf(dX = 1.2, dY = 5.6).toString(points = -1)
        }
    }

    @Test
    fun copyTest() {
        val foo = offsetOf(dX = 1.2, dY = 3.4)
        Assertions.assertNotEquals(foo.dX, foo.dY)
        Assertions.assertEquals(1.2, foo.dX)
        Assertions.assertEquals(3.4, foo.dY)
        foo.copy().also { bar ->
            Assertions.assertFalse(foo === bar)
            Assertions.assertEquals(foo, bar)
        }
        foo.copy(dX = 5.6).also { bar ->
            Assertions.assertFalse(foo === bar)
            Assertions.assertNotEquals(foo, bar)
            Assertions.assertEquals(5.6, bar.dX)
            Assertions.assertEquals(foo.dY, bar.dY)
        }
        foo.copy(dY = 5.6).also { bar ->
            Assertions.assertFalse(foo === bar)
            Assertions.assertNotEquals(foo, bar)
            Assertions.assertEquals(foo.dX, bar.dX)
            Assertions.assertEquals(5.6, bar.dY)
        }
        foo.copy(dX = 5.6, dY = 7.8).also { bar ->
            Assertions.assertFalse(foo === bar)
            Assertions.assertNotEquals(foo, bar)
            Assertions.assertEquals(5.6, bar.dX)
            Assertions.assertEquals(7.8, bar.dY)
        }
    }

    @Test
    fun swappedTest() {
        val foo = offsetOf(dX = 1.2, dY = 3.4)
        Assertions.assertNotEquals(foo.dX, foo.dY)
        Assertions.assertEquals(1.2, foo.dX)
        Assertions.assertEquals(3.4, foo.dY)
        foo.swapped().also { bar ->
            Assertions.assertFalse(foo === bar)
            Assertions.assertNotEquals(foo, bar)
            Assertions.assertNotEquals(foo.dX, bar.dX)
            Assertions.assertEquals(foo.dX, bar.dY)
            Assertions.assertNotEquals(foo.dY, bar.dY)
            Assertions.assertEquals(foo.dY, bar.dX)
        }
    }

    @Test
    fun isEmptyTest() {
        Assertions.assertFalse(offsetOf(dX = 0.0, dY = 0.1).isEmpty())
        Assertions.assertFalse(offsetOf(dX = 0.1, dY = 0.0).isEmpty())
        Assertions.assertTrue(offsetOf(dX = 0.0, dY = 0.0).isEmpty())
        Assertions.assertTrue(Offset.Empty.isEmpty())
    }

    @Test
    fun isEmptyPointsTest() {
        offsetOf(dX = 0.0, dY = 0.01).also { offset: Offset ->
            Assertions.assertTrue(offset.isEmpty(points = 1))
            Assertions.assertFalse(offset.isEmpty(points = 2))
        }
        offsetOf(dX = 0.0, dY = 0.001).also { offset: Offset ->
            Assertions.assertTrue(offset.isEmpty(points = 1))
            Assertions.assertTrue(offset.isEmpty(points = 2))
            Assertions.assertFalse(offset.isEmpty(points = 3))
            Assertions.assertFalse(offset.isEmpty(points = 4))
            Assertions.assertFalse(offset.isEmpty(points = 8))
            Assertions.assertFalse(offset.isEmpty(points = 16))
        }
        offsetOf(dX = 0.0001, dY = 0.0).also { offset: Offset ->
            Assertions.assertTrue(offset.isEmpty(points = 1))
            Assertions.assertTrue(offset.isEmpty(points = 2))
            Assertions.assertTrue(offset.isEmpty(points = 3))
            Assertions.assertFalse(offset.isEmpty(points = 4))
            Assertions.assertFalse(offset.isEmpty(points = 8))
            Assertions.assertFalse(offset.isEmpty(points = 16))
        }
        offsetOf(dX = 0.0, dY = 0.00001).also { offset: Offset ->
            Assertions.assertTrue(offset.isEmpty(points = 1))
            Assertions.assertTrue(offset.isEmpty(points = 2))
            Assertions.assertTrue(offset.isEmpty(points = 3))
            Assertions.assertTrue(offset.isEmpty(points = 4))
            Assertions.assertFalse(offset.isEmpty(points = 5))
            Assertions.assertFalse(offset.isEmpty(points = 8))
            Assertions.assertFalse(offset.isEmpty(points = 16))
        }
    }

    @Test
    fun isEmptyErrorTest() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            val foo = offsetOf(dX = 0.0, dY = 0.0)
            @Suppress("IgnoredReturnValue")
            foo.isEmpty(points = 0)
        }
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            val foo = offsetOf(dX = 0.0, dY = 0.0)
            @Suppress("IgnoredReturnValue")
            foo.isEmpty(points = -1)
        }
    }

    @Test
    fun offsetOfIntsTest() {
        offsetOf(dX = 0, dY = 0).also { actual: Offset ->
            Assertions.assertEquals(actual.dX, actual.dY)
            Assertions.assertEquals(0.0, actual.dX)
            Assertions.assertEquals(0.0, actual.dY)
            Assertions.assertEquals(Offset.Empty, actual)
        }
        offsetOf(dX = 1, dY = 1).also { actual: Offset ->
            Assertions.assertEquals(actual.dX, actual.dY)
            Assertions.assertEquals(1.0, actual.dX)
            Assertions.assertEquals(1.0, actual.dY)
        }
        offsetOf(dX = 1, dY = 2).also { actual: Offset ->
            Assertions.assertNotEquals(actual.dX, actual.dY)
            Assertions.assertEquals(1.0, actual.dX)
            Assertions.assertEquals(2.0, actual.dY)
        }
        offsetOf(dX = -3, dY = -4).also { actual: Offset ->
            Assertions.assertNotEquals(actual.dX, actual.dY)
            Assertions.assertEquals(-3.0, actual.dX)
            Assertions.assertEquals(-4.0, actual.dY)
        }
    }
}
