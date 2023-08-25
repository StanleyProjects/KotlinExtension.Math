package sp.kx.math

import sp.kx.math.measure.Measure

operator fun Vector.plus(offset: Offset): Vector {
    return vectorOf(
        startX = start.x + offset.dX,
        startY = start.y + offset.dY,
        finishX = finish.x + offset.dX,
        finishY = finish.y + offset.dY,
    )
}

operator fun Vector.times(value: Double): Vector {
    return vectorOf(
        startX = start.x * value,
        startY = start.y * value,
        finishX = finish.x * value,
        finishY = finish.y * value,
    )
}

operator fun Vector.plus(
    measure: Measure<Double, Double>,
): Vector {
    return ImmutableVector(
        start = pointOf(x = measure.transform(start.x), y = measure.transform(start.y)),
        finish = pointOf(x = measure.transform(finish.x), y = measure.transform(finish.y)),
    )
}
