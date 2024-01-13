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
 * val angle = angleOf(a = pointOf(1, 1), bX = 3.0, bY = 3.0)
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
 * @return The angle in radians between the x-axis and the straight line containing point [a] and point `b` with [bX] and [bY] coordinates.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.4
 */
fun angleOf(
    a: Point,
    bX: Double,
    bY: Double,
): Double {
    return angleOf(
        aX = a.x,
        aY = a.y,
        bX = bX,
        bY = bY,
    )
}

/**
 * Usage:
 * ```
 * val angle = angleOf(aX = 1.0, aY = 1.0, b = pointOf(3, 3))
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
 * @return The angle in radians between the x-axis and the straight line containing point `a` with [aX] and [aY] coordinates and point [b].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.4
 */
fun angleOf(
    aX: Double,
    aY: Double,
    b: Point,
): Double {
    return angleOf(
        aX = aX,
        aY = aY,
        bX = b.x,
        bY = b.y,
    )
}

/**
 * Usage:
 * ```
 * val angle = angleOf(a = pointOf(1, 1), offset = offsetOf(2.0, 2.0))
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
 * @return The angle in radians between the x-axis and the straight line containing point [a] and point `b` with `a.x + offset.dX` and `a.y + offset.dY` coordinates.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.4
 */
fun angleOf(
    a: Point,
    offset: Offset,
): Double {
    return angleOf(
        a = a,
        b = a + offset,
    )
}

/**
 * Usage:
 * ```
 * val angle = angleOf(a = pointOf(0, 0), b = pointOf(2, 2), offset = offsetOf(1.0, 1.0))
 * assertEquals(PI / 4, angle)
 *
 *   ^
 *   |
 * 3 -           * b
 *   |         /
 * 2 -       x
 *   |     /
 * 1 -   * a
 *   |
 * 0 x---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return The angle in radians between the x-axis and the straight line containing
 * point `a` with `a.x + offset.dX` and `a.y + offset.dY` coordinates and
 * point `b` with `b.x + offset.dX` and `b.y + offset.dY` coordinates.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.4
 */
fun angleOf(
    a: Point,
    b: Point,
    offset: Offset,
): Double {
    return angleOf(
        a = a + offset,
        b = b + offset,
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

fun getPerpendicular(
    a: Point,
    b: Point,
    c: Point,
): Point {
    return getPerpendicular(
        aX = a.x,
        aY = a.y,
        bX = b.x,
        bY = b.y,
        cX = c.x,
        cY = c.y,
    )
}

fun getShortest(
    start: Point,
    finish: Point,
    target: Point,
): Double {
    return getShortest(
        xStart = start.x,
        yStart = start.y,
        xFinish = finish.x,
        yFinish = finish.y,
        xTarget = target.x,
        yTarget = target.y,
    )
}
