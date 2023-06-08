package sp.kx.math

import sp.kx.math.unsafe.eq
import sp.kx.math.unsafe.toString
import java.util.Locale

/**
 * Usage:
 * ```
 * assertEquals("{x: 1.20, y: 3.40}", pointOf(x = 1.2, y = 3.4).toString(points = 2))
 * ```
 * @return Coordinates of the receiver [Point] in formatted form.
 * @receiver The coordinates of this [Point] will be displayed in the summary [String].
 * @param points The number of decimal places that each coordinate will have.
 * @param locale To apply during formatting. Default is [Locale.US].
 * @throws IllegalStateException if [points] count is negative.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.2.1
 */
fun Point.toString(points: Int, locale: Locale = Locale.US): String {
    if (points < 0) error("Points count is negative!")
    return toString(point = this, points, locale)
}

/**
 * Compares [this] object [Point] with the specified [other] object [Point].
 *
 * Usage:
 * ```
 * assertTrue(pointOf(x = 1.2, y = 3.4).eq(pointOf(x = 1.2, y = 3.45), 1))
 * assertFalse(pointOf(x = 1.2, y = 3.4).eq(pointOf(x = 1.2, y = 3.45), 2))
 * ```
 * @receiver The coordinates of [this] receiver [Point] will be compared with the coordinates of [other].
 * @param other These coordinates will be compared with the coordinates of [this] receiver [Point].
 * @param points The number of decimal places to compare coordinates with.
 * @return `true` if [this] receiver's coordinates are equal to [other]'s coordinates to [points] decimal places; `false` otherwise
 * @throws IllegalArgumentException if [points] lower than 1.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.2.1
 * @see Double.eq
 */
fun Point.eq(other: Point, points: Int): Boolean {
    require(points > 0)
    return eq(it = this, other = other, points = points)
}

/**
 * Creates a new [Point] object with a copy of [this] receiver's coordinates or the values [x] and [y] passed in.
 *
 * Usage:
 * ```
 * val foo = pointOf(x = 3.0, y = 2.0)
 * val bar = foo.copy(y = 3.0)
 *
 *   ^
 *   |
 * 3 -   -   -   * bar
 *   |
 * y -   -   -   * foo
 *   |
 * 1 -           |
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   x   4
 * ```
 * @param x This value will be set as the [Point.x]-coordinate. Default is [Point.x] coordinate of [this] receiver.
 * @param y This value will be set as the [Point.y]-coordinate. Default is [Point.y] coordinate of [this] receiver.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.2.2
 */
fun Point.copy(
    x: Double = this.x,
    y: Double = this.y,
): Point {
    return pointOf(x = x, y = y)
}

/**
 * Creates a new [Point] object with a copy of [this] receiver's swapped coordinates.
 *
 * Usage:
 * ```
 * val foo = pointOf(x = 3.0, y = 2.0)
 * val bar = foo.swapped()
 *
 *   ^
 *   |
 * 3 -   -   * bar
 *   |       |
 * y -   -   -   * foo
 *   |
 * 1 -       |   |
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   x   4
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.2.2
 */
fun Point.swapped(): Point {
    return pointOf(x = y, y = x)
}

/**
 * Creates a new [Point] object with a copy of [this] receiver's coordinates with [dX] and [dY] offsets added to them.
 *
 * Usage:
 * ```
 * val foo = pointOf(x = 1.0, y = 2.0)
 * val bar = foo.plus(dX = 2.0, dY = 1.0)
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
 * @param dX This offset will be added to receiver's [Point.x]-coordinate.
 * @param dY This offset will be added to receiver's [Point.y]-coordinate.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.3.1
 */
fun Point.plus(
    dX: Double,
    dY: Double,
): Point {
    return pointOf(
        x = x + dX,
        y = y + dY,
    )
}

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
 * Creates a new [Point] object with a copy of the coordinates of [this] receiver point at a distance of [length].
 *
 * Usage:
 * ```
 * val foo = pointOf(x = 1.0, y = 2.0)
 * val bar = foo.moved(length = 1.0, angle = kotlin.math.PI / 4)
 *
 *   ^
 *   |
 *   |             * bar
 *   |           /
 *   |        /
 *   |     /  PI/4
 *   |   * foo - - - - -
 *   |
 * 0 +------------------->
 *   0
 * ```
 *
 * Special cases:
 * ```
 * val point = pointOf(x = 1.2, y = 3.4)
 *     .moved(length = 1.0, angle = 0.0)
 * assertEquals(2.2, point.x, 0.01)
 * assertEquals(3.4, point.y, 0.01)
 * ```
 * ```
 * val point = pointOf(x = 1.2, y = 3.4)
 *     .moved(length = 1.0, angle = kotlin.math.PI / 2)
 * assertEquals(1.2, point.x, 0.01)
 * assertEquals(4.4, point.y, 0.01)
 * ```
 * ```
 * val point = pointOf(x = 1.2, y = 3.4)
 *     .moved(length = 1.0, angle = kotlin.math.PI)
 * assertEquals(0.2, point.x, 0.01)
 * assertEquals(3.4, point.y, 0.01)
 * ```
 * @param length The coordinates will be shifted by this distance (taking into account the rotation [angle]).
 * @param angle The angle of rotation around the receiver's [Point.x] and [Point.y] coordinates, given in radians.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.3.1
 */
fun Point.moved(
    length: Double,
    angle: Double,
): Point {
    return pointOf(
        x = x + length * kotlin.math.cos(angle),
        y = y + length * kotlin.math.sin(angle),
    )
}

/**
 * Special case of [moved] method with zero angle.
 *
 * Usage:
 * ```
 * val foo = pointOf(x = 1.0, y = 2.0)
 * val bar = foo.moved(length = 2.0)
 *
 *   ^
 *   |
 * y -
 *   |
 * 2 -   * foo   * bar
 *   |
 * 1 -   |       |
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   3   x
 * ```
 * @param length The receiver's [Point.x]-coordinate will be shifted by this distance.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.3.1
 */
fun Point.moved(length: Double): Point {
    return pointOf(
        x = x + length,
        y = y,
    )
}

/**
 * Usage:
 * ```
 * val point = pointOf(x = 3.0, y = 3.0)
 * val offset = point.minus(x = 2.0, y = 1.0)
 * assertEquals(1.0, offset.x)
 * assertEquals(2.0, offset.y)
 * ```
 * @return The difference between the coordinates of [this] receiver and the coordinates passed to the method, represented as an [Offset] object.
 * @param x This coordinate will be subtracted from the [Point.x]-coordinate of [this] receiver.
 * @param y This coordinate will be subtracted from the [Point.y]-coordinate of [this] receiver.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.3.1
 */
fun Point.minus(
    x: Double,
    y: Double,
): Offset {
    return offsetOf(
        dX = this.x - x,
        dY = this.y - y,
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
