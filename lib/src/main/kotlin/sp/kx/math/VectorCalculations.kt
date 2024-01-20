package sp.kx.math

/**
 * Usage:
 * ```
 * val target = pointOf(x = 2, y = 3)
 * val vector = pointOf(x = 1, y = 1) + pointOf(x = 3, y = 1)
 * val p = vector.getPerpendicular(
 *     target = target,
 * )
 * assertEquals(p.x, target.x)
 * assertEquals(p.y, vector.start.y)
 * assertEquals(p.y, vector.finish.y)
 * assertEquals(p.x, 2.0)
 * assertEquals(p.y, 1.0)
 *
 *   ^
 *   |        target
 * 3 -       *
 *   |       |
 * 2 -       |
 *   |    s  |    f
 * 1 -   *---*---*
 *   |
 * 0 *---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return The point of intersection of the perpendicular dropped the [target] point to [this] receiver.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.2
 */
fun Vector.getPerpendicular(target: Point): Point {
    return getPerpendicular(
        aX = target.x,
        aY = target.y,
        bX = start.x,
        bY = start.y,
        cX = finish.x,
        cY = finish.y,
    )
}

/**
 * The function calculates the shortest distance from point to segment.
 * It is up to the segment, and not the length of the perpendicular to the straight line!
 *
 * Usage:
 * ```
 * val target = pointOf(x = 2, y = 3)
 * val vector = pointOf(x = 1, y = 1) + pointOf(x = 3, y = 1)
 * val value = vector.getShortest(
 *     target = target,
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
 * @return The shortest distance from the [target] point to the segment described by [this] receiver.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.2
 */
fun Vector.getShortestDistance(target: Point): Double {
    return getShortestDistance(
        xStart = start.x,
        yStart = start.y,
        xFinish = finish.x,
        yFinish = finish.y,
        xTarget = target.x,
        yTarget = target.y,
    )
}

operator fun Vector.contains(target: Point): Boolean {
    return contains(
        xStart = start.x,
        yStart = start.y,
        xFinish = finish.x,
        yFinish = finish.y,
        xTarget = target.x,
        yTarget = target.y,
    )
}

fun Vector.isCollinear(target: Point): Boolean {
    return isCollinear(
        aX = start.x,
        aY = start.y,
        bX = finish.x,
        bY = finish.y,
        cX = target.x,
        cY = target.y,
    )
}
