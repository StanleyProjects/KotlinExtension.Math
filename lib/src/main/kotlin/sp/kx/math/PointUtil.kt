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
 */
fun Point.eq(other: Point, points: Int): Boolean {
    if (points < 0) error("Points count is negative!")
    return eq(it = this, other = other, points = points)
}
