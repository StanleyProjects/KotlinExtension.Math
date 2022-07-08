package sp.kx.math.implementation.entity.geometry

import sp.kx.math.foundation.entity.geometry.Offset
import sp.kx.math.foundation.entity.geometry.Point

/**
 * @return An instance of [Point] modified by the [Double] values [dX] and [dY].
 * ```
 * val a = pointOf(1, 2)
 * val dX = 2.0
 * val dY = 1.0
 * val b = a.updated(dX = dX, dY = dY)
 * assertEquals(b.x, a.x + dX)
 * assertEquals(b.y, a.y + dY)
 *
 *   Y
 *   |            b
 * 3 -           *
 *   |    a
 * 2 -   *
 *   |
 * 1 -
 *   |
 * 0 +---|---|---|---|---> X
 *   0   1   2   3   4
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.1.0
 */
fun Point.updated(
    dX: Double,
    dY: Double
): Point {
    return pointOf(
        x = x + dX,
        y = y + dY
    )
}

/**
 * @return An instance of [Point] modified by the [offset].
 * ```
 * val a = pointOf(1, 2)
 * val offset = offsetOf(2.0, 1.0)
 * val b = a.updated(offset)
 * assertEquals(b.x, a.x + offset.dX)
 * assertEquals(b.y, a.y + offset.dY)
 *
 *   Y
 *   |            b
 * 3 -           *
 *   |    a
 * 2 -   *
 *   |
 * 1 -
 *   |
 * 0 +---|---|---|---|---> X
 *   0   1   2   3   4
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.1.0
 */
fun Point.updated(offset: Offset): Point {
    return updated(dX = offset.dX, dY = offset.dY)
}

/**
 * @return An instance of [Point] moved by the [length] and [angle].
 * ```
 * val a = pointOf(1, 1)
 * val dX = xM - xN
 * val dY = yM - yN
 * val length = kotlin.math.sqrt(dX * dX + dY * dY)
 * val angle = kotlin.math.PI / 4
 * val b = a.updated(length = length, angle = angle)
 * assertEquals(b.x, a.x + dX)
 * assertEquals(b.y, a.y + dY)
 *
 *    Y
 *    |              b
 * yM -             *
 *    |           /
 *    |        /
 *    |    a/  (kotlin.math.PI / 4)
 * yN -   * - - - - - - - -
 *    |
 *    +---|---------|-----> X
 *       xN        xM
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.1.0
 */
fun Point.moved(
    length: Double,
    angle: Double
): Point {
    return updated(
        dX = length * kotlin.math.cos(angle),
        dY = length * kotlin.math.sin(angle),
    )
}

fun Point.getDifference(that: Point): Offset {
    return offsetOf(
        dX = x - that.x,
        dY = y - that.y
    )
}
