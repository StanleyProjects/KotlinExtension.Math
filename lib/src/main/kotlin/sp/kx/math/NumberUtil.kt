package sp.kx.math

import sp.kx.math.unsafe.toString
import java.util.Locale
import kotlin.math.absoluteValue
import kotlin.math.pow

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

fun Double.eq(other: Double, points: Int): Boolean {
    if (points < 0) error("Points count is negative!")
    return (this - other).absoluteValue < 10.0.pow(-points)
}
