package sp.kx.math

import sp.kx.math.measure.Measure

/**
 * Usage:
 * ```
 * val foo = offsetOf(dX = 1.0, dY = 2.0)
 * val bar = foo * 2
 * assertFalse(foo === bar)
 * assertEquals(2.0, bar.dX)
 * assertEquals(4.0, bar.dY)
 * ```
 * @return A new [Offset] object with [this] receiver's [Offset.dX] and [Offset.dY] multiplied by the [value].
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
 * Usage:
 * ```
 * val foo = offsetOf(dX = 2.0, dY = 4.0)
 * val bar = foo / 2
 * assertFalse(foo === bar)
 * assertEquals(1.0, bar.dX)
 * assertEquals(2.0, bar.dY)
 * ```
 * @return A new [Offset] object with [this] receiver's [Offset.dX] and [Offset.dY] divided by the [value].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
operator fun Offset.div(value: Double): Offset {
    return offsetOf(
        dX = dX / value,
        dY = dY / value,
    )
}

/**
 * Usage:
 * ```
 * val foo = offsetOf(dX = 1.0, dY = 2.0)
 * val measure = measureOf(magnitude = 2.0)
 * val bar = foo * measure
 * assertFalse(foo === bar)
 * assertEquals(2.0, bar.dX)
 * assertEquals(4.0, bar.dY)
 * ```
 * @return A new [Offset] object with [this] receiver's [Offset.dX] and [Offset.dY] transformed by the [measure].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.0
 */
operator fun Offset.times(measure: Measure<Double, Double>): Offset {
    return offsetOf(
        dX = measure.transform(dX),
        dY = measure.transform(dY),
    )
}

/**
 * Usage:
 * ```
 * val foo = offsetOf(dX = 2.0, dY = 4.0)
 * val measure = measureOf(magnitude = 2.0)
 * val bar = foo / measure
 * assertFalse(foo === bar)
 * assertEquals(1.0, bar.dX)
 * assertEquals(2.0, bar.dY)
 * ```
 * @return A new [Offset] object with [this] receiver's [Offset.dX] and [Offset.dY] units calculated by the [measure].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.0
 */
operator fun Offset.div(measure: Measure<Double, Double>): Offset {
    return offsetOf(
        dX = measure.units(dX),
        dY = measure.units(dY),
    )
}

/**
 * Usage:
 * ```
 * val foo = offsetOf(dX = 3.0, dY = 4.0)
 * val bar = offsetOf(dX = 1.0, dY = 2.0)
 * val baz = foo + bar
 * assertFalse(foo === baz)
 * assertFalse(bar === baz)
 * assertEquals(4.0, bar.dX)
 * assertEquals(6.0, bar.dY)
 * ```
 * @return A new [Offset] object with a copy of [this] receiver's [Offset.dX] and [Offset.dY] with [other]'s [Offset.dX] and [Offset.dY] added to them.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.0
 */
operator fun Offset.plus(other: Offset): Offset {
    return offsetOf(
        dX = dX + other.dX,
        dY = dY + other.dY,
    )
}

/**
 * Usage:
 * ```
 * val foo = offsetOf(dX = 3.0, dY = 4.0)
 * val bar = offsetOf(dX = 1.0, dY = 2.0)
 * val baz = foo - bar
 * assertFalse(foo === baz)
 * assertFalse(bar === baz)
 * assertEquals(2.0, bar.dX)
 * assertEquals(2.0, bar.dY)
 * ```
 * @return A new [Offset] object with a copy of [this] receiver's [Offset.dX] and [Offset.dY] with [other]'s [Offset.dX] and [Offset.dY] subtracted to them.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.0
 */
operator fun Offset.minus(other: Offset): Offset {
    return offsetOf(
        dX = dX - other.dX,
        dY = dY - other.dY,
    )
}
