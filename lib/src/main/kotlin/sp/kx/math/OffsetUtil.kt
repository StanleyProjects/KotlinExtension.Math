package sp.kx.math

import sp.kx.math.unsafe.eq
import sp.kx.math.unsafe.toString
import java.util.Locale

/**
 * Usage:
 * ```
 * assertEquals("{dX: 1.20, dY: 3.40}", offsetOf(dX = 1.2, dY = 3.4).toString(points = 2))
 * ```
 * @receiver The values of this [Offset] will be displayed in the summary [String].
 * @param points The number of decimal places that each offset will have.
 * @param locale To apply during formatting. Default is [Locale.US].
 * @return Values of [this] receiver [Offset] in formatted form.
 * @throws IllegalStateException if [points] count is negative.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.3.0
 */
fun Offset.toString(points: Int, locale: Locale = Locale.US): String {
    if (points < 0) error("Points count is negative!")
    return toString(offset = this, points = points, locale = locale)
}

/**
 * Compares [this] object [Offset] with the specified [other] object [Offset].
 *
 * Usage:
 * ```
 * assertTrue(offsetOf(dX = 1.2, dY = 3.4).eq(offsetOf(dX = 1.2, dY = 3.45), points = 1))
 * assertFalse(offsetOf(dX = 1.2, dY = 3.4).eq(offsetOf(dX = 1.2, dY = 3.45), points = 2))
 * ```
 * @receiver The values of [this] receiver [Offset] will be compared with the values of [other].
 * @param other These values will be compared with the values of [this] receiver [Offset].
 * @param points The number of decimal places to compare offsets with.
 * @return `true` if [this] receiver's offsets are equal to [other]'s offsets to [points] decimal places; `false` otherwise
 * @throws IllegalArgumentException if [points] lower than 1.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.3.0
 * @see Double.eq
 */
fun Offset.eq(other: Offset, points: Int): Boolean {
    require(points > 0)
    return eq(it = this, other = other, points = points)
}

/**
 * Creates a new [Offset] object with a copy of [this] receiver's values or the values [dX] and [dY] passed in.
 *
 * Usage:
 * ```
 * val foo = offsetOf(dX = 1.2, dY = 3.4)
 * val bar = foo.copy(dY = 5.6)
 * assertEquals(foo.dX, bar.dX)
 * assertNotEquals(foo.dY, bar.dY)
 * ```
 * @param dX This value will be set as the [Offset.dX] offset. Default is [Offset.dX] value of [this] receiver.
 * @param dY This value will be set as the [Offset.dY] offset. Default is [Offset.dY] value of [this] receiver.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.3.0
 */
fun Offset.copy(
    dX: Double = this.dX,
    dY: Double = this.dY,
): Offset {
    return offsetOf(dX = dX, dY = dY)
}

/**
 * Creates a new [Offset] object with a copy of [this] receiver's swapped values.
 *
 * Usage:
 * ```
 * val foo = offsetOf(dX = 1.2, dY = 3.4)
 * val bar = foo.swapped()
 * assertNotEquals(foo, bar)
 * assertEquals(foo.dX, bar.dY)
 * assertEquals(foo.dY, bar.dX)
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.3.0
 */
fun Offset.swapped(): Offset {
    return offsetOf(dX = dY, dY = dX)
}

/**
 * Usage:
 * ```
 * assertTrue(offsetOf(0.0, 0.01)).isEmpty(points = 1))
 * assertFalse(offsetOf(0.0, 0.01)).isEmpty(points = 2))
 * ```
 * @param points The number of decimal places to compare coordinates with.
 * @return `true` if [this] receiver's [Offset.dX] and [Offset.dY] are equals `0.0` to [points] decimal places; `false` otherwise
 * @throws IllegalArgumentException if [points] lower than 1.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.4
 * @see Double.eq
 */
fun Offset.isEmpty(points: Int): Boolean {
    require(points > 0)
    return eq(it = dX, other = 0.0, points = points) && eq(it = dY, other = 0.0, points = points)
}

/**
 * Usage:
 * ```
 * assertTrue(offsetOf(0.0, 0.0)).isEmpty())
 * assertFalse(offsetOf(0.0, 0.1)).isEmpty())
 * ```
 * @return `true` if [this] receiver's [Offset.dX] and [Offset.dY] are equals `0.0`; `false` otherwise
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.4
 */
fun Offset.isEmpty(): Boolean {
    return dX == 0.0 && dY == 0.0
}
