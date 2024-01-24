package sp.kx.math

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

/**
 * Special case of [angleOf] method.
 *
 * Usage:
 * ```
 * val angle = angleOf(x = 3.0, y = 3.0)
 * assertEquals(angleOf(aX = 0.0, aY = 0.0, bX = 3.0, bY = 3.0), angle)
 * assertEquals(PI / 4, angle)
 *
 *   ^
 *   |
 * 3 -           *
 *   |         /
 * 2 -       /
 *   |     /
 * 1 -   /
 *   | /
 * 0 *---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return The angle in radians between the x-axis and the straight line
 * containing point with x-coordinate `0` and y-coordinate `0` and point with [x] and [y] coordinates.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
fun angleOf(
    x: Double,
    y: Double,
): Double {
    return kotlin.math.atan2(y = y, x = x)
}
