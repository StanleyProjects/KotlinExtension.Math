package sp.kx.math.measure

import sp.kx.math.unsafe.toString
import java.util.Locale
import java.util.Objects
import java.util.concurrent.TimeUnit
import kotlin.time.Duration

/**
 * A mutable implementation of the [Speed] type.
 *
 * Usage:
 * ```
 * val speed = MutableSpeed(magnitude = 60.0, timeUnit = TimeUnit.HOURS)
 * assertEquals(60.0, speed.per(TimeUnit.HOURS))
 * assertEquals(120.0, speed.length(2.hours))
 * speed.set(magnitude = 50.0, timeUnit = TimeUnit.HOURS)
 * assertEquals(50.0, speed.per(TimeUnit.HOURS))
 * assertEquals(100.0, speed.length(2.hours))
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
class MutableSpeed : Speed {
    private var raw: Double

    constructor(magnitude: Double, timeUnit: TimeUnit) {
        raw = magnitude / timeUnit.toNanos(1)
    }

    constructor(magnitude: Double, time: Duration) {
        raw = magnitude / time.inWholeNanoseconds
    }

    override fun toString(): String {
        return toString(speed = this, timeUnit = TimeUnit.SECONDS, points = 2, locale = Locale.US)
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Speed) return false
        return raw == other.per(TimeUnit.NANOSECONDS)
    }

    override fun hashCode(): Int {
        return Objects.hash(raw)
    }

    fun set(magnitude: Double, timeUnit: TimeUnit) {
        raw = magnitude / timeUnit.toNanos(1)
    }

    fun set(magnitude: Double, time: Duration) {
        raw = magnitude / time.inWholeNanoseconds
    }

    override fun per(timeUnit: TimeUnit): Double {
        return raw * timeUnit.toNanos(1)
    }

    override fun length(duration: Duration): Double {
        return raw * duration.inWholeNanoseconds
    }
}

/**
 * Usage:
 * ```
 * val speed = speedOf(magnitude = 60.0, timeUnit = TimeUnit.HOURS)
 * assertEquals(120.0, speed.length(2.hours))
 * ```
 * @param magnitude This number of [Double]s will pass through `1` unit of time in [timeUnit].
 * @param timeUnit After `1` unit of time in such [TimeUnit] the transferred [magnitude] will pass. Default is [TimeUnit.SECONDS].
 * @return An instance of [Speed] built from [magnitude] and [TimeUnit].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
fun speedOf(magnitude: Double, timeUnit: TimeUnit = TimeUnit.SECONDS): Speed {
    return MutableSpeed(magnitude = magnitude, timeUnit = timeUnit)
}

/**
 * Usage:
 * ```
 * val speed = speedOf(magnitude = 240.0, time = 4.hours)
 * assertEquals(120.0, speed.length(2.hours))
 * ```
 * @param magnitude This number of [Double]s will pass through [time].
 * @param time After this [Duration] the transferred [magnitude] will pass.
 * @return An instance of [Speed] built from [magnitude] and [Duration].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
fun speedOf(magnitude: Double, time: Duration): Speed {
    return MutableSpeed(magnitude = magnitude, time = time)
}
