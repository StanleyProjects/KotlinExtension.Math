package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class MutablePointTest {
    @Test
    fun constructorTest() {
        val actual = MutablePoint(
            x = 1.2,
            y = 3.4,
        )
        Assertions.assertNotEquals(actual.x, actual.y)
        Assertions.assertEquals(1.2, actual.x)
        Assertions.assertEquals(3.4, actual.y)
        actual.x = 5.6
        Assertions.assertEquals(5.6, actual.x)
        Assertions.assertEquals(3.4, actual.y)
        actual.y = 7.8
        Assertions.assertEquals(5.6, actual.x)
        Assertions.assertEquals(7.8, actual.y)
    }

    @Test
    fun toStringTest() {
        val actual = MutablePoint(
            x = 1.2,
            y = 3.4,
        )
        Assertions.assertEquals("{x: 1.20, y: 3.40}", actual.toString())
    }

    @Test
    fun equalsTest() {
        val first = MutablePoint(
            x = 1.2,
            y = 3.4,
        )
        val second = MutablePoint(
            x = 1.2,
            y = 3.4,
        )
        Assertions.assertEquals(first, second)
        Assertions.assertTrue(first == second)
    }

    @Test
    fun equalsNotTest() {
        val actual = MutablePoint(
            x = 1.2,
            y = 3.4,
        )
        Assertions.assertNotEquals(MutablePoint(1.2, 1.2), actual)
        Assertions.assertFalse(MutablePoint(1.2, 1.2) == actual)
        Assertions.assertNotEquals(MutablePoint(3.4, 3.4), actual)
        Assertions.assertFalse(MutablePoint(3.4, 3.4) == actual)
        Assertions.assertNotEquals(MutablePoint(3.4, 1.2), actual)
        Assertions.assertFalse(MutablePoint(3.4, 1.2) == actual)
        Assertions.assertFalse(actual.equals(Unit))
    }

    @Test
    fun hashCodeTest() {
        @Suppress("IgnoredReturnValue")
        MutablePoint(
            x = 1.2,
            y = 3.4,
        ).hashCode()
    }
}
