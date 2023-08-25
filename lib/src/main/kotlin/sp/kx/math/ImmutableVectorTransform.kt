package sp.kx.math

/**
 * Usage:
 * ```
 * val vector = vectorOf(
 *     startX = 1.0,
 *     startY = 2.0,
 *     finishX = 2.0,
 *     finishY = 1.0,
 * ) { it * 2 }
 *
 *   ^
 *   |
 * 4 -   -   * vector.start
 *   |
 * 3 -       |
 *   |
 * 2 -   -   -   -   * vector.finish
 *   |
 * 1 -       |       |
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   x   4
 * ```
 * @return An instance of [Vector] built from the [Double] values and the [transform] function.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.6.0
 */
fun vectorOf(
    startX: Double,
    startY: Double,
    finishX: Double,
    finishY: Double,
    transform: (Double) -> Double,
): Vector {
    return ImmutableVector(
        start = pointOf(x = transform(startX), y = transform(startY)),
        finish = pointOf(x = transform(finishX), y = transform(finishY)),
    )
}

/**
 * Usage:
 * ```
 * val vector = vectorOf(
 *     startX = 1.0,
 *     startY = 2.0,
 *     finish = pointOf(x = 2.0, y = 1.0),
 * ) { it * 2 }
 *
 *   ^
 *   |
 * 4 -   -   * vector.start
 *   |
 * 3 -       |
 *   |
 * 2 -   -   -   -   * vector.finish
 *   |
 * 1 -       |       |
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   x   4
 * ```
 * @return An instance of [Vector] built from the [Double] values, [Point] and the [transform] function.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.6.0
 */
fun vectorOf(
    startX: Double,
    startY: Double,
    finish: Point,
    transform: (Double) -> Double,
): Vector {
    return ImmutableVector(
        start = pointOf(x = transform(startX), y = transform(startY)),
        finish = pointOf(x = transform(finish.x), y = transform(finish.y)),
    )
}

/**
 * Usage:
 * ```
 * val foo = pointOf(x = 1.0, y = 2.0)
 * val vector = foo.toVector(x = 2.0, y = 1.0) { it * 2 }
 *
 *   ^
 *   |
 * 4 -   -   * vector.start
 *   |
 * 3 -       |
 *   |
 * 2 -   -   -   -   * vector.finish
 *   |
 * 1 -       |       |
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   x   4
 * ```
 * @receiver This [Point] will become the [Vector.start] point transformed by the [transform] function.
 * @param x This value will become the x-coordinate of the [Vector.finish] point transformed by the [transform] function.
 * @param y This value will become the y-coordinate of the [Vector.finish] point transformed by the [transform] function.
 * @return An instance of [Vector] built from the [Double] values, [Point] and the [transform] function.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.6.0
 */
fun Point.toVector(
    x: Double,
    y: Double,
    transform: (Double) -> Double,
): Vector {
    return ImmutableVector(
        start = pointOf(x = transform(this.x), y = transform(this.y)),
        finish = pointOf(x = transform(x), y = transform(y)),
    )
}

/**
 * Usage:
 * ```
 * val foo = pointOf(x = 1.0, y = 2.0) + pointOf(x = 2.0, y = 1.0)
 * val bar = foo.map { it * 2 }
 *
 *   ^
 *   |
 * 4 -       * bar.start
 *   |
 * 3 -
 *   |
 * 2 -   * foo.start * bar.finish
 *   |
 * 1 -       * foo.finish
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   x   4
 * ```
 * @return An instance of [Vector] built from [this] receiver [Vector] and the [transform] function.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.6.0
 */
fun Vector.map(
    transform: (Double) -> Double,
): Vector {
    return ImmutableVector(
        start = pointOf(x = transform(start.x), y = transform(start.y)),
        finish = pointOf(x = transform(finish.x), y = transform(finish.y)),
    )
}
