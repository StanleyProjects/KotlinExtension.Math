package sp.kx.math

import sp.kx.math.measure.Measure

fun vectorOf(
    startX: Double,
    startY: Double,
    finishX: Double,
    finishY: Double,
    dX: Double,
    dY: Double,
    measure: Measure<Double, Double>,
): Vector {
    return ImmutableVector(
        start = pointOf(x = measure.transform(startX + dX), y = measure.transform(startY + dY)),
        finish = pointOf(x = measure.transform(finishX + dX), y = measure.transform(finishY + dY)),
    )
}

fun vectorOf(
    startX: Double,
    startY: Double,
    finishX: Double,
    finishY: Double,
    offset: Offset,
    measure: Measure<Double, Double>,
): Vector {
    return vectorOf(
        startX = startX,
        startY = startY,
        finishX = finishX,
        finishY = finishY,
        dX = offset.dX,
        dY = offset.dY,
        measure = measure,
    )
}

fun vectorOf(
    startX: Double,
    startY: Double,
    finish: Point,
    offset: Offset,
    measure: Measure<Double, Double>,
): Vector {
    return vectorOf(
        startX = startX,
        startY = startY,
        finishX = finish.x,
        finishY = finish.y,
        dX = offset.dX,
        dY = offset.dY,
        measure = measure,
    )
}

fun Point.toVector(
    finish: Point,
    offset: Offset,
    measure: Measure<Double, Double>,
): Vector {
    return vectorOf(
        startX = x,
        startY = y,
        finishX = finish.x,
        finishY = finish.y,
        dX = offset.dX,
        dY = offset.dY,
        measure = measure,
    )
}
