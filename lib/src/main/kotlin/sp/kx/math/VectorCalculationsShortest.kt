package sp.kx.math

/**
 * The function calculates the shortest distance from point to segment.
 * It is up to the segment, and not the length of the perpendicular to the straight line!
 *
 * Usage:
 * ```
 * val target = pointOf(x = 2, y = 3)
 * val vector = pointOf(x = 1, y = 1) + pointOf(x = 3, y = 1)
 * val value = vector.getShortestDistance(
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

/**
 * The function calculates the shortest distance from point to segment.
 * It is up to the segment, and not the length of the perpendicular to the straight line!
 *
 * Usage:
 * ```
 * val target = pointOf(x = 2, y = 3)
 * val vector = pointOf(x = 1, y = 1) + pointOf(x = 3, y = 1)
 * val value = vector.getShortestDistance(
 *     xTarget = target.x,
 *     yTarget = target.y,
 * )
 * assertEquals(2.0, value)
 * ```
 *
 * ```
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
 * @return The shortest distance from the coordinates [[xTarget], [yTarget]] to the segment described by [this] receiver.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.0
 */
fun Vector.getShortestDistance(
    xTarget: Double,
    yTarget: Double,
): Double {
    return getShortestDistance(
        xStart = start.x,
        yStart = start.y,
        xFinish = finish.x,
        yFinish = finish.y,
        xTarget = xTarget,
        yTarget = yTarget,
    )
}

/**
 * The function calculates the shortest [Point] from point to segment.
 * It is up to the segment, and not the [Point] of the perpendicular to the straight line!
 *
 * Usage:
 * ```
 * val vector = pointOf(x = 1, y = 1) + pointOf(x = 3, y = 1)
 * val target = pointOf(x = 2, y = 3)
 * val result = vector.getShortestPoint(target = target)
 * assertEquals(2.0, result.x)
 * assertEquals(1.0, result.y)
 *
 *   ^
 *   |        t
 * 3 -       *
 *   |
 * 2 -
 *   |    s   r   f
 * 1 -   *---*---*
 *   |
 * 0 *---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 *
 * Special cases:
 * ```
 * val vector = pointOf(x = 1, y = 1) + pointOf(x = 3, y = 1)
 * val target = pointOf(x = 4, y = 3)
 * val result = vector.getShortestPoint(target = target)
 * assertEquals(3.0, result.x)
 * assertEquals(1.0, result.y)
 * assertEquals(vector.finish, result)
 *
 *   ^
 *   |                t
 * 3 -               *
 *   |
 * 2 -
 *   |    s       f
 * 1 -   *-------*
 *   |
 * 0 *---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return The shortest [Point] from the point [target] to the segment described by [this] receiver.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.3
 */
fun Vector.getShortestPoint(target: Point): Point {
    return getShortestPoint(
        xStart = start.x,
        yStart = start.y,
        xFinish = finish.x,
        yFinish = finish.y,
        xTarget = target.x,
        yTarget = target.y,
    )
}

/**
 * The function calculates the shortest [Point] from point to segment.
 * It is up to the segment, and not the [Point] of the perpendicular to the straight line!
 *
 * Usage:
 * ```
 * val vector = pointOf(x = 1, y = 1) + pointOf(x = 3, y = 1)
 * val target = pointOf(x = 2, y = 3)
 * val result = vector.getShortestPoint(xTarget = target.x, yTarget = target.y)
 * assertEquals(2.0, result.x)
 * assertEquals(1.0, result.y)
 *
 *   ^
 *   |        t
 * 3 -       *
 *   |
 * 2 -
 *   |    s   r   f
 * 1 -   *---*---*
 *   |
 * 0 *---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 *
 * Special cases:
 * ```
 * val vector = pointOf(x = 1, y = 1) + pointOf(x = 3, y = 1)
 * val target = pointOf(x = 4, y = 3)
 * val result = vector.getShortestPoint(xTarget = target.x, yTarget = target.y)
 * assertEquals(3.0, result.x)
 * assertEquals(1.0, result.y)
 * assertEquals(vector.finish, result)
 *
 *   ^
 *   |                t
 * 3 -               *
 *   |
 * 2 -
 *   |    s       f
 * 1 -   *-------*
 *   |
 * 0 *---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return The shortest [Point] from the coordinates [[xTarget], [yTarget]] to the segment described by [this] receiver.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.3
 */
fun Vector.getShortestPoint(
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
