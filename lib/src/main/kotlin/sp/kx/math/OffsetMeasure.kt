package sp.kx.math

import sp.kx.math.measure.Measure

/**
 * Usage:
 * ```
 * val measure = measureOf(magnitude = 2.0)
 * val offset = offsetOf(dX = 1.5, dY = 1.0, measure = measure)
 * assertEquals(3.0, offset.dX)
 * assertEquals(2.0, offset.dY)
 * ```
 *
 * ```
 *   ^
 *   |
 * 3 -
 *   |
 *dY -           *
 *   |
 * 1 -
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   dX  4
 * ```
 * @return An instance of [Offset] built from the [Double] values and the [Measure].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.0
 */
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
