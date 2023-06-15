package sp.kx.math.measure

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.time.Duration
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.nanoseconds
import kotlin.time.Duration.Companion.seconds
import kotlin.time.DurationUnit

internal class DurationIntervalTest {
    @Test
    fun intervalOfTest() {
        val interval = intervalOf(a = 1.2.seconds, b = 3.4.seconds)
        Assertions.assertEquals(1.2 * 1_000, interval.a.inWholeMilliseconds.toDouble())
        Assertions.assertEquals(3.4 * 1_000, interval.b.inWholeMilliseconds.toDouble())
    }

    @Test
    fun isEmptyTest() {
        Assertions.assertTrue(intervalOf(a = 1.2.seconds, b = 1.2.seconds).isEmpty())
        Assertions.assertFalse(intervalOf(a = 1.2.seconds, b = 3.4.seconds).isEmpty())
    }

    @Test
    fun diffTest() {
        Assertions.assertEquals(2.seconds, intervalOf(a = 1.2.seconds, b = 3.2.seconds).diff())
        Assertions.assertEquals(12.8.seconds, intervalOf(a = 12.8.seconds, b = 25.6.seconds).diff())
        Assertions.assertEquals(10.24.seconds, intervalOf(a = 25.6.seconds, b = (25.6 + 10.24).seconds).diff())
    }

    @Test
    fun toStringTest() {
        val interval: Interval<Duration> = intervalOf(a = 120.seconds, b = 180.seconds)
        Assertions.assertEquals("{120.0s..180.0s}", interval.toString(points = 1))
        Assertions.assertEquals("{120000.00ms..180000.00ms}", interval.toString(durationUnit = DurationUnit.MILLISECONDS, points = 2))
        Assertions.assertEquals("{2.000m..3.000m}", interval.toString(durationUnit = DurationUnit.MINUTES, points = 3))
    }

    @Test
    fun toStringNsMcTest() {
        val interval: Interval<Duration> = intervalOf(a = 12000.nanoseconds, b = 56000.nanoseconds)
        Assertions.assertEquals("{12000.0ns..56000.0ns}", interval.toString(durationUnit = DurationUnit.NANOSECONDS, points = 1))
        Assertions.assertEquals("{12.00mc..56.00mc}", interval.toString(durationUnit = DurationUnit.MICROSECONDS, points = 2))
    }

    @Test
    fun toStringHDTest() {
        val interval: Interval<Duration> = intervalOf(a = 1.2.days, b = 5.6.days)
        Assertions.assertEquals("{1.2d..5.6d}", interval.toString(durationUnit = DurationUnit.DAYS, points = 1))
        Assertions.assertEquals("{28.80h..134.40h}", interval.toString(durationUnit = DurationUnit.HOURS, points = 2))
    }
}
