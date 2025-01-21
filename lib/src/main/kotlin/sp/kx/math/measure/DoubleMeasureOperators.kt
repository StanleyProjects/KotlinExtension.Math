package sp.kx.math.measure

/**
 * Usage:
 * ```
 * val m1 = measureOf(magnitude = 2.0)
 * val m2 = m1 * 3.0
 * assertEquals(6.0, m2.magnitude)
 * ```
 * @return A new [Measure] object with [this] receiver's [Measure.magnitude] multiplied by the [value].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.0
 */
operator fun Measure<Double, Double>.times(value: Double): Measure<Double, Double> {
    return measureOf(magnitude = magnitude * value)
}

/**
 * Usage:
 * ```
 * val m1 = measureOf(magnitude = 6.0)
 * val m2 = m1 / 3.0
 * assertEquals(2.0, m2.magnitude)
 * ```
 * @return A new [Measure] object with [this] receiver's [Measure.magnitude] divided by the [value].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.0
 */
operator fun Measure<Double, Double>.div(value: Double): Measure<Double, Double> {
    return measureOf(magnitude = magnitude / value)
}

/**
 * Usage:
 * ```
 * val v1 = 2.0
 * val measure = measureOf(magnitude = 3.0)
 * val v2 = v1 * measure
 * assertEquals(6.0, v2)
 * ```
 * @return [this] receiver's [Double] value transformed by the [measure].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.0
 */
operator fun Double.times(measure: Measure<Double, Double>): Double {
    return measure.transform(this)
}

/**
 * Usage:
 * ```
 * val v1 = 6.0
 * val measure = measureOf(magnitude = 3.0)
 * val v2 = v1 / measure
 * assertEquals(2.0, v2)
 * ```
 * @return Units by [measure] calculated from [this] receiver's [Double] value.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.0
 */
operator fun Double.div(measure: Measure<Double, Double>): Double {
    return measure.units(this)
}
