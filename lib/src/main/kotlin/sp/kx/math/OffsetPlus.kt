package sp.kx.math

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
