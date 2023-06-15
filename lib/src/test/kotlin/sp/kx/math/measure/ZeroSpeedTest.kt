package sp.kx.math.measure

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.microseconds
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.nanoseconds
import kotlin.time.Duration.Companion.seconds

@Suppress("MagicNumber")
internal class ZeroSpeedTest {
    @Test
    fun toStringTest() {
        Speed.Zero.also { speed ->
            Assertions.assertEquals("{speed: 0.00 per SECONDS}", speed.toString())
        }
    }

    @Test
    fun equalsTest() {
        val expected = speedOf(magnitude = 0.0)
        Assertions.assertEquals(expected, Speed.Zero)
        Assertions.assertFalse(expected === Speed.Zero)
        Assertions.assertTrue(Speed.Zero == expected)
    }

    @Test
    fun equalsNotTest() {
        speedOf(magnitude = 0.001).also { unexpected: Speed ->
            Assertions.assertFalse(unexpected === Speed.Zero)
            Assertions.assertNotEquals(unexpected, Speed.Zero)
            Assertions.assertFalse(Speed.Zero == unexpected)
        }
        speedOf(magnitude = 1.2).also { unexpected: Speed ->
            Assertions.assertFalse(unexpected === Speed.Zero)
            Assertions.assertNotEquals(unexpected, Speed.Zero)
            Assertions.assertFalse(Speed.Zero == unexpected)
        }
        speedOf(magnitude = -3.4).also { unexpected: Speed ->
            Assertions.assertFalse(unexpected === Speed.Zero)
            Assertions.assertNotEquals(unexpected, Speed.Zero)
            Assertions.assertFalse(Speed.Zero == unexpected)
        }
        Assertions.assertFalse(Speed.Zero.equals(Unit))
    }

    @Test
    fun hashCodeTest() {
        Assertions.assertEquals(1, Speed.Zero.hashCode())
    }

    @Test
    fun lengthTest() {
        Assertions.assertEquals(0.0, Speed.Zero.length(1.nanoseconds))
        Assertions.assertEquals(0.0, Speed.Zero.length(42.nanoseconds))
        Assertions.assertEquals(0.0, Speed.Zero.length(1.microseconds))
        Assertions.assertEquals(0.0, Speed.Zero.length(1.milliseconds))
        Assertions.assertEquals(0.0, Speed.Zero.length(1.seconds))
        Assertions.assertEquals(0.0, Speed.Zero.length(1.minutes))
        Assertions.assertEquals(0.0, Speed.Zero.length(1.hours))
        Assertions.assertEquals(0.0, Speed.Zero.length(1.days))
    }
}
