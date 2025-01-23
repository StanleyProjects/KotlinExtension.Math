package sp.kx.math

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
