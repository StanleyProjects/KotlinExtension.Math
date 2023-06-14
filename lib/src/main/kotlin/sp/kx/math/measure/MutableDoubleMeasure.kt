package sp.kx.math.measure

class MutableDoubleMeasure(var magnitude: Double) : Measure<Double, Double> {
    override fun transform(units: Double): Double {
        return units * magnitude
    }
}

fun measureOf(magnitude: Double) : Measure<Double, Double> {
    return MutableDoubleMeasure(magnitude = magnitude)
}
