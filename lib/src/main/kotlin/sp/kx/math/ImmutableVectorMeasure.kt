package sp.kx.math

import sp.kx.math.measure.Measure

/**
 * Usage:
 * ```
 * val measure = measureOf(magnitude = 2.0)
 * val vector = vectorOf(
 *     startX = 1.0,
 *     startY = 2.0,
 *     finishX = 2.0,
 *     finishY = 1.0,
 *     measure = measure,
 * )
 *
 *   ^
 *   |
 * 4 -       * vector.start
 *   |
 * 3 -
 *   |
 * 2 -   *           * vector.finish
 *   |
 * 1 -       *
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   x   4
 * ```
 * @return An instance of [Vector] built from the [Double] values and the [Measure].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.2
 */
fun vectorOf(
    startX: Double,
    startY: Double,
    finishX: Double,
    finishY: Double,
    measure: Measure<Double, Double>,
): Vector {
    return ImmutableVector(
        start = pointOf(x = measure.transform(startX), y = measure.transform(startY)),
        finish = pointOf(x = measure.transform(finishX), y = measure.transform(finishY)),
    )
}

/**
 * Usage:
 * ```
 * val measure = measureOf(magnitude = 2.0)
 * val vector = vectorOf(
 *     startX = 1.0,
 *     startY = 2.0,
 *     finish = pointOf(x = 2.0, y = 1.0),
 *     measure = measure,
 * )
 *
 *   ^
 *   |
 * 4 -       * vector.start
 *   |
 * 3 -
 *   |
 * 2 -   *           * vector.finish
 *   |
 * 1 -       *
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   x   4
 * ```
 * @return An instance of [Vector] built from the [Double] values, [Point] and the [Measure].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.2
 */
fun vectorOf(
    startX: Double,
    startY: Double,
    finish: Point,
    measure: Measure<Double, Double>,
): Vector {
    return ImmutableVector(
        start = pointOf(x = measure.transform(startX), y = measure.transform(startY)),
        finish = pointOf(x = measure.transform(finish.x), y = measure.transform(finish.y)),
    )
}

/**
 * Usage:
 * ```
 * val measure = measureOf(magnitude = 2.0)
 * val foo = pointOf(x = 1.0, y = 2.0)
 * val vector = foo.toVector(x = 2.0, y = 1.0, measure = measure)
 *
 *   ^
 *   |
 * 4 -       * vector.start
 *   |
 * 3 -
 *   |
 * 2 -   *           * vector.finish
 *   |
 * 1 -       *
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   x   4
 * ```
 * @receiver This [Point] will become the [Vector.start] point transformed by the [measure].
 * @param x This value will become the x-coordinate of the [Vector.finish] point transformed by the [measure]
 * @param y This value will become the y-coordinate of the [Vector.finish] point transformed by the [measure]
 * @param measure It will transform all original coordinates.
 * @return An instance of [Vector] built from the [Double] values, [Point] and the [Measure].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.2
 */
fun Point.toVector(
    x: Double,
    y: Double,
    measure: Measure<Double, Double>,
): Vector {
    return ImmutableVector(
        start = pointOf(x = measure.transform(this.x), y = measure.transform(this.y)),
        finish = pointOf(x = measure.transform(x), y = measure.transform(y)),
    )
}

/**
 * Usage:
 * ```
 * val measure = measureOf(magnitude = 2.0)
 * val foo = pointOf(x = 1.0, y = 2.0)
 * val bar = pointOf(x = 2.0, y = 1.0)
 * val vector = foo.toVector(finish = bar, measure = measure)
 *
 *   ^
 *   |
 * 4 -       * vector.start
 *   |
 * 3 -
 *   |
 * 2 -   *           * vector.finish
 *   |
 * 1 -       *
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   x   4
 * ```
 * @receiver This [Point] will become the [Vector.start] point transformed by the [measure].
 * @param finish This [Point] will become the [Vector.finish] point transformed by the [measure]
 * @param measure It will transform all original coordinates.
 * @return An instance of [Vector] built from [Point]s and the [Measure].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.2
 */
fun Point.toVector(
    finish: Point,
    measure: Measure<Double, Double>,
): Vector {
    return ImmutableVector(
        start = pointOf(x = measure.transform(this.x), y = measure.transform(this.y)),
        finish = pointOf(x = measure.transform(finish.x), y = measure.transform(finish.y)),
    )
}

/**
 * Usage:
 * ```
 * val measure = measureOf(magnitude = 2.0)
 * val v1 = pointOf(x = 1.0, y = 2.0) + pointOf(x = 2.0, y = 1.0)
 * val v2 = v1.map(measure = measure)
 *
 *   ^
 *   |        v2.start
 * 4 -       *
 *   |
 * 3 -
 *   |    v1.start    v2.finish
 * 2 -   *           *
 *   |        v1.finish
 * 1 -       *
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   x   4
 * ```
 * @return An instance of [Vector] built from [this] receiver [Vector] and the [Measure].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.2
 */
fun Vector.map(
    measure: Measure<Double, Double>,
): Vector {
    return ImmutableVector(
        start = pointOf(x = measure.transform(start.x), y = measure.transform(start.y)),
        finish = pointOf(x = measure.transform(finish.x), y = measure.transform(finish.y)),
    )
}
