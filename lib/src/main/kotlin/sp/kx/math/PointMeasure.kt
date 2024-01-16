package sp.kx.math

import sp.kx.math.measure.Measure

/**
 * Usage:
 * ```
 * val measure = measureOf(magnitude = 2.0)
 * val point = pointOf(x = 1.0, y = 2.0, measure = measure)
 *
 *   ^
 *   |
 * 3 -
 *   |
 * 2 -               *
 *   |
 * 1 -
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return An instance of [Point] built from the [Double] values and the [Measure].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.2
 */
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
