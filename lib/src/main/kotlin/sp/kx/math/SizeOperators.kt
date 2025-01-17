package sp.kx.math

import sp.kx.math.measure.Measure

/**
 * Usage:
 * ```
 * val foo = sizeOf(width = 1.0, height = 2.0)
 * val bar = foo * 2
 * assertFalse(foo === bar)
 * assertEquals(2.0, bar.width)
 * assertEquals(4.0, bar.height)
 * ```
 * @return A new [Size] object with [this] receiver's [Size.width] and [Size.height] multiplied by the [value].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.0
 */
operator fun Size.times(value: Double): Size {
    return sizeOf(
        width = width * value,
        height = height * value,
    )
}

/**
 * Usage:
 * ```
 * val foo = sizeOf(width = 2.0, height = 4.0)
 * val bar = foo / 2
 * assertFalse(foo === bar)
 * assertEquals(1.0, bar.width)
 * assertEquals(2.0, bar.height)
 * ```
 * @return A new [Size] object with [this] receiver's [Size.width] and [Size.height] divided by the [value].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.0
 */
operator fun Size.div(value: Double): Size {
    return sizeOf(
        width = width / value,
        height = height / value,
    )
}

/**
 * Usage:
 * ```
 * val foo = sizeOf(width = 1.0, height = 2.0)
 * val measure = measureOf(magnitude = 2.0)
 * val bar = foo * measure
 * assertFalse(foo === bar)
 * assertEquals(2.0, bar.width)
 * assertEquals(4.0, bar.height)
 * ```
 * @return A new [Size] object with [this] receiver's [Size.width] and [Size.height] transformed by the [measure].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.0
 */
operator fun Size.times(measure: Measure<Double, Double>): Size {
    return sizeOf(
        width = measure.transform(width),
        height = measure.transform(height),
    )
}

/**
 * Usage:
 * ```
 * val foo = sizeOf(width = 2.0, height = 4.0)
 * val measure = measureOf(magnitude = 2.0)
 * val bar = foo / measure
 * assertFalse(foo === bar)
 * assertEquals(1.0, bar.width)
 * assertEquals(2.0, bar.height)
 * ```
 * @return A new [Size] object with [this] receiver's [Size.width] and [Size.height] units calculated by the [measure].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.0
 */
operator fun Size.div(measure: Measure<Double, Double>): Size {
    return sizeOf(
        width = measure.units(width),
        height = measure.units(height),
    )
}

// todo doc
operator fun Size.plus(other: Size): Size {
    return sizeOf(
        width = width + other.width,
        height = height + other.height,
    )
}

// todo doc
operator fun Size.minus(other: Size): Size {
    return sizeOf(
        width = width - other.width,
        height = height - other.height,
    )
}
