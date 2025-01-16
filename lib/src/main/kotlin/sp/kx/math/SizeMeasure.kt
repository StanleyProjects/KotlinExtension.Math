package sp.kx.math

import sp.kx.math.measure.Measure

// todo doc
fun sizeOf(
    width: Double,
    height: Double,
    measure: Measure<Double, Double>,
): Size {
    return sizeOf(
        width = measure.transform(width),
        height = measure.transform(height),
    )
}
