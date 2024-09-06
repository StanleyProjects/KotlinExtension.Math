package sp.kx.math

/**
 * Usage:
 * ```
 * val ab = pointOf(x = 2, y = 3) + pointOf(x = 4, y = 3)
 * val c = pointOf(x = 1, y = 1)
 * val d = pointOf(x = 3, y = 1)
 * val isParallel = ab.isParallel(
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
 * val ab = pointOf(x = 2, y = 2) + pointOf(x = 4, y = 3)
 * val c = pointOf(x = 1, y = 1)
 * val d = pointOf(x = 3, y = 1)
 * val isParallel = ab.isParallel(
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
 * @return `true` if the segment described by [this] receiver is parallel to
 * the segment described by the points [c] and [d];
 * `false` otherwise.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.3
 */
fun Vector.isParallel(
    c: Point,
    d: Point,
): Boolean {
    return isParallel(
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
 * val ab = pointOf(x = 2, y = 3) + pointOf(x = 4, y = 3)
 * val cd = pointOf(x = 1, y = 1) + pointOf(x = 3, y = 1)
 * val isParallel = ab.isParallel(cd)
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
 * val ab = pointOf(x = 2, y = 2) + pointOf(x = 4, y = 3)
 * val cd = pointOf(x = 1, y = 1) + pointOf(x = 3, y = 1)
 * val isParallel = ab.isParallel(cd)
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
 * @return `true` if the segment described by [this] receiver is parallel to
 * the segment described by [other] vector;
 * `false` otherwise.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.3
 */
fun Vector.isParallel(other: Vector): Boolean {
    return isParallel(
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
 * val a = pointOf(x = 2, y = 3)
 * val b = pointOf(x = 4, y = 3)
 * val cd = pointOf(x = 1, y = 1) + pointOf(x = 3, y = 1)
 * val isParallel = isParallel(
 *     a = a,
 *     b = b,
 *     cd = cd,
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
 * val cd = pointOf(x = 1, y = 1) + pointOf(x = 3, y = 1)
 * val isParallel = isParallel(
 *     a = a,
 *     b = b,
 *     cd = cd,
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
 * the segment described by [cd] vector;
 * `false` otherwise.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.3
 */
fun isParallel(
    a: Point,
    b: Point,
    cd: Vector,
): Boolean {
    return isParallel(
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
