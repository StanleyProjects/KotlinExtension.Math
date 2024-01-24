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

/**
 * A line's steepness is measured by the absolute value of its slope.
 * The larger the value is, the steeper the line.
 * Given a slope, it is possible to determine the direction of the line that a slope describes based on its sign and value.
 *
 * Usage:
 * ```
 * val a = pointOf(x = 1, y = 1)
 * val value = getSlope(
 *     a = a,
 *     bX = 3.0,
 *     bY = 2.0,
 * )
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
 * val value = getSlope(
 *     a = a,
 *     bX = b.x,
 *     bY = b.y,
 * )
 * assertEquals(0.0, actual)
 * ```
 * ```
 * val a = pointOf(x = 1, y = 3)
 * val b = pointOf(x = 1, y = 0)
 * check(a.x == b.x)
 * check(a.y != b.y)
 * val value = getSlope(
 *     a = a,
 *     bX = b.x,
 *     bY = b.y,
 * )
 * assertTrue(value.isInfinite())
 * ```
 * ```
 * val a = pointOf(x = 1, y = 3)
 * val b = pointOf(x = 1, y = 3)
 * check(a == b)
 * val value = getSlope(
 *     a = a,
 *     bX = b.x,
 *     bY = b.y,
 * )
 * assertTrue(value.isNaN())
 * ```
 * @return A number that measures the steepness and direction of the segment described by point [a] and the coordinates [[bX], [bY]].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.3
 */
fun getSlope(
    a: Point,
    bX: Double,
    bY: Double,
): Double {
    return (bY - a.y) / (bX - a.x)
}

/**
 * A line's steepness is measured by the absolute value of its slope.
 * The larger the value is, the steeper the line.
 * Given a slope, it is possible to determine the direction of the line that a slope describes based on its sign and value.
 *
 * Usage:
 * ```
 * val b = pointOf(x = 3, y = 2)
 * val value = getSlope(
 *     aX = 1.0,
 *     aY = 1.0,
 *     b = b,
 * )
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
 * val value = getSlope(
 *     aX = a.x,
 *     aY = a.y,
 *     b = b,
 * )
 * assertEquals(0.0, actual)
 * ```
 * ```
 * val a = pointOf(x = 1, y = 3)
 * val b = pointOf(x = 1, y = 0)
 * check(a.x == b.x)
 * check(a.y != b.y)
 * val value = getSlope(
 *     aX = a.x,
 *     aY = a.y,
 *     b = b,
 * )
 * assertTrue(value.isInfinite())
 * ```
 * ```
 * val a = pointOf(x = 1, y = 3)
 * val b = pointOf(x = 1, y = 3)
 * check(a == b)
 * val value = getSlope(
 *     aX = a.x,
 *     aY = a.y,
 *     b = b,
 * )
 * assertTrue(value.isNaN())
 * ```
 * @return A number that measures the steepness and direction of the segment described by the coordinates [[aX], [aY]] and point [b].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.3
 */
fun getSlope(
    aX: Double,
    aY: Double,
    b: Point,
): Double {
    return (b.y - aY) / (b.x - aX)
}

/**
 * A line's steepness is measured by the absolute value of its slope.
 * The larger the value is, the steeper the line.
 * Given a slope, it is possible to determine the direction of the line that a slope describes based on its sign and value.
 *
 * Usage:
 * ```
 * val a = pointOf(x = 1, y = 1)
 * val b = pointOf(x = 3, y = 2)
 * val value = getSlope(a = a, b = b)
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
 * val value = getSlope(a = a, b = b)
 * assertEquals(0.0, actual)
 * ```
 * ```
 * val a = pointOf(x = 1, y = 3)
 * val b = pointOf(x = 1, y = 0)
 * check(a.x == b.x)
 * check(a.y != b.y)
 * val value = getSlope(a = a, b = b)
 * assertTrue(value.isInfinite())
 * ```
 * ```
 * val a = pointOf(x = 1, y = 3)
 * val b = pointOf(x = 1, y = 3)
 * check(a == b)
 * val value = getSlope(a = a, b = b)
 * assertTrue(value.isNaN())
 * ```
 * @return A number that measures the steepness and direction of the segment described by the points [a] and [b].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.3
 */
fun getSlope(
    a: Point,
    b: Point,
): Double {
    return (b.y - a.y) / (b.x - a.x)
}

/**
 * Usage:
 * ```
 * val vector = pointOf(x = 1, y = 1) + pointOf(x = 3, y = 1)
 * val target = pointOf(x = 2, y = 1)
 * val contains = contains(
 *     start = vector.start,
 *     finish = vector.finish,
 *     target = target,
 * )
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
 * @return `true` if the point [target] lies on the segment described by the points [start] and [finish];
 * `false` otherwise.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.3
 */
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

/**
 * Usage:
 * ```
 * val a = pointOf(x = 1, y = 1)
 * val b = pointOf(x = 2, y = 1)
 * val c = pointOf(x = 3, y = 1)
 * val isCollinear = isCollinear(
 *     a = a,
 *     b = b,
 *     c = c,
 * )
 * assertTrue(isCollinear)
 *
 *   ^
 *   |
 * 2 -
 *   |    a   b   c
 * 1 -   *---*---*
 *   |
 * 0 *---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 *
 * Or:
 * ```
 * val a = pointOf(x = 1, y = 1)
 * val b = pointOf(x = 2, y = 1)
 * val c = pointOf(x = 3, y = 2)
 * val isCollinear = isCollinear(
 *     a = a,
 *     b = b,
 *     c = c,
 * )
 * assertFalse(isCollinear)
 *
 *   ^
 *   |            c
 * 2 -           *
 *   |    a   b
 * 1 -   *   *
 *   |
 * 0 *---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return `true` if all three points ([a], [b] and [c]) lie on the same line;
 * `false` otherwise.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.3
 */
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

/**
 * Usage:
 * ```
 * val a = pointOf(x = 2, y = 3)
 * val b = pointOf(x = 4, y = 3)
 * val c = pointOf(x = 1, y = 1)
 * val d = pointOf(x = 3, y = 1)
 * val isParallel = isParallel(
 *     a = a,
 *     b = b,
 *     c = c,
 *     d = d,
 * )
 * assertTrue(isParallel)
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
 * Or:
 * ```
 * val a = pointOf(x = 2, y = 2)
 * val b = pointOf(x = 4, y = 3)
 * val c = pointOf(x = 1, y = 1)
 * val d = pointOf(x = 3, y = 1)
 * val isParallel = isParallel(
 *     a = a,
 *     b = b,
 *     c = c,
 *     d = d,
 * )
 * assertFalse(isParallel)
 *
 *   ^
 *   |                b
 * 3 -               *
 *   |        a
 * 2 -       *
 *   |    c       d
 * 1 -   *-------*
 *   |
 * 0 *---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return `true` if the segment described by the points [a] and [b] is parallel to
 * the segment described by the points [c] and [d];
 * `false` otherwise.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.3
 */
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

/**
 * Usage:
 * ```
 * val a = pointOf(x = 1, y = 2)
 * val b = pointOf(x = 3, y = 2)
 * val c = pointOf(x = 2, y = 3)
 * val d = pointOf(x = 2, y = 1)
 * val i = getIntersection(
 *     a = a,
 *     b = b,
 *     c = c,
 *     d = d,
 * )
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
 * val c = pointOf(x = 1, y = 1)
 * val d = pointOf(x = 3, y = 1)
 * val i = getIntersection(
 *     a = a,
 *     b = b,
 *     c = c,
 *     d = d,
 * )
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
 * val c = pointOf(x = 3, y = 1)
 * val d = pointOf(x = 4, y = 1)
 * val i = getIntersection(
 *     a = a,
 *     b = b,
 *     c = c,
 *     d = d,
 * )
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
 * @return [Point] that is the intersection of two lines described by the ([a] and [b]) and ([c] and [d]) points;
 * `null` if the lines are parallel;
 * `null` if the lines are collinear
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.3
 */
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
