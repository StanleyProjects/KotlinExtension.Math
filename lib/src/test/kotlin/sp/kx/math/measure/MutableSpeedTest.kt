package sp.kx.math.measure

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.concurrent.TimeUnit
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
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
}
