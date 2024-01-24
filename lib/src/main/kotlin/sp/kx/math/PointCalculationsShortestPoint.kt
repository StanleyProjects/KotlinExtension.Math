package sp.kx.math

/**
 * The function calculates the shortest [Point] from point to segment.
 * It is up to the segment, and not the [Point] of the perpendicular to the straight line!
 *
 * Usage:
 * ```
 * val vector = pointOf(x = 1, y = 1) + pointOf(x = 3, y = 1)
 * val target = pointOf(x = 2, y = 3)
 * val result = getShortestPoint(
 *     start = vector.start,
 *     xFinish = vector.finish.x,
 *     yFinish = vector.finish.y,
 *     xTarget = target.x,
 *     yTarget = target.y,
 * )
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
 * val result = getShortestPoint(
 *     start = vector.start,
 *     xFinish = vector.finish.x,
 *     yFinish = vector.finish.y,
 *     xTarget = target.x,
 *     yTarget = target.y,
 * )
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
 * @return The shortest [Point] from the coordinates [xTarget] and [yTarget] to the segment described by the point [start] and the coordinates [xFinish], [yFinish].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.3
 */
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

/**
 * The function calculates the shortest [Point] from point to segment.
 * It is up to the segment, and not the [Point] of the perpendicular to the straight line!
 *
 * Usage:
 * ```
 * val vector = pointOf(x = 1, y = 1) + pointOf(x = 3, y = 1)
 * val target = pointOf(x = 2, y = 3)
 * val result = getShortestPoint(
 *     start = vector.start,
 *     finish = vector.finish,
 *     xTarget = target.x,
 *     yTarget = target.y,
 * )
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
 * val result = getShortestPoint(
 *     start = vector.start,
 *     finish = vector.finish,
 *     xTarget = target.x,
 *     yTarget = target.y,
 * )
 * assertEquals(3.0, result.x)
 * assertEquals(1.0, result.y)
 * assertEquals(vector.finish, result)
 *
 *   ^
 *   |                a
 * 3 -               *
 *   |
 * 2 -
 *   |    b       c
 * 1 -   *-------*
 *   |
 * 0 *---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return The shortest [Point] from the coordinates [xTarget] and [yTarget] to the segment described by the points [start] and [finish].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.3
 */
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

/**
 * The function calculates the shortest [Point] from point to segment.
 * It is up to the segment, and not the [Point] of the perpendicular to the straight line!
 *
 * Usage:
 * ```
 * val vector = pointOf(x = 1, y = 1) + pointOf(x = 3, y = 1)
 * val target = pointOf(x = 2, y = 3)
 * val result = getShortestPoint(
 *     xStart = vector.start.x,
 *     yStart = vector.start.y,
 *     xFinish = vector.finish.x,
 *     yFinish = vector.finish.y,
 *     target = target,
 * )
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
 * val result = getShortestPoint(
 *     xStart = vector.start.x,
 *     yStart = vector.start.y,
 *     xFinish = vector.finish.x,
 *     yFinish = vector.finish.y,
 *     target = target,
 * )
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
 * @return The shortest [Point] from the point [target] to the segment described by the coordinates [xStart], [yStart] and [xFinish], [yFinish].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.3
 */
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

/**
 * The function calculates the shortest [Point] from point to segment.
 * It is up to the segment, and not the [Point] of the perpendicular to the straight line!
 *
 * Usage:
 * ```
 * val vector = pointOf(x = 1, y = 1) + pointOf(x = 3, y = 1)
 * val target = pointOf(x = 2, y = 3)
 * val result = getShortestPoint(
 *     start = vector.start,
 *     finish = vector.finish,
 *     target = target,
 * )
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
 * val result = getShortestPoint(
 *     start = vector.start,
 *     finish = vector.finish,
 *     target = target,
 * )
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
 * @return The shortest [Point] from the point [target] to the segment described by the points [start] and [finish].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.3
 */
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
