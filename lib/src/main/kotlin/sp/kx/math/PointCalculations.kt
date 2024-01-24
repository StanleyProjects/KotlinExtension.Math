package sp.kx.math

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
 * val value = getShortestDistance(
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

fun getIntersection(
    a: Point,
    b: Point,
    c: Point,
    d: Point,
): Point? {
    return getIntersection(
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
