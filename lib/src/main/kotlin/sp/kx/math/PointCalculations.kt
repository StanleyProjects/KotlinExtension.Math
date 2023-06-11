package sp.kx.math

/**
 * Usage:
 * ```
 * val distance = distanceOf(a = pointOf(1, 1), b = pointOf(3, 1))
 * assertEquals(2.0, distance)
 *
 *   ^
 *   |
 * 2 -
 *   |    a       b
 * 1 -   * - - - *
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return Distance between point [a] and point [b].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.2
 */
fun distanceOf(
    a: Point,
    b: Point,
): Double {
    return distanceOf(
        aX = a.x,
        aY = a.y,
        bX = b.x,
        bY = b.y,
    )
}

/**
 * Usage:
 * ```
 * val angle = angleOf(a = pointOf(1, 1), b = pointOf(3, 3))
 * assertEquals(PI / 4, angle)
 *
 *   ^
 *   |
 * 3 -           * b
 *   |         /
 * 2 -       /
 *   |     /
 * 1 -   * a
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return The angle in radians between the x-axis and the straight line containing point [a] and point [b].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.2
 */
fun angleOf(
    a: Point,
    b: Point,
): Double {
    return angleOf(
        aX = a.x,
        aY = a.y,
        bX = b.x,
        bY = b.y,
    )
}

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
