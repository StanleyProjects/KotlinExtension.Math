package sp.kx.math

/**
 * Usage:
 * ```
 * val offset = offsetOf(dX = 3.0, dY = 3.0)
 * val angle = angleOf(offset)
 * assertEquals(angleOf(aX = 0.0, aY = 0.0, bX = offset.dX, bY = offset.dY), angle)
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
 * containing point with x-coordinate `0` and y-coordinate `0` and point with [Offset.dX] and [Offset.dY] offset.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
fun angleOf(offset: Offset): Double {
    return angleOf(
        x = offset.dX,
        y = offset.dY,
    )
}

/**
 * Usage:
 * ```
 * val offset = offsetOf(dX = 3.0, dY = 0.0)
 * val distance = distanceOf(offset)
 * assertEquals(distanceOf(aX = 0.0, aY = 0.0, bX = offset.dX, bY = offset.dY), distance)
 * assertEquals(3.0, distance)
 *
 *   ^
 *   |
 * 0 *---|---|---*---|--->
 *   0   1   2   3   4
 * ```
 * @return Distance between point with x-coordinate `0` and y-coordinate `0` and point with [Offset.dX] and [Offset.dY] offset.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
fun distanceOf(offset: Offset): Double {
    return distanceOf(
        x = offset.dX,
        y = offset.dY,
    )
}
