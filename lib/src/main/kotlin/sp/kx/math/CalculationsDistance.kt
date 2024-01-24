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
 * Special case of [distanceOf] method.
 *
 * Usage:
 * ```
 * val x = 3.0
 * val y = 0.0
 * val distance = distanceOf(x = x, y = y)
 * assertEquals(distanceOf(aX = 0.0, aY = 0.0, bX = x, bY = y), distance)
 * assertEquals(3.0, distance)
 *
 *   ^
 *   |
 * 0 *---|---|---*---|--->
 *   0   1   2   3   4
 * ```
 * @return Distance between point with x-coordinate `0` and y-coordinate `0` and point with [x] and [y] coordinates.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
fun distanceOf(
    x: Double,
    y: Double,
): Double {
    return kotlin.math.hypot(x = x, y = y)
}
