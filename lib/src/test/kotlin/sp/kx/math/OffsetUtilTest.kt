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
    fun eqTest() {
        val actual = offsetOf(dX = 1.234, dY = 5.67)
        Assertions.assertTrue(actual.eq(other = offsetOf(dX = 1.2, dY = 5.6), points = 1))
        Assertions.assertTrue(actual.eq(other = offsetOf(dX = 1.23, dY = 5.67), points = 1))
        Assertions.assertTrue(actual.eq(other = offsetOf(dX = 1.23, dY = 5.67), points = 2))
        Assertions.assertTrue(actual.eq(other = offsetOf(dX = 1.2356789, dY = 5.67891234), points = 1))
        Assertions.assertTrue(actual.eq(other = offsetOf(dX = 1.2356789, dY = 5.67891234), points = 2))
    }

    @Test
    fun eqNotTest() {
        val actual = offsetOf(dX = 1.234, dY = 5.67)
        Assertions.assertFalse(actual.eq(other = offsetOf(dX = -1.23, dY = 5.67), points = 1))
        Assertions.assertFalse(actual.eq(other = offsetOf(dX = 1.23, dY = -5.67), points = 1))
        Assertions.assertFalse(actual.eq(other = offsetOf(dX = 1.23, dY = 5.67891234), points = 3))
        Assertions.assertFalse(actual.eq(other = offsetOf(dX = 1.2356789, dY = 5.67), points = 3))
        Assertions.assertFalse(actual.eq(other = offsetOf(dX = 1.2356789, dY = 5.67891234), points = 3))
        Assertions.assertFalse(actual.eq(other = offsetOf(dX = 1.2356789, dY = 5.67891234), points = 4))
        Assertions.assertFalse(actual.eq(other = offsetOf(dX = 1.2356789, dY = 5.67891234), points = 8))
    }

    @Test
    fun eqErrorTest() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            @Suppress("IgnoredReturnValue")
            offsetOf(dX = 1.2, dY = 5.6).eq(other = offsetOf(dX = 1.2, dY = 5.6), points = -1)
        }
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            @Suppress("IgnoredReturnValue")
            offsetOf(dX = 1.2, dY = 5.6).eq(other = offsetOf(dX = 1.2, dY = 5.6), points = 0)
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
    fun timesTest() {
        val foo = offsetOf(dX = 1.2, dY = 5.6)
        Assertions.assertNotEquals(foo.dX, foo.dY)
        Assertions.assertEquals(1.2, foo.dX)
        Assertions.assertEquals(5.6, foo.dY)
        1.0.also { value: Double ->
            val offset: Offset = foo * value
            Assertions.assertEquals(1.2, offset.dX)
            Assertions.assertEquals(5.6, offset.dY)
            Assertions.assertEquals(foo.dX * value, offset.dX)
            Assertions.assertEquals(foo.dY * value, offset.dY)
            Assertions.assertEquals(foo.dX, offset.dX)
            Assertions.assertEquals(foo.dY, offset.dY)
            Assertions.assertEquals(foo, offset)
        }
        2.0.also { value: Double ->
            val offset: Offset = foo * value
            Assertions.assertEquals(2.4, offset.dX)
            Assertions.assertEquals(11.2, offset.dY)
            Assertions.assertEquals(foo.dX * value, offset.dX)
            Assertions.assertEquals(foo.dY * value, offset.dY)
            Assertions.assertNotEquals(foo.dX, offset.dX)
            Assertions.assertNotEquals(foo.dY, offset.dY)
        }
        (-1.0).also { value: Double ->
            val offset: Offset = foo * value
            Assertions.assertEquals(-1.2, offset.dX)
            Assertions.assertEquals(-5.6, offset.dY)
            Assertions.assertEquals(foo.dX * value, offset.dX)
            Assertions.assertEquals(foo.dY * value, offset.dY)
            Assertions.assertNotEquals(foo.dX, offset.dX)
            Assertions.assertNotEquals(foo.dY, offset.dY)
        }
        7.8.also { value: Double ->
            val offset: Offset = foo * value
            Assertions.assertEquals(9.36, offset.dX)
            Assertions.assertEquals(43.68, offset.dY)
            Assertions.assertEquals(foo.dX * value, offset.dX)
            Assertions.assertEquals(foo.dY * value, offset.dY)
            Assertions.assertNotEquals(foo.dX, offset.dX)
            Assertions.assertNotEquals(foo.dY, offset.dY)
        }
    }

    @Test
    fun divTest() {
        val foo = offsetOf(dX = 1.2, dY = 5.6)
        Assertions.assertNotEquals(foo.dX, foo.dY)
        Assertions.assertEquals(1.2, foo.dX)
        Assertions.assertEquals(5.6, foo.dY)
        1.0.also { value: Double ->
            val offset: Offset = foo / value
            Assertions.assertEquals(1.2, offset.dX)
            Assertions.assertEquals(5.6, offset.dY)
            Assertions.assertEquals(foo.dX / value, offset.dX)
            Assertions.assertEquals(foo.dY / value, offset.dY)
            Assertions.assertEquals(foo.dX, offset.dX)
            Assertions.assertEquals(foo.dY, offset.dY)
            Assertions.assertEquals(foo, offset)
        }
        2.0.also { value: Double ->
            val offset: Offset = foo / value
            Assertions.assertEquals(0.6, offset.dX)
            Assertions.assertEquals(2.8, offset.dY)
            Assertions.assertEquals(foo.dX / value, offset.dX)
            Assertions.assertEquals(foo.dY / value, offset.dY)
            Assertions.assertNotEquals(foo.dX, offset.dX)
            Assertions.assertNotEquals(foo.dY, offset.dY)
        }
        (-1.0).also { value: Double ->
            val offset: Offset = foo / value
            Assertions.assertEquals(-1.2, offset.dX)
            Assertions.assertEquals(-5.6, offset.dY)
            Assertions.assertEquals(foo.dX / value, offset.dX)
            Assertions.assertEquals(foo.dY / value, offset.dY)
            Assertions.assertNotEquals(foo.dX, offset.dX)
            Assertions.assertNotEquals(foo.dY, offset.dY)
        }
        7.8.also { value: Double ->
            val offset: Offset = foo / value
            Assertions.assertEquals(0.1538461, offset.dX, 0.0000001)
            Assertions.assertEquals(0.7179487, offset.dY, 0.0000001)
            Assertions.assertEquals(foo.dX / value, offset.dX)
            Assertions.assertEquals(foo.dY / value, offset.dY)
            Assertions.assertNotEquals(foo.dX, offset.dX)
            Assertions.assertNotEquals(foo.dY, offset.dY)
        }
    }
}
