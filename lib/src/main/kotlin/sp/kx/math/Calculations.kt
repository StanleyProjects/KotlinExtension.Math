package sp.kx.math

/**
 * Usage:
 * ```
 * val distance = distanceOf(aX = 1.0, aY = 1.0, bX = 3.0, bY = 1.0)
 * assertEquals(2.0, distance)
 *
 *   ^
 *   |
 * 2 -
 *   |
 * y -   * - - - *
 *   |
 * 0 +---|---|---|---|--->
 *   0   aX  2   bX  4
 * ```
 * @return Distance between point `a` with [aX] and [aY] coordinates and point `b` with [bX] and [bY] coordinates.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.2
 */
fun distanceOf(
    aX: Double,
    aY: Double,
    bX: Double,
    bY: Double,
): Double {
    return kotlin.math.hypot(x = bX - aX, y = bY - aY)
}

/**
 * Usage:
 * ```
 * val angle = angleOf(aX = 1.0, aY = 1.0, bX = 3.0, bY = 3.0)
 * assertEquals(PI / 4, angle)
 *
 *   ^
 *   |
 * bY-           *
 *   |         /
 * 2 -       /
 *   |     /
 * aY-   *
 *   |
 * 0 +---|---|---|---|--->
 *   0   aX  2   bX  4
 * ```
 * @return The angle in radians between the x-axis and the straight line
 * containing point `a` with [aX] and [aY] coordinates and point `b` with [bX] and [bY] coordinates.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.2
 */
fun angleOf(
    aX: Double,
    aY: Double,
    bX: Double,
    bY: Double,
): Double {
    return kotlin.math.atan2(y = bY - aY, x = bX - aX)
}
