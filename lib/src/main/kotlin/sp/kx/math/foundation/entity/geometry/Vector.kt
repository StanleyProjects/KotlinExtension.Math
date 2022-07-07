package sp.kx.math.foundation.entity.geometry

/**
 * Stores the values of two [Point]s.
 * Since the [start] and [finish] points are specified explicitly, for example,
 * you can calculate the angle of the resulting segment relative to the x-axis.
 *
 * ```
 *
 * vector = Vector(a, b)
 *
 *   Y
 *   |      b
 * 3 -       * <- finish
 *   |      /
 * 2 -     /
 *   |    /
 * 1 -   * <- start
 *   |    a
 * 0 +---|---|---> X
 *   0   1   2
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.1.0
 */
interface Vector {
    /**
     * Start of segment.
     */
    val start: Point

    /**
     * ```
     * End of segment.
     * ```
     */
    val finish: Point
}
