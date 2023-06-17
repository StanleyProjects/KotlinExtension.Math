package sp.kx.math.measure

import java.util.concurrent.TimeUnit
import kotlin.time.Duration

internal object ZeroSpeed : Speed {
    override fun toString(): String {
        return "{speed: 0.00 per SECONDS}"
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Speed) return false
        return other.per(TimeUnit.NANOSECONDS) == 0.0
    }

    override fun hashCode(): Int {
        return 1
    }

    override fun per(timeUnit: TimeUnit): Double {
        return 0.0
    }

    override fun length(duration: Duration): Double {
        return 0.0
    }
}
