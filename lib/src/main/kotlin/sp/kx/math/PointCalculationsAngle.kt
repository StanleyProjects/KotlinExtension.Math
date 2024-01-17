package sp.kx.math

/**
 * Usage:
 * ```
 * val angle = angleOf(a = pointOf(1, 1), b = pointOf(3, 3))
 * assertEquals(PI / 4, angle)
 *
 *   ^
 *   |
 * 3 -           * b
 *   |         /
 * 2 -       /
 *   |     /
 * 1 -   * a
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return The angle in radians between the x-axis and the straight line containing point [a] and point [b].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.2
 */
fun angleOf(
    a: Point,
    b: Point,
): Double {
    return angleOf(
        aX = a.x,
        aY = a.y,
        bX = b.x,
        bY = b.y,
    )
}

/**
 * Usage:
 * ```
 * val angle = angleOf(a = pointOf(1, 1), bX = 3.0, bY = 3.0)
 * assertEquals(PI / 4, angle)
 *
 *   ^
 *   |
 * 3 -           * b
 *   |         /
 * 2 -       /
 *   |     /
 * 1 -   * a
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return The angle in radians between the x-axis and the straight line containing point [a] and point `b` with [bX] and [bY] coordinates.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.4
 */
fun angleOf(
    a: Point,
    bX: Double,
    bY: Double,
): Double {
    return angleOf(
        aX = a.x,
        aY = a.y,
        bX = bX,
        bY = bY,
    )
}

/**
 * Usage:
 * ```
 * val angle = angleOf(aX = 1.0, aY = 1.0, b = pointOf(3, 3))
 * assertEquals(PI / 4, angle)
 *
 *   ^
 *   |
 * 3 -           * b
 *   |         /
 * 2 -       /
 *   |     /
 * 1 -   * a
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return The angle in radians between the x-axis and the straight line containing point `a` with [aX] and [aY] coordinates and point [b].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.4
 */
fun angleOf(
    aX: Double,
    aY: Double,
    b: Point,
): Double {
    return angleOf(
        aX = aX,
        aY = aY,
        bX = b.x,
        bY = b.y,
    )
}

/**
 * Usage:
 * ```
 * val angle = angleOf(a = pointOf(1, 1), offset = offsetOf(2.0, 2.0))
 * assertEquals(PI / 4, angle)
 *
 *   ^
 *   |
 * 3 -           * b
 *   |         /
 * 2 -       /
 *   |     /
 * 1 -   * a
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return The angle in radians between the x-axis and the straight line containing point [a] and point `b` with `a.x + offset.dX` and `a.y + offset.dY` coordinates.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.4
 */
fun angleOf(
    a: Point,
    offset: Offset,
): Double {
    return angleOf(
        a = a,
        b = a + offset,
    )
}

/**
 * Usage:
 * ```
 * val angle = angleOf(a = pointOf(0, 0), b = pointOf(2, 2), offset = offsetOf(1.0, 1.0))
 * assertEquals(PI / 4, angle)
 *
 *   ^
 *   |
 * 3 -           * b
 *   |         /
 * 2 -       x
 *   |     /
 * 1 -   * a
 *   |
 * 0 x---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return The angle in radians between the x-axis and the straight line containing
 * point `a` with `a.x + offset.dX` and `a.y + offset.dY` coordinates and
 * point `b` with `b.x + offset.dX` and `b.y + offset.dY` coordinates.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.4
 */
fun angleOf(
    a: Point,
    b: Point,
    offset: Offset,
): Double {
    return angleOf(
        a = a + offset,
        b = b + offset,
    )
}