package sp.kx.math.measure

import sp.kx.math.unsafe.toString
import java.util.Locale
import java.util.Objects
import kotlin.time.Duration
import kotlin.time.DurationUnit

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
