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

/**
 * Usage:
 * ```
 * val foo = offsetOf(dX = 1.0, dY = 2.0)
 * val bar = foo.reversed()
 * assertFalse(foo === bar)
 * assertEquals(-1.0, bar.dX)
 * assertEquals(-2.0, bar.dY)
 * ```
 * @return A new [Offset] object with [this] receiver's [Offset.dX] and [Offset.dY] multiplied by the -1.0.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
fun Offset.reversed(): Offset {
    return offsetOf(dX = dX * -1.0, dY = dY * -1.0)
}

/**
 * In particular, it can be used to obtain the [Offset] relative to the center of a rectangle that has dimensions [Size.width] x [Size.height].
 *
 * Usage:
 * ```
 * val foo = offsetOf(dX = 3.0, dY = 4.0)
 * val size = sizeOf(width = 1.0, height = 2.0)
 * val bar = foo.plus(size = size, multiplier = 2.0)
 * assertFalse(foo === bar)
 * assertEquals(5.0, bar.dX)
 * assertEquals(8.0, bar.dY)
 * ```
 *
 * Special case:
 * ```
 * val offset: Offset = ...
 * val size: Size = ...
 * val foo = offset.plus(size = size, multiplier = -0.5)
 * ```
 *
 * ```
 *  ^
 *  |    offset
 *  -   *
 *  |        size
 *  -       * - - - *
 *  |       |       |
 *  -       |       |
 *  |       |       |
 *  -       * - - - *
 *  |
 *  *---|---|---|---|--->
 * ```
 *
 * @return A new [Offset] object with a copy of [this] receiver's [Offset.dX] and [Offset.dY] with [size]'s [Size.width] and [Size.height] multiplied by the [multiplier] added to them.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.0
 */
fun Offset.plus(size: Size, multiplier: Double): Offset {
    return offsetOf(dX = dX + size.width * multiplier, dY = dY + size.height * multiplier)
}

/**
 * Usage:
 * ```
 * val foo = offsetOf(dX = 1.0, dY = 2.0)
 * val bar = foo.plus(dX = 2.0, dY = 1.0)
 * assertFalse(foo === bar)
 * assertEquals(3.0, bar.dX)
 * assertEquals(3.0, bar.dY)
 * ```
 *
 * ```
 *   ^
 *   |
 * 3 -           * bar
 *   |
 * 2 -   * foo
 *   |
 * 1 -
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 *
 * @return A new [Offset] object with a copy of [this] receiver's [Offset.dX] and [Offset.dY] with the [dX] and [dY] offsets added to them.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.1
 */
fun Offset.plus(dX: Double, dY: Double): Offset {
    return offsetOf(
        dX = this.dX + dX,
        dY = this.dY + dY,
    )
}

/**
 * Usage:
 * ```
 * val foo = offsetOf(dX = 1.0, dY = 1.0)
 * val size = sizeOf(width = 1.0, height = 2.0)
 * val bar = foo.plus(dX = 2.0, dY = 1.0)
 * assertFalse(foo === bar)
 * assertEquals(4.0, bar.dX)
 * assertEquals(4.0, bar.dY)
 * ```
 *
 * ```
 *   ^
 *   |
 * 4 -               * bar
 *   |
 * 3 -
 *   |
 * 2 -
 *   |
 * 1 -   * foo
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 *
 * @return A new [Offset] object with a copy of [this] receiver's [Offset.dX] and [Offset.dY]
 * with [size]'s [Size.width] and [Size.height] and
 * with the [dX] and [dY] offsets added to them.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.1
 */
fun Offset.plus(size: Size, dX: Double, dY: Double): Offset {
    return offsetOf(
        dX = this.dX + size.width + dX,
        dY = this.dY + size.height + dY,
    )
}

/**
 * Usage:
 * ```
 * val foo = offsetOf(dX = 1.0, dY = 1.0)
 * val bar = foo.plus(dX = 1.0, dY = 1.0, multiplier = 2.0)
 * assertFalse(foo === bar)
 * assertEquals(3.0, bar.dX)
 * assertEquals(3.0, bar.dY)
 * ```
 *
 * ```
 *   ^
 *   |
 * 3 -           * bar
 *   |
 * 2 -
 *   |
 * 1 -   * foo
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 *
 * @return A new [Offset] object with a copy of [this] receiver's [Offset.dX] and [Offset.dY]
 * with the [dX] and [dY] offsets multiplied by the [multiplier] added to them.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.1
 */
fun Offset.plus(dX: Double, dY: Double, multiplier: Double): Offset {
    return offsetOf(
        dX = this.dX + dX * multiplier,
        dY = this.dY + dY * multiplier,
    )
}

/**
 * Usage:
 * ```
 * val foo = offsetOf(dX = 0.0, dY = 0.0)
 * val size = sizeOf(width = 1.0, height = 1.0)
 * val bar = foo.plus(size = size, dX = 1.0, dY = 1.0, multiplier = 2.0)
 * assertFalse(foo === bar)
 * assertEquals(4.0, bar.dX)
 * assertEquals(4.0, bar.dY)
 * ```
 *
 * ```
 *   ^
 *   |
 * 4 -               * bar
 *   |
 * 3 -
 *   |
 * 2 -
 *   |
 * 1 -
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 *
 * @return A new [Offset] object with a copy of [this] receiver's [Offset.dX] and [Offset.dY]
 * with [size]'s [Size.width] and [Size.height] and
 * with the [dX] and [dY] offsets multiplied by the [multiplier] added to them.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.1
 */
fun Offset.plus(size: Size, dX: Double, dY: Double, multiplier: Double): Offset {
    return offsetOf(
        dX = this.dX + (size.width + dX) * multiplier,
        dY = this.dY + (size.height + dY) * multiplier,
    )
}
