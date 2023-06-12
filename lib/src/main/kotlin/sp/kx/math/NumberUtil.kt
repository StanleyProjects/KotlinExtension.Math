package sp.kx.math

import sp.kx.math.unsafe.eq
import sp.kx.math.unsafe.toString
import java.util.Locale

/**
 * Usage:
 * ```
 * assertEquals("1.23", 1.234567.toString(points = 2))
 * ```
 * @return A [String] of a formatted [Double] number.
 * @receiver The value of this number will be formatted.
 * @param points The number of decimal places to be displayed in the summary [String].
 * @param locale To apply during formatting. Default is [Locale.US].
 * @throws IllegalStateException if [points] count is negative.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.2.1
 */
fun Double.toString(points: Int, locale: Locale = Locale.US): String {
    if (points < 0) error("Points count is negative!")
    return toString(number = this, points, locale)
}

// todo to string integer and fractional part
// fun Double.toString(integer: Int, fractional: Int, locale: Locale = Locale.US): String

/**
 * Compares [this] object [Double] with the specified [other] object [Double].
 *
 * Usage:
 * ```
 * assertTrue(1.2.eq(1.23, 1))
 * assertFalse(1.2.eq(1.23, 2))
 * ```
 * @receiver [this] number will be compared with [other] number.
 * @param other The value of this number will be compared with the value of [this] receiver's number.
 * @param points The number of decimal places to compare.
 * @return `true` if [this] receiver is equal to [other] to [points] decimal places; `false` otherwise
 * @throws IllegalArgumentException if [points] lower than 1.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.2.1
 */
fun Double.eq(other: Double, points: Int): Boolean {
    require(points > 0)
    return eq(it = this, other = other, points = points)
}

// todo Double normalize
