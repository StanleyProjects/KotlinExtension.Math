package sp.kx.math.measure

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class MutableDoubleMeasureTest {
    @Test
    fun constructorTest() {
        val measure = MutableDoubleMeasure(magnitude = 1.2)
        Assertions.assertEquals(1.2, measure.magnitude)
        measure.magnitude = 5.6
        Assertions.assertEquals(5.6, measure.magnitude)
        measure.magnitude = 7.8
        Assertions.assertEquals(7.8, measure.magnitude)
    }

    @Test
    fun toStringTest() {
        MutableDoubleMeasure(magnitude = 1.2).also { measure ->
            Assertions.assertEquals("{magnitude: 1.20}", measure.toString())
        }
        MutableDoubleMeasure(magnitude = 1.23).also { measure ->
            Assertions.assertEquals("{magnitude: 1.23}", measure.toString())
        }
        MutableDoubleMeasure(magnitude = 1.234).also { measure ->
            Assertions.assertEquals("{magnitude: 1.23}", measure.toString())
        }
        MutableDoubleMeasure(magnitude = 5.6).also { measure ->
            Assertions.assertEquals("{magnitude: 5.60}", measure.toString())
        }
        MutableDoubleMeasure(magnitude = 5.67).also { measure ->
            Assertions.assertEquals("{magnitude: 5.67}", measure.toString())
        }
        MutableDoubleMeasure(magnitude = 5.678).also { measure ->
            Assertions.assertEquals("{magnitude: 5.68}", measure.toString())
        }
    }

    @Test
    fun equalsTest() {
        val foo = MutableDoubleMeasure(magnitude = 1.2)
        val bar = MutableDoubleMeasure(magnitude = 1.2)
        Assertions.assertEquals(foo, bar)
        Assertions.assertFalse(foo === bar)
        Assertions.assertTrue(foo == bar)
    }

    @Test
    fun equalsNotTest() {
        val actual = MutableDoubleMeasure(magnitude = 1.2)
        MutableDoubleMeasure(magnitude = -1.2).also { unexpected ->
            Assertions.assertFalse(unexpected === actual)
            Assertions.assertNotEquals(unexpected, actual)
            Assertions.assertFalse(unexpected == actual)
        }
        MutableDoubleMeasure(magnitude = 3.4).also { unexpected ->
            Assertions.assertFalse(unexpected === actual)
            Assertions.assertNotEquals(unexpected, actual)
            Assertions.assertFalse(unexpected == actual)
        }
        object : Measure<String, String> {
            override val magnitude: String = "foo"

            override fun value(): String {
                error("foo")
            }

            override fun units(value: String): String {
                error("foo")
            }

            override fun transform(units: String): String {
                error("foo")
            }
        }.also { unexpected ->
            Assertions.assertFalse(actual.equals(unexpected))
        }
        Assertions.assertFalse(actual.equals(Unit))
    }

    @Test
    fun hashCodeTest() {
        val measure = MutableDoubleMeasure(magnitude = 1.2)
        @Suppress("IgnoredReturnValue")
        measure.hashCode()
    }

    @Test
    fun transformTest() {
        0.0.also { magnitude: Double ->
            val measure = MutableDoubleMeasure(magnitude = magnitude)
            Assertions.assertEquals(0.0, measure.transform(units = 2.0))
        }
        1.0.also { magnitude: Double ->
            val measure = MutableDoubleMeasure(magnitude = magnitude)
            Assertions.assertEquals(2.0, measure.transform(units = 2.0))
        }
        1.2.also { magnitude: Double ->
            val measure = MutableDoubleMeasure(magnitude = magnitude)
            Assertions.assertEquals(2.4, measure.transform(units = 2.0))
        }
        (-1.2).also { magnitude: Double ->
            val measure = MutableDoubleMeasure(magnitude = magnitude)
            Assertions.assertEquals(-2.4, measure.transform(units = 2.0))
        }
    }

    @Test
    fun unitsTest() {
        1.0.also { magnitude: Double ->
            val measure = MutableDoubleMeasure(magnitude = magnitude)
            Assertions.assertEquals(2.0, measure.units(value = 2.0))
        }
        1.2.also { magnitude: Double ->
            val measure = MutableDoubleMeasure(magnitude = magnitude)
            Assertions.assertEquals(2.0, measure.units(value = 2.4))
        }
        (-1.2).also { magnitude: Double ->
            val measure = MutableDoubleMeasure(magnitude = magnitude)
            Assertions.assertEquals(2.0, measure.units(value = -2.4))
        }
    }

    @Test
    fun valueTest() {
        setOf(1.0, 1.2, -1.2, 42.0).forEach { magnitude: Double ->
            val measure = MutableDoubleMeasure(magnitude = magnitude)
            Assertions.assertEquals(magnitude, measure.value())
        }
    }
}
