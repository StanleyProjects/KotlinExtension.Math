package sp.kx.math

import sp.kx.math.unsafe.eq
import sp.kx.math.unsafe.toString
import java.util.Locale

/**
 * Usage:
 * ```
 * val size = sizeOf(width = 1.2, height = 3.4)
 * assertEquals("1.20x3.40", size.toString(points = 2))
 * ```
 * @receiver The values of this [Size] will be displayed in the summary [String].
 * @param points The number of decimal places that each offset will have.
 * @param locale To apply during formatting. Default is [Locale.US].
 * @return Values of [this] receiver [Size] in formatted form.
 * @throws IllegalStateException if [points] count is negative.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
fun Size.toString(points: Int, locale: Locale = Locale.US): String {
    if (points < 0) error("Points count is negative!")
    return toString(size = this, points = points, locale = locale)
}

/**
 * Compares [this] object [Size] with the specified [other] object [Size].
 *
 * Usage:
 * ```
 * val foo = sizeOf(width = 1.2, height = 3.4)
 * val bar = sizeOf(width = 1.2, height = 3.45)
 * assertTrue(foo.eq(bar, points = 1))
 * assertFalse(foo.eq(bar, points = 2))
 * ```
 * @receiver The values of [this] receiver [Size] will be compared with the values of [other].
 * @param other These values will be compared with the values of [this] receiver [Size].
 * @param points The number of decimal places to compare offsets with.
 * @return `true` if [this] receiver's size are equal to [other]'s size to [points] decimal places; `false` otherwise
 * @throws IllegalArgumentException if [points] lower than 1.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 * @see Double.eq
 */
fun Size.eq(other: Size, points: Int): Boolean {
    require(points > 0)
    return eq(it = this, other = other, points = points)
}

/**
 * Usage:
 * ```
 * val size: Size = sizeOf(width = 1.2, height = 3.4)
 * val offset: Offset = size.toOffset()
 * assertEquals(size.width, offset.dX)
 * assertEquals(size.height, offset.dY)
 * ```
 * @receiver The values of this [Size] will be passed to the result [Offset].
 * @return An [Offset] that is the copy of the [Size.width] and the [Size.height].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
fun Size.toOffset(): Offset {
    return offsetOf(
        dX = width,
        dY = height,
    )
}

/**
 * Usage:
 * ```
 * val size: Size = sizeOf(width = 1.2, height = 3.4)
 * val offset: Offset = size.center()
 * assertEquals(0.6, offset.dX)
 * assertEquals(1.7, offset.dY)
 * ```
 * @receiver The values of this [Size] divided by `2` will be passed to the result [Offset].
 * @return An [Offset] that is the copy of the [Size.width] and the [Size.height] divided by `2`.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
fun Size.center(): Offset {
    return offsetOf(
        dX = width / 2,
        dY = height / 2,
    )
}

/**
 * Usage:
 * ```
 * assertTrue(sizeOf(width = 0.0, height = 0.01).isEmpty(points = 1))
 * assertFalse(sizeOf(width = 0.0, height = 0.01).isEmpty(points = 2))
 * ```
 * @param points The number of decimal places to compare coordinates with.
 * @return `true` if [this] receiver's [Size.width] is equal to `0`
 * and [this] receiver's [Size.height] is equal to `0` to [points] decimal places; `false` otherwise
 * @throws IllegalArgumentException if [points] lower than 1.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 * @see Double.eq
 */
fun Size.isEmpty(points: Int): Boolean {
    require(points > 0)
    return eq(it = width, other = 0.0, points = points) && eq(it = height, other = 0.0, points = points)
}

/**
 * Usage:
 * ```
 * assertTrue(sizeOf(width = 0.0, height = 0.0).isEmpty())
 * assertFalse(sizeOf(width = 1.2, height = 3.4).isEmpty())
 * ```
 * @return `true` if [this] receiver's [Size.width] is equal to `0` and [this] receiver's [Size.height] is equal to `0`; `false` otherwise
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
fun Size.isEmpty(): Boolean {
    return width == 0.0 && height == 0.0
}

fun sizeOf(
    width: Int,
    height: Int,
): Size {
    return MutableSize(
        width = width.toDouble(),
        height = height.toDouble(),
    )
}
