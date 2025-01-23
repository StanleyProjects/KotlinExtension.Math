package sp.kx.math

/**
 * Stores two values. Convenient for 2D calculations. For example, when you need to describe the size in width and height.
 *
 * Usage:
 * ```
 * val size: Size = ...
 * assertEquals(2.0, size.width)
 * assertEquals(1.0, size.height)
 * val foo = pointOf(1, 1)
 * val bar = pointOf(x = foo.x + size.width, y = foo.y + size.height)
 *
 *   ^
 *   |
 * 3 -
 *   |
 * 2 -            * bar
 *   |
 * 1 -   * foo
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
interface Size {
    /**
     * Width size. Horizontal size. Parallel to the x-axis.
     */
    val width: Double

    /**
     * Height size. Vertical size. Parallel to the y-axis.
     */
    val height: Double

    companion object {
        /**
         * A special case of a [Size] with zeroes.
         *
         * Usage:
         * ```
         * val foo = offsetOf(1.0, 2.0)
         * val bar = foo + Size.Empty
         * assertEquals(1.0, bar.dX)
         * assertEquals(2.0, bar.dY)
         * ```
         * @since 0.8.1
         */
        val Empty: Size = EmptySize

        /**
         * A special case of a [Size] with reference values of exactly one division.
         *
         * Usage:
         * ```
         * val multiplier = 0.25
         * val size = Size.Reference * multiplier
         * ```
         * @since 0.8.1
         */
        val Reference: Size = ReferenceSize

        /**
         * A special case of a [Size] with undefined values.
         *
         * Usage:
         * ```
         * var size = Size.Undefined
         * ...
         * if (condition) {
         *     size = sizeOf(0.0, 1.0)
         * } else {
         *     size = sizeOf(1.0, 0.0)
         * }
         * ```
         * @since 0.8.1
         */
        val Undefined: Size = UndefinedSize
    }
}
