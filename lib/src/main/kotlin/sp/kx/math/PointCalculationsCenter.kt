package sp.kx.math

/**
 * Usage:
 * ```
 * val point = centerOf(aX = 1.0, aY = 1.0, bX = 3.0, bY = 1.0)
 * assertEquals(2.0, point.x)
 * assertEquals(1.0, point.y)
 *
 *   ^
 *   |
 * 2 -
 *   |
 * y -   * - x - *
 *   |
 * 0 +---|---|---|---|--->
 *   0   aX  2   bX  4
 * ```
 * @return A [Point] that is the center of the segment
 * between point `a` with [aX] and [aY] coordinates and point `b` with [bX] and [bY] coordinates.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.2
 */
@Suppress("MagicNumber")
fun centerOf(
    aX: Double,
    aY: Double,
    bX: Double,
    bY: Double,
): Point {
    return pointOf(
        x = aX + (bX - aX) * 0.5,
        y = aY + (bY - aY) * 0.5,
    )
}

/**
 * Usage:
 * ```
 * val x = 2.0
 * val y = 2.0
 * val point = centerOf(x = x, y = y)
 * assertEquals(centerOf(aX = 0.0, aY = 0.0, bX = x, bY = y), point)
 * assertEquals(1.0, point.x)
 * assertEquals(1.0, point.y)
 *
 *   ^
 *   |
 * 2 -       *
 *   |     /
 * 1 -   x
 *   | /
 * 0 *---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return A [Point] that is the center of the segment
 * between point with x-coordinate `0` and y-coordinate `0` and point with [x] and [y] coordinates.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
@Suppress("MagicNumber")
fun centerOf(
    x: Double,
    y: Double,
): Point {
    return pointOf(
        x = x * 0.5,
        y = y * 0.5,
    )
}

/**
 * Usage:
 * ```
 * val offset = offsetOf(dX = 2.0, dY = 2.0)
 * val point = centerOf(offset)
 * assertEquals(centerOf(aX = 0.0, aY = 0.0, bX = offset.dX, bY = offset.dY), point)
 * assertEquals(1.0, point.x)
 * assertEquals(1.0, point.y)
 *
 *   ^
 *   |
 * 2 -       *
 *   |     /
 * 1 -   x
 *   | /
 * 0 *---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return A [Point] that is the center of the segment
 * between point with x-coordinate `0` and y-coordinate `0` and point with [Offset.dX] and [Offset.dY] offset.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
@Suppress("MagicNumber")
fun centerOf(offset: Offset): Point {
    return pointOf(
        x = offset.dX * 0.5,
        y = offset.dY * 0.5,
    )
}

/**
 * Usage:
 * ```
 * val point = centerOf(a = pointOf(1, 1), b = pointOf(3, 1))
 * assertEquals(2.0, point.x)
 * assertEquals(1.0, point.y)
 *
 *   ^
 *   |
 * 2 -
 *   |    a       b
 * 1 -   * - x - *
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return A [Point] that is the center of the segment between point [a] and point [b].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.2
 */
fun centerOf(
    a: Point,
    b: Point,
): Point {
    return centerOf(
        aX = a.x,
        aY = a.y,
        bX = b.x,
        bY = b.y,
    )
}