package sp.kx.math

/**
 * The function calculates whether the segment reaches the point.
 *
 * Usage:
 * ```
 * val target = pointOf(x = 2, y = 3)
 * val vector = pointOf(x = 1, y = 1) + pointOf(x = 3, y = 1)
 * val actual = vector.reaches(
 *     xTarget = target.x,
 *     yTarget = target.y,
 *     minDistance = 3.0,
 *     points = 16,
 * )
 * assertTrue(actual)
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
 * @return Is the shortest distance from the [Point] from the coordinates [[xTarget], [yTarget]]
 * to the segment described by [this] receiver less than the [minDistance].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.0
 */
fun Vector.reaches(
    xTarget: Double,
    yTarget: Double,
    minDistance: Double,
    points: Int,
): Boolean {
    return getShortestDistance(
        xStart = start.x,
        yStart = start.y,
        xFinish = finish.x,
        yFinish = finish.y,
        xTarget = xTarget,
        yTarget = yTarget,
    ).lt(other = minDistance, points = points)
}

/**
 * The function calculates whether the segment reaches the point.
 *
 * Usage:
 * ```
 * val target = pointOf(x = 2, y = 3)
 * val vector = pointOf(x = 1, y = 1) + pointOf(x = 3, y = 1)
 * val actual = vector.reaches(
 *     target = target,
 *     minDistance = 3.0,
 *     points = 16,
 * )
 * assertTrue(actual)
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
 * @return Is the shortest distance from the [target]
 * to the segment described by [this] receiver less than the [minDistance].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.0
 */
fun Vector.reaches(
    target: Point,
    minDistance: Double,
    points: Int,
): Boolean {
    return getShortestDistance(
        xStart = start.x,
        yStart = start.y,
        xFinish = finish.x,
        yFinish = finish.y,
        xTarget = target.x,
        yTarget = target.y,
    ).lt(other = minDistance, points = points)
}

// todo doc
fun Iterable<Vector>.reaches(
    xTarget: Double,
    yTarget: Double,
    minDistance: Double,
    points: Int,
): Boolean {
    return any { vector ->
        getShortestDistance(
            xStart = vector.start.x,
            yStart = vector.start.y,
            xFinish = vector.finish.x,
            yFinish = vector.finish.y,
            xTarget = xTarget,
            yTarget = yTarget,
        ).lt(
            other = minDistance,
            points = points,
        )
    }
}

// todo doc
fun Iterable<Vector>.reaches(
    target: Point,
    minDistance: Double,
    points: Int,
): Boolean {
    return any { vector ->
        getShortestDistance(
            xStart = vector.start.x,
            yStart = vector.start.y,
            xFinish = vector.finish.x,
            yFinish = vector.finish.y,
            xTarget = target.x,
            yTarget = target.y,
        ).lt(
            other = minDistance,
            points = points,
        )
    }
}
