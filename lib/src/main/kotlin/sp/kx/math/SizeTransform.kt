package sp.kx.math

/**
 * Usage:
 * ```
 * val size = sizeOf(width = 1.0, height = 2.0) { it * 2.0 }
 * assertEquals(2.0, size.width)
 * assertEquals(4.0, size.height)
 * ```
 * @return A new [Size] object with the [width] and [height] transformed by the [transform] function.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.1
 */
fun sizeOf(
    width: Double,
    height: Double,
    transform: (Double) -> Double,
): Size {
    return sizeOf(
        width = transform(width),
        height = transform(height),
    )
}

/**
 * Usage:
 * ```
 * val foo = sizeOf(width = 1.0, height = 2.0)
 * val bar = foo.map { it * 2.0 }
 * assertFalse(foo === bar)
 * assertEquals(2.0, bar.width)
 * assertEquals(4.0, bar.height)
 * ```
 * @return A new [Size] object with [this] receiver's [Size.width] and [Size.height] transformed by the [transform] function.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.1
 */
fun Size.map(
    transform: (Double) -> Double,
): Size {
    return sizeOf(
        width = transform(width),
        height = transform(height),
    )
}

/**
 * Usage:
 * ```
 * val size = sizeOf(width = 1.0, height = 2.0, multiplier = 2.0)
 * assertEquals(2.0, size.width)
 * assertEquals(4.0, size.height)
 * ```
 * @return A new [Size] object with the [width] and [height] multiplied by the [multiplier].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.1
 */
fun sizeOf(
    width: Double,
    height: Double,
    multiplier: Double,
): Size {
    return sizeOf(
        width = width * multiplier,
        height = height * multiplier,
    )
}
