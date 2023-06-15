package sp.kx.math.measure

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class MutableDoubleDeviationTest {
    @Test
    fun constructorTest() {
        val deviation = MutableDoubleDeviation(
            actual = 1.2,
            expected = 3.4,
        )
        Assertions.assertNotEquals(deviation.actual, deviation.expected)
        Assertions.assertEquals(1.2, deviation.actual)
        Assertions.assertEquals(3.4, deviation.expected)
        deviation.actual = 5.6
        Assertions.assertEquals(5.6, deviation.actual)
        Assertions.assertEquals(3.4, deviation.expected)
        deviation.expected = 7.8
        Assertions.assertEquals(5.6, deviation.actual)
        Assertions.assertEquals(7.8, deviation.expected)
    }

    @Test
    fun toStringTest() {
        MutableDoubleDeviation(actual = 1.2, expected = 5.6).also { deviation ->
            Assertions.assertEquals("{a: 1.20, e: 5.60}", deviation.toString())
        }
        MutableDoubleDeviation(actual = 1.23, expected = 5.67).also { deviation ->
            Assertions.assertEquals("{a: 1.23, e: 5.67}", deviation.toString())
        }
        MutableDoubleDeviation(actual = 1.234, expected = 5.678).also { deviation ->
            Assertions.assertEquals("{a: 1.23, e: 5.68}", deviation.toString())
        }
    }

    @Test
    fun equalsTest() {
        val foo = MutableDoubleDeviation(actual = 1.2, expected = 5.6)
        val bar = MutableDoubleDeviation(actual = 1.2, expected = 5.6)
        Assertions.assertEquals(foo, bar)
        Assertions.assertFalse(foo === bar)
        Assertions.assertTrue(foo == bar)
    }

    @Test
    fun equalsNotTest() {
        val actual = MutableDoubleDeviation(
            actual = 1.2,
            expected = 3.4,
        )
        MutableDoubleDeviation(actual = -1.2, expected = 3.4).also { unexpected ->
            Assertions.assertFalse(unexpected === actual)
            Assertions.assertNotEquals(unexpected, actual)
            Assertions.assertFalse(unexpected == actual)
        }
        MutableDoubleDeviation(actual = 1.2, expected = -3.4).also { unexpected ->
            Assertions.assertFalse(unexpected === actual)
            Assertions.assertNotEquals(unexpected, actual)
            Assertions.assertFalse(unexpected == actual)
        }
        MutableDoubleDeviation(actual = -1.2, expected = -3.4).also { unexpected ->
            Assertions.assertFalse(unexpected === actual)
            Assertions.assertNotEquals(unexpected, actual)
            Assertions.assertFalse(unexpected == actual)
        }
        MutableDoubleDeviation(actual = 1.2, expected = 1.2).also { unexpected ->
            Assertions.assertFalse(unexpected === actual)
            Assertions.assertNotEquals(unexpected, actual)
            Assertions.assertFalse(unexpected == actual)
        }
        MutableDoubleDeviation(actual = 3.4, expected = 3.4).also { unexpected ->
            Assertions.assertFalse(unexpected === actual)
            Assertions.assertNotEquals(unexpected, actual)
            Assertions.assertFalse(unexpected == actual)
        }
        MutableDoubleDeviation(actual = 3.4, expected = 1.2).also { unexpected ->
            Assertions.assertFalse(unexpected === actual)
            Assertions.assertNotEquals(unexpected, actual)
            Assertions.assertFalse(unexpected == actual)
        }
        object : Deviation<String> {
            override val actual: String = "foo"
            override val expected: String = "bar"
        }.also { unexpected ->
            Assertions.assertFalse(actual.equals(unexpected))
        }
        Assertions.assertFalse(actual.equals(Unit))
    }

    @Test
    fun hashCodeTest() {
        val deviation = MutableDoubleDeviation(
            actual = 1.2,
            expected = 3.4,
        )
        @Suppress("IgnoredReturnValue")
        deviation.hashCode()
    }
}
