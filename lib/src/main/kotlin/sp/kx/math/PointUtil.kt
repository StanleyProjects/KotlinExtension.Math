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
 * @throws IllegalStateException if [points] count is negative.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.2.1
 * @see Double.eq
 */
fun Point.eq(other: Point, points: Int): Boolean {
    if (points < 0) error("Points count is negative!")
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

fun Point.plus(
    dX: Double,
    dY: Double,
): Point {
    return pointOf(
        x = x + dX,
        y = y + dY,
    )
}

operator fun Point.plus(offset: Offset): Point {
    return pointOf(
        x = x + offset.dX,
        y = y + offset.dY,
    )
}

fun Point.moved(
    length: Double,
    angle: Double,
): Point {
    return pointOf(
        x = x + length * kotlin.math.cos(angle),
        y = y + length * kotlin.math.sin(angle),
    )
}

fun Point.moved(length: Double): Point {
    return pointOf(
        x = x + length,
        y = y,
    )
}

fun Point.offset(
    x: Double,
    y: Double,
): Offset {
    return offsetOf(
        dX = this.x - x,
        dY = this.y - y,
    )
}

fun Point.offset(other: Point): Offset {
    return offsetOf(
        dX = x - other.x,
        dY = y - other.y,
    )
}
