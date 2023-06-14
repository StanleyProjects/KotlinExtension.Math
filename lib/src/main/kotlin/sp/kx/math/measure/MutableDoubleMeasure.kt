package sp.kx.math.measure

import java.util.Objects

class MutableDoubleMeasure(var magnitude: Double) : Measure<Double, Double> {
    override fun toString(): String {
        return super.toString()
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return Objects.hash(magnitude)
    }

    override fun transform(units: Double): Double {
        return units * magnitude
    }
}

fun measureOf(magnitude: Double) : Measure<Double, Double> {
    return MutableDoubleMeasure(magnitude = magnitude)
}
