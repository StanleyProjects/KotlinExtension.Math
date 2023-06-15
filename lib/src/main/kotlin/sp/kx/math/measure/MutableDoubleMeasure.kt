package sp.kx.math.measure

import sp.kx.math.unsafe.toString
import java.util.Locale
import java.util.Objects

class MutableDoubleMeasure(override var magnitude: Double) : Measure<Double, Double> {
    override fun toString(): String {
        return toString(measure = this, points = 2, locale = Locale.US)
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Measure<*, *>) return false
        val magnitude = other.magnitude
        if (magnitude !is Double) return false
        return this.magnitude == magnitude
    }

    override fun hashCode(): Int {
        return Objects.hash(magnitude)
    }

    override fun transform(units: Double): Double {
        return units * magnitude
    }
}

fun measureOf(magnitude: Double): Measure<Double, Double> {
    return MutableDoubleMeasure(magnitude = magnitude)
}
