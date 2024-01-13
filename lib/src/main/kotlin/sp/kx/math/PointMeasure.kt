package sp.kx.math

import sp.kx.math.measure.Measure

fun pointOf(
    x: Double,
    y: Double,
    measure: Measure<Double, Double>,
): Point {
    return pointOf(
        x = measure.transform(x),
        y = measure.transform(y),
    )
}
