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
        val Empty: Offset = EmptyOffset

        /**
         * A special case of a [Offset] with reference values of exactly one division.
         *
         * Usage:
         * ```
         * val multiplier = 0.25
         * val offset = Offset.Reference * multiplier
         * ```
         * @since 0.8.1
         */
        val Reference: Offset = ReferenceOffset

        /**
         * A special case of a [Offset] with undefined values.
         *
         * Usage:
         * ```
         * var offset = Offset.Undefined
         * ...
         * if (condition) {
         *     offset = offsetOf(0.0, 1.0)
         * } else {
         *     offset = offsetOf(1.0, 0.0)
         * }
         * ```
         * @since 0.8.1
         */
        val Undefined: Offset = UndefinedOffset
    }
}
