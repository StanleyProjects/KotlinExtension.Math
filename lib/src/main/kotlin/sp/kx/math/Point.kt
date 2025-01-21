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
         *
         * Usage:
         * ```
         * val offset = offsetOf(dX = 1, dY = 0)
         * val point = Point.Center + offset
         * ```
         * @since 0.8.0
         */
        val Center: Point = CenterPoint

        /**
         * A special case of a point with reference coordinates of exactly one division.
         *
         * Usage:
         * ```
         * val multiplier = 0.25
         * val point = Point.Reference * multiplier
         * ```
         * @since 0.8.0
         */
        val Reference: Point = ReferencePoint

        /**
         * A special case of a point with undefined coordinates.
         *
         * Usage:
         * ```
         * var point = Point.Undefined
         * ...
         * if (condition) {
         *     point = pointOf(x = 1, y = 0)
         * } else {
         *     point = pointOf(x = 0, y = 1)
         * }
         * ```
         * @since 0.8.0
         */
        val Undefined: Point = UndefinedPoint
    }
}
