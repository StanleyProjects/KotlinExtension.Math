package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class MutableSizeTest {
    @Test
    fun constructorTest() {
        val size = MutableSize(
            width = 1.2,
            height = 3.4,
        )
        Assertions.assertNotEquals(size.width, size.height)
        Assertions.assertEquals(1.2, size.width)
        Assertions.assertEquals(3.4, size.height)
        size.width = 5.6
        Assertions.assertEquals(5.6, size.width)
        Assertions.assertEquals(3.4, size.height)
        size.height = 7.8
        Assertions.assertEquals(5.6, size.width)
        Assertions.assertEquals(7.8, size.height)
    }

    @Test
    fun toStringTest() {
        MutableSize(
            width = 1.2,
            height = 5.6,
        ).also { size: Size ->
            Assertions.assertEquals("1.20x5.60", size.toString())
        }
        MutableSize(
            width = 1.23,
            height = 5.67,
        ).also { size: Size ->
            Assertions.assertEquals("1.23x5.67", size.toString())
        }
        MutableSize(
            width = 1.234,
            height = 5.678,
        ).also { size: Size ->
            Assertions.assertEquals("1.23x5.68", size.toString())
        }
    }

    @Test
    fun equalsTest() {
        val foo = MutableSize(
            width = 1.2,
            height = 3.4,
        )
        val bar = MutableSize(
            width = 1.2,
            height = 3.4,
        )
        Assertions.assertEquals(foo, bar)
        Assertions.assertFalse(foo === bar)
        Assertions.assertTrue(foo == bar)
    }

    @Test
    fun equalsNotTest() {
        val foo = MutableSize(
            width = 1.2,
            height = 3.4,
        )
        Assertions.assertNotEquals(MutableSize(1.2, 1.2), foo)
        Assertions.assertFalse(MutableSize(1.2, 1.2) == foo)
        Assertions.assertNotEquals(MutableSize(3.4, 3.4), foo)
        Assertions.assertFalse(MutableSize(3.4, 3.4) == foo)
        Assertions.assertNotEquals(MutableSize(3.4, 1.2), foo)
        Assertions.assertFalse(MutableSize(3.4, 1.2) == foo)
        Assertions.assertFalse(foo.equals(Unit))
    }

    @Test
    fun hashCodeTest() {
        @Suppress("IgnoredReturnValue")
        MutableSize(
            width = 1.2,
            height = 3.4,
        ).hashCode()
    }
}
