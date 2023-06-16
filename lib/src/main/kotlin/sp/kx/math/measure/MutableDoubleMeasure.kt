package sp.kx.math.measure

import sp.kx.math.unsafe.toString
import java.util.Locale
import java.util.Objects

/**
 * A mutable implementation of the [Measure] type with [Double]s.
 *
 * Usage:
 * ```
 * val measure = MutableDoubleMeasure(magnitude = 2.0)
 * measure.magnitude = 3.0
 * ```
 * @property magnitude Will be used in the transformation.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
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
