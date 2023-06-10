package sp.kx.math

import sp.kx.math.unsafe.eq
import sp.kx.math.unsafe.toString
import java.util.Locale

/**
 * Usage:
 * ```
 * val foo = pointOf(x = 1.23, y = 4.56) + pointOf(x = 7.89, y = 10.1)
 * assertEquals("{x: 1.2, y: 4.6} -> {x: 7.9, y: 10.1}", foo.toString(points = 1))
 * ```
 * @return Coordinates of [this] receiver's [Vector.start] and [Vector.finish] points in formatted form.
 * @param points The number of decimal places that each coordinate will have.
 * @param locale To apply during formatting. Default is [Locale.US].
 * @throws IllegalStateException if [points] count is negative.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.1
 */
fun Vector.toString(points: Int, locale: Locale = Locale.US): String {
    if (points < 0) error("Points count is negative!")
    return toString(vector = this, points = points, locale = locale)
}

/**
 * Compares [this] object [Vector] with the specified [other] object [Vector].
 *
 * Usage:
 * ```
 * val foo = pointOf(x = 1.2, y = 4.5) + pointOf(x = 7.8, y = 10.1)
 * val bar = pointOf(x = 1.23, y = 4.56) + pointOf(x = 7.89, y = 10.1)
 * assertTrue(foo.eq(other = bar, points = 1))
 * assertFalse(foo.eq(other = bar, points = 2))
 * ```
 * @receiver The coordinates of [this] receiver's [Vector.start] and [Vector.finish] points will be compared with the points of [other].
 * @param other These points will be compared with the points of [this] receiver [Vector].
 * @param points The number of decimal places to compare coordinates with.
 * @return `true` if [this] receiver's point are equal to [other]'s points; `false` otherwise
 * @throws IllegalArgumentException if [points] lower than 1.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.1
 * @see Point.eq
 */
fun Vector.eq(other: Vector, points: Int): Boolean {
    require(points > 0)
    return eq(it = this, other = other, points = points)
}

/**
 * Creates a new [Vector] object with a copy of [this] receiver's points or the [start] and [finish] passed in.
 *
 * Usage:
 * ```
 * val foo = pointOf(1, 1) + pointOf(3, 1)
 * val bar = foo.copy(finish = pointOf(1, 3))
 *
 *   ^
 *   |
 * 3 -   ^ bar
 *   |   |
 * 2 -   |
 *   |   |
 * 1 -   * - - - > foo
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @param start This value will be set as the [Vector.start] point. Default is [Vector.start] point of [this] receiver.
 * @param finish This value will be set as the [Vector.finish] point. Default is [Vector.finish] point of [this] receiver.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.1
 */
fun Vector.copy(
    start: Point = this.start,
    finish: Point = this.finish,
): Vector {
    return start + finish
}

// todo get center Point
// todo is empty
// todo of length + angle
// todo of points + offset
// todo of point + offset
