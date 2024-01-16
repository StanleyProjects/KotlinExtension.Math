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
 *     dX = 1.0,
 *     dY = 1.0,
 *     measure = measure,
 * )
 * assertEquals(vector.start.x, 4.0)
 * assertEquals(vector.start.y, 6.0)
 * assertEquals(vector.finish.x, 6.0)
 * assertEquals(vector.finish.y, 4.0)
 *
 *   ^
 *   |
 * 6 -               * vector.start
 *   |
 * 5 -
 *   |
 * 4 -                       * vector.finish
 *   |
 * 3 -
 *   |
 * 2 -   *
 *   |
 * 1 -       *
 *   |
 * 0 +---|---|---|---|---|---|--->
 *   0   1   2   3   4   5   6
 * ```
 * @return An instance of [Vector] built from the [Double] coordinates, offsets ([dX], [dY]) and the [Measure].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.2
 */
@Suppress("LongParameterList")
fun vectorOf(
    startX: Double,
    startY: Double,
    finishX: Double,
    finishY: Double,
    dX: Double,
    dY: Double,
    measure: Measure<Double, Double>,
): Vector {
    return ImmutableVector(
        start = pointOf(x = measure.transform(startX + dX), y = measure.transform(startY + dY)),
        finish = pointOf(x = measure.transform(finishX + dX), y = measure.transform(finishY + dY)),
    )
}

/**
 * Usage:
 * ```
 * val measure = measureOf(magnitude = 2.0)
 * val offset = offsetOf(dX = 1.0, dY = 1.0)
 * val vector = vectorOf(
 *     startX = 1.0,
 *     startY = 2.0,
 *     finishX = 2.0,
 *     finishY = 1.0,
 *     offset = offset,
 *     measure = measure,
 * )
 * assertEquals(vector.start.x, 4.0)
 * assertEquals(vector.start.y, 6.0)
 * assertEquals(vector.finish.x, 6.0)
 * assertEquals(vector.finish.y, 4.0)
 *
 *   ^
 *   |
 * 6 -               * vector.start
 *   |
 * 5 -
 *   |
 * 4 -                       * vector.finish
 *   |
 * 3 -
 *   |
 * 2 -   *
 *   |
 * 1 -       *
 *   |
 * 0 +---|---|---|---|---|---|--->
 *   0   1   2   3   4   5   6
 * ```
 * @return An instance of [Vector] built from the [Double] coordinates, [Offset] and the [Measure].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.2
 */
@Suppress("LongParameterList")
fun vectorOf(
    startX: Double,
    startY: Double,
    finishX: Double,
    finishY: Double,
    offset: Offset,
    measure: Measure<Double, Double>,
): Vector {
    return vectorOf(
        startX = startX,
        startY = startY,
        finishX = finishX,
        finishY = finishY,
        dX = offset.dX,
        dY = offset.dY,
        measure = measure,
    )
}

/**
 * Usage:
 * ```
 * val measure = measureOf(magnitude = 2.0)
 * val foo = pointOf(x = 2.0, y = 1.0)
 * val offset = offsetOf(dX = 1.0, dY = 1.0)
 * val vector = vectorOf(
 *     startX = 1.0,
 *     startY = 2.0,
 *     finish = foo,
 *     offset = offset,
 *     measure = measure,
 * )
 * assertEquals(vector.start.x, 4.0)
 * assertEquals(vector.start.y, 6.0)
 * assertEquals(vector.finish.x, 6.0)
 * assertEquals(vector.finish.y, 4.0)
 *
 *   ^
 *   |                vector.start
 * 6 -               *
 *   |
 * 5 -
 *   |                        vector.finish
 * 4 -                       *
 *   |
 * 3 -
 *   |
 * 2 -   *
 *   |        foo
 * 1 -       *
 *   |
 * 0 +---|---|---|---|---|---|--->
 *   0   1   2   3   4   5   6
 * ```
 * @return An instance of [Vector] built from the [Double] values, [Point], [Offset] and the [Measure].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.2
 */
fun vectorOf(
    startX: Double,
    startY: Double,
    finish: Point,
    offset: Offset,
    measure: Measure<Double, Double>,
): Vector {
    return vectorOf(
        startX = startX,
        startY = startY,
        finishX = finish.x,
        finishY = finish.y,
        dX = offset.dX,
        dY = offset.dY,
        measure = measure,
    )
}

/**
 * Usage:
 * ```
 * val measure = measureOf(magnitude = 2.0)
 * val offset = offsetOf(dX = 1.0, dY = 1.0)
 * val foo = pointOf(x = 2.0, y = 1.0)
 * val bar = pointOf(x = 1.0, y = 2.0)
 * val vector = bar.toVector(finish = foo, offset = offset, measure = measure)
 * assertEquals(vector.start.x, 4.0)
 * assertEquals(vector.start.y, 6.0)
 * assertEquals(vector.finish.x, 6.0)
 * assertEquals(vector.finish.y, 4.0)
 *
 *   ^
 *   |                vector.start
 * 6 -               *
 *   |
 * 5 -
 *   |                        vector.finish
 * 4 -                       *
 *   |
 * 3 -
 *   |    bar
 * 2 -   *
 *   |        foo
 * 1 -       *
 *   |
 * 0 +---|---|---|---|---|---|--->
 *   0   1   2   3   4   5   6
 * ```
 * @receiver This [Point] will become the [Vector.start] point transformed by the [offset] and [measure].
 * @param finish This [Point] will become the [Vector.finish] point transformed by the [offset] and [measure]
 * @param offset It will transform all original coordinates.
 * @param measure It will transform all original coordinates.
 * @return An instance of [Vector] built from [Point]s, [Offset] and the [Measure].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.2
 */
fun Point.toVector(
    finish: Point,
    offset: Offset,
    measure: Measure<Double, Double>,
): Vector {
    return vectorOf(
        startX = x,
        startY = y,
        finishX = finish.x,
        finishY = finish.y,
        dX = offset.dX,
        dY = offset.dY,
        measure = measure,
    )
}
