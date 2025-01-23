package sp.kx.math

import sp.kx.math.measure.Measure

/**
 * Usage:
 * ```
 * val measure = measureOf(magnitude = 2.0)
 * val size = sizeOf(width = 1.5, height = 1.0, measure = measure)
 * assertEquals(3.0, size.width)
 * assertEquals(2.0, size.height)
 * ```
 *
 * ```
 *   ^
 *   |
 * 3 -
 *   |
 * h -           *
 *   |
 * 1 -
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   w   4
 * ```
 * @return An instance of [Size] built from the [Double] values and the [Measure].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.0
 */
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
