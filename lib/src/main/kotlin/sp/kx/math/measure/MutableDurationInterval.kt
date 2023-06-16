package sp.kx.math.measure

import sp.kx.math.unsafe.toString
import java.util.Locale
import java.util.Objects
import kotlin.time.Duration
import kotlin.time.DurationUnit

/**
 * A mutable implementation of the [Interval] type with [Duration]s.
 *
 * Usage:
 * ```
 * val interval = MutableDurationInterval(a = 1.hours, b = 3.hours)
 * interval.a = 2.hours
 * interval.b = 7.hours
 * ```
 * @property a Start of interval value.
 * @property b End of interval value.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
class MutableDurationInterval(
    override var a: Duration,
    override var b: Duration,
) : Interval<Duration> {
    override fun toString(): String {
        return toString(interval = this, points = 2, durationUnit = DurationUnit.SECONDS, locale = Locale.US)
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Interval<*>) return false
        val a = other.a
        if (a !is Duration) return false
        val b = other.b
        if (b !is Duration) return false
        return this.a == a && this.b == b
    }

    override fun hashCode(): Int {
        return Objects.hash(a, b)
    }
}

fun intervalOf(
    a: Duration,
    b: Duration,
): Interval<Duration> {
    return MutableDurationInterval(
        a = a,
        b = b,
    )
}
