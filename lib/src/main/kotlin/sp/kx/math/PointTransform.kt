package sp.kx.math

import sp.kx.math.measure.Measure

fun pointOf(
    x: Double,
    y: Double,
    transform: (Double) -> Double,
): Point {
    return MutablePoint(
        x = transform(x),
        y = transform(y),
    )
}

fun Point.map(
    transform: (Double) -> Double,
): Point {
    return pointOf(
        x = transform(x),
        y = transform(y),
    )
}

fun Point.map(
    measure: Measure<Double, Double>,
): Point {
    return pointOf(
        x = measure.transform(x),
        y = measure.transform(y),
    )
}
