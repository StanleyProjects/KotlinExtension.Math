package sp.kx.math

/**
 * Stores two values. Convenient for 2D calculations. For example, when you need to shift all points on the plane.
 *
 * Usage:
 * ```
 * val offset: Offset = ...
 * val foo = pointOf(x = 3.0, y = 2.0)
 * val bar = pointOf(x = foo.x + offset.dX, y = foo.y + offset.dY)
 *
 *   ^
 *   |
 * 3 -   -   * bar
 *   |       |
 * y -   -   -   * foo
 *   |
 * 1 -       |   |
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   x   4
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.3.0
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

    companion object {
        /**
         * A special case of a [Offset] with zeroes.
         *
         * Usage:
         * ```
         * val point = pointOf(1, 2)
         * assertEquals(point, point + Offset.Empty)
         * ```
         * @since 0.4.4
         */
        val Empty = offsetOf(dX = 0.0, dY = 0.0)
    }
}
