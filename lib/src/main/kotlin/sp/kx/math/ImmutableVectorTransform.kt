package sp.kx.math

fun vectorOf(
    startX: Double,
    startY: Double,
    finishX: Double,
    finishY: Double,
    transform: (Double) -> Double,
): Vector {
    return ImmutableVector(
        start = pointOf(x = transform(startX), y = transform(startY)),
        finish = pointOf(x = transform(finishX), y = transform(finishY)),
    )
}

fun vectorOf(
    startX: Double,
    startY: Double,
    finish: Point,
    transform: (Double) -> Double,
): Vector {
    return ImmutableVector(
        start = pointOf(x = transform(startX), y = transform(startY)),
        finish = pointOf(x = transform(finish.x), y = transform(finish.y)),
    )
}

fun Point.toVector(
    x: Double,
    y: Double,
    transform: (Double) -> Double,
): Vector {
    return ImmutableVector(
        start = pointOf(x = transform(this.x), y = transform(this.y)),
        finish = pointOf(x = transform(x), y = transform(y)),
    )
}
