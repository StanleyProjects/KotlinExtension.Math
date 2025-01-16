package sp.kx.math

import sp.kx.math.measure.Measure

// todo doc
fun offsetOf(
    dX: Double,
    dY: Double,
    measure: Measure<Double, Double>,
): Offset {
    return offsetOf(
        dX = measure.transform(dX),
        dY = measure.transform(dY),
    )
}
