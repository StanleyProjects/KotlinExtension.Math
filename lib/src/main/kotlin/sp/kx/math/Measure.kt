package sp.kx.math

import java.util.concurrent.TimeUnit
import kotlin.time.Duration

interface Measure<T : Any, U : Any> {
    fun transform(units: T): U
}

private class MeasureUnit(var raw: Int) : Measure<Double, Int> {
    override fun transform(units: Double): Int {
        return (units * raw).toInt()
    }
}

interface Speed {
    fun per(timeUnit: TimeUnit): Double
    fun length(duration: Duration): Double
}

private class MutableSpeed(var raw: Double) : Speed {
    override fun per(timeUnit: TimeUnit): Double {
        return raw * timeUnit.toNanos(1)
    }

    override fun length(duration: Duration): Double {
        return raw * duration.inWholeNanoseconds
    }
}
