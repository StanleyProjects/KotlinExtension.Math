package sp.kx.math.measure

// todo doc
operator fun Measure<Double, Double>.times(value: Double): Measure<Double, Double> {
    return measureOf(magnitude = magnitude * value)
}

// todo doc
operator fun Measure<Double, Double>.div(value: Double): Measure<Double, Double> {
    return measureOf(magnitude = magnitude / value)
}

// todo doc
operator fun Double.times(measure: Measure<Double, Double>): Double {
    return measure.transform(this)
}

// todo doc
operator fun Double.div(measure: Measure<Double, Double>): Double {
    return measure.units(this)
}
