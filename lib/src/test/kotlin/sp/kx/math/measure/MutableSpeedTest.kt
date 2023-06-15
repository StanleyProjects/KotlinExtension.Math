package sp.kx.math.measure

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.concurrent.TimeUnit
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

internal class MutableSpeedTest {
    @Test
    fun constructorTest() {
        val speed = MutableSpeed(magnitude = 1.2, timeUnit = TimeUnit.SECONDS)
        Assertions.assertEquals(1.2, speed.per(timeUnit = TimeUnit.SECONDS))
    }

    @Test
    fun constructorDurationTest() {
        val speed = MutableSpeed(magnitude = 1.2, time = 1.seconds)
        Assertions.assertEquals(1.2, speed.per(timeUnit = TimeUnit.SECONDS))
    }

    @Test
    fun toStringTest() {
        MutableSpeed(magnitude = 1.2, TimeUnit.SECONDS).also { speed ->
            Assertions.assertEquals("{speed: 1.20 per SECONDS}", speed.toString())
        }
        MutableSpeed(magnitude = 1.23, TimeUnit.SECONDS).also { speed ->
            Assertions.assertEquals("{speed: 1.23 per SECONDS}", speed.toString())
        }
        MutableSpeed(magnitude = 1.234, TimeUnit.SECONDS).also { speed ->
            Assertions.assertEquals("{speed: 1.23 per SECONDS}", speed.toString())
        }
        MutableSpeed(magnitude = 5.6, TimeUnit.SECONDS).also { speed ->
            Assertions.assertEquals("{speed: 5.60 per SECONDS}", speed.toString())
        }
        MutableSpeed(magnitude = 5.67, TimeUnit.SECONDS).also { speed ->
            Assertions.assertEquals("{speed: 5.67 per SECONDS}", speed.toString())
        }
        MutableSpeed(magnitude = 5.678, TimeUnit.SECONDS).also { speed ->
            Assertions.assertEquals("{speed: 5.68 per SECONDS}", speed.toString())
        }
        MutableSpeed(magnitude = 1.0 / 1_000, TimeUnit.MILLISECONDS).also { speed ->
            Assertions.assertEquals("{speed: 1.00 per SECONDS}", speed.toString())
        }
        MutableSpeed(magnitude = 60.0, TimeUnit.MINUTES).also { speed ->
            Assertions.assertEquals("{speed: 1.00 per SECONDS}", speed.toString())
        }
        MutableSpeed(magnitude = 60.0 * 60.0, TimeUnit.HOURS).also { speed ->
            Assertions.assertEquals("{speed: 1.00 per SECONDS}", speed.toString())
        }
        MutableSpeed(magnitude = 60.0 * 60.0 * 24.0, TimeUnit.DAYS).also { speed ->
            Assertions.assertEquals("{speed: 1.00 per SECONDS}", speed.toString())
        }
        MutableSpeed(magnitude = 1.0, 1.seconds).also { speed ->
            Assertions.assertEquals("{speed: 1.00 per SECONDS}", speed.toString())
        }
        MutableSpeed(magnitude = 60.0, 1.minutes).also { speed ->
            Assertions.assertEquals("{speed: 1.00 per SECONDS}", speed.toString())
        }
        MutableSpeed(magnitude = 60.0 * 2, 2.minutes).also { speed ->
            Assertions.assertEquals("{speed: 1.00 per SECONDS}", speed.toString())
        }
        MutableSpeed(magnitude = 60.0 * 60.0 * 2, 2.hours).also { speed ->
            Assertions.assertEquals("{speed: 1.00 per SECONDS}", speed.toString())
        }
        MutableSpeed(magnitude = 60.0 * 60.0 * 24.0 * 4, 4.days).also { speed ->
            Assertions.assertEquals("{speed: 1.00 per SECONDS}", speed.toString())
        }
    }

    @Test
    fun equalsTest() {
        val foo = MutableSpeed(magnitude = 1.2, timeUnit = TimeUnit.SECONDS)
        val bar = MutableSpeed(magnitude = 1.2, timeUnit = TimeUnit.SECONDS)
        Assertions.assertEquals(foo, bar)
        Assertions.assertFalse(foo === bar)
        Assertions.assertTrue(foo == bar)
    }

    @Test
    fun equalsNotTest() {
        val actual = MutableSpeed(magnitude = 1.2, timeUnit = TimeUnit.SECONDS)
        MutableSpeed(magnitude = -1.2, timeUnit = TimeUnit.SECONDS).also { unexpected ->
            Assertions.assertFalse(unexpected === actual)
            Assertions.assertNotEquals(unexpected, actual)
            Assertions.assertFalse(unexpected == actual)
        }
        MutableSpeed(magnitude = 3.4, timeUnit = TimeUnit.SECONDS).also { unexpected ->
            Assertions.assertFalse(unexpected === actual)
            Assertions.assertNotEquals(unexpected, actual)
            Assertions.assertFalse(unexpected == actual)
        }
        Assertions.assertFalse(actual.equals(Unit))
    }

    @Test
    fun hashCodeTest() {
        val speed = MutableSpeed(magnitude = 1.2, timeUnit = TimeUnit.SECONDS)
        @Suppress("IgnoredReturnValue")
        speed.hashCode()
    }

    @Test
    fun setTest() {
        val speed = MutableSpeed(magnitude = 1.2, timeUnit = TimeUnit.SECONDS)
        Assertions.assertEquals(1.2, speed.per(timeUnit = TimeUnit.SECONDS))
        speed.set(magnitude = 60.0 * 2, timeUnit = TimeUnit.MINUTES)
        Assertions.assertEquals(2.0, speed.per(timeUnit = TimeUnit.SECONDS))
        speed.set(magnitude = 60.0 * 60.0 * 3, timeUnit = TimeUnit.HOURS)
        Assertions.assertEquals(3.0, speed.per(timeUnit = TimeUnit.SECONDS))
        speed.set(magnitude = 60.0 * 60.0 * 24 * 4, timeUnit = TimeUnit.DAYS)
        Assertions.assertEquals(4.0, speed.per(timeUnit = TimeUnit.SECONDS))
    }

    @Test
    fun setDurationTest() {
        val speed = MutableSpeed(magnitude = 1.2, timeUnit = TimeUnit.SECONDS)
        Assertions.assertEquals(1.2, speed.per(timeUnit = TimeUnit.SECONDS))
        speed.set(magnitude = 3600.0 / 1_000, time = 60.milliseconds)
        Assertions.assertEquals(60.0, speed.per(timeUnit = TimeUnit.SECONDS), 0.0000001)
        Assertions.assertEquals(60.0 * 60.0, speed.per(timeUnit = TimeUnit.MINUTES), 0.0000001)
        speed.set(magnitude = 25.0, time = 5.seconds)
        Assertions.assertEquals(5.0 * 60 * 60, speed.per(timeUnit = TimeUnit.HOURS))
        Assertions.assertEquals(5.0 * 60, speed.per(timeUnit = TimeUnit.MINUTES))
        Assertions.assertEquals(5.0, speed.per(timeUnit = TimeUnit.SECONDS))
        Assertions.assertEquals(5.0 / 1_000, speed.per(timeUnit = TimeUnit.MILLISECONDS))
        speed.set(magnitude = 60.0 * 2 * 2, time = 2.minutes)
        Assertions.assertEquals(2.0, speed.per(timeUnit = TimeUnit.SECONDS))
        speed.set(magnitude = 60.0 * 60.0 * 3 * 3, time = 3.hours)
        Assertions.assertEquals(3.0, speed.per(timeUnit = TimeUnit.SECONDS))
        speed.set(magnitude = 60.0 * 60.0 * 24 * 4 * 4, time = 4.days)
        Assertions.assertEquals(4.0, speed.per(timeUnit = TimeUnit.SECONDS))
    }

    @Test
    fun lengthTest() {
        val speed = MutableSpeed(magnitude = 1.2, timeUnit = TimeUnit.SECONDS)
        Assertions.assertEquals(1.2, speed.length(1.seconds))
        Assertions.assertEquals(1.2 * 2, speed.length(2.seconds))
        Assertions.assertEquals(1.2 * 60, speed.length(1.minutes))
        Assertions.assertEquals(1.2 * 60 * 5.6, speed.length(5.6.minutes))
        Assertions.assertEquals(1.2 * 60 * 60 * 12.8, speed.length(12.8.hours))
        Assertions.assertEquals(1.2 * 60 * 60 * 24 * 25.6, speed.length(25.6.days))
    }
}
