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
 * val distance = distanceOf(a = pointOf(1, 1), bX = 3.0, bY = 1.0)
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
 * @return Distance between point [a] and point by coordinates [[bX], [bY]].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.2
 */
fun distanceOf(
    a: Point,
    bX: Double,
    bY: Double,
): Double {
    return distanceOf(
        aX = a.x,
        aY = a.y,
        bX = bX,
        bY = bY,
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

/**
 * Usage:
 * ```
 * val a = pointOf(x = 2, y = 3)
 * val b = pointOf(x = 1, y = 1)
 * val c = pointOf(x = 3, y = 1)
 * val p = getPerpendicular(
 *     a = a,
 *     b = b,
 *     c = c,
 * )
 * assertEquals(p.x, a.x)
 * assertEquals(p.y, b.y)
 * assertEquals(p.y, c.y)
 * assertEquals(p.x, 2.0)
 * assertEquals(p.y, 1.0)
 *
 *   ^
 *   |        a
 * 3 -       *
 *   |       |
 * 2 -       |
 *   |    b  |    c
 * 1 -   *---*---*
 *   |
 * 0 *---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return The point of intersection of the perpendicular dropped the [a] point to the line described by the [b] and [c] points.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.2
 */
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

/**
 * The function calculates the shortest distance from point to segment.
 * It is up to the segment, and not the length of the perpendicular to the straight line!
 *
 * Usage:
 * ```
 * val a = pointOf(x = 2, y = 3)
 * val b = pointOf(x = 1, y = 1)
 * val c = pointOf(x = 3, y = 1)
 * val value = getShortest(
 *     start = b,
 *     finish = c,
 *     target = a,
 * )
 * assertEquals(2.0, value)
 *
 *   ^
 *   |        a
 * 3 -       *
 *   |
 * 2 -
 *   |    b       c
 * 1 -   *-------*
 *   |
 * 0 *---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return The shortest distance from the [target] point to the segment described by the [start] and [finish] points.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.2
 */
fun getShortestDistance(
    start: Point,
    finish: Point,
    target: Point,
): Double {
    return getShortestDistance(
        xStart = start.x,
        yStart = start.y,
        xFinish = finish.x,
        yFinish = finish.y,
        xTarget = target.x,
        yTarget = target.y,
    )
}

fun getShortestPoint(
    start: Point,
    xFinish: Double,
    yFinish: Double,
    xTarget: Double,
    yTarget: Double,
): Point {
    return getShortestPoint(
        xStart = start.x,
        yStart = start.y,
        xFinish = xFinish,
        yFinish = yFinish,
        xTarget = xTarget,
        yTarget = yTarget,
    )
}

fun getShortestPoint(
    start: Point,
    finish: Point,
    xTarget: Double,
    yTarget: Double,
): Point {
    return getShortestPoint(
        xStart = start.x,
        yStart = start.y,
        xFinish = finish.x,
        yFinish = finish.y,
        xTarget = xTarget,
        yTarget = yTarget,
    )
}

fun getShortestPoint(
    xStart: Double,
    yStart: Double,
    xFinish: Double,
    yFinish: Double,
    target: Point,
): Point {
    return getShortestPoint(
        xStart = xStart,
        yStart = yStart,
        xFinish = xFinish,
        yFinish = yFinish,
        xTarget = target.x,
        yTarget = target.y,
    )
}

fun getShortestPoint(
    start: Point,
    finish: Point,
    target: Point,
): Point {
    return getShortestPoint(
        xStart = start.x,
        yStart = start.y,
        xFinish = finish.x,
        yFinish = finish.y,
        xTarget = target.x,
        yTarget = target.y,
    )
}

fun getSlope(
    a: Point,
    bX: Double,
    bY: Double,
): Double {
    return (bY - a.y) / (bX - a.x)
}

fun getSlope(
    aX: Double,
    aY: Double,
    b: Point,
): Double {
    return (b.y - aY) / (b.x - aX)
}

fun getSlope(
    a: Point,
    b: Point,
): Double {
    return (b.y - a.y) / (b.x - a.x)
}

fun contains(
    start: Point,
    finish: Point,
    target: Point,
): Boolean {
    return contains(
        xStart = start.x,
        yStart = start.y,
        xFinish = finish.x,
        yFinish = finish.y,
        xTarget = target.x,
        yTarget = target.y,
    )
}

fun isCollinear(
    a: Point,
    b: Point,
    c: Point,
): Boolean {
    return isCollinear(
        aX = a.x,
        aY = a.y,
        bX = b.x,
        bY = b.y,
        cX = c.x,
        cY = c.y,
    )
}

fun isParallel(
    a: Point,
    b: Point,
    c: Point,
    d: Point,
): Boolean {
    return isParallel(
        aX = a.x,
        aY = a.y,
        bX = b.x,
        bY = b.y,
        cX = c.x,
        cY = c.y,
        dX = d.x,
        dY = d.y,
    )
}

// todo getIntersection(Point,Point,Point,Point)
