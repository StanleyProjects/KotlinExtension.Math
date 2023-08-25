package sp.kx.math

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
