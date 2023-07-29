package sp.kx.math.measure

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.nanoseconds
import kotlin.time.Duration.Companion.seconds

@Suppress("MagicNumber")
internal class MutableDurationIntervalTest {
    @Test
    fun constructorTest() {
        val interval = MutableDurationInterval(a = 1.2.seconds, b = 3.4.seconds)
        Assertions.assertEquals(1.2 * 1_000, interval.a.inWholeMilliseconds.toDouble())
        Assertions.assertEquals(3.4 * 1_000, interval.b.inWholeMilliseconds.toDouble())
        interval.a = 5.6.seconds
        Assertions.assertEquals(5.6 * 1_000, interval.a.inWholeMilliseconds.toDouble())
        Assertions.assertEquals(3.4 * 1_000, interval.b.inWholeMilliseconds.toDouble())
        interval.b = 7.8.seconds
        Assertions.assertEquals(5.6 * 1_000, interval.a.inWholeMilliseconds.toDouble())
        Assertions.assertEquals(7.8 * 1_000, interval.b.inWholeMilliseconds.toDouble())
    }

    @Test
    fun toStringTest() {
        MutableDurationInterval(a = 1.2.seconds, b = 5.6.seconds).also { interval ->
            Assertions.assertEquals("{1.20s..5.60s}", interval.toString())
        }
        MutableDurationInterval(a = 1.23.seconds, b = 5.67.seconds).also { interval ->
            Assertions.assertEquals("{1.23s..5.67s}", interval.toString())
        }
        MutableDurationInterval(a = 1.234.seconds, b = 5.678.seconds).also { interval ->
            Assertions.assertEquals("{1.23s..5.68s}", interval.toString())
        }
    }

    @Test
    fun toStringErrorTest() {
        Assertions.assertThrows(IllegalStateException::class.java) {
            MutableDurationInterval(a = 1.2.seconds, b = 5.6.seconds).toString(points = -1)
        }
    }

    @Test
    fun equalsTest() {
        val foo = MutableDurationInterval(a = 1.2.seconds, b = 5.6.seconds)
        val bar = MutableDurationInterval(a = 1.2.seconds, b = 5.6.seconds)
        Assertions.assertEquals(foo, bar)
        Assertions.assertFalse(foo === bar)
        Assertions.assertTrue(foo == bar)
    }

    @Test
    fun equalsNotTest() {
        val actual = MutableDurationInterval(a = 1.2.seconds, b = 5.6.seconds)
        MutableDurationInterval(a = (-1.2).seconds, b = 5.6.seconds).also { unexpected ->
            Assertions.assertFalse(unexpected === actual)
            Assertions.assertNotEquals(unexpected, actual)
            Assertions.assertFalse(unexpected == actual)
        }
        MutableDurationInterval(a = 1.2.seconds, b = (-5.6).seconds).also { unexpected ->
            Assertions.assertFalse(unexpected === actual)
            Assertions.assertNotEquals(unexpected, actual)
            Assertions.assertFalse(unexpected == actual)
        }
        MutableDurationInterval(a = 1.2.seconds, b = 1.2.seconds).also { unexpected ->
            Assertions.assertFalse(unexpected === actual)
            Assertions.assertNotEquals(unexpected, actual)
            Assertions.assertFalse(unexpected == actual)
        }
        MutableDurationInterval(a = 5.6.seconds, b = 5.6.seconds).also { unexpected ->
            Assertions.assertFalse(unexpected === actual)
            Assertions.assertNotEquals(unexpected, actual)
            Assertions.assertFalse(unexpected == actual)
        }
        MutableDurationInterval(a = 5.6.seconds, b = 1.2.seconds).also { unexpected ->
            Assertions.assertFalse(unexpected === actual)
            Assertions.assertNotEquals(unexpected, actual)
            Assertions.assertFalse(unexpected == actual)
        }
        object : Interval<String> {
            override val a: String = "foo"
            override val b: String = "bar"
        }.also { unexpected ->
            Assertions.assertFalse(actual.equals(unexpected))
        }
        Assertions.assertFalse(actual.equals(Unit))
    }

    @Test
    fun hashCodeTest() {
        @Suppress("IgnoredReturnValue")
        MutableDurationInterval(a = 1.2.seconds, b = 3.4.seconds).hashCode()
    }

    @Test
    fun frequencyTest() {
        val interval: Interval<Duration> = intervalOf(a = Duration.ZERO, b = (1_000_000_000 / 60).nanoseconds)
        Assertions.assertEquals(60.0, interval.frequency(), 0.00001)
        Assertions.assertEquals(120.0, interval.frequency(2.seconds), 0.00001)
    }
}
