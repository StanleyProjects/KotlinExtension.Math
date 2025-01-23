package sp.kx.math

/**
 * Usage:
 * ```
 * val offset = offsetOf(dX = 1.0, dY = 2.0) { it * 2.0 }
 * assertEquals(2.0, offset.dX)
 * assertEquals(4.0, offset.dY)
 * ```
 * @return A new [Offset] object with the [dX] and [dY] transformed by the [transform] function.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.1
 */
fun offsetOf(
    dX: Double,
    dY: Double,
    transform: (Double) -> Double,
): Offset {
    return offsetOf(
        dX = transform(dX),
        dY = transform(dY),
    )
}

/**
 * Usage:
 * ```
 * val foo = offsetOf(dX = 1.0, dY = 2.0)
 * val bar = foo.map { it * 2.0 }
 * assertFalse(foo === bar)
 * assertEquals(2.0, bar.dX)
 * assertEquals(4.0, bar.dY)
 * ```
 * @return A new [Offset] object with [this] receiver's [Offset.dX] and [Offset.dY] transformed by the [transform] function.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.1
 */
fun Offset.map(
    transform: (Double) -> Double,
): Offset {
    return offsetOf(
        dX = transform(dX),
        dY = transform(dY),
    )
}

/**
 * Usage:
 * ```
 * val offset = offsetOf(dX = 1.0, dY = 2.0, multiplier = 2.0)
 * assertEquals(2.0, offset.dX)
 * assertEquals(4.0, offset.dY)
 * ```
 * @return A new [Offset] object with the [dX] and [dY] multiplied by the [multiplier].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.1
 */
fun offsetOf(
    dX: Double,
    dY: Double,
    multiplier: Double,
): Offset {
    return offsetOf(
        dX = dX * multiplier,
        dY = dY * multiplier,
    )
}
