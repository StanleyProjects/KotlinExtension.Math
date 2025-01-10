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
 * Usage:
 * ```
 * val vector = pointOf(x = 1, y = 1) + pointOf(x = 3, y = 1)
 * val target = pointOf(x = 2, y = 1)
 * val contains = target in vector
 * assertTrue(contains)
 *
 *   ^
 *   |
 * 2 -
 *   |    s   t   f
 * 1 -   *---*---*
 *   |
 * 0 *---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return `true` if the point [target] lies on the segment described by [this] receiver;
 * `false` otherwise.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.3
 */
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

/**
 * Usage:
 * ```
 * val vector = pointOf(x = 1, y = 1) + pointOf(x = 2, y = 1)
 * val target = pointOf(x = 3, y = 1)
 * val isCollinear = vector.isCollinear(target = target)
 * assertTrue(isCollinear)
 *
 *   ^
 *   |
 * 2 -
 *   |    s   f   t
 * 1 -   *---*   *
 *   |
 * 0 *---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 *
 * Or:
 * ```
 * val vector = pointOf(x = 1, y = 1) + pointOf(x = 2, y = 1)
 * val target = pointOf(x = 3, y = 2)
 * val isCollinear = vector.isCollinear(target = target)
 * assertFalse(isCollinear)
 *
 *   ^
 *   |            t
 * 2 -           *
 *   |    s   f
 * 1 -   *---*
 *   |
 * 0 *---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return `true` if all three points ([a], [b] and [c]) lie on the same line;
 * `false` otherwise.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.3
 */
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

/**
 * A line's steepness is measured by the absolute value of its slope.
 * The larger the value is, the steeper the line.
 * Given a slope, it is possible to determine the direction of the line that a slope describes based on its sign and value.
 *
 * Usage:
 * ```
 * val vector = pointOf(x = 1, y = 1) + pointOf(x = 3, y = 2)
 * val value = getSlope(vector = vector)
 * assertEquals(0.5, value)
 *
 *   ^
 *   |            b
 * 2 -           *
 *   |    a
 * 1 -   *
 *   |
 * 0 *---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 *
 * Special cases:
 * ```
 * val a = pointOf(x = 1, y = 0)
 * val b = pointOf(x = 3, y = 0)
 * check(a.x != b.x)
 * check(a.y == b.y)
 * val value = getSlope(vector = a + b)
 * assertEquals(0.0, actual)
 * ```
 * ```
 * val a = pointOf(x = 1, y = 3)
 * val b = pointOf(x = 1, y = 0)
 * check(a.x == b.x)
 * check(a.y != b.y)
 * val value = getSlope(vector = a + b)
 * assertTrue(value.isInfinite())
 * ```
 * ```
 * val a = pointOf(x = 1, y = 3)
 * val b = pointOf(x = 1, y = 3)
 * check(a == b)
 * val value = getSlope(vector = a + b)
 * assertTrue(value.isNaN())
 * ```
 * @return A number that measures the steepness and direction of the segment described by the [vector].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.3
 */
fun getSlope(vector: Vector): Double {
    return (vector.finish.y - vector.start.y) / (vector.finish.x - vector.start.x)
}

fun Vector.lt(
    xTarget: Double,
    yTarget: Double,
    minDistance: Double,
    points: Int,
): Boolean {
    return getShortestDistance(
        xTarget = xTarget,
        yTarget = yTarget,
    ).lt(other = minDistance, points = points)
}

fun Vector.lt(
    target: Point,
    minDistance: Double,
    points: Int,
): Boolean {
    return getShortestDistance(target = target).lt(other = minDistance, points = points)
}

fun Iterable<Vector>.lt(
    xTarget: Double,
    yTarget: Double,
    minDistance: Double,
    points: Int,
): Boolean {
    for (vector in this) {
        val less = vector.getShortestDistance(
            xTarget = xTarget,
            yTarget = yTarget,
        ).lt(
            other = minDistance,
            points = points,
        )
        if (less) return true
    }
    return false
}

fun Iterable<Vector>.lt(
    target: Point,
    minDistance: Double,
    points: Int,
): Boolean {
    for (vector in this) {
        val less = vector.getShortestDistance(
            target = target,
        ).lt(
            other = minDistance,
            points = points,
        )
        if (less) return true
    }
    return false
}
