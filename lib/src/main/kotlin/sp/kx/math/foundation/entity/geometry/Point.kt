package sp.kx.math.foundation.entity.geometry

/**
 * Stores two values. Can be used to store the coordinates of a point in 2D space.
 * @see sp.kx.math.implementation.entity.geometry.toVector
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
