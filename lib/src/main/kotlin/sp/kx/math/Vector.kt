package sp.kx.math

/**
 * Can be used to store the coordinates of two [Point]s in 2D space.
 *
 * Usage:
 * ```
 * val vector: Vector = ...
 *
 *   ^
 *   |
 * y -   -   -   * vector.finish
 *   |
 * 2 -   * vector.start
 *   |
 * 1 -   |       |
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   x   4
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.0
 */
interface Vector {
    /**
     * The [Point] from which the beginning of the [Vector] can be counted.
     */
    val start: Point

    /**
     * The [Point] up to which the direction of the [Vector] can be computed.
     */
    val finish: Point
}
