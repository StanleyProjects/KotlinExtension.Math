package sp.kx.math

@Suppress("LongParameterList")
fun vectorOf(
    startX: Double,
    startY: Double,
    finishX: Double,
    finishY: Double,
    dX: Double,
    dY: Double,
): Vector {
    return ImmutableVector(
        start = pointOf(x = startX + dX, y = startY + dY),
        finish = pointOf(x = finishX + dX, y = finishY + dY),
    )
}

fun vectorOf(
    startX: Double,
    startY: Double,
    finishX: Double,
    finishY: Double,
    offset: Offset,
): Vector {
    return ImmutableVector(
        start = pointOf(x = startX + offset.dX, y = startY + offset.dY),
        finish = pointOf(x = finishX + offset.dX, y = finishY + offset.dY),
    )
}

fun vectorOf(
    startX: Double,
    startY: Double,
    finish: Point,
    dX: Double,
    dY: Double,
): Vector {
    return ImmutableVector(
        start = pointOf(x = startX + dX, y = startY + dY),
        finish = pointOf(x = finish.x + dX, y = finish.y + dY),
    )
}

fun vectorOf(
    startX: Double,
    startY: Double,
    finish: Point,
    offset: Offset,
): Vector {
    return ImmutableVector(
        start = pointOf(x = startX + offset.dX, y = startY + offset.dY),
        finish = finish + offset,
    )
}

/**
 * Usage:
 * ```
 * val offset = offsetOf(2.0, 0.0)
 * val vector = pointOf(1, 1).toVector(offset = offset)
 *
 *   ^
 *   |
 * 2 -
 *   |    a       b
 * 1 -   * - - - >
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @receiver This [Point] will become the [Vector.start] point.
 * @param offset This values will be added to [this] receiver's [Point.x] and [Point.y] coordinates.
 * @return An instance of [Vector] built from the [Point] passed to the method and the [Point] constructed using the [offset].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.3
 */
fun Point.toVector(offset: Offset): Vector {
    return ImmutableVector(
        start = this,
        finish = this + offset,
    )
}

/**
 * Usage:
 * ```
 * val foo = pointOf(0.0, 0.0)
 * val bar = pointOf(2.0, 0.0)
 * val offset = offsetOf(1.0, 1.0)
 * val vector = foo.toVector(finish = bar, offset = offset)
 *
 *   ^
 *   |
 * 2 -
 *   |    a       b
 * 1 -   * - - - >
 *   |
 * 0 x---|---x---|---|--->
 *   0   1   2   3   4
 * ```
 * @receiver This [Point] modified with an [offset] will become the [Vector.start] point.
 * @param finish This [Point] modified with an [offset] will become the [Vector.finish] point.
 * @param offset This values will be added to [this] receiver [Point] and [finish] point.
 * @return An instance of [Vector] built from [this] receiver [Point] and the [finish] point constructed using the [offset].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.3
 */
fun Point.toVector(finish: Point, offset: Offset): Vector {
    return ImmutableVector(
        start = this + offset,
        finish = finish + offset,
    )
}
