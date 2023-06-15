package sp.kx.math.measure

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.concurrent.TimeUnit

@Suppress("MagicNumber")
internal class SpeedUtilTest {
    @Test
    fun isEmptyTest() {
        Assertions.assertFalse(speedOf(magnitude = 1.2).isEmpty())
        Assertions.assertFalse(speedOf(magnitude = 0.001).isEmpty())
        Assertions.assertFalse(speedOf(magnitude = -1.2).isEmpty())
        Assertions.assertTrue(speedOf(magnitude = 0.0).isEmpty())
    }

    @Test
    fun isEmptyPointsTest() {
        speedOf(magnitude = 0.01, timeUnit = TimeUnit.NANOSECONDS).also { speed: Speed ->
            Assertions.assertTrue(speed.isEmpty(points = 1))
            Assertions.assertFalse(speed.isEmpty(points = 2))
        }
        speedOf(magnitude = 0.001, timeUnit = TimeUnit.NANOSECONDS).also { speed: Speed ->
            Assertions.assertTrue(speed.isEmpty(points = 1))
            Assertions.assertTrue(speed.isEmpty(points = 2))
            Assertions.assertFalse(speed.isEmpty(points = 3))
            Assertions.assertFalse(speed.isEmpty(points = 4))
            Assertions.assertFalse(speed.isEmpty(points = 8))
            Assertions.assertFalse(speed.isEmpty(points = 16))
        }
        speedOf(magnitude = 0.0001, timeUnit = TimeUnit.NANOSECONDS).also { speed: Speed ->
            Assertions.assertTrue(speed.isEmpty(points = 1))
            Assertions.assertTrue(speed.isEmpty(points = 2))
            Assertions.assertTrue(speed.isEmpty(points = 3))
            Assertions.assertFalse(speed.isEmpty(points = 4))
            Assertions.assertFalse(speed.isEmpty(points = 8))
            Assertions.assertFalse(speed.isEmpty(points = 16))
        }
        speedOf(magnitude = 0.00001, timeUnit = TimeUnit.NANOSECONDS).also { speed: Speed ->
            Assertions.assertTrue(speed.isEmpty(points = 1))
            Assertions.assertTrue(speed.isEmpty(points = 2))
            Assertions.assertTrue(speed.isEmpty(points = 3))
            Assertions.assertTrue(speed.isEmpty(points = 4))
            Assertions.assertFalse(speed.isEmpty(points = 5))
            Assertions.assertFalse(speed.isEmpty(points = 8))
            Assertions.assertFalse(speed.isEmpty(points = 16))
        }
    }

    @Test
    fun isEmptyPointsTimeUnitTest() {
        speedOf(magnitude = 0.09 * 60, timeUnit = TimeUnit.MINUTES).also { speed: Speed ->
            Assertions.assertFalse(speed.isEmpty(points = 1, timeUnit = TimeUnit.MINUTES))
            Assertions.assertTrue(speed.isEmpty(points = 1, timeUnit = TimeUnit.SECONDS))
            Assertions.assertFalse(speed.isEmpty(points = 2, timeUnit = TimeUnit.SECONDS))
        }
        speedOf(magnitude = 0.09 * 60 * 60, timeUnit = TimeUnit.HOURS).also { speed: Speed ->
            Assertions.assertFalse(speed.isEmpty(points = 1, timeUnit = TimeUnit.HOURS))
            Assertions.assertFalse(speed.isEmpty(points = 1, timeUnit = TimeUnit.MINUTES))
            Assertions.assertTrue(speed.isEmpty(points = 1, timeUnit = TimeUnit.SECONDS))
            Assertions.assertFalse(speed.isEmpty(points = 2, timeUnit = TimeUnit.SECONDS))
        }
        speedOf(magnitude = 0.09 * 60, timeUnit = TimeUnit.HOURS).also { speed: Speed ->
            Assertions.assertFalse(speed.isEmpty(points = 1, timeUnit = TimeUnit.HOURS))
            Assertions.assertTrue(speed.isEmpty(points = 1, timeUnit = TimeUnit.MINUTES))
            Assertions.assertFalse(speed.isEmpty(points = 2, timeUnit = TimeUnit.MINUTES))
        }
        speedOf(magnitude = 0.09 * 60 * 60 * 24, timeUnit = TimeUnit.DAYS).also { speed: Speed ->
            Assertions.assertFalse(speed.isEmpty(points = 1, timeUnit = TimeUnit.DAYS))
            Assertions.assertFalse(speed.isEmpty(points = 1, timeUnit = TimeUnit.HOURS))
            Assertions.assertFalse(speed.isEmpty(points = 1, timeUnit = TimeUnit.MINUTES))
            Assertions.assertTrue(speed.isEmpty(points = 1, timeUnit = TimeUnit.SECONDS))
            Assertions.assertFalse(speed.isEmpty(points = 2, timeUnit = TimeUnit.SECONDS))
        }
        speedOf(magnitude = 0.09 * 60 * 24, timeUnit = TimeUnit.DAYS).also { speed: Speed ->
            Assertions.assertFalse(speed.isEmpty(points = 1, timeUnit = TimeUnit.DAYS))
            Assertions.assertFalse(speed.isEmpty(points = 1, timeUnit = TimeUnit.HOURS))
            Assertions.assertTrue(speed.isEmpty(points = 1, timeUnit = TimeUnit.MINUTES))
            Assertions.assertFalse(speed.isEmpty(points = 2, timeUnit = TimeUnit.MINUTES))
        }
        speedOf(magnitude = 0.09 * 24, timeUnit = TimeUnit.DAYS).also { speed: Speed ->
            Assertions.assertFalse(speed.isEmpty(points = 1, timeUnit = TimeUnit.DAYS))
            Assertions.assertTrue(speed.isEmpty(points = 1, timeUnit = TimeUnit.HOURS))
            Assertions.assertFalse(speed.isEmpty(points = 2, timeUnit = TimeUnit.HOURS))
        }
    }

    @Test
    fun isEmptyErrorTest() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            val speed: Speed = speedOf(magnitude = 1.2)
            @Suppress("IgnoredReturnValue")
            speed.isEmpty(points = 0)
        }
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            val speed: Speed = speedOf(magnitude = 1.2)
            @Suppress("IgnoredReturnValue")
            speed.isEmpty(points = -1)
        }
    }
}
