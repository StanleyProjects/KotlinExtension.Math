package sp.kx.math.foundation.entity.geometry

/**
 * Stores two values. Can be used to store the coordinates of a point in 2D space.
 *
 * ```
 * a = Point(x = 2, y = 2)
 *
 *   Y
 *   |
 * 3 -
 *   |        a
 * 2 -       *
 *   |
 * 1 -
 *   |
 * 0 +---|---|---|---> X
 *   0   1   2   3
 * ```
 *
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.1.0
 */
interface Point {
    /**
     * The coordinate of the x-axis.
     */
    val x: Double
    /**
     * The coordinate of the y-axis.
     */
    val y: Double
}
