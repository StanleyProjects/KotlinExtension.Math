package sp.kx.math.measure

import sp.kx.math.unsafe.toString
import java.util.Locale
import java.util.Objects
import java.util.concurrent.TimeUnit
import kotlin.time.Duration

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

fun speedOf(magnitude: Double, timeUnit: TimeUnit = TimeUnit.SECONDS): Speed {
    return MutableSpeed(magnitude = magnitude, timeUnit = timeUnit)
}

fun speedOf(magnitude: Double, time: Duration): Speed {
    return MutableSpeed(magnitude = magnitude, time = time)
}
