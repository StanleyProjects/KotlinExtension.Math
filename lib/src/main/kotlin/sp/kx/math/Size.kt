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
}
