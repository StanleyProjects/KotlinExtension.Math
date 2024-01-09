package sp.kx.math

import sp.kx.math.unsafe.eq
import sp.kx.math.unsafe.toString
import java.util.Locale
import kotlin.math.absoluteValue

/**
 * Decryption:
 * ```
 * 16:   |<---points--->|
 *     1.2300000000000000
 * ```
 *
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
    return toString(number = this, points = points, locale = locale)
}

/**
 * Decryption:
 * ```
 * 16:       |<---points--->|
 * 22: |<-------total------>|
 *     00001.2300000000000000
 * ```
 *
 * Usage:
 * ```
 * assertEquals("01.23", 1.234567.toString(total = 5, points = 2))
 * ```
 * @return A [String] of a formatted [Double] number.
 * @receiver The value of this number will be formatted.
 * @param total The number of total places to be displayed in the summary [String].
 * @param points The number of decimal places to be displayed in the summary [String].
 * @param locale To apply during formatting. Default is [Locale.US].
 * @throws IllegalArgumentException if [total] count is not positive.
 * @throws IllegalStateException if [points] count is negative.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.4
 */
fun Double.toString(total: Int, points: Int, locale: Locale = Locale.US): String {
    require(total > 0) { "Total count is not positive!" }
    if (points < 0) error("Points count is negative!")
    return toString(number = this, total = total, points = points, locale = locale)
}

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

/**
 * Function for coterminal conversion of a [Double].
 * For example, it can be used to convert any radian value to a value between `0.0` and `kotlin.math.PI * 2`.
 *
 * Usage:
 * ```
 * assertEquals(63.0, (-1.0).ct(k = 64.0))
 * assertEquals(1.0, 129.0.ct(k = 128.0))
 * ```
 * @receiver This [Double] will be converted to a coterminal [Double].
 * @param k The coefficient which is used in the coterminal transformation.
 * @return The coterminal [Double] relative to [this] receiver given the [k] coefficient.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.4
 */
fun Double.ct(k: Double): Double {
    return (this % k + k) % k
}

/**
 * A special case of a [Double.ct] with `kotlin.math.PI * 2` coefficient.
 *
 * Usage:
 * ```
 * assertEquals(kotlin.math.PI / 4, (kotlin.math.PI * 2 + kotlin.math.PI / 4).radians())
 * ```
 * @return The coterminal [Double] relative to [this] receiver given the `kotlin.math.PI * 2` coefficient.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.6.0
 */
fun Double.radians(): Double {
    return ct(k = kotlin.math.PI * 2)
}

/**
 * Usage:
 * ```
 * assertEquals(1.0, 1.0.sign())
 * assertEquals(1.0, 42.0.sign())
 * assertEquals(-1.0, -1.0.sign())
 * assertEquals(-1.0, -42.0.sign())
 * ```
 *
 * Special cases:
 * ```
 * assertTrue(0.0.sign().isNan())
 * assertTrue(Double.NaN.sign().isNaN())
 * assertTrue(Double.POSITIVE_INFINITY.sign().isNaN())
 * assertTrue(Double.NEGATIVE_INFINITY.sign().isNaN())
 * ```
 * @return [this] receiver is divided by the absolute value of itself.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.6.0
 */
@Deprecated(message = "replace with 'divide by yourself'", level = DeprecationLevel.ERROR)
fun Double.sign(): Double {
    return div(absoluteValue)
}

/**
 * Usage:
 * ```
 * val value = getUnknownDouble().orNull() ?: 0.0
 * assertFalse(value.isNaN())
 * assertNotNull(1.0.orNull())
 * assertNull(Double.NaN.orNull())
 * ```
 * @return [this] receiver if it is not [Double.NaN] or `null` otherwise.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.6.0
 */
@Deprecated(message = "replace with 'ifNaN'", level = DeprecationLevel.ERROR)
fun Double.orNull(): Double? {
    if (isNaN()) return null
    return this
}

/**
 * Usage:
 * ```
 * val value = getUnknownDouble().orDefault()
 * assertFalse(value.isNaN())
 * assertEquals(0.0, Double.NaN.orDefault())
 * assertEquals(1.0, Double.NaN.orDefault(1.0))
 * assertEquals(42.0, 42.0.orDefault())
 * ```
 * @param other Returns this if [this] receiver is [Double.NaN]. Default is `0.0`.
 * @return [this] receiver if it is not [Double.NaN] or [other] otherwise.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.6.0
 */
@Deprecated(message = "replace with 'ifNaN'", level = DeprecationLevel.ERROR)
fun Double.orDefault(other: Double = 0.0): Double {
    if (isNaN()) return other
    return this
}

// todo which half of the circle
// angle.whc() == (kotlin.math.PI - angle).dby()
