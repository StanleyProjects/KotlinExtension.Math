package sp.kx.math

import sp.kx.math.measure.Measure

fun vectorOf(
    startX: Double,
    startY: Double,
    finishX: Double,
    finishY: Double,
    measure: Measure<Double, Double>,
): Vector {
    return ImmutableVector(
        start = pointOf(x = measure.transform(startX), y = measure.transform(startY)),
        finish = pointOf(x = measure.transform(finishX), y = measure.transform(finishY)),
    )
}

fun vectorOf(
    startX: Double,
    startY: Double,
    finish: Point,
    measure: Measure<Double, Double>,
): Vector {
    return ImmutableVector(
        start = pointOf(x = measure.transform(startX), y = measure.transform(startY)),
        finish = pointOf(x = measure.transform(finish.x), y = measure.transform(finish.y)),
    )
}

fun Point.toVector(
    x: Double,
    y: Double,
    measure: Measure<Double, Double>,
): Vector {
    return ImmutableVector(
        start = pointOf(x = measure.transform(this.x), y = measure.transform(this.y)),
        finish = pointOf(x = measure.transform(x), y = measure.transform(y)),
    )
}

fun Point.toVector(
    finish: Point,
    measure: Measure<Double, Double>,
): Vector {
    return ImmutableVector(
        start = pointOf(x = measure.transform(this.x), y = measure.transform(this.y)),
        finish = pointOf(x = measure.transform(finish.x), y = measure.transform(finish.y)),
    )
}

fun Vector.map(
    measure: Measure<Double, Double>,
): Vector {
    return ImmutableVector(
        start = pointOf(x = measure.transform(start.x), y = measure.transform(start.y)),
        finish = pointOf(x = measure.transform(finish.x), y = measure.transform(finish.y)),
    )
}
