package sp.kx.math

import sp.kx.math.measure.Measure

/**
 * Creates a new [Vector] object with a copy of [this] receiver's [Point]s with [offset]'s values added to them.
 *
 * Usage:
 * ```
 * val foo = pointOf(x = 1.0, y = 2.0) + pointOf(x = 2.0, y = 1.0)
 * val offset = offsetOf(dX = 1.0, dY = 2.0)
 * val bar = foo + offset
 *
 *   ^
 *   |
 * 4 -       * bar.start
 *   |
 * 3 -           * bar.finish
 *   |
 * 2 -   * foo.start
 *   |
 * 1 -       * foo.finish
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @param offset This values will be added to [this] receiver's [Vector.start] and [Vector.finish] points.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.6.0
 */
operator fun Vector.plus(offset: Offset): Vector {
    return vectorOf(
        startX = start.x + offset.dX,
        startY = start.y + offset.dY,
        finishX = finish.x + offset.dX,
        finishY = finish.y + offset.dY,
    )
}

/**
 * Usage:
 * ```
 * val foo = pointOf(x = 1.0, y = 2.0) + pointOf(x = 2.0, y = 1.0)
 * val bar = foo * 2
 *
 *   ^
 *   |
 * 4 -       * bar.start
 *   |
 * 3 -
 *   |
 * 2 -   * foo.start * bar.finish
 *   |
 * 1 -       * foo.finish
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   x   4
 * ```
 * @return A new [Vector] object with [this] receiver's [Point]s multiplied by the [value].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.6.0
 */
operator fun Vector.times(value: Double): Vector {
    return vectorOf(
        startX = start.x * value,
        startY = start.y * value,
        finishX = finish.x * value,
        finishY = finish.y * value,
    )
}

/**
 * Usage:
 * ```
 * val foo = pointOf(x = 1.0, y = 2.0) + pointOf(x = 2.0, y = 1.0)
 * val measure = measureOf(magnitude = 2.0)
 * val bar = foo + measure
 *
 *   ^
 *   |
 * 4 -       * bar.start
 *   |
 * 3 -
 *   |
 * 2 -   * foo.start * bar.finish
 *   |
 * 1 -       * foo.finish
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   x   4
 * ```
 * @return A new [Vector] object with [this] receiver's [Point]s transformed by the [measure].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.6.0
 */
operator fun Vector.plus(
    measure: Measure<Double, Double>,
): Vector {
    return ImmutableVector(
        start = pointOf(x = measure.transform(start.x), y = measure.transform(start.y)),
        finish = pointOf(x = measure.transform(finish.x), y = measure.transform(finish.y)),
    )
}
