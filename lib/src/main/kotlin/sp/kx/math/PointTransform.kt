package sp.kx.math

/**
 * Usage:
 * ```
 * val point = pointOf(x = 1.0, y = 2.0) { it * 2.0 }
 * assertEquals(2.0, point.x)
 * assertEquals(4.0, point.y)
 * ```
 *
 * ```
 *   ^
 *   |
 * 4 -       *
 *   |
 * 3 -
 *   |
 * 2 -
 *   |
 * 1 -
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return A new [Point] object with the [x] and [y] transformed by the [transform] function.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.6.0
 */
fun pointOf(
    x: Double,
    y: Double,
    transform: (Double) -> Double,
): Point {
    return pointOf(
        x = transform(x),
        y = transform(y),
    )
}

/**
 * Usage:
 * ```
 * val foo = offsetOf(dX = 1.0, dY = 2.0)
 * val bar = foo.map { it * 2.0 }
 * assertFalse(foo === bar)
 * assertEquals(2.0, bar.x)
 * assertEquals(4.0, bar.y)
 * ```
 *
 * ```
 *   ^
 *   |
 * 4 -       * bar
 *   |
 * 3 -
 *   |
 * 2 -   * foo
 *   |
 * 1 -
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return A new [Point] object with [this] receiver's [Point.x] and [Point.y] transformed by the [transform] function.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.6.0
 */
fun Point.map(
    transform: (Double) -> Double,
): Point {
    return pointOf(
        x = transform(x),
        y = transform(y),
    )
}

/**
 * Usage:
 * ```
 * val point = pointOf(x = 1.0, y = 2.0, multiplier = 2.0)
 * assertEquals(2.0, point.x)
 * assertEquals(4.0, point.y)
 * ```
 *
 * ```
 *   ^
 *   |
 * 4 -       *
 *   |
 * 3 -
 *   |
 * 2 -
 *   |
 * 1 -
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return A new [Point] object with the [x] and [y] coordinates multiplied by the [multiplier].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.1
 */
fun pointOf(
    x: Double,
    y: Double,
    multiplier: Double,
): Point {
    return pointOf(
        x = x * multiplier,
        y = y * multiplier,
    )
}
