package sp.kx.math.measure

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.concurrent.TimeUnit
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

@Suppress("MagicNumber")
internal class SpeedTest {
    @Test
    fun speedOfTest() {
        val speed: Speed = speedOf(magnitude = 1.2 * 60, timeUnit = TimeUnit.MINUTES)
        Assertions.assertEquals(1.2 / 1_000_000_000, speed.per(timeUnit = TimeUnit.NANOSECONDS))
        Assertions.assertEquals(1.2 / 1_000_000, speed.per(timeUnit = TimeUnit.MICROSECONDS))
        Assertions.assertEquals(1.2 / 1_000, speed.per(timeUnit = TimeUnit.MILLISECONDS))
        Assertions.assertEquals(1.2, speed.per(timeUnit = TimeUnit.SECONDS))
        Assertions.assertEquals(1.2 * 60, speed.per(timeUnit = TimeUnit.MINUTES))
        Assertions.assertEquals(1.2 * 60 * 60, speed.per(timeUnit = TimeUnit.HOURS))
        Assertions.assertEquals(1.2 * 60 * 60 * 24, speed.per(timeUnit = TimeUnit.DAYS))
        Assertions.assertEquals(1.2, speed.length(1.seconds))
        Assertions.assertEquals(1.2 * 2, speed.length(2.seconds))
        Assertions.assertEquals(1.2 * 60, speed.length(1.minutes))
        Assertions.assertEquals(1.2 * 60 * 5.6, speed.length(5.6.minutes))
        Assertions.assertEquals(1.2 * 60 * 60 * 12.8, speed.length(12.8.hours))
        Assertions.assertEquals(1.2 * 60 * 60 * 24 * 25.6, speed.length(25.6.days))
    }

    @Test
    fun speedOfDefaultTest() {
        val speed: Speed = speedOf(magnitude = 1.2)
        Assertions.assertEquals(1.2 / 1_000_000_000, speed.per(timeUnit = TimeUnit.NANOSECONDS))
        Assertions.assertEquals(1.2 / 1_000_000, speed.per(timeUnit = TimeUnit.MICROSECONDS))
        Assertions.assertEquals(1.2 / 1_000, speed.per(timeUnit = TimeUnit.MILLISECONDS))
        Assertions.assertEquals(1.2, speed.per(timeUnit = TimeUnit.SECONDS))
        Assertions.assertEquals(1.2 * 60, speed.per(timeUnit = TimeUnit.MINUTES))
        Assertions.assertEquals(1.2 * 60 * 60, speed.per(timeUnit = TimeUnit.HOURS))
        Assertions.assertEquals(1.2 * 60 * 60 * 24, speed.per(timeUnit = TimeUnit.DAYS))
        Assertions.assertEquals(1.2, speed.length(1.seconds))
        Assertions.assertEquals(1.2 * 2, speed.length(2.seconds))
        Assertions.assertEquals(1.2 * 60, speed.length(1.minutes))
        Assertions.assertEquals(1.2 * 60 * 5.6, speed.length(5.6.minutes))
        Assertions.assertEquals(1.2 * 60 * 60 * 12.8, speed.length(12.8.hours))
        Assertions.assertEquals(1.2 * 60 * 60 * 24 * 25.6, speed.length(25.6.days))
    }

    @Test
    fun speedOfDurationTest() {
        val speed: Speed = speedOf(magnitude = 1.2 * 60 * 60 * 25.6, time = 25.6.hours)
        Assertions.assertEquals(1.2 / 1_000_000_000, speed.per(timeUnit = TimeUnit.NANOSECONDS))
        Assertions.assertEquals(1.2 / 1_000_000, speed.per(timeUnit = TimeUnit.MICROSECONDS))
        Assertions.assertEquals(1.2 / 1_000, speed.per(timeUnit = TimeUnit.MILLISECONDS))
        Assertions.assertEquals(1.2, speed.per(timeUnit = TimeUnit.SECONDS))
        Assertions.assertEquals(1.2 * 60, speed.per(timeUnit = TimeUnit.MINUTES))
        Assertions.assertEquals(1.2 * 60 * 60, speed.per(timeUnit = TimeUnit.HOURS))
        Assertions.assertEquals(1.2 * 60 * 60 * 24, speed.per(timeUnit = TimeUnit.DAYS))
        Assertions.assertEquals(1.2, speed.length(1.seconds))
        Assertions.assertEquals(1.2 * 2, speed.length(2.seconds))
        Assertions.assertEquals(1.2 * 60, speed.length(1.minutes))
        Assertions.assertEquals(1.2 * 60 * 5.6, speed.length(5.6.minutes))
        Assertions.assertEquals(1.2 * 60 * 60 * 12.8, speed.length(12.8.hours))
        Assertions.assertEquals(1.2 * 60 * 60 * 24 * 25.6, speed.length(25.6.days))
    }
}
