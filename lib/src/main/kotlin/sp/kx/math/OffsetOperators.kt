package sp.kx.math

/**
 * Creates a new [Offset] object with a copy of [this] receiver's multiplied by the [value].
 *
 * Usage:
 * ```
 * val foo = offsetOf(dX = 1.2, dY = 3.4)
 * val bar = foo * 2
 * assertNotEquals(foo, bar)
 * assertEquals(bar.dX, 2.4)
 * assertEquals(bar.dY, 6.8)
 * ```
 * @param value Receiver offsets will be multiplied by this value.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
operator fun Offset.times(value: Double): Offset {
    return offsetOf(
        dX = dX * value,
        dY = dY * value,
    )
}

/**
 * Creates a new [Offset] object with a copy of [this] receiver's divided by the [value].
 *
 * Usage:
 * ```
 * val foo = offsetOf(dX = 1.2, dY = 3.4)
 * val bar = foo / 2
 * assertNotEquals(foo, bar)
 * assertEquals(bar.dX, 0.6)
 * assertEquals(bar.dY, 1.7)
 * ```
 * @param value Receiver offsets will be divided by this value.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
operator fun Offset.div(value: Double): Offset {
    return offsetOf(
        dX = dX / value,
        dY = dY / value,
    )
}
