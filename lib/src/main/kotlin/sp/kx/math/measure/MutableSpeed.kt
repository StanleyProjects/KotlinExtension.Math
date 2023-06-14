package sp.kx.math.measure

import java.util.concurrent.TimeUnit
import kotlin.time.Duration

private class MutableSpeed(magnitude: Double, timeUnit: TimeUnit) : Speed {
    private var raw: Double = magnitude / timeUnit.toNanos(1)

    fun set(magnitude: Double, timeUnit: TimeUnit) {
        raw = magnitude / timeUnit.toNanos(1)
    }

    override fun per(timeUnit: TimeUnit): Double {
        return raw * timeUnit.toNanos(1)
    }

    override fun length(duration: Duration): Double {
        return raw * duration.inWholeNanoseconds
    }
}

fun speedOf(magnitude: Double, timeUnit: TimeUnit = TimeUnit.SECONDS): Speed {
    return MutableSpeed(magnitude = magnitude, timeUnit = timeUnit)
}
