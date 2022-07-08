package sp.kx.math.foundation.entity.geometry

/**
 * Stores two values. Convenient for 2D calculations. For example, when you need to shift all points on the plane.
 *
 * ```
 * offset = Offset(dX = 2, dY = 0)
 * a` = (a.x + offset.dX, a.y + offset.dY)
 * b` = (b.x + offset.dX, b.y + offset.dY)
 *
 *   Y
 *   |        b       b`
 * 3 -       *       *
 *   |
 * 2 -
 *   |    a       a`
 * 1 -   *       *
 *   |
 * 0 +---|---|---|---|---> X
 *   0   1   2   3   4
 * ```
 *
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.1.0
 */
interface Offset {
    /**
     * Offset along the x-axis.
     */
    val dX: Double

    /**
     * Offset along the y-axis.
     */
    val dY: Double
}
