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

/**
 * Usage:
 * ```
 * val ab = pointOf(x = 1, y = 2) + pointOf(x = 3, y = 2)
 * val cd = pointOf(x = 2, y = 3) + pointOf(x = 2, y = 1)
 * val i = ab.getIntersection(cd)
 * assertNotNull(i)
 * assertEquals(2.0, i.x)
 * assertEquals(2.0, i.y)
 *
 *   ^
 *   |
 * 4 -
 *   |        c
 * 3 -       *
 *   |    a  |i   b
 * 2 -   *---*---*
 *   |       |d
 * 1 -       *
 *   |
 * 0 *---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 *
 * Special case:
 * ```
 * val ab = pointOf(x = 2, y = 3) + pointOf(x = 4, y = 3)
 * val cd = pointOf(x = 1, y = 1) + pointOf(x = 3, y = 1)
 * val i = ab.getIntersection(cd)
 * assertNull(i)
 *
 *   ^
 *   |        a       b
 * 3 -       *-------*
 *   |
 * 2 -
 *   |    c       d
 * 1 -   *-------*
 *   |
 * 0 *---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 *
 * Special case:
 * ```
 * val ab = pointOf(x = 1, y = 1) + pointOf(x = 2, y = 1)
 * val cd = pointOf(x = 3, y = 1) + pointOf(x = 4, y = 1)
 * val i = ab.getIntersection(cd)
 * assertNull(i)
 *
 *   ^
 *   |
 * 2 -
 *   |    a   b   c   d
 * 1 -   *---*   *---*
 *   |
 * 0 *---|---|---|---|---|--->
 *   0   1   2   3   4   5
 * ```
 * @return [Point] that is the intersection of two lines described by [this] receiver and the [other] vector;
 * `null` if the lines are parallel;
 * `null` if the lines are collinear
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.3
 */
fun Vector.getIntersection(other: Vector): Point? {
    return getIntersection(
        aX = start.x,
        aY = start.y,
        bX = finish.x,
        bY = finish.y,
        cX = other.start.x,
        cY = other.start.y,
        dX = other.finish.x,
        dY = other.finish.y,
    )
}

/**
 * Usage:
 * ```
 * val ab = pointOf(x = 1, y = 2) + pointOf(x = 3, y = 2)
 * val c = pointOf(x = 2, y = 3)
 * val d = pointOf(x = 2, y = 1)
 * val i = ab.getIntersection(c = c, d = d)
 * assertNotNull(i)
 * assertEquals(2.0, i.x)
 * assertEquals(2.0, i.y)
 *
 *   ^
 *   |
 * 4 -
 *   |        c
 * 3 -       *
 *   |    a  |i   b
 * 2 -   *---*---*
 *   |       |d
 * 1 -       *
 *   |
 * 0 *---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 *
 * Special case:
 * ```
 * val ab = pointOf(x = 2, y = 3) + pointOf(x = 4, y = 3)
 * val c = pointOf(x = 1, y = 1)
 * val d = pointOf(x = 3, y = 1)
 * val i = ab.getIntersection(c = c, d = d)
 * assertNull(i)
 *
 *   ^
 *   |        a       b
 * 3 -       *-------*
 *   |
 * 2 -
 *   |    c       d
 * 1 -   *-------*
 *   |
 * 0 *---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 *
 * Special case:
 * ```
 * val ab = pointOf(x = 1, y = 1) + pointOf(x = 2, y = 1)
 * val c = pointOf(x = 3, y = 1)
 * val d = pointOf(x = 4, y = 1)
 * val i = ab.getIntersection(c = c, d = d)
 * assertNull(i)
 *
 *   ^
 *   |
 * 2 -
 *   |    a   b   c   d
 * 1 -   *---*   *---*
 *   |
 * 0 *---|---|---|---|---|--->
 *   0   1   2   3   4   5
 * ```
 * @return [Point] that is the intersection of two lines described by [this] receiver and ([c] and [d]) points;
 * `null` if the lines are parallel;
 * `null` if the lines are collinear
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.3
 */
fun Vector.getIntersection(
    c: Point,
    d: Point,
): Point? {
    return getIntersection(
        aX = start.x,
        aY = start.y,
        bX = finish.x,
        bY = finish.y,
        cX = c.x,
        cY = c.y,
        dX = d.x,
        dY = d.y,
    )
}

/**
 * Usage:
 * ```
 * val a = pointOf(x = 1, y = 2)
 * val b = pointOf(x = 3, y = 2)
 * val cd = pointOf(x = 2, y = 3) + pointOf(x = 2, y = 1)
 * val i = getIntersection(a = a, b = b, cd = cd)
 * assertNotNull(i)
 * assertEquals(2.0, i.x)
 * assertEquals(2.0, i.y)
 *
 *   ^
 *   |
 * 4 -
 *   |        c
 * 3 -       *
 *   |    a  |i   b
 * 2 -   *---*---*
 *   |       |d
 * 1 -       *
 *   |
 * 0 *---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 *
 * Special case:
 * ```
 * val a = pointOf(x = 2, y = 3)
 * val b = pointOf(x = 4, y = 3)
 * val cd = pointOf(x = 1, y = 1) + pointOf(x = 3, y = 1)
 * val i = getIntersection(a = a, b = b, cd = cd)
 * assertNull(i)
 *
 *   ^
 *   |        a       b
 * 3 -       *-------*
 *   |
 * 2 -
 *   |    c       d
 * 1 -   *-------*
 *   |
 * 0 *---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 *
 * Special case:
 * ```
 * val a = pointOf(x = 1, y = 1)
 * val b = pointOf(x = 2, y = 1)
 * val cd = pointOf(x = 3, y = 1) + pointOf(x = 4, y = 1)
 * val i = getIntersection(a = a, b = b, cd = cd)
 * assertNull(i)
 *
 *   ^
 *   |
 * 2 -
 *   |    a   b   c   d
 * 1 -   *---*   *---*
 *   |
 * 0 *---|---|---|---|---|--->
 *   0   1   2   3   4   5
 * ```
 * @return [Point] that is the intersection of two lines described by the ([a] and [b]) points and [cd] vector;
 * `null` if the lines are parallel;
 * `null` if the lines are collinear
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.3
 */
fun getIntersection(
    a: Point,
    b: Point,
    cd: Vector,
): Point? {
    return getIntersection(
        aX = a.x,
        aY = a.y,
        bX = b.x,
        bY = b.y,
        cX = cd.start.x,
        cY = cd.start.y,
        dX = cd.finish.x,
        dY = cd.finish.y,
    )
}
