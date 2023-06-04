package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class MutableOffsetTest {
    @Test
    fun constructorTest() {
        val actual = MutableOffset(
            dX = 1.2,
            dY = 3.4,
        )
        Assertions.assertNotEquals(actual.dX, actual.dY)
        Assertions.assertEquals(1.2, actual.dX)
        Assertions.assertEquals(3.4, actual.dY)
        actual.dX = 5.6
        Assertions.assertEquals(5.6, actual.dX)
        Assertions.assertEquals(3.4, actual.dY)
        actual.dY = 7.8
        Assertions.assertEquals(5.6, actual.dX)
        Assertions.assertEquals(7.8, actual.dY)
    }

    @Test
    fun toStringTest() {
        MutableOffset(dX = 1.2, dY = 5.6).also { actual ->
            Assertions.assertEquals("{dX: 1.20, dY: 5.60}", actual.toString())
        }
        MutableOffset(dX = 1.23, dY = 5.67).also { actual ->
            Assertions.assertEquals("{dX: 1.23, dY: 5.67}", actual.toString())
        }
        MutableOffset(dX = 1.234, dY = 5.678).also { actual ->
            Assertions.assertEquals("{dX: 1.23, dY: 5.68}", actual.toString())
        }
    }

    @Test
    fun equalsTest() {
        val foo = MutableOffset(dX = 1.2, dY = 3.4)
        val bar = MutableOffset(dX = 1.2, dY = 3.4)
        Assertions.assertEquals(foo, bar)
        Assertions.assertFalse(foo === bar)
        Assertions.assertTrue(foo == bar)
    }

    @Test
    fun equalsNotTest() {
        val actual = MutableOffset(dX = 1.2, dY = 3.4)
        MutableOffset(dX = 1.2, dY = 1.2).also { unexpected ->
            Assertions.assertFalse(unexpected === actual)
            Assertions.assertNotEquals(unexpected, actual)
            Assertions.assertFalse(unexpected == actual)
        }
        MutableOffset(dX = 3.4, dY = 3.4).also { unexpected ->
            Assertions.assertFalse(unexpected === actual)
            Assertions.assertNotEquals(unexpected, actual)
            Assertions.assertFalse(unexpected == actual)
        }
        MutableOffset(dX = 3.4, dY = 1.2).also { unexpected ->
            Assertions.assertFalse(unexpected === actual)
            Assertions.assertNotEquals(unexpected, actual)
            Assertions.assertFalse(unexpected == actual)
        }
        Assertions.assertFalse(actual.equals(Unit))
    }

    @Test
    fun hashCodeTest() {
        @Suppress("IgnoredReturnValue")
        MutableOffset(dX = 1.2, dY = 3.4).hashCode()
    }

    @Test
    fun setTest() {
        val actual = MutableOffset(dX = 1.2, dY = 3.4)
        Assertions.assertNotEquals(actual.dX, actual.dY)
        Assertions.assertEquals(1.2, actual.dX)
        Assertions.assertEquals(3.4, actual.dY)
        actual.set(dX = 5.6, dY = 7.8)
        Assertions.assertEquals(5.6, actual.dX)
        Assertions.assertEquals(7.8, actual.dY)
    }

    @Test
    fun setOffsetTest() {
        val foo = MutableOffset(dX = 1.2, dY = 3.4)
        Assertions.assertNotEquals(foo.dX, foo.dY)
        Assertions.assertEquals(1.2, foo.dX)
        Assertions.assertEquals(3.4, foo.dY)
        val bar = offsetOf(dX = 5.6, dY = 7.8)
        Assertions.assertNotEquals(foo, bar)
        foo.set(bar)
        Assertions.assertEquals(foo, bar)
    }

    @Test
    fun swapTest() {
        val actual = MutableOffset(dX = 1.2, dY = 3.4)
        Assertions.assertNotEquals(actual.dX, actual.dY)
        Assertions.assertEquals(1.2, actual.dX)
        Assertions.assertEquals(3.4, actual.dY)
        actual.swap()
        Assertions.assertEquals(3.4, actual.dX)
        Assertions.assertEquals(1.2, actual.dY)
    }
}
