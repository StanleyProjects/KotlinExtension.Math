package sp.kx.math

/**
 * Stores two values. Can be used to store the coordinates of a point in 2D space.
 *
 * Usage:
 * ```
 * val point: Point = ...
 *
 *   ^
 *   |
 * 3 -
 *   |
 * y -   -   -   *
 *   |
 * 1 -           |
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   x   4
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.2.0
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

    companion object {
        /**
         * A special case of a point with coordinates in the center.
         * @since 0.8.0
         */
        val Center: Point = CenterPoint

        /**
         * A special case of a point with reference coordinates of exactly one division.
         * @since 0.8.0
         */
        val Reference: Point = ReferencePoint

        val Undefined: Point = UndefinedPoint
    }
}
