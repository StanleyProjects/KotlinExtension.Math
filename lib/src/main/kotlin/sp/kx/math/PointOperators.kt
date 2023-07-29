package sp.kx.math

/**
 * Creates a new [Point] object with a copy of [this] receiver's coordinates with [offset]'s values added to them.
 *
 * Usage:
 * ```
 * val foo = pointOf(x = 1.0, y = 2.0)
 * val offset = offsetOf(dX = 2.0, dY = 1.0)
 * val bar = foo + offset
 *
 *   ^
 *   |
 * y -   -   -   * bar
 *   |
 * 2 -   * foo   |
 *   |
 * 1 -   |       |
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   x   4
 * ```
 * @param offset This values will be added to receiver's [Point.x] and [Point.y] coordinates.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.3.1
 */
operator fun Point.plus(offset: Offset): Point {
    return pointOf(
        x = x + offset.dX,
        y = y + offset.dY,
    )
}

/**
 * Creates a new [Point] object with a copy of the [this] coordinates of the destination, minus their [offset] values.
 *
 * Usage:
 * ```
 * val foo = pointOf(x = 3.0, y = 3.0)
 * val offset = offsetOf(dX = 2.0, dY = 1.0)
 * val bar = foo - offset
 *
 *   ^
 *   |
 * y -   -   -   * foo
 *   |
 * 2 -   * bar   |
 *   |
 * 1 -   |       |
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   x   4
 * ```
 * @param offset These values will be subtracted from the [Point.x] and [Point.y] coordinates of [this] receiver.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.1
 */
operator fun Point.minus(offset: Offset): Point {
    return pointOf(
        x = x - offset.dX,
        y = y - offset.dY,
    )
}

/**
 * Usage:
 * ```
 * val foo = pointOf(x = 3.0, y = 3.0)
 * val bar = pointOf(x = 2.0, y = 1.0)
 * val offset = foo - bar
 * assertEquals(1.0, offset.x)
 * assertEquals(2.0, offset.y)
 *
 *   ^
 *   |
 * y -   -   -   * foo
 *   |
 * 2 -   * bar   |
 *   |
 * 1 -   |       |
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   x   4
 * ```
 * @return The difference between the coordinates of [this] receiver and the [other] coordinates passed to the method, represented as an [Offset] object.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.3.1
 */
operator fun Point.minus(other: Point): Offset {
    return offsetOf(
        dX = x - other.x,
        dY = y - other.y,
    )
}

operator fun Point.times(other: Double): Point {
    return pointOf(
        x = x * other,
        y = y * other,
    )
}
