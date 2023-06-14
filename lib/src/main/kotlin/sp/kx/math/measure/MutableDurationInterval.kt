package sp.kx.math.measure

import java.util.Objects
import kotlin.time.Duration

class MutableDurationInterval(
    override var a: Duration,
    override var b: Duration
) : Interval<Duration> {
    override fun toString(): String {
        return super.toString()
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return Objects.hash(a, b)
    }
}
