package sp.kx.math

/**
 * Usage:
 * ```
 * val distance = distanceOf(a = pointOf(1, 1), b = pointOf(3, 1))
 * assertEquals(2.0, distance)
 *
 *   ^
 *   |
 * 2 -
 *   |    a       b
 * 1 -   * - - - *
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return Distance between point [a] and point [b].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.2
 */
fun distanceOf(
    a: Point,
    b: Point,
): Double {
    return distanceOf(
        aX = a.x,
        aY = a.y,
        bX = b.x,
        bY = b.y,
    )
}

/**
 * Usage:
 * ```
 * val distance = distanceOf(a = pointOf(1, 1), bX = 3.0, bY = 1.0)
 * assertEquals(2.0, distance)
 *
 *   ^
 *   |
 * 2 -
 *   |    a       b
 * 1 -   * - - - *
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return Distance between point [a] and point by coordinates [[bX], [bY]].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.2
 */
fun distanceOf(
    a: Point,
    bX: Double,
    bY: Double,
): Double {
    return distanceOf(
        aX = a.x,
        aY = a.y,
        bX = bX,
        bY = bY,
    )
}
